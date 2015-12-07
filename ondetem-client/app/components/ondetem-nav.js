import Ember from 'ember';

export default Ember.Component.extend({
    actions: {
        searchquery: function(query){
            this.sendAction('searchquery', query);
        }

    }
});
