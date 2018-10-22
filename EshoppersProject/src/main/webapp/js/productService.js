	 app.service('productService', function($http) {
		
		 this.getCategories = function () {
		        return $http.get('GetCategories');
		 };
		 this.saveCategory = function (category) {
		        return $http.put('AddCategory',{},{params:{
		        	category:category
		        }});
		 };
		 this.getCategoryById = function(CId){
			 	return $http.get('GetCategoryById/'+CId);
		 };
		 this.deleteCategory = function (CId) {
		        return $http.get('DeleteCategory/'+CId);
		 };
		 
		 this.getProducts = function () {
		        return $http.get('GetProducts');
		 };
		 this.deleteProduct = function (PId) {
		        return $http.get('DeleteProduct/'+PId);
		 };
		 this.saveProduct = function (product) {
			 return $http.put('AddProduct',{},{params:{
				 product:product
		        }});
		 };
		 this.getProductById = function(PId){
			 	return $http.get('GetProductById/'+PId);
		 };
		 
		 this.getOffers = function () {
		        return $http.get('GetOffers');
		 };
	});