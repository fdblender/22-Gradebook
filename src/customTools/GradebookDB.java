package customTools;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Gradebook;

public class GradebookDB {

	// get assignments for a selected student name
	public static List<Gradebook> getAssignmentsbyName(String name) {
		System.out.println("getAssignmentsbyName: " + name);

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Gradebook> assignments = null;
		// String qString = "select g from Gradebook g";
		String qString = "select g from Gradebook g where g.name = :studentname";

		try {
			TypedQuery<Gradebook> query = em.createQuery(qString, Gradebook.class);
			query.setParameter("studentname", name);
			assignments = query.getResultList();

			// for (Gradebook assignment: assignments) {
			// System.out.println(assignment.toString());
			// }

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return assignments;
	}

	// get assignments for a selected student name and assignment type
	public static List<Gradebook> getAssignments(String name, String type) {
		System.out.println("getAssignments for name & type: " + name + " " + type);

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Gradebook> assignments = null;
		String qString = "select g from Gradebook g where g.name = :studentname and g.type = :assignmenttype";

		try {
			TypedQuery<Gradebook> query = em.createQuery(qString, Gradebook.class);
			query.setParameter("studentname", name);
			query.setParameter("assignmenttype", type);
			assignments = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return assignments;
	}

	// get assignments for selected assignment type
	public static List<Gradebook> getAssignmentsbyType(String type) {
		System.out.println("getAssignmentsbyType: " + type);
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Gradebook> assignments = null;
		String qString = "select g from Gradebook g where g.type = :assignmenttype";

		try {
			TypedQuery<Gradebook> query = em.createQuery(qString, Gradebook.class);
			query.setParameter("assignmenttype", type);
			assignments = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return assignments;
	}

	// get average for student for a selected assignment type
		public static long getAverage(String name) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			long average = 0;

			String qString = "select g.type, avg(g.grade) from Gradebook+" 
					+ " from gradebook g"
					+ " where g.name = :studentname" 
					+ " group by g.type" + " order by g.type";

			try {
				TypedQuery<Gradebook> query = em.createQuery(qString, Gradebook.class);

				query.setParameter("studentname", name);			
				
				// TO DO:
				//average = query.getSingleResult();				
				

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				em.close();
			}
			return average;
		}
		
	// get average for student for a selected assignment type
	public static long getAverage(String name, String type) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		long average = 0;

		String qString = "select g.type, avg(g.grade) from Gradebook+" 
				+ " from gradebook g"
				+ " where g.name = :studentname and g.type = :assignmenttype" 
				+ " group by g.type" + " order by g.type";

		try {
			TypedQuery<Gradebook> query = em.createQuery(qString, Gradebook.class);

			query.setParameter("studentname", name);
			query.setParameter("assignmenttype", type);
			// average = query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return average;
	}

	// get average, min, and max for selected assignment type
	public static List<Object[]> getAggregateGrades() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		String qString = "select MIN(b.grade),MAX(b.grade), " + "AVG(b.grade) as grade,b.type "
				+ "from Gradebook b group by b.type";

		List<Object[]> report = null;
		try {
			report = em.createQuery(qString).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return report;
	}

}
