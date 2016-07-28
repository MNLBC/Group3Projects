/*
 * File: app/view/MyViewport.js
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

Ext.define('KanenOnlineShopping.view.MyViewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Ext.form.Panel',
        'Ext.grid.Panel',
        'Ext.grid.View',
        'Ext.grid.column.Number',
        'Ext.grid.plugin.CellEditing',
        'Ext.form.field.Text',
        'Ext.grid.column.Action',
        'Ext.button.Button',
        'Ext.toolbar.Spacer',
        'Ext.Img',
        'Ext.toolbar.Toolbar',
        'Ext.form.field.Display'
    ],

    id: 'myViewport',
    layout: 'fit',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'container',
                    id: 'mainContainer',
                    width: 150,
                    layout: 'border',
                    items: [
                        {
                            xtype: 'container',
                            flex: 0,
                            region: 'center',
                            id: 'bodyContainer',
                            itemId: 'bodyContainer',
                            layout: 'border',
                            items: [
                                {
                                    xtype: 'container',
                                    flex: 14,
                                    region: 'center',
                                    id: 'productContainer',
                                    itemId: 'productContainer',
                                    layout: 'border',
                                    items: [
                                        {
                                            xtype: 'panel',
                                            flex: 12,
                                            region: 'center',
                                            id: 'productPanel',
                                            itemId: 'productPanel',
                                            autoScroll: true,
                                            layout: 'column',
                                            title: 'Products'
                                        },
                                        {
                                            xtype: 'form',
                                            flex: 5,
                                            region: 'east',
                                            width: 100,
                                            bodyPadding: 10,
                                            collapsible: true,
                                            title: '',
                                            layout: {
                                                type: 'vbox',
                                                align: 'stretch'
                                            },
                                            items: [
                                                {
                                                    xtype: 'gridpanel',
                                                    flex: 15,
                                                    id: 'cartGrid',
                                                    itemId: 'cartGrid',
                                                    width: 150,
                                                    bodyBorder: false,
                                                    collapseDirection: 'right',
                                                    collapsible: false,
                                                    title: '',
                                                    store: 'cartStore',
                                                    viewConfig: {
                                                        border: 30
                                                    },
                                                    columns: [
                                                        {
                                                            xtype: 'gridcolumn',
                                                            width: 160,
                                                            dataIndex: 'productName',
                                                            text: 'Product Name',
                                                            flex: 3
                                                        },
                                                        {
                                                            xtype: 'gridcolumn',
                                                            width: 264,
                                                            dataIndex: 'productDescription',
                                                            text: 'Product Description',
                                                            flex: 4
                                                        },
                                                        {
                                                            xtype: 'numbercolumn',
                                                            width: 99,
                                                            dataIndex: 'productPrice',
                                                            text: 'Price',
                                                            flex: 2
                                                        },
                                                        {
                                                            xtype: 'numbercolumn',
                                                            dataIndex: 'quantity',
                                                            text: 'Quantity',
                                                            flex: 2,
                                                            format: '0,000',
                                                            editor: {
                                                                xtype: 'textfield',
                                                                id: 'mainOrdrQty',
                                                                itemId: 'mainOrdrQty',
                                                                allowBlank: false,
                                                                regex: '/^[1-9][0-9]*$/',
                                                                regexText: 'Only numbers are allowed'
                                                            }
                                                        },
                                                        {
                                                            xtype: 'actioncolumn',
                                                            flex: 1,
                                                            items: [
                                                                {
                                                                    handler: function(view, rowIndex, colIndex, item, e, record, row) {
                                                                        Ext.Msg.alert('Status', 'Item removed from cart.');
                                                                        var cartGrid = Ext.getCmp('cartGrid');
                                                                        var orderStore = cartGrid.getStore();
                                                                        //                         var orderHistoryGrid= this.getCartGrid();
                                                                        //                         var cartStore = cartGrid.getStore();

                                                                        //delete selected rows if selModel is checkboxmodel
                                                                        var selectedRows = orderStore.getAt(rowIndex);


                                                                        orderStore.remove(selectedRows);


                                                                        //                         else
                                                                        //                             Ext.Msg.alert('Status', 'Please select at least one record to delete!');
                                                                    },
                                                                    icon: 'resource/trash.png'
                                                                }
                                                            ]
                                                        }
                                                    ],
                                                    plugins: [
                                                        Ext.create('Ext.grid.plugin.CellEditing', {

                                                        })
                                                    ]
                                                },
                                                {
                                                    xtype: 'container',
                                                    flex: 4,
                                                    height: 50,
                                                    layout: {
                                                        type: 'vbox',
                                                        align: 'stretch',
                                                        pack: 'center'
                                                    },
                                                    items: [
                                                        {
                                                            xtype: 'button',
                                                            height: 46,
                                                            id: 'btnClearCart',
                                                            width: 414,
                                                            text: 'Clear Cart'
                                                        },
                                                        {
                                                            xtype: 'button',
                                                            height: 52,
                                                            hidden: true,
                                                            id: 'btnMainCheckout',
                                                            itemId: 'btnMainCheckout',
                                                            width: 162,
                                                            text: 'Checkout Items'
                                                        }
                                                    ]
                                                }
                                            ]
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            region: 'north',
                            height: 110,
                            style: 'background-color:#292c2f',
                            layout: {
                                type: 'hbox',
                                align: 'stretch'
                            },
                            items: [
                                {
                                    xtype: 'tbspacer',
                                    flex: 0,
                                    width: 540
                                },
                                {
                                    xtype: 'image',
                                    height: 201,
                                    width: 737,
                                    src: 'resource/logo1.png'
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            flex: 0,
                            region: 'north',
                            height: 45,
                            id: 'topContainer',
                            itemId: 'topContainer',
                            style: 'background-color:#292c2f',
                            layout: 'border',
                            items: [
                                {
                                    xtype: 'toolbar',
                                    region: 'center',
                                    id: 'loginToolbar',
                                    style: 'background: -webkit-linear-gradient(60deg, rgba(88, 88, 96, 0.99) 0%, rgba(92, 126, 146, 0.1) 50%, rgba(95, 164, 195, 0.99) 100%);\r\nbackground: -o-linear-gradient(60deg, rgba(88, 88, 96, 0.99) 0%, rgba(92, 126, 146, 0.1) 50%, rgba(95, 164, 195, 0.99) 100%);\r\nbackground: -ms-linear-gradient(60deg, rgba(88, 88, 96, 0.99) 0%, rgba(92, 126, 146, 0.1) 50%, rgba(95, 164, 195, 0.99) 100%);\r\nbackground: -moz-linear-gradient(60deg, rgba(88, 88, 96, 0.99) 0%, rgba(92, 126, 146, 0.1) 50%, rgba(95, 164, 195, 0.99) 100%);\r\nbackground: linear-gradient(30deg, rgba(88, 88, 96, 0.99) 0%, rgba(92, 126, 146, 0.1) 50%, rgba(95, 164, 195, 0.99) 100%);',
                                    layout: {
                                        type: 'hbox',
                                        pack: 'end'
                                    },
                                    items: [
                                        {
                                            xtype: 'textfield',
                                            id: 'txtProductSearch',
                                            itemId: 'txtProductSearch',
                                            width: 288,
                                            fieldLabel: 'Search',
                                            labelAlign: 'right'
                                        },
                                        {
                                            xtype: 'button',
                                            height: 33,
                                            id: 'btnSearchProduct',
                                            itemId: 'btnSearchProduct',
                                            width: 96,
                                            text: 'Search'
                                        },
                                        {
                                            xtype: 'button',
                                            height: 33,
                                            id: 'btnHistory',
                                            width: 96,
                                            text: 'Order History'
                                        },
                                        {
                                            xtype: 'tbspacer',
                                            width: 1350
                                        },
                                        {
                                            xtype: 'button',
                                            height: 30,
                                            id: 'btnMainLogin',
                                            itemId: 'btnMainLogin',
                                            width: 87,
                                            text: 'Login'
                                        },
                                        {
                                            xtype: 'button',
                                            height: 30,
                                            id: 'btnMainRegister',
                                            itemId: 'btnMainRegister',
                                            width: 86,
                                            text: 'Register'
                                        },
                                        {
                                            xtype: 'button',
                                            height: 29,
                                            id: 'btnUserProfile',
                                            itemId: 'btnUserProfile',
                                            width: 84,
                                            text: 'User Profile'
                                        },
                                        {
                                            xtype: 'button',
                                            height: 30,
                                            id: 'btnMainLogout',
                                            itemId: 'btnMainLogout',
                                            width: 85,
                                            text: 'Logout'
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                },
                {
                    xtype: 'container',
                    height: 590,
                    id: 'orderHistoryContainer',
                    itemId: 'orderHistoryContainer',
                    width: 1138,
                    layout: 'border',
                    items: [
                        {
                            xtype: 'container',
                            flex: 13,
                            region: 'center',
                            id: 'orderBodyContainer',
                            layout: {
                                type: 'vbox',
                                align: 'stretch'
                            },
                            items: [
                                {
                                    xtype: 'gridpanel',
                                    id: 'orderItemsGridPanel',
                                    itemId: 'orderItemsGridPanel',
                                    title: 'Transactions',
                                    store: 'orderStore',
                                    columns: [
                                        {
                                            xtype: 'gridcolumn',
                                            width: 500,
                                            dataIndex: 'orderId',
                                            text: 'Order Id',
                                            flex: 1
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            width: 500,
                                            dataIndex: 'orderDate',
                                            text: 'Order Date',
                                            flex: 1
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            width: 500,
                                            dataIndex: 'orderStatus',
                                            text: 'Order Status',
                                            flex: 1
                                        },
                                        {
                                            xtype: 'numbercolumn',
                                            width: 500,
                                            dataIndex: 'totalCost',
                                            text: 'Total Cost:',
                                            flex: 1
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            xtype: 'toolbar',
                            flex: 1,
                            region: 'south',
                            height: 150,
                            items: [
                                {
                                    xtype: 'button',
                                    id: 'btnBack',
                                    itemId: 'btnBack',
                                    text: 'Back to Main'
                                }
                            ]
                        }
                    ]
                },
                {
                    xtype: 'container',
                    id: 'userProfileContainer',
                    itemId: 'userProfileContainer',
                    style: 'style="background-color: #A6CBED;"',
                    items: [
                        {
                            xtype: 'container'
                        },
                        {
                            xtype: 'container',
                            height: 1000,
                            layout: {
                                type: 'vbox',
                                align: 'center'
                            },
                            items: [
                                {
                                    xtype: 'container',
                                    flex: 0,
                                    height: 212,
                                    width: 1270,
                                    layout: {
                                        type: 'vbox',
                                        align: 'center',
                                        pack: 'center'
                                    },
                                    items: [
                                        {
                                            xtype: 'image',
                                            flex: 0,
                                            height: 200,
                                            width: 200,
                                            src: 'resource/profile.png'
                                        }
                                    ]
                                },
                                {
                                    xtype: 'container',
                                    height: 300,
                                    html: '<html>\n<head>\n<style>\n\n</style>\n</head>\n<body>\n\n<center>\n<img src="resource/user.png"  width="400" height="400">\n</center>\n\n</body>\n</html>',
                                    width: 1200,
                                    layout: {
                                        type: 'vbox',
                                        align: 'center'
                                    },
                                    items: [
                                        {
                                            xtype: 'tbspacer',
                                            flex: 1,
                                            height: 148,
                                            width: 10
                                        },
                                        {
                                            xtype: 'displayfield',
                                            flex: 1,
                                            id: 'userName',
                                            itemId: 'userName',
                                            width: 300,
                                            fieldLabel: 'Username',
                                            value: ''
                                        },
                                        {
                                            xtype: 'displayfield',
                                            flex: 1,
                                            id: 'userFullname',
                                            itemId: 'userFullname',
                                            width: 301,
                                            fieldLabel: 'Fullname',
                                            value: ''
                                        },
                                        {
                                            xtype: 'displayfield',
                                            flex: 1,
                                            id: 'userEmail',
                                            itemId: 'userEmail',
                                            width: 300,
                                            fieldLabel: 'Email',
                                            value: ''
                                        },
                                        {
                                            xtype: 'displayfield',
                                            flex: 1,
                                            id: 'userAddress',
                                            itemId: 'userAddress',
                                            width: 302,
                                            fieldLabel: 'Address',
                                            value: ''
                                        },
                                        {
                                            xtype: 'displayfield',
                                            flex: 1,
                                            id: 'userMobileNumber',
                                            itemId: 'userMobileNumber',
                                            width: 305,
                                            fieldLabel: 'Mobile Number',
                                            value: ''
                                        },
                                        {
                                            xtype: 'displayfield',
                                            flex: 1,
                                            id: 'txtMembershipType',
                                            itemId: 'txtMembershipType',
                                            width: 320,
                                            fieldLabel: 'Membership type',
                                            labelAlign: 'top',
                                            value: ''
                                        },
                                        {
                                            xtype: 'tbspacer',
                                            flex: 1,
                                            height: 100
                                        },
                                        {
                                            xtype: 'container',
                                            flex: 1,
                                            layout: {
                                                type: 'hbox',
                                                align: 'stretch',
                                                pack: 'center'
                                            },
                                            items: [
                                                {
                                                    xtype: 'button',
                                                    flex: 1,
                                                    id: 'btnRequestMember',
                                                    itemId: 'btnRequestMember',
                                                    width: 113,
                                                    icon: '',
                                                    text: 'Request'
                                                },
                                                {
                                                    xtype: 'button',
                                                    flex: 1,
                                                    height: 25,
                                                    id: 'btnUpdateProfile',
                                                    itemId: 'btnUpdateProfile',
                                                    width: 106,
                                                    text: 'Update Info'
                                                },
                                                {
                                                    xtype: 'button',
                                                    flex: 1,
                                                    height: 160,
                                                    id: 'btnChangePass',
                                                    itemId: 'btnChangePass',
                                                    width: 138,
                                                    text: 'Change Password'
                                                },
                                                {
                                                    xtype: 'button',
                                                    flex: 1,
                                                    id: 'btnBackMainPage',
                                                    itemId: 'btnBackMainPage',
                                                    text: 'Shop Again'
                                                },
                                                {
                                                    xtype: 'button',
                                                    flex: 1,
                                                    height: 30,
                                                    id: 'btnViewTransaction',
                                                    itemId: 'btnViewTransaction',
                                                    width: 125,
                                                    text: 'View Transaction'
                                                }
                                            ]
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});