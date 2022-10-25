package likou;

import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;
import java.util.*;

public class likou005 {

    @Test
    public void test0() {
        int nums[] = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(totalFruit(nums));
    }

    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2) return fruits.length;
        int max = 2;
        int cradle1 = fruits[0];
        int cradle2 = fruits[1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(fruits[0]);
        queue.add(fruits[1]);
        for (int i = 2; i < fruits.length; i++) {
            if (cradle1 == cradle2) {
                cradle2 = fruits[i];
                queue.add(fruits[i]);
                max = Math.max(queue.size(), max);
                continue;
            }
            if (cradle1 != fruits[i] && cradle2 != fruits[i]) {
                Deque<Integer> deque = new ArrayDeque<>();
                while (queue.size() != 0 && queue.getLast() == cradle2) {
                    deque.add(queue.pollLast());
                }
                queue = deque;
                cradle1 = cradle2;
                cradle2 = fruits[i];
                queue.add(fruits[i]);
                max = Math.max(queue.size(), max);
                continue;
            }
            if (cradle1 == fruits[i] && cradle2 != fruits[i]) {
                cradle1 = cradle2;
                cradle2 = fruits[i];
                queue.add(fruits[i]);
                max = Math.max(queue.size(), max);
                continue;
            }
            queue.add(fruits[i]);
            max = Math.max(queue.size(), max);
        }
        return max;
    }

    @Test
    public void test1() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);
        System.out.println(deque.getFirst());
        System.out.println(deque);
        System.out.println(deque.getLast());
        deque.addFirst(0);
        deque.addLast(6);
        System.out.println(deque);
        System.out.println(deque.element());
        System.out.println(deque);
        System.out.println(deque.pollFirst());
        System.out.println(deque);
    }

    @Test
    public void test3() {
        String haystack = "leetcode", needle = "leeto";
        System.out.println(strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        int index = -1;
        int pointerHaystack = 0;
        int pointerNeedle = 0;
        while (pointerHaystack < haystack.length() && pointerNeedle < needle.length()) {
            if (haystack.charAt(pointerHaystack) == needle.charAt(pointerNeedle) && pointerNeedle == 0) {
                index = pointerHaystack;
                pointerNeedle++;
                pointerHaystack++;
            } else if (haystack.charAt(pointerHaystack) == needle.charAt(pointerNeedle)) {
                pointerNeedle++;
                pointerHaystack++;
            } else {
                pointerNeedle = 0;
                if (index != -1) {
                    pointerHaystack = index + 1;
                    index = -1;
                } else {
                    pointerHaystack++;
                }
            }
        }
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("etst");

        if (pointerNeedle == needle.length()) return index;
        return -1;
    }

    @Test
    public void test2() {
//        int students[] = {1,1,1,0,0,1}, sandwiches[] = {1,0,0,0,1,1};
        int students[] = {1, 1, 0, 0}, sandwiches[] = {0, 1, 0, 1};
        System.out.println(countStudents(students, sandwiches));
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int indexS = 0;
        int indexStudents = 0;
        int count = 0;
        int len = students.length;
        Set<Integer> set = new HashSet<>();
        while (count < len) {
            if (students[indexStudents] == sandwiches[indexS]) {
                len--;
                indexS++;
                set.add(indexStudents);
                count = 0;
                while (set.size() != students.length && set.contains(indexStudents = ((indexStudents + 1) % students.length))) {
                }
            } else {
                count++;
                while (set.size() != students.length && set.contains(indexStudents = ((indexStudents + 1) % students.length))) {
                }
            }
        }
        return count;
    }

    @Test
    public void test5() {
        int n = 2;
        int k = 2;
        System.out.println(kthGrammar(n, k));
//        BitSet bitSet=new BitSet();
//        bitSet.set(0,false);
//        bitSet.set(1,false);
//        bitSet.set(2,true);
//        System.out.println(bitSet.get(0));
//        System.out.println(bitSet.get(1));
//        System.out.println(bitSet.get(2));
//        System.out.println(bitSet);
    }

    //    public int kthGrammar(int n, int k) {
//        if (n==1)return 0;
//        StringBuilder ss=new StringBuilder();
//        ss.append("0");
//        for (int i = 1; i <n-1 ; i++) {
//            StringBuilder s=new StringBuilder();
//            WeakReference<StringBuilder> weakRef = new WeakReference<>(s);
//            for (int j = 0; j <ss.length() ; j++) {
//                if (ss.charAt(j)=='0'){
//                    s.append("01");
//                }else s.append("10");
//            }
//            ss=s;
//            System.gc();
//        }
//        for (int i = 0; i <ss.length() ; i++) {
//            k-=2;
//            if (ss.charAt(i)=='0'){
//                if (k==0){
//                    return 1;
//                }else if(k<0) return 0;
//            }else{
//                if (k==0){
//                    return 0;
//                }else if (k<0)return 1;
//            }
//        }
//        return 0;
//
//    }
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        boolean isOdd = (k & 1) != 0;
        int res = kthGrammar(n - 1, isOdd ? (k / 2 + 1) : (k / 2));
        if (res == 1) {
            if (isOdd) return 1;
            return 0;
        } else {
            if (isOdd) return 0;
            return 1;
        }
    }

    @Test
    public void test4() {
        int nums[] = {1, 1, 1, 0, 6, 12};
        System.out.println(partitionDisjoint(nums));
    }

    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        int leftPoint = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftMax < nums[i]) {
                leftPoint = i;
                leftMax = nums[i];
            }
        }
        return leftPoint + 1;
    }

    @Test
    public void test6() {
        int grid[][] = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(orangesRotting(grid));

    }

    public int orangesRotting(int[][] grid) {
        int minutes=0;
        int [] dr={-1,0,1,0};
        int [] dc={0,-1,0,1};
        int goodOrange=0;
        int R=grid.length;
        int C=grid[0].length;
        Queue<int[]> queue=new ArrayDeque<>();
        Map<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if (grid[i][j]==1)goodOrange++;
                else if (grid[i][j]==2) {
                    queue.add(new int[]{i,j});
                    map.put(i*C+j,0);
                }
            }
        }
        while(!queue.isEmpty()&&goodOrange>0){
            int orange[]=queue.poll();
            for (int i = 0; i <4 ; i++) {
                int nr=orange[0]+dr[i];
                int nc=orange[1]+dc[i];
                if (nr>=0&&nr<R&&nc>=0&&nc<C&&grid[nr][nc]==1){
                    queue.add(new int[]{nr,nc});
                    grid[nr][nc]=2;
                    minutes=map.get(orange[0]*C+orange[1])+1;
                    map.put(nr*C+nc,minutes);
                    goodOrange--;
                }
            }
        }
        if (goodOrange>0)return -1;
        return minutes;
    }
}
