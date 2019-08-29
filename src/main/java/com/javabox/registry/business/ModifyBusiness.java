package com.javabox.registry.business;

import com.javabox.registry.ServerNode;

public interface ModifyBusiness {

    /**
     * 注册服务
     * @param serverNode
     * @return
     */
    boolean registryNode(ServerNode serverNode);
}
