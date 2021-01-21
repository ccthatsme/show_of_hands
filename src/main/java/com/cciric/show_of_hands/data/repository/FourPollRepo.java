package com.cciric.show_of_hands.data.repository;

import com.cciric.show_of_hands.data.entity.BasePollEntity;
import com.cciric.show_of_hands.data.entity.FourChoicePollEntity;
import com.cciric.show_of_hands.data.entity.ThreeChoicePollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface FourPollRepo extends JpaRepository<FourChoicePollEntity, Integer> {
    List<FourChoicePollEntity> findAllByUser(int id);

//    void saveBasePollEntity(FourChoicePollEntity entity);

}
