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
        }
    ],

    clearCart: function(button, e, eOpts) {
        // Ext.getCmp('myViewport').hide();

        //debugger;
        alert('');
        //var orderHistoryContainer = Ext.getCmp('orderHistoryContainer');

          //  this.orderHistoryContainer = Ext.create('KanenOnlineShopping.view.orderHistoryContainer', {

         //   });

        //this.orderHistoryContainer.show();
        // Ext.getCmp('orderViewport').show();

        this.getMainContainer().hide();
        debugger;
        // this.getOrderHistoryContainer().show();
        alert('');
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
        // Ext.create('Ext.window.Window',
        //            {
        //                renderTo : Ext.getBody(),
        //                bodyPadding: 10,
        //                title: 'Login Window',
        //                id: 'loginWindow',
        //                itemId: 'loginWindow',
        //                closable: true,
        //                autoShow: true,
        //                resizable: false,
        //                width:430,
        //                height:200,
        //    items: [
        //                 {
        //                     xtype: 'form',
        //                     height: 152,
        //                     id: 'frmLogin',
        //                     itemId: 'frmLogin',
        //                     width: 376,
        //                     bodyPadding: 10,
        // //                     title: 'Login',
        //                     items: [
        //                         {
        //                             xtype: 'textfield',
        //                             anchor: '100%',
        //                             id: 'txtLoginUsername',
        //                             itemId: 'txtLoginUsername',
        //                             fieldLabel: 'Username:'
        //                         },
        //                         {
        //                             xtype: 'textfield',
        //                             anchor: '100%',
        //                             id: 'txtLoginPassword',
        //                             itemId: 'txtLoginPassword',
        //                             fieldLabel: 'Password'
        //                         }
        //                     ],
        //                     dockedItems: [
        //                         {
        //                             xtype: 'toolbar',
        //                             dock: 'bottom',
        //                             items: [
        //                                 {
        //                                     xtype: 'tbspacer',
        //                                     width: 150
        //                                 },
        //                                 {
        //                                     xtype: 'button',
        //                                     id: 'btnLoginRegister',
        //                                     itemId: 'btnLoginRegister',
        //                                     width: 70,
        //                                     text: 'Register'
        //                                 },
        //                                 {
        //                                     xtype: 'button',
        //                                     id: 'btnLogin',
        //                                     itemId: 'btnLogin',
        //                                     width: 70,
        //                                     text: 'Login'
        //                                 },
        //                                 {
        //                                     xtype: 'button',
        //                                     id: 'btnLoginCancel',
        //                                     itemId: 'btnLoginCancel',
        //                                     width: 70,
        //                                     text: 'Cancel'
        //                                 }
        //                             ]
        //                         }
        //                     ]
        //                 }
        //             ]

        //            });

        // // this.frmLogin = this.getFrmLogin();
        debugger;
        var frmLogin = Ext.create('KanenOnlineShopping.view.LoginWindow',{});
        frmLogin.show();
    },

    btnLoginClicked: function(button, e, eOpts) {
        alert('HAHA');
        // debugger;
        // this.loginWindow = Ext.getCmp('LogiNwindow');
        //this.frmLogin = this.getFrmLogin();

        var frmLogin = Ext.getCmp('frmLogin');
        var userName = frmLogin.query('#txtLoginUsername')[0].getValue();
        var userPassword = frmLogin.query('#txtLoginPassword')[0].getValue();
        //var userStore  = Ext.getStore('userStore');

        Ext.Ajax.Request({

            url: '/user/login',
            method: POST,

            params: {
            userName: userName,
            userPassword: userPassword
        },
            scope: this,
            success: function(response){
                var responseText = JSON.parse(response.responseText);
                alert(responseText.data);
        //         responseText.u
            }
        });



        // if(validateAccount(userName, password, userStore)){
        //     frmLogin.query('#txtLoginUsername')[0].setValue('');
        //     frmLogin.query('#txtPassword')[0].setValue('');


        //     var userNameArray = userStore.queryBy(function(record){
        //                         return record.data.userName == userName;
        //                     });

        //      this.userId = userNameArray.items[0].data.userId;
        //      this.userFullName = userNameArray.items[0].data.fullName;
        // }else{
        //     Ext.MessageBox.alert('Login failed', 'Enter valid username or password');
        // }


        alert(userName);
    },

    onBtnMainRegisterClick: function(button, e, eOpts) {
        debugger;
        alert('register!');
        var frmReg = Ext.create('KanenOnlineShopping.view.RegisterWindow', {});
        frmReg.show();
    },

    onBtnRegRegisterClick: function(button, e, eOpts) {
        alert('Clicked!');
        var frmRegister = Ext.getCmp('frmRegister');
        var userName = frmRegister.query('#txtRegUsername')[0].getValue();

    },

    onLaunch: function() {

        this.bodyContainer = this.getBodyContainer();
        this.productContainer = Ext.getCmp('productContainer');

        this.productStore = Ext.getStore('productsStore');
        this.loadProducts(this.productStore);

    },

    loadProducts: function(productStore) {
        var mystr ='';

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
           debugger;
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

    init: function(application) {
        this.control({
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
            }
        });
    }

});
