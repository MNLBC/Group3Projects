/*
 * File: app/view/MyViewport1.js
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

Ext.define('KanenOnlineShopping.view.MyViewport1', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Ext.grid.Panel',
        'Ext.grid.column.Number',
        'Ext.grid.column.Date',
        'Ext.grid.View'
    ],

    id: 'orderViewport',
    layout: 'fit',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
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
                                    title: 'My Grid Panel',
                                    columns: [
                                        {
                                            xtype: 'numbercolumn',
                                            width: 500,
                                            dataIndex: 'number',
                                            text: 'Order Id',
                                            format: '0,000'
                                        },
                                        {
                                            xtype: 'datecolumn',
                                            width: 500,
                                            dataIndex: 'date',
                                            text: 'Order Date'
                                        },
                                        {
                                            xtype: 'numbercolumn',
                                            width: 500,
                                            dataIndex: 'bool',
                                            text: 'Total Cost:'
                                        },
                                        {
                                            xtype: 'gridcolumn',
                                            width: 500,
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