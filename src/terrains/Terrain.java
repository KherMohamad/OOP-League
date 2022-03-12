package terrains;

import champions.Champion;

import java.util.ArrayList;

public class Terrain {
    /**
     * coloana.
     */
    private final int x;
    /**
     * randul.
     */
    private final int y;
    /**
     * tipul de teren.
     */
    private final TerrainsType type;
    /**
     * eroii aflati pe teren.
     */
    private final ArrayList<Champion> championsHere
            = new ArrayList<>();


    /**
     * Constructor.
     * @param y rand
     * @param x coloana
     * @param type tipul terenului
     */
    public Terrain(final int y,
               final int x,
               final TerrainsType type) {
          this.y = y;
          this.x = x;
          this.type = type;
}

    /**
     * suprascrie metoda equals.
     * 2 terenuri sunt egale cand se afla
     * pe aceeasi pozitie pe harta
     * @param terrain terenul cu care este comparat
     * terenul "this"
     * @return true daca sunte egale,
     * false altfel
     */
    public boolean equals(final Terrain terrain) {
       if (this.x == terrain.x
         && this.y == terrain.y) {
           return true;
       }
       return false;
    }

    /**
     * getter.
     * @return tipul
     */
    public TerrainsType getType() {
    return this.type;

    }

    /**
     * getter.
     * @return coloana
     */
    public int getX() {
   return this.x;

    }

    /**
     * getter.
     * @return randul
     */
    public int getY() {
    return this.y;

}

    /**
     * getter.
     * @return eroii aflati pe teren
     */
    public ArrayList<Champion> getChampionsHere() {
    return this.championsHere;

}

}
