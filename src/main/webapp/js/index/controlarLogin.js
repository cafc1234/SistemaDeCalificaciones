

function validarLogin(data) {
    var login = $("#codigo").val();
    var clave = $("#clave").val();
    esClaveValida = false;
    esUsuarioValido = false;
    posicion = 0;


    for (var i = 0; i < data.length; i++) {
        if (data[i].codigo == login) {
            esUsuarioValido = true;
            if (data[i].password == clave) {
                esClaveValida = true;
                posicion = i;
            }
        }
    }
    if (esClaveValida && esUsuarioValido) {
        document.cookie = "codigoUsuario=" + data[posicion].codigo;
        if (data[posicion].idRol.nombreRol == "Estudiante") {
            window.location.href = "/SistemaDeCalificaciones/estudiante.html";
        }


    } else {
        $("#errorClave").html("<div class='alert alert-danger'>La clave no es correcta</div>");

    }
}

(function ($) {

    $("#botonInicio").click(function (event) {

        $.ajax({
            method: 'GET',
            url: "/SistemaDeCalificaciones/api/cuentas",
            dataType: 'json',
            contentType: 'application/json'
        }).done(function (data) {
            validarLogin(data);
        }).fail(function (xhr, status, error) {
            console.log(error);
        });

    });


})(jQuery);


