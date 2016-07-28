/*
 * File: app/view/WishListWindow.js
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

Ext.define('KanenOnlineShopping.view.WishListWindow', {
    extend: 'Ext.window.Window',

    requires: [
        'Ext.grid.Panel',
        'Ext.grid.View',
        'Ext.grid.column.Action',
        'Ext.toolbar.Toolbar',
        'Ext.toolbar.Spacer',
        'Ext.button.Button'
    ],

    height: 438,
    id: 'WishListWindow',
    itemId: 'WishListWindow',
    width: 730,
    title: 'Wish List',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'gridpanel',
                    id: 'wishListGridPanel',
                    itemId: 'wishListGridPanel',
                    store: 'wishListStore',
                    columns: [
                        {
                            xtype: 'gridcolumn',
                            renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
                                return '<img src="' + value + '"  width="150" height="150"  />';
                            },
                            maxWidth: 160,
                            minWidth: 160,
                            width: 160,
                            defaultWidth: 160,
                            dataIndex: 'imagePath',
                            text: 'Image',
                            flex: 1
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'productName',
                            text: 'Product Name',
                            flex: 1
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'productDescription',
                            text: 'Description',
                            flex: 1
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'productPrice',
                            text: 'Price',
                            flex: 1
                        },
                        {
                            xtype: 'actioncolumn',
                            icon: 'resource/trash.png',
                            items: [
                                {
                                    handler: function(view, rowIndex, colIndex, item, e, record, row) {
                                        var wishListGridPanel = Ext.getCmp('wishListGridPanel');
                                        var wishListStore = wishListGridPanel.getStore();

                                        var selectedRows = wishListStore.getAt(rowIndex);

                                        var wishListId = wishListStore.getAt(rowIndex).data.wishListId;


                                        Ext.Ajax.request({
                                            url : window.location.pathname+ 'wishList/removeFromWishList',
                                            method : 'POST',
                                            params : {
                                                wishListId : wishListId
                                            },
                                            scope : this,
                                            success : function(response) {
                                                wishListStore.remove(selectedRows);
                                                if(wishListStore.data.items.length === 0){
                                                    Ext.MessageBox.alert('Success','Your wish list is now empty');
                                                    Ext.getCmp('WishListWindow').close();
                                                }else{
                                                    Ext.MessageBox.alert('Success','Selected item was removed');
                                                }

                                            }
                                        });

                                    },
                                    icon: 'resource/trash.png'
                                }
                            ]
                        },
                        {
                            xtype: 'actioncolumn',
                            items: [
                                {
                                    handler: function(view, rowIndex, colIndex, item, e, record, row) {
                                        var wishListGridPanel = Ext.getCmp('wishListGridPanel');
                                        var wishListStore = wishListGridPanel.getStore();
                                        var cartStore = Ext.getStore('cartStore');
                                        var cartLength = cartStore.data.items.length;
                                        var alreadyInCart = false;
                                        var selectedRows = wishListStore.getAt(rowIndex);


                                        var wishListId = wishListStore.getAt(rowIndex).data.wishListId;

                                        Ext.Ajax.request({
                                            url : window.location.pathname+ 'wishList/removeFromWishList',
                                            method : 'POST',
                                            params : {
                                                wishListId : wishListId
                                            },
                                            scope : this,
                                            success : function(response) {
                                                var item = {
                                                    productId: wishListStore.getAt(rowIndex).data.productId,
                                                    productName: wishListStore.getAt(rowIndex).data.productName,
                                                    productDescription: wishListStore.getAt(rowIndex).data.productDescription,
                                                    productPrice: wishListStore.getAt(rowIndex).data.productPrice,
                                                    quantity: 1,
                                                    imagePath: wishListStore.getAt(rowIndex).data.imagePath
                                                };


                                                wishListStore.remove(selectedRows);
                                                if(cartLength > 0){
                                                    for(i = 0; i < cartStore.data.items.length; i++){
                                                        if(selectedRows.data.productId == cartStore.data.items[i].data.productId){
                                                            alreadyInCart = true;
                                                        }
                                                    }
                                                }else{
                                                    alreadyInCart = false;
                                                }

                                                if(alreadyInCart){
                                                    Ext.MessageBox.alert('Info','Item already in cart');
                                                }else{
                                                    cartStore.add(item);
                                                    Ext.MessageBox.alert('Success','Selected item added to carted');
                                                }

                                                if(wishListStore.data.items.length === 0){
                                                    Ext.MessageBox.alert('Success','Your wish list is now empty');
                                                    Ext.getCmp('WishListWindow').close();
                                                }else{
                                                    Ext.MessageBox.alert('Success','Selected item was removed');
                                                }
                                            }
                                        });


                                    },
                                    icon: 'resource/cartIcon.png'
                                }
                            ]
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
                            width: 500
                        },
                        {
                            xtype: 'button',
                            id: 'btnWLRemoveAll',
                            itemId: 'btnWLRemoveAll',
                            text: 'Remove All'
                        },
                        {
                            xtype: 'button',
                            id: 'btnWLAddAllToCart',
                            itemId: 'btnWLAddAllToCart',
                            text: 'Add all to Cart'
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});