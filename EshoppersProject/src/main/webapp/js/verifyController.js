	app.controller('verifyController', ['$scope', 'verifyService', function($scope, verifyService) {
		  $scope.code = {
				  code : ""
		  }; 
		  $scope.verifyUser = function(code){
				var code = verifyService.verifyUser(code);
				code.then(function(result){
					var data = result.data;
					if(data.goto=="showAdmin")
					{
						window.location.href="showAdmin";
					}
					else if(data.goto=="display")
					{
						window.location.href="display";
					}
					else if(data.goto=="login")
					{
						window.location.href="login";
					}
					else{
						window.location.href="login";
					}
					$scope.verificationForm.$setPristine();
				}, function(error){
					console.log(error);
				});
			}
	}]);