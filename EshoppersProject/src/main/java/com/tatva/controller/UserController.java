package com.tatva.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tatva.model.Category;
import com.tatva.model.Credit;
import com.tatva.model.Product;
import com.tatva.model.User;
import com.tatva.other.classes.GetDate;
import com.tatva.service.UserService;

@Controller
public class UserController {

	@Autowired
	@Qualifier("userService")
	UserService service;
	
	public UserController() {
	}
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView indexPage() {
		ModelAndView mv = new ModelAndView("index.jsp");
        return mv;
    }
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	 public ModelAndView userViewPage() {
		return new ModelAndView("login");
    }
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	 public ModelAndView addUserPage() {
		return new ModelAndView("register");
   }
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	 public ModelAndView displayPage() {
    return new ModelAndView("display");
	}
	@RequestMapping(value = "/buyers", method = RequestMethod.GET)
	 public ModelAndView buyersPage() {
   return new ModelAndView("buyers");
	}
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView productsPage() {
		return new ModelAndView("products");
	}
	@RequestMapping(value = "/suppliers", method = RequestMethod.GET)
	public ModelAndView suppliersPage() {
		return new ModelAndView("suppliers");
	}
	@RequestMapping(value = "/offers", method = RequestMethod.GET)
	public ModelAndView offersPage() {
		return new ModelAndView("offers");
	}
	@RequestMapping(value = "/authentication", method = RequestMethod.GET)
	public ModelAndView authenticationPage() {
		return new ModelAndView("authentication");
	}
	@RequestMapping(value = "/credit", method = RequestMethod.GET)
	public ModelAndView creditPage() {
		return new ModelAndView("credit");
	}
	@RequestMapping(value = "/showAdmin", method = RequestMethod.GET)
	public ModelAndView showAdmin() {
		return new ModelAndView("showAdmin");
	}
	@RequestMapping(value = "/adminAdd", method = RequestMethod.GET)
	public ModelAndView adminAdd() {
		return new ModelAndView("adminAdd");
	}
	@RequestMapping(value = "/adminAuth", method = RequestMethod.GET)
	public ModelAndView adminAuth() {
		return new ModelAndView("adminAuth");
	}
	@RequestMapping(value = "/verifyUser", method = RequestMethod.POST)
	public @ResponseBody String verifyUser(HttpServletRequest request) throws JSONException{
		String string = request.getParameter("code");
		JSONObject json = new JSONObject(string);
		int code = (Integer)json.get("code");
		if(code == 000000){
			return "{\"goto\":\"showAdmin\"}";
		}
		else if(code == 000001){
			return "{\"goto\":\"display\"}";
		}
		else{
			return "{\"goto\":\"login\"}";
		}
	}
	
	@RequestMapping(value="/getUserById/{id}", method=RequestMethod.GET)
	public @ResponseBody String getUserById(@PathVariable int id){
		User user = service.getUserById(id);
		JSONObject object = new JSONObject(user);
		return object.toString();
	}
	@RequestMapping(value="/AuthApprove/{id}", method=RequestMethod.GET)
	public  @ResponseBody String AuthApprove(@PathVariable int id){
		User user = service.getUserById(id);
		user.setStatus("Approved");
		service.addUser(user);
		return "";
	}
	@RequestMapping(value="/AuthCancel/{id}", method=RequestMethod.GET)
	public  @ResponseBody String AuthCancel(@PathVariable int id){
		User user = service.getUserById(id);
		user.setStatus("Cancelled");
		service.addUser(user);
		return "";
	}
	@RequestMapping(value = "/DeleteUser/{id}", method = RequestMethod.GET)
	public @ResponseBody String deleteUser(@PathVariable int id){
		service.deleteUser(id);
		return "";
	}
	
	@RequestMapping(value = "/LoginServlet", method = RequestMethod.POST)
	 public @ResponseBody String loginController(HttpServletRequest request) throws JSONException {
		HttpSession session = request.getSession();
		String string = request.getParameter("user");
		JSONObject json = new JSONObject(string);
		String luname = (String)json.get("username");
		String lpwd = (String)json.get("password");
		User user = new User(luname, lpwd);
		int userId = 0;
		userId = service.checkUser(user);
		User user1 = service.getUserById(userId);
	    if(userId>0){
			String appliedFor = user1.getAppliedFor();
			String status = user1.getStatus();
			if((appliedFor.equals("Supplier")||appliedFor.equals("Admin"))&&(status.equals("Approved"))){
				session.setAttribute("appliedFor", appliedFor);
				return "{\"goto\":\"authentication\"}";
			}
			else if((appliedFor.equals("Buyer"))&&(status.equals("Approved"))){
				session.setAttribute("appliedFor", appliedFor);
				return "{\"goto\":\"display\"}";
			}
			else{
				return "{\"goto\":\"login\"}";
			}
	    }
	    else{
			return "{\"goto\":\"login\"}";
		}
    }
	
