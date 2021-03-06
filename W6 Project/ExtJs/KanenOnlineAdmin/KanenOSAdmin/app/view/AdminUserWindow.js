/*
 * File: app/view/AdminUserWindow.js
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

Ext.define('MyApp.view.AdminUserWindow', {
    extend: 'Ext.window.Window',

    requires: [
        'Ext.form.Panel',
        'Ext.form.FieldContainer',
        'Ext.form.field.Text',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button'
    ],

    draggable: false,
    height: 314,
    id: 'adminUserWindow',
    itemId: 'adminUserWindow',
    width: 519,
    layout: 'fit',
    title: 'Add Admin',
    modal: true,

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'form',
                    height: 300,
                    id: 'frmAddAdminUser',
                    itemId: 'frmAddAdminUser',
                    width: 475,
                    layout: 'fit',
                    bodyPadding: 10,
                    title: '',
                    items: [
                        {
                            xtype: 'fieldcontainer',
                            height: 120,
                            fieldLabel: '',
                            items: [
                                {
                                    xtype: 'textfield',
                                    id: 'frmAdminFullname',
                                    width: 450,
                                    fieldLabel: 'Fullname',
                                    labelWidth: 120,
                                    allowBlank: false,
                                    allowOnlyWhitespace: false,
                                    maxLength: 100,
                                    maxLengthText: 'exceed maximum limit'
                                },
                                {
                                    xtype: 'textfield',
                                    id: 'frmAdminUsername',
                                    itemId: 'frmAdminUsername',
                                    width: 450,
                                    fieldLabel: 'Username',
                                    labelWidth: 120,
                                    allowBlank: false,
                                    allowOnlyWhitespace: false,
                                    maxLength: 100,
                                    maxLengthText: 'Exceed maximum limit'
                                },
                                {
                                    xtype: 'textfield',
                                    id: 'frmAdminPassword',
                                    itemId: 'frmAdminPassword',
                                    width: 450,
                                    fieldLabel: 'Password',
                                    labelWidth: 120,
                                    inputType: 'password',
                                    allowBlank: false,
                                    allowOnlyWhitespace: false
                                },
                                {
                                    xtype: 'textfield',
                                    id: 'frmAdminConfirm',
                                    itemId: 'frmAdminConfirm',
                                    width: 450,
                                    fieldLabel: 'Confirm Password',
                                    labelWidth: 120,
                                    inputType: 'password',
                                    allowBlank: false,
                                    allowOnlyWhitespace: false
                                },
                                {
                                    xtype: 'textfield',
                                    id: 'frmAdminEmail',
                                    itemId: 'frmAdminEmail',
                                    width: 450,
                                    fieldLabel: 'Email',
                                    labelWidth: 120,
                                    inputType: 'email',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    id: 'frmAdminAddress',
                                    itemId: 'frmAdminAddress',
                                    width: 450,
                                    fieldLabel: 'Address',
                                    labelWidth: 120,
                                    allowBlank: false,
                                    allowOnlyWhitespace: false,
                                    maxLength: 150,
                                    maxLengthText: 'Exceed maximum limit'
                                },
                                {
                                    xtype: 'textfield',
                                    id: 'frmAdminMobile',
                                    itemId: 'frmAdminMobile',
                                    width: 450,
                                    fieldLabel: 'Mobile Number',
                                    labelWidth: 120,
                                    allowBlank: false,
                                    allowOnlyWhitespace: false,
                                    maxLength: 11,
                                    regex: /^[1-9][0-9]*$/
                                },
                                {
                                    xtype: 'toolbar',
                                    items: [
                                        {
                                            xtype: 'button',
                                            id: 'btnSaveAdmin',
                                            itemId: 'btnSaveAdmin',
                                            text: 'Save Admin'
                                        },
                                        {
                                            xtype: 'button',
                                            id: 'btnResetAdmin',
                                            itemId: 'btnResetAdmin',
                                            text: 'Reset'
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