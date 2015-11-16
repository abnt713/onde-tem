import Ember from 'ember';

export default Ember.Component.extend({
	classNames: ['fullheight'],

	markers : [],
	mapHeight: '200px',
	center : [51.5, -0.09],
	zoom : 13,
	icon :  L.icon({
			iconUrl: 'assets/images/marker-icon.png',
			iconRetinaUrl: 'assets/images/marker-icon@2x.png',
			shadowUrl: 'assets/images/marker-shadow.png'
	}),
	
	didInsertElement : function(){
			this.buildMap();
	},

	buildMap :function(){
			var map = this._Map();

			this._addMapLayer(map);

			var markers = this.get('markers');
			this._addMarkers(map, markers);
	},

	_Map : function(){
			var center = this.get('center');
			var zoom = this.get('zoom');

			var mapElem = this.$('.map').get(0);
			var map = L.map(mapElem).setView(center, zoom);

			return map;
	},
	_addMapLayer : function(map){
			L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
					attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
			}).addTo(map);
	},
	_addMarkers : function(map, markers){
		if(markers){
				for(var i=0; i < markers.length; ++i){
						var marker = markers[i];
						L.marker([marker.x, marker.y], {icon: this.getIcon()})
							.addTo(map)
							.bindPopup(String(marker.label) + "[" + marker.x + ", " + marker.y + "]").openPopup();
				}
		}
	},

	getIcon : function(){
			return this.get('icon');
	}

});
