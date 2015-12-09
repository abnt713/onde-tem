import Ember from 'ember';

export default Ember.Component.extend({
    classNames: ['content-wrapper'],
    mapmarkers: {},
    displayMarker: {},

    clone: function(marker){
        return {
            "id": marker.id,
            "latitude": marker.latitude,
            "longitude": marker.longitude,
            "label": marker.label,
            "positiveCount": marker.positiveCount,
            "negativeCount": marker.negativeCount,
            "address": marker.address
        };
    },

    actions: {
        markerclick: function(marker){
            var self = this;
            var lat = marker.latitude;
            var lon = marker.longitude;

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

        change_rating: function(value){
            var markerId = this.get('displayMarker').id;
            var data = new Ember.RSVP.Promise(function(resolve){
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: '/api/v1/markers/' + markerId + '/rate',
                    data: JSON.stringify({
                        'score': value
                    }),
                    dataType: "json",
                    success: function(data){
                        resolve(data);
                    }
                });
    		});

            var self = this;

            data.then(function(data){
                var marker = self.get('displayMarker');
                marker.positiveCount = data.positiveCount;
                marker.negativeCount = data.negativeCount;

                var clone = self.clone(marker);
                self.set('displayMarker', clone);

                console.log(self.get('displayMarker'));
                self.sendAction('reload');
            });
        }
    }
});
