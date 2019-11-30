package com.bilqu.java8.cons;

public class MultipleInterfaceImpl implements Child1,Child2  {

    public static void main(String[] args) {
        MultipleInterfaceImpl impl = new MultipleInterfaceImpl();
        impl.whoIsThis();
    }

    @Override
    public void doThis() {

    }
}

@FunctionalInterface
interface Parent {

    void doThis();

    default void whoIsThis(){
        System.out.println("Printing from Interface Parent");
    }

}

interface Child1 extends  Parent{
//    default void whoIsThis(){
//        System.out.println("Printing from Interface Child1");
//    }
}


interface Child2 extends Parent{
//    default void whoIsThis(){
//        System.out.println("Printing from Interface Child2");
//    }
}