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
               System.out.print("Please enter your choose :");
               int selectLoc=input.nextInt();

               switch (selectLoc){
                    case 1:
                         location=new SafeHouse(player);
                         break;
                    case 2:
                         location=new ToolStore(player);
                         break;
                    default:
                         location= new SafeHouse(player);
               }
               if (!location.onLocation()) {
                    System.out.println("You died ! Game Over!");
                    break;
               }
               System.out.println("===================================================");
          }

     }


}
