package com.julia.store.order.client.activity.details;


import com.julia.store.model.client.Order;
import com.julia.store.order.client.activity.table.AbstractOrderTableActivity;


public interface AbstractOrderDetailsActivity {

    void show(Order order);

//    void showResultOfSearch(Order order);

    void setActivity(AbstractOrderTableActivity orderTablePresenter);

    void onCancelClicked();

    void onSaveClicked();

}