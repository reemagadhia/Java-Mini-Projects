	app.controller('adminController', ['$scope', 'adminService', function($scope, adminService) {
		$scope.user={
				firstName : "",
				lastName : "",
				company : "",
				contact : "",
				userName : "",
				password : ""
		};
		$scope.getAdmins = function(){
			var userad = adminService.getAdmins();
			userad.then(function(result){
				$scope.userad = result.data;

			}, function(error){
				console.log(error);
			});
		}
		$scope.getAdmins();
		$scope.saveAdmin = function(user){
			var userad = adminService.saveAdmin(user);
			userad.then(function(result){
			$scope.getUserById(UID);
			$scope.user={
					firstName : "",
					lastName : "",
					company : "",
					contact : "",
					userName : "",
					password : ""
			};
			$scope.adminForm.$setPristine();
		}, function(error){
			console.log(error);
		});
		}
		$scope.getUserById = function(UID){
			   var userad = adminService.getUserById(UID);
			   userad.then(function(result){
				   var data = result.data;
				   $scope.user.firstName = data.firstName;
				   $scope.user.lastName = data.lastName;
				   $scope.user.company = data.company;
				   $scope.user.contact = data.contact;
				   $scope.user.userName = data.userName;
				   $scope.user.password = data.password;
			   },function(error){
					console.log( error);
			   });
		}
		$scope.deleteUser = function(UID){
			var userad = adminService.deleteUser(UID);
			userad.then(function(result){
				$scope.getAdmins();
			}, function(error){
				console.log(error);
			});
		}
	}]);