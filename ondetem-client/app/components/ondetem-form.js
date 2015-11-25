import Ember from 'ember';

export default Ember.Component.extend({
    classNames: ['marker-details-wrapper'],

    marcador: {},

    actions: {
        novo_marcador: function(){
            this.sendAction('novo_marcador', this.get('marcador').label);
            $('.marker-details-wrapper').hide();
        }
    },

    didInsertElement: function(){
        this.set('marcador', {label: ''});
        console.log(this.get('marcador'));
    }
});
