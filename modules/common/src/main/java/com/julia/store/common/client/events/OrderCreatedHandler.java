package com.julia.store.common.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface OrderCreatedHandler extends EventHandler {

    void Save(OrderCreated e);
}
