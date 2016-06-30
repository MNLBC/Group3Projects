Ext.application({
    requires: ['Ext.container.Viewport' ],
    name : 'Employees',
    controllers : ['EmployeeMaster'],

    launch: function () {
        
        Ext.create('Ext.container.Viewport', 
        {
            layout : 'anchor',
            items : [{
                xtype: 'EmployeeGrid'
            }]
        });
    }
});