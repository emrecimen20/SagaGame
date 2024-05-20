import java.util.Random;

public class BattleLoc extends Location {
private Obstacle obstacle;
private String award;
private int maxObstacle;
private Random rand=new Random();

    public BattleLoc(int id,Player player,String name,Obstacle obstacle,String award,int maxObstacle){
        super(id,player,name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }

    @Override
    public boolean onLocation(){
        int obsNumber=randomObstacleNumber();
        System.out.println("You are in here : "+ this.getName());
        System.out.println("Be careful! "+obsNumber+" "+this.getObstacle().getName()+"(s)"+ " lives here!");
        System.out.print("<F>ight or <E>scape :");
        String selectCase=input.nextLine();
        selectCase=selectCase.toUpperCase();
        if (selectCase.equals("F")) {
            if (combat(obsNumber)) {
                switch (this.award){
                    case "food":
                        this.getPlayer().getInventory().setFood(true);
                        break;
                    case "firewood":
                        this.getPlayer().getInventory().setFirewood(true);
                        break;
                    case "water":
                        this.getPlayer().getInventory().setWater(true);
                        break;
                }
                System.out.println(this.getName() + " area gained ");
                return true;
            }
        }
        if(this.getPlayer().getHealth()<=0){
            System.out.println("You died !");
            return false;
        }

        return true;
    }

    public boolean combat(int obsNumber){
        for(int i=1;i<=obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOrgHealth());
            playerStats();
            obstacleStats(i);
            while(this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){
                System.out.print("<F>ight or <E>scape :");
                String selectCombat=input.nextLine().toUpperCase();
                if(selectCombat.equals("F")){
                    Random rand=new Random();
                    int firstBlood=rand.nextInt(100);
                    if(firstBlood>50){
                        System.out.println("Your attack !");
                        this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                        afterHit();
                        if(this.getObstacle().getHealth()>0){
                            System.out.println();
                            System.out.println("Obstacle Attack!");
                            int obstacleDamage=this.getObstacle().getDamage()-getPlayer().getInventory().getArmor().getBlock();
                            if(obstacleDamage<0){
                                obstacleDamage=0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                            afterHit();
                        }
                    }else{
                        System.out.println("Obstacle Attack!");
                       int obstacleDamage=this.getObstacle().getDamage()-getPlayer().getInventory().getArmor().getBlock();
                        if(obstacleDamage<0){
                            obstacleDamage=0;
                        }

                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                        afterHit();

                        if(this.getPlayer().getHealth()>0){
                            System.out.println();
                            System.out.println("Your Attack");
                            this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                            afterHit();
                        }
                    }

                }else {
                    return false;
                }
            }
            if(this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                if (!obstacle.getName().equals("Snake")) {
                    System.out.println("You Win !");
                    System.out.println(this.getObstacle().getAward()+ " Money won !");
                    this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                    System.out.println("Your Money :"+this.getPlayer().getMoney());
                } else {
                    System.out.println("You Win !");
                    int randomNumber = rand.nextInt(100) + 1;
                    if (randomNumber <= 15) {
                        int randomWeapon = rand.nextInt(100) + 1;
                        if (randomWeapon <= 20) {
                            System.out.println("You won a SHOTGUN.");
                            Weapon shotgun = Weapon.weapons()[2];
                            getPlayer().getInventory().setWeapon(shotgun);
                        } else if (randomWeapon <= 50) {
                            System.out.println("You won a SWORD.");
                            Weapon sword = Weapon.weapons()[1];
                            getPlayer().getInventory().setWeapon(sword);
                        } else {
                            System.out.println("You won a GUN.");
                            Weapon gun = Weapon.weapons()[0];
                            getPlayer().getInventory().setWeapon(gun);
                        }
                    } else if (randomNumber <= 30) {
                        int randomArmor = rand.nextInt(100) + 1;
                        if (randomArmor <= 20) {
                            System.out.println("Ağır armor you won");
                            Armor heavyArmor = Armor.armors()[2];
                            getPlayer().getInventory().setArmor(heavyArmor);
                        } else if (randomArmor <= 50) {
                            System.out.println("Orta armor you won");
                            Armor mediumArmor = Armor.armors()[1];
                            getPlayer().getInventory().setArmor(mediumArmor);
                        } else {
                            System.out.println("Light armor you won");
                            Armor lightArmor = Armor.armors()[0];
                            getPlayer().getInventory().setArmor(lightArmor);
                        }
                    } else if (randomNumber <= 55) {
                        int randomMoney = rand.nextInt(100) + 1;
                        if (randomMoney <= 20) {
                            System.out.println("10 Money you won !");
                            getPlayer().setMoney(getPlayer().getMoney() + 10);
                        } else if (randomMoney <= 50) {
                            System.out.println("5 Money you won ! ");
                            getPlayer().setMoney(getPlayer().getMoney() + 5);
                        } else {
                            System.out.println("Unlucky ! You didn't win anything");
                        }
                    }
                }
            }else{
                return false;
            }

        }
        return true;
    }
    public void afterHit(){
        System.out.println("Your health :"+this.getPlayer().getHealth());
        System.out.println(this.obstacle.getName()+" Health :"+this.obstacle.getHealth());
        System.out.println();
    }
    public void obstacleStats(int i){
        System.out.println(i+"."+"Obstacle Stats :");
        System.out.println("---------------------------------");
        System.out.println("Health :"+this.getObstacle().getHealth());
        System.out.println("Damage :"+this.getObstacle().getDamage());
        System.out.println("Award :" + this.getObstacle().getAward());
        System.out.println();
    }

    public void playerStats(){
        System.out.println("Player stats :");
        System.out.println("---------------------------------");
        System.out.println("Health :"+ this.getPlayer().getHealth());
        System.out.println("Weapon :" +this.getPlayer().getInventory().getWeapon().getName() );
        System.out.println("Armor :"+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block :"+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Damage :"+ this.getPlayer().getTotalDamage());
        System.out.println("Money :"+ this.getPlayer().getMoney());



    }
    public int randomObstacleNumber(){
        Random r=new Random();
        return r.nextInt(this.getMaxObstacle())+1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
