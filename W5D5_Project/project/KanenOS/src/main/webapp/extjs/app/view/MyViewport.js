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
        'Ext.button.Button',
        'Ext.toolbar.Toolbar',
        'Ext.toolbar.Spacer',
        'Ext.grid.column.Date'
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
                                            layout: 'column',
                                            title: 'My Panel'
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
                                            title: 'My Grid Panel',
                                            store: 'cartStore',
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
                                                }
                                            ]
                                        },
                                        {
                                            xtype: 'container',
                                            flex: 4,
                                            region: 'south',
                                            height: 150,
                                            items: [
                                                {
                                                    xtype: 'button',
                                                    id: 'btnClearCart',
                                                    text: 'View Order History'
                                                }
                                            ]
                                        }
                                    ]
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            flex: 0,
                            region: 'north',
                            height: 150,
                            id: 'topContainer',
                            itemId: 'topContainer',
                            items: [
                                {
                                    xtype: 'toolbar',
                                    id: 'loginToolbar',
                                    items: [
                                        {
                                            xtype: 'tbspacer',
                                            width: 1000
                                        },
                                        {
                                            xtype: 'button',
                                            id: 'btnMainLogin',
                                            itemId: 'btnMainLogin',
                                            text: 'Login'
                                        },
                                        {
                                            xtype: 'button',
                                            id: 'btnMainRegister',
                                            itemId: 'btnMainRegister',
                                            text: 'Register'
                                        },
                                        {
                                            xtype: 'button',
                                            id: 'btnMainLogout',
                                            itemId: 'btnMainLogout',
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
                            region: 'north',
                            height: 150,
                            id: 'orderHeaderContainer'
                        },
                        {
                            xtype: 'container',
                            flex: 1,
                            region: 'center',
                            id: 'orderBodyContainer',
                            layout: 'fit',
                            items: [
                                {
                                    xtype: 'gridpanel',
                                    itemId: 'orderItemsGridPanel',
                                    title: 'Transactions',
                                    store: 'orderStore',
                                    columns: [
                                        {
                                            xtype: 'numbercolumn',
                                            width: 500,
                                            dataIndex: 'orderId',
                                            text: 'Order Id',
                                            format: '0,000'
                                        },
                                        {
                                            xtype: 'datecolumn',
                                            width: 500,
                                            dataIndex: 'orderDate',
                                            text: 'Order Date'
                                        },
                                        {
                                            xtype: 'numbercolumn',
                                            width: 500,
                                            dataIndex: 'totalCost',
                                            text: 'Total Cost:'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            width: 500,
                                            dataIndex: 'orderStatus',
                                            text: 'Order Status'
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