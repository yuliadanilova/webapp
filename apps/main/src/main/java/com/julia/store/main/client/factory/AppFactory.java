package com.julia.store.main.client.factory;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.julia.store.common.client.factory.CommonModule;
import com.julia.store.order.client.activity.details.OrderDetailsActivity;
import com.julia.store.order.client.activity.table.OrderTableActivity;
import com.julia.store.order.client.factory.OrderModule;


@GinModules({CommonModule.class, OrderModule.class})
public interface AppFactory extends Ginjector {

    OrderTableActivity getDialog();

    OrderDetailsActivity getDetails();

}