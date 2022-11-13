package Decor;

public class Decor {
    private final String wrapperType;
    private final String extraElements;
    private final int totalPrice;

    public Decor(String wrapperType, String extraElements, int totalPrice) {
        this.wrapperType = wrapperType;
        this.extraElements = extraElements;
        this.totalPrice = totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String toString() {
        return
                "Тип обгортки: " + wrapperType + '\n' +
                "Додаткові елементи: " + extraElements;
    }
}
