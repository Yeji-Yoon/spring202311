package exam04;

public class Ex01 {
    public static void main(String[] args) {
        //Book b1  = new Book();//오류: book에서 private로 설정

        Book b1 = Book.builder()
                .title("제목1")
                .author("저자1")
                .publisher("출판사1")
                .build();//빌드업 체인

        System.out.println(b1);
    }
}
