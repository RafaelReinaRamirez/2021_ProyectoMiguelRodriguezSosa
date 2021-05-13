package com.mkStudio.MKStudio.Shared.Err;

public class EntityNotExist extends DomainError {
    public EntityNotExist(String entityName, Object id) {
        super(entityName + "_not_exist", String.format("The " + entityName + ".id=<%s> doesn't exist", id));
    }
}