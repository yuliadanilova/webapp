package com.julia.store.order.client.activity.table;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.julia.store.order.client.view.item.Item;


public interface AbstractOrderTableView extends IsWidget {

    void setTableActivity(OrderTableActivity tableActivity);

//    void setUser(String name);
//
//    void setDate(String date);
//
//    void setCount(String count);
//
//    void setPrice(String price);


    void searchDialogClose();

    void setSearchDialogVisible();

    boolean searchUser();

    void clear();

    void addContent(Item item);

    HasWidgets getContent();
}
