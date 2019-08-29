package com.javabox.registry;
import com.javabox.exception.RegistryException;
import com.javabox.log.Log;
import com.javabox.properties.RegistryProperties;

public interface RegistryService {

    /**
     * 设置配置
     * @param registryProperties
     */
    void setProperties(RegistryProperties registryProperties);

    /**
     * log配置
     * @param log
     */
    void setLog(Log log);

    /**
     *  链接
     */
    void connect(ServerNode serverNode) throws RegistryException;

    /**
     *  关闭
     */
    void close() throws RegistryException;
}
