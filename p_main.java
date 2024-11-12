import java.util.concurrent.Semaphore;
import java.util.*;
class p_main{
static Semaphore mutex= new Semaphore(1);
static Semaphore wrt= new Semaphore(1);
static String message="Hello";        
static int readcnt=0;
static Scanner sc= new Scanner(System.in);
public  static class Read implements Runnable{

    public void run(){
    try{
        mutex.acquire();
        readcnt++;
        if(readcnt==1){
            wrt.acquire();
        }
        mutex.release();
        System.out.println("Thread "+Thread.currentThread().getName()+" is reading "+ message);
        Thread.sleep(1500);
        System.out.println("Thread "+Thread.currentThread().getName()+" Reading is completed! ");
        mutex.acquire();
        readcnt--;
        if(readcnt==0){
            wrt.release();
        }
        mutex.release();
    }
    catch(InterruptedException e){
        System.out.println(e.getMessage());

    }
    }
}
public static class Write implements Runnable{
    
    public void run(){
    try{
        wrt.acquire();
        message="Good Morning";
        System.out.println("Thread "+Thread.currentThread().getName()+" is Writing "+message);
        Thread.sleep(1500);
        System.out.println("Thread "+Thread.currentThread().getName()+" is completed writing! ");
        wrt.release();
    }
    catch(InterruptedException e)
    {
        System.out.println(e.getMessage());
    }
    }

}
public static void main(String[] args){

    Read reader= new Read();
    Write writer= new Write();
    Thread r1=new Thread(reader);
    r1.setName("Reader1");
    Thread r2=new Thread(reader);
    r2.setName("Reader2");
    Thread r3=new Thread(reader);
    r3.setName("Reader3");
    Thread w1=new Thread(writer);
    w1.setName("Writer1");
    Thread w2=new Thread(writer);
    w2.setName("Writer2");
    Thread w3= new Thread(writer);
    w3.setName("Writer3");

    w1.start();
    r1.start();
    w2.start();
    r2.start();
    w3.start();
    r3.start();
}
}