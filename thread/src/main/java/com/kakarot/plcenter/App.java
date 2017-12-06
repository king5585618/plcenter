package com.kakarot.plcenter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Hello world!
 *
 */
public class App 
{
    private int i =0;

    private final static DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    public static void main( String[] args )
    {
//        System.out.println(dateFormat.format(Calendar.getInstance().getTime()));
        String a = "15054526517589";
        Long b = Long.parseLong(a.substring(0,a.length()-1));
        System.out.println(b);
        System.out.println(Long.toHexString(b));
        System.out.println(a.charAt(a.length()-1));
        App app = new App();
        System.out.println(app.i);
    }
}
