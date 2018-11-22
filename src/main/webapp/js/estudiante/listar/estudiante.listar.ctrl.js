var estudianteModule = angular.module("estudianteModule");
//El controlador quedará asociado al modulo

estudianteModule.controller('estudianteCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        // metodo necesario para que se recargue correctamente la pagina, el $state no esta sirviendo por que recarga y no espera que se termine la ejecucion de la accion
        reload = function () {

            $scope.programasEstudiantes = new Array();
            $scope.tiposDocumentoEstudiantes = new Array();
            $scope.estudiantes = new Array();
            $scope.estudiante = {};
            $scope.cuenta = {};
            $scope.tipoDocumento = {};
            $scope.programa = {};
            $scope.cuenta.idRol = {
                "id": 54,
                "nombreRol": "Estudiante"
            };



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
                    $scope.cuenta = $scope.estudiante.codigo;
                    $scope.tipoDocumento = $scope.estudiante.tipoDocumento;
                    $scope.programa = $scope.estudiante.programa;
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

        $scope.actualizarEstudiante = function () {
            if ($scope.estudiante.id && $scope.estudiante.nombre && $scope.estudiante.apellido && $scope.estudiante.correo
                    && $scope.estudiante.genero && $scope.estudiante.documento && $scope.estudiante.codigo && $scope.estudiante.programa
                    && $scope.estudiante.tipoDocumento) {
                $http.put('api/personas/' + $scope.estudiante.id, JSON.stringify($scope.estudiante)).then(function (response) {
                    $scope.estudiante = {};
                    // se llama el metodo de cierre del modal
                    $scope.cerrarModal();
                    //se recarga la pagina, con el metodo creado que vuelve a llamar el get de los datos
                    reload();
                }, function (error) {
                    console.log(error);
                });
            }
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
            $http.get('api/tiposDocumento/' + $scope.tipoDocumento.id).then(function (response) {
                $scope.estudiante.tipoDocumento = response.data;
                $scope.tipoDocumento = {};
                $scope.crearCuenta();
            }, function (error) {
                console.log(error);
            });


        };

        $scope.obtenerPrograma = function () {
            $http.get('api/programas/' + $scope.programa.id).then(function (response) {
                $scope.estudiante.programa = response.data;
                $scope.programa = {};
                $scope.obtenerTipo();
            }, function (error) {
                console.log(error);
            });

        };



        $scope.crearCuenta = function () {
            $scope.cuenta.password = $scope.cuenta.codigo;
            if ($scope.cuenta.codigo && $scope.cuenta.password && $scope.cuenta.idRol) {
                $http.post('api/cuentas/', JSON.stringify($scope.cuenta)).then(function (response) {
                    $scope.cuenta = {};
                    $scope.estudiante.codigo = response.data;
                    $scope.crearEstudianteCompleto();

                }, function (error) {
                    console.log(error);
                });
            }
            ;

        };

    }]);