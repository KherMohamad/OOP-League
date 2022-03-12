package common;

import angels.Angel;
import champions.Champion;
import observers.GreatMagician;
import terrains.Terrain;
import java.util.ArrayList;
import static terrains.TerrainsType.Land;
import static terrains.TerrainsType.Woods;
import static terrains.TerrainsType.Volcanic;
import static terrains.TerrainsType.Desert;


public class GameEngine {
    /**
     * singleton.
     */
    private static ArrayList<ArrayList<Terrain>> map = null;

    /**
     * creeaza un array bidimensional de Terrain reprez. harta.
     * @param input array-ul de stringuri citit din fisier
     * @return harta
     */
   public ArrayList<ArrayList<Terrain>> makeMap(final ArrayList<String> input) {
        if (map == null) {
            map = new ArrayList<>();
            for (int i = 0; i < input.size(); i++) {
                ArrayList<Terrain> line = new ArrayList<>();
                for (int j = 0; j < input.get(i).length(); j++) {
                    if (input.get(i).charAt(j) == 'D') {
                        line.add(new Terrain(i, j, Desert));
                    }
                    if (input.get(i).charAt(j) == 'L') {
                        line.add(new Terrain(i, j, Land));
                    }
                    if (input.get(i).charAt(j) == 'V') {
                        line.add(new Terrain(i, j, Volcanic));
                    }
                    if (input.get(i).charAt(j) == 'W') {
                        line.add(new Terrain(i, j, Woods));
                    }
                }
                map.add(line);
            }
        }

        return map;
    }

    /**
     * returneaza xp-ul dobandit in de un erou ce omoara alt erou.
     * @param levelWinner nivelul eroului castigator
     * @param levelLoser nivelul eroului infrant
     * @return xp-ul dobandit de invingator
     */
    public int xpForKill(final int levelWinner, final int levelLoser) {
        return Constants.SAMELEVELXP
                - (levelWinner - levelLoser) * Constants.KILLCOEFF;
    }

    /**
     * afla daca eroul este sau nu imobilizat.
     * @param champion eroul verificat
     * @return true dace erou este imobilizat,
     * false altfel
     */
    public boolean isParalysed(final Champion champion) {
        ProlongedDamage prolongedDamage
                = champion.getProlongedDamage();


        if (prolongedDamage.getParalysed()) {
            return true;
        }
        return false;
    }

    /**
     * misca eroul.
     * @param champion eroul care se misca
     * @param move caracterul corespunzator
     * miscarii executate
     */
    public void move(final Champion champion,
                     final char move) {

        if (move == '_') {
            return;
        }
        if (move == 'L') {
            int x = champion.getLocation().getX();
            int y = champion.getLocation().getY();
            Terrain newLocation = map.get(y).get(x - 1);
            champion.setLocation(newLocation);
            return;
        }
        if (move == 'R') {
            int x = champion.getLocation().getX();
            int y = champion.getLocation().getY();
            Terrain newLocation = map.get(y).get(x + 1);
            champion.setLocation(newLocation);
            return;
        }
        if (move == 'U') {
            int x = champion.getLocation().getX();
            int y = champion.getLocation().getY();
            Terrain newLocation = map.get(y - 1).get(x);
            champion.setLocation(newLocation);
            return;
        }
        if (move == 'D') {
            int x = champion.getLocation().getX();
            int y = champion.getLocation().getY();
            Terrain newLocation = map.get(y + 1).get(x);
            champion.setLocation(newLocation);
            return;
        }
    }

