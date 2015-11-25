import Ember from 'ember';

export default Ember.Route.extend({
	model(){
		return [
			{latitude:0.0, longitude:0.0, label:"center of the world"},
			{latitude:0.1, longitude:-0.10, label:"other marker"},
			{latitude:-5.84132, longitude:-35.19833, label: "dimap"}
		];
	},

	novo_marcador: {
		latitude: null,
		longitude: null,
		label: null
	},

	actions: {
		new_marker: function(latlng){
			console.log(latlng);
			var marker = this.get('novo_marcador');
			console.log(marker);
			marker.latitude = latlng.lat;
			marker.longitude = latlng.lng;

			this.set('novo_marcador', marker);
			console.log(this.get('novo_marcador'));
		},

		save_marker: function(label){
			var marker = this.get('novo_marcador');
			marker.label = label;
			this.set('novo_marcador', marker);

			$.post('/api/v1/markers/', marker, function(data){
				alert("Sucesso!");
			});
		}
	}
});
