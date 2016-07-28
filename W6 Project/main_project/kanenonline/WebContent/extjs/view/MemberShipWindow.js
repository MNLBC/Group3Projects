/*
 * File: app/view/MemberShipWindow.js
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

Ext.define('KanenOnlineShopping.view.MemberShipWindow', {
    extend: 'Ext.window.Window',

    requires: [
        'Ext.toolbar.Spacer',
        'Ext.form.Label',
        'Ext.form.field.ComboBox',
        'Ext.form.field.TextArea',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button'
    ],

    height: 396,
    id: 'memberShipWindow',
    itemId: 'MemberShipWindow',
    width: 530,
    title: 'Membeship Request',
    modal: true,

    layout: {
        type: 'vbox',
        align: 'center',
        pack: 'center'
    },

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            dockedItems: [
                {
                    xtype: 'tbspacer',
                    flex: 1,
                    dock: 'top',
                    height: 20
                }
            ],
            items: [
                {
                    xtype: 'label',
                    text: 'Types of Membership:'
                },
                {
                    xtype: 'label',
                    text: 'VIP can avail 30% discount'
                },
                {
                    xtype: 'label',
                    text: 'Student/Senior  can avail 20% discount'
                },
                {
                    xtype: 'label',
                    text: 'Member can avail 5% discount'
                },
                {
                    xtype: 'tbspacer',
                    flex: 0,
                    height: 50
                },
                {
                    xtype: 'combobox',
                    id: 'memberShipField',
                    itemId: 'memberShipField',
                    width: 340,
                    fieldLabel: 'Membership Type',
                    allowBlank: false,
                    allowOnlyWhitespace: false,
                    store: [
                        'REGULAR',
                        'MEMBER',
                        'VIP',
                        'STUDENT',
                        'SENIOR'
                    ]
                },
                {
                    xtype: 'textareafield',
                    flex: 0,
                    id: 'membershipRequestRemarks',
                    itemId: 'membershipRequestRemarks',
                    width: 340,
                    fieldLabel: 'Remarks'
                },
                {
                    xtype: 'toolbar',
                    flex: 0,
                    width: 217,
                    items: [
                        {
                            xtype: 'button',
                            height: 35,
                            id: 'btnSendRequest',
                            itemId: 'btnSendRequest',
                            width: 201,
                            text: 'Send'
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});