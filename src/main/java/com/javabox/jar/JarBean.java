package com.javabox.jar;

import lombok.Data;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@Data
public class JarBean {
    URL fileUrl;
    JarURLConnection jarURLConnection;
    JarFile jarFile;
    Enumeration enumeration;
    ClassLoader classLoader;

    /**
     * get class maps
     * @return
     */
    public Map<String, Object> getJarAllClass() {
        Map<String, Object> classMap = new HashMap<>();
        while (enumeration.hasMoreElements()) {
            JarEntry jarEntry = (JarEntry) enumeration.nextElement();
            String name = jarEntry.getName();
            if (name.endsWith(".class")) {
                String value = name.replace("/", ".");
                classMap.put(name, value.substring(0, value.lastIndexOf(".")));
            }
        }
        return classMap;
    }
}
