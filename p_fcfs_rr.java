import java.util.*;
public class p_fcfs_rr{
    public static class Process{
        int id,at,ct,bt,wt,tat;
        Process(int id,int at,int bt){
            this.id=id;
            this.at=at;
            this.bt=bt;

        }
    }
    public static void fcfs(Process[] p){
        int curr=0;
        for(int i=0;i<p.length;i++){
            

            if(curr<p[i].at)
                curr=p[i].at;
            
            curr= curr+p[i].bt;
            p[i].ct=curr;
            p[i].tat=p[i].ct-p[i].at;
            p[i].wt=p[i].tat-p[i].bt;
        }
    }

    public static void rr(Process[] p,int tq){
        int n= p.length;
        int[] r_bt= new int[n];
        for(int i=0;i<n;i++){
            r_bt[i]= p[i].bt;
        }

        int curr=0,comp=0;
        while (comp<n){
            for(int i=0;i<n;i++){
                if(r_bt[i]>0){
                    if(r_bt[i]>tq){
                        curr +=tq;
                        r_bt[i]-=tq;
                    }
                    else{
                        curr += r_bt[i];
                        p[i].ct=curr;
                        p[i].tat=p[i].ct-p[i].at;
                        p[i].wt=p[i].tat-p[i].bt;
                        r_bt[i]=0;
                        comp++;
                    }
                }
            }
        }
    }
public static void display(Process[] p){
    System.out.println("\nProcess ID | Arrival Time | Burst Time | Completion Time | Turnaround Time | Waiting Time");
    for(int i=0;i<p.length;i++){
        Process p1=p[i];
        System.out.printf("%10d | %12d | %10d | %15d | %14d | %11d\n",p1.id,p1.at,p1.bt,p1.ct,p1.tat,p1.wt);
    }
}
public static void main(String[] args) {

    Scanner sc= new Scanner(System.in);

    System.out.println("Enter the number of processes: ");
    int n=sc.nextInt();
    Process[] prs= new Process[n];
    int ch;
    do{
        System.out.println("\n-------MENU------");
        System.out.println("1.FCFS");
        System.out.println("2.Round Robin");
        System.out.println("3.Exit");
        System.out.print("Enter your choice: ");
        ch= sc.nextInt();
        switch(ch){

            case 1:
            for(int i=0;i<n;i++){
            System.out.print("Enter arrival time for process " + (i + 1) + ": ");
            int at = sc.nextInt();
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            int bt = sc.nextInt(); 
            prs[i]= new Process(i+1,at,bt);
            }
            fcfs(prs);
            display(prs);
            break;
            case 2:
            for(int i=0;i<n;i++){
                System.out.print("Enter burst time for process " + (i + 1) + ": ");
                int bt = sc.nextInt(); 
                prs[i]= new Process(i+1,0,bt);
                }
                System.out.print("Enter Time Quantum: ");
                int tq = sc.nextInt();
                rr(prs,tq);
                display(prs);
                break;
            case 3: 
            System.exit(0); 
            break;
            default:
            System.out.println("Invalid choice");
            break;    

        }


    }while(ch!=3);
    sc.close();

}

    
} 