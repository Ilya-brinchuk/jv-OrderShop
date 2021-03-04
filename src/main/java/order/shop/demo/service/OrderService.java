package order.shop.demo.service;

import order.shop.demo.model.Item;
import order.shop.demo.model.Order;

public interface OrderService {

    Order complete(Order order);

}
