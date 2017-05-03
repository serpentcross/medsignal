package ru.medsignal.dao;

import org.springframework.stereotype.Component;
import ru.medsignal.entities.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class ItemDAOImpl implements ItemDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Item> getAll() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery = cb.createQuery(Item.class);
        Root<Item> root = criteriaQuery.from(Item.class);
        CriteriaQuery<Item> all = criteriaQuery.select(root);
        TypedQuery<Item> allQuery = em.createQuery(all);

        return  allQuery.getResultList();
    }
}
