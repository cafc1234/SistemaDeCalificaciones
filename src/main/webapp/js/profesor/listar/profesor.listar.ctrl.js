var profesorModule = angular.module("profesorModule");
//El controlador quedará asociado al modulo

profesorModule.controller('profesorCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        // metodo necesario para que se recargue correctamente la pagina, el $state no esta sirviendo por que recarga y no espera que se termine la ejecucion de la accion
        reload = function () {

            $scope.programasProfesores = new Array();
            $scope.tiposDocumentoProfesores = new Array();
            $scope.profesores = new Array();
            $scope.profesor = {};

            $http.get('api/programas').then(function (response) {
                $scope.programasProfesores = response.data;
            }, function (error) {
                console.log(error);
            });
            $http.get('api/tiposDocumento').then(function (response) {
                $scope.tiposDocumentoProfesores = response.data;
            }, function (error) {
                console.log(error);
            });
            $http.get('api/profesores').then(function (response) {
                console.log(response);
                $scope.profesores = response.data;
            }, function (error) {
                console.log(error);
            });

            $http.get('api/roles').then(function (response) {
                $scope.obtenerRol(response.data);
            }, function (error) {
                console.log(error);
            });
        };

        reload();

        $scope.obtenerRol = function (data) {
            for (var i = 0; i < data.length; i++) {
                if (data[i].nombreRol == "Profesor") {
                    $scope.idRol = data[i];
                }
            }
        };

        $scope.actualizarCrear = function (id, tipoModal) {
            $scope.tipoModal = tipoModal;
            $scope.idProfesor = id;

            if (id != 0) {
                $http.get('api/profesores/' + id).then(function (response) {
                    $scope.profesor = response.data;
                }, function (error) {
                    console.log(error);
                });
            }
            ;
        };

        $scope.crearProfesor = function () {

            $scope.obtenerPrograma();
        };

        $scope.obtenerPrograma = function () {
            $http.get('api/programas/' + $scope.profesor.codigo.programa.id).then(function (response) {
                $scope.profesor.codigo.programa = response.data;
                $scope.obtenerTipo();
            }, function (error) {
                console.log(error);
            });

        };

        $scope.obtenerTipo = function () {
            $http.get('api/tiposDocumento/' + $scope.profesor.codigo.tipoDocumento.id).then(function (response) {
                $scope.profesor.codigo.tipoDocumento = response.data;
                $scope.crearCuenta();
            }, function (error) {
                console.log(error);
            });


        };

        $scope.crearCuenta = function () {
            $scope.profesor.codigo.codigo.password = $scope.profesor.codigo.codigo.codigo;
            $scope.profesor.codigo.codigo.idRol = $scope.idRol;
            if ($scope.profesor.codigo.codigo.codigo && $scope.profesor.codigo.codigo.password && $scope.profesor.codigo.codigo.idRol) {
                $http.post('api/cuentas/', JSON.stringify($scope.profesor.codigo.codigo)).then(function (response) {
                    $scope.profesor.codigo.codigo = response.data;
                    $scope.crearPersona();

                }, function (error) {
                    console.log(error);
                });
            }
            ;

        };

        $scope.crearPersona = function () {
            if ($scope.profesor.codigo.nombre && $scope.profesor.codigo.apellido && $scope.profesor.codigo.correo
                    && $scope.profesor.codigo.genero && $scope.profesor.codigo.documento && $scope.profesor.codigo.codigo && $scope.profesor.codigo.programa
                    && $scope.profesor.codigo.tipoDocumento) {

                $http.post('api/personas/', JSON.stringify($scope.profesor.codigo)).then(function (response) {

                    $scope.profesor.codigo = response.data;
                    $scope.crearProfesorCompleto();

                }, function (error) {
                    console.log(error);
                });
            }
            ;
        };

        $scope.crearProfesorCompleto = function () {
            if ($scope.profesor.areaProfundizacion && $scope.profesor.codigo) {

                $http.post('api/profesores/', JSON.stringify($scope.profesor)).then(function (response) {
                    $scope.profesor = {};
                    $scope.cerrarModal();
                    //se recarga la pagina, con el metodo creado que vuelve a llamar el get de los datos
                    reload();

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


        $scope.actualizar = function () {
            if ($scope.profesor.areaProfundizacion && $scope.profesor.codigo) {
                $http.put('api/cuentas/' + $scope.profesor.codigo.codigo.id, JSON.stringify($scope.profesor.codigo.codigo)).then(function (response) {
                    $http.put('api/personas/' + $scope.profesor.codigo.id, JSON.stringify($scope.profesor.codigo)).then(function (response) {
                        $http.put('api/profesores/' + $scope.profesor.id, JSON.stringify($scope.profesor)).then(function (response) {
                            $scope.profesor = {};
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
                }, function (error) {
                    console.log(error);
                });
            }
        };


        $scope.actualizarProfesor = function () {
            $http.get('api/programas/' + $scope.profesor.codigo.programa.id).then(function (response) {
                $scope.profesor.codigo.programa = response.data;
            }, function (error) {
                console.log(error);
            });

            $http.get('api/tiposDocumento/' + $scope.profesor.codigo.tipoDocumento.id).then(function (response) {
                $scope.profesor.codigo.tipoDocumento = response.data;
            }, function (error) {
                console.log(error);
            });

            $scope.actualizar();
        };
        
        $scope.eliminar=function(id){
            $scope.idEliminar=id;
            $("#modalConfirmar").modal("show");
            
        };
        
        $scope.eliminarProfesor=function(){
             $http.delete('api/profesores/' + $scope.idEliminar).then(function (response) {
                // se llama el metodo de cierre del modal
                $scope.cerrarModal();

                reload();
            }, function (error) {
                console.log(error);
            });

        }

    }]);