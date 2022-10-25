package likou;

import org.junit.jupiter.api.Test;

public class likou003 {

    @Test
    public void test(){
        String s1 = "waterbottle", s2 = "erbottlewat";
        System.out.println(isFlipedString(s1,s2));
    }
//    public boolean isFlipedString(String s1, String s2) {
//        if ((s1==null&&s2!=null)||(s1!=null&&s2==null))return false;
//        assert s1 != null;
//        if (s1.equals(s2)) return true;
//        if (s1.length()!=s2.length())return false;
//
//        int len=0,l=0,r=0;
//        while(l<s1.length()&&r<s2.length()){
//            if(s1.charAt(l)==s2.charAt(r)){
//                len++;
//                r++;
//                l++;
//            }else{
//                l=0;
//                r++;
//                len=0;
//            }
//            if(r==s1.length()){
//             String a=s1.substring(len);
//             String b=s2.substring(0,s2.length()-len);
//             return a.equals(b);
//            }
//        }
//        return true;
//    }
    public boolean isFlipedString(String s1, String s2) {
        if ((s1==null&&s2!=null)||(s1!=null&&s2==null))return false;
        assert s1 != null;
        if (s1.equals(s2)) return true;
        if (s1.length()!=s2.length())return false;
        s1+=s1;
        return s1.contains(s2);
    }
}
