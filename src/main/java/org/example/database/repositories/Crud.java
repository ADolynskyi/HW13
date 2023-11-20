package org.example.database.repositories;

public interface Crud<T> {

    void persist(T entity);

    T getByID(Object id);

    void merge(T entity);

    void remove(T entity);

}
