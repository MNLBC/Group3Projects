/*
 * File: app/view/MyWindow.js
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

Ext.define('KanenOnlineShopping.view.MyWindow', {
    extend: 'Ext.window.Window',

    requires: [
        'Ext.form.Panel',
        'Ext.form.field.Text',
        'Ext.toolbar.Toolbar',
        'Ext.toolbar.Spacer',
        'Ext.button.Button'
    ],

    draggable: false,
    height: 141,
    id: 'loginWindow',
    itemId: 'loginWindow',
    width: 386,
    title: 'Login',
    modal: true,

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'form',
                    height: 109,
                    id: 'frmLogin',
                    itemId: 'frmLogin',
                    width: 376,
                    bodyPadding: 10,
                    items: [
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'txtLoginUsername',
                            itemId: 'txtLoginUsername',
                            fieldLabel: 'Username:'
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'txtLoginPassword',
                            itemId: 'txtLoginPassword',
                            fieldLabel: 'Password'
                        }
                    ],
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            dock: 'bottom',
                            items: [
                                {
                                    xtype: 'tbspacer',
                                    width: 150
                                },
                                {
                                    xtype: 'button',
                                    id: 'btnLoginRegister',
                                    itemId: 'btnLoginRegister',
                                    width: 70,
                                    text: 'Register'
                                },
                                {
                                    xtype: 'button',
                                    id: 'btnLogin',
                                    itemId: 'btnLogin',
                                    width: 70,
                                    text: 'Login'
                                },
                                {
                                    xtype: 'button',
                                    id: 'btnLoginCancel',
                                    itemId: 'btnLoginCancel',
                                    width: 70,
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