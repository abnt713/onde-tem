import Ember from 'ember';

export default Ember.Component.extend({
	classNames: ['fullheight', 'map'],

	markers : [],
	mapHeight: '200px',
	center : [0.0, 0.0],
	zoom : 13,
	icon :  L.icon({
			iconUrl: 'assets/images/marker-icon.png',
			iconRetinaUrl: 'assets/images/marker-icon@2x.png',
			shadowUrl: 'assets/images/marker-shadow.png'
	}),

	map : null,
	markersLayer : null,

	onChangeMarkers : Ember.observer('markers', function(){
			this.clearMarkers();
			this._addMarkers(this.map, this.get('markers'));
	}),

	didInsertElement : function(){
			this.buildMap();
	},

	buildMap :function(){
		this.map = this._Map();
		this.markersLayer = L.layerGroup();
		this.markersLayer.addTo(this.map);

		this._addMapLayer(this.map);

		var markers = this.get('markers');
		this._addMarkers(this.map, markers);

		var self = this;
		this.map.on('contextmenu', function onMapClick(e) {
			self.map.panTo(e.latlng)
			self.sendAction('contextmenu', e.latlng);
			// var marker = {latitude:e.latlng[0], longitude:e.latlng[1], label: "novo"}
			// self.addMarker(map, marker);
			$('.marker-details-wrapper').show();
				console.log("Context Menu at " + e.latlng);
		});
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
						// L.marker([marker.latitude, marker.longitude], {icon: this.getIcon()})
						// 	.addTo(map)
						// 	.bindPopup(String(marker.label) + "[" + marker.latitude + ", " + marker.longitude + "]").openPopup();
						this.addMarker(map, marker);
				}
		}
	},

	clearMarkers : function(){
			var markers = this.get('markers');
			for(var i=0; i < markers.length; ++i){
					this.markersLayer.removeLayer(markers[i]);
			}
	},

	getIcon : function(){
			return this.get('icon');
	},

	addMarker: function(map, marker){
		L.marker(L.latLng(marker.latitude, marker.longitude), {icon: this.getIcon()})
			//.addTo(map)
			.addTo(this.markersLayer)
			.bindPopup(String(marker.label)).openPopup();
	}

});
