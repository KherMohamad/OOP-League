package main;

import angels.Angel;
import angels.AngelFactory;
import champions.ChampionFactory;
import champions.Champion;
import common.GameEngine;
import java.util.ArrayList;

import observers.GreatMagician;
import subjects.Subject;
import terrains.Terrain;



public final class Main {
  private Main() {

  }
    /**
     * main.
     * @param args caile catre fisiere
     */
    public static void main(final String[] args) {
    GameInputLoad inputLoader = new GameInputLoad(args[0], args[1]);
    GameInput input = inputLoader.load();
    GameEngine engine = new GameEngine();
    final ArrayList<ArrayList<Terrain>> map
               = engine.makeMap(input.getMap());
    ArrayList<Champion> champions =
                new ArrayList<Champion>();
    int id = 0;
    ChampionFactory championFactory = ChampionFactory.getInstance();
    for (ChampionInput heroI : input.getChampions()) {
        champions.add(championFactory.getChampion(heroI.getType(), id, map.get(heroI.getY()).get(heroI.getX())));

        id++;
    }
    final ArrayList<ArrayList<Angel>> angels = new ArrayList<>();
    final AngelFactory angelFactory = AngelFactory.getInstance();
    for (ArrayList<AngelInput> angelsInputI : input.getAngels()) {
        ArrayList<Angel> angelsI = new ArrayList<>();
        for (AngelInput angelIJ : angelsInputI) {
            String angelType = angelIJ.getType();
            int x = angelIJ.getX();
            int y = angelIJ.getY();
            Terrain spawnLocation = map.get(x).get(y);
            angelsI.add(angelFactory.getAngel(angelType, spawnLocation));
        }
        angels.add(angelsI);
    }
        Subject roundNotifier = new Subject();
        GreatMagician greatMagician = GreatMagician.getInstance();
        int i = 0;
  for (String movesI : input.getMoves()) {
      roundNotifier.notify(greatMagician, "~~ Round " + (int) (i + 1) + " ~~");
            engine.round(champions, movesI, angels.get(i));
            i++;
        }



        inputLoader.outPut(champions, greatMagician.getMagicOrb());


        }
}



