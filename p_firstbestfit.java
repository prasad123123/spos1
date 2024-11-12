import java.util.*;
public class p_firstbestfit{

    public static void firstfit(int[] m_blk, int[] p_sz){
        System.out.println("\nFirst Fit Allocation:");
        System.out.print("\nProcess | Size | Block Allocated | Remaining \n"); 
   
        for(int i=0;i<p_sz.length;i++){
            int allow_blk=-1;
            for(int j =0;j<m_blk.length;j++){
                if(m_blk[j]>=p_sz[i]){
                    allow_blk=j;
    
                    
                    break;
                }
            }
            if(allow_blk!=-1){
                System.out.printf("\n%8d | %4d | %15d | %15d \n",i+1,p_sz[i],m_blk[allow_blk],m_blk[allow_blk] -= p_sz[i]);
                m_blk[allow_blk] -= p_sz[i];
                
            }
            else{
                System.out.printf("\n%8d | %4d | %15s | %15s \n",i+1,p_sz[i],"Not Allocated","-");
            }
        }

        
        
    }
    

    public static void best(int[] m_blk, int[] p_sz){
        System.out.println("\nFirst Fit Allocation:");
        System.out.print("\nProcess | Size | Block Allocated | Remaining \n"); 
   
        for(int i=0;i<p_sz.length;i++){
            int allow_blk=-1;
            int min_space=Integer.MAX_VALUE;
            for(int j =0;j<m_blk.length;j++){
                int r_space=m_blk[j]-p_sz[i];

                if(r_space>=0 && r_space<min_space){
                    min_space=r_space;
                    allow_blk=j;
                    
                }
            }
            if(allow_blk!=-1){
                
                System.out.printf("\n%8d | %4d | %15d | %15d \n",i+1,p_sz[i],m_blk[allow_blk],m_blk[allow_blk] -= p_sz[i]);
                m_blk[allow_blk] -= p_sz[i];
            }
            else{
                System.out.printf("\n%8d | %4d | %15s | %15s \n",i+1,p_sz[i],"Not Allocated","-");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of Memory Blocks: ");
        int n_blk = sc.nextInt();
        int[] m_blk= new int[n_blk];
        System.out.println("Enter the size of each Memory Block: ");
        for(int i=0;i<n_blk;i++){
            System.out.print("Block "+(i+1)+": ");
            m_blk[i]=sc.nextInt();
        }

        System.out.println("Enter the number of processes: ");
        int n_prs = sc.nextInt();
        int[] p_sz= new int[n_prs];
        System.out.println("Enter the size of each process: ");
        for(int i=0;i<n_prs;i++){
            System.out.print("process "+(i+1)+": ");
            p_sz[i]=sc.nextInt();
        }
        int ch;

        do{
            System.out.println("\nMemory Allocation Strategies:");
            System.out.println("1. First Fit");
            System.out.println("2. Best Fit");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");
            ch= sc.nextInt();
            switch (ch) {
                case 1:
                    firstfit(m_blk.clone(), p_sz);
                    break;
                case 2:
                    best(m_blk.clone(), p_sz);
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }while(ch!=3);




    }

}