package com.cciric.show_of_hands.data.repository;

import com.cciric.show_of_hands.data.entity.BasePollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface BasePollRepo extends JpaRepository<BasePollEntity, Integer> {


}
