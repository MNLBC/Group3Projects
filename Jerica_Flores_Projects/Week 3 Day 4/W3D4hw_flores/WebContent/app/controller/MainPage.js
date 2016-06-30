Ext.define('Company.controller.MainPage', {
    extend: 'Ext.app.Controller',
    views: ['Company.view.MainPage'],

    refs: [{
        ref: 'mainPageForm',
        selector: 'viewport > MainPage'
    }],

    init: function () {
        this.control({

            'viewport > MainPage button[itemId=btnEmpInfo]': {
                click: this.onClick
            },
            'viewport > MainPage button[itemId=btnEmpCreate]': {
                click: this.onClick2
            },
            'viewport > MainPage button[itemId=btnDynTbl]': {
                click: this.onClick3
            }
        }
            );
    },
    onClick: function () {
    	window.location.assign("/W3D4hw_flores/EmployeeInfo.html");
    },
    onClick2: function () {
    	window.location.assign("/W3D4hw_flores/EmployeeCreate.html");
    },
    onClick3: function () {
    	var component = Ext.getCmp('result');
    	var grid = Ext.create('Company.view.MyGridPanel');
    	component.add(grid);
    }
});