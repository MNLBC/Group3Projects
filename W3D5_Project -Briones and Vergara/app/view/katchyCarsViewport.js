/*
 * File: app/view/katchyCarsViewport.js
 *
 * This file was generated by Sencha Architect version 3.1.0.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 5.0.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 5.0.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('KatchyCars.view.katchyCarsViewport', {
    extend: 'Ext.container.Viewport',
    alias: 'widget.katchycarsviewport',

    requires: [
        'KatchyCars.view.katchyCarsViewportViewModel',
        'Ext.form.Panel',
        'Ext.form.FieldSet',
        'Ext.form.field.TextArea',
        'Ext.toolbar.Toolbar',
        'Ext.toolbar.Spacer',
        'Ext.button.Button',
        'Ext.form.FieldContainer'
    ],

    viewModel: {
        type: 'katchycarsviewport'
    },
    id: 'katchyCarsViewport',
    itemId: 'katchyCarsViewport',

    layout: {
        type: 'hbox',
        align: 'middle',
        pack: 'center'
    },
    items: [
        {
            xtype: 'form',
            height: 430,
            id: 'frmRegistration',
            itemId: 'frmRegistration',
            width: 516,
            bodyPadding: 10,
            title: 'Registration Form',
            items: [
                {
                    xtype: 'fieldset',
                    height: 137,
                    width: 495,
                    title: 'My Fields',
                    items: [
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'txtRegUsername',
                            fieldLabel: 'Username:',
                            allowBlank: false,
                            allowOnlyWhitespace: false
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'txtRegPassword',
                            fieldLabel: 'Password:',
                            inputType: 'password',
                            allowBlank: false,
                            allowOnlyWhitespace: false
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'txtRegConfirmPassword',
                            fieldLabel: 'Confrim Password:',
                            inputType: 'password',
                            allowBlank: false,
                            allowOnlyWhitespace: false
                        }
                    ]
                },
                {
                    xtype: 'fieldset',
                    title: 'My Fields',
                    items: [
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'txtFullname',
                            fieldLabel: 'Full name',
                            allowBlank: false,
                            allowOnlyWhitespace: false
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'txtEmail',
                            fieldLabel: 'E-mail',
                            allowBlank: false,
                            allowOnlyWhitespace: false,
                            regex: /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
                            regexText: 'Invalid E-mail'
                        },
                        {
                            xtype: 'textareafield',
                            anchor: '100%',
                            id: 'txtAddress',
                            fieldLabel: 'Address',
                            allowBlank: false,
                            allowOnlyWhitespace: false
                        },
                        {
                            xtype: 'textfield',
                            anchor: '100%',
                            id: 'txtMobileNumber',
                            fieldLabel: 'Mobile Number',
                            allowBlank: false,
                            allowOnlyWhitespace: false
                        }
                    ]
                }
            ],
            dockedItems: [
                {
                    xtype: 'toolbar',
                    dock: 'bottom',
                    items: [
                        {
                            xtype: 'tbspacer',
                            width: 170
                        },
                        {
                            xtype: 'button',
                            id: 'btnRegRegister',
                            itemId: 'btnRegRegister',
                            text: 'Register'
                        },
                        {
                            xtype: 'button',
                            id: 'btnRegReset',
                            itemId: 'btnRegReset',
                            text: 'Reset'
                        },
                        {
                            xtype: 'button',
                            id: 'btnRegCancel',
                            itemId: 'btnRegCancel',
                            text: 'Cancel'
                        }
                    ]
                }
            ]
        },
        {
            xtype: 'form',
            frame: true,
            height: 226,
            id: 'frmLogin',
            itemId: 'frmLogin',
            width: 478,
            layout: 'vbox',
            bodyPadding: 10,
            title: 'Login Form',
            items: [
                {
                    xtype: 'fieldcontainer',
                    flex: 1,
                    height: 120,
                    width: 463,
                    fieldLabel: '',
                    layout: {
                        type: 'vbox',
                        align: 'stretch',
                        padding: 20
                    },
                    items: [
                        {
                            xtype: 'textfield',
                            flex: 1,
                            id: 'txtLoginUsername',
                            itemId: 'txtLoginUsername',
                            width: 275,
                            fieldLabel: 'Username',
                            allowBlank: false,
                            allowOnlyWhitespace: false
                        },
                        {
                            xtype: 'textfield',
                            flex: 1,
                            id: 'txtLoginPassword',
                            itemId: 'txtLoginPassword',
                            fieldLabel: 'Password',
                            inputType: 'password',
                            allowBlank: false,
                            allowOnlyWhitespace: false
                        },
                        {
                            xtype: 'toolbar',
                            flex: 1,
                            height: 50,
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
                                    id: 'btnLoginExit',
                                    itemId: 'btnLoginExit',
                                    width: 70,
                                    text: 'Exit'
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    ]

});