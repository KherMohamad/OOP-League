package main;

public class AngelInput {
    /**
     * tipul ingerului.
     */
    private String type;
    /**
     * coordonata x.
     */
    private int x;
    /**
     * coordonata y.
     */
    private int y;

    /**
     * setter.
     * @param setType .
     */
    public void setType(final String setType) {
        this.type = setType;
    }

    /**
     * setter.
     * @param setX .
     */
    public void setX(final int setX) {
        this.x = setX;
    }

    /**
     * setter.
     * @param setY .
     */
    public void setY(final int setY) {
        this.y = setY;
    }

    /**
     * getter.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * getter.
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * getter.
     * @return y
     */
    public int getY() {
        return y;
    }

}
