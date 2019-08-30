package com.javabox.jar;

import lombok.Data;

import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarFile;

@Data
public class Jar {
    URL fileUrl;
    JarURLConnection jarURLConnection;
    JarFile jarFile;
    Enumeration enumeration;
    ClassLoader classLoader;
}
