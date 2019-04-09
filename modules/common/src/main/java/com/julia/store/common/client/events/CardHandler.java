package com.julia.store.common.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface CardHandler extends EventHandler {

    void Show(CardShow e);
}