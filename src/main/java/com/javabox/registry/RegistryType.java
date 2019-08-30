package com.javabox.registry;

/**
 *  Registration Type
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
