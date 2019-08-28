package com.javabox.registry;
import com.javabox.properties.RegistryProperties;
import com.javabox.registry.mutation.Mutation;
import com.javabox.registry.query.Query;
import com.javabox.registry.service.RegistryService;
import lombok.Data;
@Data
public class RegistryBaseFactory {
    RegistryProperties registryProperties;
    Query query;
    Mutation mutation;
    RegistryService registryService;
}
