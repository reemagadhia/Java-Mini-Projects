	 app.service('verifyService', function($http) {
		
		 this.verifyUser = function (code) {
		        return $http.post('verifyUser',{},{params:{
		        	code:code
		        }});
		 };
	});