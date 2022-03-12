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



public class Rogue extends Champion {
    /**
     * constructor.
     * @param id .
     * @param location .
     */
    public Rogue(final int id, final Terrain location) {
      this.setId(id);
      this.setType('R');
      this.setCurrentHp(Constants.RHP);
      this.setMaxHp(Constants.RHP);
      this.setLevelUpHp(Constants.RUPHP);
      this.setLocation(location);
      this.initTerrainModifier(Constants.R_TERRAINMOD);

    }

    /**
     * numarul de dati in care s-a executat atacul 1.
     * folosit pt. critical.
     */
    private int hitNumber = 0;

    /**
     * Backstab.
     * @param enemy inamicul lovit de backstab
     * @param battleground campul de batalie
     * @return damage-ul rotunjit
     */
    public int attack1(final Wizard enemy, final Terrain battleground) {
        int damage = Constants.STABDAMAGE
                + this.getLevel() * Constants.STABBONUS;
        if (this.getHitNumber() % Constants.STABCRIT == 0) {
            if (battleground.getType() == TerrainsType.Woods) {
                damage = Math.round(Constants.CRITMOD * damage);
                damage = Math.round(this.getTerrainModifier() * damage);
            }
        } else {
            if (battleground.getType() == TerrainsType.Woods) {
                damage = Math.round(this.getTerrainModifier() * damage);
            }
        this.setHitNumber(this.getHitNumber() + 1);
        enemy.setDamageTaken(damage);
        float modifier = Constants.ROGUETOWIZARDMOD1;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);
        }

