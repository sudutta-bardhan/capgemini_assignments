package stream_api_programs.students;

import java.util.*;
import java.util.stream.Collectors;

public class StudentController
{
    public static void main(String[] args)
    {
        List<Student> students = new ArrayList<>();

        students.add(new Student("S1", "Alice", "CSE", 20, 2, 3.5, 0));
        students.add(new Student("S2", "Bob", "CSE", 21, 3, 3.2, 1));
        students.add(new Student("S3", "Charles", "ECE", 22, 3, 3.8, 0));
        students.add(new Student("S4", "David", "ECE", 23, 4, 3.1, 0));
        students.add(new Student("S5", "Eve", "IT", 20, 2, 3.4, 1));

        Map<String, Set<Student>> result = groupStudents(students);

        System.out.println(result);
    }

    public static Map<String, Set<Student>> groupStudents(List<Student> students)
    {
        return students.stream()
                	   .sorted(Comparator.comparing(Student::getGpa)
                       .thenComparing(Student::getAge, Comparator.reverseOrder()))
                	   .collect(Collectors.groupingBy(
                			   				Student::getMajor,
                			   				Collectors.toCollection(LinkedHashSet::new)));
    }
}