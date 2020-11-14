package com.cciric.show_of_hands.data.repository;

import com.cciric.show_of_hands.data.entity.BasePollEntity;
import com.cciric.show_of_hands.data.entity.ThreeChoicePollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreePollRepo extends JpaRepository<ThreeChoicePollEntity, Integer> {

}
