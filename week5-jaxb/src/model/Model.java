package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {
	private static  Model model=new Model();
	public List<Course> courses = new ArrayList<Course>();
	public List<Student> students = new ArrayList<Student>();
	private Model(){}
	public static Model getModel(){
		return model;
	}
	
	static{
		Model m=Model.getModel();
		m.courses.add(new Course("java",21));
		m.students=new ArrayList(
				Arrays.asList(new Student("jeff","edmonds",12),
				new Student("ali","salem",12)));
		m.courses.get(0).students=m.students; 
		m.students.get(0).courses.add(m.courses.get(0)); 
		m.students.get(1).courses.add(m.courses.get(0)); 
	}
	// Model.getModel()
	
	
}
