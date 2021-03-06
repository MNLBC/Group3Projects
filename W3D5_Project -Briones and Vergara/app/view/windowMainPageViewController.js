/*
 * File: app/view/windowMainPageViewController.js
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

Ext.define('KatchyCars.view.windowMainPageViewController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.windowmainpage',

    onGridCarsForSaleRowClick: function(tableview, record, tr, rowIndex, e, eOpts) {
        var recordData = record.data;
        var windowMainPage = Ext.getCmp('windowMainPage');
        var lblCarManufacturer = windowMainPage.query('#lblCarManufacturer')[0];
        var lblCarModel = windowMainPage.query('#lblCarModel')[0];
        var lblCarYear = windowMainPage.query('#lblCarYear')[0];
        var lblCarColor = windowMainPage.query('#lblCarColor')[0];
        var lblCarTransmission = windowMainPage.query('#lblCarTransmission')[0];
        var lblCarFuel = windowMainPage.query('#lblCarFuel')[0];
        var lblCarPrice = windowMainPage.query('#lblCarPrice')[0];
        var lblCarSeller = windowMainPage.query('#lblCarSeller')[0];

        lblCarManufacturer.setText(recordData.carManufacturer);
        lblCarModel.setText(recordData.carModel);
        lblCarYear.setText(recordData.carYear);
        lblCarColor.setText(recordData.carColor);
        lblCarTransmission.setText(recordData.carTransmission);
        lblCarFuel.setText(recordData.carFuel);
        lblCarPrice.setText(recordData.carPrice);
        lblCarSeller.setText(recordData.carSeller);
    }

});
