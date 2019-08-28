package com.javabox.registry;
import com.javabox.properties.RegistryProperties;
import com.javabox.registry.mutation.RegistryMutation;
import com.javabox.registry.query.RegistryQuery;
import com.javabox.registry.service.RegistryService;
import lombok.Data;

@Data
public class RegistryBaseFactory {
    RegistryProperties registryProperties;
    RegistryQuery query;
    RegistryMutation mutation;
    RegistryService registryService;
}
