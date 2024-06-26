public class Weapon {
    private int id;
    private String name;
    private int damage;
    private  int price;

    public Weapon(int id, String name, int damage, int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon[] weapons(){
            Weapon[] weaponList=new Weapon[3];
            weaponList[0]=new Weapon(1,"Gun",2,25);
            weaponList[1]=new Weapon(2,"Sword",3,35);
            weaponList[2]=new Weapon(3,"ShotGun",7,45);
            return weaponList;
    }
    public static Weapon  getWeaponObjectById(int id){
        for(Weapon w: Weapon.weapons()){
            if(w.getId()==id){
                return w;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
