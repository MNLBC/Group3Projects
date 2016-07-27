/*
 * File: app/store/product.js
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

Ext.define('MyApp.store.product', {
    extend: 'Ext.data.Store',

    requires: [
        'MyApp.model.product',
        'Ext.data.proxy.Ajax',
        'Ext.data.reader.Json'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            model: 'MyApp.model.product',
            storeId: 'product',
            data: [
                {
                    productId: 'quis',
                    productName: 'omnis',
                    productDescription: 'Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.',
                    productPrice: 'atque',
                    productStockQuantity: 'saepe',
                    productImagePath: 'dolorem'
                },
                {
                    productId: 'iure',
                    productName: 'et',
                    productDescription: 'Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum.',
                    productPrice: 'itaque',
                    productStockQuantity: 'qui',
                    productImagePath: 'repellat'
                }
            ],
            proxy: {
                type: 'ajax',
                reader: {
                    type: 'json'
                }
            }
        }, cfg)]);
    }
});