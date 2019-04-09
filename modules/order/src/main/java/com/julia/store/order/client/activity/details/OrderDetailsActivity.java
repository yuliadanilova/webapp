package com.julia.store.order.client.activity.details;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import com.julia.store.common.client.events.*;
import com.julia.store.model.client.Order;
import com.julia.store.order.client.activity.table.AbstractOrderTableActivity;
import com.julia.store.order.client.view.details.OrderDetailsView;


public class OrderDetailsActivity implements AbstractOrderDetailsActivity {

    public OrderDetailsActivity() {
        this.view = new OrderDetailsView();
        view.setDetailsActivity(this);
    }

    @Inject
    public void init() {
        RootPanel.get().add(view.asWidget());
        eventBus.addHandler(CardShow.getType(), new CardHandler() {
            @Override
            public void Show(CardShow e) {
                onShowCard(e);
            }
        });
    }

    @Override
    public void show(Order order) {
        this.order = order;
        fillInputFields(order.getUser(),order.getDate(),order.getCount(),order.getPrice());
        view.setItemDialogVisible();
    }

    public void showEditDialog(Order order) {
        this.order = order;
        fillInputFields(order.getUser(),order.getDate(),order.getCount(),order.getPrice());
        view.setEditItemDialogVisible();
    }

//    @Override
//    public void showResultOfSearch(Order order) {
//        this.order = order;
//        view.setUser(order.getUser());
//        view.setDate(order.getDate());
//        view.setCount(order.getCount());
//        view.setPrice(order.getPrice());
//        view.setSearchItemDialogVisible();
//    }

    @Override
    public void setActivity(AbstractOrderTableActivity tableActivity) {
        this.tableActivity = tableActivity;
    }

    @Override
    public void onCancelClicked() {
        view.clear();
        view.closeItemDialog();
    }

    public void onSaveClicked() {
        order.setUser(view.getUser());
        order.setDate(view.getDate());
        order.setCount(view.getCount());
        order.setPrice(view.getPrice());
        view.clear();
        eventBus.fireEvent(new OrderCreated(order));
        view.closeItemDialog();
    }

    public void onEditClicked() {
        view.closeItemDialog();
        fillInputFields(order.getUser(), order.getDate(), order.getCount(), order.getPrice());
        eventBus.fireEvent(new OrderEdit(order));
    }

    public void onApplyClicked() {
        view.closeItemDialog();
        fillInputFields(order.getUser(),order.getDate(),order.getCount(),order.getPrice());
        eventBus.fireEvent(new OrderEditApply(order));
    }


    public void fillInputFields(String name, String date, String count, String price) {
        view.setUserInput(name);
        view.setDateInput(date);
        view.setCountInput(count);
        view.setPriceInput(price);
    }

    private void onShowCard(CardShow e) {
        fillInputFields(e.getUser(),e.getDate(),e.getCount(),e.getProduct());
        view.setSearchItemDialogVisible();
    }

    public void onCancelInSearchClicked() {
        view.closeItemDialog();
    }

    @Inject
    EventBus eventBus;

    AbstractOrderTableActivity tableActivity;

    AbstractOrderDetailsView view;

    private Order order;


}

