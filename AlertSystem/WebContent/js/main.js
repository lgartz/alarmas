/**
 * 
 */
$(document).ready(function() {
	
	//Stops the submit request
    $("#LoginForm").submit(function(e){
    	e.preventDefault();
    	 var name = $('#userName').val();
         var pass= $('#userPassword').val();
         $.get('AutenticacionServlet', {
                 userName : name,
                 pass: pass
         }, function(responseText) {
         	if(responseText=="ok")
         	{
         		//window.location.href=window.location.host+"/HTML5/index.html";
         		window.location.assign("http://"+window.location.host+"/Html5Jboss/index.html");
         	}else{
         		
         		$('#Error').show();
                 $('#Errormsg').text(responseText);
         	}
         });
           
    });
    
    
  //Stops the submit request
    $("#CrearForm").submit(function(e){
    	e.preventDefault();
    	// get inputs
    	var factor = new Object();
        factor.value1 = $('#1').val();
        factor.value2 = $('#2').val();
        factor.value3 = $('#3').val();
        factor.value4 = $('#4').val();
        factor.value5 = $('#5').val();
        factor.value6 = $('#6').val();
        factor.value7 = $('#7').val();
        factor.value8 = $('#8').val();
        factor.value9 = $('#9').val();
        factor.value10 = $('#10').val();
        
     
        $.ajax({
            url: "RetencionServlet",
            type: 'POST',
            dataType: 'json',
            data: JSON.stringify(factor),
            contentType: 'application/json',
            mimeType: 'application/json'     
            
        }).done(function(responseText) {
        	$('#Exito').show();
            $('#Exitomsg').text(responseText.data);
    	});;  
    });
    
     
    
});



$("#CrearForm_rest").submit(function(e){
	e.preventDefault();
    
    var factorRetencion = {
    		codigoFactor: $('#5').val(),
    		descripcion: $('#4').val(),
    		indicadorIngresoEgresoEnum: $('#6').val(),
    		porcentajeRetencionNoDecl: $('#9').val(),
    		porcentajeRetencionDeclarante: $('#10').val()
    		//indicadorOperacional: $('#optionsRadiosInline1').val() || $('#optionsRadiosInline2').val(),
        };
 
    $.ajax({
    	url: "http://"+window.location.host+"/Html5Jboss/rest/factorRetencionCrud/crearfactor",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(factorRetencion),
        contentType: 'application/json',
        mimeType: 'application/json',
    }).done(function(responseText) {
    	$('#Exito').show();
        $('#Exitomsg').text(responseText.data);
	});;  
});

 



//////////////////////




//Stops the submit request
function getFactor() {
	alert("getFactor");
	$('#Error').hide();
	$('#Exito').hide();
	
	$.ajax({
        url: "http://"+window.location.host+"/Html5Jboss/rest/factorRetencion/getFactorRetencion",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',     
        success: function(responseText) {
     				alert( "ok" );
			    	$('#Exito').show();
			        $('#Exitomsg').text(responseText.data);
     			},
     	error: function() {
				    alert( "error" );
				    $('#Error').show();
			        $('#Errormsg').text(responseText.data);
     			},
     	complete: function() {
     				alert("done");
     			}
	});
}

//Stops the submit request
function getFactorResponse() {
	alert("getFactorResponse");
	$('#Error').hide();
	$('#Exito').hide();
	
	$.ajax({
        url: "http://"+window.location.host+"/Html5Jboss/rest/factorRetencion/getFactorRetencionResponse",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',     
        success: function(responseText) {
     				alert( "ok" );
			    	$('#Exito').show();
			        $('#Exitomsg').text(responseText.data);
     			},
     	error: function() {
				    alert( "error" );
				    $('#Error').show();
			        $('#Errormsg').text(responseText.data);
     			},
     	complete: function() {
     				alert("done");
     			}
	});
}

//Stops the submit request
function getFactorList() {
	alert("getFactorList");
	$('#Error').hide();
	$('#Exito').hide();
	
	$.ajax({
        url: "http://"+window.location.host+"/Html5Jboss/rest/factorRetencion/getListFactorRetencion",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',     
        success: function(responseText) {
     				alert( "ok" );
			    	$('#Exito').show();
			        $('#Exitomsg').text(responseText.data);
     			},
     	error: function() {
				    alert( "error" );
				    $('#Error').show();
			        $('#Errormsg').text(responseText.data);
     			},
     	complete: function() {
     				alert("done");
     			}
	});
}

//Stops the submit request
function postFactorCrear() {
	alert("postFactorCrear");
	$('#Error').hide();
	$('#Exito').hide();
	
	$.ajax({
        url: "http://"+window.location.host+"/Html5Jboss/rest/factorRetencionCrud/crear/11/unos",
        type: 'POST',
        success: function(responseText) {
        			alert( "ok" );
			    	$('#Exito').show();
			        $('#Exitomsg').text(responseText.data);
        		},
        error: function() {
				    alert( "error" );
				    $('#Error').show();
			        $('#Errormsg').text(responseText.data);
        		},
        complete: function() {
     				alert("done");
     			}
	});
}

//Stops the submit request
function postFactorCrearJson() {
	alert("postFactorCrearJson");
	$('#Error').hide();
	$('#Exito').hide();
    
    var factorRetencion = {
    	idFactorRetencion: 333,
		codigoFactor: "factor 3"
    };
    
	$.ajax({
        url: "http://"+window.location.host+"/Html5Jboss/rest/factorRetencionCrud/crearfactor",
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(factorRetencion),
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function(responseText) {
        			alert( "ok" );
			    	$('#Exito').show();
			        $('#Exitomsg').text(responseText);
        		},
        error: function() {
				    alert( "error" );
				    $('#Error').show();
			        $('#Errormsg').text(responseText);
        		},
        complete: function() {
     				alert("done");
     			}
	});
}


