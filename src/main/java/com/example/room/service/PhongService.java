package com.example.room.service;

import com.example.room.model.Phong;
import com.example.room.repository.PhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongService {
    @Autowired
    private PhongRepository phongRepository;

    public List<Phong> getAllPhongs() {
        return (List<Phong>) phongRepository.findAll();
    }

    public void createPhong(Phong phong) {
        phongRepository.save(phong);
    }

    public Phong findPhongById(Long id) {
        return phongRepository.findById(id).orElse(null);
    }

    public void updatePhong(Phong phong) {
        Phong existingPhong = findPhongById(phong.getId());

        if (existingPhong != null) {
            existingPhong.setName(phong.getName());
            existingPhong.setDetail(phong.getDetail());
            existingPhong.setPrice(phong.getPrice());
            existingPhong.setStatus(phong.isStatus());
            existingPhong.setNumberOfPerson(phong.getNumberOfPerson());
            existingPhong.setNumberBed(phong.getNumberBed());

            phongRepository.save(existingPhong);
        }
    }

    public void deletePhongById(Long id) {
        phongRepository.deleteById(id);
    }

    public List<Phong> searchPhongByName(String name) {
        return phongRepository.findPhongByNameContaining(name);
    }

    public List<Phong> searchPhongByPrice(double price) {
        return phongRepository.findPhongByPriceLessThanEqual(price);
    }
}