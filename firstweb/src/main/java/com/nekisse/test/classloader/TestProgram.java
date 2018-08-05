package com.nekisse.test.classloader;


public class TestProgram {

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("[Usage] java TestProgram <directory>");
            System.exit(1);
        }

        FileClassLoader loader = new FileClassLoader(args[0]);

        Class klass = loader.loadClass("com.nekisse.test.FirstHello");
        Object obj = klass.newInstance();

        System.out.println(obj.getClass().getName() );
    }
}
