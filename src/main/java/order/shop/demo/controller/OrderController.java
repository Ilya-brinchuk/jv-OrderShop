package order.shop.demo.controller;

import order.shop.demo.model.Item;
import order.shop.demo.model.Order;
import order.shop.demo.service.ItemService;
import order.shop.demo.service.OrderService;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

@Component
public class OrderController {
    private final ItemService itemService;
    private final OrderService orderService;

    public OrderController(ItemService itemService, OrderService orderService) {
        this.itemService = itemService;
        this.orderService = orderService;
    }

    @PostConstruct
    public void init() {
        Item item1 = new Item();
        item1.setName("Sweater");
        item1.setPrice(234);
        item1.setDiscountInPercent(14);
        Item item2 = new Item();
        item2.setName("Pants");
        item2.setPrice(450);
        item2.setDiscountInPercent(23);
        itemService.save(item1);
        itemService.save(item2);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        System.out.println(item1.getId());
        Order order = new Order();
        order.setOrderTime(LocalDateTime.now());
        order.setItems(items);
        orderService.complete(order);

        System.out.println(order.getOrderAmount());
    }


}
