Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'Employees',
    views: ['Employees.view.EmployeeMaster'],
    controllers: ['EmployeeMaster2'],

    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
            {
                xtype: 'EmployeeMaster'
            }]
        });
    }
});