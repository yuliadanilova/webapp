package com.julia.store.main.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.julia.store.main.client.factory.AppFactory;

import com.julia.store.order.client.activity.details.OrderDetailsActivity;

import com.julia.store.order.client.activity.table.OrderTableActivity;
import com.julia.store.order.client.view.table.OrderTableView;


public class Store implements EntryPoint {


    public void onModuleLoad() {

        AppFactory injector = GWT.create(AppFactory.class);

        OrderTableActivity tableActivity = injector.getDialog();

        OrderDetailsActivity detailsActivity = injector.getDetails();
    }
}
