/*
 * File: app/view/LoginWindow.js
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

Ext.define('KanenOnlineShopping.view.LoginWindow', {
    extend: 'Ext.window.Window',

    requires: [
        'Ext.form.Panel',
        'Ext.form.field.Text',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button'
    ],

    draggable: false,
    height: 226,
    hidden: false,
    id: 'loginWindow',
    itemId: 'loginWindow',
    width: 598,
    resizable: false,
    closable: false,
    title: 'Login',
    modal: true,

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'form',
                    height: 170,
                    id: 'frmLogin',
                    itemId: 'frmLogin',
                    padding: 10,
                    width: 604,
                    layout: 'auto',
                    bodyPadding: 10,
                    items: [
                        {
                            xtype: 'textfield',
                            height: 33,
                            id: 'txtLoginUsername',
                            itemId: 'txtLoginUsername',
                            padding: 5,
                            width: 398,
                            fieldLabel: 'Username:',
                            labelWidth: 150,
                            allowBlank: false,
                            allowOnlyWhitespace: false
                        },
                        {
                            xtype: 'textfield',
                            height: 33,
                            id: 'txtLoginPassword',
                            itemId: 'txtLoginPassword',
                            padding: 5,
                            width: 397,
                            fieldLabel: 'Password',
                            labelWidth: 150,
                            inputType: 'password',
                            allowBlank: false,
                            allowOnlyWhitespace: false
                        }
                    ],
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            dock: 'bottom',
                            layout: {
                                type: 'hbox',
                                pack: 'center'
                            },
                            items: [
                                {
                                    xtype: 'button',
                                    height: 33,
                                    id: 'btnLoginRegister',
                                    itemId: 'btnLoginRegister',
                                    width: 130,
                                    text: 'Register'
                                },
                                {
                                    xtype: 'button',
                                    height: 33,
                                    id: 'btnLogin',
                                    itemId: 'btnLogin',
                                    width: 130,
                                    text: 'Login'
                                },
                                {
                                    xtype: 'button',
                                    height: 33,
                                    id: 'btnLoginCancel',
                                    itemId: 'btnLoginCancel',
                                    width: 130,
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