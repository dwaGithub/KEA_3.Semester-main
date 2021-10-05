import java.util.Random;

public class Octopus extends Animal {

    final Random random = new Random();
    static final int min = 1;
    static final int max = 10;

    public static final GameOfOctopus gameThread = new GameOfOctopus();


    public void makeDoActivity() {
        while(true){
            try {
                String activity = selectActivity();
                System.out.println(activity);
                if(activity.equalsIgnoreCase("mate")){
                    gameThread.start();
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String move(){
        return "Swish Swosh";
    }

    public String selectActivity(){

        String activity;
        int activityNumber = random.nextInt(max) + min;

        switch (activityNumber){
            case 1:
                activity = "jump";
                break;

            case 2:
                activity = "run";
                break;

            case 3:
                activity = "sleep";
                break;

            case 4:
                activity = "hide";
                break;

            case 5, 6:
                activity = "mate";
                break;
            default: activity = move();
        }

        return activity;
    }

}
