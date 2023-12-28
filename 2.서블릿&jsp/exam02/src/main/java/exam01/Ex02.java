package exam01;

public class Ex02 {
    public static void main(String[] args) {
        /*
        Book b1 = new Book();
        b1.setTitle("스프링5");
        b1.setAuthor("최범균");
        b1.setPublisher("가메출판사");

        System.out.println(b1);

        Book b2 = new Book("JSP2.3","최범균","가메출판사");
        System.out.println(b2);
        */
        Student s1 = new Student(1000,"이름1","과목1");
        System.out.println(System.identityHashCode(s1));

        Student s2 = s1;
        s2.setId(1001);
        s2.setName("이름2");
        System.out.println("s2 : " + s2);
        System.out.println("s1 : " + s1);
    }
}
