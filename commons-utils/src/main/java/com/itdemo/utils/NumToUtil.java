package com.itdemo.utils;

import com.domain.Student;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 随机输入数字转化为人名币单位
 */
public class NumToUtil {



    public static void main(String[] args) {
//        System.out.println(numToMoney2(12305678.89));
//        Map map = new ConcurrentHashMap(10);
//
//        map.put("aaa","bbb");
//        System.out.println(map.get("aaa"));
//        map.put("aaa","ccc");
//        System.out.println(map.get("aaa"));
//
//        System.out.println(map.size());
//        System.out.println("aaaa");
//
//        ArrayList arrayList =new ArrayList();
//        arrayList.add("aaa1");
//        arrayList.add("aaa2");
//        arrayList.add("aaa3");
//        arrayList.add("aaa4");
//        arrayList.add("aaa5");
//        arrayList.add("aaa6");
//        arrayList.add("aaa7");
//        arrayList.add("aaa8");
//        arrayList.add("aaa9");
//        arrayList.add("aaa10");
//        arrayList.add("aaa11");
//        arrayList.get(2);
//        arrayList.remove(4);
//        arrayList.remove("aaa3");
//
//        LinkedList linkedList = new LinkedList();
//        linkedList.add("aaa1");
//        linkedList.add(0,"bbb");
//        linkedList.add("ccc");
//        linkedList.get(1);


        HashMap hashMap = new HashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();



        HashSet<String> set = new HashSet();
        set.add("aaa1");
        set.add("bbb");
        set.add("aaa1");
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println("================");
        HashSet<Student> students = new HashSet<Student>();
        students.add(new Student(1,"aaa"));
        students.add(new Student(2,"bbb"));
        students.add(new Student(1,"aaa"));
        for (Student student : students) {
            System.out.println(student);
        }


        LinkedHashSet linkedHashSet = new LinkedHashSet();




    }

    private static String[] str1 = new String[]{"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};

    private static String[] str2 = new String[]{"十","百","千","万"}; // ,"亿"


    //2.0
    public static String numToMoney2(double num) {
        String result = "";
        long bigNum = (long)num;
        long smallNum = Math.round((num - bigNum)*100);

        String bigNumStr = String.valueOf(bigNum);
        String smallNumStr = smallNum + "";

        char[] chars = bigNumStr.toCharArray();

        int length = chars.length;
        // 698023  6十9万8千02十3
        for (int i = 0; i < chars.length -1; i++) {
            int n = chars[i] -48;


            if (i != length -1 && n != 0) {
                if (length - i > 5 ) {
                    result += str1[n] + str2[length - i- 6];
                } else {
                    result += str1[n] + str2[length - i- 2];
                }
            } else {
                if (length - i == 5) {
                    result += str2[3];
                } else {
                    result += str1[n];
                }
            }
        }



        return result;
    }



    // 1.0
    public static String numToMoney1(double num) {

        String result = null;

//        double bigNum = Math.floor(num);
        long bigNum = (long)num;
        long smallNum = Math.round((num - bigNum)*100);

        String bigNumStr = String.valueOf(bigNum);
        String smallNumStr = smallNum + "";

        char[] chars = bigNumStr.toCharArray();

        for (int i = chars.length-1; i >= 0; i--) {
            int n = chars[i] - 48;

            // 0 和最后一位不需要添加单位
            if (i != chars.length - 1 && n !=0) {

                result +=  str2[chars.length - i -2] + str1[n];

            } else {
                 result = str1[n];
            }

        }

        StringBuffer stringBuffer = new StringBuffer(result);
        String string = stringBuffer.reverse().toString();

        return string;

    }





}
