Ext.define('Office.store.Employee', {
	extend : 'Ext.data.Store',
	model : 'Office.model.Employee2',
	autoLoad : false,
	storeId : 'Employee'
});