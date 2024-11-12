import java.util.*;
public class p_pri_sjf{
    public static class Process{
        int id,at,ct,bt,wt,tat,pri;
        Process(int id,int at,int bt,int pri){
            this.id=id;
            this.at=at;
            this.bt=bt;
            this.pri=pri;

        }
    }

    public static void pri(Process[] prs){
        int n= prs.length;
        int comp=0,curr=0;
        boolean[] isComp= new boolean[n];
        while(comp<n)
        {
            int high_pri=Integer.MAX_VALUE,idx=-1;
            for(int i=0;i<n;i++){
                if(!isComp[i] && prs[i].at<=curr && prs[i].pri<high_pri){
                    high_pri= prs[i].pri;
                    idx=i;
                }
            }
                if(idx!=-1){
                    Process p=prs[idx];
                    curr =Math.max(curr,p.at) + p.bt;
                    p.ct=curr;
                    p.tat=p.ct-p.at;
                    p.wt=p.tat-p.bt;
                    isComp[idx]=true;
                    comp++;
                }
                else{
                    curr++;
                }
        
            
        }
    }

    public static void sjf(Process[] prs){
        int n= prs.length;
        int comp=0,curr=0;
        boolean[] isComp= new boolean[n];
        while(comp<n)
        {
            int min_bt=Integer.MAX_VALUE,idx=-1;
            for(int i=0;i<n;i++){
                if(!isComp[i] && prs[i].at<=curr && prs[i].bt<min_bt){
                    min_bt= prs[i].bt;
                    idx=i;
                }
            }
                if(idx!=-1){
                    Process p=prs[idx];
                    curr =Math.max(curr,p.at) + p.bt;
                    p.ct=curr;
                    p.tat=p.ct-p.at;
                    p.wt=p.tat-p.bt;
                    isComp[idx]=true;
                    comp++;
                }
                else{
                    curr++;
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
            System.out.println("1.Priority");
            System.out.println("2.SJF");
            System.out.println("3.Exit");
            System.out.print("Enter your choice: ");
            ch= sc.nextInt();
            switch(ch){
    
                case 1:
                for (int i = 0; i < n; i++) {
                    System.out.print("Enter arrival time for process " + (i + 1) + ": ");
                    int arrivalTime = sc.nextInt();
                    System.out.print("Enter burst time for process " + (i + 1) + ": ");
                    int burstTime = sc.nextInt();
                    System.out.print("Enter priority for process " + (i + 1) + ": ");
                    int pri = sc.nextInt();
                    prs[i] = new Process(i + 1, arrivalTime, burstTime, pri);
                }
                pri(prs);
                display(prs);
                break;
                case 2:
                for (int i = 0; i < n; i++) {
                    System.out.print("Enter arrival time for process " + (i + 1) + ": ");
                    int arrivalTime = sc.nextInt();
                    System.out.print("Enter burst time for process " + (i + 1) + ": ");
                    int burstTime = sc.nextInt();
                    prs[i] = new Process(i + 1, arrivalTime, burstTime, 0);
                }
                sjf(prs);
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