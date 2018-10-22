<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <style type="text/css">
    <%@include file="../../css/bootstrap.min.css" %>
    <%@include file="../../css/mystyle.css" %>
  </style>
  
  <script type="text/javascript">
  	  <%@include file="../../js/jquery.min.js" %>
	  <%@include file="../../js/bootstrap.min.js" %>
  </script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
</head>
<body ng-app="myApp" ng-controller="productController">
	<div class="container-fluid">
		<div class="header">
			   <nav class="navbar navbar-expand-lg navbar-light bg-light">
				  <a class="navbar-brand" href="#">EShoppers</a>
				  <div class="collapse navbar-collapse" id="navbarNav"> 
				  	<div class="row">
						<div class="col-sm-10">
						    <ul class="navbar-nav" type="none">
						      <li class="nav-item">
						        <a class="nav-link" href="display">Registrations</a>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link" href="orders">Orders</a>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link" href="buyers">Buyers List</a>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link" href="suppliers">Suppliers List</a>
						      </li>
						      <li class="nav-item active">
						        <a class="nav-link" href="products">Manage Products</a>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link" href="offers">Active Offers</a>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link" href="credit">Supplier Credit Integration</a>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link-logout" href="LogoutController">Logout</a>
						      </li>
						    </ul>
				         </div>
				         <div class="col-sm-2">
				         </div>
				    </div>
				  </div>
				</nav>
		</div>
	</div>
	<div class="container-fluid">
		<div class="content">
			<div class="container">
				<div class="row">
								<div class="col-xs-12">
									<div class="tab2">
										<ul class="nav nav-tabs" role="tablist">
											<li role="presentation" class="active">
											<a href="#Categories" aria-controls="Categories" role="tab"data-toggle="tab">Manage Categories</a>
											</li>
											<li role="presentation">
											<a href="#Products" aria-controls="Products" role="tab" data-toggle="tab">Manage Products</a>
											</li>
										</ul>
										<div class="tab-content">
											<div role="tabpanel" class="tab-pane active" id="Categories">
												<form class="form-horizontal" action="" name="categoryForm" id="categoryForm">
													   <div class="form-group"> 
													 	 <div class="col-sm-offset-10 col-sm-2">
													      <a role="button" id = "categoryButton" class="btn btn-login btn-lg" data-toggle="modal" href="#" data-target=".category-modal-md">+ Add Category</a>
													    </div>
													  </div>
												</form>
												<table class="table table-hover">
								                      <thead>
								                          <tr>
								                          	  <th>Category</th>
								                              <th>Parent Category</th>
								                              <th colspan="2">Actions</th>
								                          </tr>
								                      </thead>
								                      <tbody>
								                          <tr ng-repeat="c in categories">
								                          	  <td>{{c.Category}}</td>
								                              <td>{{c.Parent}}</td>
								                              <td><a data-toggle="modal" href="#" data-target=".category-modal-md" ng-click="getCategoryById(c.CId);">Edit</a></td>
															  <td><a href="" ng-click="deleteCategory(c.CId)">Delete</a></td>
								                          </tr>
								                      </tbody>
								                  </table>
											</div>
											<div role="tabpanel" class="tab-pane" id="Products">
												<form class="form-horizontal" action="" name="productForm" id="productForm">
												   <div class="form-group"> 
												 	 <div class="col-sm-offset-10 col-sm-2">
												      <a role="button" id = "productButton" class="btn btn-login btn-lg" data-toggle="modal" href="#" data-target=".product-modal-lg">+ Add Product</a>
												    </div>
												  </div>
												</form>
												<table class="table table-hover">
								                      <thead>
								                          <tr>
								                          	  <th>Product Name</th>
								                              <th>Product Code</th>
								                              <th>Product Category</th>
								                        	  <th>Supplier Name</th>      
								                              <th>Stock Available</th>
								                              <th>Max Stock Limit</th>
								                              <th>Offer Start Date</th>
															  <th>Offer End Date</th>
								                              <th colspan="2">Actions</th>
								                          </tr>
								                      </thead>
								                      <tbody>
								                          <tr ng-repeat="p in products">
								                          	  <td>{{p.Name}}</td>
								                              <td>{{p.Code}}</td>
								                              <td>{{p.Category}}</td>
								                              <td>{{p.Supplier}}</td>
								                              <td>{{p.StockAvailable}}</td>
								                              <td>{{p.MaxStock}}</td>
								                              <td>{{p.OfferStartDate}}</td>
															  <td>{{p.OfferEndDate}}</td>
								                              <td><a href="" ng-click="editUserData(p.PId);">Edit</a></td>
															  <td><a href="" ng-click="deleteProduct(p.PId);">Delete</a></td>
								                          </tr>
								                      </tbody>
								                  </table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade category-modal-md" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">

		<div class="container">
			<div class="modal-dialog modal-md" role="document">

				<div class="modal-content">

					<div class="row">
						<div class="col-xs-12">
							<div class="col-xs-10">
								<h4 class="modal-title">Add/Edit Category</h4>
							</div>
							<div class="col-xs-2">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<form class="form-horizontal" action="" name="categoryForm" id="categoryForm">
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="category"><span class="required">*</span>Category</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="category" ng-model="category.name" name="category" placeholder="Enter Category">
								    </div>
								    <div class="col-sm-12">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="parent">Parent Category</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="parent" ng-model="category.parent" name="parent" placeholder="Enter Parent Category">
								    </div>
								    <div class="col-sm-12">
								      
								    </div>
								  </div>
								   <div class="form-group"> 
								 	 <div class="col-sm-offset-7 col-sm-5">
								      <button type="submit" id = "SaveCategory" class="btn btn-login btn-lg" ng-click="saveCategory(category)">Save</button>
								    </div>
								  </div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade product-modal-lg" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">

		<div class="container">
			<div class="modal-dialog modal-lg" role="document">

				<div class="modal-content">

					<div class="row">
						<div class="col-xs-12">
							<div class="col-xs-10">
								<h4 class="modal-title">Add/Edit Product</h4>
							</div>
							<div class="col-xs-2">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<form class="form-horizontal" action="" name="productForm" id="productForm">
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="pName"><span class="required">*</span>Product Name</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="pName" ng-model="product.pName" name="pName" placeholder="Product Name">
								    </div>
								    <div class="col-sm-12">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="pCode">Product Code</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="pCode" ng-model="product.pCode" name="pCode" placeholder="Enter Product Code">
								    </div>
								    <div class="col-sm-12">
								      
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="category">Product Category</label>
								    <div class="col-sm-8">
								    <select class="selectpicker form-control" id="category" ng-model="product.category" name="category">
										 <option ng-repeat="c in categories" value="c.CId">{{c.Category}}</option>
									</select>
								    </div>
								    <div class="col-sm-12">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="principal">Principal</label>
								    <div class="col-sm-8" ng-controller="supplierController">
								      <select class="selectpicker form-control" id="principal" ng-model="product.principal" name="principal">
										 <option ng-repeat="s in usersu" value="s.SId">{{s.FIRSTNAME}}</option>
									  </select>
								    </div>
								    <div class="col-sm-12">
								      
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="description">Description</label>
								    <div class="col-sm-8">
								      <textarea class="form-control" ng-model="product.description" name="description" rows="5" id="description" placeholder="Enter Product Description"></textarea>
								    </div>
								    <div class="col-sm-12">
								      
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="review">Review</label>
								    <div class="col-sm-8">
								      <textarea class="form-control" ng-model="product.review" name="review" rows="5" id="review" placeholder="Enter Product Review"></textarea>
								    </div>
								    <div class="col-sm-12">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="returnPolicy">Return Policy</label>
								    <div class="col-sm-8">
								      <textarea class="form-control" ng-model="product.returnPolicy" name="returnPolicy" rows="5" id="returnPolicy" placeholder="Enter Return Policy"></textarea>
								    </div>
								    <div class="col-sm-12">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="stockLimit">Stock Level Information</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" ng-model="product.stockLimit" name="stockLimit" id="stockLimit" placeholder="Enter Stock Limit">
								    </div>
								    <div class="col-sm-12">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="maxLimit">Maximum Purchase Limit</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" ng-model="product.maxLimit" name="maxLimit" id="maxLimit" placeholder="Enter Max Limit">
								    </div>
								    <div class="col-sm-12">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="tandc">Terms and Conditions</label>
								    <div class="col-sm-8">
								      <textarea class="form-control" ng-model="product.tandc" name="tandc" rows="5" id="tandc" placeholder="Enter Terms and Conditions"></textarea>
								    </div>
								    <div class="col-sm-12">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="offerStartDate">Offer Start Date</label>
								    <div class="col-sm-8">
								      <input type="date" class="form-control" ng-model="product.offerStartDate" name="offerStartDate" id="offerStartDate" placeholder="Offer Start Date">
								    </div>
								    <div class="col-sm-12">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4" for="offerEndDate">Offer End Date</label>
								    <div class="col-sm-8">
								      <input type="date" class="form-control" ng-model="product.offerEndDate" name="offerEndDate"  id="offerEndDate" placeholder="Offer End Date">
								    </div>
								    <div class="col-sm-12">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4">Product Specifications</label>
								    <div class="col-sm-7">
									    <div id="repeatSpef" class="productSpef">
										    <div class="col-sm-5 productLeft">
										      <input type="text" class="form-control-product" id="type" name="type" placeholder="Type" class="spefType" value="">
										    </div>
										    <div class="col-sm-5 productRight">
										      <input type="text" class="form-control-product" id="spefDescription" name="spefDescription" placeholder="Description" class="spefDesc" value="">
										    </div>
									    </div>
									    <div class="col-sm-2">
								    		<button type="button" class="button" id = "" onclick="repeatSpef()">+</button>
								    	</div>
								    </div>
								    <div class="col-sm-12">
								    </div>
								  </div>
								  <div class="form-group">
								    <label class="control-label col-sm-4">Product Images</label>
								    <div class="col-sm-7">
									    <div id="repeatImg" class="productImg">
										    <div class="col-sm-5 productLeft">
										      <input type="text" class="form-control-product" id="url" ng-model="product.url" name="url" placeholder="Url" class="imgUrl">
										    </div>
										    <div class="col-sm-5 productRight">
										      <input type="text" class="form-control-product" id="imgDescription" ng-model="imgDescription" name="imgDescription" placeholder="Description" class="imgDesc">
										    </div>
									    </div>
									    <div class="col-sm-2">
								    		<button type="button" class="button" id = "" onclick="repeatImg()">+</button>
								    	</div>
								    </div>
								    
								    <div class="col-sm-12">
								    </div>
								  </div>
								   <div class="form-group"> 
								 	 <div class="col-sm-offset-9 col-sm-3">
								      <button type="submit" id = "SaveProduct" class="btn btn-login btn-lg" ng-click="saveProduct(product)">Save</button>
								    </div>
								  </div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
	$('.category-modal-md').on('hidden.bs.modal', function () {
	    $(this).find('form').trigger('reset');
	})
	$('.product-modal-md').on('hidden.bs.modal', function () {
	    $(this).find('form').trigger('reset');
	})
	var i = 0;
	var original = document.getElementById('repeatImg');

	function repeatImg() {
	  var clone = original.cloneNode(true);
	  clone.id = "repeatImg1" + ++i; 
	  original.parentNode.appendChild(clone);
	}
	
	var j = 0;
	var original = document.getElementById('repeatSpef');

	function repeatSpef() {
	  document.getElementById('type').value='';
	  document.getElementById('spefDescription').value='';
	  var clone = original.cloneNode(true);
	  clone.id = "repeatSpef1" + ++j; 
	  original.parentNode.appendChild(clone);
	}
	</script>
<script type="text/javascript">
	<%@include file="../../js/app.js" %>
	<%@include file="../../js/productService.js" %>
	<%@include file="../../js/productController.js" %>
	<%@include file="../../js/supplierService.js" %>
	<%@include file="../../js/supplierController.js" %>
</script>
</body>
</html>