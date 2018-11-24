var grupoModule = angular.module("grupoModule");
//El controlador quedará asociado al modulo

grupoModule.controller('listarGrupoCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        //Almacenar arreglo de tipos que retorna el servicio GET
        $scope.grupo = {};

        $scope.tipos = new Array();

        // metodo necesario para que se recargue correctamente la pagina, el $state no esta sirviendo por que recarga y no espera que se termine la ejecucion de la accion
        reload = function () {
            $http.get('api/grupos').then(function (response) {
                console.log(response);
                $scope.tipos = response.data;
            }, function (error) {
                console.log(error);
            });
        };

        reload();

        $scope.actualizarCrear = function (id, nombreGrupo, tipoModal) {
            $scope.valorNombre = nombreGrupo;
            $scope.valorId = id;
            $scope.tipoModal = tipoModal;
        };

        $scope.crearGrupo = function () {
            if ($scope.grupo.nombreGrupo) {
                $scope.grupo.id = $scope.valorId;
                $http.post('api/grupos/', JSON.stringify($scope.grupo)).then(function (response) {
                    $scope.grupo = {};
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

        $scope.guardarGrupo = function () {
            if ($scope.grupo.nombreGrupo && $scope.valorId) {
                $scope.grupo.id = $scope.valorId;

                $http.put('api/grupos/' + $scope.valorId, JSON.stringify($scope.grupo)).then(function (response) {
                    $scope.grupo = {};
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

        $scope.eliminarGrupo = function () {
            $http.delete('api/grupos/' + $scope.idEliminar).then(function (response) {
                $scope.cerrarModal();

                //Recargar la pag
                reload();
            }, function (error) {
                console.log(error);
            });
        };
    }]);