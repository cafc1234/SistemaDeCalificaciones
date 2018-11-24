var tipoDocumentoModule = angular.module("tipoDocumentoModule");
//El controlador quedará asociado al modulo

tipoDocumentoModule.controller('listarTipoDocumentoCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {

    //Almacenar arreglo de tipos que retorna el servicio GET
    $scope.tipoDocumento = {};

    $scope.tipos = new Array();

    // metodo necesario para que se recargue correctamente la pagina, el $state no esta sirviendo por que recarga y no espera que se termine la ejecucion de la accion
    reload = function () {
      $http.get('api/tiposDocumento').then(function (response) {
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

    $scope.crearTipoDocumento = function () {
      if ($scope.tipoDocumento.nombreTipo) {
        $scope.tipoDocumento.id = $scope.valorId;
        $http.post('api/tiposDocumento/', JSON.stringify($scope.tipoDocumento)).then(function (response) {
          $scope.tipoDocumento = {};
          // se llama el metodo de cierre del modal
          $scope.cerrarModal();
          //se recarga la pagina, con el metodo creado que vuelve a llamar el get de los datos
          reload();
        }, function (error) {
          console.log(error);
        });
      }
      ;    };
    
    // Se corrige el metodo para cerrar el modal
    $scope.cerrarModal = function () {
      $("#modalActualizar").modal("hide");
      $("#modalConfirmar").modal("hide");
    };

    $scope.guardarTipoDocumento = function () {
      if ($scope.tipoDocumento.nombreTipo && $scope.valorId) {
        $scope.tipoDocumento.id = $scope.valorId;

        $http.put('api/tiposDocumento/' + $scope.valorId, JSON.stringify($scope.tipoDocumento)).then(function (response) {
          $scope.tipoDocumento = {};
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

        $scope.eliminarTipoDocumento = function () {
            $http.delete('api/tiposDocumento/' + $scope.idEliminar).then(function (response) {
                $scope.cerrarModal();

                //Recargar la pag
                reload();
            }, function (error) {
                console.log(error);
            });
        };
    }]);