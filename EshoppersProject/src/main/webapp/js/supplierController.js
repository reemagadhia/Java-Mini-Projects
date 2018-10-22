	app.controller('supplierController', ['$scope', 'supplierService', function($scope, supplierService) {
			$scope.getSuppliers = function(){
				var usersu = supplierService.getSuppliers();
				usersu.then(function(result){
					$scope.usersu = result.data;

				}, function(error){
					console.log(error);
				});
			}
			$scope.getSuppliers();
	}]);