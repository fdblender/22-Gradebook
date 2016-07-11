package Servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
@WebServlet("/DisplayServlet")
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

		// get parameters from the session
		String name = request.getParameter("studentname");
		String type = request.getParameter("assignmenttype");
		List<Gradebook> assignments = null;

		if (name == null || name.trim().length() <= 0) {
			System.out.println("Name is empty");
		} else {
			System.out.println("DisplayServlet: student name is " + name);
		}

		if (type == null || type.trim().length() <= 0) {
			System.out.println("Type is empty");
		} else {
			System.out.println("DisplayServlet: type is " + type);
		}

		// get assignments for a selected student name and assignment type
		if (name != null && type != null) {

			assignments = GradebookDB.getAssignments(name, type);
		}

		// get assignments for a selected student
		else if (name != null && type == null) {

			// TO DO: pass in type to get assignments by name & type
			assignments = GradebookDB.getAssignmentsbyName(name);

		// get assignments for a selected assignment type
		} else if (name == null && type != null) {
			assignments = GradebookDB.getAssignmentsbyType(type);
		}

		HttpSession session = request.getSession();
		session.setAttribute("assignments", assignments);
		
		// redirect to assignments page to display assignments
		String nextURL = "/assignments.jsp";
		request.getRequestDispatcher(nextURL).forward(request, response);

		return;

	}

}
