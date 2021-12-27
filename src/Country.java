public class Country {
    private final String name;
    private final String region;
    private final int generosityRatio;

    public Country(String name, String region, int generosityRatio) {
        this.name = name;
        this.region = region;
        this.generosityRatio = generosityRatio;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public int getGenerosityRatio() {
        return generosityRatio;
    }

    @Override
    public String toString() {
        return String.format("Страна: %1$25s | Показатель щедрости: %2$10s", name, generosityRatio);
    }
}
