package com.julia.store.order.client.activity.details;

import com.google.gwt.user.client.ui.IsWidget;

public interface AbstractOrderDetailsView extends IsWidget {

    void clear();

    void setDetailsActivity(OrderDetailsActivity presenter);

    void setUserInput(String user);

    void setDateInput(String date);

    void setCountInput(String count);

    void setPriceInput(String price);

    void setDialogVisible();

    void setFieldsEnable(Boolean enable);

    void setItemDialogVisible();

    void setEditItemDialogVisible();

    void setSearchItemDialogVisible();

    void closeItemDialog();

    String getUser();

    String getDate();

    String getCount();

    String getPrice();

}
