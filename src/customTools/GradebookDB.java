package customTools;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Gradebook;

public class GradebookDB {	
	
	/*// returns a string containing the HTML to generate a table of assignments
		public static StringBuilder getAssignmentTable(List<Gradebook> assignments) {

			StringBuilder table = new StringBuilder();
			long studentname;
			String assignment;
			Date dategraded;			
			long grade;
			

			table.append("<table>");// get gravatar        
			table.append("<tr><th>Student Name</th><th>Assignment</th><th>Date</th>th>Grade</th></tr>");
			
			for (Gradebook a : assignments) {

				table.append(public static List<Gradebook> getAssignments(String name)
			    {
			        EntityManager em = DBUtil.getEmFactory().createEntityManager();
			        List<Gradebook> assignments = null;
			        String qString = "select g from Gradebook g where b.name = :studentname";
			        
			        try{
			            TypedQuery<Gradebook> query = em.createQuery(qString,Gradebook.class);
			            query.setParameter("studentname", name);
			            assignments = query.getResultList();
			        }catch (Exception e){
			            e.printStackTrace();
			        }
			        finally{
			                em.close();
			            }
			        return assignments;    
			    }"<tr><td>" + a.getName() + "</td><td>" 
				+ a.getAssignment()+" " + "</td><td>" 
				+ a.getGrade() + "</td>td>"
				+ a.getDategraded() + "</td></tr>");
			}
			table.append("</table>");
			return table;

		}		*/		
	
    
	// get assignments for a selected student name
	public static List<Gradebook> getAssignmentsbyName(String name)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Gradebook> assignments = null;
        String qString = "select g from Gradebook g where g.name = :studentname";
        
        try{
            TypedQuery<Gradebook> query = em.createQuery(qString,Gradebook.class);
            query.setParameter("studentname", name);
            assignments = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return assignments;    
    }
	
	// get assignments for a selected student name and assignment type
	public static List<Gradebook> getAssignments(String name, String type)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Gradebook> assignments = null;
        String qString = "select g from Gradebook g where g.name = :studentname and g.type = :assignmenttype";
        
        try{
            TypedQuery<Gradebook> query = em.createQuery(qString,Gradebook.class);
            query.setParameter("studentname", name);
            query.setParameter("assignmenttype", type);
            assignments = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return assignments;    
    }
	
	// get assignments for selected assignment type
	public static List<Gradebook> getAssignmentsbyType(String type) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Gradebook> assignments = null;
        String qString = "select g from Gradebook g where g.type = :assignmenttype";
        
        try{
            TypedQuery<Gradebook> query = em.createQuery(qString,Gradebook.class);            
            assignments = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return assignments;    
    }
	
	// get average for student for a selected assignment type
		public static long getAverage(String name, String type) {
	        EntityManager em = DBUtil.getEmFactory().createEntityManager();
	        long average = 0;
	        
	        String qString = 
	        		"select g.type, avg(g.grade) from Gradebook+"
	        		+ " from gradebook g"
	        		+ " where g.name = 'Sue Snell' and g.type='Writing'"
	        		+ " group by g.type"
	        		+ " order by g.type;";	        		
	        
	        try{
	            TypedQuery<Gradebook> query = em.createQuery(qString,Gradebook.class);  
	            
	            // TO DO: fix the next line to execute the query
	            //average = query.getSingleResult();
	            
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        finally{
	                em.close();
	            }
	        return average;    
	    }
		
	
}
