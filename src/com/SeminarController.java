package com;

import registration.RegCostBean;
import registration.Register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Servlet implementation class SeminarController
 */
@WebServlet("/SeminarController")
public class SeminarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeminarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);
		
		String errorMessage = "";
        ServletContext servletContext = getServletContext();
        ServletConfig servletConfig = getServletConfig();
        
        RegCostBean rcb = new RegCostBean();
        
        if(request.getParameter("formType").equals("registrationPage")){
	        //validation checks on required parameters.  Forwards error to registrationError Page.
	        if(request.getParameterValues("courseListings")==null){
	        	errorMessage = "You have not entered any courses, Please go back and select courses to register for";
	        	request.setAttribute("error", errorMessage);
	        	RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/registrationError.jsp");
	        	dispatcher.forward(request, response);
	        }else if(request.getParameter("empStatus")==null){
	        	errorMessage = "You have not entered your employment status.  Please go back and select your Employment Status";
	        	request.setAttribute("error", errorMessage);
	        	RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/registrationError.jsp");
	        	dispatcher.forward(request, response);
	        }else{
	        	errorMessage = "";
	        	
		        //get necessary parameters for processing
		        String name = request.getParameter("name");
		        String [] courses = request.getParameterValues("courseListings");
		        String status = request.getParameter("empStatus");
		        String email = request.getParameter("email");
		        boolean hotel = false;
		        boolean parking = false;
		        
		      //determine boolean values for hotel and parking fees
		        if(request.getParameter("hotel")!=null){
		        	hotel = true;
		        	
		        }
		
		        if(request.getParameter("parking")!=null){
		        	parking = true;
		        }
		
		      //determine String Equivalent for the value associated with status Parameter
		        if(status.equals("jhuEmp")){
		        	status="JHU Employee";
		        }else if(status.equals("jhuStud")){
		        	status="JHU Student";
		        }else if(status.equals("speaker")){
		        	status="Speaker";
		        }else{
		        	status="Other";
		        }
		        
		        Register regUser = new Register(name, email, status);
		        regUser.calculateCourseFees(courses);
		       
		        
		        
		        rcb.setCourses(courses);
		        rcb.setEmail(email);
		        rcb.setHotelFee(regUser.calculateHotelFee());
		        rcb.setParkingFee(regUser.calculateParkingFee());
		        rcb.setTotalCost(regUser.calculateTotalFees(courses, hotel, parking));
		        rcb.setIndividualCost(regUser.calculateIndividualCourseCost());
		        rcb.setRegistrationType(status);
		        rcb.setWelcomeName(name);
		        
		        session.setAttribute("coursesLength", courses.length);
		        session.setAttribute("rcb", rcb);
		        session.setAttribute("coursesArray", courses);
		        session.setAttribute("coursesList", rcb.getCourses());
		        session.setAttribute("individualCourseCost", rcb.getIndividualCost());
		        session.setAttribute("hotelFee", rcb.getHotelFee());
		        session.setAttribute("hotelBoolean", hotel);
		        session.setAttribute("parkingBoolean", parking);
		        session.setAttribute("empStatus", status);
		        session.setAttribute("parkingFee", rcb.getParkingFee());
		        session.setAttribute("totalCost", rcb.getTotalCost());
		    	
		        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/registrationCosts.jsp");
		    	dispatcher.forward(request, response);
		        
			}
        }else if(request.getParameter("formType").equals("edit")){
        		// do something.
        		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/seminarRegistration.jsp");
        		dispatcher.forward(request, response);
        }else if(request.getParameter("formType").equals("confirm")){
        	//do something.
        	/// do what we do if they need to edit their information apart from "removing" a class
        }else if(request.getParameter("formType").equals("tableListingPage")){
        	rcb = (RegCostBean)session.getAttribute("rcb");
        	session.getAttribute("coursesList");
        	rcb.adjustCourseList((String)request.getParameter("removeCourse"), (List)session.getAttribute("coursesList"));
        	session.setAttribute("coursesList", rcb.getCourses());
        	
        	double updatedCost = rcb.getTotalCost() - rcb.getIndividualCost();
        	rcb.setTotalCost(updatedCost);	
	        session.setAttribute("totalCost", rcb.getTotalCost());
        	
        	RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/registrationCosts.jsp");
	    	dispatcher.forward(request, response);
        	
        	/// do what we do if they need to edit their information apart from "removing" a class
        }else{
        	RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/registrationError.jsp");
        	dispatcher.forward(request, response);
        }
	}
		

}
