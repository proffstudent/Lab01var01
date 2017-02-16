package su.doma_dachi.inno.txt.main.utils;

/**
 * Created by User on 13.02.2017.
 */
public class ThreadForRecource implements Runnable {
    String recource = new String();
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    ThreadForRecource(String recource){
        this.recource = recource;
    }
    @Override
    public void run() {
        System.out.println("start thread"+ Thread.currentThread().getName());
        Parser.choiceResource(recource);
    }
}
