import Ember from 'ember';

export default Ember.Component.extend({
    classNames: ['marker-details-wrapper'],

    actions: {
        novo_marcador: function(){
            console.log("Consegui! " + nome);
        }
    }
});
