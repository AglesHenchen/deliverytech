package com.deliverytech.delivery.repository;

import com.deliverytech.delivery.entity.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class PedidoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Pedido save(Pedido pedido) {
        if (pedido.getId() == null) {
            entityManager.persist(pedido);
            return pedido;
        } else {
            return entityManager.merge(pedido);
        }
    }

    public Optional<Pedido> findById(Long id) {
        Pedido pedido = entityManager.find(Pedido.class, id);
        return pedido != null ? Optional.of(pedido) : Optional.empty();
    }

    public List<Pedido> findAll() {
        return entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class)
                .getResultList();
    }

    public void deleteById(Long id) {
        findById(id).ifPresent(entityManager::remove);
    }
}
