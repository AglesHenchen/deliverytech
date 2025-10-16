package com.deliverytech.delivery.repository;

import com.deliverytech.delivery.entity.Restaurante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class RestauranteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Restaurante save(Restaurante restaurante) {
        if (restaurante.getId() == null) {
            entityManager.persist(restaurante);
            return restaurante;
        } else {
            return entityManager.merge(restaurante);
        }
    }

    public Optional<Restaurante> findById(Long id) {
        Restaurante restaurante = entityManager.find(Restaurante.class, id);
        return restaurante != null ? Optional.of(restaurante) : Optional.empty();
    }

    public List<Restaurante> findAll() {
        return entityManager.createQuery("SELECT r FROM Restaurante r", Restaurante.class)
                .getResultList();
    }

    public void deleteById(Long id) {
        findById(id).ifPresent(entityManager::remove);
    }
}
