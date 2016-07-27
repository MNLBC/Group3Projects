/*
 * File: app/view/CartWindow.js
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

Ext.define('KanenOnlineShopping.view.CartWindow', {
    extend: 'Ext.window.Window',

    requires: [
        'Ext.grid.Panel',
        'Ext.grid.View',
        'Ext.grid.column.Number',
        'Ext.form.Label',
        'Ext.toolbar.Spacer',
        'Ext.button.Button'
    ],

    height: 529,
    hidden: false,
    id: 'cartWindow',
    itemId: 'cartWindow',
    width: 876,
    layout: 'border',
    closable: false,
    title: 'Please review your items:',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'gridpanel',
                    flex: 9,
                    region: 'center',
                    title: '',
                    store: 'cartStore',
                    columns: [
                        {
                            xtype: 'gridcolumn',
                            width: 151,
                            dataIndex: 'productName',
                            text: 'Product Name:',
                            flex: 4
                        },
                        {
                            xtype: 'gridcolumn',
                            width: 243,
                            dataIndex: 'productDescription',
                            text: 'Product Description',
                            flex: 7
                        },
                        {
                            xtype: 'numbercolumn',
                            width: 197,
                            dataIndex: 'productPrice',
                            text: 'Price',
                            flex: 2
                        },
                        {
                            xtype: 'numbercolumn',
                            width: 191,
                            dataIndex: 'quantity',
                            text: 'Quantity',
                            flex: 2,
                            format: '0,000'
                        }
                    ],
                    viewConfig: {
                        id: 'checkoutCartGrid',
                        itemId: 'checkoutCartGrid'
                    }
                },
                {
                    xtype: 'panel',
                    flex: 3,
                    region: 'south',
                    height: 150,
                    layout: 'border',
                    title: 'Total Cost:',
                    items: [
                        {
                            xtype: 'container',
                            flex: 5,
                            region: 'west',
                            width: 150,
                            layout: {
                                type: 'hbox',
                                align: 'stretch',
                                pack: 'center',
                                padding: 8
                            },
                            items: [
                                {
                                    xtype: 'label',
                                    flex: 1,
                                    height: 70,
                                    id: 'lblCheckoutTotalCost',
                                    itemId: 'lblCheckoutTotalCost',
                                    padding: 11,
                                    width: 224,
                                    text: 'My Label'
                                },
                                {
                                    xtype: 'label',
                                    flex: 2,
                                    id: 'lblDiscountRate',
                                    padding: 11,
                                    text: 'My Label'
                                },
                                {
                                    xtype: 'label',
                                    flex: 1,
                                    id: 'lblDiscountedCost',
                                    padding: 11,
                                    text: 'My Label'
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            flex: 8,
                            region: 'center',
                            padding: 10,
                            layout: {
                                type: 'hbox',
                                align: 'middle'
                            },
                            items: [
                                {
                                    xtype: 'tbspacer',
                                    width: 220
                                },
                                {
                                    xtype: 'button',
                                    height: 38,
                                    hidden: true,
                                    id: 'btnBuy',
                                    itemId: 'btnBuy',
                                    width: 132,
                                    text: 'Buy these items'
                                },
                                {
                                    xtype: 'tbspacer',
                                    flex: 1,
                                    width: 20
                                },
                                {
                                    xtype: 'button',
                                    height: 37,
                                    id: 'btnCartWindowCancel',
                                    itemId: 'btnCartWindowCancel',
                                    width: 143,
                                    text: 'Cancel'
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