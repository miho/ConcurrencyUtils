package eu.mihosoft.concurrencyutils.vmfmodel;

import eu.mihosoft.vmf.core.Container;
import eu.mihosoft.vmf.core.Contains;
import eu.mihosoft.vmf.core.DelegateTo;

interface Counter {

    int getValue();

    @DelegateTo(className = "eu.mihosoft.vmfactors.CounterBehavior")
    void inc();

    @DelegateTo(className = "eu.mihosoft.vmfactors.CounterBehavior")
    void dec();

    @DelegateTo(className = "eu.mihosoft.vmfactors.CounterBehavior")
    void reset();

    @Container(opposite = "counter")
    CounterParent getOwner();

}

interface CounterParent {

    @Contains(opposite = "owner")
    Counter getCounter();

}
