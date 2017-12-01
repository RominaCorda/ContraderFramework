package main.model;

public class Gomma {

    private Integer G_id;
    private String typevehicle;
    private String model;
    private String manufacturer;
    private double quantity;
    private double price;
    private double width;
    private double height;
    private double diameter;
    private double weight;
    private String speed;
    private String season;


    public Gomma(Integer g_id, String typevehicle, String model, String manufacturer, double quantity, double price, double width, double height, double diameter, double weight, String speed, String season) {
        G_id = g_id;
        this.typevehicle = typevehicle;
        this.model = model;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.price = price;
        this.width = width;
        this.height = height;
        this.diameter = diameter;
        this.weight = weight;
        this.speed = speed;
        this.season = season;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getQuantity() { return quantity; }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getG_id() {
        return G_id;
    }

    public void setG_id(int g_id) {
        G_id = g_id;
    }

    public String getTypevehicle() {
        return typevehicle;
    }

    public void setTypevehicle(String typevehicle) {
        this.typevehicle = typevehicle;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gomma gomma = (Gomma) o;

        if (Double.compare(gomma.price, price) != 0) return false;
        if (model != null ? !model.equals(gomma.model) : gomma.model != null) return false;
        return manufacturer != null ? manufacturer.equals(gomma.manufacturer) : gomma.manufacturer == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = model != null ? model.hashCode() : 0;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Modello: " + model +
                "\nVeicolo: " + typevehicle +
                "\nProduttore: " + manufacturer +
                "\nQuantità: "+ quantity +
                "\nPrezzo: "+ price +
                "\nLarghezza: " + width +
                "\nAltezza: " + height +
                "\nDiametro: " + diameter +
                "\nCarico: " + weight +
                "\nVelocità: " + speed +
                "\nStagione: " + season +
                "\n";
    }
}
