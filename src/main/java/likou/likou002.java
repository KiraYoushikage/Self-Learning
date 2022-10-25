package likou;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class likou002 {
    @Test
    public void test(){
        int k=5;
        System.out.println(getKthMagicNumber(k));
        Boolean test=null;
        System.out.println("dasd"+test+"???");

    }
    public int getKthMagicNumber(int k) {
        if (k==1)return 1;
        int factors[]={3,5,7};
        Set<Long> set=new HashSet<>();
        PriorityQueue<Long> priorityQueue=new PriorityQueue<>();
        priorityQueue.add(1L);
        priorityQueue.add(3L);
        priorityQueue.add(5L);
        priorityQueue.add(7L);
        set.add(3L);
        set.add(5L);
        set.add(7L);
        long target=-1L;
        for (int i = 0; i <k ; i++) {
            long ugly=priorityQueue.poll();
            for (int j = 0; j <factors.length ; j++) {
                long res=factors[j]*ugly;
                if (set.add(res)){
                    priorityQueue.add(res);
                }
            }
            target=ugly;
        }
        return (int)target;
    }
}
