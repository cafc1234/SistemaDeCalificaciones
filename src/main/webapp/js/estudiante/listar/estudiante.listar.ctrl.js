var estudianteModule = angular.module("estudianteModule");
//El controlador quedará asociado al modulo

estudianteModule.controller('estudianteCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {


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

        // metodo necesario para que se recargue correctamente la pagina, el $state no esta sirviendo por que recarga y no espera que se termine la ejecucion de la accion
        reload = function () {
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

        $scope.actualizarCrear = function (id, tipoModal) {
            $scope.tipoModal = tipoModal;
            $scope.idEstudiante = id;
        };

        $scope.cerrarModal = function () {
            $("#modalActualizar").modal("hide");

        };

        $scope.crearEstudiante = function () {

            $scope.obtenerPrograma();
            $scope.crearCuenta();


        };
        $scope.crearEstudianteCompleto = function () {
            if ($scope.estudiante.nombre && $scope.estudiante.apellido && $scope.estudiante.correo
                    && $scope.estudiante.genero && $scope.estudiante.documento && $scope.estudiante.codigo && $scope.estudiante.programa
                    && $scope.estudiante.tipoDocumento) {
                console.log($scope.estudiante);

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


        $scope.obtenerPrograma = function () {
            $http.get('api/programas/' + $scope.programa.id).then(function (response) {
                $scope.estudiante.programa = response.data;
                $scope.programa = {};
            }, function (error) {
                console.log(error);
            });
            $http.get('api/tiposDocumento/' + $scope.tipoDocumento.id).then(function (response) {
                $scope.estudiante.tipoDocumento = response.data;
                $scope.tipoDocumento = {};
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