import Ember from 'ember';

export default Ember.Component.extend({
    classNames: ['marker-desc-wrapper'],

    total: Ember.computed('displayMarker', function(){
        return this.get('displayMarker').positiveCount + this.get('displayMarker').negativeCount;
    }),
    positive: Ember.computed('displayMarker', function(){
        return this.get('displayMarker').positiveCount;
    }),
    negative: Ember.computed('displayMarker', function(){
        return this.get('displayMarker').negativeCount;
    }),
    positiveProgress: Ember.computed('total', 'positive', function(){
        return (this.get('positive') * 100) / this.get('total');
    }),
    negativeProgress: Ember.computed('total', 'positive', function(){
        return (this.get('negative') * 100) / this.get('total');
    }),

    actions: {
        rating_up: function(){
            this.sendAction('change_rating', 1);
        },
        rating_down: function(){
            this.sendAction('change_rating', -1);
        }
    }
});
