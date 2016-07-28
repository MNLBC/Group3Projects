/*
 * File: app.js
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

// @require @packageOverrides
Ext.Loader.setConfig({
    enabled: true
});


Ext.application({
    models: [
        'User',
        'Product',
        'CartItem',
        'Order',
        'OrderItem',
        'Membership',
        'WishList'
    ],
    stores: [
        'productsStore',
        'orderStore',
        'cartStore',
        'orderItemStore',
        'userStore',
        'MembershipStore',
        'wishListStore'
    ],
    views: [
        'MyViewport',
        'itemContainer',
        'MyViewport1',
        'LoginWindow',
        'RegistrationWindow',
        'RegisterWindow',
        'CartWindow',
        'UserWindow',
        'ChangePassWindow',
        'MemberShipWindow',
        'CommentWindow',
        'WishListWindow'
    ],
    controllers: [
        'productController',
        'MyController'
    ],
    name: 'KanenOnlineShopping',

    launch: function() {
        Ext.create('KanenOnlineShopping.view.MyViewport');
    }

});
