package com.julia.store.common.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.julia.store.common.client.events.ClickEvent;

public interface ClickHandler extends EventHandler {

    void onClick(ClickEvent e);
}
