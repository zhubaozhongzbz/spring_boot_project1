package java8.studyOptional;

import java.util.Optional;

public class CreateOptional {
    public static void main(String[] args) {
        CreateOptional createOptional = new CreateOptional();
        //可以为null
        Optional<Student> option = Optional.ofNullable(createOptional.new Student(null, null));
        Optional<Student> option1 = Optional.ofNullable(null);
        //必须确定是不为null
        Optional.of(createOptional.new Student(null, null));
        Optional.empty();
        //获取值
        Optional<Integer> integer = Optional.of(1);

        //如果optional不为空，则将optional中的对象传给Comsumer函数，为null则do nothing
        option.ifPresent(System.out::println);
        option.get();
        //有值返回当前值，无值则执行括号
        Student student = option1.orElse(createOptional.new Student("11", "222"));
        System.out.println(student);
        //如果optional不为空，则返回optional中的对象；如果为null，则使用Supplier函数生成默认值other
        Student student1=option1.orElseGet(() -> createOptional.new Student("a","b"));
        System.out.println("student1 = " + student1);
        Student student2 = option.orElseThrow(() -> new RuntimeException());
        System.out.println("student2 = " + student2);
        //
        Optional<Student> student3 = option.filter(studen -> studen.age.equals("222"));
    }

    class Student {

        @Override
        public String toString() {
            return "Student{" + "name='" + name + '\'' + ", age='" + age + '\'' + '}';
        }

        public Student(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        private String name;
        private String age;
    }

}


