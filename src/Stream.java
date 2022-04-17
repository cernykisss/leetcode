import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("name1","1001"));
        list1.add(new Student("name2","1002"));
        list1.add(new Student("name3","1003"));

        List<Student> list2 = new ArrayList<>();
        list2.add(new Student("name3","1003"));
        list2.add(new Student("name4","1004"));
//        交集
        List<Student> intersaction = list1.stream().filter(list2::contains).collect(Collectors.toList());
        for (Student student : intersaction) {
            System.out.println(student);
        }
//        差集
        List<Student> reduce = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
        for (Student student : reduce) {
            System.out.println(student);
        }
//        并集
        List<Student> listAll = list1.parallelStream().collect(Collectors.toList());
        List<Student> listAll2 = list2.parallelStream().collect(Collectors.toList());
        listAll.addAll(listAll2);
        listAll.parallelStream().forEach(System.out::println);
//        去重
        List<Student> distinct = list1.stream().distinct().collect(Collectors.toList());


    }
    static class Student {
        private String name;
        private String code;

        public Student(String name, String code) {
            this.name = name;
            this.code = code;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Student)) {
                return false;
            }
            Student student = (Student) o;
            return code.equals(student.getCode());
        }
        @Override
        public int hashCode() {
            return Objects.hash(code);
        }
        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    '}';
        }
        public String getName() {
            return name;
        }
        public String getCode() {
            return code;
        }
    }
}
