Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'Company',
    views: ['Company.view.EmployeeCreate'],
    controllers: ['EmployeeCreate'],

    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
            {
                xtype: 'EmployeeCreate'
            }]
        });
    }
});