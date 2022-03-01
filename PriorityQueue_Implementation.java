/* Author shobhit_behl */
// import java.io.*;
import java.util.*;
public class PriorityQueue_Implementation {

    public static class PriorityQueue {
        private ArrayList<Integer> data;
        PriorityQueue(){
            data=new ArrayList<>();
        }
        public int size(){
            return this.data.size();
        }
        public void add(int val){
            data.add(val);
            int c=data.size()-1;
            while(c>=1&&data.get(c)<data.get((c-1)/2)){
                 int t=data.get(c);
                 data.set(c,data.get((c-1)/2));
                 data.set((c-1)/2,t);
                 c=(c-1)/2;
            }
        }
        public int remove(){
            int t=data.get(0);
            data.set(0,data.get(data.size()-1));
            data.set(data.size()-1,t);
            int remData=data.remove(data.size()-1);
            int c=0;
            while(true){
                int p1=2*c+1;
                int p2=2*c+2;
                int f=0;
                if(p1>=data.size()){
                    break;
                }else if(p2>=data.size()){
                   f=p1;
                }else{
                if(data.get(p1)<data.get(p2)){
                  f=p1;
                }else{
                    f=p2;
                }
            }
                int temp=data.get(c);
                data.set(c,data.get(f));
                data.set(f,temp);
                c=f;
            }

            return remData;
        }
        


    }
    public static void main(String[] args){
         Scanner scn=new Scanner(System.in);
         int n=scn.nextInt();
         PriorityQueue pq=new PriorityQueue();
         for(int i=0;i<n;i++){
             String[] s=scn.nextLine().split(" ");
             if(s[0].equals("Add")){
                 int j=Integer.parseInt(s[1]);
                 pq.add(j);
             }else if(s[0].equals("Remove")){
                 System.out.println(pq.remove());
             }else if(s[0].equals("Size")){
                 System.out.println(pq.size());
             }
         }
         scn.close();
    }
    }


    

