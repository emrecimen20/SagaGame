import java.util.Scanner;

public  class Game {
     private Scanner input =new Scanner(System.in);




     public  void start(){
          System.out.println("Welcome to Saga Game !");
          System.out.print("Enter your name : ");
          String playerName=input.nextLine();
          Player player=new Player(playerName);
          System.out.println("Adventurer "+ player.getName()+ " welcome to this dark world  !");
          System.out.println("-----------------------------------------------------------------");
          System.out.println("Select your character");

          player.selectCharacter();
          System.out.println("------------------------------------------------------------------");

          Location location = null;
          while(true){
               player.printInfo();
               Scanner input=new Scanner(System.in);

               System.out.println("##Locations :");
               System.out.println("1-Safe House ==> Here your health is regeneration.");
               System.out.println("2-Tool Store ==> You can buy weapon or armor.");
               System.out.println("3-Cave ==> Award : Food. Be careful! " +
                       "There is a monster here ");
               System.out.println("4-Forest ==> Award : Firewood. Be careful! " +
                       "There is a monster here ");
               System.out.println("5-River ==> Award : Water. Be careful! " +
                       "There is a monster here ");
               System.out.println("6-Coal ==> Award : Random Weapon,Armor or Money. Be careful! " +
                       "There is a monster here ");

               System.out.println("0-Exit the Game.");


               System.out.print("Please enter your choose :");
               int selectLoc=input.nextInt();

               switch (selectLoc){
                    case 0:
                         location=null;
                         break;
                    case 1:
                         location=new SafeHouse(player);
                         break;
                    case 2:
                         location=new ToolStore(player);
                         break;
                    case 3:
                         location=new Cave(player);
                         break;
                    case 4:
                         location=new Forest(player);
                         break;
                    case 5:
                         location=new River(player);
                         break;
                    case 6:
                         location=new Coal(player);
                         break;
                    default:
                         System.out.println("Please enter a valid region.");
               }

               if(location==null){
                    System.out.println("Game Over ! See you !");
                    break;
               }
               if (!location.onLocation()) {
                    System.out.println("You died ! Game Over!");
                    break;
               }
               System.out.println("===================================================");
          }

     }


}
