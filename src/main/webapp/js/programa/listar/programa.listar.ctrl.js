var programaModule = angular.module("programaModule");
//El controlador quedará asociado al modulo

programaModule.controller('listarProgramaCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        //Almacenar arreglo de programas que retorna el servicio GET
        $scope.programa = {};

        $scope.programas = new Array();

        // metodo necesario para que se recargue correctamente la pagina, el $state no esta sirviendo por que recarga y no espera que se termine la ejecucion de la accion
        reload = function () {
            $http.get('api/programas').then(function (response) {
                console.log(response);
                $scope.programas = response.data;
            }, function (error) {
                console.log(error);
            });
        };

        reload();

        $scope.actualizarCrear = function (id, nombrePrograma, tipoModal) {
            $scope.valorNombre = nombrePrograma;
            $scope.valorId = id;
            $scope.tipoModal = tipoModal;
        };

        $scope.crearPrograma = function () {
            if ($scope.programa.nombrePrograma) {
                $scope.programa.id = $scope.valorId;
                $http.post('api/programas/', JSON.stringify($scope.programa)).then(function (response) {
                    $scope.programa = {};
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

        // Se corrige el metodo para cerrar el modal
        $scope.cerrarModal = function () {
            $("#modalActualizar").modal("hide");
            $("#modalConfirmar").modal("hide");
        };

        $scope.guardarPrograma = function () {
            if ($scope.programa.nombrePrograma && $scope.valorId) {
                $scope.programa.id = $scope.valorId;

                $http.put('api/programas/' + $scope.valorId, JSON.stringify($scope.programa)).then(function (response) {
                    $scope.programa = {};
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
            $scope.idEliminar = id;
            $("#modalConfirmar").modal("show");

        };

        $scope.eliminarPrograma = function () {
            $http.delete('api/programas/' + $scope.idEliminar).then(function (response) {
                $scope.cerrarModal();

                //Recargar la pag
                reload();
            }, function (error) {
                console.log(error);
            });
        };
    }]);