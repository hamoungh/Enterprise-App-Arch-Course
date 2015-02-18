package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
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
	static{
		Model m=Model.getModel();
		m.courses.add(new Course("java",21));
		m.students=Arrays.asList(new Student("jeff","edmonds",12),
				new Student("ali","salem",12));
		m.courses.get(0).students=m.students; 
		m.students.get(0).courses.add(m.courses.get(0)); 
		m.students.get(1).courses.add(m.courses.get(0)); 
	}
	
	public Test(){}
	
	@GET
	@Path("/studentByFname/{course}")
	@Produces(MediaType.APPLICATION_XML)
	public Response studentsByFname (
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
		Response r=null;

			r= Response.ok(sts
				,"application/xml").build();

		return r;
		
		
	}
}
