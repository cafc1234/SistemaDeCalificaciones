var inscripcionModule = angular.module("inscripcionModule");
//El controlador quedará asociado al modulo

inscripcionModule.controller('inscripcionCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {



        // metodo necesario para que se recargue correctamente la pagina, el $state no esta sirviendo por que recarga y no espera que se termine la ejecucion de la accion
        reload = function () {

            $scope.cursos = new Array();
            ;
            $scope.inscritos = {};
            $scope.cantidadInscritas = 0;
            $scope.inscritosCompletos = new Array();

            $http.get('api/inscritos').then(function (response) {
                $scope.inscritosCompletos = response.data;
                $scope.mostrarInscritos(response.data);
            }, function (error) {
                console.log(error);
            });

            $http.get('api/cursos').then(function (response) {
                $scope.cursos = response.data;
            }, function (error) {
                console.log(error);
            });
        };

        reload();

        $scope.actualizarCrear = function (id,tipoModal) {
            
            $scope.valorId = id;
            $scope.tipoModal = tipoModal;
        };
        
        $scope.inscribirGrupo=function(){
            $scope.obtenerCurso();
            $scope.obtenerPersona();
        };


        $scope.mostrarInscritos = function (data) {
            for (var i = 0; i < data.length; i++) {
                if (data[i].estudiante.id == Cookies.get('idCuenta')) {
                    $scope.inscritos[i] = data[i];
                    $scope.cantidadInscritas++;
                }
            }
        }


    }]);