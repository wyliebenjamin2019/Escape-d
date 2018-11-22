import java.util.Scanner;
public class Main {

    public static int foodPacks = 30;
    public static boolean looked = false;
    public static String position = "shore";
    public static boolean ropeAcquired = false;
    public static boolean holeDug = false;
    public static boolean canSee = true;
    public static boolean branchPossesion = false;
    public static boolean lookedEast = false;
    public static boolean trapped = false;
    public static boolean paperAcquired = false;
    public static int torch = 0;
    public static boolean memory = false;
    public static boolean examinedBodies = false;
    public static boolean cavernSeen = false;
    public static boolean vine = false;

    public static void main(String[] args) {
        start();
    }

    public static void foodCount() {
        foodPacks -= 3;
        if (foodPacks >= 0) {
            System.out.printf("You have %d Food packs left.\n\n", foodPacks);
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

        System.out.println("NOTE: ALL COMMANDS ARE LOWERCASE EXCEPT DIRECTIONAL (North, East South, West)");
        System.out.println("You find yourself washed up on a large island, with no recollection as to how you got there.");
        System.out.println("\n The only supplies you carry are the clothes on your back, and a small backpack filled with packaged food.");
        System.out.println("\nYou have 30 Food Packs in your bag until you starve. \nYour adventure begins now\n\nType 'help' for a list of commands\n");
        seekInput();
    }

    public static void seekInput() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        input1(input);
    }

