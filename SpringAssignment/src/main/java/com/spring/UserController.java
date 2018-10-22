package com.spring;
 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pojo.Address;
import com.pojo.Role;
import com.pojo.User;
import com.pojo.UserDetails;
import com.service.UserService;
import com.service_impl.UserServiceImpl;



@Controller
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	UserService service;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView indexPage() {
		ModelAndView mv = new ModelAndView("index");
        return mv;
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	 public ModelAndView loginPageRedirect() {
       return new ModelAndView("redirect:Login");
    }
	
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	 public ModelAndView loginPage() {
      return new ModelAndView("login");
    }
	
	@RequestMapping(value = "/Display", method = RequestMethod.GET)
	 public ModelAndView displayPage() {
     return new ModelAndView("display");
	}
	
	@RequestMapping(value = "/Register", method = RequestMethod.GET)
	public ModelAndView registerPage() {	
	return new ModelAndView("register");
	}
	
	@RequestMapping(value = "/editOtherPage", method = RequestMethod.GET)
	public ModelAndView editOtherPage() {	
	return new ModelAndView("edit_other");
	}
	
	@RequestMapping(value = "/editAdminPage", method = RequestMethod.GET)
	public ModelAndView editAdminPage() {	
    return new ModelAndView("edit_admin");
	}
	
	@RequestMapping(value = "/AddAddress", method = RequestMethod.GET)
	public ModelAndView addAddress() {	
		return new ModelAndView("add_address");
	}
	
	@RequestMapping(value = "/editAddressPage", method = RequestMethod.GET)
	public ModelAndView editAddressPage() {	
		return new ModelAndView("edit_address");
	}
	
	@RequestMapping(value = "/ShowAddress", method = RequestMethod.GET)
	 public ModelAndView showAddressDetails() {
   return new ModelAndView("address");
	}
	
	//User Controllers
	
	@RequestMapping(value = "/LoginServlet", method = RequestMethod.POST)
	 public String loginController(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String luname = request.getParameter("luname");
		String lpwd = request.getParameter("lpwd");
		String status = "true";
		User user = new User();
		user.setUserName(luname);
		user.setPassword(lpwd);
		
		int userId=0,roleId=0;
		try{
			userId= service.checkUser(user);
		}
		catch(Exception e){
			String message = "Incorrect username or password. Please try again.";
	 		session.setAttribute("loginMessage", message);
			session.setAttribute("status","false");
			return "redirect:Login";
		}
		
		user = service.getUsersById(userId);
		try{
			roleId = user.getRole().getRoleId();
			session.setAttribute("userId", userId);
			if(userId>0 &&( roleId==1 || roleId ==2)){
				session.setAttribute("status", status);
				session.setAttribute("roleId", roleId);
				return "redirect:Display";
			}
			return "redirect:Login";
		}
		catch(Exception e)
		{	
			return "redirect:Login";
		}
    }
	
	@RequestMapping(value = "/ShowData", method = RequestMethod.GET)
	public @ResponseBody String ShowData(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<User> list = (ArrayList<User>)service.getUsers();
		String output = "";
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		session.setAttribute("status", "true");
		if (roleId == 1) {
			output += "<tr>"
					+ "<th>First Name</th>"
					+ "<th>Last Name</th>"
					+ "<th>Role</th>"
					+ "<th>Email</th>"
					+ "<th>Mobile No.</th>"
					+ "<th colspan=\"3\">Actions</th>"
					+ "</tr>";
			if(list!=null){
					for (User user : list) {
						output += "<tr>"
								+ "<td>"+user.getUserDetails().getFirstName()+"</td>"
								+ "<td>"+user.getUserDetails().getLastName()+"</td>"
								+ "<td>"+user.getRole().getRole()+"</td>"
								+ "<td>"+user.getUserDetails().getEmail()+"</td>"
								+ "<td>"+user.getUserDetails().getMobileNo()+"</td>"
								+ "<td colspan=\"3\">"
								+ "<a href=\"ShowAddress?id="+user.getUserDetails().getUserDetailsId()+"\" class=\"btn btn-address btn-sm\" role=\"button\">Address</a>"
								+ "<a href=\"EditAdminData?uid="+user.getUserId()+"&udid="+user.getUserDetails().getUserDetailsId()+"\" class=\"btn btn-edit btn-sm\" role=\"button\">Edit</a>"
								+ "<a href=\"DeleteServlet?uid="+user.getUserId()+"\" id=\"delete\" class=\"btn btn-delete btn-sm\" role=\"button\">Delete</a>"
								+ "</td>"
								+"</tr>";
					}
					output += "<tr>"
							+ "<td colspan=\"7\"><a href=\"Register\">+ Add New User</a>"
							+ "</td>"
							+ "</tr>";
			}
		}else{
			int userId = (Integer) session.getAttribute("userId");
			User user = service.getUsersById(userId);
			output += "<tr>"
					+ "<th>User Name</th>"
					+ "<th>Password</th>"
					+ "<th>First Name</th>"
					+ "<th>Last Name</th>"
					+ "<th>Email</th>"
					+ "<th>Mobile No.</th>"
					+ "<th colspan=\"3\">Actions</th>"
					+ "</tr>"
					+ "<tr>"
					+ "<td>"+user.getUserName()+"</td>"
					+ "<td>"+user.getPassword()+"</td>"
					+ "<td>"+user.getUserDetails().getFirstName()+"</td>"
					+ "<td>"+user.getUserDetails().getLastName()+"</td>"
					+ "<td>"+user.getUserDetails().getEmail()+"</td>"
					+ "<td>"+user.getUserDetails().getMobileNo()+"</td>"
					+ "<td colspan=\"3\">"
					+ "<a href=\"ShowAddress?id="+user.getUserDetails().getUserDetailsId()+"\" class=\"btn btn-address btn-sm\" role=\"button\">Address</a>"
					+ "<a href=\"EditOtherData?uid="+user.getUserId()+"&udid="+user.getUserDetails().getUserDetailsId()+"\" class=\"btn btn-edit btn-sm\" role=\"button\">Edit</a>"
					+ "</td>"
					+"</tr>";
			
		}
			return output;
    }
	
	@RequestMapping(value = "/EditAdminData", method = RequestMethod.GET)
	public String editAdminController(HttpServletRequest request) {	
		HttpSession session = request.getSession();
		int uid = Integer.parseInt(request.getParameter("uid"));
		int udid = Integer.parseInt(request.getParameter("udid"));
		session.setAttribute("userId", uid);
		session.setAttribute("userDetailsId", udid);
		User user = service.getUsersById(uid);
		session.setAttribute("user",user);
		
		return "redirect:editAdminPage";
		
	}
	
	@RequestMapping(value = "/EditOtherData", method = RequestMethod.GET)
	public String editOtherController(HttpServletRequest request) {	
		HttpSession session = request.getSession();
		int uid = Integer.parseInt(request.getParameter("uid"));
		int udid = Integer.parseInt(request.getParameter("udid"));
		session.setAttribute("userId", uid);
		session.setAttribute("userDetailsId", udid);
		User user = service.getUsersById(uid);
		session.setAttribute("user",user);
		
		return "redirect:editOtherPage";
	}
	
	
	@RequestMapping(value = "/EditOtherServlet", method = RequestMethod.POST)
	public String saveEditedOtherController(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute("status")== "true"){
			String userName = request.getParameter("uname");
			String password = request.getParameter("pwd");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			
			int userId = (Integer)session.getAttribute("userId");
			int userDetailsId = Integer.parseInt(request.getParameter("userDetailsId"));
			
			User user = service.getUsersById(userId);
			user.setUserName(userName);
			user.setPassword(password);
			user.setRole(user.getRole());
			UserDetails userDetails = new UserDetails(fname, lname, email, mobile,user);
			userDetails.setUserDetailsId(userDetailsId);
			Address address = service.getAddressById(userDetailsId);
			List<Address> addresses = new ArrayList<Address>();
			addresses.add(address);
			userDetails.setAddress(addresses);
			user.setUserDetails(userDetails);
			service.updateUser(user);
			session.setAttribute("status", "true");
			return "redirect:Display";
		}
		else
		{
			session.setAttribute("status", "false");
			return "redirect:Login";
		}

	}
	
	@RequestMapping(value = "/EditAdminServlet", method = RequestMethod.POST)
	public String saveEditedAdminController(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute("status")== "true"){
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			int userId = (Integer)session.getAttribute("userId");
			Role role = new Role();
			String roleType = request.getParameter("role");
			if("Admin".equals(roleType)){
				role.setRoleId(1);
				role.setRole("Admin");
			}
			else if("Buyer".equals(roleType)){
				role.setRoleId(2);
				role.setRole("Buyer");
			}
			int userDetailsId = Integer.parseInt(request.getParameter("userDetailsId"));
			User user = service.getUsersById(userId);
			user.setRole(role);
			UserDetails userDetails = new UserDetails(fname, lname, email, mobile,user);
			userDetails.setUserDetailsId(userDetailsId);
			user.setUserDetails(userDetails);
			service.updateUser(user);
			session.setAttribute("status", "true");
			return "redirect:Display";
		}
		else
		{
			session.setAttribute("status", "false");
			return "redirect:Login";
		}
	}
	
	@RequestMapping(value = "/AddDataServlet", method = RequestMethod.POST)
	public String insertDataController(HttpServletRequest request){
		HttpSession session = request.getSession();
		
		String userName = request.getParameter("uname");
		String password = request.getParameter("pwd");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String pincode = request.getParameter("pincode");
		
		Role role = new Role();
		String roleType = request.getParameter("role"); 
		if("Admin".equals(roleType)){
			role.setRoleId(1);
			role.setRole("Admin");
		}
		else if("Buyer".equals(roleType)){
			role.setRoleId(2);
			role.setRole("Buyer");
		}
		
		User user = new User(userName, password, role);
		session.setAttribute("user", user);
		UserDetails userDetails = new UserDetails(fname, lname, email, mobile, user);
		Address address = new Address(street, city, pincode, userDetails);
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address);
		userDetails.setAddress(addresses);
		user.setUserDetails(userDetails);
		service.addUser(user);
		String message = "Registered Successfully";
 		session.setAttribute("registerMessage", message);
 		return "redirect:Login";
	}
	
	@RequestMapping(value = "/DeleteServlet", method = RequestMethod.GET)
	 public String deleteController(HttpServletRequest request){
		HttpSession session = request.getSession();
		
		int roleId = (Integer) session.getAttribute("roleId");
		session.setAttribute("roleId", roleId);
		
		int userId = Integer.parseInt(request.getParameter("uid"));
		session.setAttribute("userId", userId);
		service.deleteUser(userId);
		return "redirect:Display";
	}
	
	//Address Controllers
	@RequestMapping(value = "/AddressDetails", method = RequestMethod.GET)
	public @ResponseBody String showAddressDetails(HttpServletRequest request){
		int userDetailsId = 0;
		String output ="";
		HttpSession session = request.getSession();
		try{
			userDetailsId = (Integer)session.getAttribute("userDetailsId");
			session.setAttribute("userDetailsId",userDetailsId);
			session.setAttribute("status", "true");
			ArrayList<Address> list = (ArrayList<Address>) service.getAddresses(userDetailsId);
			output += "<tr>"
					+ "<th>Street</th>"
					+ "<th>City</th>"
					+ "<th>Pincode</th>"
					+ "<th colspan=\"2\">Actions</th>"
					+ "</tr>";
			for (Address address : list) {
			
				output += "<tr>"
						+ "<td>"+address.getStreetName()+"</td>"
						+ "<td>"+address.getCityName()+"</td>"
						+ "<td>"+address.getPincode()+"</td>"
						+ "<td colspan=\"2\"><a href=\"EditAddress?aid="+address.getAddressId()+"&udid="+userDetailsId+"\" class=\"btn btn-edit btn-sm\" role=\"button\">Edit</a>"
						+ "<a href=\"DeleteAddressServlet?id="+address.getAddressId()+"\" class=\"btn btn-delete btn-sm\" role=\"button\">Delete</a>"
						+ "</td>"
						+"</tr>";
			}
			output += "<tr>"
					+"<td colspan=\"4\">"
					+ "<a href=\"AddAddress?id="+userDetailsId+"\">+ Add New Address</a></td>"
					+"</tr>";
		}catch(Exception e){
			e.printStackTrace();
			userDetailsId =(Integer) session.getAttribute("userDetailsId");
		}
		return output;
	}
	
	@RequestMapping(value = "/EditAddress", method = RequestMethod.GET)
	public String editAddressController(HttpServletRequest request) {	
		HttpSession session = request.getSession();
		int userDetailsId = Integer.parseInt(request.getParameter("udid"));
		int addressId = Integer.parseInt(request.getParameter("aid"));
		session.setAttribute("userDetailsId", userDetailsId);
		session.setAttribute("addressId", addressId);
		Address address = service.getAddressById(addressId);
		session.setAttribute("address",address);
		return "redirect:editAddressPage";
	}
	
	@RequestMapping(value = "/EditAddressServlet", method = RequestMethod.POST)
	public String saveEditedAddressController(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute("status")== "true"){
			String street = request.getParameter("street");
			String city = request.getParameter("city");
			String pincode = request.getParameter("pincode");
			int addressId = (Integer) session.getAttribute("addressId");
			int userDetailsId = Integer.parseInt(request.getParameter("userDetailsId"));
			UserDetails userDetails = new UserDetails(userDetailsId);
			Address address = new Address(addressId, userDetails);
			address.setStreetName(street);
			address.setCityName(city);
			address.setPincode(pincode);
			address.setUserDetails(userDetails);
			service.updateAddress(address);
			session.setAttribute("status", "true");
			return "redirect:ShowAddress";
		}
		else
		{
			session.setAttribute("status", "false");
			return "redirect:Login";
		}
	}
	
	@RequestMapping(value = "/AddAddressServlet", method = RequestMethod.POST)
	public String addAddressController(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute("status")== "true"){
			String street = request.getParameter("street");
			String city = request.getParameter("city");
			String pincode = request.getParameter("pincode");
			int userDetailsId = Integer.parseInt(request.getParameter("userDetailsId"));
			System.out.print(userDetailsId);
			session.setAttribute("userDetailsId", userDetailsId);
			UserDetails userDetails = new UserDetails(userDetailsId);
			Address address = new Address();
			address.setStreetName(street);
			address.setCityName(city);
			address.setPincode(pincode);
			address.setUserDetails(userDetails);
			service.addAddress(address);
			session.setAttribute("status", "true");
			return "redirect:ShowAddress";
		}
		else
		{
			session.setAttribute("status", "false");
			return "redirect:Login";
		}
	}
	
	@RequestMapping(value = "/DeleteAddressServlet", method = RequestMethod.GET)
	 public String deleteAddressController(HttpServletRequest request){
		HttpSession session = request.getSession();
		int addressId = Integer.parseInt(request.getParameter("id"));
		int userDetailsId =(Integer) session.getAttribute("userDetailsId");
		session.setAttribute("userDetailsId", userDetailsId);
		service.deleteAddress(addressId);
		return "redirect:ShowAddress";
	}
	
	@RequestMapping(value = "/LogoutServlet", method = RequestMethod.GET)
	 public String logoutController(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("status", "false");
		session.invalidate();
		HttpSession se = request.getSession();
		String message = "Successfully Logged out...";
 		se.setAttribute("logoutMessage", message);
		return "redirect:Login";
	}
}
