package main;

public class ChampionInput {
    /**
     * tipul/rasa eroului.
     */
    private String type;
    /**
     * coloana.
     */
     private int x;
    /**
     * linia.
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
