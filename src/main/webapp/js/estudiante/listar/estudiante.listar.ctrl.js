var estudianteModule = angular.module("estudianteModule");
//El controlador quedará asociado al modulo

estudianteModule.controller('estudianteCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        // metodo necesario para que se recargue correctamente la pagina, el $state no esta sirviendo por que recarga y no espera que se termine la ejecucion de la accion
        $scope.estudiante = {};
        $scope.tipoDocumento = {};

        reload = function () {

            $scope.programasEstudiantes = new Array();
            $scope.tiposDocumentoEstudiantes = new Array();
            $scope.estudiantes = new Array();
            $scope.estudiante = {};
            $scope.tipoDocumento = {};
            $scope.programa = {};
            $scope.cuenta = {};
            $http.get('api/roles').then(function (response) {
                $scope.obtenerRol(response.data);
            }, function (error) {
                console.log(error);
            });


            $http.get('api/programas').then(function (response) {
                $scope.programasEstudiantes = response.data;
            }, function (error) {
                console.log(error);
            });
            $http.get('api/tiposDocumento').then(function (response) {
                $scope.tiposDocumentoEstudiantes = response.data;
            }, function (error) {
                console.log(error);
            });
            $http.get('api/personas').then(function (response) {
                console.log(response);
                $scope.estudiantes = response.data;
            }, function (error) {
                console.log(error);
            });
        };

        reload();

        $scope.obtenerRol = function (data) {
            for (var i = 0; i < data.length; i++) {
                if (data[i].nombreRol == "Estudiante") {
                    $scope.idRol = data[i];
                }
            }
        };

        /*Se encarga de mostrar el modal de confirmación y de asignar el id a eliminar a la variable
         idEliminar
         **/
        $scope.eliminar = function (id) {
            $scope.idEliminar = id;
            $("#modalConfirmar").modal("show");

        };

        /*
         *  Se encarga de eliminar el estudiante una vez se confirmó por parte del usuario que desea realizarse
         */
        $scope.eliminarEstudiante = function () {
            $http.delete('api/personas/' + $scope.idEliminar).then(function (response) {
                // se llama el metodo de cierre del modal
                $scope.cerrarModal();

                reload();
            }, function (error) {
                console.log(error);
            });
        };

        $scope.actualizarCrear = function (id, tipoModal) {
            $scope.tipoModal = tipoModal;
            $scope.idEstudiante = id;

            if (id != 0) {
                $http.get('api/personas/' + id).then(function (response) {
                    $scope.estudiante = response.data;
                    $scope.programa = $scope.estudiante.programa;
                    $scope.tipoDocumento = $scope.estudiante.tipoDocumento;
                    $scope.cuenta = $scope.estudiante.codigo;
                }, function (error) {
                    console.log(error);
                });
            }
            ;
        };

        $scope.cerrarModal = function () {
            $("#modalActualizar").modal("hide");
            $("#modalConfirmar").modal("hide");

        };

        $scope.crearEstudiante = function () {

            $scope.obtenerPrograma();


        };

        $scope.actualizar = function () {
            if ($scope.estudiante.id && $scope.estudiante.nombre && $scope.estudiante.apellido && $scope.estudiante.correo
                    && $scope.estudiante.genero && $scope.estudiante.documento && $scope.estudiante.codigo && $scope.estudiante.programa
                    && $scope.estudiante.tipoDocumento) {
                $http.put('api/cuentas/' + $scope.cuenta.id, JSON.stringify($scope.cuenta)).then(function (response) {

                    $http.put('api/personas/' + $scope.estudiante.id, JSON.stringify($scope.estudiante)).then(function (response) {
                        $scope.estudiante = {};
                        // se llama el metodo de cierre del modal
                        $scope.cerrarModal();
                        //se recarga la pagina, con el metodo creado que vuelve a llamar el get de los datos
                        reload();
                    }, function (error) {
                        console.log(error);
                    });

                }, function (error) {
                    console.log(error);
                });

            }
        }

        $scope.actualizarEstudiante = function () {
            $http.get('api/programas/' + $scope.programa.id).then(function (response) {
                $scope.programa = {};
                $scope.estudiante.programa = response.data;
            }, function (error) {
                console.log(error);
            });

            $http.get('api/tiposDocumento/' + $scope.estudiante.tipoDocumento.id).then(function (response) {
                $scope.tipoDocumento = {};
                $scope.estudiante.tipoDocumento = response.data;
            }, function (error) {
                console.log(error);
            });

            $scope.actualizar();

        };


        $scope.crearEstudianteCompleto = function () {
            if ($scope.estudiante.nombre && $scope.estudiante.apellido && $scope.estudiante.correo
                    && $scope.estudiante.genero && $scope.estudiante.documento && $scope.estudiante.codigo && $scope.estudiante.programa
                    && $scope.estudiante.tipoDocumento) {

                $http.post('api/personas/', JSON.stringify($scope.estudiante)).then(function (response) {
                    $scope.estudiante = {};
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


        $scope.obtenerTipo = function () {
            $http.get('api/tiposDocumento/' + $scope.estudiante.tipoDocumento.id).then(function (response) {
                $scope.tipoDocumento = {};
                $scope.estudiante.tipoDocumento = response.data;
                $scope.crearCuenta();
            }, function (error) {
                console.log(error);
            });


        };

        $scope.obtenerPrograma = function () {
            $http.get('api/programas/' + $scope.programa.id).then(function (response) {
                $scope.programa = {};
                $scope.estudiante.programa = response.data;
                $scope.obtenerTipo();
            }, function (error) {
                console.log(error);
            });

        };



        $scope.crearCuenta = function () {
            $scope.cuenta.password = $scope.cuenta.codigo;
            $scope.cuenta.idRol = $scope.idRol;
            if ($scope.cuenta.codigo && $scope.cuenta.password && $scope.cuenta.idRol) {
                $http.post('api/cuentas/', JSON.stringify($scope.cuenta)).then(function (response) {
                    $scope.estudiante.codigo = response.data;
                    $scope.crearEstudianteCompleto();

                }, function (error) {
                    console.log(error);
                });
            }
            ;

        };

    }]);