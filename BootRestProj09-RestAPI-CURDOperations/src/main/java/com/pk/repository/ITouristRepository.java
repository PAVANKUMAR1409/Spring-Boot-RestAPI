package com.pk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pk.entity.Tourist;

public interface ITouristRepository extends JpaRepository<Tourist, Integer> {

}
