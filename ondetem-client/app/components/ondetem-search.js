import Ember from 'ember';

export default Ember.Component.extend({
    classNames: ['marker-search-box'],

    currentQuery: "",

    actions: {
        search: function(){
            this.sendAction('search', this.get('currentQuery'));
        }
    }

});
