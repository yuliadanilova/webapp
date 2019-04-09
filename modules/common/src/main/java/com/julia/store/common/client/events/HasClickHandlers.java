package com.julia.store.common.client.events;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.julia.store.common.client.events.ClickHandler;

public interface HasClickHandlers extends HasHandlers {

    HandlerRegistration addClickHandler(ClickHandler var1);

}
