public class Items {
    private String name;
    private int price;

    public Items(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static int compare (Items i1, Items i2){
        if (i1.getPrice() > i2.getPrice()) return 1;
        else return -1;
    }
}
