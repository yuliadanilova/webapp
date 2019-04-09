package com.julia.store.common.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface OrderEditApplyHandler extends EventHandler {
    void Apply(OrderEditApply editApply);
}
