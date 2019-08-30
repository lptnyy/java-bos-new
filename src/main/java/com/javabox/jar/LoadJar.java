package com.javabox.jar;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarFile;

/**
 * 加载jar
 */
public class LoadJar {

    /**
     * load jar
     * @param fileUrl
     * @return
     * @throws Exception
     */
    public Jar loadJar(String fileUrl) throws Exception {
        Jar jar = new Jar();
        URL url = new URL("jar:"+fileUrl+"!/");
        JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
        JarFile jarFile = jarURLConnection.getJarFile();
        jar.setEnumeration(jarFile.entries());
        jar.setJarURLConnection(jarURLConnection);
        jar.setFileUrl(url);
        jar.setJarFile(jarFile);
        URLClassLoader myClassLoader = new URLClassLoader( new URL[] { url } );
        jar.setClassLoader(myClassLoader);
        return jar;
    }
}
