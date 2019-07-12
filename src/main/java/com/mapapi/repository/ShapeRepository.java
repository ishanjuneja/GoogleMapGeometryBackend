package com.mapapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapapi.model.Shape;

@Repository
public interface ShapeRepository extends JpaRepository<Shape, Integer> {

}
