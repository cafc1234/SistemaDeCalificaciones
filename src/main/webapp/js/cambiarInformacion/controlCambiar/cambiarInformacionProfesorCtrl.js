var cambiarInformacionProfesorModule = angular.module("cambiarInformacionProfesorModule");
//El controlador quedará asociado al modulo

cambiarInformacionProfesorModule.controller('cambiarInformacionProfesorCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        // metodo necesario para que se recargue correctamente la pagina, el $state no esta sirviendo por que recarga y no espera que se termine la ejecucion de la accion
        reload = function () {

            $scope.profesor = {};
            $scope.clave = {};

            $http.get('api/personas/' + Cookies.get('idCuenta')).then(function (response) {
                $scope.obtenerProfesor(response.data);
            }, function (error) {
                console.log(error);
            });
        };

        reload();

        $scope.obtenerProfesor = function () {
            $http.get('api/profesores').then(function (response) {
                for (var i = 0; i < response.data.length; i++) {
                    if (response.data[i].codigo.id == Cookies.get('idCuenta')) {
                        $scope.profesor = response.data[i];
                    }
                }
            }, function (error) {
                console.log(error);
            });
        };



        $scope.actualizarInformacion = function () {
            if ($scope.profesor.codigo.id && $scope.profesor.codigo.nombre && $scope.profesor.codigo.apellido && $scope.profesor.codigo.correo
                    && $scope.profesor.codigo.genero && $scope.profesor.codigo.documento && $scope.profesor.codigo.codigo && $scope.profesor.codigo.programa
                    && $scope.profesor.codigo.tipoDocumento) {

                $http.put('api/personas/' + $scope.profesor.codigo.id, JSON.stringify($scope.profesor.codigo)).then(function (response) {
                    $http.put('api/profesores/' + $scope.profesor.id, JSON.stringify($scope.profesor)).then(function (response) {
                        $scope.profesor = {};
                        $("#errorActualizar").html("<div class='alert alert-success'>Se cambió la información</div>");

                        //se recarga la pagina, con el metodo creado que vuelve a llamar el get de los datos
                        reload();
                    }, function (error) {
                        console.log(error);
                        $("#errorActualizar").html("<div class='alert alert-danger'>No se pudo actualizar la información</div>");

                    });
                }, function (error) {
                    console.log(error);
                    $("#errorActualizar").html("<div class='alert alert-danger'>No se pudo actualizar la información</div>");

                });

            }
        };

        $scope.cambiarClave = function () {
            if ($scope.clave.passwordAntiguo == $scope.profesor.codigo.codigo.password) {
                if ($scope.clave.passwordAntiguo == $scope.clave.passwordNuevo) {
                    $("#errorClave").html("<div class='alert alert-danger'>La clave nueva no puede ser igual a la antigua</div>");
                } else {

                    if ($scope.clave.passwordNuevo == $scope.clave.passwordConfirmacion) {
                        if ($scope.profesor.codigo.codigo) {
                            $scope.profesor.codigo.codigo.password = $scope.clave.passwordConfirmacion;
                            $http.put('api/cuentas/' + $scope.profesor.codigo.codigo.id, JSON.stringify($scope.profesor.codigo.codigo)).then(function (response) {
                                $scope.profesor = {};
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