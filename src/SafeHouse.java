public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player){
        super(1,player,"Safe House");
    }

    @Override
    public boolean onLocation(){
        System.out.println("You are in Safece House !");
        System.out.println("Your health is FULL !");
        this.getPlayer().setHealth(this.getPlayer().getOrgHealth());
        return true;
    }
}
