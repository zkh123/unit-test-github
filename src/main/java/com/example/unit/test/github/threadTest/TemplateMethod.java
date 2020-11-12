package com.example.unit.test.github.threadTest;

public class TemplateMethod {

    /**
     * 由于父类的print方法被关键字final修饰了  子类不能对其进行重写
     * @param message
     */
    public final void print(String message){
        System.out.println("########################");
        wrapPrint(message);
        System.out.println("########################");
    }

    /**
     * 子类可以重写父类的方法wrapPrint
     * @param message
     */
    protected void wrapPrint(String message){

    }


    public static void main(String[] args) {
        TemplateMethod t1 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("*"+message+"*");
            }

        };
        t1.print("Hello Thread");

        TemplateMethod t2 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+"+message+"+");
            }
        };
        t2.print("Hello Thread");
    }

}
