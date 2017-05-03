package ru.medsignal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.medsignal.dao.ItemDAO;
import ru.medsignal.entities.Item;

import java.util.List;

@Controller
public class RepoControler {

    @Autowired
    ItemDAO itemDAO;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> loadCreditPeriods() throws Exception {
        List<Item> items = itemDAO.getAll();
        if (items.isEmpty()) {
            return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }


}
