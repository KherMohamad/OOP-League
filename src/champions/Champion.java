package champions;


import angels.Angel;
import common.ProlongedDamage;
import observers.GreatMagician;
import strategies.Strategy;
import subjects.Subject;
import terrains.Terrain;


public abstract class Champion {
    /**
     * id-ul eroului.
     */
    private int id;
    /**
     * tipul/rasa eroului.
     */
    private char type;
    /**
     * hp-ul actual al eroului .
     */
    private int currentHp;
    /**
     * hp-ul maxim pe care il poate avea eroul la nivelul lui.
     */
    private int maxHp;
    /**
     * xp-ul actual dobandit de erou.
     */
    private int xp = 0;
    /**
     * hp-ul necesar pentru a creste in nivel.
     */
    private  int levelUpHp;
    /**
     * damage-ul pe parcurs.
     */
    private ProlongedDamage prolongedDamage
            = new ProlongedDamage(0, 0, false);

    /**
     * nivelul eroului.
     */
    private int level = 0;
    /**
     * statutul de viata al eroului.
     */
    private boolean isDead = false;
    /**
     * unitatea(terenul) pe care se afla eroul.
     */
    private Terrain location;
    /**
     * modifier-ul de teren.
     */
    private float terrainModifier;
    /**
     * modifier-ul de damage.
     */
    private float damageModifier = 0;
    /**
     * strategia utilizata de erou.
     */
    private Strategy strategy;
    /**
     * notifica magicianul asupra eroului.
     */
    private final Subject notifier = new Subject();


    /**
     * atacul 1 asupra unui inamic de tip wizard.
     * @param enemy inamicul
     * @param battleground terenul de lupta/locatia
     * @return valoarea damage-ului
     */
    public abstract int attack1(Wizard enemy, Terrain battleground);
    /**
     * atacul 1 asupra unui inamic de tip rogue.
     * @param enemy inamicul
     * @param battleground terenul de lupta/locatia
     * @return valoarea damage-ului
     */
    public abstract int attack1(Rogue enemy, Terrain battleground);
    /**
     * atacul 1 asupra unui inamic de tip pyromancer.
     * @param enemy inamicul
     * @param battleground terenul de lupta/locatia
     * @return valoarea damage-ului
     */
    public abstract int attack1(Pyromancer enemy, Terrain battleground);
    /**
     * atacul 1 asupra unui inamic de tip knight.
     * @param enemy inamicul
     * @param battleground terenul de lupta/locatia
     * @return valoarea damage-ului
     */
    public abstract int attack1(Knight enemy, Terrain battleground);
    /**
     * atacul 2 asupra unui inamic de tip wizard.
     * @param enemy inamicul
     * @param battleground terenul de lupta/locatia
     * @return valoarea damage-ului
     */
    public abstract int attack2(Wizard enemy, Terrain battleground);
    /**
     * atacul 2 asupra unui inamic de tip rogue.
     * @param enemy inamicul
     * @param battleground terenul de lupta/locatia
     * @return valoarea damage-ului
     */
    public abstract int attack2(Rogue enemy, Terrain battleground);
    /**
     * atacul 2 asupra unui inamic de tip pyromancer.
     * @param enemy inamicul
     * @param battleground terenul de lupta/locatia
     * @return valoarea damage-ului
     */
    public abstract int attack2(Pyromancer enemy, Terrain battleground);
    /**
     * atacul 2 asupra unui inamic de tip knight.
     * @param enemy inamicul
     * @param battleground terenul de lupta/locatia
     * @return valoarea damage-ului
     */
    public abstract int attack2(Knight enemy, Terrain battleground);

    /**
     * incaseaza atacul de la inamic.
     * mecanism de double dispatch
     * @param enemy inamul ce ataca
     * @param battleground terenul de lupta/locatia
     */
    public abstract void isAttacked(Champion enemy, Terrain battleground);

    /**
     * aplica efectul ingerululi.
     * @param angel ingerul ce apare
     * pe terenul pe care se afla campionul
     */
    public abstract void isTouched(Angel angel);
    /**
     * alegerea strategiei.
     */
    public abstract void chooseStrategy();
    /**
     * functie ce creste nivelul eroului + actualire hp.
     */
    public void  levelUp() {
        this.level++;
        this.maxHp += levelUpHp;
        this.currentHp = this.maxHp;
        String message = new String(this.typeFull());
        message += " " + this.id;
        message += " reached level ";
        message += this.level;
        this.notifier.notify(GreatMagician.getInstance(), message);
    }

