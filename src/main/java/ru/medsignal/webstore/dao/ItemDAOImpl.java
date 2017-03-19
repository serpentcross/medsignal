package ru.medsignal.webstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.medsignal.webstore.entities.Item;


@Repository
@Transactional
public class ItemDAOImpl implements ItemDAO {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Item> getAll() {

        List<Item> result;

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery = criteriaBuilder.createQuery(Item.class);

        Root<Item> root = criteriaQuery.from(Item.class);

        CriteriaQuery<Item> all = criteriaQuery.select(root);
        TypedQuery<Item> allQuery = em.createQuery(all);

        result = allQuery.getResultList();

        return result;
    }
}
