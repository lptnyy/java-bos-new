package com.javabox;
import com.javabox.registry.RegistryFactory;
import lombok.Data;

@Data
public abstract class BaseAbstractFactory {
    RegistryFactory registryBaseFactory;
}
