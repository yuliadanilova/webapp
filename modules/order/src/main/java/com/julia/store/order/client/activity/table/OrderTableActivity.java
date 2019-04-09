package com.julia.store.order.client.activity.table;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;

import com.google.inject.Provider;
import com.julia.store.common.client.events.*;
import com.julia.store.model.client.Order;
import com.julia.store.order.client.activity.details.OrderDetailsActivity;
import com.julia.store.order.client.view.item.Item;
import com.julia.store.order.client.view.table.OrderTableView;

import java.util.ArrayList;

import java.util.List;

public class OrderTableActivity implements AbstractOrderTableActivity {

    public OrderTableActivity() {
        detailsActivity = new OrderDetailsActivity();
        detailsActivity.setActivity(this);
        this.view= new OrderTableView();
        view.setTableActivity(this);

    }

    @Inject
    public void init() {

        RootPanel.get().add(view.asWidget());

        eventBus.addHandler(OrderCreated.getType(), new OrderCreatedHandler() {
            @Override
            public void Save(OrderCreated order) {
                addItem(order.getOrder().getUser(), order.getOrder().getDate(), order.getOrder().getCount(), order.getOrder().getPrice());
            }
        });
        eventBus.addHandler(OrderEdit.getType(), new OrderEditHandler() {
            @Override
            public void Edit(OrderEdit orderEdit) {
                detailsActivity.showEditDialog(orderEdit.getOrder());
            }
        });
        eventBus.addHandler(OrderEditApply.getType(), new OrderEditApplyHandler() {
            @Override
            public void Apply(OrderEditApply editApply) {
                if (!isExist(editApply.getOrder()))
                    addItem(editApply.getOrder().getUser(), editApply.getOrder().getDate(), editApply.getOrder().getCount(), editApply.getOrder().getPrice());
            }
        });
    }

    public void onAddButtonClick() {
        Order order = new Order();
        detailsActivity.show(order);

    }

    public void onClearAllClick() {
        items.removeAll(items.subList(0, items.size() - 1));
        orders.removeAll(orders.subList(0, orders.size() - 1));
        view.clear();
    }

    public void onSearchButtonClick(String user) {
//        for (Order order : orders) {
//            if (order.getUser().equals(user))
//                detailsActivity.showResultOfSearch(order);
//        }
//
    }

    public boolean isExist(Order editOrder) {
        for (Order order : orders) {
            if ((order.equals(editOrder)) && order.hashCode() == editOrder.hashCode())
                return true;
        }
        return false;
    }

    void addItem(String user, String date, String count, String product) {
        Item item = itemProvider.get();
        item.setUser(user);
        item.setDate(date);
        item.setAmount(count);
        item.setProduct(product);

        addOrder(user, date, count, product);

        item.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(com.julia.store.common.client.events.ClickEvent e) {
                eventBus.fireEvent(new CardShow(user, date, count, product));
            }
        });
//        MultiWordSuggestOracle oracle = (MultiWordSuggestOracle) suggestBox.getSuggestOracle();
//        oracle.add(user);
        view.addContent(item);
        items.add(item);

    }

    void addOrder(String user, String date, String count, String price) {
        Order order = new Order();
        order.setUser(user);
        order.setCount(count);
        order.setDate(date);
        order.setPrice(price);
        orders.add(order);
    }


    @Inject
    EventBus eventBus;

    @Inject
    Provider<Item> itemProvider;

    @Inject
    OrderDetailsActivity detailsActivity;

    AbstractOrderTableView view;

//    AbstractOrderTableView view = new OrderTableView();

    private List<Item> items = new ArrayList<>();

    private List<Order> orders = new ArrayList<>();


}
