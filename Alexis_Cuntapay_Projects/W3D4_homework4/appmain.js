Ext.application({
	requires : [ 'Ext.container.Viewport' ],
	name : 'Company',
	views : [ 'Company.view.Main' ],
	controllers : [ 'Main' ],

	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout : 'fit',
			items : [ {
				xtype : 'Main'
			} ]
		});
	}
});