var app= angular.module("SistemaCalificaciones");

//Se realiza la configuración de la aplicación mediante el manejo 
//de estados de las rutas 
app.config(["$stateProvider","$urlRouterProvider", function($stateProvider,$urlRouterProvider){
    
//Otherwise - 404- Cuando no encuentra una ruta 
$urlRouterProvider.otherwise('/');

$stateProvider.state("tipoDocumento",{
url:'/tipoDocumento',
views:{
   mainView:{
     templateUrl:'./js/tipoDocumento/listar/listarTiposDocumento.html',
     controller:'listarTipoDocumentoCtrl'
   }    
}
});
        
}]);
