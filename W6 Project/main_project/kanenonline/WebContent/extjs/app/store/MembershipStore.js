/*
 * File: app/store/MembershipStore.js
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

Ext.define('KanenOnlineShopping.store.MembershipStore', {
    extend: 'Ext.data.Store',

    requires: [
        'KanenOnlineShopping.model.Membership'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            model: 'KanenOnlineShopping.model.Membership',
            storeId: 'membershipStore',
            data: [
                {
                    membershipTypeId: 5000000005,
                    membershipTypeName: 'SENIOR',
                    discountRate: 20
                },
                {
                    membershipTypeId: 5000000004,
                    membershipTypeName: 'STUDENT',
                    discountRate: 20
                },
                {
                    membershipTypeId: 5000000003,
                    membershipTypeName: 'VIP',
                    discountRate: 30
                },
                {
                    membershipTypeId: 5000000002,
                    membershipTypeName: 'MEMBER',
                    discountRate: 5
                },
                {
                    membershipTypeId: 5000000001,
                    membershipTypeName: 'REGULAR',
                    discountRate: 0
                }
            ]
        }, cfg)]);
    }
});