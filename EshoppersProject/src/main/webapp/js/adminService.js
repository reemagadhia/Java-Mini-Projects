	 app.service('adminService', function($http) {
		
		 this.getAdmins = function () {
		    return $http.get('GetAdmins');
		 };
		 this.saveAdmin = function (user) {
	        return $http.post('saveAdmin',{},{params:{
	        	user:user
	        }});
		 };
		 this.getUserById = function(UID){
			 	return $http.get('getUserById/'+UID);
		 };
		 this.deleteUser = function (UID) {
		        return $http.get('DeleteUser/'+UID);
		 };
	});