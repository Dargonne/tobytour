
var GM = document.getElementById("GM");

var a = 0;
var b = 0;

function getRandomInt(min, max) 
{
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

var options = {
  center: {lat : a, lng: b}, 
  zoom: 8,
  mapTypeId:google.maps.MapTypeId.SATELLITE
};

var googlemap = new google.maps.Map(GM, options);

var takef = function(){
	a = getRandomInt(-85, 85);
	b = getRandomInt(-180, 180);
	var options = {
		  center: {lat : a, lng: b}, 
		  zoom: 8,
		  mapTypeId:google.maps.MapTypeId.HYBRID
		};
	var googlemap = new google.maps.Map(GM, options);
}

$("#TAKE_ME").bind("click", takef);



// This code is crafted by Dod Mason Applejack's hubby and THE JS KING! ;D 