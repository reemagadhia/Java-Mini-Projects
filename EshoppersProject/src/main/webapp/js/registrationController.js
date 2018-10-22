app.controller('registrationController', ['$scope', 'registrationService', function($scope, registrationService) {
			$scope.user={
					firstName : "",
					lastName : "",
					appliedFor : "",
					company : "",
					contact : "",
					userName : "",
					password : ""
			};
			$scope.getPendingUsers = function(){
				var userp = registrationService.getPendingUsers();
				userp.then(function(result){
					$scope.userp = result.data;

				}, function(error){
					console.log(error);
				});
			}
			$scope.getPendingUsers();
			$scope.getApprovedUsers = function(){
					var usera = registrationService.getApprovedUsers();
					usera.then(function(result){
						$scope.usera = result.data;

					}, function(error){
						console.log(error);
					});
				}
			$scope.getApprovedUsers();
			$scope.getCancelledUsers = function(){
				var userc = registrationService.getCancelledUsers();
				userc.then(function(result){
					$scope.userc = result.data;

				}, function(error){
					console.log(error);
				});
			}
			$scope.getCancelledUsers();
			$scope.authApprove = function(USERID){
				var userad = registrationService.authApprove(USERID);
				userad.then(function(result){
					$scope.getPendingUsers();
					$scope.getApprovedUsers();
					$scope.getCancelledUsers();
				}, function(error){
					console.log(error);
				});
			}
			$scope.authCancel = function(USERID){
				var userad = registrationService.authCancel(USERID);
				userad.then(function(result){
					$scope.getPendingUsers();
					$scope.getApprovedUsers();
					$scope.getCancelledUsers();
				}, function(error){
					console.log(error);
				});
			}
			$scope.saveUser = function(user){
				var userad = registrationService.saveUser(user);
				alert("HYyyyy");
				userad.then(function(result){
					alert("HYyyyy");
				$scope.user={
						firstName : "",
						lastName : "",
						appliedFor : "",
						company : "",
						contact : "",
						userName : "",
						password : ""
				};
				$scope.registrationForm.$setPristine();
			}, function(error){
				console.log(error);
			});
			}
	}]);