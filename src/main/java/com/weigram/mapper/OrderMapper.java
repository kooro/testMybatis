package com.weigram.mapper;

import com.weigram.model.Orders;
import com.weigram.model.OrdersExt;
import com.weigram.model.User;

import java.util.List;

public interface OrderMapper {
    public OrdersExt findOrderById(int id);
    public Orders findOrderById2(int id);
    public Orders findOrderById3(int id);
    public List<Orders> findOrderAndUserByLazyLoading();
}
