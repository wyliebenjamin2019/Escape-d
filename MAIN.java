import java.util.Scanner;

public class Main {

    public static Scanner sc;
    public static int moves = 30;
    public static boolean Foyer = true;
    public static boolean Library = false;
    public static boolean Conservatory = false;
    public static boolean chestOpen = false;
    public static boolean hasMatches = false;
    public static boolean candleLit = false;
    public static boolean foyDoorLocked = true;
    public static boolean foyDoorOpen = false;
    public static boolean hasPen = false;
    public static boolean Book = false;
    public static boolean libDoorLocked = true;
    public static boolean libDoorOpen = false;
    public static boolean Trumpet = false;
    public static boolean Piano = false;
    public static boolean Drum = false;
    public static boolean conDoorLocked = true;
    public static boolean conDoorOpen = false;
    public static boolean finished = false;
    public static String dialogue ="\nYou find yourself in a large foyer. There is a door to the north. To the west is a bench\n" +
            "against the wall. To the east is a chest on the floor. In the center of the room is a large\n" +
            "candle. The candle is unlit.\n";

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            room();
            moves--;
            if (finished) {
                break;
            }
        }
        if (finished) {
            System.out.println("E N D G A M E");
        }
        else {
            System.out.printf("\nYou did not complete the Escape Room.");
        }
    }

    public static void room() {
        if (Foyer) {
            foyer();
        }
        else if (Library) {
            library();
        }
        else if (Conservatory) {
            conservatory();
        }
    }

    public static void foyer() {
        System.out.printf("\n%s You have %d moves left.\n>>", dialogue, moves);
        sc = new Scanner(System.in);
        String test = sc.nextLine();
        System.out.println();

        switch (test) {
            case "look bench":
                dialogue = "You examine the bench. There is a note on the bench.";
                break;
            case "look":
                System.out.println(dialogue);
                break;
            case "help":
                dialogue = "Here is what you can do: " +
                        "\nlook ~ help ~ open ~ read ~ light ~ go" +
                        "\nHere's what you can interact with:" +
                        "\nchest ~ candle ~ matches ~ door ~ north ~ note\n";
                break;
            case "read note":
                dialogue = "The note says, 'May my light show you the way.'";
                break;

            case "look chest":
                if (chestOpen) {
                    dialogue = "There is a chest. It is open. There are a box of matches inside";
                }
                else {
                    dialogue = "You see a chest. It is closed. It doesn't appear to be locked.";
                }
                break;

            case "open chest":
                chestOpen = true;
                dialogue = "You open the chest. There is a box of matches here.";
                break;

            case "get matches":
                if (chestOpen) {
                    hasMatches = true;
                    dialogue = "You take the matches.";
                }
                else {
                    dialogue = "There aren't any matches.";
                }
                break;

            case "look candle":
                if (candleLit) {
                    dialogue = "The candle is lit.";
                }
                else {
                    dialogue = "The candle is not lit";
                }
                break;

            case "light candle":
                if (hasMatches) {
                    candleLit = true;
                    foyDoorLocked = false;
                    dialogue = "You light the candle, and fierce wind blows through the room, extinguishing the match in your\n" +
                            "hand, but making the candle burn brighter. You hear a loud metal grinding sound from the\n" +
                            "north.";
                }
                else {
                    dialogue = "You don't have anything to light it with.";
                }
                break;

            case "look door":
                if (!foyDoorLocked) {
                    if (foyDoorOpen) {
                        dialogue = "The door to the north is unlocked and open.";
                    }
                    else {
                        dialogue = "The door to the north is unlocked but closed.";
                    }
                }
                else {
                    dialogue = "The door to the north is locked.";
                }
                break;

            case "open door":
                if (!foyDoorLocked) {
                    foyDoorOpen = true;
                    dialogue = "You open the north door";
                }
                else {
                    dialogue = "The door is locked!";
                }
                break;

            case "go north":
                if (foyDoorOpen) {
                    Foyer = false;
                    Library = true;
                    dialogue = "You leave the foyer, the door behind you closes with a loud slam, and you hear the locking\n" +
                            "mechanism re-lock the door. You cannot return to the foyer.\n" +
                            "You now find yourself in a library full of shelves of books. In the center of the room is a\n" +
                            "desk. On the desk is a pen and a scroll. There is a door to the north.\n";
                }
                else {
                    dialogue = "The door is closed.";
                }
                break;

            default :
                dialogue = "Invalid Command. There is a door to the north. \n" +
                        "To the west is a bench against the wall. \n" +
                        "To the east is a chest on the floor. In the center \n" +
                        "of the room is a large candle.";
                break;
        }
    }

    public static void library() {
        System.out.printf("%s You have %d moves left.\n>>", dialogue, moves);
        sc = new Scanner(System.in);
        String test = sc.nextLine();
        System.out.println();

        switch (test) {
            case "look shelf":
            case "look shelves":
                dialogue = "You examine the shelves.\n" +
                        "You see a book with a dark green, leather cover.\n" +
                        "Upon opening the book, you can see that the first page says:\n" +
                        "The Autobiography of _______. The rest of the pages are glued together.";
                break;
            case "help":
                dialogue = "Here is what you can do: " +
                        "\nlook ~ help ~ get ~ write ~ read ~ open" +
                        "\nHere's what you can interact with:" +
                        "\nbook ~ shelf ~ pen ~ scroll ~ door";
                break;
            case "look":
                dialogue = "You leave the foyer, the door behind you closes with a loud slam, and you hear the locking\n" +                "                            \"mechanism re-lock the door. You cannot return to the foyer.\\n\" +\n" +
                        "You now find yourself in a library full of shelves of books. In the center of the room is a\n"+
                        "desk. On the desk is a pen and a scroll. There is a door to the north.\n";
                break;
            case "look book":
                dialogue = "You see a book with a dark green, leather cover.\nThe First page says:\n" +
                        "The Autobiography of ______";
                break;
            case "look pen":
                if (hasPen) {
                    dialogue = "You have a pen in your hand.";
                }else {
                    dialogue = "There is a pen in the desk";
                }
                break;
            case "get pen":
                if (hasPen) {
                    dialogue = "You already have the pen";
                } else {
                    hasPen=true;
                    dialogue = "You pick up the pen";
                }
                break;
            case "read scroll":
            case "look scroll":
                dialogue = "You examine the scroll. It says, 'Share your Story'.";
                break;
            case "write book":
                if (hasPen) {
                    Book = true;
                    libDoorLocked = false;
                    dialogue = "You print your name on the cover.\n"+
                    "You hear a loud metal grinding sound from the north.";
                }
                else {
                    dialogue = "You do not have anything to write with";
                }
                break;

            case "look door":
                if (!libDoorLocked) {
                    if (libDoorOpen) {
                        dialogue = "The door is unlocked and open.";
                    }
                    else {
                        dialogue = "The door is unlocked, but closed.";
                    }
                }
                else {
                    dialogue = "The door is locked and closed.";
                }
                break;

            case "open door":
                if (!libDoorLocked) {
                    libDoorOpen = true;
                    dialogue = "You open the North door.";
                }
                else {
                    dialogue = "The door is locked.";
                }
                break;

            case "go north":
                if (libDoorOpen) {
                    Library = false;
                    Conservatory = true;
                    dialogue = "You leave the library and enter the conservatory.\n" +
                            "You enter a conservatory. Inside is a set of drums, a trumpet,\n" +
                            "and a piano. In the center of the room is a sheet music resting on a stand.";
                }
                else {
                    dialogue = "The North door is closed.";
                }
                break;

            default:
                dialogue = "Sorry, that is not a valid command.";
        }
    }

    public static void conservatory()  {
        System.out.printf("%s You have %d moves left.\n>>", dialogue, moves);
        sc = new Scanner(System.in);
        String test = sc.nextLine();
        System.out.println();

        switch (test) {
            case "help":
                dialogue = "Here's what you can do: " +
                        "\nlook ~ help ~ play ~ open" +
                        "\nHere's what you can interact with:" +
                        "\nmusic ~ drum ~ trumpet ~ piano ~ door ";
                break;
            case "look":
                dialogue = "You enter a conservatory. Inside is a set of drums, a trumpet,\n" +
                        "and a piano. In the center of the room is sheet music resting on a stand.";
                break;
            case "read music":
                dialogue = "There is sheet music in the center of the room." +
                        "\nOddly enough, there is no music, but a phrase:" +
                        "\n'Timbre, Tone, Time'";
                break;

            case "play trumpet":
                if (!Piano && !Drum) {
                    Trumpet = true;
                    dialogue = "Perfectly in tune...";
                }
                else {
                    dialogue = "That was a little flat...";
                    Trumpet = false;
                    Piano = false;
                    Drum = false;
                }
                break;

            case "play piano":
                if (Trumpet && !Piano && !Drum) {
                    Piano = true;
                    dialogue = "Beautifully played...";
                }
                else {
                    dialogue = "You missed a few notes...";
                    Trumpet = false;
                    Piano = false;
                    Drum = false;
                }
                break;

            case "play drum":
                if (Trumpet && Piano) {
                    Drum = true;
                    conDoorLocked = false;
                    dialogue = "Amazing timing... Suddenly you hear a loud metal grinding sound from the north...";
                }
                else {
                    dialogue = "You need to work on your rhythm...";
                    Trumpet = false;
                    Piano = false;
                    Drum = false;
                }
                break;

            case "open door":
                if (!conDoorLocked) {
                    conDoorOpen = true;
                    dialogue = "You open the North Door";
                }
                else {
                    dialogue = "The North door is closed.";
                }
                break;

            case "go north":
                if (conDoorOpen) {
                    finished = true;
                }
                else {
                    dialogue = "The door is closed.";
                }
                break;

            default:
                dialogue = "That is not a valid command.";
                break;
        }
    }
}
