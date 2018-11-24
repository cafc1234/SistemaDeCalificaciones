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

        $scope.actualizarCrear = function (id, tipoModal) {

            $scope.valorId = id;
            $scope.tipoModal = tipoModal;
        };

        $scope.inscribirGrupo = function () {
            $scope.obtenerCurso();
            $scope.obtenerPersona();
        };

        $scope.obtenerCurso = function () {
            $http.get('api/cursos/' + $scope.inscrito.grupo.id).then(function (response) {
                $scope.inscrito.grupo = response.data;
            }, function (error) {
                console.log(error);
            });

        };
        $scope.obtenerPersona = function () {
            $http.get('api/personas/' + Cookies.get('idCuenta')).then(function (response) {
                $scope.inscrito.estudiante = response.data;
                $scope.inscribir();
            }, function (error) {
                console.log(error);
            });
        };

        $scope.inscribir = function () {
            if ($scope.cantidadInscritas < 6) {
                if ($scope.inscrito.estudiante && $scope.inscrito.grupo) {
                    $http.post('api/inscritos/', JSON.stringify($scope.inscrito)).then(function (response) {
                        $scope.inscrito = {};
                        $("#errorInscritas").html("");
                        // se llama el metodo de cierre del modal
                        $scope.cerrarModal();
                        //se recarga la pagina, con el metodo creado que vuelve a llamar el get de los datos
                        reload();
                    }, function (error) {
                        console.log(error);
                    });
                }
            } else {
                $("#errorInscritas").html("<div class='alert alert-danger'>No se pueden inscribir más de 6 materias</div>");
                $scope.cerrarModal();

            }

        };

        $scope.cerrarModal = function () {
            $("#modalActualizar").modal("hide");
            $("#modalConfirmar").modal("hide");

        };
        $scope.mostrarInscritos = function (data) {
            for (var i = 0; i < data.length; i++) {
                if (data[i].estudiante.id == Cookies.get('idCuenta')) {
                    $scope.inscritos[i] = data[i];
                    $scope.cantidadInscritas++;
                }
            }
        }

        $scope.eliminar = function (id) {
            $scope.idEliminar = id;
            $("#modalConfirmar").modal("show");

        };

        $scope.eliminarInscripcion = function () {
            $http.delete('api/inscritos/' + $scope.idEliminar).then(function (response) {
                // se llama el metodo de cierre del modal
                $scope.cerrarModal();

                reload();
            }, function (error) {
                console.log(error);
            });

        };
    }]);