package champions;

import terrains.Terrain;

public class ChampionFactory {
    /**
     * singleton.
     */
    private static ChampionFactory instance = null;

    /**
     * creeaza si returneaza campionul dorit.
     * @param type clasa
     * @param id id-ul
     * @param location locatia pe care va aparea
     * @return campionul
     */
    public Champion getChampion(final String type,
                                final int id,
                                final Terrain location) {
        if (type.equalsIgnoreCase("W")) {
            return new Wizard(id, location);
        }
        if (type.equalsIgnoreCase("R")) {
            return new Rogue(id, location);
        }
        if (type.equalsIgnoreCase("P")) {
            return new Pyromancer(id, location);
        }
        if (type.equalsIgnoreCase("K")) {
            return new Knight(id, location);
        }
        System.out.println("Wrong input at champion line "
                + id + " of type " + type);
        return null;
    }

    /**
     * instantiaza(daca e nula) si returneaza
     * instanta singleton.
     * @return instanta singleton
     */
    public static ChampionFactory getInstance() {
        if (instance == null) {
            instance = new ChampionFactory();
        }
        return instance;
    }

}
