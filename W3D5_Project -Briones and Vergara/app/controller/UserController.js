/*
 * File: app/controller/UserController.js
 *
 * This file was generated by Sencha Architect version 3.1.0.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 5.0.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 5.0.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('KatchyCars.controller.UserController', {
    extend: 'Ext.app.Controller',
    alias: 'controller.UserController',

    id: 'UserController',

    refs: {
        frmLogin: '#frmLogin',
        frmRegistration: '#frmRegistration',
        windowMainPage: '#windowMainPage',
        windowHomePage: '#windowHomePage'
    },

    control: {
        "#btnExit": {
            click: 'onBtnExitClicked'
        },
        "#btnProceed": {
            click: 'onBtnProceedClicked'
        },
        "#btnLogout": {
            click: 'onBtnLogoutClicked'
        },
        "#btnLoginRegister": {
            click: 'onBtnLoginRegisterClicked'
        },
        "#btnLogin": {
            click: 'onBtnLoginClicked'
        },
        "#btnSell": {
            click: 'onBtnSellClicked'
        },
        "#btnUpdate": {
            click: 'onBtnUpdateClicked'
        },
        "#btnBuy": {
            click: 'onBtnBuyClicked'
        },
        "#btnRegRegister": {
            click: 'onBtnRegRegisterClicked'
        },
        "#btnDelete": {
            click: 'onDeleteButtonClicked'
        }
    },

    onBtnExitClicked: function(button, e, eOpts) {
                this.windowMainPage.close();
    },

    onBtnProceedClicked: function(button, e, eOpts) {
                this.windowHomePage.hide();
                this.windowMainPage.show();
    },

    onBtnLogoutClicked: function(button, e, eOpts) {
        Ext.MessageBox.alert('Logout', 'Logout Successful!');
        this.windowMainPage.hide();
        this.frmLogin.show();

    },

    onBtnLoginRegisterClicked: function(button, e, eOpts) {
        this.frmLogin.hide();
        this.frmRegistration.show();
    },

    onBtnLoginClicked: function(button, e, eOpts) {
                var username = this.frmLogin.query('#txtLoginUsername')[0].getValue();
                var password = this.frmLogin.query('#txtLoginPassword')[0].getValue();
                var userStore = Ext.getStore('userStore');

                if(this.validateAccount(username, password, userStore)){

                    this.frmLogin.query('#txtLoginUsername')[0].setValue('');
                    this.frmLogin.query('#txtLoginPassword')[0].setValue('');
                    this.windowHomePage.show();
                    this.frmLogin.hide();

                    var userNameArray = userStore.queryBy(function(record){
                        return record.data.userName == username;
                    });

                    this.userId = userNameArray.items[0].data.userId;
                    this.userFullName = userNameArray.items[0].data.userFullName;

                }else{
                    Ext.MessageBox.alert('Login failed', 'Enter valid username or password');
                }




    },

    onBtnSellClicked: function(button, e, eOpts) {
                var carStore = Ext.getStore('carStore');
                var carRecord = {

                    itemId: '',
                    carModel:'',
                    carManufacturer: '',
                    carColor:'',
                    carYear:'',
                    carPrice: '',
                    carTransmission:'',
                    carSellerName:this.userFullName,
                    carSellerId:this.userId,

                };
                carStore.add(carRecord);
    },

    onBtnUpdateClicked: function(button, e, eOpts) {
        Ext.MessageBox.alert('','Update!!');
    },

    onBtnBuyClicked: function(button, e, eOpts) {
        Ext.MessageBox.alert('','Buy!!');
    },

    onBtnRegRegisterClicked: function(button, e, eOpts) {
        var userName  = this.frmRegistration.query('#txtRegUsername')[0].getValue();
        var password = this.frmRegistration.query('#txtRegPassword')[0].getValue();
        var confirmPassword = this.frmRegistration.query('#txtRegConfirmPassword')[0].getValue();
        var fullname = this.frmRegistration.query('#txtFullname')[0].getValue();
        var email = this.frmRegistration.query('#txtEmail')[0].getValue();
        var address = this.frmRegistration.query('#txtAddress')[0].getValue();
        var mobileNumber = this.frmRegistration.query('#txtMobileNumber')[0].getValue();

        var userStore = Ext.getStore('userStore');

        if(this.frmRegistration.isValid()){
            if(password == confirmPassword){
                if(this.checkIfUserExist(userName, userStore)){
                    return;
                }else{
                    var user = {
                            userId: this.userIdSequence+=1,
                            userName: userName,
                            userPassword: password,
                            userFullName: fullname,
                            userEmail: email,
                            userAddress: address,
                            userMobileNumber: mobileNumber
                    };
                    userStore.add(user);
                    Ext.MessageBox.alert('Registation','Account Created, You are now registered!');
                    this.resetRegistrationFields();
                    this.frmLogin.show();
                    this.frmRegistration.hide();
                }
            }else{
                Ext.MessageBox.alert('Invalid confirmPassword','Passowrd does not match');
            }
        }else{
            Ext.MessageBox.alert('','Invalid!!!!');
        }

        //Ext.MessageBox.alert('','Registered!!');
    },

    onDeleteButtonClicked: function(button, e, eOpts) {
                Ext.Msg.confirm("Warning", 'Are you sure you want to remove this listing?', function(btn)
                {
                   if(btn=='yes'){       //delete selected record
                      var carStore = Ext.getStore('carStore');
                      var carGrid = this.windowMainPage.query('#gridCarsForSale')[0];
                      var selectedRecord = carGrid.getSelectionModel().getSelection()[0];

                      if (selectedRecord) {
                          carStore.remove(selectedRecord);
                      }

                   }

                }, this, true);
    },

    onLaunch: function() {
                this.frmLogin = this.getFrmLogin();
                this.frmRegistration = this.getFrmRegistration();
                this.windowMainPage = Ext.create('KatchyCars.view.windowMainPage');
                this.windowHomePage = Ext.create('KatchyCars.view.windowHomePage');
                this.frmRegistration.hide();
                this.userIdSequence = 100001;

    },

    checkIfUserExist: function(userName, userStore) {
                var userNameArray = userStore.queryBy(function(record){
                    return record.data.userName == userName;
                });
                if(userNameArray.length > 0){
                    Ext.MessageBox.alert('User exist', 'Username already exist.');
                    return true;
                }else{
                    return false;
                }
    },

    resetRegistrationFields: function() {
        this.frmRegistration.query('#txtRegUsername')[0].setValue('');
        this.frmRegistration.query('#txtRegPassword')[0].setValue('');
        this.frmRegistration.query('#txtRegConfirmPassword')[0].setValue('');
        this.frmRegistration.query('#txtFullname')[0].setValue('');
        this.frmRegistration.query('#txtEmail')[0].setValue('');
        this.frmRegistration.query('#txtAddress')[0].setValue('');
        this.frmRegistration.query('#txtMobileNumber')[0].setValue('');

    },

    validateAccount: function(username, password, userStore) {
        var userArray = userStore.queryBy(function(record){

                if(record.data.userName == username){

                }
                return record.data.userName == username;
             });

            if(userArray.length === 0 ){
                return false;
            }else if(userArray.length > 0){
                if(userArray.items[0].data.userPassword == password){
                    return true;
                }else{
                    return false;
                }
            }

    }

});
