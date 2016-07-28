/*
 * File: app/view/AdminAddProductWindow.js
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

Ext.define('MyApp.view.AdminAddProductWindow', {
    extend: 'Ext.window.Window',

    requires: [
        'Ext.form.Panel',
        'Ext.form.field.Text',
        'Ext.button.Button'
    ],

    draggable: false,
    height: 243,
    id: 'adminAddProductWindow',
    itemId: 'adminAddProductWindow',
    width: 659,
    layout: 'fit',
    title: 'Add Product',
    modal: true,

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'form',
                    bodyPadding: 10,
                    title: '',
                    items: [
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'frmProductName',
                            itemId: 'frmProductName',
                            fieldLabel: 'Product Name',
                            labelWidth: 120,
                            allowBlank: false,
                            allowOnlyWhitespace: false
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'frmProductDescription',
                            itemId: 'frmProductDescription',
                            fieldLabel: 'Product Description',
                            labelWidth: 120,
                            allowBlank: false,
                            allowOnlyWhitespace: false
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'frmProductPrice',
                            itemId: 'frmProductPrice',
                            fieldLabel: 'Product Price',
                            labelWidth: 120,
                            allowBlank: false,
                            allowOnlyWhitespace: false,
                            regex: /^[1-9][0-9]*$/
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'frmProductQuantity',
                            itemId: 'frmProductQuantity',
                            fieldLabel: 'In Stock Quantity',
                            labelWidth: 120,
                            allowBlank: false,
                            allowOnlyWhitespace: false,
                            regex: /^[1-9][0-9]*$/
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'frmImagePath',
                            itemId: 'frmImagePath',
                            fieldLabel: 'Image Path',
                            labelWidth: 120,
                            allowBlank: false,
                            allowOnlyWhitespace: false
                        },
                        {
                            xtype: 'container',
                            height: 28,
                            width: 612,
                            layout: {
                                type: 'hbox',
                                align: 'middle',
                                pack: 'center'
                            },
                            items: [
                                {
                                    xtype: 'button',
                                    id: 'frmBtnSave',
                                    itemId: 'frmBtnSave',
                                    margin: 2,
                                    width: 100,
                                    text: 'Save Product'
                                },
                                {
                                    xtype: 'button',
                                    flex: 0,
                                    id: 'frmBtnReset',
                                    itemId: 'frmBtnReset',
                                    margin: 2,
                                    width: 100,
                                    text: 'Reset'
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