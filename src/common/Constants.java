package common;


public final class Constants {
    /**
     * constructor for utility class.
      */
  private Constants() {

  }

    /**
     * rogue hp.
     */
    public static final int RHP = 600;
    /**
     * wizard hp.
     */
    public static final int WHP = 400;
    /**
     * pyromancer hp.
     */
    public static final int PHP = 500;
    /**
     * knight hp.
     */
    public static final int KHP = 900;
    /**
     * hp-ul extra pe nivel al unui wizard.
     */
    public static final int WUPHP = 30;
    /**
     * hp-ul extra pe nivel al unui rogue.
     */
    public static final int RUPHP = 40;
    /**
     * hp-ul extra pe nivel al unui pyromancer.
     */
    public static final int PUPHP = 50;
    /**
     * hp-ul extra pe nivel al unui knight.
     */
    public static final int KUPHP = 80;
    /**
     * xp-ul necesar pt. nivelul 1.
     */
    public static final int LEVEL1XP = 250;
    /**
     * xp-ul suplimentar necesar pentru a creste cu un nivel.
     */
    public static final int UPCOEFF = 50;
    /**
     * modifier de teren pt. wizard.
     */
    public static final float W_TERRAINMOD = 1.1f;
    /**
     * modifier de teren pt. rogue.
     */
    public static final float R_TERRAINMOD = 1.15f;
    /**
     * modifier de teren pt. pyromancer.
     */
    public static final float P_TERRAINMOD = 1.25f;
    /**
     * modifier de teren pt. knight.
     */
    public static final float K_TERRAINMOD = 1.15f;
    /**
     * modifier de critical hit pt backstab.
     */
    public static final float CRITMOD = 1.5f;
    /**
     * xp-ul dobandit la omorarea unui erou de acelasi nivel.
     */
    public static final int SAMELEVELXP = 200;
    /**
     * xp-ul in plus/minus fata de 200 pe o diferenta de un nivel.
     */
    public static final int KILLCOEFF = 40;

    /**
     * procentajul de viata trasa de atacul drain.
     */
    public static final float DRAINPERCENTAGE = 0.2f;
    /**
     * extra pe nivel.
     */
    public static final float DRAINBONUS = 0.05f;
    /**
     * procentajul tras din maxim.
     */
    public static final float DRAINOFMAX = 0.3f;

    /**
     * procentajul de damage dat de deflect.
     */
    public static final float DEFLECTPERCENTAGE = 0.35f;
    /**
     * extra pe nivel.
     */
    public static final float DEFLECTBONUS = 0.02f;
    /**
     * procentajul maxim.
     */
    public static final float DEFLECTMAX = 0.7f;

    /**
     * modifier-ul de atac 1 wizard-wizard.
     */
    public static final float WIZARDTOWIZARDMOD1 = 1.05f;
    /**
     * modifier-ul de atac 1 wizard-rogue.
     */
    public static final float WIZARDTOROGUEMOD1 = 0.8f;
    /**
     * modifier-ul de atac 1 wizard-pyromancer.
     */
    public static final float WIZARDTOPYROMOD1 = 0.9f;
    /**
     * modifier-ul de atac 1 wizard-knight.
     */
    public static final float WIZARDTOKNIGHTMOD1 = 1.2f;

      //modifier-ul de atac 2 wizard-wizard.
      //skip deoarece atacul 2 nu afecteaza alt wizard

    /**
     * modifier-ul de atac 2 wizard-rogue.
     */
    public static final float WIZARDTOROGUEMOD2 = 1.2f;
    /**
     * modifier-ul de atac 2 wizard-pyromancer.
     */
    public static final float WIZARDTOPYROMOD2 = 1.3f;
    /**
     * modifier-ul de atac 2 wizard-knight.
     */
    public static final float WIZARDTOKNIGHTMOD2 = 1.4f;

    /**
     * damage-ul de baza pt. backstab.
     */
    public static final int STABDAMAGE = 200;
    /**
     * extra pe nivel.
     */
    public static final int STABBONUS = 20;
    /**
     * verifica daca lovitura va fi criticala.
     */
    public static final int STABCRIT = 3;

    /**
     * damage-ul de baza dat de paralysis.
     */
    public static final int PARALYSISDAMAGE = 40;
    /**
     * extra pe nivel.
     */
    public static final int PARALYSISBONUS = 10;
    /**
     * numarul de runde in conditii normale.
     */
    public static final int ROUNDSNORMAL = 3;
    /**
     * numarul de runde pe teren woods.
     */
    public static final int ROUNDSWOODS = 6;

    /**
     * modifier-ul de atac 1 rogue-wizard.
     */
    public static final float ROGUETOWIZARDMOD1 = 1.25f;
    /**
     * modifier-ul de atac 1 rogue-rogue.
     */
    public static final float ROGUETOROGUEMOD1 = 1.2f;
    /**
     * modifier-ul de atac 1 rogue-pyromancer.
     */
    public static final float ROGUETOPYROMOD1 = 1.25f;
    /**
     * modifier-ul de atac 1 rogue-knight.
     */
    public static final float ROGUETOKNIGHTMOD1 = 0.9f;
    /**
     * modifier-ul de atac 2 rogue-wizard.
     */
    public static final float ROGUETOWIZARDMOD2 = 1.25f;
    /**
     * modifier-ul de atac 2 rogue-rogue.
     */
    public static final float ROGUETOROGUEMOD2 = 0.9f;
    /**
     * modifier-ul de atac 2 rogue-pyromancer.
     */
    public static final float ROGUETOPYROMOD2 = 1.2f;
    /**
     * modifier-ul de atac 2 rogue-knight.
     */
    public static final float ROGUETOKNIGHTMOD2 = 0.8f;

