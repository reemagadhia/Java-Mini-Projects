app.service('loginService', function( $http) {
		
		 this.loginUser = function (user) {
		        return $http.post('LoginServlet',{},{params:{
		        	user:user
		        }});
		 };
	 });