Ext.define('Employees.controller.HomePage', {
	extend : 'Ext.app.Controller',
	views : [ 'Employees.view.HomePage' ],

	refs : [ {
		ref : 'homePageForm',
		selector : 'viewport > HomePage'
	} ],

	init : function() {
		this.control({

			'viewport > HomePage button[itemId=buttonPage1]' : {
				click : this.onPage1Click
			},
			'viewport > HomePage button[itemId=buttonPage2]' : {
				click : this.onPage2Click
			},
			'viewport > HomePage button[itemId=buttonPage3]' : {
				click : this.onPage3Click
			}
		});
	},
	onPage1Click : function() {
		window.location.assign("/W3D4_homework/EmployeeInfo.html");

	},
	onPage2Click : function() {
		window.location.assign("/W3D4_homework/EmployeeCreate.html");
	},
	onPage3Click : function() {
		window.location.assign("/W3D4_homework/EmployeeCreate.html");
	}
});