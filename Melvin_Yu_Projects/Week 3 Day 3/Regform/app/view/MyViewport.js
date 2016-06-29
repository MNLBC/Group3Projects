/*
 * File: app/view/MyViewport.js
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

Ext.define('MyApp.view.MyViewport', {
    extend: 'Ext.container.Viewport',
    alias: 'widget.myviewport',

    requires: [
        'MyApp.view.MyViewportViewModel',
        'Ext.form.Panel',
        'Ext.form.field.Date',
        'Ext.form.field.ComboBox',
        'Ext.form.RadioGroup',
        'Ext.form.field.Radio',
        'Ext.form.field.TextArea',
        'Ext.button.Button'
    ],

    viewModel: {
        type: 'myviewport'
    },

    items: [
        {
            xtype: 'form',
            autoScroll: true,
            width: '',
            bodyPadding: 10,
            title: 'Register To Melvin\'s Fan Page',
            layout: {
                type: 'vbox',
                align: 'center',
                pack: 'center'
            },
            items: [
                {
                    xtype: 'textfield',
                    width: 800,
                    fieldLabel: 'Full Name'
                },
                {
                    xtype: 'datefield',
                    flex: 1,
                    width: 800,
                    fieldLabel: 'Birthdate'
                },
                {
                    xtype: 'combobox',
                    flex: 1,
                    width: 800,
                    fieldLabel: 'Profession'
                },
                {
                    xtype: 'textfield',
                    width: 800,
                    fieldLabel: 'Email'
                },
                {
                    xtype: 'textfield',
                    width: 800,
                    fieldLabel: 'Address'
                },
                {
                    xtype: 'textfield',
                    flex: 1,
                    width: 800,
                    fieldLabel: 'Phone'
                },
                {
                    xtype: 'radiogroup',
                    height: 25,
                    width: 800,
                    fieldLabel: 'Gender',
                    items: [
                        {
                            xtype: 'radiofield',
                            boxLabel: 'Male'
                        },
                        {
                            xtype: 'radiofield',
                            boxLabel: 'Female'
                        }
                    ]
                },
                {
                    xtype: 'textareafield',
                    height: 150,
                    width: 800,
                    fieldLabel: 'Hobbies and Interest'
                },
                {
                    xtype: 'button',
                    flex: 1,
                    width: 234,
                    text: 'Submit'
                }
            ]
        }
    ]

});