package com.julia.store.common.client.events;

import com.google.gwt.event.shared.GwtEvent;
import com.julia.store.model.client.Order;

public class OrderEditApply extends GwtEvent<OrderEditApplyHandler> {
    static Type<OrderEditApplyHandler> TYPE;

    private static Order order;

    public OrderEditApply(Order order){
        this.order=order;
    }
    public static Type<OrderEditApplyHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type();
        }

        return TYPE;
    }

    public Order getOrder(){
        return order;
    }

    @Override
    public Type<OrderEditApplyHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(OrderEditApplyHandler orderEditApplyHandler) {
        orderEditApplyHandler.Apply(this);
    }
}


