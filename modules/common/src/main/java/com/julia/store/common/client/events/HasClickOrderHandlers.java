package com.julia.store.common.client.events;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasClickOrderHandlers extends HasHandlers {

    HandlerRegistration addChangedHandler(OrderCreatedHandler var1);

}
