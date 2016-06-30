Ext.define('Company.controller.Main', {
	extend : 'Ext.app.Controller',
	views : [ 'Company.view.Main' ],

	refs : [ {
		ref : 'MainForm',
		selector : 'viewport > Main'
	} ],

	init : function() {
		this.control({

			'viewport > Main button[itemId=buttonOne]' : {
				click : this.onClickMaster
			},
			'viewport > Main button[itemId=buttonTwo]' : {
				click : this.onClickMasterTwo
			},
			'viewport > Main button[itemId=buttonThree]' : {
				click : this.onClickThree
			}
		});
	},
	onClickMaster : function() {
		window.location.assign("/W3D4_homework4/EmployeeMaster.html");

	},
	onClickMasterTwo : function() {
		window.location.assign("/W3D4_homework4/EmployeeMasterTwo.html");
	},
	onClickThree : function() {
		window.location.assign("/W3D4_homework4/EmployeeMasterTwo.html");
	}
});