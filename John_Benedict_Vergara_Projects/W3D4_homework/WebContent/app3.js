Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'Employees',
    views: ['Employees.view.HomePage'],
    controllers: ['HomePage'],

    launch: function () {
        Ext.create('Ext.container.Viewport', {
            items: [
            {
                xtype: 'HomePage'
            }]
        });
    }
});