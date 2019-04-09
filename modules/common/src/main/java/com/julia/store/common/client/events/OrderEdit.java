package com.julia.store.common.client.events;

import com.google.gwt.event.shared.GwtEvent;
import com.julia.store.model.client.Order;

public class OrderEdit extends GwtEvent<OrderEditHandler> {

    static Type<OrderEditHandler> TYPE;

    private static Order order;

    public OrderEdit(Order order){
        this.order=order;
    }
    public static Type<OrderEditHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type();
        }

        return TYPE;
    }

    public Order getOrder(){
        return order;
    }

    @Override
    public Type<OrderEditHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(OrderEditHandler orderEditHandler) {
        orderEditHandler.Edit(this);
    }
}
