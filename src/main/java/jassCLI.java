import ch.game.cardgame.CardGameFactory;
import ch.game.jass.Jass;
import ch.game.jass.JassTable;
import ch.game.jass.exception.JassCardGameDoesNotExistException;
import ch.game.jass.player.JassPlayer;
import ch.game.jass.player.JassPlayersBuilder;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class JassCLI {

    private static Jass jass;
    private static final Logger LOGGER = Logger.getLogger("Logger");

    public static void main(String[] args){

        try {
            jass=(Jass) CardGameFactory.make("Jass");
        } catch (JassCardGameDoesNotExistException e) {
            System.err.println("Game doesn't exist..");
            System.exit(0);
        }

        System.out.println("Starting Jass Computer Version "+jass.getVersion());

        LOGGER.setLevel(Level.OFF);

        JassPlayersBuilder playersBuilder=new JassPlayersBuilder();

        JassPlayersBuilder.setPlayerNumber(3);
        ArrayList<JassPlayer> players = playersBuilder.build();

        HumanJassPlayer cli = new HumanJassPlayer();

        cli.assignName("cli");

        players.add(cli);

        JassTable table = new JassTable(players);

        jass.setPlayers(table);

        jass.play();


    }


}