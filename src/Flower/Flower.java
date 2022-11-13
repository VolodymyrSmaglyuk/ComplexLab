package Flower;

public class Flower {
    private final String name;
    private final String color;
    private int freshnessLevel;
    private final int stemLength;
    private int price;

    public Flower(String name, String color, int freshnessLevel, int stemLength, int price) {
        this.name = name;
        this.color = color;
        this.freshnessLevel = freshnessLevel;
        this.stemLength = stemLength;
        this.price = price;
    }
    public void reduceFreshnessLevel(int reduceNumb){
        int tmp = this.freshnessLevel-reduceNumb;
        this.price =(int) (this.price - (this.price * ((this.freshnessLevel - tmp) / 10.0)));
        this.freshnessLevel=tmp;
        if(freshnessLevel<0){
            this.freshnessLevel=0;
            this.price=0;
        }
    }
    public int getFreshnessLevel() {
        return freshnessLevel;
    }

    public int getStemLength() {
        return stemLength;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return
                "Назва квітки: " + name +'\n' +
                "Колір: " + color + '\n'+
                "Рівень свіжості: " + freshnessLevel +'\n'+
                "Довжина стебла: " + stemLength +'\n'+
                "Ціна за одиницю: " + price + '\n';
    }
}
