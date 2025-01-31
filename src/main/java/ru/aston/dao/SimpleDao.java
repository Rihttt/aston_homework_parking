package ru.aston.dao;

import ru.aston.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface SimpleDao<T> {
    void save(T record);
    List<T> findAll();
    Optional<T> findById(int id);
    void deleteById(int id);
    //void update(T record, int id);

}