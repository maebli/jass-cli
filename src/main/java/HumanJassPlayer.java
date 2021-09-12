import ch.game.jass.JassCard;
import ch.game.jass.JassTrick;
import ch.game.jass.exception.JassCardNotInSetException;
import ch.game.jass.player.BasicJassPlayer;
import ch.game.jass.player.JassHand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HumanJassPlayer extends BasicJassPlayer {

    Scanner reader = new Scanner(System.in);

    @Override
    public JassCard playCard(JassTrick trick) {

        JassHand hand=getHand();
        System.out.println("Your hand:");
        int i=0;
        ArrayList<JassCard> cards = new ArrayList<JassCard>(hand.getAllCards());

        Collections.sort(cards);

        for(JassCard card:cards){
            System.out.println(i++ +":"+card+" ");
        }

        System.out.println("Enter number of card: ");
        int n = reader.nextInt();
        JassCard card=cards.get(n);
        try {
            hand.removeCard(card);
        } catch (JassCardNotInSetException e) {
            System.err.println("card doesn't exist in players hand.");
            System.exit(0);
        }
        return card;
    }

    @Override
    public int chooseGameMode() {

        System.out.println("Choose the mode of play");
        System.out.println("OBEN=0, UNTEN=1,SCHELLEN TRUMPF=2,SCHILTEN_TRUMPF=3,EICHEL_TRUMPF=4, ROSEN_TRUMPF=5");

        int n = reader.nextInt();

        return n;
    }

    @Override
    public boolean decidedToChooseGameMode(){
        System.out.println("Would you like to choose the mode? (0 = no, 1 = yes)");
        int n = reader.nextInt();
        return n!=0;
    }


}
