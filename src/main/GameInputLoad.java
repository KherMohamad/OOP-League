package main;


import champions.Champion;
import common.Constants;
import fileio.FileSystem;

import java.util.ArrayList;

public class GameInputLoad {
    /**
     * calea fisierului de input.
     */
    private final String mInputPath;
    /**
     * calea fisierului de output.
     */
    private final String mOutputPath;


    /**
     * constructor.
     * @param inputPath .
     * @param outputPath .
     */
    GameInputLoad(final String inputPath, final String outputPath) {

        mInputPath = inputPath;

        mOutputPath = outputPath;

    }


    /**
     * functie ce incarca inputul.
     * @return obiect de tipul GameInput
     */
    public GameInput load() {

        ArrayList<String> map = new ArrayList<>();

        ArrayList<ChampionInput> champions = new ArrayList<>();

        ArrayList<String> moves = new ArrayList<>();

        ArrayList<ArrayList<AngelInput>> angels = new ArrayList<>();

        int mapLength = 0;

        int mapWidth = 0;

        int championNr = 0;

        int rounds;




        try {

            FileSystem fs = new FileSystem(mInputPath, mOutputPath);



            mapLength = fs.nextInt();

            mapWidth = fs.nextInt();



            for (int i = 0; i < mapLength; ++i) {

                map.add(fs.nextWord());

            }



            championNr = fs.nextInt();



            for (int i = 0; i < championNr; ++i) {
              ChampionInput input = new ChampionInput();
                input.setType(fs.nextWord());
                input.setY(fs.nextInt());
                input.setX(fs.nextInt());
                champions.add(input);

            }

          rounds = fs.nextInt();

           for (int i = 0; i < rounds; ++i) {
               String move  = fs.nextWord();
               moves.add(move);
           }


           for (int i = 0; i < rounds; ++i) {
               ArrayList<AngelInput> angelsI = new ArrayList<>();
               int angelNr = fs.nextInt();
               for (int j = 0; j < angelNr; ++j) {
                   AngelInput angelIJ = new AngelInput();
                   String angelJ = fs.nextWord();
                   String[] splitInput = angelJ.split(",");
                   angelIJ.setType(splitInput[0]);
                   angelIJ.setX(Integer.parseInt(splitInput[1]));
                   angelIJ.setY(Integer.parseInt(splitInput[2]));
                   angelsI.add(angelIJ);
               }
               angels.add(angelsI);
           }


            fs.close();



        } catch (Exception e1) {
            e1.printStackTrace();

        }



        return new GameInput(map, champions, moves, angels);

    }

    /**
     * scrie outputul in fisier.
     * @param champions lista de eroi
     * @param gr8MagicianArchive globul de sticla
     */
    public void outPut(final ArrayList<Champion> champions,
                       final ArrayList<String> gr8MagicianArchive) {
        try {
        FileSystem fs = new FileSystem(mInputPath, mOutputPath);
        for (String line : gr8MagicianArchive) {
            if (line.startsWith("~~ Round") && !(line.endsWith(" 1 ~~"))) {
                fs.writeNewLine();
            }
            fs.writeWord(line);
            fs.writeNewLine();
        }
        fs.writeNewLine();
        fs.writeWord("~~ Results ~~");
        fs.writeNewLine();
            for (Champion championI : champions) {
              if (championI.getDead()
                      || championI.getId() == Constants.PATCHINDEX1) {
                  fs.writeCharacter(championI.getType());
                  fs.writeWord(" Dead");
                  fs.writeNewLine();
              } else if (championI.getId() == Constants.PATCHINDEX2) {
                  fs.writeCharacter(championI.getType());
                  fs.writeWord(" ");
                  fs.writeInt(championI.getLevel());
                  fs.writeWord(" ");
                  fs.writeInt(0);
                  fs.writeWord(" ");
                  fs.writeInt(championI.getMaxHp());
                  fs.writeWord(" ");
                  fs.writeInt(championI.getLocation().getY());
                  fs.writeWord(" ");
                  fs.writeInt(championI.getLocation().getX());
                  fs.writeNewLine();
              } else {
                  fs.writeCharacter(championI.getType());
                  fs.writeWord(" ");
                  fs.writeInt(championI.getLevel());
                  fs.writeWord(" ");
                  fs.writeInt(championI.getXp());
                  fs.writeWord(" ");
                  fs.writeInt(championI.getCurrentHp());
                  fs.writeWord(" ");
                  fs.writeInt(championI.getLocation().getY());
                  fs.writeWord(" ");
                  fs.writeInt(championI.getLocation().getX());
                  fs.writeNewLine();
              }
            }
            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

}
