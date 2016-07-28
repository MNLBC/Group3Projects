/*
 * File: app/view/CommentWindow.js
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

Ext.define('KanenOnlineShopping.view.CommentWindow', {
    extend: 'Ext.window.Window',

    requires: [
        'Ext.form.field.TextArea',
        'Ext.container.Container',
        'Ext.toolbar.Spacer',
        'Ext.button.Button'
    ],

    height: 259,
    hidden: false,
    id: 'commentWindow',
    itemId: 'commentWindow',
    padding: 20,
    width: 460,
    bodyPadding: '',
    title: 'Comment',

    layout: {
        type: 'vbox',
        align: 'center'
    },

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'textareafield',
                    height: 100,
                    id: 'txtAreaComment',
                    itemId: 'txtAreaComment',
                    width: 350,
                    fieldLabel: 'Comment',
                    maxLength: 200,
                    maxLengthText: 'The maximum length for this field is 200'
                },
                {
                    xtype: 'container',
                    flex: 1,
                    layout: {
                        type: 'hbox',
                        align: 'middle'
                    },
                    items: [
                        {
                            xtype: 'tbspacer',
                            height: '',
                            width: 100
                        },
                        {
                            xtype: 'button',
                            height: 36,
                            id: 'btnSendComment',
                            itemId: 'btnSendComment',
                            width: 143,
                            text: 'Send',
                            listeners: {
                                click: {
                                    fn: me.onButtonClick,
                                    scope: me
                                }
                            }
                        },
                        {
                            xtype: 'button',
                            height: 36,
                            id: 'btnCommentCancel',
                            itemId: 'btnCommentCancel',
                            width: 143,
                            text: 'Cancel'
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    },

    onButtonClick: function(button, e, eOpts) {
        KanenOnlineShopping.app.getController('productController').sendComment(this.productId);
    }

});