/*
 * File: app/view/ProductDetailsWindow.js
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

Ext.define('KanenOnlineShopping.view.ProductDetailsWindow', {
    extend: 'Ext.window.Window',

    requires: [
        'Ext.toolbar.Spacer',
        'Ext.form.Label',
        'Ext.Img',
        'Ext.toolbar.Toolbar',
        'Ext.button.Button'
    ],

    height: 497,
    id: 'ProductDetailsWindow',
    itemId: 'ProductDetailsWindow',
    width: 410,
    title: 'Product Details',
    modal: true,

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'container',
                    height: 460,
                    width: 410,
                    items: [
                        {
                            xtype: 'tbspacer',
                            height: 20
                        },
                        {
                            xtype: 'container',
                            layout: {
                                type: 'hbox',
                                align: 'middle'
                            },
                            items: [
                                {
                                    xtype: 'tbspacer',
                                    flex: 0,
                                    width: 60
                                },
                                {
                                    xtype: 'label',
                                    height: 16,
                                    width: 100,
                                    text: 'My Label'
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            height: '',
                            width: 410,
                            layout: {
                                type: 'vbox',
                                align: 'center',
                                pack: 'center'
                            },
                            items: [
                                {
                                    xtype: 'image',
                                    height: 230,
                                    width: 241,
                                    src: 'resource/laptop.png'
                                },
                                {
                                    xtype: 'label',
                                    flex: 1,
                                    text: 'My Label'
                                }
                            ]
                        },
                        {
                            xtype: 'container',
                            height: 50,
                            width: 410,
                            layout: {
                                type: 'vbox',
                                align: 'center'
                            },
                            items: [
                                {
                                    xtype: 'label',
                                    flex: 1,
                                    text: 'My Label'
                                },
                                {
                                    xtype: 'label',
                                    flex: 1,
                                    text: 'My Label'
                                }
                            ]
                        },
                        {
                            xtype: 'tbspacer',
                            height: 20
                        },
                        {
                            xtype: 'container',
                            height: 50,
                            items: [
                                {
                                    xtype: 'toolbar',
                                    height: 80,
                                    width: 410,
                                    layout: {
                                        type: 'hbox',
                                        pack: 'center'
                                    },
                                    items: [
                                        {
                                            xtype: 'button',
                                            cls: 'btnCart',
                                            height: 52,
                                            id: 'btnAddtoCart',
                                            itemId: 'btnAddtoCart',
                                            style: '.btnCart {\n    background: url(resource/cartIcon.png) !important;\n    width: 50px;\n    height: 45px;\n}',
                                            width: 53,
                                            text: ''
                                        },
                                        {
                                            xtype: 'button',
                                            height: 52,
                                            id: 'btnAddFavorite',
                                            itemId: 'btnAddFavorite',
                                            style: '.btnFavorite {\n    background: url(resource/favorite.png) !important;\n    width: 50px;\n    height: 45px;\n}',
                                            width: 53,
                                            text: ''
                                        },
                                        {
                                            xtype: 'button',
                                            height: 52,
                                            id: 'btnAddComment',
                                            itemId: 'btnAddComment',
                                            style: 'background: url(resource/comment.png) !important;\nwidth: 50px;\nheight: 45px;',
                                            width: 53,
                                            text: '',
                                            listeners: {
                                                click: {
                                                    fn: me.onButtonClick,
                                                    scope: me
                                                }
                                            }
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
    },

    onButtonClick: function(button, e, eOpts) {
        KanenOnlineShopping.app.getController('productController').showCommentWindow(this.productId);
    }

});