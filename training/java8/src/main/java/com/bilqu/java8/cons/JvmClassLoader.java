package com.bilqu.java8.cons;

public class JvmClassLoader {

    public static void main(String[] a)  throws ClassNotFoundException{

        //An application or system class loader loads our own files in the classpath.
        System.out.println("Classloaded for JvmClassLoader : "+JvmClassLoader.class.getClassLoader());

        //Extension class loaders load classes that are an extension of the standard core Java classes.
        System.out.println("Classloaded for Logging : "+ java.util.logging.Logger.class.getClassLoader());

        //A bootstrap or primordial class loader is the parent of all the others.
        System.out.println("Classloaded for Arraylist : "+ java.util.ArrayList.class.getClassLoader());
        System.out.println("Classloaded for System : "+ System.class.getClassLoader());



    }
}
