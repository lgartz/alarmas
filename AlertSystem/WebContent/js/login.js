$(function(){
	$( "#enviar" ).click(function() {
        return validacionObligatoriedad();
    });

    $( "#cancelar" ).click(function() {
        $("#message_user").fadeOut();
        $("#message_password").fadeOut();
    });

    function validacionObligatoriedad(){
        var username = $("#username").val();
        var password = $("#password").val();
        var fallo = false;
        if (username.trim()=="") {     
            $("#message_user").fadeIn();
            fallo=true;
        } else{
            $("#message_user").fadeOut();
        }       
        if (password.trim()=="") {
            $("#message_password").fadeIn();
            fallo=true;
        } else{
            $("#message_password").fadeOut();
        }
        return !fallo;
    }
});