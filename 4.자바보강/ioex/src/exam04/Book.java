package exam04;

import java.io.Serializable;

public class Book implements Serializable {//Serializable : 마커인터페이스. 직렬화

    public static final long serialVersionUID = 1L;//호환성의 문제가 없이 됨.
    private String title;
    private String author;
    private String publisher;

    private String str1;
    private String str2;

    public Book(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
