package com.javabox.jar;
import com.javabox.exception.RegistryException;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 加载jar
 */
public class LoadedNetWorkJar implements Loaded<JarBean>{

    /**
     * load jar
     * @param fileUrl
     * @return
     * @throws Exception
     */
    @Override
    public JarBean loadNetWorkJar(String fileUrl) throws RegistryException {
        JarBean jarBean = new JarBean();
        try {
            URL url = new URL("jar:"+fileUrl+"!/");
            JarURLConnection jarURLConnection = null;
            jarURLConnection = (JarURLConnection) url.openConnection();
            JarFile jarFile = jarURLConnection.getJarFile();
            Enumeration enumeration=jarFile.entries();
            URLClassLoader myClassLoader = new URLClassLoader( new URL[] { url } );
            jarBean.setClassLoader(myClassLoader);
            jarBean.setEnumeration(enumeration);
            jarBean.setFileUrl(url);
            jarBean.setJarURLConnection(jarURLConnection);
        } catch (IOException e) {
            throw new RegistryException(e.getMessage());
        }
        return jarBean;
    }
    @Override
    public JarBean loadlocalJar(String fileUrl) throws RegistryException {
        return null;
    }

    @Override
    public void close(JarBean jarBean) {
        try {
            jarBean.getJarFile().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
