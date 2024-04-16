package com.zero.learns.jmx;

import javax.management.DynamicMBean;
import java.lang.management.PlatformManagedObject;

public interface TokenUsageMBean extends PlatformManagedObject, DynamicMBean {

    long getTotal();

    void setTotal(long total);

    long getUsed();

    void setUsed(long used);

}
