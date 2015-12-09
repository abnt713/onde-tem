import Ember from 'ember';

export default Ember.Route.extend({
	currentQuery: "",

	model(){
		var self = this;
		console.log('Chamando model');
		var model = new Ember.RSVP.Promise(function(resolve){
			var query = self.get("currentQuery");
			if(query !== ""){
				query = 'q=' + query;
			}

			$.get('/api/v1/markers', query, function(data){
				resolve(data);
			}, 'json');
		});

		console.log(model);

		return model;
		// return [
		// 	{latitude:0.0, longitude:0.0, label:"center of the world"},
		// 	{latitude:0.1, longitude:-0.10, label:"other marker"},
		// 	{latitude:-5.84132, longitude:-35.19833, label: "dimap"}
		// ];
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
			var self = this;
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: '/api/v1/markers',
				data: JSON.stringify(marker),
				dataType: "json",
				success: function(){
					//Refresh model;
					self.set('currentQuery', '');
					self.refresh();
				}
			});
		},

		apisearchquery: function(query){
			this.set('currentQuery', query);
			this.refresh();
			// var self = this;
			// $.get('/api/v1/markers', '', function(data){
			// 	self.refresh();
			// }, 'json');
		}
	}
});
