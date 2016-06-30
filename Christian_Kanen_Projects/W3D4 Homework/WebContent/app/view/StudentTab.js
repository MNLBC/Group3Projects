Ext.define('School.view.StudentTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'School.view.StudentGrid', 'School.view.StudentMaster',
			'Ext.tab.Tab', 'Ext.form.Panel', 'Ext.grid.Panel' ],

	width : '100%',
	height : '90%',
	activeTab : 0,
	plain : true,

	initComponent : function() {

		Ext.applyIf(this, {
			items : [
					{
						xtype : 'panel',
						title : 'Students Information',
						items : [ {
							xtype : 'StudentGrid'
						} ]
					},
					{
						xtype : 'panel',
						title : 'Student Information Reg',
						items : [ {
							xtype : 'StudentMaster'
						} ]
					},
					{
						xtype : 'panel',
						title : 'Generate Table Dynamically',
						width : '100%',
						height : 400,
						items : [ {
							data : {
								columns : [ {
									"name" : "ColA"
								}, {
									"name" : "ColB"
								}, {
									"name" : "ColC"
								} ],
								rows : [ {
									"valueA" : "Row 1A",
									"valueB" : "Row 1B",
									"valueC" : "Row 1C"
								} ]
							},
							tpl : new Ext.XTemplate("<table border='1'>"
									+ "<tr>" + "<tpl for='columns'>"
									+ "<th>{name}</th>" + "</tpl>"
									+ "<tpl for='rows'>" + "<tr>"
									+ "<td>{valueA}</td>" + "<td>{valueB}</td>"
									+ "<td>{valueC}</td>" + "</tr>" + "</tpl>"
									+ "<tr>" + "</table>")
						} ]
					} ]
		});

		this.callParent(arguments);
	}
});