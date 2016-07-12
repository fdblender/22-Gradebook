package Servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.GradebookDB;
import model.Gradebook;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();	
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String aggregate = request.getParameter("aggregate");
		String nextURL;
		List<Gradebook> assignments = null;
		List<Object[]> agglist = null;
		boolean wantAggregates = false;

		/*if (name == "" ) {		
			System.out.println("DisplayServlet: Name is empty");
		} else {
			System.out.println("DisplayServlet: student name is " + name);
			assignments = GradebookDB.getAssignmentsbyName(name);
		}

		if (type == "" ) {		
			System.out.println("DisplayServlet: Type is empty");
		} else {
			System.out.println("DisplayServlet: type is " + type);
		}*/
		
		System.out.println("Aggregate string: "+aggregate);
		if (aggregate.equals("yes")) {
			
			System.out.println("Aggregate string: "+aggregate);
			agglist = GradebookDB.getAggregateGrades();			
			
			wantAggregates = true;
		} 

		// get assignments for a selected student name and assignment type
		else if (name != "" && type != "") {

			assignments = GradebookDB.getAssignments(name, type);
		}

		// get assignments for a selected student
		else if (name != "" && type == "") {
			
			System.out.println("Report Servlet for selected student: "+name);

			// TO DO: pass in type to get assignments by name & type
			assignments = GradebookDB.getAssignmentsbyName(name);

		
		} 
		else if (name == "" && type != "") {
			// get assignments for a selected assignment type
			assignments = GradebookDB.getAssignmentsbyType(type);
		} 		
				
		if (wantAggregates) {
			
			System.out.println("calling aggReport");
			
			StringBuffer report = new StringBuffer();
			
			// DEBUG: print aggregate report to console
			for (Object[] r: agglist){
				 System.out.print(r[0].toString());
				 System.out.print("\t");
				 System.out.print(r[1].toString());
				 System.out.print("\t");
				 System.out.print(r[2].toString());
				 System.out.print("\t");
				 System.out.println(r[3].toString());
				 report.append("<tr><td>"+r[0].toString() + "</td><td>"+r[1].toString()+"</td><td>"+r[2].toString()+"</td></tr>");
				 }				
			
			session.setAttribute("reportstring", report.toString());			
			nextURL = "/aggReport.jsp";
		} else {		
		
			session.setAttribute("assignments", assignments);		
			// redirect to assignments page to display assignments
			nextURL = "/detailReport.jsp";
		}
		
		request.getRequestDispatcher(nextURL).forward(request, response);

		return;

	}

}
