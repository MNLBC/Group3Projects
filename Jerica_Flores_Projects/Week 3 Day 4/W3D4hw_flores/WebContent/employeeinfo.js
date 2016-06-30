Ext.application({
    requires: ['Ext.container.Viewport' ],
    name : 'Company',
    controllers : ['EmployeeInfo'],

    launch: function () {
        
        Ext.create('Ext.container.Viewport', 
        {
            layout : 'anchor',
            items : [{
                xtype: 'EmployeeInfo'
            }]
        });
    }
});