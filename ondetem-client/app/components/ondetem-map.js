import Ember from 'ember';

export default Ember.Component.extend({
	didInsertElement : function(){

			var myIcon = L.icon({
			    iconUrl: 'assets/images/marker-icon.png',
			    iconRetinaUrl: 'assets/images/marker-icon@2x.png',
			    shadowUrl: 'assets/images/marker-shadow.png'
			});

			var map = L.map('map').setView([51.5, -0.09], 13);
			L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
			    attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
			}).addTo(map);

			var marker = L.marker([51.5, -0.09], {icon: myIcon}).addTo(map);
			marker.bindPopup("<b>Hello world!</b><br>I am a popup.").openPopup();
	}
});
