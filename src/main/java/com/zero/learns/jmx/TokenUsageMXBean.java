package com.zero.learns.jmx;


import javax.management.*;
import javax.management.modelmbean.ModelMBeanInfoSupport;
import java.beans.beancontext.BeanContext;

public class TokenUsageMXBean implements TokenUsageMBean {
    private ObjectName objectName;
    private long total;
    private long used;

    public TokenUsageMXBean(ObjectName objectName) {
        this.objectName = objectName;
    }

    @Override
    public long getTotal() {
        return this.total;
    }

    @Override
    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public long getUsed() {
        return this.used;
    }

    @Override
    public void setUsed(long used) {
        this.used = used;
    }

    @Override
    public ObjectName getObjectName() {
        return this.objectName;
    }

    @Override
    public Object getAttribute(String attribute) throws AttributeNotFoundException, MBeanException, ReflectionException {
        throw new AttributeNotFoundException("do not support attributes");
    }

    @Override
    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        throw new AttributeNotFoundException("do not support attributes");
    }

    @Override
    public AttributeList getAttributes(String[] attributes) {
        return new AttributeList();
    }

    @Override
    public AttributeList setAttributes(AttributeList attributes) {
        return attributes;
    }

    @Override
    public Object invoke(String actionName, Object[] params, String[] signature) throws MBeanException, ReflectionException {

        return null;
    }

    @Override
    public MBeanInfo getMBeanInfo() {

        return null;
    }
}
