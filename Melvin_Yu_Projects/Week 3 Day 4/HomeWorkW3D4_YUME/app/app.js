Ext.application({
	requires : [ 'Ext.container.Viewport' ],
	name : 'Office',
	views : [ 'Office.view.EmployeeMaster' ],
	controllers : [ 'EmployeeControllerGrid', 'EmployeeControllerForm' ],

	launch : function() {
		Ext.create('Ext.panel.Panel', {
			renderTo : Ext.getBody(),
			items : [ {
				xtype : 'button',
				text : 'Display 1',
				handler : function() {
					Ext.create('Ext.container.Viewport', {
						layout : 'fit',
						items : [ {
							xtype : 'EmployeeMaster'
						} ]
					});
				}
			}, {
				xtype : 'button',
				text : 'Display 2',
				handler : function() {
					Ext.create('Ext.container.Viewport', {
						layout : 'fit',
						items : [ {
							xtype : 'EmployeeGrid'
						} ]
					});
				}
			},

			{
				xtype : 'button',
				text : 'Display 3',
				handler : function() {
					Ext.create('Ext.grid.Panel', {
					    title: 'Melvin Awesome',
					    store: Ext.data.StoreManager.lookup('melvinStore'),
					    columns: [
					        { text: 'Name',  dataIndex: 'name' },
					        { text: 'Email', dataIndex: 'email', flex: 1 },
					        { text: 'Phone', dataIndex: 'phone' }
					    ],
					    height: 300,
					    width: 500,
					    renderTo: Ext.getBody()
					});
				}
			}]
		});
	}
});