	@RequestMapping(value = "/saveAdmin", method = RequestMethod.POST)
	public @ResponseBody String saveAdmin(HttpServletRequest request) throws JSONException{
		String string = request.getParameter("user");
		JSONObject json = new JSONObject(string);
		String firstName = (String)json.get("firstName");
		String lastName = (String)json.get("lastName");
		String company = (String)json.get("company");
		String contact = (String)json.get("contact");
		String userName = (String)json.get("userName");
		String password = (String)json.get("password");
		String appliedFor = "Admin";
		String status = "Approved";
		Date regDate = GetDate.getDateTime();
		User user = new User(userName, password, appliedFor, regDate, status, firstName, lastName, company, contact);
		service.addUser(user);
		return "";
	}
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public @ResponseBody String saveUser(HttpServletRequest request) throws JSONException{
		String string = request.getParameter("user");
		JSONObject json = new JSONObject(string);
		String firstName = (String)json.get("firstName");
		String lastName = (String)json.get("lastName");
		String company = (String)json.get("company");
		String contact = (String)json.get("contact");
		String userName = (String)json.get("userName");
		String password = (String)json.get("password");
		String appliedFor = (String)json.get("appliedFor");
		String status = "Pending";
		Date regDate = GetDate.getDateTime();
		User user = new User(userName, password, appliedFor, regDate, status, firstName, lastName, company, contact);
		service.addUser(user);
		return "";
	}
	
