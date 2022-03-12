package champions;

import angels.Angel;
import common.Constants;
import common.GameEngine;
import common.ProlongedDamage;
import strategies.AttackStrategy;
import strategies.BasicStrategy;
import strategies.DefenceStrategy;
import terrains.Terrain;
import terrains.TerrainsType;


public class Pyromancer extends Champion {
    /**
     * constructor.
     * @param id .
     * @param location .
     */
    public Pyromancer(final int id, final Terrain location) {
        this.setId(id);
        this.setType('P');
        this.setCurrentHp(Constants.PHP);
        this.setMaxHp(Constants.PHP);
        this.setLevelUpHp(Constants.PUPHP);
        this.setLocation(location);
        this.initTerrainModifier(Constants.P_TERRAINMOD);
    }

    /**
     * Fireblast.
     * @param enemy inamicul lovit de fireblast
     * @param battleground terenul de lupta
     * @return damage-ul rotunjit
     */
    public int attack1(final Wizard enemy, final Terrain battleground) {
        int damage = Constants.BLASTDAMAGE
                + this.getLevel() * Constants.BLASTBONUS;
        if (battleground.getType() == TerrainsType.Volcanic) {
            damage = Math.round(this.getTerrainModifier() * damage);

        }
     enemy.setDamageTaken(damage);
        float modifier = Constants.PYROTOWIZARDMOD;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);

