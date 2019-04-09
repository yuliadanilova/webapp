package com.julia.store.order.client.view.item;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import com.julia.store.common.client.events.ClickEvent;
import com.julia.store.common.client.events.ClickHandler;
import com.julia.store.common.client.events.HasClickHandlers;


public class Item extends Composite implements HasClickHandlers {

    @UiField
    InlineLabel orderId;

    @UiField
    InlineLabel user;

    @UiField
    InlineLabel product;

    @UiField
    InlineLabel date;

    @UiField
    InlineLabel amount;

    @UiField
    FocusPanel root;

    @UiHandler("root")
    public void rootClick(com.google.gwt.event.dom.client.ClickEvent event) {
        ClickEvent.fire(this);
    }

    @Inject
    public void init() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @Override
    public HandlerRegistration addClickHandler(ClickHandler var1) {
        return addHandler(var1, ClickEvent.getType());
    }



    public String getOrderId() {
        return orderId.getText();
    }

    public void setOrderId(int id) {
        orderId.setText(String.valueOf(id));
    }

    public String getUser() {
        return user.getText();
    }

    public void setUser(String s) {
        user.setText(s);
    }

    public String getDate() {
        return date.getText();
    }

    public void setDate(String s) {
        date.setText(s);
    }

    public String getAmount() {
        return amount.getText();
    }

    public void setAmount(String s) {
        amount.setText(s);
    }

    public String getProduct() {
        return product.getText();
    }

    public void setProduct(String s) {
        product.setText(s);
    }

    interface ItemUiBinder extends UiBinder<HTMLPanel, Item> {
    }

    private static ItemUiBinder ourUiBinder = GWT.create(ItemUiBinder.class);
}

