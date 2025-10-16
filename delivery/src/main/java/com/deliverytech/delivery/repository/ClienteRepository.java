package com.deliverytech.delivery.repository;

import com.deliverytech.delivery.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ClienteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Salvar cliente
    public Cliente save(Cliente cliente) {
        if (cliente.getId() == null) {
            entityManager.persist(cliente);
            return cliente;
        } else {
            return entityManager.merge(cliente);
        }
    }

    // Buscar por ID
    public Optional<Cliente> findById(Long id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        return cliente != null ? Optional.of(cliente) : Optional.empty();
    }

    // Buscar todos
    public List<Cliente> findAll() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList();
    }

    // Deletar por ID
    public void deleteById(Long id) {
        findById(id).ifPresent(entityManager::remove);
    }
}