    public static String input1(String input) {
        if (input.equals("debug")) {
            foodPacks = 1000;
        }
        if (input.equals("1")) {
            position = "temple";
        }
        if (input.equals("2")) {
            position = "westShore";
        }
        if (input.equals("3")) {
            position = "code";
        }
        if (position == "rescued") {
            return "Congratulations";
        }
        if (input.equals("quit")) {
            foodPacks = 0;
        }
        if (foodPacks < 0) {
            return "Fail";
        }
        if (position == "shore") {
            if (input.equals("help")) {
                if (looked == false) {
                    System.out.println("Here's what you can do: \nlook - help\nHere's what you can interact with:\n");
                }
                if ((looked == true) && (holeDug == false)) {
                    System.out.println("Here's what you can do: \nlook - help - dig - climb - North - South\nHere's what you can interact with: \ntree - sand");
                }
                if ((holeDug == true)&&(ropeAcquired == false)) {
                    System.out.println("Here's what you can do: \nlook - help - get - climb\nHere's what you can interact with: \ntree - rope");
                }
                if ((ropeAcquired == true)&&(paperAcquired == false)) {
                    System.out.println("Here's what you can dO:\nlook - help - get - climb\nHere's what you can interact with:\ntree - rope - note");
                }
                if ((paperAcquired == true)) {
                    System.out.println("Here's what you can dO:\nlook - help - climb - North - South\nHere's what you can interact with:\ntree");
                }
            }
            if (input.equals("look")) {
                if (holeDug == false) {
                    System.out.println("To the North is a thick jungle, and to the South is the Ocean.\nThe East is blocked by a large mountain that cuts off the cove you washed ashore on.\nThe West is a long stretch of sandy beaches, to what seems like no end.");
                    looked = true;
                    System.out.println("\nYou notice that you are hungry, and eat 3 food packs from your bag.");
                    foodCount();
                }
                if ((ropeAcquired == false) && (holeDug == true)) {
                    System.out.println("There are parts of a shipwreck buried in the sand. Including a long rope.");
                }
                if (ropeAcquired == true) {
                    System.out.println("Now that you have the rope, the tree should be easy to climb");
                }
            }
            if (input.equals("dig sand") && (looked == true)) {
                System.out.println("You begin digging next to your feet, until you feel something buried beneath the sand.");
                holeDug = true;
            }
            if (input.equals("South") && (looked == true)) {
                foodPacks = -1;
                System.out.println("You walk into the violent waves only to be knocked down and dragged out to the\n middle of the ocean, where sharks are pleased to have their dinner");
                System.out.println("--==<<YOU DIED>>==--\n Press 'Enter' to finish the game");
            }
            if (input.equals("North") && (looked == true) && (paperAcquired == true)) {
                System.out.println("You enter the thick jungle canvas. Just a few steps in, and you are \nimmediately surrounded by mosquitoes. Your vision is blurred");
                canSee = false;
                position = "jungle";
            }
            if (input.equals("North") && (looked == true) && (paperAcquired == false)) {
                System.out.println("You should look around for clues and materials before wandering off...");
            }
            if (input.equals("climb tree") && (looked == true)) {
                if ((ropeAcquired == true)&&(paperAcquired==true)) {
                    System.out.println("You begin climbing the tree...");
                    position = "tree1";
                }
                if (ropeAcquired == false) {
                    System.out.println("The Trees are too steep to climb! You need something to assist you..");
                }
                if ((ropeAcquired == true)&&(paperAcquired=false)) {
                    System.out.println("While you may have the tools to scale this tree, you should look around\nto see if there is anything else worth taking");
                }
            }
            if (input.equals("look sand") && (looked == true)&&(holeDug==false)) {
                System.out.println("The sand is soft, but strangely uneven...");
            }
            if (input.equals("look sand")&&(holeDug==true)) {
                System.out.println("There are parts of a shipwreck buried in the sand. Including a long rope");
            }
            if (input.equals("get rope") && (holeDug == true)) {
                ropeAcquired = true;
                System.out.println("You have obtained the rope!\n...Hold on, there is something else here... a note ");
            }
            if ((ropeAcquired == true) && (input.equals("get note"))) {
                System.out.println("You pick up the note. It says: '20601'");
                paperAcquired = true;
            }
            seekInput();
        }
        if (position == "tree1") {
            if (input.equals("help")) {
                System.out.println("Here is what you can do: \nlook - help - climb - swing\nHere's what you can interact with:\n");
            }
            if (input.equals("look")) {
                System.out.println("There is a loose branch that is out of reach on another tree.\n You notice that your rope is long enough to either scale to the top of the tree, \nor swing to another tree and acquire the branch.");
            }
            if (input.equals("climb")) {
                System.out.println("You climb to the top of a tree");
                position = "tree2";
            }
            if (input.equals("swing")) {
                System.out.println("You swing to the other tree, and just as you land, the rope snaps");
                position = "treeB";
            }
            seekInput();
        }
        if (position == "tree2") {
            if (input.equals("help")) {
                System.out.println("Here's what you can do: \nlook - help - East \nHere's what you can interact with: \n  ");
            }
            if (input.equals("look")) {
                System.out.println("As you look up, you realize the Tallest branch \non the Tree can support your climb onto the large rock...");
                lookedEast=true;
            }
            if ((input.equals("East")) && (lookedEast == false)) {
                System.out.println("You do not know what lies East!");
            }
            if ((input.equals("East")) && (lookedEast == true)) {
                System.out.println("You make your way to the tallest branch, and use it to maneuver \nyourself over to the top of the large rock.");
                System.out.println("All of this movement makes you hungry...");
                foodCount();
                position = "rock";
            }
            seekInput();
        }
        if (position == "rock") {
            if (input.equals("help")&&(cavernSeen==false)) {
                System.out.println("Here's what you can do: \nlook - help \nHere's what you can interact with:\n ");
            }
            if (input.equals("help")&&(cavernSeen==true)) {
                System.out.println("Here's what you can do: \nlook - help - descend \nHere's what you can interact with:\nrock ");
            }
            if (input.equals("look")) {
                System.out.println("Behind the Boulder is a series of sharp rocks, violent waves, and dangerous currents. You see just a few feet below you lies a cavern entrance.");
                cavernSeen=true;
            }
            if (input.equals("descend rock")&&(cavernSeen==true)) {
                System.out.println("You climb down into the cavern. However you forgot to zip up your bag, and 5 Food Packs fall down into the oceanic cliffs.");
                foodPacks-=2;
                foodCount();
                System.out.println("\nYou have come across and ancient temple, hidden inside the mountains.\nAs you continue to explore, the foundation of rock beneath you crumbles.\nYou find yourself falling into a dark abyss, uncertain of your fate");
                position="falling";
            }
            seekInput();
        }
        if (position=="falling") {
            if (input.equals("look")) {
                System.out.println("You land in a small body of water, just deep enough to catch your fall. Upon resurfacing, you can see a small light at the end of a tunnel, and decide to approach it.");
                System.out.println("\nAs you approach the light, which you can now recognize as a small torch, you enter a room where a wall behind you slides closed");
                System.out.println("A strong wind blows out the torch, just as another further away ignites.");
                position="secretRoom";
            }
            if (input.equals("help")) {
                System.out.println("Here's what you can do:\nlook - help\nHere's what you can interact with:\n");
            }
            seekInput();
        }
        if (position == "treeB") {
            if (input.equals("help")) {
                System.out.println("Here's what you can do: \nhelp - look - get - jump\n Here's what you can interact with:\nbranch");
            }
            if ((input.equals("help"))&&(vine==true)) {
                System.out.println("Here's what you can do: \nhelp - look - jump - climb\n Here's what you can interact with:\ntree");
            }
            if (input.equals("look")) {
                System.out.println("You stand upon the arm of a tree high in the canopy.\nThe perfect, multifunctional branch is elongated in your direction");
            }
            if (input.equals("get branch")) {
                System.out.println("You easily snap the branch from its place. Perfectly straight, perfectly weighted.\nYou see a Coconut in the distance, and knock it down with your new stick.");
                System.out.println("You store the coconut for consumption later");
                foodPacks += 7;
                foodCount();
                branchPossesion = true;
                System.out.println("You notice a nearby vine that is perfect for letting you scale to the top of the tree.");
                vine=true;
            }
            if (input.equals("jump")) {
                System.out.println("\n\nS P L A T\n\n");
                foodPacks = 0;
            }
            if (input.equals("climb vine")&&(vine==true)){
                System.out.println("You climb the vine, only to come face to face with a spotted python. \nYou sacrifice your perfect stick to defend yourself, and knock the snake to the ground");
                System.out.println("You approach the top of the towering boulder...");
                position="rock";
            }
            seekInput();
        }
        if (position == "jungle") {
            if (input.equals("look")) {
                System.out.println("You cannot see, there are mosquitoes everywhere!");
            }
            if (input.equals("help")) {
                System.out.println("Here's what you can do: \n help - run - retreat\nHere's what you can interact with:\n");
            }
            if (input.equals("run")) {
                System.out.println("As you run away from the swarm, your vision once again becomes reliable. \nAs the last of the swarm dies off, you notice a small stone structure in the distance and decide to approach it.");
                position = "temple";
                System.out.println("You become slightly Hungry from the long journey...");
                foodPacks -= 2;
                foodCount();
            }
            if (input.equals("retreat")) {
                System.out.println("You run back toward the beach, where the mosquitoes won't follow.");
                position = "shore";
            }
            seekInput();
        }
        if (position == "temple") {
            if (input.equals("help")) {
                if (trapped == true) {
                    System.out.println("Here's what you can do:\nlook - help - good ol' fashion switcheroo\nHere's what you can interact with:\n");
                }
                if (trapped == false) {
                    System.out.println("Here's what you can do:\n look - help - enter - retreat\nHere's what you can interact with:\n temple");
                }
            }
            if (input.equals("look")) {
                System.out.println("There appears to be an ancient temple on this island, overgrown with moss and\nother jungle flora. The large stone body of a jaguar protrudes through the center \nof the temple. As if to ward off any visitors...");
            }
            if (input.equals("look") && (trapped == true)) {
                System.out.println("You are trapped...");
            }
            if (input.equals("enter") && (trapped == false)) {
                System.out.println("You take your first steps into the mysterious ruins. *CLICK* \nYour left foot lands on a trap, still fully functional even after all the years that \nthis temple has been abandoned...");
                trapped = true;

            }
            if (input.equals("retreat") && (trapped == false)) {
                System.out.println("You return to the island shore...");
                position = "shore";
            }
            if (input.equals("good ol' fashion switcheroo") && (trapped == true)) {
                System.out.println("You take a substantial amount of your food supply to substitute the \nweight of your foot. You stand back in disbelief as to how you could have\n accomplished such a maneuver, until the floor below you drops...");
                position = "tunnel";
                foodPacks -= 5;
                foodCount();
            }
            seekInput();
        }
        if (position == "tunnel") {
            if (input.equals("look")) {
                System.out.println("It is pitch black, but you can feel yourself sliding down a long tunnel.\nThe sound of creaking gears makes it impossible to think. Suddenly, you\ncome to a stop. A single torch lights up the room you are in.");
                position = "secretRoom";
            }
            if (input.equals("help")) {
                System.out.println("Here's what you can do:\n look - help\nHere's what you can interact with:\n");
            }
            seekInput();
        }
        if (position == "secretRoom") {
            if (input.equals("look") && (torch == 0)) {
                System.out.println("A single torch guides your way");
            }
            if (input.equals("help") && (torch == 0)) {
                System.out.println("Here's what you can do:\nlook - help - follow\nHere's what you can interact with:\ntorch\n");
            }
            if (input.equals("look") && (torch == 1)) {
                System.out.println("You continue to follow the light");
            }
            if (input.equals("help") && (torch == 1)) {
                System.out.println("Here's what you can do:\nlook - help - follow\nHere's what you can interact with:\ntorch\n");
            }
            if (input.equals("follow torch") && (torch == 0)) {
                System.out.println("You make your way towards the light on the other side of the room...");
                System.out.println("You grow slightly hungrier, and decide to eat some more.");
                torch = 1;
                foodCount();
            }
            if (input.equals("follow torch") && (torch == 1)) {
                System.out.println("As you get closer, you see a panel on the wall with five slots");
                position = "code";
            }
            seekInput();
        }
        if (position == "code") {
            if (input.equals("look") && (memory == false)) {
                System.out.println("It looks like you need to enter a code...");
            }
            if (input.equals("look") && (memory == true)) {
                System.out.println("Suddenly, the torch light grows. You slowly turn around,\nto see your 5 team members lifeless, leaning against the walls");
                System.out.println("Poisoned Arrows litter their corpses. You can infer that \nthis place is Booby Trapped. Any wrong move, and you'll die");
                System.out.println("\nYou must decide your next move carefully");
                position = "realization";
            }
            if (input.equals("help")) {
                System.out.println("Here's what you can do:\nlook - help - (entercode)\nHere's what you can interact with:\n\n");
                torch = 1;
            }
            if (input.equals("20601")) {
                System.out.println("The wall in front of you slides open, the sound of stone slab grinding against the mountain is deafening\nBehind the wall is a view of the whole island on a map, with a large diamond emerging from the center.\n Seeing the shape of the island has triggered your memory");
                System.out.println("\nYou are an explorer, who voyaged out to sea with your colleagues\n in search of an island rumored to contain a priceless Diamond.\n You remember the violent waves that capsized your boat, and how you were knocked unconscious.");
                System.out.println("You are filled with relief to have been so lucky, and to be the first\n explorer to make such an accomplishment... Until you ponder the fate of your 5 team members.\nYou wonder whether they could have died in the shipwreck, or if they made it onto the island like you have.");
                memory = true;
            }
            seekInput();
        }
        if (position == "realization") {
            if (input.equals("help") && (examinedBodies == false)) {
                System.out.println("Here's What you can do:\nlook - help - examine\nHere's what you can interact with:\nmap - bodies");
            }
            if (input.equals("help") && (examinedBodies == true)) {
                System.out.println("Here's What you can do:\nlook - help - get\nHere's what you can interact with:\nmap - torch");
            }
            if (input.equals("look")) {
                    System.out.println("You are trapped in a room. One side has 5 dead corpses, the other has a large map with a diamond in the center.");
            }
            if (input.equals("examine map") && (examinedBodies == false)) {
                    System.out.println("Without thinking, you lay one finger on the core of the diamond.\nAn arrow fires from the wall, tearing a hole in your bag and causing your food packs to spill");
                    foodPacks = 3;
                    System.out.println("You now have 3 Food Packs remaining");
            }
            if (input.equals("examine bodies")) {
                    System.out.println("You search for any information your team can provide you. As you reach \ninto one of their pockets, you find a note written in another language:");
                    System.out.println("\nIt translates to:\n 'Shine a light through my prism to escape your doom. Real Treasures are often not what we believe to be so...'");
                    System.out.println("As you continue searching, you find a map, with a ship drawn on the West shore. You think, 'this must be where the life raft is'");
                    examinedBodies = true;
            }
            if (input.equals("get torch") && (examinedBodies == true)) {
                System.out.println("You hold the torch up to the diamond.\n The Wall to the West drops suddenly. You walk along the path it gives you, \nemerging from a large rabbit hole beneath a tree, and onto the West shore.");
                System.out.println("You grow hungry, and eat three food packs");
                foodCount();
                position = "westShore";
            }

            seekInput();
        }
        if (position == "westShore") {
            if (input.equals("help")) {
                System.out.println("Here's what you can do:\nlook - help\nHere's what you can interact with:\n");
            }
            if (input.equals("look")) {
                System.out.println("The smell of fresh air clams your nerves. You can see the life raft in the distance.");
                System.out.println("You shove the torch into the sand to relinquish the flames, and put it in your bag (for sentimental reasons).");
                System.out.println("You step onto the raft, greeted by the mountain of canned and packaged food and the dual oars to guide you home.");
                System.out.println("\nFIVE DAYS LATER\n");
                System.out.println("As you approach the shore of your home town in San Francisco, you pick up your bag \nand pull out the torch to thank it for saving your life.\nYou glance at the charred end, and see a perfectly cut diamond embedded into the wood.");
                System.out.println("\nE N D G A M E\n");
                position = "rescue";
            }
            seekInput();
        }
        return "You Died";
    }
}
