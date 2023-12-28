package exam01;

public enum Transportation {
    BUS("버스",1400){
        @Override
        public int getTotal(int person) {
            return price*person;
        }
    },
    SUBWAY("지하철",1450){
        @Override
        public int getTotal(int person) {
            return price*person;
        },
    TAXI("택시",4500){
        @Override
        public int getTotal(int person) {
            return price*person;
        };

    private final String title;
    private final int price;

    public String getTitle(){
        return title;
        }

    Transportation(String title,int price){
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }
    public abstract  int getTotal(int person){

        }
}
