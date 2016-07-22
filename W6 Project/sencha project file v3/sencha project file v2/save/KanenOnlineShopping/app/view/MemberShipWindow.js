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
        'Ext.form.field.ComboBox',
        'Ext.button.Button'
    ],

    height: 340,
    hidden: false,
    html: '<html>\n<head>\n\n</head>\n<body>\n</br>\nTypes of Membership:</br>\nVIP can avail 30% discount</br>\nStudent/Senior  can avail 20% discount</br>\nMember can avail 5% discount</br>\n</body>\n</html>',
    id: 'memberShipWindow',
    itemId: 'MemberShipWindow',
    width: 499,
    title: 'My Window',
    modal: true,

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'combobox',
                    id: 'memberShipField',
                    itemId: 'memberShipField',
                    width: 340,
                    fieldLabel: 'Label',
                    store: [
                        'Member',
                        'VIP',
                        'Student',
                        'Senior'
                    ]
                },
                {
                    xtype: 'button',
                    height: 35,
                    id: 'btnSendRequest',
                    itemId: 'btnSendRequest',
                    width: 93,
                    text: 'Send'
                }
            ]
        });

        me.callParent(arguments);
    }

});