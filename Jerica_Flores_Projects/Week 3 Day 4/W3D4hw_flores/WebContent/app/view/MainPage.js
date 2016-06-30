Ext.define('Company.view.MainPage', 
{
    extend : 'Ext.form.Panel',
    alias : 'widget.MainPage',
    config : {},
    constructor : function(config){
        this.initConfig(config);
        return this.callParent(arguments);
    },
    
  
    initComponent : function(){
        
        Ext.apply(this, 
        {
            items : [{
            	xtype : 'button',
                text : 'Employee Form',
                itemId : 'btnEmpInfo',
                id : 'btnEmpInfo2'
                
            }, 
            {
            	xtype : 'button',
                text : 'Employee Grid',
                itemId : 'btnEmpCreate'
            }, 
            
            {
            	xtype : 'button',
                text : 'Generate Dynamic Table',
                itemId : 'btnDynTbl'
            },
            {
            xtype: 'panel',
            region: 'center',
            id: 'result',
            title: 'My Panel',
            layout: {
                type: 'vbox',
                align: 'center',
                pack: 'center'
            }
            }
            ]
        });
        this.callParent(arguments);
    }
});