        return damage;
    }

    /**
     * Backstab.
     * @param enemy inamicul lovit de backstab
     * @param battleground campul de batalie
     * @return damage-ul rotunjit
     */
    public int attack1(final Rogue enemy, final Terrain battleground) {
        int damage = Constants.STABDAMAGE
                + this.getLevel() * Constants.STABBONUS;
        if (this.getHitNumber() % Constants.STABCRIT == 0) {
            if (battleground.getType() == TerrainsType.Woods) {
                damage = Math.round(Constants.CRITMOD * damage);
                damage = Math.round(this.getTerrainModifier() * damage);
            }
        } else {
            if (battleground.getType() == TerrainsType.Woods) {
                damage = Math.round(this.getTerrainModifier() * damage);
            }
            this.setHitNumber(this.getHitNumber() + 1);
            float modifier = Constants.ROGUETOROGUEMOD1;
            modifier += this.getDamageModifier();
            damage = Math.round(modifier * damage);
        }

        return damage;
    }

    /**
     * Backstab.
     * @param enemy inamicul lovit de backstab
     * @param battleground campul de batalie
     * @return damage-ul rotunjit
     */
    public int attack1(final Pyromancer enemy, final Terrain battleground) {
        int damage = Constants.STABDAMAGE
                + this.getLevel() * Constants.STABBONUS;
        if (this.getHitNumber() % Constants.STABCRIT == 0) {
            if (battleground.getType() == TerrainsType.Woods) {
                damage = Math.round(Constants.CRITMOD * damage);
                damage = Math.round(this.getTerrainModifier() * damage);
            }
        } else {
            if (battleground.getType() == TerrainsType.Woods) {
                damage = Math.round(this.getTerrainModifier() * damage);
            }
            this.setHitNumber(this.getHitNumber() + 1);
            float modifier = Constants.ROGUETOPYROMOD1;
            modifier += this.getDamageModifier();
            damage = Math.round(modifier * damage);
        }

        return damage;
    }

    /**
     * Backstab.
     * @param enemy inamicul lovit de backstab
     * @param battleground campul de batalie
     * @return damage-ul rotunjit
     */
    public int attack1(final Knight enemy, final Terrain battleground) {
        int damage = Constants.STABDAMAGE
                + this.getLevel() * Constants.STABBONUS;
        if (this.getHitNumber() % Constants.STABCRIT == 0) {
            if (battleground.getType() == TerrainsType.Woods) {
                damage = Math.round(Constants.CRITMOD * damage);
                damage = Math.round(this.getTerrainModifier() * damage);
            }
        } else {
            if (battleground.getType() == TerrainsType.Woods) {
                damage = Math.round(this.getTerrainModifier() * damage);
            }
            this.setHitNumber(this.getHitNumber() + 1);
            float modifier = Constants.ROGUETOKNIGHTMOD1;
            modifier += this.getDamageModifier();
            damage = Math.round(modifier * damage);
        }

        return damage;
    }


    /**
     * Paralysis.
     * @param enemy inamicul lovit de paralysis
     * @param battleground terenul de lupta
     * @return damage-ul rotunjit
     */
    public int attack2(final Wizard enemy, final Terrain battleground) {
        int damage = Constants.PARALYSISDAMAGE
                + this.getLevel() * Constants.PARALYSISBONUS;
        int roundsDamaged = Constants.ROUNDSNORMAL;
        if (battleground.getType() == TerrainsType.Woods) {
            damage = Math.round(this.getTerrainModifier() * damage);
            roundsDamaged = Constants.ROUNDSWOODS;
        }
        enemy.setDamageTaken(damage);
        float modifier = Constants.ROGUETOWIZARDMOD2;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);
        ProlongedDamage paralysis
             = new ProlongedDamage(damage, roundsDamaged, true);
        enemy.setProlongedDamage(paralysis);

        return damage;
 }

    /**
     * Paralysis.
     * @param enemy inamicul lovit de paralysis
     * @param battleground terenul de lupta
     * @return damage-ul rotunjit
     */
    public int attack2(final Rogue enemy, final Terrain battleground) {
        int damage = Constants.PARALYSISDAMAGE
                + this.getLevel() * Constants.PARALYSISBONUS;
        int roundsDamaged = Constants.ROUNDSNORMAL;
        if (battleground.getType() == TerrainsType.Woods) {
            damage = Math.round(this.getTerrainModifier() * damage);
            roundsDamaged = Constants.ROUNDSWOODS;
        }
        float modifier = Constants.ROGUETOROGUEMOD2;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);
        ProlongedDamage paralysis
                = new ProlongedDamage(damage, roundsDamaged, true);
        enemy.setProlongedDamage(paralysis);

        return damage;
    }

    /**
     * Paralysis.
     * @param enemy inamicul lovit de paralysis
     * @param battleground terenul de lupta
     * @return damage-ul rotunjit
     */
    public int attack2(final Pyromancer enemy, final Terrain battleground) {
        int damage = Constants.PARALYSISDAMAGE
                + this.getLevel() * Constants.PARALYSISBONUS;
        int roundsDamaged = Constants.ROUNDSNORMAL;
        if (battleground.getType() == TerrainsType.Woods) {
            damage = Math.round(this.getTerrainModifier() * damage);
            roundsDamaged = Constants.ROUNDSWOODS;
        }
        float modifier = Constants.ROGUETOPYROMOD2;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);
        ProlongedDamage paralysis
                = new ProlongedDamage(damage, roundsDamaged, true);
        enemy.setProlongedDamage(paralysis);

        return damage;
    }

    /**
     * Paralysis.
     * @param enemy inamicul lovit de paralysis
     * @param battleground terenul de lupta
     * @return damage-ul rotunjit
     */
    public int attack2(final Knight enemy, final Terrain battleground) {
        int damage = Constants.PARALYSISDAMAGE
                + this.getLevel() * Constants.PARALYSISBONUS;
        int roundsDamaged = Constants.ROUNDSNORMAL;
        if (battleground.getType() == TerrainsType.Woods) {
            damage = Math.round(this.getTerrainModifier() * damage);
            roundsDamaged = Constants.ROUNDSWOODS;
        }
        float modifier = Constants.ROGUETOKNIGHTMOD2;
        modifier += this.getDamageModifier();
        damage = Math.round(modifier * damage);
        ProlongedDamage paralysis
                = new ProlongedDamage(damage, roundsDamaged, true);
        enemy.setProlongedDamage(paralysis);

        return damage;
    }

    /**
     * incaseaza atacurile de la inamic.
     * @param enemy inamul ce ataca
     * @param battleground terenul de lupta/locatia
     */
    public void isAttacked(final Champion enemy, final Terrain battleground) {
        int totalDamage = enemy.attack1(this, battleground)
                + enemy.attack2(this, battleground);
        int myHp = this.getCurrentHp();
        this.setCurrentHp(myHp - totalDamage);
    }

    /**
     * aplicarea efectelor ingerululi.
     * @param angel ingerul care apare pe
     * terenul pe care se afla campionul
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
            if (this.getCurrentHp() < (float) 1 / Constants.ROGUESTRMIN
                    * this.getMaxHp()) {
                if (!(this.getStrategy() instanceof DefenceStrategy)) {
                    this.changeStrategy(new DefenceStrategy());
                    this.getStrategy().apply(this);
                }
            } else if (this.getCurrentHp()
                    > (float) 1 / Constants.ROGUESTRMIN * this.getMaxHp()
                    && this.getCurrentHp()
                    < (float) 1 / Constants.ROGUESTRMAX * this.getMaxHp()) {
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

    /**
     * setter.
     * @param setHitNumber .
     */
    public void setHitNumber(final int setHitNumber) {
     this.hitNumber = setHitNumber;
    }

    /**
     * getter.
     * @return hitNumber
     */
    public int getHitNumber() {
        return this.hitNumber;
    }
}
