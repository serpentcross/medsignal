package ru.medsignal.webstore.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.medsignal.webstore.constants.EndPoints;
import ru.medsignal.webstore.dao.ItemDAO;
import ru.medsignal.webstore.entities.Item;

@Controller
@RequestMapping("shop")
public class RestController {

    @Autowired
    ItemDAO itemDAO;

    @RequestMapping(value = EndPoints.ALL_ITEMS, method = RequestMethod.GET)
    public ResponseEntity<List<Item>> loadBusinessForms() throws DataAccessException {
        List<Item> items = itemDAO.getAll();
        if (items.isEmpty()) {
            return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }

}
