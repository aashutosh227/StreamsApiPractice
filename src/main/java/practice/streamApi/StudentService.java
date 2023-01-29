package practice.streamApi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        System.out.println("Execution Started");
        students.add(new Student("Aashutosh", 10, "IT"));
        students.add(new Student("Abhishek", 11, "Extc"));
        students.add(new Student("Kartik", 12, "IT"));
        students.add(new Student("John", 13, "CS"));
        students.add(new Student("Aslam", 14, "Mechanical"));
        students.add(new Student("Ankit", 15, "CS"));
        students.add(new Student("XabcX", 16, "Mechanical"));

        System.out.println("Name Startswith A : ");
        Iterator<Student> iterator = students.stream().filter(e->e.getName().startsWith("A"))
                .collect(Collectors.toList()).iterator();
        printStreams(iterator);

        System.out.println("\nName contains A : ");
        iterator = students.stream()
                .filter(e->e.getName().toUpperCase().contains("ABC"))
                .collect(Collectors.toList()).iterator();
        printStreams(iterator);

        System.out.println("\nStudents with Dept IT : ");
        iterator = students.stream()
                .filter(e->e.getDept().equals("IT"))
                .collect(Collectors.toList()).iterator();
        printStreams(iterator);

        System.out.println("\nStudents sorted with Dept name : ");
        iterator = students.stream()
                .sorted(new DeptComparator())
                .collect(Collectors.toList()).iterator();
        printStreams(iterator);

        System.out.println("\nStudents sorted with name : ");
        Comparator<Student> nameComparator = (Student s1, Student s2)->s1.getName()
                .compareTo(s2.getName());
        iterator = students.stream()
                .sorted(nameComparator)
                .collect(Collectors.toList()).iterator();
        printStreams(iterator);
    }

    public static <T> void printStreams(Iterator<T> i) {
        while(i.hasNext()) {
            T obj = i.next();
            System.out.println(obj.toString());
        }
    }
}

class DeptComparator implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getDept().compareTo(s2.getDept());
    }
}
