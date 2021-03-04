package order.shop.demo.service.impl;

import order.shop.demo.model.Item;
import order.shop.demo.model.Order;
import order.shop.demo.repository.OrderRepository;
import order.shop.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order complete(Order order) {
        order.setOrderAmount(calculateSumOrder(order));
        return orderRepository.save(order);
    }

    private double calculateSumOrder(Order order) {
        double sum = 0;
        for (Item item : order.getItems()) {
            double price = item.getPrice();
            int discount = item.getDiscountInPercent();
            if (discount != 0) {
                price = price - ((price / 100) * discount);;
            }
            sum += price;
        }
        return sum;
    }
}
