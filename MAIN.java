import java.util.Scanner;
public class Main {

    public static int turns = 30;
    public static String position = "foyer";
    public static boolean lookbench = false;
    public static boolean chestopen = false;
    public static boolean candlelit = false;
    public static boolean hasmatches = false;
    public static boolean dooropen = false;
    public static boolean haspen = false;
    public static boolean bookopen = false;
    public static boolean libdoorunlocked=false;
    public static boolean libdooropen=false;
    public static boolean haslookedshelf=false;
    public static boolean drum = false;
    public static boolean trumpet = false;
    public static boolean piano = false;
    public static boolean condoorunlocked = false;
    public static boolean condoorunopen = false;

    public static void main(String[] args) {
        start();
    }

    public static void turnCount() {
        turns--;
        if (turns >= 0) {
            System.out.printf("You have %d Turns left.\n\n", turns);
        }
    }

    public static void start() {

        Scanner s = new Scanner(System.in);
        System.out.print("What's your name? \n");
        String name = s.next();
        System.out.println("Hello there, " + name + ". Are you ready to begin your adventure? (Yes or No)");

        Scanner yesNo = new Scanner(System.in);
        String YesNo = yesNo.nextLine();

        if (YesNo.equals("Yes")) {
            System.out.println("\nGreat.\n");

        } else if (YesNo.equals("yes")) {
            System.out.println("\nGreat.\n");
        } else {
            System.out.println("Okay, I'll give you some time");
            System.exit(0);
        }

        System.out.println("NOTE: ALL COMMANDS ARE LOWERCASE");
        System.out.println("You find yourself in a large foyer. There is a door to the north. To the west is a bench\n"+
                "against the wall. To the east is a chest on the floor. In the center of the room is a large\n"+
                "candle. The candle is unlit.\n"+
                "You have 30 turns to escape.");
        seekInput();
    }

