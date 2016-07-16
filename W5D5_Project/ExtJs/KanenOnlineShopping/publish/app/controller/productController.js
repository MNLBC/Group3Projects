/*
 * File: app/controller/productController.js
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

Ext.define('KanenOnlineShopping.controller.productController', {
    extend: 'Ext.app.Controller',

    id: 'productController',

    refs: [
        {
            ref: 'bodyContainer',
            selector: '#bodyContainer'
        },
        {
            ref: 'mainContainer',
            selector: '#mainContainer'
        },
        {
            ref: 'orderHistoryContainer',
            selector: '#orderHistoryContainer'
        },
        {
            ref: 'frmLogin',
            selector: '#frmLogin'
        },
        {
            ref: 'frmRegister',
            selector: '#frmRegister'
        },
        {
            ref: 'registerWindow',
            selector: '#registerWindow'
        },
        {
            ref: 'loginWindow',
            selector: '#loginWindow'
        }
    ],

    onBtnBuyClicked: function(button, e, eOpts) {
        var isUserLoggedIn = (Ext.getStore('userStore').count() > 0);

        if(isUserLoggedIn){
           Ext.Msg.confirm('Place Order', 'Order these items?', function(btn)
           {
              if(btn=='yes'){
                  Ext.MessageBox.alert('','Order successfully created. Please wait for confirmation.');
              }

           }, this, true);

        }else{
           Ext.MessageBox.alert('','You must be logged on to order.');
        }

    },

    clearCart: function(button, e, eOpts) {
        var cartStore = Ext.getStore('cartStore');

        if(cartStore.count() > 0){

            Ext.Msg.confirm('Clear Cart', 'Remove all items from your cart?', function(btn)
        	{
        	if(btn=='yes'){
        		Ext.getStore('cartStore').removeAll();
        		Ext.MessageBox.alert('','Cart cleared!');
        	}

        	}, this, true);

        }else{
            Ext.MessageBox.alert('','Your cart is empty!');
        }


    },

    onOrderItemsGridPanelItemDblClick: function(dataview, record, item, index, e, eOpts) {

        alert('Sample');
        Ext.create('Ext.window.Window',{

                       rendetTo: Ext.getBody(),
                       bodyPadding: 10,
                       title: 'Order Summary',
                       closable: true,
                       autoShow: true,
                       resizable: false,
                       modal: true,
                       draggable: false,
                       width:1054,
                       height:600,
                       items:[ {

                                            xtype: 'gridpanel',
                                            itemId: 'orderSummaryGridPanel',
                                            title: 'Transactions',
                                            store: 'orderItemStore',
                                            columns: [
                                                {
                                                    xtype: 'numbercolumn',
                                                    width: 500,
                                                    dataIndex: 'productId',
                                                    text: 'Product Id',
                                                    format: '0,000'
                                                },
                                                 {
                                                    xtype: 'gridcolumn',
                                                    width: 200,
                                                    dataIndex: 'productName',
                                                    text: 'Product Name'
                                                },

                                                {
                                                    xtype: 'gridcolumn',
                                                    width: 310,
                                                    dataIndex: 'productDescription',
                                                    text: 'Product Description'
                                                },
                                               {
                                                    xtype: 'numbercolumn',
                                                    width: 272,
                                                    dataIndex: 'quantity',
                                                    text: 'Quantity'
                                                },
                                               {
                                                    xtype: 'numbercolumn',
                                                    width: 272,
                                                    dataIndex: 'productPrice',
                                                    text: 'Price'
                                                }
                                            ]
                                }
                              ]
        });
    },

    btnMainLoginClicked: function(button, e, eOpts) {
        this.loginWindow.show();
    },

    btnLoginClicked: function(button, e, eOpts) {

        // debugger;
        // this.loginWindow = Ext.getCmp('LogiNwindow');
        //this.frmLogin = this.getFrmLogin();

        var frmLogin = Ext.getCmp('frmLogin');
        var userName = frmLogin.query('#txtLoginUsername')[0].getValue();
        var userPassword = frmLogin.query('#txtLoginPassword')[0].getValue();
        var userStore  = Ext.getStore('userStore');
        userStore.removeAll();

        Ext.Ajax.request({

             url: window.location.pathname +'user/login',
             method: 'POST',

             params: {
             userName: userName,
             userPassword: userPassword
         },
             scope: this,
             success: function(response){


                 var responseText = Ext.decode(response.responseText);
                 var responseData = responseText.data;
                 var user = responseData.user[0];

                 var loggedInUser = {
                     userId: user.userId,
                     userName: user.userName,
                     userFullName: user.fullName,
                     userEmail: user.email,
                     userAddress: user.address,
                     userMobileNumber : user.mobileNumber,
                     userRole: user.userRole,
                     userPassword: ''
                 };

                 userStore.add(loggedInUser);

                 Ext.getCmp('btnMainLogin').hide();
                 Ext.getCmp('btnMainRegister').hide();
                 Ext.getCmp('btnMainLogout').show();

                 Ext.getCmp('loginWindow').hide();
                    debugger;
                 Ext.getCmp('loginToolbar').doLayout();

                 Ext.Msg.alert('Status', 'Logged in successfully');

             },
             failure: function(){
                 Ext.MessageBox.alert('Login failed', 'Unable to connect to server, please try again.');
             }
         });

    },

    onBtnMainRegisterClick: function(button, e, eOpts) {
        // var windowReg = Ext.create('KanenOnlineShopping.view.RegisterWindow', {});
        this.registerWindow.show();
    },

    onBtnRegRegisterClick: function(button, e, eOpts) {
        var frmRegister = Ext.getCmp('frmRegister');
        var userName = frmRegister.query('#txtRegUsername')[0].getValue();
        var password = frmRegister.query('#txtRegPassword')[0].getValue();
        var confirmPassword = frmRegister.query('#txtRegConfirmPassword')[0].getValue();
        var fullName = frmRegister.query('#txtRegFullname')[0].getValue();
        var email = frmRegister.query('#txtRegEmail')[0].getValue();
        var address = frmRegister.query('#txtRegAddress')[0].getValue();
        var contactNumber = frmRegister.query('#txtRegContactNumber')[0].getValue();
        var userRole = 'Customer';
        var userStore = Ext.getStore('userStore');


        Ext.Ajax.Request({

            url: '/user/register',
            method: POST,

            params: {
                userName: userName,
                userPassword: userPassword,
                fullName: fullName,
                email: email,
                deliveryAddress: address,
                mobileNumber: contactNumber,
                userRole: userRole
        },
            scope: this,
            success: function(response){
                var responseText = JSON.parse(response.responseText);
                alert(responseText.data);
        //         responseText.u
            }
        });





        if(frmRegister.isValid()){
                    if(password == confirmPassword){
                        if(this.checkIfUserExist(userName, userStore)){
                            return;
                        }else{
                            var user = {
                                //    userId: this.userIdSequence+=1,
                                    userName: userName,
                                    userPassword: password,
                                    userFullName: fullName,
                                    userEmail: email,
                                    userAddress: address,
                                    userMobileNumber: mobileNumber
                                // userRole
                                // userAddress
                            };
                            userStore.add(user);
                            Ext.MessageBox.alert('Registation','Account Created, You are now registered!');
                            this.resetRegistrationFields();
                            frmRegister.hide();
                        }
                    }else{
                        Ext.MessageBox.alert('Invalid confirmPassword','Passowrd does not match');
                    }
                }else{
                    Ext.MessageBox.alert('','Invalid!');
                }

    },

    onBtnRegResetClick: function(button, e, eOpts) {
        this.resetRegistrationFields();
    },

    onBtnRegCancelClick: function(button, e, eOpts) {
        // var registerWindow = Ext.getCmp('registerWindow');
        this.registerWindow.hide();
    },

    onBtnLoginCancelClick: function(button, e, eOpts) {
        this.loginWindow.hide();

    },

    onBtnLoginRegisterClick: function(button, e, eOpts) {

        this.loginWindow.hide();
        this.registerWindow.show();


    },

    onBtnMainLogoutClicked: function(button, e, eOpts) {
        Ext.getCmp('btnMainLogin').show();
        Ext.getCmp('btnMainRegister').show();
        Ext.getCmp('btnMainLogout').hide();


        Ext.getCmp('loginToolbar').doLayout();
        var userStore  = Ext.getStore('userStore');
        userStore.removeAll();

        Ext.Msg.alert('Status', 'Signing out.');

    },

    onViewOrderHistoryClicked: function(label) {
        this.getMainContainer().hide();


    },

    onBtnMainCheckoutClicked: function(button, e, eOpts) {
        var cartStore = Ext.getStore('cartStore');

        if(cartStore.count() > 0){

            var totalCost = 0.00;
            cartStore.each(function(record){
                totalCost = totalCost + record.data.productPrice;
            });


            Ext.getCmp('lblCheckoutTotalCost').text = '$' + totalCost;
            this.cartWindow.show();
        }else{
            Ext.MessageBox.alert('','Your cart is empty!');
        }


    },

    onCartWindowCancelClicked: function(button, e, eOpts) {
        this.cartWindow.hide();
    },

    onLaunch: function() {

        this.bodyContainer = this.getBodyContainer();
        this.productContainer = Ext.getCmp('productContainer');

        this.productStore = Ext.getStore('productsStore');
        this.loadProducts(this.productStore);
        this.registerWindow = Ext.create('KanenOnlineShopping.view.RegisterWindow', {});
        this.registerWindow.hide();

        this.loginWindow = Ext.create('KanenOnlineShopping.view.LoginWindow',{});
        this.loginWindow.hide();

        this.cartWindow = Ext.create('KanenOnlineShopping.view.CartWindow',{});
        this.cartWindow.hide();

        Ext.getCmp('btnMainLogout').hide();
    },

    loadProducts: function(productStore) {
        Ext.Ajax.request({
            url: 'product/productList',
            method: 'POST',
            params: {

            },
            success: function(response){

                var responseData = Ext.decode(response.responseText).data;

                for(var i=0; i < responseData.products.length; i++){
                    var product = {
                       productId: responseData.products[i].productId,
                       productName: responseData.products[i].productName,
                       productDescription: responseData.products[i].productDescription,
                       productPrice: responseData.products[i].productPrice,
                       productStockQuantity: responseData.products[i].productStockQuantity,
                       productImagePath: responseData.products[i].imagePath

                 };
                    productStore.add(product);
                }
                var productPanel = Ext.getCmp('productPanel');
            productStore.each(function(record){
            var mystr ='';


          var itemContainer = Ext.create('KanenOnlineShopping.view.itemContainer', {

          });

          itemContainer.productId = record.data.productId;
          itemContainer.productName = record.data.productName;
          itemContainer.productDescription = record.data.productDescription;
          itemContainer.productPrice = record.data.productPrice;
          itemContainer.productStockQuantity = record.data.productStockQuantity;
          itemContainer.productImagePath = record.data.productImagePath;

          var itemImage = itemContainer.items.items[0];
          itemImage.src = record.data.productImagePath;

          var itemNameLabel = itemContainer.items.items[1];
          itemNameLabel.text = record.data.productName + record.data.productDescription;

          //var itemDescriptionLabel = itemContainer.items.items[2];
          //itemDescriptionLabel.text = record.data.productDescription;
          var itemBtn = itemContainer.items.items[2];


           // debugger;
          itemBtn.tooltip=record.data.productDescription;

          productPanel.add(itemContainer);
          productPanel.doLayout();


        });

            }
        });


        /*
        var productPanel = Ext.getCmp('productPanel');
        productStore.each(function(record){
            var mystr ='';

           // debugger;

          var itemContainer = Ext.create('KanenOnlineShopping.view.itemContainer', {

          });

          itemContainer.productId = record.data.productId;
          itemContainer.productName = record.data.productName;
          itemContainer.productDescription = record.data.productDescription;
          itemContainer.productPrice = record.data.productPrice;
          itemContainer.productStockQuantity = record.data.productStockQuantity;
          itemContainer.productImagePath = record.data.productImagePath;

          var itemImage = itemContainer.items.items[0];
          itemImage.src = record.data.productImagePath;

          var itemNameLabel = itemContainer.items.items[1];
          itemNameLabel.text = record.data.productName + record.data.productDescription;

          //var itemDescriptionLabel = itemContainer.items.items[2];
          //itemDescriptionLabel.text = record.data.productDescription;
          var itemBtn = itemContainer.items.items[2];


           // debugger;
          itemBtn.tooltip=record.data.productDescription;

          productPanel.add(itemContainer);
          productPanel.doLayout();


        });
        */

    },

    addItemToCart: function(productId, productName, productDescription, productPrice, productStockQuantity, productImagePath) {
        //alert(productName);

        var cartStore = Ext.getStore('cartStore');
        var itemAlreadyInCart = false;
        var recordInCart;
        cartStore.each(function(record){
            if(record.data.productId == productId){


               record.data.quantity = record.data.quantity + 1;
               itemAlreadyInCart = true;
            }
        });

        if(itemAlreadyInCart){
           Ext.getCmp('cartGrid').getView().refresh();
           Ext.Msg.alert('Status', 'Item quantity increased.');

        }else{

           var item = {
           productId: productId,
           productName:productName,
           productDescription: productDescription,
           productPrice:productPrice,
           quantity:1,
           productImagePath:productImagePath

           };
              cartStore.add(item);
              Ext.Msg.alert('Status', 'Item added to cart.');

        }
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

    },

    loginAccount: function() {

    },

    resetRegistrationFields: function() {

                var frmRegister = Ext.getCmp('frmRegister');

                frmRegister.query('#txtRegUsername')[0].setValue('');
                frmRegister.query('#txtRegPassword')[0].setValue('');
                frmRegister.query('#txtRegConfirmPassword')[0].setValue('');
                frmRegister.query('#txtRegFullname')[0].setValue('');
                frmRegister.query('#txtRegEmail')[0].setValue('');
                frmRegister.query('#txtRegAddress')[0].setValue('');
                frmRegister.query('#txtRegContactNumber')[0].setValue('');
        //frmRegister.invalidate();
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

    init: function(application) {
        this.control({
            "#btnBuy": {
                click: this.onBtnBuyClicked
            },
            "#btnClearCart": {
                click: this.clearCart
            },
            "#orderItemsGridPanel": {
                itemdblclick: this.onOrderItemsGridPanelItemDblClick
            },
            "#btnMainLogin": {
                click: this.btnMainLoginClicked
            },
            "#btnLogin": {
                click: this.btnLoginClicked
            },
            "#btnMainRegister": {
                click: this.onBtnMainRegisterClick
            },
            "#btnRegRegister": {
                click: this.onBtnRegRegisterClick
            },
            "#btnRegReset": {
                click: this.onBtnRegResetClick
            },
            "#btnRegCancel": {
                click: this.onBtnRegCancelClick
            },
            "#btnLoginCancel": {
                click: this.onBtnLoginCancelClick
            },
            "#btnLoginRegister": {
                click: this.onBtnLoginRegisterClick
            },
            "#btnMainLogout": {
                click: this.onBtnMainLogoutClicked
            },
            "#lblViewOrderHistory": {
                click: this.onViewOrderHistoryClicked
            },
            "#btnMainCheckout": {
                click: this.onBtnMainCheckoutClicked
            },
            "#btnCartWindowCancel": {
                click: this.onCartWindowCancelClicked
            }
        });
    }

});
