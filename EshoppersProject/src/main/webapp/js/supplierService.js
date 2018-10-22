	 app.service('supplierService', function($http) {
		
		 this.getSuppliers = function () {
		        return $http.get('GetSuppliers');
		 };
	});