var tipoDocumentoModule = angular.module("tipoDocumentoModule");
//El controlador quedará asociado al modulo

tipoDocumentoModule.controller('listarTipoDocumentoCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        //Almacenar arreglo de tipos que retorna el servicio GET
        $scope.tipoDocumento = {};

        $scope.tipos = new Array();

        $http.get('api/tiposDocumento').then(function (response) {
            console.log(response);
            $scope.tipos = response.data;
        }, function (error) {
            console.log(error);
        });
        $scope.actualizarCrear = function (id, nombreTipo, tipoModal) {
            $scope.valorNombre = nombreTipo;
            $scope.valorId = id;
            $scope.tipoModal = tipoModal;
        };

        $scope.crearTipoDocumento = function () {
            $scope.cerrarModal();
        };
        $scope.cerrarModal = function () {
            document.getElementById("botonCerrar").click();

        };
        $scope.guardarTipoDocumento = function () {
            $scope.cerrarModal();
            alert($scope.tipoModal.nombreTipo);
            if ($scope.tipoDocumento.nombreTipo && $scope.valorId) {
                $scope.tipoDocumento.id = $scope.valorId;

                $http.put('api/tiposDocumento/' + $scope.valorId, JSON.stringify($scope.tipoDocumento)).then(function (response) {
                    $scope.tipoDocumento = {};
                    $state.reload();
                }, function (error) {
                    console.log(error);
                });
            }
            ;
        };


        $scope.eliminar = function (id) {
            $http.delete('api/tiposDocumento/' + id).then(function (response) {
                //Recargar la pag
                $state.reload();
            }, function (error) {
                console.log(error);
            });
        };
    }]);