import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String charName;
    private String name;
    private Inventory inventory;


   public Player(String name){
       this.name=name;
       this.inventory=new Inventory();
   }
    public  void selectCharacter(){
        Scanner input=new Scanner(System.in);
        int select = 0;

        GameChar[] charList={new Samurai(),new Archer(),new Knight()};

        for(GameChar gameChar: charList){
            System.out.println("ID :" +gameChar.getId()+
                    "\tCharacter :"+ gameChar.getName()+
                    "\tDamage :"+gameChar.getDamage()+"" +
                    "\tHealth :"+gameChar.getHealth()+"" +
                    "\tMoney :" + gameChar.getMoney());
        }

        System.out.print("Select a Character :");
        select=input.nextInt();

        switch (select){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }

        System.out.println("Character :" + this.getCharName()+ ", Damage :"+this.getDamage()+", Health :"+ this.getHealth()+ ", Money :"+ this.getMoney());
    }

    public void initPlayer(GameChar gameChar){
       this.setCharName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
    }

    public void printInfo(){
        System.out.println("Weapon : "+this.getInventory().getWeapon().getName()+",  Damage :"+ this.getDamage()+
                ",   Armor : "+this.getInventory().getArmor().getName()+",   Block :"+this.getInventory().getArmor().getBlock() +",  Health :"+ this.getHealth()+ ", Money :"+this.getMoney());
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void  setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDamage() {
        return damage +this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }


}
