package main;


import java.util.ArrayList;

public class GameInput {
    /**
     * citirea hartii din fisier.
     */
    private final ArrayList<String> map;
    /**
     * citirea miscarile din fisier.
     */
    private final ArrayList<String> moves;
    /**
     * citirea listei de campioni din fisier.
     */
    private final ArrayList<ChampionInput> champions;
    /**
     * citirea listei de liste de ingeri pe runda din fisier.
     */
    private final ArrayList<ArrayList<AngelInput>> angels;

    /**
     * constructor.
     */
 GameInput() {

    map = null;
    moves = null;
    champions = null;
    angels = null;
 }

    /**
     * constructor.
     * @param map .
     * @param champions .
     * @param moves .
     * @param angels .
     */
    public GameInput(final ArrayList<String> map,
                 final ArrayList<ChampionInput> champions,
                 final ArrayList<String> moves,
                 final ArrayList<ArrayList<AngelInput>> angels) {
  this.map = map;
  this.champions = champions;
  this.moves = moves;
  this.angels = angels;
    }

    /**
     * getter.
     * @return map.
     */
    public final ArrayList<String> getMap() {
        return map;
    }

    /**
     * getter.
     * @return champions
     */
    public final ArrayList<ChampionInput> getChampions() {
        return champions;
    }

    /**
     * getter.
     * @return moves
     */
    public final ArrayList<String> getMoves() {
        return moves;
    }

    /**
     * getter.
     * @return angels.
     */
    public ArrayList<ArrayList<AngelInput>> getAngels() {
        return angels;
    }

}
