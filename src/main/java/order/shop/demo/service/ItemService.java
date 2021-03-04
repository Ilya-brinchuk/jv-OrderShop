package order.shop.demo.service;

import order.shop.demo.model.Item;

public interface ItemService {
    Item save(Item item);

    Item update(Item item);

    Item getById(Long id);
}
