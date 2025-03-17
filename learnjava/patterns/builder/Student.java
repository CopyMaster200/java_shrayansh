package learnjava.patterns.builder;

public class Student {
    private String name;
    private int age;
    private String email;

    public abstract class StudentBuilder {
        private String name;
        private int age;
        private String email;

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder age(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder email(String email) {
            this.email = email;
            return this;
        }
    }

}
