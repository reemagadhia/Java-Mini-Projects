	app.controller('buyerController', ['$scope', 'buyerService', function($scope, buyerService) {
			$scope.getBuyers = function(){
				var userb = buyerService.getBuyers();
				userb.then(function(result){
					$scope.userb = result.data;

				}, function(error){
					console.log(error);
				});
			}
			$scope.getBuyers();
	}]);