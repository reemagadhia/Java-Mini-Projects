	app.controller('creditController', ['$scope', 'creditService', function($scope, creditService) {
		  $scope.credit = {
				supplier : "",
				tandc : ""
		  };
		   $scope.saveCredit = function(credit){

				var credit = creditService.saveCredit(credit);
				credit.then(function(result){
					$scope.credit = {
							supplier : "",
							tandc : ""
					  };
				}, function(error){
					console.log(error);
				});
			}
		   $scope.getCreditById = function(creditId){
			   var credit = creditService.getCreditById(creditId);
			   credit.then(function(result){
				   var data = result.data;
				   $scope.credit.supplier = data.supplier;
				   $scope.credit.tandc = data.tandc;
			   },function(error){
					console.log( error);
			   });
		   }
	}]);