var cursoModule = angular.module("cursoModule");
//El controlador quedará asociado al modulo

cursoModule.controller('cursoCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        //Almacenar arreglo de tipos que retorna el servicio GET

        // metodo necesario para que se recargue correctamente la pagina, el $state no esta sirviendo por que recarga y no espera que se termine la ejecucion de la accion
        reload = function () {
            $scope.curso = {};

            $scope.tipoCurso = "";
            $scope.nombreCurso = "";

            $scope.cursos = new Array();
            $scope.cursosFiltro = new Array();
            $scope.profesores = new Array();
            $scope.tiposCurso = new Array();
            $scope.tiposNivel = new Array();


            $http.get('api/grupos').then(function (response) {
                $scope.grupos = response.data;
            }, function (error) {
                console.log(error);
            });

            $http.get('api/profesores').then(function (response) {
                $scope.profesores = response.data;
            }, function (error) {
                console.log(error);
            });

            $http.get('api/tipoCursos').then(function (response) {
                $scope.tiposCurso = response.data;
            }, function (error) {
                console.log(error);
            });

            $http.get('api/tiposNivel').then(function (response) {
                $scope.tiposNivel = response.data;
            }, function (error) {
                console.log(error);
            });

            $http.get('api/cursos').then(function (response) {
                $scope.cursos = response.data;
            }, function (error) {
                console.log(error);
            });
        };

        reload();

        $scope.actualizarCrear = function (id, tipoModal) {
            $scope.valorId = id;
            $scope.tipoModal = tipoModal;
            $("#modalFiltro").modal("hide");

            if (id != 0) {
                $http.get('api/cursos/' + id).then(function (response) {
                    $scope.curso = response.data;
                }, function (error) {
                    console.log(error);
                });
            }
            ;


        };


        $scope.crearCurso = function () {
            $scope.obtenerProfesor();
            $scope.obtenerTipoNivel();
            $scope.obtenerGrupo();
            $scope.obtenerTipoCurso();
            $scope.crear();

        }

        $scope.crear = function () {
            if ($scope.curso.nombreCurso && $scope.curso.tipoNivel &&
                    $scope.curso.tipoCurso && $scope.curso.profesor && $scope.curso.grupo) {
                $http.post('api/cursos/', JSON.stringify($scope.curso)).then(function (response) {
                    $scope.curso = {};
                    // se llama el metodo de cierre del modal
                    $scope.cerrarModal();
                    //se recarga la pagina, con el metodo creado que vuelve a llamar el get de los datos
                    reload();
                }, function (error) {
                    console.log(error);
                });

            }

        };

        $scope.cerrarModal = function () {
            $("#modalActualizar").modal("hide");
            $("#modalConfirmar").modal("hide");
            $("#modalFiltro").modal("hide");


        };

        $scope.obtenerProfesor = function () {
            $http.get('api/profesores/' + $scope.curso.profesor.id).then(function (response) {
                $scope.curso.profesor = response.data;
            }, function (error) {
                console.log(error);
            });

        };
        $scope.obtenerTipoNivel = function () {
            $http.get('api/tiposNivel/' + $scope.curso.tipoNivel.id).then(function (response) {
                $scope.curso.tipoNivel = response.data;
            }, function (error) {
                console.log(error);
            });

        };
        $scope.obtenerTipoCurso = function () {
            $http.get('api/tipoCursos/' + $scope.curso.tipoCurso.id).then(function (response) {
                $scope.curso.tipoCurso = response.data;
            }, function (error) {
                console.log(error);
            });
        };
        $scope.obtenerGrupo = function () {
            $http.get('api/grupos/' + $scope.curso.grupo.id).then(function (response) {
                $scope.grupos = response.data;
            }, function (error) {
                console.log(error);
            });
        };

        $scope.guardarCurso = function () {

            $scope.obtenerProfesor();
            $scope.obtenerTipoNivel();
            $scope.obtenerGrupo();
            $scope.obtenerTipoCurso();
            $scope.actualizar();
        };

        $scope.actualizar = function () {
            if ($scope.curso.nombreCurso && $scope.curso.tipoNivel &&
                    $scope.curso.tipoCurso && $scope.curso.profesor && $scope.curso.grupo) {
                $http.put('api/cursos/' + $scope.curso.id, JSON.stringify($scope.curso)).then(function (response) {
                    $scope.curso = {};
                    // se llama el metodo de cierre del modal
                    $scope.cerrarModal();
                    //se recarga la pagina, con el metodo creado que vuelve a llamar el get de los datos
                    reload();
                }, function (error) {
                    console.log(error);
                });

            }

        };

        $scope.eliminar = function (id) {
            $scope.idEliminar = id;
            $("#modalFiltro").modal("hide");

            $("#modalConfirmar").modal("show");
        };

        $scope.eliminarCurso = function () {
            $http.delete('api/cursos/' + $scope.idEliminar).then(function (response) {
                // se llama el metodo de cierre del modal
                $scope.cerrarModal();

                reload();
            }, function (error) {
                console.log(error);
            });
        };

        $scope.filtrarTipo = function () {
            $scope.cursosFiltro = {};
            $http.get('api/tipoCursos/' + $scope.tipoCurso).then(function (response) {
                $scope.tipoCurso = response.data.nombreCurso;
            }, function (error) {
                console.log(error);
            });
            $http.get('api/cursos').then(function (response) {
                $scope.realizarFiltro(response.data);
            }, function (error) {
                console.log(error);
            });

        };

        $scope.filtrarNombre = function () {
            $scope.cursosFiltro = {};
            for (var i = 0; i < $scope.cursos.length; i++) {
                if ($scope.cursos[i].nombreCurso.indexOf($scope.nombreCurso) > -1) {
                    $scope.cursosFiltro[i] = $scope.cursos[i];
                }
            }

            $("#modalFiltro").modal("show");

        };


        $scope.realizarFiltro = function (data) {
            for (var i = 0; i < data.length; i++) {
                if ($scope.tipoCurso == data[i].tipoCurso.nombreCurso) {
                    $scope.cursosFiltro[i] = data[i];
                }
            }
            $("#modalFiltro").modal("show");

        };


    }]);