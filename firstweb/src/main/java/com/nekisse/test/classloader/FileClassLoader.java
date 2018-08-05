package com.nekisse.test.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class FileClassLoader extends ClassLoader {

    private String root;

    /*
    @param rootDir 클래스를 읽어올  루트 디렉토리
    */
    public FileClassLoader(String rootDir) throws FileNotFoundException {

        super(FileClassLoader.class.getClassLoader());

        File f = new File(rootDir);
        if (f.isDirectory())
            root = rootDir;
        else
            throw new FileNotFoundException(rootDir + "isn't a directory");
    }


    @Override
    protected URL findResource(String name) {
        return super.findResource(name);
    }

    /*
        @param name 검색할 클래스 이름
        */
    public Class findClass(String name) throws ClassNotFoundException {
        try {
            String path = root + File.separatorChar +
                    name.replace('.', File.separatorChar) + ".class";

            FileInputStream file = new FileInputStream(path);
            byte[] classByte = new byte[file.available()];
            file.read(classByte);

            return defineClass(name, classByte, 0, classByte.length);
        } catch (IOException ex) {
            throw new ClassNotFoundException();
        }

    }


}
