package com.sayed.saber.repository;

import com.sayed.saber.entity.ImageEntity;
import com.sayed.saber.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity,Integer> {

}
