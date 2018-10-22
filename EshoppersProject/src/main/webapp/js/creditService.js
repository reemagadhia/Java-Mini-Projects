 app.service('creditService', function($http) {
		
		 this.saveCredit = function (credit) {
		        return $http.put('SaveCredit',{},{params:{
		        	credit:credit
		        }});
		 };
		 this.getCreditById = function(creditId){
			 	return $http.get('GetCreditById/'+creditId);
		 };
	});