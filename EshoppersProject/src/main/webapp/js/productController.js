	app.controller('productController', ['$scope', 'productService', function($scope, productService) {
		  $scope.category = {
				name : "",
				parent : ""
		  }; 
		  $scope.product = {
			    pName : "",
				pCode : "",
				category : "",
				principal :"",
				description : "",
				review : "",
				returnPolicy :"",
				stockLimit :"",
				maxLimit :"",
				tandc :"",
				offerStartDate :"",
				offerEndDate :""
		  }; 
		  $scope.getCategories = function(){
				var categories = productService.getCategories();
				categories.then(function(result){
					$scope.categories = result.data;

				}, function(error){
					console.log(error);
				});
		   }
		   $scope.getCategories();
		   $scope.saveCategory = function(category){
				var ctgy = productService.saveCategory(category);
				ctgy.then(function(result){
					$scope.getCategories();
					$scope.category = {
							name : "",
							parent : ""
					};
					$scope.categoryForm.$setPristine();
				}, function(error){
					console.log(error);
				});
			}
		   $scope.getCategoryById = function(CId){
			   var category = productService.getCategoryById(CId);
			   category.then(function(result){
				   var data = result.data;
				   $scope.category.name = data.category;
				   $scope.category.parent = data.parentCategory;
			   },function(error){
					console.log( error);
			   });
		   }
		   $scope.deleteCategory = function(CId){
				var category = productService.deleteCategory(CId);
				category.then(function(result){
					$scope.getCategories();
				}, function(error){
					console.log(error);
				});
			}
		   
		   $scope.getProducts = function(){
				var products = productService.getProducts();
				products.then(function(result){
					$scope.products = result.data;
				}, function(error){
					console.log(error);
				});
			}
		   $scope.getProducts();
		   $scope.deleteProduct = function(PId){
				var product = productService.deleteProduct(PId);
				product.then(function(result){
					$scope.getProducts();
				}, function(error){
					console.log(error);
				});
		   }
		   $scope.saveProduct = function(product){
			   /* var spefProduct = new Array();
			    var imgProduct = new Array();
			   $(".productSpef").each(function(){
				   var spef = {
				     type: $(this).find(".spefType").val(),
				     desc: $(this).find(".spefDesc").val()
				   };
				   alert(type);
				   $scope.product.spefProduct.push(spef);
			   });
			   $(".productImg").each(function(){
				   var img = {
				     img: $(this).find(".imgUrl").val(),
				     desc: $(this).find(".imgDesc").val()
				   };
				   $scope.product.imgProduct.push(img);
			   });*/
				var prdct = productService.saveProduct(product);
				
				prdct.then(function(result){
					 $scope.product = {
							    pName : "",
								pCode : "",
								category : "",
								principal :"",
								description : "",
								review : "",
								returnPolicy :"",
								stockLimit :"",
								maxLimit :"",
								tandc :"",
								offerStartDate :"",
								offerEndDate :""
						  }; 
					$scope.productForm.$setPristine();
				}, function(error){
					console.log(error);
				});
			}
		   $scope.getProductById = function(PId){
			   var product = productService.getCategoryById(PId);
			   product.then(function(result){
				   var data = result.data;
				   $scope.category.name = data.category;
				   $scope.category.parent = data.parentCategory;
			   },function(error){
					console.log( error);
			   });
			   $scope.category = {
						name : "",
						parent : ""
				};
		   }
		   
		   $scope.getOffers = function(){
				var offers = productService.getOffers();
				offers.then(function(result){
					$scope.offers = result.data;
				}, function(error){
					console.log(error);
				});
			}
		   $scope.getOffers();
	}]);