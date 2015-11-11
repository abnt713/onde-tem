import Ember from 'ember';

export default Ember.Route.extend({
	model(){
		return [
			{x:51.5, y:-0.09, label:"some marker"},
			{x:51.55, y:-0.10, label:"other marker"},
			{x:50.8, y:-0.07, label:"final marker"}
		];
	}

});