    public static void seekInput() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        input1(input);
    }

    public static String input1(String input) {
        if (input.equals("debug")) {
            turns = 1000;
        }
        if (input.equals("1")) {
            position = "library";
        }
        if (input.equals("2")) {
            position = "conservatory";
        }
        if (position == "finished") {
            return "Congratulations";
        }
        if (input.equals("quit")) {
            turns = -1;
        }
        if (turns < 0) {
            return "Fail";
        }
        if (position == "foyer") {
            if (input.equals("help")) {
                System.out.println("Here is what you can do: " +
                        "\nlook ~ help ~ open ~ read ~ light ~ go" +
                        "\nHere's what you can interact with:" +
                        "\nchest ~ candle ~ matches ~ door ~ north ~ note\n");

            }
            if (input.equals("look")) {
                System.out.println("You find yourself in a large foyer. There is a door to the north. To the west is a bench\n" +
                        "against the wall. To the east is a chest on the floor. In the center of the room is a large\n" +
                        "candle. The candle is unlit.\n");
                turnCount();
            }
            if (input.equals("look chest")&&(chestopen==false)) {
                System.out.println("You see a chest. It is closed. It doesn't appear to be locked.");
                turnCount();
            }
            if (input.equals("look chest")&&(chestopen==true)&&(hasmatches==false)) {
                System.out.println("You see a chest. It is open. There are a box of matches inside.");
                turnCount();
            }
            if (input.equals("look chest")&&(chestopen==true)&&(hasmatches==true)) {
                System.out.println("You see a chest. It is open. There is nothing inside now that you have\ntaken the matches.");
                turnCount();
            }
            if (input.equals("look bench")) {
                lookbench=true;
                System.out.println("There is a bench on the western wall. There is a small note here.");
                turnCount();
            }
            if (input.equals("look candle")&&(candlelit==false)) {
                System.out.println("The candle in the center of the room is not lit.");
                turnCount();
            }
            if (input.equals("look candle")&&(candlelit==true)) {
                System.out.println("The candle in the center of the room is lit.");
                turnCount();
            }
            if (input.equals("look note")&&(lookbench==true)) {
                System.out.println("A note is written on a piece of embossed vellum paper. In script writing you can make out\n" +
                        "the phrase 'May my light show you the way.'");
                turnCount();
            }
            if (input.equals("look note")&&(lookbench==false)) {
                System.out.println("There is no note to be looked upon!");
                turnCount();
            }
            if (input.equals("look door")&&(candlelit==false)) {
                System.out.println("The door to the north is closed and locked.");
                turnCount();
            }
            if (input.equals("look door")&&(candlelit==true)) {
                System.out.println("The door to the north is closed, but not locked");
                turnCount();
            }
            if (input.equals("open chest")&&(chestopen==true)) {
                System.out.println("The chest is already open.");
                turnCount();
                chestopen = true;
            }
            if (input.equals("open chest")&&(chestopen==false)) {
                System.out.println("You open the chest. There is a box of matches here.");
                chestopen=true;
                turnCount();
            }
            if (input.equals("get matches")&&(chestopen==true)) {
                System.out.println("You take the box of matches out of the chest.");
                hasmatches=true;
                turnCount();
            }
            if (input.equals("get matches")&&(chestopen==false)) {
                System.out.println("There are no matches to get!");
                turnCount();
            }
            if (input.equals("read note")&&(lookbench==false)) {
                System.out.println("A note is written on a piece of embossed vellum paper. In script writing you can make out\n" +
                        "the phrase 'May my light show you the way.'");
                turnCount();
            }
            if (input.equals("read note")&&(lookbench==true)) {
                System.out.println("There is no note to be looked upon!");
                turnCount();
            }
            if (input.equals("light candle")&&(hasmatches==true)) {
                System.out.println("You light the candle, and fierce wind blows through the room, extinguishing the match in your\n" +
                        "hand, but making the candle burn brighter. You hear a loud metal grinding sound from the\n" +
                        "north.");
                candlelit=true;
                turnCount();
            }
            if (input.equals("light candle")&&(hasmatches==false)) {
                System.out.println("You must find something to light it with!");
                turnCount();
            }
            if (input.equals("open door")&&(candlelit==true)) {
                System.out.println("The north door is open.");
                dooropen=true;
                turnCount();
            }
            if (input.equals("open door")&&(candlelit==false)) {
                System.out.println("The door is locked. You must find a way to open it!");
                turnCount();
            }
            if (input.equals("go north")&&(dooropen==true)) {
               System.out.println("You leave the foyer, the door behind you closes with a loud slam, and you hear the locking\n" +
                       "mechanism relock the door. You cannot return to the foyer.\n" +
                       "You now find yourself in a library full of shelves of books. In the center of the room is a\n" +
                       "desk. On the desk is a pen and a scroll. There is a door to the north.\n");
                turnCount();
                position="library";
            }
            if (input.equals("go north")&&(dooropen==false)&&(candlelit==true)) {
                System.out.println("You must open the door before you can move on");
                turnCount();
            }
            if (input.equals("go north")&&(dooropen==false)&&(candlelit==false)) {
                System.out.println("You cannot go north. There is a door blocking your way out,\nand it is locked");
                turnCount();
            }
            seekInput();
        }
        if (position == "library") {
            if (input.equals("help")) {
                System.out.println("Here is what you can do: " +
                        "\nlook ~ help ~ get ~ write ~ read ~ open" +
                        "\nHere's what you can interact with:" +
                        "\nname ~ shelf ~ pen ~ scroll ~ door\n");
            }
            if (input.equals("look")) {
                System.out.println("You leave the foyer, the door behind you closes with a loud slam, and you hear the locking\n" +
                        "mechanism relock the door. You cannot return to the foyer.\n" +
                        "You now find yourself in a library full of shelves of books. In the center of the room is a\n" +
                        "desk. On the desk is a pen and a scroll. There is a door to the north.\n" +
                        "You have 19 turns to escape.");
                turnCount();
            }
            if (input.equals("look scroll")) {
                System.out.println("You examine the scroll. It says, 'Share your Story'.");
                turnCount();
            }
            if (input.equals("look shelf")) {
                System.out.println("You examine the shelf.");
                haslookedshelf=true;
                System.out.println("You see a book with a dark green, leather cover.\n" +
                        "Upon opening the book, you can see that the first page says:\n"
                        + "'The Autobiography of _______. The rest of the pages are glued together.");
                bookopen=true;
                turnCount();
            }
            if (input.equals("look pen")&&(haspen==true)) {
                System.out.println("You have the pen in your hand.");
                turnCount();
            }
            if (input.equals("look pen")&&(haspen==false)) {
                System.out.println("A pen rests on the desk.");
                turnCount();
            }
            if (input.equals("look door")&&(libdoorunlocked==true)&&(libdooropen==true)) {
                System.out.println("The door is ajar.");
                turnCount();
            }
            if (input.equals("look door")&&(libdoorunlocked==true)&&(libdooropen==false)) {
                System.out.println("The door is closed but unlocked");
                libdooropen=true;
                turnCount();
            }
            if (input.equals("look door")&&(libdoorunlocked==false)&&(libdooropen==false)) {
                System.out.println("The door is closed and locked");
                turnCount();
            }
            if (input.equals("read scroll")) {
                System.out.println("You examine the scroll. It says, 'Share your Story'.");
                turnCount();
            }
            if (input.equals("get pen")&&(haspen==true)) {
                System.out.println("You already have the pen in your possession");
                turnCount();
            }
            if (input.equals("get pen")&&(haspen==false)) {
                haspen = true;
                System.out.println("You pick up the pen");
                turnCount();
            }
            if (input.equals("write name")&&(bookopen==false)) {
                System.out.println("Vandalism is a crime");
                turnCount();
            }
            if (input.equals("write name")&&(bookopen==true)) {
                System.out.print("You print your name on the cover.\n"+
                        "It now says, 'The Autobiography of... ");
                Scanner s = new Scanner(System.in);
                String name = s.next();
                System.out.print(" ");
                System.out.println("'The Autobiography of "+name+"'. The letters melt into the page.\n"+
                        "You hear a loud metal grinding sound from the north.");
                libdoorunlocked=true;
                turnCount();
            }
            if (input.equals("open door")&&(libdoorunlocked==true)&&(libdooropen==true)) {
                System.out.println("The door is already open");
                turnCount();
            }
            if (input.equals("open door")&&(libdoorunlocked==true)&&(libdooropen==false)) {
                System.out.println("You open the door");
                libdooropen=true;
                turnCount();
            }
            if (input.equals("open door")&&(libdoorunlocked==false)&&(libdooropen==false)) {
                System.out.println("The door is closed and locked");
                turnCount();
            }
            if (input.equals("go north")&&(libdoorunlocked==true)&&(libdooropen==true)) {
                System.out.println("You leave the library and enter the conservatory.");
                position="conservatory";
                System.out.println("You enter a conservatory. Inside is a set of drums, a trumpet,\n" +
                        "and a piano. In the center of the room is a sheet music resting on a stand.");
                turnCount();
            }
            if (input.equals("go north")&&(libdoorunlocked==true)&&(libdooropen==false)) {
                System.out.println("The door is closed but unlocked.");
                turnCount();
            }
            if (input.equals("go north")&&(libdoorunlocked==false)&&(libdooropen==false)) {
                System.out.println("The door is closed and locked.");
                turnCount();
            }
            seekInput();
        }
        if (position == "conservatory") {
            if (input.equals("help")) {
                System.out.println("Here's what you can do: " +
                        "\nlook ~ help ~ play ~ open" +
                        "\nHere's what you can interact with:" +
                        "\nsheet ~ drums ~ trumpet ~ piano ~ door ");
            }
            if (input.equals("look")) {
                System.out.println("You enter a conservatory. Inside is a set of drums, a trumpet,\n" +
                        "and a piano. In the center of the room is sheet music resting on a stand.");
                turnCount();
            }
            if (input.equals("look door")&&(condoorunlocked==true)&&(condoorunopen==false)) {
                System.out.println("The door is closed, but unlocked");
                turnCount();
            }
            if (input.equals("look door")&&(condoorunlocked==false)) {
                System.out.println("The door is locked and closed");
                turnCount();
            }
            if (input.equals("look door")&&(condoorunopen==true)) {
                System.out.println("The door is open");
                turnCount();
            }
            if (input.equals("look drums")) {
                System.out.println("There is an expensive set of drums to the right.");
                turnCount();
            }
            if (input.equals("look trumpet")) {
                System.out.println("There is an golden trumpet on the floor.");
                turnCount();
            }
            if (input.equals("look piano")) {
                System.out.println("There is an expensive piano to the left.");
                turnCount();
            }
            if (input.equals("play trumpet")&&(piano==false)) {
                System.out.println("*trumpet Noises*");
                trumpet=true;
                turnCount();
            }
            if (input.equals("play trumpet")&&(piano==true)) {
                System.out.println("*trumpet Noises*");
                piano=false;
                trumpet=true;
                turnCount();
            }
            if (input.equals("play piano")&&(trumpet==true)) {
                System.out.println("*piano Noises*");
                piano=true;
                turnCount();
            }
            if (input.equals("play piano")&&(trumpet==false)) {
                System.out.println("*piano Noises*");
                turnCount();
            }
            if (input.equals("play drums")&&(trumpet==false)) {
                System.out.println("*drum Noises*");
                turnCount();
            }
            if (input.equals("play drums")&&(trumpet==true)&&(piano==false)) {
                System.out.println("*drum Noises*");
                piano=false;
                turnCount();
            }
            if (input.equals("play drums")&&(trumpet==true)&&(piano==true)) {
                System.out.println("Suddenly, you hear the sound of metal gears grinding.");
                condoorunlocked=true;
                turnCount();
            }
            if (input.equals("look sheet")) {
                System.out.println("There is sheet music in the center of the room." +
                        "\nOddly enough, there is no music, but a phrase:" +
                        "\n'Timbre, Tone, Time'");
                turnCount();
            }
            if (input.equals("open door")&&(condoorunopen==true)) {
                System.out.println("The door is already open");
                turnCount();
            }
            if (input.equals("open door")&&(condoorunlocked==true)&&(condoorunopen==false)) {
                System.out.println("The door is now open");
                condoorunopen=true;
                turnCount();
            }
            if (input.equals("open door")&&(condoorunlocked==false)&&(condoorunopen==true)) {
                System.out.println("The door is locked and closed");
                turnCount();
            }
            if (input.equals("go north")&&(condoorunopen==true)) {
                System.out.println("You leave the escape room");
                position="finished";
                System.out.println("Press 'enter' to finish the game.");
                turnCount();
            }
            if (input.equals("go north")&&(condoorunopen==false)&&(condoorunlocked==true)) {
                System.out.println("The door is closed, but unlocked.");
                turnCount();
            }
            if (input.equals("go north")&&(condoorunopen==false)&&(condoorunlocked==false)) {
                System.out.println("The door is closed and locked.");
                turnCount();
            }
            seekInput();
        }
        return "You Died";
    }
}
