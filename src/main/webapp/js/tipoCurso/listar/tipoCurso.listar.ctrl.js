var tipoCursoModule = angular.module("tipoCursoModule");
//El controlador quedará asociado al modulo

tipoCursoModule.controller('listarTiposCursoCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        //Almacenar arreglo de tipos que retorna el servicio GET
        $scope.tipoCurso = {};

        $scope.tipos = new Array();

        // metodo necesario para que se recargue correctamente la pagina, el $state no esta sirviendo por que recarga y no espera que se termine la ejecucion de la accion
        reload = function () {
            $http.get('api/tipoCursos').then(function (response) {
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
            if ($scope.tipoCurso.nombreCurso) {
                $scope.tipoCurso.id = $scope.valorId;
                $http.post('api/tipoCursos/', JSON.stringify($scope.tipoCurso)).then(function (response) {
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

        // Se corrige el metodo para cerrar el modal
        $scope.cerrarModal = function () {
            $("#modalActualizar").modal("hide");
            $("#modalConfirmar").modal("hide");

        };

        $scope.guardarTipoCurso = function () {
            if ($scope.tipoCurso.nombreCurso && $scope.valorId) {
                $scope.tipoCurso.id = $scope.valorId;

                $http.put('api/tipoCursos/' + $scope.valorId, JSON.stringify($scope.tipoCurso)).then(function (response) {
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
            $scope.idEliminar = id;
            $("#modalConfirmar").modal("show");

        };

        $scope.eliminarTipoCurso = function () {
            $http.delete('api/tipoCursos/' + $scope.idEliminar).then(function (response) {
                $scope.cerrarModal();

                //Recargar la pag
                reload();
            }, function (error) {
                console.log(error);
            });
        };
    }]);