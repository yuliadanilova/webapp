package com.julia.store.order.client.view.details;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.julia.store.order.client.activity.details.OrderDetailsActivity;
import com.julia.store.order.client.activity.details.AbstractOrderDetailsView;

public class OrderDetailsView extends Composite implements AbstractOrderDetailsView {


    public OrderDetailsView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void clear() {
        this.userName.setText("");
        this.dateInput.setText("");
        this.countInput.setText("");
        this.priceInput.setText("");
    }

    @Override
    public void setDetailsActivity(OrderDetailsActivity detailsActivity) {
        this.detailsActivity = detailsActivity;
    }

    @Override
    public void setUserInput(String users) {
        userName.setText(users);
    }

    @Override
    public void setDateInput(String dates) {
        dateInput.setText(dates);
    }

    @Override
    public void setCountInput(String counts) {
        countInput.setText(counts);
    }

    @Override
    public void setPriceInput(String prices) {
        priceInput.setText(prices);
    }


    @Override
    public void setItemDialogVisible() {
        setDialogVisible();
        save.setVisible(true);
        cancel.setVisible(true);
    }

    @Override
    public void setSearchItemDialogVisible() {
        setDialogVisible();
        setFieldsEnable(false);
        edit.setVisible(true);
        cancelSearch.setVisible(true);

    }

    @Override
    public  void setEditItemDialogVisible(){
        save.setVisible(false);
        cancelSearch.setVisible(false);
        setDialogVisible();
        setFieldsEnable(true);
        apply.setVisible(true);
        cancel.setVisible(true);
    }

    @Override
    public void setDialogVisible() {
        itemDialog.setVisible(true);
        itemDialog.show();
        itemDialog.center();
    }

    public void setFieldsEnable(Boolean enable){
        userName.setEnabled(enable);
        dateInput.setEnabled(enable);
        countInput.setEnabled(enable);
        priceInput.setEnabled(enable);
    }

    @Override
    public void closeItemDialog() {
        save.setVisible(false);
        cancel.setVisible(false);
        edit.setVisible(false);
        apply.setVisible(false);
        cancelSearch.setVisible(false);
        setFieldsEnable(true);
        itemDialog.hide();
    }

    @Override
    public String getUser() {
        return userName.getText();
    }

    @Override
    public String getDate() {
        return dateInput.getText();
    }

    @Override
    public String getCount() {
        return priceInput.getText();
    }

    @Override
    public String getPrice() {
        return priceInput.getText();
    }

    @UiHandler("apply")
    public void onApplyButtonClick(ClickEvent event) {
        detailsActivity.onApplyClicked();
    }

    @UiHandler("edit")
    public void onEditButtonClick(ClickEvent event) {
        detailsActivity.onEditClicked();
    }

    @UiHandler("save")
    public void onSaveButtonClick(ClickEvent event) {
        detailsActivity.onSaveClicked();
    }

    @UiHandler("cancel")
    public void onCancelButtonClick(ClickEvent event) {
        detailsActivity.onCancelClicked();
    }

    @UiHandler("cancelSearch")
    public void onCancelButtonInSearchDialogClick(ClickEvent event) {
        detailsActivity.onCancelInSearchClicked();
    }

    @UiField
    DivElement content;

    @UiField
    TextBox userName;

    @UiField
    TextBox dateInput;

    @UiField
    TextBox priceInput;

    @UiField
    TextBox countInput;

    @UiField
    DialogBox itemDialog;

    @UiField
    Button save;

    @UiField
    Button cancel;

    @UiField
    Button cancelSearch;

    @UiField
    Button edit;

    @UiField
    Button apply;

    private OrderDetailsActivity detailsActivity;

    interface DetailsViewUiBinder extends UiBinder<HTMLPanel, OrderDetailsView> {
    }

    private static DetailsViewUiBinder uiBinder = GWT.create(DetailsViewUiBinder.class);


}
