package com.javabox.properties;
import lombok.Data;

@Data
public abstract class RegistryProperties {
    String type;
    String ip;
    String port;

    public RegistryProperties(){

    }

    public RegistryProperties(String type,String ip,String port){
        this.type = type;
        this.ip = ip;
        this.port = port;
    }
}