    /**
     * simuleaza lupta intre 2 eroi.
     * da xp unde este cazul
     * @param champion1 eroul 1
     * @param champion2 eroul 2
     * @param battleground terenul de batalie
     */
    public void duel(final Champion champion1,
                     final Champion champion2,
                     final Terrain battleground) {
        if (champion2.getType() == 'W') {
            champion2.isAttacked(champion1, battleground);
            champion1.isAttacked(champion2, battleground);
        } else {
            champion1.isAttacked(champion2, battleground);
            champion2.isAttacked(champion1, battleground);
        }
        if (champion1.getCurrentHp() <= 0) {
                int xpGained;
                int levelWinner = champion2.getLevel();
                int levelLoser = champion1.getLevel();
                xpGained = Math.max(0, this.xpForKill(levelWinner, levelLoser));
                champion2.setXp(champion2.getXp() + xpGained);
                champion1.setDead(true);
                String message = new String("Player " + champion1.typeFull());
                message += " " + champion1.getId();
                message += " was killed by ";
                message += champion2.typeFull();
                message += " " + champion2.getId();
                GreatMagician magician = GreatMagician.getInstance();
                champion1.getNotifier().notify(magician, message);
        }
        if (champion2.getCurrentHp() <= 0) {
                int xpGained;
                int levelWinner = champion1.getLevel();
                int levelLoser = champion2.getLevel();
                xpGained = Math.max(0, this.xpForKill(levelWinner, levelLoser));
                champion1.setXp(champion1.getXp() + xpGained);
                champion2.setDead(true);
                String message = new String("Player " + champion2.typeFull());
                message += " " + champion2.getId();
                message += " was killed by ";
                message += champion1.typeFull();
                message += " " + champion1.getId();
                GreatMagician magician = GreatMagician.getInstance();
                champion2.getNotifier().notify(magician, message);
        }
    }

    /**
     * executa toate actiunile dintr-o runda.
     * @param champions lista de eroi
     * @param moves string-ul cu miscarile din runda respectiva
     * @param angels lista cu ingerii din runda
     * respectiva
     */
    public void round(final ArrayList<Champion> champions,
                      final String moves,
                      final ArrayList<Angel> angels) {
        this.damageOverTime(champions);
        for (int i = 0; i < moves.length(); i++) {
            if (!(this.isParalysed(champions.get(i))
                    || champions.get(i).getDead())) {
                this.move(champions.get(i), moves.charAt(i));

            }
        }
        for (Champion championI : champions) {
            if (!(this.isParalysed(championI) || championI.getDead())) {
                championI.chooseStrategy();
            }
        }
        for (int i = 0; i < champions.size() - 1; i++) {
            Champion championI = champions.get(i);
            for (int j = i + 1; j < champions.size(); j++) {
                Champion championJ = champions.get(j);
                if (championI.getLocation().equals(championJ.getLocation())) {
                   if (!(championI.getDead() || championJ.getDead())) {
                       this.duel(championI, championJ, championI.getLocation());
                   }
                }
            }
        }
        this.newLevel(champions);
        for (Angel angelI : angels) {
            String message = new String("Angel " + angelI.getType());
            message += " was spawned at ";
            message += angelI.getSpawnLocation().getY();
            message += " " + angelI.getSpawnLocation().getX();
            angelI.getNotifier().notify(GreatMagician.getInstance(), message);
            this.angelEffects(champions, angelI);
        }
        this.newLevel(champions);
    }

    /**
     * aplica damage-ul prelungit asupra tuturor eroilor.
     * @param champions lista de eroi
     */
    public void damageOverTime(final ArrayList<Champion> champions) {
        for (Champion championI : champions) {
            ProlongedDamage iProlongedDamage = championI.getProlongedDamage();
            if (iProlongedDamage.getTurnsDamaged() == 0) {
                championI.setProlongedDamage(new ProlongedDamage(0, 0, false));
            } else {
                int iHp = championI.getCurrentHp();
                championI.setCurrentHp(iHp - iProlongedDamage.getDamage());
                int turnsDamaged = iProlongedDamage.getTurnsDamaged() - 1;
                iProlongedDamage.setTurnsDamaged(turnsDamaged);
            }
            if (championI.getCurrentHp() <= 0) {
                championI.setDead(true);
            }
        }
    }

    /**
     * .
     * aplica efectele ingerului tuturor
     * campionilor aflati pe terenul respectiv.
     * @param champions lista de campioni
     * @param angel ingerul aparut
     */
    public void angelEffects(final ArrayList<Champion> champions,
                             final Angel angel) {
        for (int i = 0; i < champions.size(); i++) {
          if (champions.get(i).getLocation().equals(angel.getSpawnLocation())) {
                champions.get(i).isTouched(angel);
            }
        }
    }

    /**
     * schimba nivelul eroului la fiecare runda la cel nou.
     * @param champions lista de eroi
     */
    public void newLevel(final ArrayList<Champion> champions) {
        for (Champion championI : champions) {
            if (!championI.getDead()) {
                int levelUp = championI.getLevel();
                while (championI.getXp() >= Constants.LEVEL1XP
                    + Constants.UPCOEFF * levelUp) {
                    championI.levelUp();
                    levelUp++;
                }
            }
        }
    }
}


