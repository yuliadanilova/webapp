package com.julia.store.order.client.view.table;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.julia.store.order.client.activity.table.OrderTableActivity;
import com.julia.store.order.client.activity.table.AbstractOrderTableView;
import com.julia.store.order.client.view.item.Item;

import java.util.ArrayList;
import java.util.List;


public class OrderTableView extends Composite implements AbstractOrderTableView {

    public OrderTableView() {
        initWidget(ourUiBinder.createAndBindUi(this));

        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                if (tableActivity != null)
                    tableActivity.onAddButtonClick();
            }
        });
        clearAll.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                tableActivity.onClearAllClick();
            }
        });
        search.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                tableActivity.onSearchButtonClick(suggestBox.getValue());
            }
        });

    }

    @Override
    public void addContent(Item item) {
        content.add(item);
    }

    @Override
    public HasWidgets getContent() {
        return content;
    }

    @Override
    public boolean searchUser() {
        boolean isFound = false;
        for (Item item : items) {
            if (item.getUser().equals(suggestBox.getText())) {
                isFound = true;
            }
        }
        return isFound;
    }

    @Override
    public void setSearchDialogVisible() {
        searchDialog.show();
    }

    @Override
    public void clear() {
        content.clear();
    }

    @Override
    public void setTableActivity(OrderTableActivity tableActivity) {
        this.tableActivity = tableActivity;
    }

    @Override
    public void searchDialogClose() {
        searchDialog.hide();
    }


    @UiField
    SuggestBox suggestBox;

    @UiField
    HTMLPanel content;

    @UiField
    DialogBox searchDialog;

    @UiField
    Button addButton;

    @UiField
    Button cancel;

    @UiField
    Button search;

    @UiField
    Button clearAll;

    private List<Item> items = new ArrayList<>();

    private OrderTableActivity tableActivity;

    interface DialogUiBinder extends UiBinder<HTMLPanel, OrderTableView> {
    }

    private static DialogUiBinder ourUiBinder = GWT.create(DialogUiBinder.class);


}
