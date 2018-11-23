function buscarDatosUsuario(data){
 
var codigoUsuario= Cookies.get('codigoUsuario');
 for(var i=0; i<data.length;i++){
    if(data[i].codigo.codigo==codigoUsuario){
        $("#usuario").html(data[i].nombre+" "+data[i].apellido);
        Cookies.set('idCuenta', data[i].id);

    }
 }
    
}


(function ($) {

   

        $.ajax({
            method: 'GET',
            url: "/SistemaDeCalificaciones/api/personas",
            dataType: 'json',
            contentType: 'application/json'
        }).done(function (data) {
            buscarDatosUsuario(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });

   
  

})(jQuery);


