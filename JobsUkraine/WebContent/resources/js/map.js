function initialize() {
	var position = new google.maps.LatLng(49.832777, 23.996903);
	var myOptions = {
		zoom : 15,
		center : position,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	var map = new google.maps.Map(document.getElementById("map_canvas"),
			myOptions);

	var marker = new google.maps.Marker({
		position : position,
		map : map,
		title : "This is the place."
	});

	var contentString = 'JobsUkraine<br>Fed\'kovycha 60a/227';
	var infowindow = new google.maps.InfoWindow({
		content : contentString
	});

	google.maps.event.addListener(marker, 'click', function() {
		infowindow.open(map, marker);
	});

};