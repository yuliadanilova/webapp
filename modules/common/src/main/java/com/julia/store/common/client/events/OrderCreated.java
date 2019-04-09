package com.julia.store.common.client.events;

import com.google.gwt.event.shared.GwtEvent;
import com.julia.store.model.client.Order;

public class OrderCreated extends GwtEvent<OrderCreatedHandler> {
    static Type<OrderCreatedHandler> TYPE;

     private static Order order;

    public OrderCreated(Order order){
        this.order=order;
    }
    public static Type<OrderCreatedHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type();
        }

        return TYPE;
    }

    public static <S extends HasClickOrderHandlers> void fire(S source) {
        if (TYPE != null) {
            OrderCreated event = new OrderCreated(order);
            source.fireEvent(event);
        }

    }

    public Order getOrder(){
        return order;
    }

    @Override
    public Type<OrderCreatedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(OrderCreatedHandler orderChangedHandler) {
        orderChangedHandler.Save(this);
    }
}
