package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="course")
public class Course {
	private String name;
	private Integer id; 
	public Course(){}
	public Course(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}

	// simply add the annotation : "@XmlTransient"
	// (javax.xml.bind.annotation.XmlTransient)
	// at the getter of the property that causes the cycle.
	@XmlTransient
	public List<Student> students = new  ArrayList<Student>();
	
	@XmlElement 
	public Integer getId(){
		return id;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
}