	@RequestMapping(value = "/GetPendingUsersServlet", method = RequestMethod.GET)
	public @ResponseBody String GetPendingUsersServlet(HttpServletRequest request) throws JSONException{
		HttpSession session = request.getSession();
		
		List<User> users = service.getUsers();
		JSONArray arr = new JSONArray();
		
		for(User item : users) {
			if(item.getStatus().equals("Pending")){
				JSONObject object = new JSONObject();
				object.put("USERID", item.getUid());
				object.put("FIRSTNAME", item.getFirstName());
				object.put("LASTNAME", item.getLastName());
				object.put("USERNAME", item.getUserName());
				object.put("COMPANY", item.getCompany());
				object.put("CONTACT", item.getContact());
				object.put("APPLIEDFOR", item.getAppliedFor());
				object.put("REGDATE", item.getRegDate());
				object.put("STATUS", item.getStatus());
				arr.put(object);
			}
		}
		return arr.toString();
	}
	@RequestMapping(value = "/GetApprovedUsersServlet", method = RequestMethod.GET)
	public @ResponseBody String GetApprovedUsersServlet(HttpServletRequest request) throws JSONException{
		List<User> users = service.getUsers();
		JSONArray arr = new JSONArray();
		
		for(User item : users) {
			if((item.getStatus().equals("Approved"))&&(!item.getAppliedFor().equals("Admin"))){
				JSONObject object = new JSONObject();
				object.put("USERID", item.getUid());
				object.put("FIRSTNAME", item.getFirstName());
				object.put("LASTNAME", item.getLastName());
				object.put("USERNAME", item.getUserName());
				object.put("COMPANY", item.getCompany());
				object.put("CONTACT", item.getContact());
				object.put("APPLIEDFOR", item.getAppliedFor());
				object.put("REGDATE", item.getRegDate());
				object.put("STATUS", item.getStatus());
				arr.put(object);
			}
		}
		return arr.toString();
	}
	@RequestMapping(value = "/GetCancelledUsersServlet", method = RequestMethod.GET)
	public @ResponseBody String GetCancelledUsersServlet(HttpServletRequest request) throws JSONException{
		List<User> users = service.getUsers();
		JSONArray arr = new JSONArray();
		
		for(User item : users) {
			if(item.getStatus().equals("Cancelled")){
				JSONObject object = new JSONObject();
				object.put("USERID", item.getUid());
				object.put("FIRSTNAME", item.getFirstName());
				object.put("LASTNAME", item.getLastName());
				object.put("USERNAME", item.getUserName());
				object.put("COMPANY", item.getCompany());
				object.put("CONTACT", item.getContact());
				object.put("APPLIEDFOR", item.getAppliedFor());
				object.put("REGDATE", item.getRegDate());
				object.put("STATUS", item.getStatus());
				arr.put(object);
			}
		}
		return arr.toString();
	}
	@RequestMapping(value = "/GetBuyers", method = RequestMethod.GET)
	public @ResponseBody String getBuyers(HttpServletRequest request) throws JSONException{
		List<User> users = service.getUsers();
		JSONArray arr = new JSONArray();
		
		for(User item : users) {
			if((item.getAppliedFor().equals("Buyer"))&&(item.getStatus().equals("Approved"))){
				JSONObject object = new JSONObject();
				object.put("USERNAME", item.getUserName());
				object.put("FIRSTNAME", item.getFirstName());
				object.put("LASTNAME", item.getLastName());
				object.put("EMAIL", item.getUserName());
				object.put("COMPANY", item.getCompany());
				object.put("CONTACT", item.getContact());
				arr.put(object);
			}
		}
		return arr.toString();
	}
	@RequestMapping(value = "/GetAdmins", method = RequestMethod.GET)
	public @ResponseBody String getAdmins(HttpServletRequest request) throws JSONException{
		List<User> users = service.getUsers();
		JSONArray arr = new JSONArray();
		
		for(User item : users) {
			if((item.getAppliedFor().equals("Admin"))&&(item.getStatus().equals("Approved"))){
				JSONObject object = new JSONObject();
				object.put("UID", item.getUid());
				object.put("USERNAME", item.getUserName());
				object.put("FIRSTNAME", item.getFirstName());
				object.put("LASTNAME", item.getLastName());
				object.put("EMAIL", item.getUserName());
				object.put("COMPANY", item.getCompany());
				object.put("CONTACT", item.getContact());
				arr.put(object);
			}
		}
		return arr.toString();
	}
	@RequestMapping(value = "/GetSuppliers", method = RequestMethod.GET)
	public @ResponseBody String GetSuppliers(HttpServletRequest request) throws JSONException{
		List<User> users = service.getUsers();
		JSONArray arr = new JSONArray();
		
		for(User item : users) {
			if(item.getAppliedFor().equals("Supplier")){
				JSONObject object = new JSONObject();
				object.put("SID", item.getUid());
				object.put("USERNAME", item.getUserName());
				object.put("FIRSTNAME", item.getFirstName());
				object.put("LASTNAME", item.getLastName());
				object.put("EMAIL", item.getUserName());
				object.put("COMPANY", item.getCompany());
				object.put("CONTACT", item.getContact());
				arr.put(object);
			}
		}
		return arr.toString();
	}
	@RequestMapping(value = "/GetCategories", method = RequestMethod.GET)
	public @ResponseBody String getCategories(HttpServletRequest request) throws JSONException{
		List<Category> categories = service.getCategories();
		JSONArray arr = new JSONArray();
		
		for(Category item : categories) {
			JSONObject object = new JSONObject();
			object.put("CId", item.getCid());
			object.put("Category", item.getCategory());
			object.put("Parent", item.getParentCategory());
			arr.put(object);
		}
		return arr.toString();
	}
	@RequestMapping(value = "/AddCategory", method = RequestMethod.PUT)
	public @ResponseBody String AddCategory(HttpServletRequest request) throws JSONException{
		String string = request.getParameter("category");
		JSONObject json = new JSONObject(string);
		String name = (String)json.get("name");
		String parent = (String)json.get("parent");
		Category category = new Category(name, parent);
		service.addCategory(category);
		return "";
	}
	@RequestMapping(value="/GetCategoryById/{id}", method=RequestMethod.GET)
	public @ResponseBody String GetCategoryById(@PathVariable int id){
		Category category = service.getCategoryById(id);
		JSONObject object = new JSONObject(category);
		return object.toString();
	}
	@RequestMapping(value="/GetCategoryByName/{name}", method=RequestMethod.GET)
	public @ResponseBody String GetCategoryByName(@PathVariable String name){
		Category category = service.getCategoryByName(name);
		JSONObject object = new JSONObject(category);
		return object.toString();
	}
	@RequestMapping(value = "/DeleteCategory/{id}", method = RequestMethod.GET)
	public @ResponseBody String deleteCategory(@PathVariable int id){
		service.deleteCategory(id);
		return "";
	}
	
