package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="student")
public class Student {
	public Student(){}
	public Student(String fname, String family_name, Integer id) {
		super();
		this.fname = fname;
		this.familyName = family_name;
		this.id = id;
	}
	private  String fname;
	private String familyName;
	private Integer id;
	
	// simply add the annotation : "@XmlTransient"
	// (javax.xml.bind.annotation.XmlTransient)
	// at the getter of the property that causes the cycle.
	@XmlTransient
	public List<Course> courses = new ArrayList<Course>();

	// Course course; //--> if it was one to many

	@XmlElement
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	@XmlElement
	public String getFamilyName() {
		return familyName;
	}
	public void setFamily_name(String family_name) {
		this.familyName = family_name;
	}
	@XmlElement
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}



