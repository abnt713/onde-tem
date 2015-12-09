import Ember from 'ember';

export default Ember.Component.extend({
	classNames: ['fullheight', 'map'],

	markers : [],
	mapHeight: '200px',
	center : [0.0, 0.0],
	zoom : 3,
	icon :  L.icon({
		iconUrl: 'assets/images/marker-icon.png',
		iconRetinaUrl: 'assets/images/marker-icon@2x.png',
		shadowUrl: 'assets/images/marker-shadow.png',

		iconSize: [25, 41],
		iconAnchor: [13, 40]
	}),

	map : null,
	markersLayer : null,

	onChangeMarkers : Ember.observer('markers', function(){
		console.log("Chamando doutor hans chucrute");
		console.log(this.get('markers'));
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
			self.map.panTo(e.latlng);
			self.sendAction('contextmenu', e.latlng);
			// var marker = {latitude:e.latlng[0], longitude:e.latlng[1], label: "novo"}
			// self.addMarker(map, marker);
			$('.marker-details-wrapper').show();
			console.log("Context Menu at " + e.latlng);
		});

		this.map.locate({setView: true, maxZoom: 16});
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
		this.markersLayer.clearLayers();
	},

	getIcon : function(){
		return this.get('icon');
	},

	addMarker: function(map, marker){
		var popup = new L.Popup();
		popup.setContent(String(marker.label));

		var mapMarker = L.marker(L.latLng(marker.latitude, marker.longitude), {icon: this.getIcon()})
		//.addTo(map)
		.addTo(this.markersLayer)
		.bindPopup(popup, {
			"offset": new L.Point(0, -32)
		});

		mapMarker.marker = marker;
		var self = this;
		mapMarker.on('click', function(e){
			self.sendAction('markerclick', this.marker);
		});
	}

});
