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

        $stateProvider.state("tipoCurso", {
            url: '/tipoCursos',
            views: {
                mainView: {
                    templateUrl: './js/tipoCurso/listar/listarTipoCurso.html',
                    controller: 'listarTipoCursoCtrl'
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

        $stateProvider.state("programa", {
            url: '/programa',
            views: {
                mainView: {
                    templateUrl: './js/programa/listar/listarProgramas.html',
                    controller: 'listarProgramaCtrl'
                }
            }
        });

    }]);