    /**
     * damage-ul dat de fireblast.
     */
    public static final int BLASTDAMAGE = 350;
    /**
     * extra pe nivel.
     */
    public static final int BLASTBONUS = 50;

    /**
     * damage-ul dat de incinerate.
     */
    public static final int INCINERATEDAMAGE = 150;
    /**
     * extra pe nivel.
     */
    public static final int INCINERATEBONUS = 20;
    /**
     * damage-ul prelungit.
     */
    public static final int BURNDAMAGE = 50;
    /**
     * extra pe nivel.
     */
    public static final int BURNBONUS = 30;
    /**
     * numarul de runde de efect.
     */
    public static final int ROUNDSBURNED = 2;

    /**
     * modifier-ul de atac 1 si 2 pyromancer-wizard(acelasi modifier).
     */
    public static final float PYROTOWIZARDMOD = 1.05f;
    /**
     * modifier-ul de atac 1 si 2 pyromancer-rogue(acelasi modifier).
     */
    public static final float PYROTOROGUEMOD = 0.8f;
    /**
     * modifier-ul de atac 1 si 2 pyromancer-pyromancer(acelasi modifier).
     */
    public static final float PYROTOPYROMOD = 0.9f;
    /**
     * modifier-ul de atac 1 si 2 pyromancer-knight(acelasi modifier).
     */
    public static final float PYROTOKNIGHTMOD = 1.2f;

    /**
     * procentajul de hp sub care inamicul este omorat.
     */
    public static final float POINTOFEXECUTION = 0.2f;
    /**
     * extra pe nivel.
     */
    public static final float EXECUTIONBONUS = 0.01f;
    /**
     * damage-ul dat de execute.
     */
    public static final int EXECUTEDAMAGE = 200;
    /**
     * extra pe nivel.
     */
    public static final int EXECUTEDMGBONUS = 30;

    /**
     * damage-ul dat de slam.
     */
    public static final int SLAMDAMAGE = 100;
    /**
     * extra pe nivel.
     */
    public static final int SLAMBONUS = 40;
    /**
     * numarul de runde imobilizat.
     */
    public static final int TURNSSLAMMED = 1;

    /**
     * modifier-ul la atac 1 knight-wizard.
     */
    public static final float KNIGHTTOWIZZARDMOD1 = 0.8f;
    /**
     * modifier-ul la atac 1 knight-rogue.
     */
    public static final float KNIGHTTOROGUEMOD1 = 1.15f;
    /**
     * modifier-ul la atac 1 knight-pyromancer.
     */
    public static final float KNIGHTTOPYROMOD1 = 1.1f;
    /**
     * modifier-ul la atac 1 knight-knight.
     */
    public static final float KNIGHTTOKNIGHTMOD1 = 1f;
    /**
     * modifier-ul la atac 2 knight-wizard.
     */
    public static final float KNIGHTTOWIZZARDMOD2 = 1.05f;
    /**
     * modifier-ul la atac 2 knight-rogue.
     */
    public static final float KNIGHTTOROGUEMOD2 = 0.8f;
    /**
     * modifier-ul la atac 2 knight-pyromancer.
     */
    public static final float KNIGHTTOPYROMOD2 = 0.9f;
    /**
     * modifier-ul la atac 2 knight-knight.
     */
    public static final float KNIGHTTOKNIGHTMOD2 = 1.2f;
  /**
   * indexul patch1.
   */
   public static final int PATCHINDEX1 = 31;
  /**
    * indexul patch2.
    */
   public static final int PATCHINDEX2 = 44;
  /**
   * .
   * inversa capatului maxim al intervalului de
   * DefenceStrategy.
   */
   public static final int WIZARDSTRMIN = 4;
  /**
   * .
   * inversa capatului maxim al intervalului de
   * AttackStrategy.
   */
   public static final int WIZARDSTRMAX = 2;
  /**
   * .
   * inversa capatului maxim al intervalului de
   * DefenceStrategy.
   */
   public static final int ROGUESTRMIN = 7;
  /**
   * .
   * inversa capatului maxim al intervalului de
   * AttackStrategy.
   */
   public static final int ROGUESTRMAX = 5;
  /**
   * .
   * inversa capatului maxim al intervalului de
   * DefenceStrategy.
   */
   public static final int PYROSTRMIN = 4;
  /**
   * .
   * inversa capatului maxim al intervalului de
   * AttackStrategy.
   */
   public static final int PYROSTRMAX = 3;
  /**
   * .
   * inversa capatului maxim al intervalului de
   * DefenceStrategy.
   */
   public static final int KNIGHTSTRMIN = 3;
  /**
   * .
   * inversa capatului maxim al intervalului de
   * AttackStrategy.
   */
   public static final int KNIGHTSTRMAX = 2;





}
