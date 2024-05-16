import java.util.Random;

public class Snake extends Obstacle{
private int damage;

Random rand=new Random();
    public Snake(){
        super(4,"Snake",0, 12);
        this.damage= rand.nextInt(4)+3;
        setDamage(damage);
    }

    public int damage(){
        return damage;
    }

}
