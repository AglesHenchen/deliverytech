package com.deliverytech.delivery.repository;

import com.deliverytech.delivery.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProdutoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Produto save(Produto produto) {
        if (produto.getId() == null) {
            entityManager.persist(produto);
            return produto;
        } else {
            return entityManager.merge(produto);
        }
    }

    public Optional<Produto> findById(Long id) {
        Produto produto = entityManager.find(Produto.class, id);
        return produto != null ? Optional.of(produto) : Optional.empty();
    }

    public List<Produto> findAll() {
        return entityManager.createQuery("SELECT p FROM Produto p", Produto.class)
                .getResultList();
    }

    public void deleteById(Long id) {
        findById(id).ifPresent(entityManager::remove);
    }
}
