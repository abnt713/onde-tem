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

        change_rating: function(value){
            var markerId = this.get('displayMarker').id;
            var data = new Ember.RSVP.Promise(function(resolve){
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: '/api/v1/markers/' + markerId + '/rate',
                    data: {
                        'score': value
                    },
                    dataType: "json",
                    success: function(data){
                        resolve(data);
                    }
                });
    		});

            data.then(function(data){
                var marker = this.get('displayMarker');
                marker.positiveCount = data.positiveCount;
                marker.negativeCount = data.negativeCount;
            });
        }
    }
});
