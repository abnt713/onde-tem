import Ember from 'ember';

export default Ember.Component.extend({
    classNames: ['content-wrapper'],
    mapmarkers: {},
    displayMarker: {},

    actions: {
        markerclick: function(marker){
            var self = this;
            var lat = marker.latitude;
            var lon = marker.longitude;
            console.log(marker);

            var data = new Ember.RSVP.Promise(function(resolve){
    			$.get('http://nominatim.openstreetmap.org/reverse', 'format=json&lat=' + lat +'&lon=' + lon + '&zoom=18&addressdetails=1', function(data){
    				resolve(data);
    			}, 'json');
    		});

            data.then(function(data){
                console.log(data);
                marker.address = data.display_name;
                self.set('displayMarker', marker);
            });

			$('.marker-desc-wrapper').show();
		},

        new_marker: function(latlng){
            this.sendAction('new_marker', latlng);
        },
        save_marker: function(label){
			this.sendAction('save_marker', label);
		},
    }
});
