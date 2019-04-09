package com.julia.store.common.client.events;


import com.google.gwt.event.shared.GwtEvent;

public class ClickEvent extends GwtEvent<ClickHandler> {

    static Type<ClickHandler> TYPE;

    public static <S extends HasClickHandlers> void fire(S source) {
        if (TYPE != null) {
            ClickEvent event = new ClickEvent();
            source.fireEvent(event);
        }

    }

    public static Type<ClickHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type();
        }

        return TYPE;
    }

    @Override
    public Type<ClickHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ClickHandler clickHandler) {
        clickHandler.onClick(this);
    }
}
