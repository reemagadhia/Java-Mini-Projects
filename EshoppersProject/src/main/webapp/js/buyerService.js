	 app.service('buyerService', function($http) {
		
		 this.getBuyers = function () {
		        return $http.get('GetBuyers');
		 };
	});