var tipoCursoModule = angular.module("tipoCrusoModule");
//El controlador quedará asociado al modulo

tipoCursoModule.controller('listarTipoCursoCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        //Almacenar arreglo de tipos que retorna el servicio GET
        $scope.tipoCurso = {};

        $scope.tipos = new Array();

        // metodo necesario para que se recargue correctamente la pagina, 
        // el $state no esta sirviendo por que recarga y no espera que se termine la ejecucion de la accion
        reload = function () {
            $http.get('api/tipoCurso').then(function (response) {
                console.log(response);
                $scope.tipos = response.data;
            }, function (error) {
                console.log(error);
            });
        };

        reload();

        $scope.actualizarCrear = function (id, nombreTipo, tipoModal) {
            $scope.valorNombre = nombreTipo;
            $scope.valorId = id;
            $scope.tipoModal = tipoModal;
        };

        $scope.crearTipoCurso = function () {
            if ($scope.tipoCurso.nombreTipo) {
                $scope.tipoCurso.id = $scope.valorId;
                $http.post('api/tipoCurso/', JSON.stringify($scope.tipoCurso)).then(function (response) {
                    $scope.tipoCurso = {};
                    // se llama el metodo de cierre del modal
                    $scope.cerrarModal();
                    //se recarga la pagina, con el metodo creado que vuelve a llamar el get de los datos
                    reload();
                }, function (error) {
                    console.log(error);
                });
            };
        };

        // Se corrige el metodo para cerrar el modal
        $scope.cerrarModal = function () {
            $("#modalActualizar").modal("hide");

        };

        $scope.guardarTipoCurso = function () {
            if ($scope.tipoCurso.nombreTipo && $scope.valorId) {
                $scope.tipoCurso.id = $scope.valorId;

                $http.put('api/tipoCurso/' + $scope.valorId, JSON.stringify($scope.tipoCurso)).then(function (response) {
                    $scope.tipoCurso = {};
                    // se llama el metodo de cierre del modal
                    $scope.cerrarModal();
                    //se recarga la pagina, con el metodo creado que vuelve a llamar el get de los datos
                    reload();
                }, function (error) {
                    console.log(error);
                });
            }
            ;
        };


        $scope.eliminar = function (id) {
            $http.delete('api/tipoCurso/' + id).then(function (response) {
                //Recargar la pag
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };
    }]);