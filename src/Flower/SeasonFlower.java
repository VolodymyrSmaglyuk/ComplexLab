package Flower;

public class SeasonFlower extends Flower{
    private final String flowerSeason;
    private final String countryOfOrigin;

    public SeasonFlower(String name, String color, int freshnessLevel, int stemLength, int price,
                        String flowerSeason,String countryOfOrigin) {
        super(name, color, freshnessLevel, stemLength, price);
        this.flowerSeason=flowerSeason;
        this.countryOfOrigin = countryOfOrigin;
    }
    public SeasonFlower(SeasonFlower that) {
        this(that.getName(), that.getColor(), that.getFreshnessLevel(), that.getStemLength(),
                that.getPrice(), that.getFlowerSeason(),that.getCountryOfOrigin());
    }

    public String getFlowerSeason() {
        return flowerSeason;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Сезон квітки: " + flowerSeason + '\n' +
                "Країна походження: " + countryOfOrigin + '\n';
    }
}
