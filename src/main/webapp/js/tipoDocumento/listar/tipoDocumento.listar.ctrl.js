var tipoDocumentoModule = angular.module("tipoDocumentoModule");
//El controlador quedará asociado al modulo

tipoDocumentoModule.controller('listarTipoDocumentoCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        //Almacenar arreglo de tipos que retorna el servicio GET
        $scope.tipos = new Array();

        $http.get('api/tiposDocumento').then(function (response) {
            console.log(response);
            $scope.tipos = response.data;
        }, function (error) {
            console.log(error);
        });
        $scope.actualizar = function (id,nombreTipo) {
          $scope.prueba=nombreTipo;
        };
    }]);