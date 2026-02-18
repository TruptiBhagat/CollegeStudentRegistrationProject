package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.CollegeStudent;

@Repository
public interface CollegeStudRepo extends JpaRepository<CollegeStudent, Integer> {

}
