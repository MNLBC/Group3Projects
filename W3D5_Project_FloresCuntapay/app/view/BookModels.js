/*
 * File: app/view/BookModels.js
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

Ext.define('BMS.view.BookModels', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.bookmodels',

    requires: [
        'Ext.grid.Panel',
        'Ext.grid.column.Column',
        'Ext.form.Panel',
        'Ext.form.field.Display',
        'Ext.form.field.Text',
        'Ext.button.Button',
        'Ext.toolbar.Toolbar'
    ],

    shrinkWrap: 0,
    layout: 'border',
    collapsed: false,
    title: 'My Panel',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'gridpanel',
                    flex: 1,
                    region: 'center',
                    split: true,
                    itemId: 'list',
                    resizable: false,
                    title: '',
                    forceFit: true,
                    columns: [
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'title',
                            text: 'Title'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'author',
                            text: 'Author'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'publisher',
                            text: 'Publisher'
                        },
                        {
                            xtype: 'gridcolumn',
                            dataIndex: 'category',
                            text: 'Category'
                        }
                    ]
                },
                {
                    xtype: 'panel',
                    flex: 1,
                    region: 'east',
                    split: true,
                    itemId: 'display',
                    width: 150,
                    layout: 'card',
                    bodyBorder: true,
                    items: [
                        {
                            xtype: 'panel',
                            itemId: 'selectMessage',
                            layout: {
                                type: 'vbox',
                                align: 'center',
                                pack: 'center'
                            },
                            items: [
                                {
                                    xtype: 'container',
                                    flex: 1,
                                    html: '<h1>Please select a record</h1>'
                                }
                            ]
                        },
                        {
                            xtype: 'form',
                            itemId: 'details',
                            bodyPadding: 10,
                            items: [
                                {
                                    xtype: 'displayfield',
                                    fieldLabel: 'Title',
                                    name: 'title'
                                },
                                {
                                    xtype: 'displayfield',
                                    fieldLabel: 'Author',
                                    name: 'author'
                                },
                                {
                                    xtype: 'displayfield',
                                    fieldLabel: 'Publisher',
                                    name: 'publisher'
                                },
                                {
                                    xtype: 'displayfield',
                                    fieldLabel: 'Category',
                                    name: 'category'
                                }
                            ]
                        },
                        {
                            xtype: 'form',
                            itemId: 'form',
                            bodyPadding: 10,
                            title: 'Edit BookModel',
                            items: [
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'Title',
                                    name: 'title'
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'Author',
                                    name: 'author'
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'Publisher',
                                    name: 'publisher'
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'Category',
                                    name: 'category'
                                },
                                {
                                    xtype: 'container',
                                    padding: 10,
                                    layout: {
                                        type: 'hbox',
                                        align: 'middle',
                                        pack: 'center'
                                    },
                                    items: [
                                        {
                                            xtype: 'button',
                                            flex: 1,
                                            formBind: true,
                                            itemId: 'saveButton',
                                            margin: 5,
                                            text: 'Save'
                                        },
                                        {
                                            xtype: 'button',
                                            flex: 1,
                                            itemId: 'cancelButton',
                                            margin: 5,
                                            text: 'Cancel'
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            ],
            dockedItems: [
                {
                    xtype: 'toolbar',
                    dock: 'top',
                    items: [
                        {
                            xtype: 'button',
                            itemId: 'addButton',
                            text: 'Add'
                        },
                        {
                            xtype: 'button',
                            hidden: true,
                            itemId: 'editButton',
                            text: 'Edit'
                        },
                        {
                            xtype: 'button',
                            hidden: true,
                            itemId: 'removeButton',
                            text: 'Remove'
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

});