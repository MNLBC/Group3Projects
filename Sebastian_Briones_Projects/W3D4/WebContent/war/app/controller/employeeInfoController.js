/*
 * File: app/controller/employeeInfoController.js
 *
 * This file was generated by Sencha Architect version 3.0.4.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 4.2.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 4.2.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('W3D4.controller.employeeInfoController', {
    extend: 'Ext.app.Controller',

    refs: [
        {
            ref: 'employeeInfoForm',
            selector: '#employeeInfoForm'
        }
    ],

    onAddEmployee: function(button, e, eOpts) {
        var employeeStore = Ext.getStore('employeeStore');
        var record = Ext.create('W3D4.model.Employee',{
            "id": this.idTextBox.getValue(),
            "firstname": this.firstNameText.getValue(),
            "middlename": this.middleNameText.getValue(),
            "lastname": this.lastNameText.getValue(),
            "birthdate": this.birthDate.getValue(),
            "city": this.stateTextArea.getValue(),
            "state": this.cityTextArea.getValue()
        } );

        employeeStore.add(record);


        Ext.Msg.alert('Status', 'Employee saved successfully.');

        this.idTextBox.setValue('');
        this.firstNameText.setValue('');
        this.middleNameText.setValue('');
        this.lastNameText.setValue('');
        this.birthDate.setValue('');
        this.stateTextArea.setValue('');
        this.cityTextArea.setValue('');
    },

    onLaunch: function() {
        this.employeeInfoForm = this.getEmployeeInfoForm();

        this.idTextBox = this.employeeInfoForm.query('#empId')[0];


        this.firstNameText = this.employeeInfoForm.query('#empFirstname')[0];
        this.middleNameText = this.employeeInfoForm.query('#empMiddlename')[0];
        this.lastNameText = this.employeeInfoForm.query('#empLastname')[0];
        this.birthDate = this.employeeInfoForm.query('#empBirthdate')[0];
        this.stateTextArea = this.employeeInfoForm.query('#empState')[0];
        this.cityTextArea = this.employeeInfoForm.query('#empCity')[0];

        var employeeStore = Ext.getStore('employeeStore');
        var record = Ext.create('W3D4.model.Employee',{
            "id": "1",
            "firstname": "Bes",
            "middlename": "Snakey",
            "lastname": "Moves",
            "birthdate": "",
            "city": 'Manila',
            "state": 'Philippines'
        } );

        employeeStore.add(record);


    },

    init: function(application) {
        this.control({
            "#btnCreateEmployee": {
                click: this.onAddEmployee
            }
        });
    }

});
