/*
 * File: app/controller/AdminController.js
 *
 * This file was generated by Sencha Architect version 3.1.0.
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

Ext.define('MyApp.controller.AdminController', {
    extend: 'Ext.app.Controller',

    refs: [
        {
            ref: 'productListPanel',
            selector: '#productListPanel'
        },
        {
            ref: 'customerConfirmPanel',
            selector: '#customerConfirmPanel'
        },
        {
            ref: 'orderRequestsPanel',
            selector: '#orderRequestsPanel'
        },
        {
            ref: 'viewAllOrderPanel',
            selector: '#viewAllOrderPanel'
        },
        {
            ref: 'centerContainer',
            selector: '#CenterContainer'
        },
        {
            ref: 'username',
            selector: '#txtUsername'
        },
        {
            ref: 'password',
            selector: '#txtPassword'
        },
        {
            ref: 'loginContainer',
            selector: '#loginContainer'
        },
        {
            ref: 'adminPageContainer',
            selector: '#adminContainer'
        },
        {
            ref: 'addProductContainer',
            selector: '#AddProductContainer'
        },
        {
            ref: 'userListPanel',
            selector: '#userListPanel'
        }
    ],

    onBtnCustomerRequestClick: function() {
        this.getCustomerConfirmPanel().show();
        this.getOrderRequestsPanel().hide();
        this.getViewAllOrderPanel().hide();

        var customerRequestGrid = Ext.getCmp('membershipRequestGrid');
        var customerRequestStore = customerRequestGrid.getStore();

        customerRequestStore.clearData();
        customerRequestGrid.getView().refresh();

        Ext.Ajax.request({
            url: window.location.pathname +'admin/userRequest',
            method: 'POST',

            scope: this,
            success: function(response){
                var responseText = Ext.decode(response.responseText);
                for (var ctr = 0; ctr < responseText.userRequest.length; ctr++){
                    var userRequest = {
                        userId:responseText.userRequest[ctr].userId,
                        fullName: responseText.userRequest[ctr].fullname,
                        currentMembershipLevel: responseText.userRequest[ctr].currentType,
                        requestedMembershipLevel: responseText.userRequest[ctr].requestType,
                        isForApproval: responseText.userRequest[ctr].forApproval,
                        isRequestApproved: responseText.userRequest[ctr].isApproved
                    };
                    customerRequestStore.add(userRequest);
               }
          },
            failure: function(){
                Ext.MessageBox.alert('Loading Failed','Unable to connect to server');
            }

        });
    },

    onConfirmOrderBtnClick: function() {
        this.getOrderRequestsPanel().show();
        this.getViewAllOrderPanel().hide();
        this.getCustomerConfirmPanel().hide();

        var orderGrid = Ext.getCmp('orderRequestsGrid');
        var orderGridStore = orderGrid.getStore();

        orderGridStore.remoteFilter = false;
        orderGridStore.clearFilter();
        orderGridStore.filter('orderStatus','Pending Order');

        orderGridStore.clearData();
        orderGrid.getView().refresh();

        Ext.Ajax.request({
             url: window.location.pathname +'admin/getOrders',
             method: 'POST',

            scope: this,
            success: function(response){
                  var responseText = Ext.decode(response.responseText);

               for (var ctr = 0; ctr < responseText.orderList.length; ctr++){
                    var order = {
                        orderId: responseText.orderList[ctr].order.orderId,
                        userId: responseText.orderList[ctr].userID,
                        userFullName: responseText.orderList[ctr].fullName,
                        orderDate: responseText.orderList[ctr].order.orderDate,
                        totalCost: responseText.orderList[ctr].order.totalCost,
                        orderStatus: responseText.orderList[ctr].order.orderStatus

                    };

                    orderGridStore.add(order);
                }
            },

            failure: function(){
                Ext.MessageBox.alert('Loading Failed','Unable to connect to server');
            }
        });
    },

    onBtnLoginClick: function() {
        var userName = Ext.getCmp('txtUsername').getValue();
        var userPassword = Ext.getCmp('txtPassword').getValue();
        var userStore = Ext.getStore('userStore');
        userStore.removeAll();

        Ext.Ajax.request({

            url: window.location.pathname +'admin/login',
            method: 'POST',

            params: {
                userName: userName,
                userPassword: userPassword
            },
            scope:this,
            success:function(response){
                var responseText = Ext.decode(response.responseText);

                if (responseText.success == true){
                       if (responseText.user.userRole != 'Admin'){
                            Ext.MessageBox.alert('Status', 'Unauthorized User');
                            Ext.getCmp('txtUsername').setValue();
                            Ext.getCmp('txtPassword').setValue();
                        }
                        else{

                            var loggedInUser = {
                                userId: responseText.user.userId,
                                userName: responseText.user.username,
                                userFullName: responseText.user.fullName,
                                userRole: responseText.user.userRole,
                                userPassword: ''
                            };

                            userStore.add(loggedInUser);
                            Ext.MessageBox.alert('Status', 'Logged in successfully');
                            Ext.getCmp('txtUsername').setValue();
                            Ext.getCmp('txtPassword').setValue();
                            this.getLoginContainer().hide();
                            this.getAdminPageContainer().show();

                        }
                } else {
                    Ext.MessageBox.alert('Login Failed', 'Invalid Credentials');
                    Ext.getCmp('txtUsername').setValue();
                    Ext.getCmp('txtPassword').setValue();
                }

            },
            failure:function(){
                Ext.MessageBox.alert('Login Failed', 'Unable to connect to server, Please try again.');
            }

        });
    },

    onViewAllOrderGridItemDblClick: function() {
        var viewAllOrderGrid = Ext.getCmp('viewAllOrderGrid');
                 var orderItems = Ext.getStore('orderItems');
                 var selModel = viewAllOrderGrid.getSelectionModel();
                 var selectedRecords = selModel.getSelection();
                 var selectionCount = selModel.getCount();
                 var orderId = selectedRecords[0].data.orderId;

                 orderItems.clearFilter(true);
                 orderItems.filter('orderId', orderId);
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
                                                   title: 'List of Transactions',
                                                   store: 'orderItems',
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
                        var orderStore = Ext.getStore('orderItems');
                        var orderId = orderStore.data.items[0].data.orderId;
    },

    onViewAllOrderBtnClick: function() {
        this.getOrderRequestsPanel().hide();
        this.getCustomerConfirmPanel().hide();
        this.getProductListPanel().hide();
        this.getUserListPanel().hide();
        this.getViewAllOrderPanel().show();

        var viewAllGrid = Ext.getCmp('viewAllOrderGrid');
        var viewAllGridStore = viewAllGrid.getStore();
        var orderItemsStore = Ext.getStore('orderItems');

        orderItemsStore.removeAll();
        viewAllGridStore.clearData();
        viewAllGrid.getView().refresh();


        Ext.Ajax.request({
             url: window.location.pathname +'admin/getOrders',
             method: 'POST',

            scope: this,
            success: function(response){
                var responseText = Ext.decode(response.responseText);

                for (var ctr = 0; ctr < responseText.orderList.length; ctr++){
                    var order = {
                        orderId: responseText.orderList[ctr].order.orderId,
                        userId: responseText.orderList[ctr].userID,
                        userFullName: responseText.orderList[ctr].fullName,
                        orderDate: responseText.orderList[ctr].order.orderDate,
                        totalCost: responseText.orderList[ctr].order.totalCost,
                        orderStatus: responseText.orderList[ctr].order.orderStatus

                    };

                    viewAllGridStore.add(order);
                }


                for (var i = 0; i < responseText.itemList.length; i++){
                    var items = {
                        orderId: responseText.itemList[i].orderId,
                        orderItemId: responseText.itemList[i].item.orderItemId,
                        productId: responseText.itemList[i].item.productId,
                        productName: responseText.itemList[i].productname,
                        quantity: responseText.itemList[i].item.quantity,
                        productPrice: responseText.itemList[i].item.productPrice

                    };

                    orderItemsStore.add(items);
                }
            },

            failure: function(){
                Ext.MessageBox.alert('Loading Failed','Unable to connect to server');
            }

        });
    },

    onBtnApproveRequestClick: function() {
        var userRequestGrid = Ext.getCmp('membershipRequestGrid');
        var userGridStore = userRequestGrid.getStore();
        var selectedRows = userRequestGrid.getSelectionModel().getSelection()[0];
        var rowIndex = userGridStore.indexOf(selectedRows);
        if (rowIndex >-1 ){
            var userId = selectedRows.data.userId;
            var requestedMembershipLevel = selectedRows.data.requestedMembershipLevel;
            Ext.Msg.confirm('Approve Request', 'Do you want to Approve this request?',function(btn){
                if (btn==='yes'){
        //                userGridStore.data.items[rowIndex].data.currentMembershipLevel =  userGridStore.data.items[rowIndex].data.requestedMembershipLevel;
        //                userRequestGrid.getView().refresh();
                        Ext.Ajax.request({
                            url: window.location.pathname +'update/membershipApproval',
                            method: 'POST',
                                params:{
                                userId: userId,
                                approvedType:requestedMembershipLevel,
                                isApproved:1

                                },

                        scope:this,
                        success: function(response){
                            var responseText = Ext.decode(response.responseText);

                        }

                    });

                }
            });} else {
               Ext.MessageBox.alert('Status','Please select a request to approve');
        }
    },

    onBtnRejectRequestClick: function() {
        var userRequestGrid = Ext.getCmp('membershipRequestGrid');
        var userGridStore = userRequestGrid.getStore();
        var selectedRows = userRequestGrid.getSelectionModel().getSelection()[0];
        var rowIndex = userGridStore.indexOf(selectedRows);
        if (rowIndex >-1 ){
            var userId = selectedRows.data.userId;
            var requestedMembershipLevel = selectedRows.data.requestedMembershipLevel;
            Ext.Msg.confirm('Approve Request', 'Do you want to Reject this request?',function(btn){
                if (btn==='yes'){
                      Ext.Ajax.request({
                            url: window.location.pathname +'update/membershipApproval',
                            method: 'POST',
                                params:{
                                userId: userId,
                                approvedType:requestedMembershipLevel,
                                isApproved:0

                                },

                        scope:this,
                        success: function(response){
                            var responseText = Ext.decode(response.responseText);

                        }

                    });
                    userGridStore.remove(selectedRows);
                }
            });} else {
               Ext.MessageBox.alert('Status','Please select a request ');
        }
    },

    onBtnSaveUpdatesClick: function() {


        var orderRequestsGrid = Ext.getCmp('orderRequestsGrid');
        var orderRequestsStore = orderRequestsGrid.getStore();
        var selectedRows = orderRequestsGrid.getSelectionModel().getSelection()[0];
        var rowIndex = orderRequestsStore.indexOf(selectedRows);
        if (rowIndex >-1 ){
            var orderId = selectedRows.data.orderId;
            var orderStatus = selectedRows.data.orderStatus;
            Ext.Msg.confirm('Approve Request', 'Do you want to Approve this request?',function(btn){
                if (btn==='yes'){
                        Ext.Ajax.request({
                            url: window.location.pathname +'update/updateOrderStatus',
                            method: 'POST',
                                params:{
                                    orderId: orderId,
                                    status: orderStatus
                                },

                        scope:this,
                        success: function(response){
                            var responseText = Ext.decode(response.responseText);
                             Ext.MessageBox.alert('Status','Order Updated');

                        }

                    });

                }
            });} else {
               Ext.MessageBox.alert('Status','Please select a request to approve');
        }
    },

    onMembershipRequestClick: function() {
        this.getCustomerConfirmPanel().show();
        this.getOrderRequestsPanel().hide();
        this.getViewAllOrderPanel().hide();
        this.getProductListPanel().hide();
        this.getUserListPanel().hide();


        var customerRequestGrid = Ext.getCmp('membershipRequestGrid');
        var customerRequestStore = customerRequestGrid.getStore();

        customerRequestStore.clearData();
        customerRequestGrid.getView().refresh();

        Ext.Ajax.request({
            url: window.location.pathname +'admin/userRequest',
            method: 'POST',

            scope: this,
            success: function(response){
                var responseText = Ext.decode(response.responseText);
                for (var ctr = 0; ctr < responseText.userRequest.length; ctr++){
                    var userRequest = {
                        userId:responseText.userRequest[ctr].userId,
                        fullName: responseText.userRequest[ctr].fullname,
                        currentMembershipLevel: responseText.userRequest[ctr].currentType,
                        requestedMembershipLevel: responseText.userRequest[ctr].requestType,
                        isForApproval: responseText.userRequest[ctr].forApproval,
                        isRequestApproved: responseText.userRequest[ctr].isApproved
                    };
                    customerRequestStore.add(userRequest);
               }
          },
            failure: function(){
                Ext.MessageBox.alert('Loading Failed','Unable to connect to server');
            }

        });
    },

    onOrderRequestClick: function() {
        this.getOrderRequestsPanel().show();
        this.getViewAllOrderPanel().hide();
        this.getCustomerConfirmPanel().hide();
        this.getUserListPanel().hide();
        this.getProductListPanel().hide();


        var orderGrid = Ext.getCmp('orderRequestsGrid');
        var orderGridStore = orderGrid.getStore();

        orderGridStore.remoteFilter = false;
        orderGridStore.clearFilter();
        orderGridStore.filter('orderStatus','Pending Order');

        orderGridStore.clearData();
        orderGrid.getView().refresh();

        Ext.Ajax.request({
             url: window.location.pathname +'admin/getOrders',
             method: 'POST',

            scope: this,
            success: function(response){
                  var responseText = Ext.decode(response.responseText);

               for (var ctr = 0; ctr < responseText.orderList.length; ctr++){
                    var order = {
                        orderId: responseText.orderList[ctr].order.orderId,
                        userId: responseText.orderList[ctr].userID,
                        userFullName: responseText.orderList[ctr].fullName,
                        orderDate: responseText.orderList[ctr].order.orderDate,
                        totalCost: responseText.orderList[ctr].order.totalCost,
                        orderStatus: responseText.orderList[ctr].order.orderStatus

                    };

                    orderGridStore.add(order);
                }
            },

            failure: function(){
                Ext.MessageBox.alert('Loading Failed','Unable to connect to server');
            }
        });
    },

    onViewAllOrderClick: function() {
        this.getOrderRequestsPanel().hide();
        this.getCustomerConfirmPanel().hide();
        this.getProductListPanel().hide();
        this.getUserListPanel().hide();
        this.getViewAllOrderPanel().show();

        var viewAllGrid = Ext.getCmp('viewAllOrderGrid');
        var viewAllGridStore = viewAllGrid.getStore();
        var orderItemsStore = Ext.getStore('orderItems');

        orderItemsStore.removeAll();
        viewAllGridStore.clearData();
        viewAllGrid.getView().refresh();


        Ext.Ajax.request({
             url: window.location.pathname +'admin/getOrders',
             method: 'POST',

            scope: this,
            success: function(response){
                var responseText = Ext.decode(response.responseText);

                for (var ctr = 0; ctr < responseText.orderList.length; ctr++){
                    var order = {
                        orderId: responseText.orderList[ctr].order.orderId,
                        userId: responseText.orderList[ctr].userID,
                        userFullName: responseText.orderList[ctr].fullName,
                        orderDate: responseText.orderList[ctr].order.orderDate,
                        totalCost: responseText.orderList[ctr].order.totalCost,
                        orderStatus: responseText.orderList[ctr].order.orderStatus

                    };

                    viewAllGridStore.add(order);
                }


                for (var i = 0; i < responseText.itemList.length; i++){
                    var items = {
                        orderId: responseText.itemList[i].orderId,
                        orderItemId: responseText.itemList[i].item.orderItemId,
                        productId: responseText.itemList[i].item.productId,
                        productName: responseText.itemList[i].productname,
                        quantity: responseText.itemList[i].item.quantity,
                        productPrice: responseText.itemList[i].item.productPrice

                    };

                    orderItemsStore.add(items);
                }
            },

            failure: function(){
                Ext.MessageBox.alert('Loading Failed','Unable to connect to server');
            }

        });
    },

    onProductsClick: function() {
        this.getOrderRequestsPanel().hide();
                this.getCustomerConfirmPanel().hide();
                this.getViewAllOrderPanel().hide();
                this.getProductListPanel().show();

                var productGrid = Ext.getCmp('productListGrid');
                var productGridStore = productGrid.getStore();

                productGridStore.removeAll();
                productGridStore.clearData();
                productGrid.getView().refresh();


                Ext.Ajax.request({
                     url: window.location.pathname +'admin/getProducts',
                     method: 'POST',

                    scope: this,
                    success: function(response){
                        var responseText = Ext.decode(response.responseText);


                        for (var i = 0; i < responseText.productList.length; i++){
                            var items = {
                                productId: responseText.productList[i].productId,
                                productName: responseText.productList[i].productName,
                                productDescription: responseText.productList[i].productDescription,
                                productPrice: responseText.productList[i].productPrice,
                                productStockQuantity: responseText.productList[i].productStockQuantity,
                                productImagePath: responseText.productList[i].productImagePath
                            };

                            productGridStore.add(items);
                        }
                    },

                    failure: function(){
                        Ext.MessageBox.alert('Loading Failed','Unable to connect to server');
                    }

                });
    },

    onLogoutClick: function() {
                var userStore  = Ext.getStore('userStore');
                userStore.removeAll();
                Ext.Msg.alert('Status', 'Signing out.');

                this.getAdminPageContainer().hide();
                this.getLoginContainer().show();
    },

    onBtnAddProductClick: function() {
        var adminAddProduct = Ext.create('MyApp.view.AdminAddProductWindow', {});
        adminAddProduct.show();

    },

    onBtnUpdateProductClick: function() {
        updatedProduct = [];
        var productListGrid = Ext.getCmp('productListGrid');
        var productListStore = productListGrid.getStore();
        var updatedRecords = productListStore.getModifiedRecords();
        var updateProduct = Ext.getStore('updateProduct');
        Ext.each(updatedRecords,function(record){
            if (record.dirty){
                updatedProduct.push(record.data);
                var product = {
                    productId: record.data.productId,
                    productName: record.data.productName,
                    productDescription: record.data.productDescription,
                    productPrice: record.data.productPrice,
                    productStockQuantity: record.data.productStockQuantity,
                    productImagePath: record.data.productImagePath

                };
                updateProduct.add(product);
            }

        });

        var jsonData = '{ "productList": ';
        jsonData += Ext.encode(Ext.pluck(updateProduct.data.items,'data'));
        jsonData += '}';

        Ext.Ajax.request({

            url: 'update/updateProduct',
            method: 'POST',

            params:{

                jsonData: jsonData,
            },

            scope: this,
            success: function(response){
                var responseText = Ext.decode(response.responseText);

            }

        });

    },

    onBtnSaveProduct: function(button, e, eOpts) {
        var productName = Ext.getCmp('frmProductName').getValue();
        var productDescription = Ext.getCmp('frmProductDescription').getValue();
        var productPrice = Ext.getCmp('frmProductPrice').getValue();
        var productInStock = Ext.getCmp('frmProductQuantity').getValue();
        var productImagePath = Ext.getCmp('frmProductImagePath').getValue();

        Ext.Ajax.request({
               url: 'admin/addProduct',
                    method: POST,
            params:{
                productName: productName,
                productDescription: productDescription,
                productPrice:productPrice,
                productStockQuantity: productInStock,
                productImagePath: productImagePath
            },

            scope: this,
            success: function(response){
                var responseText = JSON.parse(response.responseText);
                alert(responseText);
            }

        });


    },

    onViewUserListClick: function() {
          this.getOrderRequestsPanel().hide();
                this.getCustomerConfirmPanel().hide();
                this.getProductListPanel().hide();
                this.getViewAllOrderPanel().hide();
        this.getUserListPanel().show();


                var viewUserGrid = Ext.getCmp('viewUserListGrid');
                var viewUserGridStore = viewUserGrid.getStore();
                var userListStore = Ext.getStore('userList');

                userListStore.removeAll();
                viewUserGridStore.clearData();
                viewUserGrid.getView().refresh();


                Ext.Ajax.request({
                     url: window.location.pathname +'admin/getUsers',
                     method: 'POST',

                    scope: this,
                    success: function(response){
                        var responseText = Ext.decode(response.responseText);

                        for (var ctr = 0; ctr < responseText.userList.length; ctr++){
                            var user = {
                                userId: responseText.userList[ctr].user.userId,
                                fullName: responseText.userList[ctr].user.fullName,
                                userName: responseText.userList[ctr].user.username,
                                email: responseText.userList[ctr].user.email,
                                address: responseText.userList[ctr].user.address,
                                mobile: responseText.userList[ctr].user.mobileNumber,
                                userRole: responseText.userList[ctr].user.userRole,
                                isBlacklisted: responseText.userList[ctr].user.isBlacklisted,
                                membershipType: responseText.userList[ctr].membershipType

                            };

                            viewUserGridStore.add(user);
                        }
                    },

                    failure: function(){
                        Ext.MessageBox.alert('Loading Failed','Unable to connect to server');
                    }

                });
    },

    onAddUserClick: function() {
        this. userAdminWindow= Ext.create('MyApp.view.AdminUserWindow',{});

                this.userAdminWindow.show();
    },

    onBtnSaveAdminClick: function() {
        alert('');
        var frmAddAdmin = Ext.getCmp('frmAddAdminUser');
                var fullname = frmAddAdmin.query('#frmAdminFullname')[0].getValue();
                var username = frmAddAdmin.query('#frmAdminUsername')[0].getValue();
                var password = frmAddAdmin.query('#frmAdminPassword')[0].getValue();
                var confirmPassword = frmAddAdmin.query('#frmAdminConfirm')[0].getValue();
                var email = frmAddAdmin.query('#frmAdminEmail')[0].getValue();
                var address = frmAddAdmin.query('#frmAdminAddress')[0].getValue();
                var mobile = frmAddAdmin.query('#frmAdminMobile')[0].getValue();
                var userRole = 'Admin';
                //var userStore = Ext.getStore('userStore');

                if(frmAddAdmin.isValid()){
                            if(password === confirmPassword){

                                    Ext.Ajax.request({

                                         url: window.location.pathname +'update/addUser',
                                         method: 'POST',

                                         params: {
                                            userName: username,
                                            userPassword: password,
                                            fullName: fullname,
                                            email: email,
                                            deliveryAddress: address,
                                            mobileNumber: mobile,
                                            userRole: userRole
                                     },
                                         scope: this,
                                         success: function(response){
                                                     var responseText = Ext.decode(response.responseText);
                                             if(responseText.data.errormsg.indexOf('none') >-1){
                                                 Ext.MessageBox.alert('Registation','Admin Account Created, Successfully Created Admin Account!');
                                                  Ext.getCmp('adminUserWindow').close();
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

    onFrmBtnSaveClick: function() {
        var productName = Ext.getCmp('frmProductName').getValue();
        var productDescription = Ext.getCmp('frmProductDescription').getValue();
        var productPrice = Ext.getCmp('frmProductPrice').getValue();
        var productInStock = Ext.getCmp('frmProductQuantity').getValue();
        var productImagePath = Ext.getCmp('frmImagePath').getValue();

        Ext.Ajax.request({
               url: 'update/addProducts',
                    method: 'POST',
            params:{
                productName: productName,
                productDescription: productDescription,
                productPrice:productPrice,
                productStockQuantity: productInStock,
                productImagePath: productImagePath
            },

            scope: this,
            success: function(response){
                var responseText = Ext.decode(response.responseText);
                alert(responseText);
                Ext.MessageBox.alert('Status', 'Successfully added product to the list');
                Ext.getCmp('frmProductName').setValue();
                Ext.getCmp('frmProductDescription').setValue();
                Ext.getCmp('frmProductPrice').setValue();
                Ext.getCmp('frmProductQuantity').setValue();
                Ext.getCmp('frmImagePath').setValue();

            },

             failure: function(){
                Ext.MessageBox.alert('Loading Failed','Unable to connect to server');
             }

        });
    },

    init: function(application) {
        this.control({
            "#btnCustomerRequest": {
                click: this.onBtnCustomerRequestClick
            },
            "#confirmOrderBtn": {
                click: this.onConfirmOrderBtnClick
            },
            "#btnLogin": {
                click: this.onBtnLoginClick
            },
            "#viewAllOrderGrid": {
                itemdblclick: this.onViewAllOrderGridItemDblClick
            },
            "#viewAllOrderBtn": {
                click: this.onViewAllOrderBtnClick
            },
            "#btnApproveRequest": {
                click: this.onBtnApproveRequestClick
            },
            "#btnRejectRequest": {
                click: this.onBtnRejectRequestClick
            },
            "#btnSaveUpdates": {
                click: this.onBtnSaveUpdatesClick
            },
            "#membershipRequest": {
                click: this.onMembershipRequestClick
            },
            "#orderReqeust": {
                click: this.onOrderRequestClick
            },
            "#viewAllOrder": {
                click: this.onViewAllOrderClick
            },
            "#products": {
                click: this.onProductsClick
            },
            "#logout": {
                click: this.onLogoutClick
            },
            "#btnAddProduct": {
                click: this.onBtnAddProductClick
            },
            "#btnUpdateProduct": {
                click: this.onBtnUpdateProductClick
            },
            "#btnSaveProduct": {
                click: this.onBtnSaveProduct
            },
            "#viewUserList": {
                click: this.onViewUserListClick
            },
            "#addUser": {
                click: this.onAddUserClick
            },
            "#btnSaveAdmin": {
                click: this.onBtnSaveAdminClick
            },
            "#frmBtnSave": {
                click: this.onFrmBtnSaveClick
            }
        });
    }

});