package com.dy.error.collection;

public class E1 {

    public static int i = 0;

    public static void main(String[] args) {


        String s = "hello";
        String t = "hello";
        char[] c = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(c.length);
        System.out.println(s.length());
        System.out.println("s" + s.hashCode());
        System.out.println("c" + c.hashCode());
        System.out.println("t" + t.hashCode());
        //equal源码先判断s==t，因为两者指向同一字符串常量
        System.out.println(s.equals(t));
        //false，因为t和c类型不同
        System.out.println(t.equals(c));
        System.out.println(s == t);
        System.out.println(t.equals(new String("hello")));


        myprint();
        String a0 = "hello2";
        String b0 = "hello" + 2;
        System.out.println((a0 == b0));


        myprint();
        String a1 = "hello2";
        String b1 = "hello";
        String c1 = b1 + 2;
        System.out.println((a1 == c1));


        myprint();
        String a2 = "hello2";
        final String b2 = "hello";
        String c2 = b2 + 2;
        System.out.println((a2 == c2));


        myprint();
        String a3 = "hello2";
        final String b3 = getHello();
        String c3 = b3 + 2;
        System.out.println((a3 == c3));


        myprint();
        String a4 = "hello";
        String b4 = new String("hello");
        String c4 = new String("hello");
        String d4 = b4.intern();

        System.out.println(a4 == b4);
        System.out.println(b4 == c4);
        System.out.println(b4 == d4);
        System.out.println(a4 == d4);


        myprint();
        E1 e = new E1();
        e.f1();
        e.f2();


        //????????????????????????????????????????????????????????
        myprint();
        String s1 = new StringBuilder("go")
                .append("od").toString();
        String s11 = s1.intern();
        System.out.println("s11->" + s11.hashCode());
        System.out.println("s1->" + s1.hashCode());

        System.out.println(s11 == s1);
        String s2 = new StringBuilder("ja")
                .append("va").toString();
        String s22 = s2.intern();
        System.out.println("s22->" + s22.hashCode());
        System.out.println("s2->" + s2.hashCode());
        System.out.println(s22 == s2);
        //????????????????????????????????????????????????????????


        test2String();
        test1String();



    }

    public static void myprint() {
        System.out.println("===================" + (i++) + "=================");
    }

    public static String getHello() {
        return "hello";
    }


    public void f1() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append("hello");
        }
    }


    public void f2() {
        String string = "";
        for (int i = 0; i < 10000; i++) {
            string += "hello";
        }
    }

    public static void test1String() {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            String s = "I" + "love" + "java";
        }
        long over = System.currentTimeMillis();
        System.out.println("字符串直接相加操作：" + (over - begin) + "毫秒");
    }

    public static void test2String() {
        String s1 = "I";
        String s2 = "love";
        String s3 = "java";
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            String s = s1 + s2 + s3;
        }
        long over = System.currentTimeMillis();
        System.out.println("字符串间接相加操作：" + (over - begin) + "毫秒");
    }
}
