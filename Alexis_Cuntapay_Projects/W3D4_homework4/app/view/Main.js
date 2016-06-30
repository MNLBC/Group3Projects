Ext.define('Company.view.Main', {
	extend : 'Ext.form.Panel',
	alias : 'widget.Main',
	config : {},
	constructor : function(config) {
		this.initConfig(config);
		return this.callParent(arguments);
	},

	initComponent : function() {

		Ext.apply(this, {
			items : [ {
				xtype : 'button',
				text : 'Employee First Page',
				itemId : 'buttonOne'
			}, {
				xtype : 'button',
				text : 'Employee Second Page',
				itemId : 'buttonTwo'
			},

			{
				xtype : 'button',
				text : 'Third Page',
				itemId : 'buttonThree'
			} ]
		});
		this.callParent(arguments);
	}
});