package com.example.room.repository;

import com.example.room.model.Phong;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhongRepository extends CrudRepository<Phong, Long> {
    List<Phong> findPhongByNameContaining(String name);
}