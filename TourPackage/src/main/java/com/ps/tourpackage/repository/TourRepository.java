package com.ps.tourpackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.tourpackage.entity.TourPackage;
@Repository
public interface TourRepository extends JpaRepository<TourPackage, Integer> {

}
