
import java.util.Random;
public class Snake extends Obstacle {
private  static Random rand=new Random();


    public Snake() {
        super(4, "Snake", rand.nextInt(4)+3, 12, 0);

    }


}