package model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="studentList")
public class StudentList {

    private List<Student> list;

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
}
