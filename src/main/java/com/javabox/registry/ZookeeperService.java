package com.javabox.registry;
import com.javabox.exception.RegistryException;
import com.javabox.log.Log;
import com.javabox.properties.RegistryProperties;
import com.javabox.registry.business.ModifyBusiness;
import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

public class ZookeeperService implements ModifyBusiness,RegistryService,Watcher{
    String registryRoot = "/javabox";
    String getRegistryRootNode=registryRoot+"/nodes";
    Log log;
    RegistryProperties registryProperties;
    private ZooKeeper zooKeeper;
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public void setProperties(RegistryProperties registryProperties) {
        this.registryProperties = registryProperties;
    }

    public void setLog(Log log) {
        this.log = log;
    }
    ServerNode serverNode;

    public void connect(ServerNode serverNode) throws RegistryException {
        this.serverNode = serverNode;
        try {
            zooKeeper = new ZooKeeper(registryProperties.getConnect()
                    ,registryProperties.getTimeOut(), this);
            countDownLatch.await();
        } catch (Exception e) {
            throw new RegistryException(e.getMessage());
        }
    }

    public void close() throws RegistryException  {
        if(zooKeeper != null){
            try {
                zooKeeper.close();
            } catch (InterruptedException e) {
                throw new RegistryException(e.getMessage());
            }
        }
    }

    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            log.info("服务链接成功");
            countDownLatch.countDown();
            registryNode(serverNode);
        }
    }

    /**
     * 注册服务
     * @param serverNode
     * @return
     */
    public boolean registryNode(ServerNode serverNode) {
        try {
            if(zooKeeper.exists(registryRoot, null) == null){
                zooKeeper.create(registryRoot,"".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            }
            if(zooKeeper.exists(getRegistryRootNode, null) == null){
                zooKeeper.create(getRegistryRootNode,"".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            }
            if(zooKeeper.exists(getRegistryRootNode, null) == null){
                zooKeeper.create(getRegistryRootNode,"".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            }
        } catch (KeeperException e) {
            log.error(e);
        } catch (InterruptedException e) {
            log.error(e);
        }
        return false;
    }
}
