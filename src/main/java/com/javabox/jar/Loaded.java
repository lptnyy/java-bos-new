package com.javabox.jar;

import com.javabox.exception.RegistryException;

import java.util.Map;

/**
 * jar load
 */
public interface Loaded<T> {

    /**
     * load network jar
     * @param fileUrl
     * @return
     * @throws Exception
     */
    T loadNetWorkJar(String fileUrl) throws RegistryException;

    /**
     * Load local jar
     * @param fileUrl
     * @return
     * @throws Exception
     */
    T loadlocalJar(String fileUrl) throws RegistryException;

    /**
     * close
     */
    void close(T t) throws RegistryException;
}
