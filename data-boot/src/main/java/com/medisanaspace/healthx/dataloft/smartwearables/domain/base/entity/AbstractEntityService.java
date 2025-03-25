package com.medisanaspace.healthx.dataloft.smartwearables.domain.base.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractEntityService<E extends AbstractEntity, I, R extends JpaRepository<E, I>> {

    protected final R repository;

    protected AbstractEntityService(R repository) {
        this.repository = repository;
    }

    public E save(E entity) {
        return repository.save(entity);
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public <S extends E> List<S> saveAll(Iterable<S> entities) {
        return repository.saveAll(entities);
    }

    public Optional<E> findById(I id) {
        return repository.findById(id);
    }

    public void delete(E entity) {
        repository.delete(entity);
    }

    public void deleteById(I id) {
        repository.deleteById(id);
    }

}
