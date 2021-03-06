/*
 * File: app/controller/BookModels.js
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

Ext.define('BMS.controller.BookModels', {
    extend: 'Ext.app.Controller',
    alias: 'controller.bookmodels',

    requires: [
        'Ext.window.MessageBox',
        'Ext.util.Point'
    ],

    refs: [
        {
            ref: 'list',
            selector: 'bookmodels #list'
        },
        {
            ref: 'display',
            selector: 'bookmodels #display'
        },
        {
            ref: 'details',
            selector: 'bookmodels #details'
        },
        {
            ref: 'form',
            selector: 'bookmodels #form'
        },
        {
            ref: 'editButton',
            selector: 'bookmodels #editButton'
        },
        {
            ref: 'removeButton',
            selector: 'bookmodels #removeButton'
        }
    ],

    select: function(target, record) {
        // Set selected record
        this.selectedRecord = record;

        // Show details
        this.showView('details');

        // Load record into details
        this.getDetails().getForm().loadRecord(record);

        // Show edit/remove buttons
        this.getEditButton().show();
        this.getRemoveButton().show();
    },

    add: function(target) {
        var formPanel = this.getForm(),
            form = formPanel.getForm(),
            newRecord = Ext.create('model.bookmodel');

        // Clear form
        form.reset();

        // Set record
        form.loadRecord(newRecord);

        // Set title
        formPanel.setTitle('Add BookModel');

        // Show form
        this.showView('form');
    },

    edit: function(target) {
        var formPanel = this.getForm(),
            form = formPanel.getForm();

        // Load record model into form
        form.loadRecord(this.selectedRecord);

        // Set title
        formPanel.setTitle('Edit BookModel');

        // Show form
        this.showView('form');
    },

    save: function(target) {
        var form = this.getForm().getForm(),
            record = form.getRecord(),
            store = Ext.StoreManager.lookup('BookModels');

        // Valid
        if (form.isValid()) {

            // Update associated record with values
            form.updateRecord();

            // Add to store if new record
            if (record.phantom) {

                // TODO: Assign the record's ID from data source
                // Normally, this value would be auto-generated,
                // or returned from the server
                var id = store.count() + 1;
                record.set('id', id);

                // Add to store
                store.add(record);

            }

            // Commit changes
            store.commitChanges();

            // Display record
            this.select(this, record);

        }
    },

    cancelEdit: function(target) {
        // Show details
        this.showView('details');
    },

    remove: function(target) {
        var me = this;

        // Ask user to confirm this action
        Ext.Msg.confirm('Confirm Delete', 'Are you sure you want to delete this bookmodel?', function(result) {

            // User confirmed yes
            if (result == 'yes') {

                var record = me.getDetails().getForm().getRecord(),
                    store = me.getStore('BookModels');

                // Delete record from store
                store.remove(record);

                // Hide display
                me.showView('selectMessage');

                // Hide edit/remove buttons
                me.getEditButton().hide();
                me.getRemoveButton().hide();

            }

        });
    },

    showView: function(view) {
        this.getDisplay().getLayout().setActiveItem(view);
    },

    init: function(application) {
        this.control({
            "bookmodels #list": {
                select: this.select
            },
            "bookmodels #addButton": {
                click: this.add
            },
            "bookmodels #editButton": {
                click: this.edit
            },
            "bookmodels #saveButton": {
                click: this.save
            },
            "bookmodels #cancelButton": {
                click: this.cancelEdit
            },
            "bookmodels #removeButton": {
                click: this.remove
            }
        });
    }

});
