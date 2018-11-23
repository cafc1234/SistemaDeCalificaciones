var cambiarInformacionModule = angular.module("cambiarInformacionModule");
//El controlador quedará asociado al modulo

cambiarInformacionModule.controller('cambiarInformacionCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        // metodo necesario para que se recargue correctamente la pagina, el $state no esta sirviendo por que recarga y no espera que se termine la ejecucion de la accion
        reload = function () {

            $scope.estudiante = {};
            $scope.clave = {};

            $http.get('api/personas/' + Cookies.get('idCuenta')).then(function (response) {
                console.log(response);
                $scope.estudiante = response.data;
            }, function (error) {
                console.log(error);
            });
        };

        reload();

        $scope.actualizarInformacion = function () {
            if ($scope.estudiante.id && $scope.estudiante.nombre && $scope.estudiante.apellido && $scope.estudiante.correo
                    && $scope.estudiante.genero && $scope.estudiante.documento && $scope.estudiante.codigo && $scope.estudiante.programa
                    && $scope.estudiante.tipoDocumento) {
                $http.put('api/personas/' + $scope.estudiante.id, JSON.stringify($scope.estudiante)).then(function (response) {
                    $scope.estudiante = {};
                    $("#errorActualizar").html("<div class='alert alert-success'>Se cambió la información</div>");

                    //se recarga la pagina, con el metodo creado que vuelve a llamar el get de los datos
                    reload();
                }, function (error) {
                    console.log(error);
                    $("#errorActualizar").html("<div class='alert alert-danger'>No se pudo actualizar la información</div>");

                });
            }
        };

        $scope.cambiarClave = function () {
            if ($scope.clave.passwordAntiguo == $scope.estudiante.codigo.password) {
                if ($scope.clave.passwordAntiguo == $scope.clave.passwordNuevo) {
                    $("#errorClave").html("<div class='alert alert-danger'>La clave nueva no puede ser igual a la antigua</div>");
                } else {
                    if ($scope.clave.passwordNuevo == $scope.clave.passwordConfirmacion) {
                        if ($scope.estudiante.codigo) {
                            $scope.estudiante.codigo.password=$scope.clave.passwordConfirmacion;
                            $http.put('api/cuentas/' + $scope.estudiante.codigo.id, JSON.stringify($scope.estudiante.codigo)).then(function (response) {
                                $scope.estudiante = {};
                                $scope.clave = {};
                                $("#errorClave").html("<div class='alert alert-success'>Se cambió la clave de forma exitosa</div>");

                                //se recarga la pagina, con el metodo creado que vuelve a llamar el get de los datos
                                reload();
                            }, function (error) {
                                console.log(error);
                                $("#errorClave").html("<div class='alert alert-danger'>No se pudo cambiar la clave</div>");

                            });
                        }
                    } else {
                        $("#errorClave").html("<div class='alert alert-danger'>La clave nueva y de confirmación no coinciden</div>");
                    }
                }
            } else {
                $("#errorClave").html("<div class='alert alert-danger'>La clave antigua no es correcta</div>");
            }


        };

    }]);