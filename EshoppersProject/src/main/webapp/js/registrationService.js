	 app.service('registrationService', function($http) {
		
		 this.getPendingUsers = function () {
		        return $http.get('GetPendingUsersServlet');
		 };
		 this.getApprovedUsers = function () {
		        return $http.get('GetApprovedUsersServlet');
		 };
		 this.getCancelledUsers = function () {
		        return $http.get('GetCancelledUsersServlet');
		 };
		 this.authApprove = function(USERID){
			 	return $http.get('AuthApprove/'+USERID);
		 };
		 this.authCancel = function(USERID){
			 	return $http.get('AuthCancel/'+USERID);
		 };
		 this.saveUser = function (user) {
		        return $http.post('saveUser',{},{params:{
		        	user:user
		        }});
		 };
	});