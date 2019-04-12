package com.dangdang.common.utils.data;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;


/**
 * Create by tianjiaqin 2018/11/12-23-12
 */
public class FieldDescription {

    private Field field;

    private PropertyDescriptor propertyDescriptor;

    private String name;

    private Class<?> type;

    private Object value;

    public FieldDescription(String name, Class<?> type, Object value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public FieldDescription(Field field, PropertyDescriptor propertyDescriptor, String name, Class<?> type, Object value) {
        this(name, type, value);
        this.field = field;
        this.propertyDescriptor = propertyDescriptor;
    }

    public Field getField() {
        return this.field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public PropertyDescriptor getPropertyDescriptor() {
        return this.propertyDescriptor;
    }

    public void setPropertyDescriptor(PropertyDescriptor propertyDescriptor) {
        this.propertyDescriptor = propertyDescriptor;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getType() {
        return this.type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + (this.type == null ? 0 : this.type.hashCode());
        result = 31 * result + (this.name == null ? 0 : this.name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        FieldDescription other = (FieldDescription) obj;
        if (this.type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!this.type.equals(other.type)) {
            return false;
        }
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
}