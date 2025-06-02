package lambda;
import stream.Student;
import java.util.ArrayList;


class Test {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 9.1);

        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);


        StudentInfo info = new StudentInfo();
        info.testStudents(students, (Student st) -> {return st.getAge() < 30;});
        info.testStudents(students, st -> st.getAge() < 30);
        info.testStudents(students, st -> {return st.getAge() < 30;});



        info.testStudents(students, (Student st) -> {return st.getAvgGrade() > 8;});
        info.testStudents(students, (Student st) -> {return st.getAge() > 20 && st.getAvgGrade() < 9.3 && st.getSex() == 'f';});
    }
}

interface StudentChecks{
    boolean check(Student st);
}


public class StudentInfo {
    void testStudents(ArrayList<Student> list, StudentChecks sc) {
        for (Student st : list) {
            if (sc.check(st)) {
                System.out.println(st);
            }
        }
    }
}