    /**
     * returneaza numele rasei campionului.
     * mai mult o metoda nascuta din neatentie
     * la implementare decat necesitate(mai practic
     * decat rescrierea unei portiuni mari de cod
     * @return numele.
     */
    public String typeFull() {
        if (this.type == 'W') {
            return "Wizard";
        }
        if (this.type == 'R') {
            return "Rogue";
        }
        if (this.type == 'P') {
            return "Pyromancer";
        }
        if (this.type == 'K') {
            return "Knight";
        }
    return null;
    }


    /**
     * setter.
     * @param setId .
     */
    public void setId(final int setId) {
        this.id = setId;
    }

    /**
     * setter.
     * @param setType .
     */
    public void setType(final char setType) {
        this.type = setType;
    }

    /**
     * setter.
     * @param setCurrentHp .
     */
    public void setCurrentHp(final int setCurrentHp) {
        this.currentHp = setCurrentHp;
    }

    /**
     * setter.
     * @param setMaxHp .
     */
    public void setMaxHp(final int setMaxHp) {
        this.maxHp = setMaxHp;
    }

    /**
     * setter.
     * @param setXp .
     */
    public void setXp(final int setXp) {
        this.xp = setXp;
    }

    /**
     * setter.
     * @param setLevelUpHp .
     */
    public void setLevelUpHp(final int setLevelUpHp) {
        this.levelUpHp = setLevelUpHp;
    }

    /**
     * setter.
     * @param setProlongedDamage .
     */
    public void setProlongedDamage(final ProlongedDamage setProlongedDamage) {
        this.prolongedDamage = setProlongedDamage;
    }

    /**
     * setter.
     * @param setLevel .
     */
    public void setLevel(final int setLevel) {
        this.level = setLevel;
    }

    /**
     * setter.
     * @param setDead .
     */
    public void setDead(final boolean setDead) {
        this.isDead = setDead;
    }

    /**
     * setter.
     * @param setLocation .
     */
    public void setLocation(final Terrain setLocation) {
        this.location = setLocation;
    }

    /**
     * seteaza modificatorul de teren.
     * am folosit init deoarece este constant.
     * @param setTerrainModifier .
     */
    public void initTerrainModifier(final float setTerrainModifier) {
        this.terrainModifier = setTerrainModifier;
    }

    /**
     * setter.
     * @param setDamageModifier .
     */
    public void setDamageModifier(final float setDamageModifier) {
        this.damageModifier = setDamageModifier;
    }

    /**
     * schuimba strategia implementata de erou.
     * @param newStrategy noua strategie aleasa
     */
    public void changeStrategy(final Strategy newStrategy) {
        this.strategy = newStrategy;
    }

    /**
     * getter.
     * @return  id.
     */
    public int getId() {
        return id;
    }

    /**
     * getter.
     * @return  type.
     */
    public char getType() {
        return type;
    }

    /**
     * getter.
     * @return currentHp.
     */
    public int getCurrentHp() {
        return this.currentHp;
    }

    /**
     * getter.
     * @return  maxHp.
     */
    public int getMaxHp() {
        return this.maxHp;
    }

    /**
     * getter.
     * @return  xp.
     */
    public int getXp() {
        return this.xp;
    }

    /**
     * getter.
     * @return  prolongedDamageLst.
     */
    public ProlongedDamage getProlongedDamage() {
        return this.prolongedDamage;
    }

    /**
     * getter.
     * @return  level.
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * getter.
     * @return  isDead.
     */
    public boolean getDead() {
        return isDead;
    }

    /**
     * getter.
     * @return  location.
     */
    public Terrain getLocation() {
        return location;
    }

    /**
     * getter.
     * @return  levelUpHp.
     */
    public int getLevelUpHp() {
        return levelUpHp;
    }

    /**
     * getter.
     * @return  terrainModifier.
     */
    public float getTerrainModifier() {
        return terrainModifier;
    }

    /**
     * getter.
     * @return  damageModifier.
     */
    public float getDamageModifier() {
        return damageModifier;
    }

    /**
     * getter.
     * @return strategy.
     */
    public Strategy getStrategy() {
        return strategy;
    }

    /**
     * getter.
     * @return notifier
     */
    public Subject getNotifier() {
        return notifier;
    }
}

