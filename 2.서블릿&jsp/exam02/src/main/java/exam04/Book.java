package exam04;

public class Book {
   private String title;
   private String author;
   private String publisher;

    private Book() {}

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }

    protected static class Builder{
        //같은 클래스 안에서 만들어서 값을 할당
        private Book instance = new Book();

        public Builder title(String title) {
            instance.title = title;
            return this;//본인 객체를 반환해서 계속 쓸수 있게 함.
        }

        public Builder author(String author){
            instance.author = author;

            return this;
        }

        public Builder publisher(String publisher){
            instance.publisher = publisher;

            return this;
        }
        public  Book build() {

            return instance;
        }
    }
}
