import java.util.Random;

public class BattleLoc extends Location {
private Obstacle obstacle;
private String award;
private int maxObstacle;

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
        if(selectCase.equals("F")){
            System.out.println("Savaş işlemleri");
        }


        return true;
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
