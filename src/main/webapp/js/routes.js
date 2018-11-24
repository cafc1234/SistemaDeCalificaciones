var app = angular.module("SistemaCalificaciones");

//Se realiza la configuración de la aplicación mediante el manejo 
//de estados de las rutas 
app.config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) {

//Otherwise - 404- Cuando no encuentra una ruta 
        $urlRouterProvider.otherwise('/');

        $stateProvider.state("tipoDocumento", {
            url: '/tipoDocumento',
            views: {
                mainView: {
                    templateUrl: './js/tipoDocumento/listar/listarTiposDocumento.html',
                    controller: 'listarTipoDocumentoCtrl'
                }
            }
        });
        
                $stateProvider.state("tipoDocumento", {
            url: '/tipoDocumento',
            views: {
                mainView: {
                    templateUrl: './js/tipoDocumento/listar/listarTiposDocumento.html',
                    controller: 'listarTipoDocumentoCtrl'
                }
            }
        });

        $stateProvider.state("programa", {
            url: '/programa',
            views: {
                mainView: {
                    templateUrl: './js/programa/listar/listarProgramas.html',
                    controller: 'listarProgramaCtrl'
                }
            }
        });


        $stateProvider.state("cursos", {
            url: '/cursos',
            views: {
                mainView: {
                    templateUrl: './js/curso/listar/listarCursos.html',
                    controller: 'cursoCtrl'
                }
            }
        });



        $stateProvider.state("cambiar_informacion", {
            url: '/cambiar_informacion',
            views: {
                mainView: {
                    templateUrl: './js/cambiarInformacion/controlCambiar/cambiarInformacion.html',
                    controller: 'cambiarInformacionCtrl'
                }
            }
        });

        $stateProvider.state("cambiar_informacion_profesor", {
            url: '/cambiar_informacion_profesor',
            views: {
                mainView: {
                    templateUrl: './js/cambiarInformacion/controlCambiar/cambiarInformacionProfesor.html',
                    controller: 'cambiarInformacionProfesorCtrl'
                }
            }
        });



        $stateProvider.state("tipoCurso", {
            url: '/tipoCursos',
            views: {
                mainView: {
                    templateUrl: './js/tipoCurso/listar/listarTiposCurso.html',
                    controller: 'listarTiposCursoCtrl'
                }
            }
        });

        $stateProvider.state("estudiante", {
            url: '/estudiante',
            views: {
                mainView: {
                    templateUrl: './js/estudiante/listar/listarEstudiantes.html',
                    controller: 'estudianteCtrl'
                }
            }
        });
        


        $stateProvider.state("profesor", {
            url: '/profesor',
            views: {
                mainView: {
                    templateUrl: './js/profesor/listar/listarProfesores.html',
                    controller: 'profesorCtrl'
                }
            }
        });
        
        $stateProvider.state("grupo", {
            url: '/grupos',
            views: {
                mainView: {
                    templateUrl: './js/grupo/listar/listarGrupos.html',
                    controller: 'listarGrupoCtrl'
                }
            }
        });

        $stateProvider.state("tiposNivel", {
            url: '/tiposNivel',
            views: {
                mainView: {
                    templateUrl: './js/tipoNivel/listar/listarTiposNivel.html',
                    controller: 'listarTiposNivelCtrl'
                }
            }
        });

    }]);


