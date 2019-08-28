package com.javabox.properties;
import lombok.Data;

@Data
public abstract class RegistryProperties {
    String type;
    String ip;
    String port;
}
