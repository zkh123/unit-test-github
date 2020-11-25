package com.example.unit.test.github.threadTest.singletonTest;

// final 不能被继承
public final class Singleton6 {

    // 加载的时候 不会马上被实例化
    private byte[] bytes = new byte[1024];

    private Singleton6(){
    }

    private static class Holder{
        private static Singleton6 singleton6 = new Singleton6();
    }

    public static Singleton6 getSingleton(){
        return Holder.singleton6;
    }

    public static void main(String[] args) {
        Singleton6.getSingleton();
    }
}
