package practice.streamApi;

public class Student {

    private String name;
    private int rollNo;
    private String dept;

    public Student(String name, int rollNo, String dept) {
        super();
        this.name = name;
        this.rollNo = rollNo;
        this.dept = dept;
    }
    public String getName() {
        return name;
    }
    public Student setName(String name) {
        this.name = name;
        return this;
    }
    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", rollNo=" + rollNo + ", dept=" + dept + "]";
    }
}
