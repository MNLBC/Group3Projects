/*
 * File: app/view/UserWindow.js
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

Ext.define('KanenOnlineShopping.view.UserWindow', {
    extend: 'Ext.window.Window',

    requires: [
        'Ext.form.field.Text',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button'
    ],

    height: 340,
    id: 'UserWindow',
    itemId: 'UserWindow',
    width: 530,
    title: 'My Window',
    modal: true,

    layout: {
        type: 'vbox',
        align: 'center',
        pack: 'center'
    },

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'textfield',
                    id: 'fullNameField',
                    itemId: 'fullNameField',
                    width: 316,
                    fieldLabel: 'Full Name'
                },
                {
                    xtype: 'textfield',
                    id: 'emailField',
                    width: 316,
                    fieldLabel: 'Email'
                },
                {
                    xtype: 'textfield',
                    id: 'addressField',
                    width: 316,
                    fieldLabel: 'Address'
                },
                {
                    xtype: 'textfield',
                    id: 'mobileNumberField',
                    itemId: 'mobileNumberField',
                    width: 316,
                    fieldLabel: 'Mobile Number'
                },
                {
                    xtype: 'toolbar',
                    height: 46,
                    layout: {
                        type: 'hbox',
                        pack: 'center'
                    },
                    items: [
                        {
                            xtype: 'button',
                            height: 36,
                            id: 'btnResetProfile',
                            itemId: 'btnResetProfile',
                            width: 95,
                            text: 'Reset'
                        },
                        {
                            xtype: 'button',
                            height: 41,
                            id: 'btnUpdateFields',
                            itemId: 'btnUpdateFields',
                            width: 111,
                            text: 'Update'
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});