var tipoNivelModule = angular.module("tipoNivelModule");
//El controlador quedará asociado al modulo

tipoNivelModule.controller('listarTiposNivelCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        //Almacenar arreglo de tipos que retorna el servicio GET
        $scope.tipoNivel = {};

        $scope.tipos = new Array();

        // metodo necesario para que se recargue correctamente la pagina, el $state no esta sirviendo por que recarga y no espera que se termine la ejecucion de la accion
        reload = function () {
            $http.get('api/tiposNivel').then(function (response) {
                console.log(response);
                $scope.tipos = response.data;
            }, function (error) {
                console.log(error);
            });
        };

        reload();

        $scope.actualizarCrear = function (id, nombreNivel, tipoModal) {
            $scope.valorId = id;
            $scope.tipoModal = tipoModal;
            
            if(id!=0){
            $http.get('api/tiposNivel/'+id).then(function (response) {
               
                $scope.tipoNivel = response.data;
            }, function (error) {
                console.log(error);
            });                
            }
        };

        $scope.crearTipoNivel = function () {
            if ($scope.tipoNivel.nombreNivel) {
                $http.post('api/tiposNivel/', JSON.stringify($scope.tipoNivel)).then(function (response) {
                    $scope.tipoNivel = {};
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

        $scope.guardarTipoNivel = function () {
            if ($scope.tipoNivel.nombreNivel) {
                $http.put('api/tiposNivel/' + $scope.tipoNivel.id, JSON.stringify($scope.tipoNivel)).then(function (response) {
                    $scope.tipoNivel = {};
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

        $scope.eliminarTipoNivel = function () {
            $http.delete('api/tiposNivel/' + $scope.idEliminar).then(function (response) {
                $scope.cerrarModal();

                //Recargar la pag
                reload();
            }, function (error) {
                console.log(error);
            });
        };
    }]);