package com.julia.store.common.client.events;

import com.google.gwt.event.shared.GwtEvent;
import com.julia.store.common.client.events.CardHandler;

public class CardShow extends GwtEvent<CardHandler> {

    static Type<CardHandler> TYPE;

    private String user;
    private String date;
    private String count;
    private String product;

    public CardShow(String user, String date, String count, String product) {
        this.user = user;
        this.date = date;
        this.count = count;
        this.product = product;

    }

    public static Type<CardHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type();
        }

        return TYPE;
    }

    public String getUser() {
        return user;
    }

    public String getDate() {
        return date;
    }

    public String getCount() {
        return count;
    }

    public String getProduct() {
        return product;
    }

    @Override
    public Type<CardHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CardHandler cardHandler) {
        cardHandler.Show(this);
    }
}

