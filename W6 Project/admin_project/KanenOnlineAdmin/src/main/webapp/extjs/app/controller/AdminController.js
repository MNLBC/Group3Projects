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
            ref: 'centerContainer',
            selector: '#CenterContainer'
        },
        {
            ref: 'orderRequestsPanel',
            selector: '#orderRequestsPanel'
        },
        {
            ref: 'customerConfirmPanel',
            selector: '#customerConfirmPanel'
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
            ref: 'viewAllOrderPanel',
            selector: '#viewAllOrderPanel'
        }
    ],

    onBtnCustomerRequestClick: function() {
        this.getCustomerConfirmPanel().show();
        this.getOrderRequestsPanel().hide();
        this.getViewAllOrderPanel().hide();

        var customerRequestGrid = Ext.getCmp('membershipRequestGrid');
        var customerRequestStore = customerRequestGrid.getStore();
        Ext.Ajax.request({
            url: window.location.pathname +'admin/userRequest',
            method: 'POST',
            scope: this,
            success: function(response){
            	debugger;
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

        orderGridStore.clearFilter(true);
        orderGridStore.filter('orderStatus','On Delivery');

        Ext.Ajax.request({
             url: window.location.pathname +'order/PendingOrders',
             method: 'POST',

            scope: this,
            success: function(response){
                  var responseText = Ext.decode(response.responseText);
                  var responseData = responseText.data;

                for (var ctr = 0; ctr < responseData.orders.length; ctr++){
                    var order = {
                        orderId: responseData.orders[ctr].orderId,
                        userId: responseData.orders[ctr].userId,
                        userFullName: responseData.orders[ctr].userFullName,
                        orderDate: responseData.orders[ctr].orderDate,
                        totalCost: responseData.orders[ctr].totalCost,
                        items: responseData.orders[ctr].items
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
        var userName = this.getTxtUsername().getValue();
        var userPassword = this.getTxtPassword().getValue();
        var userStore = Ext.getStore('userStore');
        userStore.removeAll();

        Ext.Ajax.request({

            url: window.location.pathname +'user/login',
            method: 'POST',

            params: {
                userName: userName,
                userPassword: userPassword
            },
            scope:this,
            success:function(response){
                var responseText = Ext.decode(response.responseText);
                var responseData = responseText.data;
                var user = responseData.user[0];

                var loggedInUser = {
                    userId: user.userId,
                    userName: user.userName,
                    userFullName: user.fullName,
                    userEmail: user.email,
                    useAddress: user.Address,
                    userMobileNumber: user.mobileNumber,
                    userRole: user.userRole,
                    userPassword: ''
                };

                userStore.add(loggedInUser);
                this.getLoginContainer().hide();
                this.getAdminContainer().show();
                Ext.MessageBox.alert('Status', 'Logged in successfully');

            },
            failure:function(){
                Ext.MessageBox.alert('Login Failed', 'Unable to connect to server, Please try again.');
            }

        });
    },

    onViewAllOrderGridItemDblClick: function() {
        // var orderItems = Ext.getStore('orderItems');
        // var selectedRecords = selModel.getSelection();
        // var selectionCount = selModel.getCount();
        // var orderId = selectedRecords[0].data.orderId;
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
                var orderStore = Ext.getStore('orderStore');
                var orderId = orderStore.data.items[0].data.orderId;
    },

    onViewAllOrderBtnClick: function() {
        this.getOrderRequestsPanel().hide();
        this.getCustomerConfirmPanel().hide();
        this.getViewAllOrderPanel().show();

        var orderStore = Ext.getStore('orderStore');
        var orderItemStore = Ext.getStore('orderItems');
        var viewAllGrid = Ext.getCmp('viewAllOrderGrid');
        var viewAllGridStore = viewAllGrid.getStore();
        viewAllGridStore.remoteFilter = false;
        viewAllGridStore.clearFilter();

        Ext.Ajax.request({
             url: window.location.pathname +'order/getAllOrders',
             method: 'POST',

            scope: this,
            success: function(response){
                var responseText = Ext.decode(response.responseText);
                var responseData = responseText.data;

                for (var ctr = 0; ctr < responseData.orders.length; ctr++){
                    var order = {
                        orderId: responseData.orders[ctr].orderId,
                        userId: responseData.orders[ctr].userId,
                        userFullName: responseData.orders[ctr].userFullName,
                        orderDate: responseData.orders[ctr].orderDate,
                        totalCost: responseData.orders[ctr].totalCost,
                        items: responseData.orders[ctr].items
                    };

                    orderStore.add(order);
                }

                for (var i = 0; i < responseData.items.length; i++){
                    var items = {
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
                Ext.MessageBox.alert('Loading Failed','Unable to connect to server');
            }

        });
    },

    onBtnApproveRequestClick: function() {
        var userRequestGrid = Ext.getCmp('userRequestGrid');
        var userGridStore = userRequestGrid.getStore();
        var selectedRows = userRequestGrid.getSelectionModel().getSelection()[0];
        var rowIndex = userGridStore.indexOf(selectedRows);
        if (rowIndex >0 ){
            Ext.Msg.confirm('Approve Request', 'Do you want to Approve this request?',function(btn){
                if (btn==='yes'){
                       userGridStore.data.items[rowIndex].data.currentMembershipLevel =  userGridStore.data.items[rowIndex].data.requestedMembershipLevel;
                       userRequestGrid.getView().refresh();
                }
            });} else {
               Ext.MessageBox.alert('Status','Please select a request to approve');
        }
    },

    onBtnRejectRequestClick: function() {
        var userRequestGrid = Ext.getCmp('userRequestGrid');
        var userGridStore = userRequestGrid.getStore();
        var selectedRows = userRequestGrid.getSelectionModel().getSelection()[0];
        var rowIndex = userGridStore.indexOf(selectedRows);
        if (rowIndex >0 ){
            Ext.Msg.confirm('Approve Request', 'Do you want to Reject this request?',function(btn){
                if (btn==='yes'){
                      userGridStore.remove(selectedRows);
                }
            });} else {
               Ext.MessageBox.alert('Status','Please select a request ');
        }
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
            }
        });
    }

});
