package likou;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class likou001 {

    @Test
    public void test(){
        String s1 = "abc", s2 = "bca";
//        System.out.println(CheckPermutation(s1,s2));
        List<Integer> list=null;
        for (Integer a: list) {
            System.out.println(a);
        }

    }

    public boolean CheckPermutation(String s1, String s2) {
        if(s1==null&&s2==null)return true;
        if((s1==null&&s2!=null)||(s1!=null&&s2==null))return false;
        if(s1.length()!=s2.length())return false;
        int []table=new int[26];
        for (int i = 0; i <s1.length() ; i++) {
            char target1=s1.charAt(i);
            table[target1-'a']++;
            char target2=s2.charAt(i);
            table[target2-'a']--;
        }
        for (int i = 0; i <table.length ; i++) {
            if (table[i]!=0)return false;
        }
        return true;
    }
}
