package likou;

import component.ListNode;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class likou004 {

    @Test
    public void test() {
        int nums[] = {10, 20, 30, 5, 10, 50};
        System.out.println(maxAscendingSum(nums));
    }

    public int maxAscendingSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int last = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                count = nums[i];
                max = nums[i];
                last = i;
                continue;
            }
            if (nums[i] > nums[last]) {
                count += nums[i];
                last = i;
                max = Math.max(max, count);
                continue;
            }
            count = nums[i];
            last = i;
            max = Math.max(max, count);
        }
        return max;
    }

    @Test
    public void test2() {
        String urlString = "D:/githome/fwk_tool/framework server/ESM/config/agent-config.txt";
        System.out.println(getUrlContent(urlString));
    }

    private static String getUrlContent(String urlString) {
        InputStream in = null;
        StringBuffer stringBuffer = null;
        try {
            URL url = new URL(urlString); // Create the URL
            URLConnection uc = url.openConnection();
            System.out.println("dsaaaaaaaaaaaaa");
            uc.setDefaultUseCaches(false);
            uc.setUseCaches(false);
            uc.setRequestProperty("Cache-Control", "max-age=0,no-cache");
            uc.setRequestProperty("Pragma", "no-cache");

            in = uc.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(in));
            stringBuffer = new StringBuffer();
            System.out.println("dasdaasd");
            for (String s1 = null; (s1 = bufferedReader.readLine()) != null; ) {
                stringBuffer.append(s1);
                stringBuffer.append('\n');
            }
        }
        // On exceptions, print error message and usage message.
        catch (Exception e) {
//            throw new Exception(e, "Error getting Url Content "
//                    + urlString);
            System.out.println("读取不了");
        } finally { // Always close the streams, no matter what.
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                }
            }
        }
        return stringBuffer.toString();
    }

    @Test
    public void test3() {
        String s1 = "bank", s2 = "kanb";
        System.out.println(areAlmostEqual(s1, s2));
    }

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        int nums[] = new int[26];
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            nums[(s1.charAt(i) - 'a')]++;
            nums[(s2.charAt(i) - 'a')]--;
            if (s1.charAt(i) != s2.charAt(i)) count++;
            if (count > 2) return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) return false;
        }
        if (count != 2) return false;
        return true;
    }

    @Test
    public void test4() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = reverse3(node1);
//        while (head != null) {
//            System.out.println(head);
//            head = head.next;
//        }
        System.out.println(head);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = reverse3(node1);
//        while (head != null) {
//            System.out.println(head);
//            head = head.next;
//        }
        System.out.println(head);
    }

    public static ListNode reverse3(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head.next;
        ListNode right = head.next;
//        head.next=null;
        while (right != null) {
            right = right.next;
            left.next = head;

            if (right != null) {
                head = right;
                right = right.next;
                head.next = left;
            } else {
                head = left;
            }
            left = right;
        }
        return head;
    }

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        boolean sw = false;
        int count = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!sw) count++;
                sw = true;
                head = head.next;
                continue;
            }
            sw = false;
            head = head.next;
        }
        return count;
    }

    @Test
    public void test5() {
        int arr[] = {1, 2, 0, 3};
        System.out.println(maxChunksToSorted(arr));
        List<Integer> list = null;
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public int maxChunksToSorted(int[] arr) {
        if (arr.length == 1) return 1;
        int count = 1;
        int max = arr[0];
        int min = Integer.MAX_VALUE;
        int len = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                count++;
                max = arr[i];
                len++;
            } else if (arr[i] < min) {
                count -= (len - 1);
                len = 1;
                min = arr[i];
            } else {

            }
        }
        return count;
    }

    //    public ListNode reverse(ListNode head){
//        if(head==null)return head;
//        Stack<ListNode> stack=new Stack<>();
//        while(head!=null){
//            stack.push(head);
//            head=head.next;
//        }
//        ListNode temp=stack.pop();
//        head=temp;
//        while(!stack.empty()){
//            ListNode tt=stack.pop();
//            temp.next=tt;
//            temp=tt;
//        }
//        temp.next=null;
//        return head;
//    }
    public ListNode reverse(ListNode head) {
        ListNode guard = new ListNode();
        head = reverse2(head, guard);
        head.next = null;
        return guard.next;
    }

    public ListNode reverse2(ListNode next, ListNode guard) {
        if (next.next == null) {
            guard.next = next;
            return next;
        }
        reverse2(next.next, guard).next = next;
        return next;
    }

    @Test
    public void test7(){
       String a= "zzc";
        System.out.println(distinctSubseqII(a));
    }
    public int distinctSubseqII(String s) {
        Set<String> set=new HashSet<>();
        recurse(s,-1,"",set);
        System.out.println(set);
        return (set.size()%(10*9 + 7));
    }
    public void recurse(String s,int index,String subString,Set<String> set){
        if (index>=s.length())return;
        for (int i = index+1; i <s.length() ; i++) {
            char chaz=s.charAt(i);
            if (set.contains(subString+chaz))return;
            set.add(subString+chaz);
            recurse(s,i,subString+chaz,set);
        }
    }

    @Test
    public void test8(){
        int nums[]={3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(nums));
    }

    public int totalFruit(int[] fruits) {
        if (fruits.length<=2)return fruits.length;
        Map<Integer,Integer> map=Arrays.stream(fruits).boxed().collect(Collectors.toMap(o->o,value->1, Integer::sum));
        int cradle1=-1;
        int cradle2=-1;
        int max=Integer.MIN_VALUE;
        for (int i = 1; i < fruits.length; i++) {
            cradle1=fruits[i-1];
            cradle2=fruits[i];
            if (cradle1==cradle2)max=Math.max(map.getOrDefault(cradle1,0),max);
            else max=Math.max(map.getOrDefault(cradle1,0)+map.getOrDefault(cradle2,0),max);
            int temp=map.getOrDefault(cradle1,0);
            map.put(cradle1,temp-1);
        }
        return max;
    }
    public int totalFruit1(int[] fruits) {
        if (fruits.length<=2)return fruits.length;
        Map<Integer,Integer> map=Arrays.stream(fruits).boxed().collect(Collectors.toMap(o->o,value->1, Integer::sum));
        int cradle1=-1;
        int cradle2=-1;
        int max=Integer.MIN_VALUE;
        for (int i = 1; i < fruits.length; i++) {
            cradle1=fruits[i-1];
            cradle2=fruits[i];
            if (cradle1==cradle2)max=Math.max(map.getOrDefault(cradle1,0),max);
            else max=Math.max(map.getOrDefault(cradle1,0)+map.getOrDefault(cradle2,0),max);
            int temp=map.getOrDefault(cradle1,0);
            map.put(cradle1,temp-1);
        }
        return max;
    }

}