	@RequestMapping(value = "/GetProducts", method = RequestMethod.GET)
	public @ResponseBody String GetProducts(HttpServletRequest request) throws JSONException{
		List<Product> product = service.getProducts();
		JSONArray arr = new JSONArray();
		
		for(Product item : product) {
			JSONObject object = new JSONObject();
			object.put("Name", item.getName());
			object.put("Code", item.getCode());
			object.put("Category", item.getCategory().getCategory());
			object.put("Supplier", item.getUser().getFirstName()+" "+item.getUser().getLastName());
			object.put("StockAvailable", item.getStockLimit());
			object.put("MaxStock", item.getMaxLimit());
			object.put("OfferStartDate", item.getOfferStartDate());
			object.put("OfferEndDate", item.getOfferEndDate());
			object.put("PId", item.getPid());
			arr.put(object);
		}
		return arr.toString();
	}
	@RequestMapping(value = "/AddProduct", method = RequestMethod.PUT)
	public @ResponseBody String AddProduct(HttpServletRequest request) throws JSONException{

		String string = request.getParameter("product");
		
		JSONObject json = new JSONObject(string);
		String pName = (String)json.get("pName");
		String pCode = (String)json.get("pCode");
		String description = (String)json.get("description");
		String review = (String)json.get("review");
		String returnPolicy = (String)json.get("returnPolicy");
		String stockLimit = (String)json.get("stockLimit");
		String maxLimit = (String)json.get("maxLimit");
		String tandc = (String)json.get("tandc");
		
		String offerStartDate = (String) json.get("offerStartDate");
		String offerEndDate = (String) json.get("offerEndDate");

		String categoryName = (String)json.get("category");
		Category category = service.getCategoryByName(categoryName);
		category.setCid(category.getCid());
		
		String principal = (String)json.get("principal");
		User user = service.getUserByName(principal);
		user.setUid(user.getUid());
		
		Product product = new Product(pName, pCode, description, review, returnPolicy, stockLimit, maxLimit, tandc, user, category);
		service.addProduct(product);
		return "";
		
	}
	
	@RequestMapping(value = "/GetOffers", method = RequestMethod.GET)
	public @ResponseBody String GetOffers(HttpServletRequest request) throws JSONException{
		List<Product> product = service.getProducts();
		JSONArray arr = new JSONArray();
		for(Product item : product) {
			Date date1  = item.getOfferEndDate();
			if (!(date1.before(GetDate.getDateTime()))) {
			JSONObject object = new JSONObject();
			object.put("Name", item.getName());
			object.put("Code", item.getCode());
			object.put("OfferStartDate", item.getOfferStartDate());
			object.put("OfferEndDate", item.getOfferEndDate());
			object.put("PId", item.getPid());
			arr.put(object);
			}
		}
		return arr.toString();
	}
	@RequestMapping(value = "/DeleteProduct/{id}", method = RequestMethod.GET)
	public @ResponseBody String deleteProduct(@PathVariable int id){
		service.deleteProduct(id);
		return "";
	}
	@RequestMapping(value = "/SaveCredit", method = RequestMethod.PUT)
	public @ResponseBody String SaveCredit(HttpServletRequest request) throws JSONException{
		String string = request.getParameter("credit");
		JSONObject json = new JSONObject(string);
		String supplier = (String)json.get("supplier");
		String tandc = (String)json.get("tandc");
		User user = service.getUserByName(supplier);
		user.setUid(user.getUid());
		Credit credit = new Credit(tandc, user);
		service.addCredit(credit);
		return "";
	}
	@RequestMapping(value="/GetCreditById", method=RequestMethod.GET)
	public @ResponseBody String GetCreditById(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Credit credit = service.getCreditById(id);
		JSONObject json = new JSONObject(credit);
		return json.toString();
	}
	@RequestMapping(value = "/LogoutController", method = RequestMethod.GET)
	public String LogoutController(HttpServletRequest request) throws JSONException{
		HttpSession session = request.getSession();
		session.setAttribute("status", "false");
		session.invalidate();
		return "redirect:login";
	}
}
