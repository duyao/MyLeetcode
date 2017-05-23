package com.dy.error.collection;

/**
 * Created by amy on 2017/4/10.
 */
public class E18 {

    private String baseName = "base";

    public E18() {
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }

    static class Son extends E18 {
        private String baseName = "sub";

        @Override
        public void callName() {
            System.out.println(baseName);
        }

        public static void main(String[] args) {
            //这里会先去执行子类构造方法init，在init中第一句是执行父类的构造方法，因此就去父类构造方法中了
            //在父类构造方法中，调用callname，这个callname是一个重载的过程，因此遵守动态单分派，执行调用者的方法，也就是new son中的son
            new Son();
        }
    }


}

