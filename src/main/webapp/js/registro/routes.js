var app = angular.module("SistemaRegistro");

//Se realiza la configuración de la aplicación mediante el manejo 
//de estados de las rutas 
app.config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) {

//Otherwise - 404- Cuando no encuentra una ruta 
        $urlRouterProvider.otherwise('/');

        $stateProvider.state("registro", {
            url: '/',
            views: {
                mainView: {
                    templateUrl: './js/registro/registro.html',
                    controller: 'registroCtrl'
                }
            }
        });


 



    }]);
