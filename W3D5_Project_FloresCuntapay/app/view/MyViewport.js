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

Ext.define('BMS.view.MyViewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Ext.form.Panel',
        'Ext.form.field.Text',
        'Ext.toolbar.Toolbar',
        'Ext.toolbar.Spacer',
        'Ext.button.Button'
    ],

    id: 'loginView',

    layout: {
        type: 'hbox',
        align: 'middle',
        pack: 'center'
    },

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'form',
                    height: 177,
                    id: 'frmLogin',
                    itemId: 'frmLogin',
                    padding: '',
                    width: 293,
                    layout: 'auto',
                    bodyPadding: 15,
                    title: 'Login (Book Management System)',
                    items: [
                        {
                            xtype: 'textfield',
                            id: 'lusername',
                            itemId: 'lusername',
                            fieldLabel: 'Username:'
                        },
                        {
                            xtype: 'textfield',
                            id: 'lpassword',
                            itemId: 'lpassword',
                            fieldLabel: 'Password',
                            inputType: 'password'
                        },
                        {
                            xtype: 'toolbar',
                            items: [
                                {
                                    xtype: 'tbspacer',
                                    height: 50,
                                    padding: 10,
                                    width: 90
                                },
                                {
                                    xtype: 'button',
                                    height: 35,
                                    id: 'lbtnLog',
                                    width: 70,
                                    text: 'Login'
                                },
                                {
                                    xtype: 'button',
                                    height: 35,
                                    id: 'lbtnReg',
                                    width: 70,
                                    text: 'Register'
                                }
                            ]
                        }
                    ]
                },
                {
                    xtype: 'form',
                    flex: 1,
                    height: 300,
                    hidden: true,
                    id: 'frmReg',
                    itemId: 'frmReg',
                    width: 309,
                    bodyPadding: 10,
                    title: 'Registration (Book Management System)',
                    items: [
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'rname',
                            itemId: 'rname',
                            fieldLabel: 'Name',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'rusername',
                            itemId: 'rusername',
                            fieldLabel: 'Username',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'rpassword',
                            itemId: 'rpassword',
                            fieldLabel: 'Password',
                            inputType: 'password',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'rcpassword',
                            itemId: 'rcpassword',
                            fieldLabel: 'Confirm Password',
                            inputType: 'password',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'raddress',
                            itemId: 'raddress',
                            fieldLabel: 'Address',
                            allowBlank: false
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'rmobileno',
                            itemId: 'rmobileno',
                            fieldLabel: 'Mobile Number',
                            allowBlank: false
                        },
                        {
                            xtype: 'toolbar',
                            layout: {
                                type: 'hbox',
                                pack: 'center'
                            },
                            items: [
                                {
                                    xtype: 'button',
                                    height: 35,
                                    id: 'rbtnReg',
                                    width: 70,
                                    text: 'Register'
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