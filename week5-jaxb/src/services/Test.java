package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Course;
import model.Model;
import model.Student;
import model.StudentList;

@Path("/")
public class Test {

	
	public Test(){}
	
	@GET
	@Path("/studentByFname/{course}")
	@Produces(MediaType.APPLICATION_XML)
	public StudentList studentsByFname (
			@PathParam("course")String courseName) throws Exception {
		// all the student whose first name 
		// starts with "a" in course "java"
		List<Student> result= new ArrayList<Student>();
		Model m=Model.getModel();
		for(Course c:m.courses){
			if (c.getName().equalsIgnoreCase(courseName)){
				for(Student s:c.students){
					if(s.getFname().toCharArray()[0]=='a'){
						result.add(s);
					}
				}
				
			}
		}
		StudentList sts= new StudentList();
		sts.setList(result);
		return sts;
	}
	
	@GET
	@Path("/student")
	@Produces(MediaType.APPLICATION_XML)
	public StudentList listStudent ()
		throws Exception {

		List<Student> result= new ArrayList<Student>();
		Model m=Model.getModel();

		for(Student s:m.students){
				result.add(s);					
		}		
		
		StudentList sts= new StudentList();
		sts.setList(result);
		return sts;
	}
	
	@POST
	@Path("/course")
	@Produces(MediaType.TEXT_PLAIN  )
	public String addCourse(Course c)	{		
		Model m=Model.getModel();
		m.courses.add(c); //new Course("java",21)
		return "everything is okay and; and ";
	}
	
	@POST
	@Path("/student")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML  )
	public Response   addStudent(Student s)	{		
		Model m=Model.getModel();
		m.students.add(s);
		Response r=null;
		r= Response.ok(s
		,"application/xml").build();
		return r;

	}
	//m.courses.get(0).students=m.students; 
	//m.students.get(0).courses.add(m.courses.get(0)); 
	//m.students.get(1).courses.add(m.courses.get(0)); 
}


