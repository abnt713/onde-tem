import Ember from 'ember';

export default Ember.Route.extend({
	model(){
		return [
			{latitude:0.0, longitude:0.0, label:"center of the world"},
			{latitude:0.1, longitude:-0.10, label:"other marker"},
			{latitude:-5.84132, longitude:-35.19833, label: "dimap"}
		];
	}
});
