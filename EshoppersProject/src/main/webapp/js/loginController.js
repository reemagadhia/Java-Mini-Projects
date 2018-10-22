app.controller('loginController', ['$scope', 'loginService', function($scope, loginService) {
			  $scope.user = {
					username : "",
					password : ""
			  };
			$scope.loginUser = function(user){
				var userl = loginService.loginUser(user);
				userl.then(function(result){
					
					var data = result.data;
					if(data.goto=="authentication")
					{
						window.location.href="authentication";
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
				}, function(error){
					console.log(error);
				});
			}
	}]);