package com.javabox.registry;
import com.javabox.properties.RegistryProperties;
import lombok.Data;

@Data
public class RegistryBaseFactory {
    RegistryProperties registryProperties;
    RegistryQuery query;
    RegistryMutation mutation;
    RegistryService registryService;
}
