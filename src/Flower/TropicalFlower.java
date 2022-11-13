package Flower;

public class TropicalFlower extends Flower{
    private final String countryOfOrigin;
    private final boolean compatibleWithOthers;

    public TropicalFlower(String name, String color, int freshnessLevel, int stemLength, int price,
                          String CountryOfOrigin,boolean compatibleWithOthers) {
        super(name, color, freshnessLevel, stemLength, price);
        this.countryOfOrigin =CountryOfOrigin;
        this.compatibleWithOthers=compatibleWithOthers;
    }

    public TropicalFlower(TropicalFlower that) {
        this(that.getName(), that.getColor(), that.getFreshnessLevel(), that.getStemLength(),
                that.getPrice(), that.getCountryOfOrigin(), that.isCompatibleWithOthers());
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public boolean isCompatibleWithOthers() {
        return compatibleWithOthers;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Країна походження: " + countryOfOrigin + '\n' +
                "Сумісність з іншими квітами: " + compatibleWithOthers +'\n';
    }
}
