public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(2,player, "Tool Store");
    }

    @Override
    public boolean onLocation(){
        System.out.println("-----Welcome to store !-----");
        boolean showMenu=true;
        while(showMenu){
            System.out.println("1-Weapons");
            System.out.println("2-Armors");
            System.out.println("3-Exit");
            System.out.print("Your choose :");
            int selectCase=input.nextInt();
            while(selectCase<1 || selectCase>3){
                System.out.println("Invalid value ! Try again.");
                selectCase=input.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("See you adventurer !");
                    showMenu=false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon(){
        System.out.println("----Weapons----");
        for( Weapon w: Weapon.weapons()  ){
            System.out.println(w.getId()+"-"+w.getName()+"  ==>"+"  Damage:"+ w.getDamage()+ "  Price:"+ w.getPrice() );
        }
        System.out.println("0-Exit");
    }
    public void  buyWeapon(){
        System.out.print("Your choose :");
        int selectWeapon=input.nextInt();
        while(selectWeapon<0 || selectWeapon>Weapon.weapons().length){
            System.out.println("Invalid value ! Try again :");
            selectWeapon=input.nextInt();
        }
        if(selectWeapon!=0){
            Weapon selectedWeapon=Weapon.getWeaponObjectById(selectWeapon);
            if(selectedWeapon!=null){
                if(selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Sorry! You don't have enough money to buy this item.");
                }else {
                    System.out.println("Congratulations! You have a :" + selectedWeapon.getName());
                    int balance =this.getPlayer().getMoney()-selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Remaining money :" + this.getPlayer().getMoney());

                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }

    }
    public void printArmor(){
        System.out.println("----Armors----");
        for(Armor a : Armor.armors()){
            System.out.println(a.getId()+"-"+a.getName()+"  ==>"+"  Block:"+a.getBlock()+"  Price:"+a.getPrice());
        }
        System.out.println("0-Exit");
    }

    public void buyArmor(){
        System.out.println("Your choose :");
        int selectArmor=input.nextInt();

        while (selectArmor<0 || selectArmor>Armor.armors().length){
            System.out.println("Invalid value! Try again.");
            selectArmor=input.nextInt();
        }

        if(selectArmor!=0){
            Armor selectedArmor=Armor.getArmorObjectById(selectArmor);
            if(selectedArmor!=null){
                if(selectedArmor.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Sorry! You don't have enough money to buy this item.");
                }else {
                    System.out.println("Congratulations! You have a :" + selectedArmor.getName());
                    int balance=this.getPlayer().getMoney()-selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Remaining money :"+this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }

    }
}
