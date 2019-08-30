package com.javabox.registry.business;

import com.javabox.registry.ServerNode;

public interface ModifyBusiness<T> {

    /**
     * 注册服务
     * @param serverNode
     * @return
     */
    boolean registryNode(T t,ServerNode serverNode);
}
