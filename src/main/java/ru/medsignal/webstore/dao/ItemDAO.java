package ru.medsignal.webstore.dao;

import java.util.List;
import ru.medsignal.webstore.entities.Item;

public interface ItemDAO {

    List<Item> getAll();
}
