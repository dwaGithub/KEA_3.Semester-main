public class GameOfOctopus extends Thread{

    @Override
    public void run(){
        System.out.println("Run has been called");
        Octopus otto = new Octopus();
        otto.makeDoActivity();

        /*Octopus otto = new Octopus();
        System.out.println(otto.makeDoActivity(1));
        System.out.println(otto.makeDoActivity(2));
        System.out.println(otto.makeDoActivity(3));
        System.out.println(otto.makeDoActivity(4));
        System.out.println(otto.makeDoActivity(5));
        System.out.println(otto.makeDoActivity(6));
        System.out.println(otto.makeDoActivity(7));

         */
    }


}