        return damage;
    }

    /**
     * Fireblast.
     * @param enemy inamicul lovit de fireblast
     * @param battleground terenul de lupta
     * @return damage-ul rotunjit
     */
    public int attack1(final Rogue enemy, final Terrain battleground) {
        int damage = Constants.BLASTDAMAGE
                + this.getLevel() * Constants.BLASTBONUS;
        if (battleground.getType() == TerrainsType.Volcanic) {
            damage = Math.round(this.getTerrainModifier() * damage);

        }
        float modifier = Constants.PYROTOROGUEMOD;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);

        return damage;
    }

    /**
     * Fireblast.
     * @param enemy inamicul lovit de fireblast
     * @param battleground terenul de lupta
     * @return damage-ul rotunjit
     */
    public int attack1(final Pyromancer enemy, final Terrain battleground) {
        int damage = Constants.BLASTDAMAGE
                + this.getLevel() * Constants.BLASTBONUS;
        if (battleground.getType() == TerrainsType.Volcanic) {
            damage = Math.round(this.getTerrainModifier() * damage);

        }
        float modifier = Constants.PYROTOPYROMOD;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);

        return damage;
    }

    /**
     * Fireblast.
     * @param enemy inamicul lovit de fireblast
     * @param battleground terenul de lupta
     * @return damage-ul rotunjit
     */
    public int attack1(final Knight enemy, final Terrain battleground) {
        int damage = Constants.BLASTDAMAGE
                + this.getLevel() * Constants.BLASTBONUS;
        if (battleground.getType() == TerrainsType.Volcanic) {
            damage = Math.round(this.getTerrainModifier() * damage);

        }
        float modifier = Constants.PYROTOROGUEMOD;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);

        return damage;
    }

    /**
     * Ignite.
     * @param enemy inamicul lovit de ignite
     * @param battleground terenul de lupta
     * @return damage-ul rotunjit
     */
    public int attack2(final Wizard enemy, final Terrain battleground) {
        int damage = Constants.INCINERATEDAMAGE
                + this.getLevel() * Constants.INCINERATEBONUS;
        int burnDmg = Constants.BURNDAMAGE
                + Constants.BURNBONUS * enemy.getLevel();
        int roundsDamaged = Constants.ROUNDSBURNED;

        if (battleground.getType() == TerrainsType.Volcanic) {
            damage = Math.round(this.getTerrainModifier() * damage);
            burnDmg = Math.round(this.getTerrainModifier() * damage);
        }
       enemy.setDamageTaken(enemy.getDamageTaken() + damage);
        float modifier = Constants.PYROTOWIZARDMOD;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);
        burnDmg = Math.round(modifier * burnDmg);
        ProlongedDamage prolongedDamage
            = new ProlongedDamage(Math.round(burnDmg), roundsDamaged, false);
        enemy.setProlongedDamage(prolongedDamage);

        return damage;
    }

    /**
     * Ignite.
     * @param enemy inamicul lovit de ignite
     * @param battleground terenul de lupta
     * @return damage-ul rotunjit
     */
    public int attack2(final Rogue enemy, final Terrain battleground) {
        int damage = Constants.INCINERATEDAMAGE
                + this.getLevel() * Constants.INCINERATEBONUS;
        int burnDmg = Constants.BURNDAMAGE
                + Constants.BURNBONUS * enemy.getLevel();
        int roundsDamaged = Constants.ROUNDSBURNED;

        if (battleground.getType() == TerrainsType.Volcanic) {
            damage = Math.round(this.getTerrainModifier() * damage);
            burnDmg = Math.round(this.getTerrainModifier() * damage);
        }
        float modifier = Constants.PYROTOROGUEMOD;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);
        burnDmg = Math.round(modifier * burnDmg);
        ProlongedDamage prolongedDamage
               = new ProlongedDamage(Math.round(burnDmg), roundsDamaged, false);
        enemy.setProlongedDamage(prolongedDamage);

        return damage;
    }

    /**
     * Ignite.
     * @param enemy inamicul lovit de ignite
     * @param battleground terenul de lupta
     * @return damage-ul rotunjit
     */
    public int attack2(final Pyromancer enemy, final Terrain battleground) {
        int damage = Constants.INCINERATEDAMAGE
                + this.getLevel() * Constants.INCINERATEBONUS;
        int burnDmg = Constants.BURNDAMAGE
                + Constants.BURNBONUS * enemy.getLevel();
        int roundsDamaged = Constants.ROUNDSBURNED;

        if (battleground.getType() == TerrainsType.Volcanic) {
            damage = Math.round(this.getTerrainModifier() * damage);
            burnDmg = Math.round(this.getTerrainModifier() * damage);
        }
        float modifier = Constants.PYROTOPYROMOD;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);
        burnDmg = Math.round(modifier * burnDmg);
        ProlongedDamage prolongedDamage
               = new ProlongedDamage(Math.round(burnDmg), roundsDamaged, false);
        enemy.setProlongedDamage(prolongedDamage);

        return damage;
    }

    /**
     * Ignite.
     * @param enemy inamicul lovit de ignite
     * @param battleground terenul de lupta
     * @return damage-ul rotunjit
     */
    public int attack2(final Knight enemy, final Terrain battleground) {
        int damage = Constants.INCINERATEDAMAGE
                + this.getLevel() * Constants.INCINERATEBONUS;
        int burnDmg = Constants.BURNDAMAGE
                + Constants.BURNBONUS * enemy.getLevel();
        int roundsDamaged = Constants.ROUNDSBURNED;

        if (battleground.getType() == TerrainsType.Volcanic) {
            damage = Math.round(this.getTerrainModifier() * damage);
            burnDmg = Math.round(this.getTerrainModifier() * damage);
        }
        float modifier = Constants.PYROTOKNIGHTMOD;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);
        burnDmg = Math.round(modifier * burnDmg);
        ProlongedDamage prolongedDamage
              = new ProlongedDamage(Math.round(burnDmg), roundsDamaged, false);
        enemy.setProlongedDamage(prolongedDamage);

        return damage;
    }

    /**
     * incaseaza atacurile de la inamic.
     * @param enemy inamicul ce ataca
     * @param battleground terenul de lupta/locatia
     */
    public void isAttacked(final Champion enemy, final Terrain battleground) {
        int totalDamage = enemy.attack1(this, battleground)
                + enemy.attack2(this, battleground);
        int myHp = this.getCurrentHp();
        this.setCurrentHp(myHp - totalDamage);
    }

    /**
     * aplicarea efectelor ingerului.
     * @param angel ingerul ce apare
     * pe terenul pe care se afla pyromancer
     */
    public void isTouched(final Angel angel) {
        angel.touch(this);
    }

    /**
     * alegerea unei strategii.
     */
    public void chooseStrategy() {
        GameEngine engine = new GameEngine();
        if (!(this.getDead() || engine.isParalysed(this))) {
            if (this.getCurrentHp() < (float) 1 / Constants.PYROSTRMIN
                    * this.getMaxHp()) {
                if (!(this.getStrategy() instanceof DefenceStrategy)) {
                    this.changeStrategy(new DefenceStrategy());
                    this.getStrategy().apply(this);
                }
            } else if (this.getCurrentHp()
                    > (float) 1 / Constants.PYROSTRMIN * this.getMaxHp()
                    && this.getCurrentHp()
                    < (float) 1 / Constants.PYROSTRMAX * this.getMaxHp()) {
                if (!(this.getStrategy() instanceof AttackStrategy)) {
                    this.changeStrategy(new AttackStrategy());
                    this.getStrategy().apply(this);
                }
            } else if (!(this.getStrategy() instanceof BasicStrategy)) {
                this.changeStrategy(new BasicStrategy());
                this.getStrategy().apply(this);
            }
        }
    }

}
