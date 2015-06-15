function initialize(){
  changePosition(5.529258050293696, -73.36318016052246,"Tipo Alarma","Aqui se coloca una pequeña descricion de la alarma");
}

function changePosition(latitud, longitud, typeAlarm, description){
  var mapOption = {
    center: new google.maps.LatLng( latitud, longitud),
    zoom:15,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  };

  var map = new google.maps.Map(document.getElementById("googleMap"),mapOption);

  var marker = new google.maps.Marker({
    position: map.getCenter(),
    map: map,
    title: 'Punto Marcado'
  });

  google.maps.event.addListener(map, 'center_changed', function() {
    window.setTimeout(function() {
      map.panTo(marker.getPosition());
    }, 1000);
  });

  var infowindow = new google.maps.InfoWindow();

  infowindow.setContent(getDescripcion(typeAlarm, description));

  google.maps.event.addListener(marker, 'click', function() {
      map.setZoom(20);
      infowindow.open(map, marker);
  });
}

function loadScript(){
  var script = document.createElement("script");
  script.type = "text/javascript";
  script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp' +
      '&signed_in=true&callback=initialize';
  document.body.appendChild(script);
}

function getDescripcion(typeAlarm, description){
    return "<h4>"+typeAlarm+"</h4>"+"<p><strong>Descripci&oacute;n:</strong>"+description+"</p>"
}

google.maps.event.addDomListener(window, 'load', initialize);