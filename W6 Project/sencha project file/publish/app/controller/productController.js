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
         var userStore =Ext.getStore('userStore');
                 var isUserLoggedIn = ( userStore.count() > 0);

                 if(isUserLoggedIn){
                    Ext.Msg.confirm('Place Order', 'Order these items?', function(btn)
                    {
                       if(btn=='yes'){
                           Ext.MessageBox.alert('','Order successfully created. Please wait for confirmation.');


                           var cartStore = Ext.getStore('cartStore');

                           var jsonData = '{ "userId": ' + userStore.getAt(0).data.userId;

                           jsonData += ',"items": ';
                           jsonData += Ext.encode(Ext.pluck(cartStore.data.items, 'data'));

                           var totalCost = Ext.getCmp('lblCheckoutTotalCost').text.substr(1,Ext.getCmp('lblCheckoutTotalCost').text.length);
                           jsonData += ',"totalCost": ' + totalCost;
                           jsonData += '}';


                           Ext.Ajax.request({
                              url : 'order/saveOrder',
                              method: 'POST',
                              params: {
                                  jsonData: jsonData

                              },

                              success: function (response) {
                              var responseText = Ext.decode(response.responseText);
                                  var responseeErrormsg = responseText.data.errormsg;
                                  if(responseeErrormsg == 'none'){
                                  Ext.Msg.alert("Success",'Your order has been placed.');
                                  Ext.getStore('cartStore').removeAll();
                                  }
                                  if(responseeErrormsg == 'failed'){
                                  Ext.Msg.alert("Failed",'Unable to place your order.');
                                  }


                              },

                          failure: function (response) {

                             Ext.Msg.alert("Error",'Unable to checkout cart.');
                          }
                          });


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

        // debugger;
        var orderItemsGridPanel = Ext.getCmp('orderItemsGridPanel');
        var  orderItemStore = Ext.getStore('orderItemStore');
        var selModel = orderItemsGridPanel.getSelectionModel();
        var selectedRecords = selModel.getSelection();
        var selectionCount = selModel.getCount();
        var orderId = selectedRecords[0].data.orderId;

        // for(var i =0;i<selectionCount;i++) {
        // alert(selectedRecords[i]);
        // }
        orderItemStore.clearFilter(true);
        orderItemStore.filter('orderId', orderId);
        // debugger;
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
                                            id: 'orderSummaryGridPanel',
                                            itemId: 'orderSummaryGridPanel',
                                            title: 'Transactions',
                                            store: 'orderItemStore',
                                            columns: [
                                                {
                                                    xtype: 'gridcolumn',
                                                    width: 500,
                                                    flex:1,
                                                    dataIndex: 'productId',
                                                    text: 'Product Id'
                                                },
                                                 {
                                                    xtype: 'gridcolumn',
                                                    width: 200,
                                                      flex:1,
                                                    dataIndex: 'productName',
                                                    text: 'Product Name'
                                                },

                                                {
                                                    xtype: 'gridcolumn',
                                                    width: 310,
                                                     flex:1,
                                                    dataIndex: 'productDescription',
                                                    text: 'Product Description'
                                                },
                                               {
                                                    xtype: 'numbercolumn',
                                                    width: 272,
                                                    flex:1,
                                                    dataIndex: 'quantity',
                                                    text: 'Quantity'
                                                },
                                               {
                                                    xtype: 'numbercolumn',
                                                    width: 272,
                                                    flex:1,
                                                    dataIndex: 'productPrice',
                                                    text: 'Price'
                                                }
                                            ]
                                }
                              ]
        });



        var  userStore = Ext.getStore('userStore');

        var  orderStore = Ext.getStore('orderStore');

        var orderId = orderStore.data.items[0].data.orderId;


        // Ext.Ajax.request({

        //      url: window.location.pathname +'order/userOrderDetails',
        //      method: 'POST',

        //      params: {
        //      orderId: orderId

        //  },
        //      scope: this,
        //      success: function(response){


        //          var responseText = Ext.decode(response.responseText);
        //          var responseData = responseText.data;
        //          debugger;


        //          for(var i=0; i < responseData.items.length; i++){
        //          var items = {
        //               productId: responseData.items[i].productId,
        //               productName: responseData.items[i].productName,
        //               productDescription: responseData.items[i].productDescription,
        //               quantity: responseData.items[i].quantity,
        //               productPrice: responseData.items[i].productPrice
        //         };
        //         orderItemStore.add(items);

        // }



        //      },
        //      failure: function(){
        //          Ext.MessageBox.alert('Login failed', 'Unable to connect to server, please try again.');
        //      }
        //  });

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

                 if(responseData.banned == true){
                     Ext.MessageBox.alert('Login failed', 'Your account is blocked.');
                 }else if(!responseData.user[0]){
                     Ext.MessageBox.alert('Login failed', 'Invalid credentials.');
                 }else{


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
                 this.resetLoginFields();
                 Ext.getCmp('loginWindow').hide();
                 Ext.getCmp('loginToolbar').doLayout();
                 Ext.getCmp('btnHistory').show();
                 Ext.Msg.alert('Status', 'Logged in successfully');
                 }



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
        var userPassword = frmRegister.query('#txtRegPassword')[0].getValue();
        var confirmPassword = frmRegister.query('#txtRegConfirmPassword')[0].getValue();
        var fullName = frmRegister.query('#txtRegFullname')[0].getValue();
        var email = frmRegister.query('#txtRegEmail')[0].getValue();
        var address = frmRegister.query('#txtRegAddress')[0].getValue();
        var contactNumber = frmRegister.query('#txtRegContactNumber')[0].getValue();
        var userRole = 'Customer';
        //var userStore = Ext.getStore('userStore');

        if(frmRegister.isValid()){
                    if(userPassword === confirmPassword){

                            Ext.Ajax.request({

                                 url: window.location.pathname +'user/register',
                                 method: 'POST',

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
                                             var responseText = Ext.decode(response.responseText);
                                     if(responseText.data.errormsg.indexOf('none') >-1){
                                         Ext.MessageBox.alert('Registation','Account Created, You are now registered!');
                                          this.resetRegistrationFields();
                                          this.registerWindow.hide();
                                     }

                                     if (responseText.data.errormsg.indexOf('usernametaken') >-1){
                                         Ext.MessageBox.alert('Registation Failed','Username is already taken!');
                                     }

                                     if (responseText.data.errormsg.indexOf('emailtaken') >-1){
                                         Ext.MessageBox.alert('Registation Failed','Email is already taken!');
                                     }

                                 }
                                 });




                    }else{
                        Ext.MessageBox.alert('Invalid confirmPassword','Passowrd does not match');
                    }
                }else{
                    Ext.MessageBox.alert('Missing fields','Please fill-up all the fields!');
                }
    },

    onBtnRegResetClick: function(button, e, eOpts) {
        this.resetRegistrationFields();
    },

    onBtnRegCancelClick: function(button, e, eOpts) {
        // var registerWindow = Ext.getCmp('registerWindow');
        this.resetRegistrationFields();
        this.registerWindow.hide();
    },

    onBtnLoginCancelClick: function(button, e, eOpts) {
        this.resetLoginFields();
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
         var cartStore = Ext.getStore('cartStore');
                cartStore.removeAll();

        Ext.getCmp('btnHistory').hide();
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
                totalCost = totalCost + (record.data.productPrice * record.data.quantity);
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

    onBtnHistoryClick: function(button, e, eOpts) {
        this.orderHistoryContainer.show();
        this.mainContainer.hide();


        var  userStore = Ext.getStore('userStore');
        var  orderStore = Ext.getStore('orderStore');
        var  orderItemStore = Ext.getStore('orderItemStore');

        var userId = userStore.data.items[0].data.userId;

        Ext.Ajax.request({

             url: window.location.pathname +'order/userOrder',
             method: 'POST',

             params: {
             userId: userId

         },
             scope: this,
             success: function(response){


                 var responseText = Ext.decode(response.responseText);
                 var responseData = responseText.data;

                 for(var i=0; i < responseData.orders.length; i++){
                   var order = {
                      orderId: responseData.orders[i].orderId,
                      userId: responseData.orders[i].userId,
                      orderDate: responseData.orders[i].orderDate,
                      totalCost: responseData.orders[i].totalCost,
                      orderStatus: responseData.orders[i].orderStatus,
                      items: responseData.orders[i].items


                };
                      orderStore.add(order);
                 }


                 for(var i=0; i < responseData.items.length; i++){
                 var items = {
                     orderId: responseData.items[i].orderId,
                      productId: responseData.items[i].productId,
                      productName: responseData.items[i].productName,
                      productDescription: responseData.items[i].productDescription,
                      quantity: responseData.items[i].quantity,
                      productPrice: responseData.items[i].productPrice
                       };
                orderItemStore.add(items);
                 }





             },
             failure: function(){
                 Ext.MessageBox.alert('Login failed', 'Unable to connect to server, please try again.');
             }
         });

    },

    onBtnBackClick: function(button, e, eOpts) {
        Ext.getStore('orderStore').removeAll();
        Ext.getCmp('orderHistoryContainer').hide();
        this.getMainContainer().show();
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

        this.orderHistoryContainer = Ext.getCmp('orderHistoryContainer');
        this.mainContainer = Ext.getCmp('mainContainer');

        Ext.getCmp('btnMainLogout').hide();
        Ext.getCmp('btnHistory').hide();
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

    resetLoginFields: function() {
        var frmLogin = Ext.getCmp('frmLogin');

        frmLogin.query('#txtLoginUsername')[0].setValue('');
        frmLogin.query('#txtLoginPassword')[0].setValue('');
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
            },
            "#btnHistory": {
                click: this.onBtnHistoryClick
            },
            "#btnBack": {
                click: this.onBtnBackClick
            }
        });
    }

});
