Ext.define('Employees.view.HomePage', 
{
    extend : 'Ext.form.Panel',
    alias : 'widget.HomePage',
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
                text : 'Page 1',
                itemId : 'buttonPage1',
                id : 'buttonPage1'
                
            }, 
            {
            	 xtype : 'button',
                text : 'Page 2',
                itemId : 'buttonPage2'
            }, 
            
            {
            	 xtype : 'button',
                text : 'Page 3',
                itemId : 'buttonPage3'
            }]
        });
        this.callParent(arguments);
    }
});