package angels;

import terrains.Terrain;

public class AngelFactory {
    /**
     * singleton.
     */
    private static AngelFactory instance = null;

    /**
     * creeaza si returneaza ingerul dorit.
     * @param type tipul de inger
     * @param spawnLocation locatia la care va aparea
     * @return ingerul
     */
    public Angel getAngel(final String type, final Terrain spawnLocation) {
        if (type.equalsIgnoreCase("DAMAGEANGEL")) {
            return new DamageAngel(spawnLocation);
        }
        if (type.equalsIgnoreCase("DARKANGEL")) {
            return new DarkAngel(spawnLocation);
        }
        if (type.equalsIgnoreCase("DRACULA")) {
            return new Dracula(spawnLocation);
        }
        if (type.equalsIgnoreCase("GOODBOY")) {
            return new GoodBoy(spawnLocation);
        }
        if (type.equalsIgnoreCase("LEVELUPANGEL")) {
            return new LevelUpAngel(spawnLocation);
        }
        if (type.equalsIgnoreCase("LIFEGIVER")) {
            return new LifeGiver(spawnLocation);
        }
        if (type.equalsIgnoreCase("THEDOOMER")) {
            return new OKDoomer(spawnLocation);
        }
        if (type.equalsIgnoreCase("SMALLANGEL")) {
            return new SmallAngel(spawnLocation);
        }
        if (type.equalsIgnoreCase("SPAWNER")) {
            return new Spawner(spawnLocation);
        }
        if (type.equalsIgnoreCase("XPANGEL")) {
            return new XPAngel(spawnLocation);
        }
        System.out.println("Wrong input at " + type + " "
                + spawnLocation.getX() + ", " + spawnLocation.getY());
        return null;
    }

    /**
     * returneaza instanta singleton.
     * @return instance
     */
    public static AngelFactory getInstance() {
        if (instance == null) {
            instance = new AngelFactory();
        }
        return instance;
    }

}
