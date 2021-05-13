package com.mkStudio.MKStudio.Shared.Err;

public class EntityExist extends DomainError {
    public EntityExist(String entityName, Object id) {
        super(entityName + "_exist", String.format("The " + entityName + ".id=<%s> already exist", id));
    }
}
