package entity;

/**
 *
 * @author Jamie
 */
public class Cupcake {

    private String topping;
    private String bottom;

    public Cupcake(String topping, String bottom) {
        this.topping = topping;
        this.bottom = bottom;
    }
    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    @Override
    public String toString() {
        return topping + " + " + bottom;
    }

}
