public class Obstacle {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int award;
    private int orgHealth;

    public Obstacle(int id,String name ,int damage, int health,int award) {
        this.id = id;
        this.name=name;
        this.damage = damage;
        this.health = health;
        this.orgHealth=health;
        this.award=award;
    }

    public int getOrgHealth() {
        return orgHealth;
    }

    public void setOrgHealth(int orgHealth) {
        this.orgHealth = orgHealth;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {

        return health;
    }

    public void setHealth(int health) {
        if(health<0){
            health=0;
        }
        this.health = health;
    }
}
