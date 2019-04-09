package com.julia.store.order.client.factory;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.julia.store.order.client.activity.details.OrderDetailsActivity;
import com.julia.store.order.client.activity.table.OrderTableActivity;

public class OrderModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(OrderTableActivity.class).in(Singleton.class);
        bind(OrderDetailsActivity.class).asEagerSingleton();
    }
}

