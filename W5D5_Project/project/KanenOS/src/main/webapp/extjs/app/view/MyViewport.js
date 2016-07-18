/*
 * File: app/view/MyViewport.js
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

Ext.define('KanenOnlineShopping.view.MyViewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Ext.grid.Panel',
        'Ext.grid.View',
        'Ext.grid.column.Number',
        'Ext.grid.column.Action',
        'Ext.toolbar.Spacer',
        'Ext.button.Button',
        'Ext.Img',
        'Ext.toolbar.Toolbar'
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
                                    layout: 'fit',
                                    items: [
                                        {
                                            xtype: 'panel',
                                            id: 'productPanel',
                                            itemId: 'productPanel',
                                            autoScroll: true,
                                            layout: 'column',
                                            title: 'Products'
                                        }
                                    ]
                                },
                                {
                                    xtype: 'container',
                                    flex: 8,
                                    region: 'east',
                                    width: 150,
                                    layout: 'border',
                                    items: [
                                        {
                                            xtype: 'gridpanel',
                                            flex: 15,
                                            region: 'center',
                                            id: 'cartGrid',
                                            itemId: 'cartGrid',
                                            bodyBorder: true,
                                            title: 'My Cart',
                                            store: 'cartStore',
                                            viewConfig: {
                                                border: 30
                                            },
                                            columns: [
                                                {
                                                    xtype: 'gridcolumn',
                                                    width: 160,
                                                    dataIndex: 'productName',
                                                    text: 'Product Name'
                                                },
                                                {
                                                    xtype: 'gridcolumn',
                                                    width: 264,
                                                    dataIndex: 'productDescription',
                                                    text: 'Product Description'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    width: 99,
                                                    dataIndex: 'productPrice',
                                                    text: 'Price'
                                                },
                                                {
                                                    xtype: 'numbercolumn',
                                                    dataIndex: 'quantity',
                                                    text: 'Quantity',
                                                    format: '0,000'
                                                },
                                                {
                                                    xtype: 'actioncolumn',
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
                                            ]
                                        },
                                        {
                                            xtype: 'container',
                                            flex: 4,
                                            region: 'south',
                                            height: 150,
                                            layout: {
                                                type: 'vbox',
                                                align: 'stretch',
                                                pack: 'center'
                                            },
                                            items: [
                                                {
                                                    xtype: 'tbspacer',
                                                    flex: 1,
                                                    height: 10
                                                },
                                                {
                                                    xtype: 'button',
                                                    height: 46,
                                                    id: 'btnClearCart',
                                                    width: 414,
                                                    text: 'Clear Cart'
                                                },
                                                {
                                                    xtype: 'tbspacer',
                                                    flex: 1,
                                                    height: 3
                                                },
                                                {
                                                    xtype: 'button',
                                                    height: 52,
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
                                            xtype: 'button',
                                            height: 33,
                                            id: 'btnHistory',
                                            width: 96,
                                            text: 'Order History'
                                        },
                                        {
                                            xtype: 'tbspacer',
                                            width: 1500
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
                    style: 'background-color:#292c2f',
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
                }
            ]
        });

        me.callParent(arguments);
    }

});