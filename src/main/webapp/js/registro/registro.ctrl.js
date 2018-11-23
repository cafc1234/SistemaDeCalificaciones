var registroModule = angular.module("registroModule");
//El controlador quedará asociado al modulo

registroModule.controller('registroCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        // metodo necesario para que se recargue correctamente la pagina, el $state no esta sirviendo por que recarga y no espera que se termine la ejecucion de la accion
        reload = function () {

            $scope.programasCoordinadores = new Array();
            $scope.tiposDocumentoCoordinadores = new Array();
            $scope.coordinadores = new Array();
            $scope.coordinador = {};
            $scope.cuenta = {};
            $scope.tipoDocumento = {};
            $scope.programa = {};
            $scope.cuenta.idRol = {
                "id": 252,
                "nombreRol": "Coordinador"
            };



            $http.get('api/programas').then(function (response) {
                $scope.programasCoordinadores = response.data;
            }, function (error) {
                console.log(error);
            });
            $http.get('api/tiposDocumento').then(function (response) {
                $scope.tiposDocumentoCoordinadores = response.data;
            }, function (error) {
                console.log(error);
            });

        };

        reload();


        $scope.crearCoordinador = function () {
            if ($scope.cuenta.password === $scope.cuenta.passwordConfirmacion) {
                if ($scope.coordinador.apellido && $scope.coordinador.nombre && $scope.coordinador.correo
                        && $scope.coordinador.genero && $scope.coordinador.documento) {
                    $scope.obtenerPrograma();
                } else {

                    $("#errorClave").html("<div class='alert alert-danger'>No se completó todo el formulario</div>");
                }

            } else {
                $("#errorClave").html("<div class='alert alert-danger'>Las claves no coinciden</div>");
            }
        };



        $scope.crearCoordinadorCompleto = function () {
            if ($scope.coordinador.nombre && $scope.coordinador.apellido && $scope.coordinador.correo
                    && $scope.coordinador.genero && $scope.coordinador.documento && $scope.coordinador.codigo && $scope.coordinador.programa
                    && $scope.coordinador.tipoDocumento) {

                $http.post('api/personas/', JSON.stringify($scope.coordinador)).then(function (response) {
                    $scope.coordinador = {};
                    window.location.href = "/SistemaDeCalificaciones/index.html"
                }, function (error) {
                    console.log(error);
                });
            } else {

                $("#errorClave").html("<div class='alert alert-danger'>No se completaron todos los campos</div>");

            }
        };


        $scope.obtenerTipo = function () {
            $http.get('api/tiposDocumento/' + $scope.tipoDocumento.id).then(function (response) {
                $scope.coordinador.tipoDocumento = response.data;
                $scope.tipoDocumento = {};
                $scope.crearCuenta();
            }, function (error) {
                console.log(error);
            });


        };

        $scope.obtenerPrograma = function () {
            $http.get('api/programas/' + $scope.programa.id).then(function (response) {
                $scope.coordinador.programa = response.data;
                $scope.programa = {};
                $scope.obtenerTipo();
            }, function (error) {
                console.log(error);
            });

        };



        $scope.crearCuenta = function () {

            if ($scope.cuenta.codigo && $scope.cuenta.password && $scope.cuenta.idRol) {
                $http.post('api/cuentas/', JSON.stringify($scope.cuenta)).then(function (response) {
                    $scope.cuenta = {};
                    $scope.coordinador.codigo = response.data;
                    $scope.crearCoordinadorCompleto();

                }, function (error) {
                    console.log(error);
                });
            } else {
                $("#errorClave").html("<div class='alert alert-danger'>No se completaron todos los campos</div>");

            }


        };



    }]);

