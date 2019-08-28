package com.javabox.registry;

/**
 *  发现服务类型
 */
public enum RegistryType {
    ZOOKEEPER("zookeeper"),NACOS("nacos"),OTHER("other");

    String value;

    RegistryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
