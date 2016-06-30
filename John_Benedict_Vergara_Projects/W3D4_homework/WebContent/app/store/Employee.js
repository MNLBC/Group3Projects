Ext.define('Employees.store.Employee',
{
    extend: 'Ext.data.Store',
    model: 'Employees.model.Employee',
    autoLoad: false,
    storeId: 'Employee'
});