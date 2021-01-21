package com.cciric.show_of_hands.data.repository;

import com.cciric.show_of_hands.data.entity.BasePollEntity;
import com.cciric.show_of_hands.data.entity.ThreeChoicePollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThreePollRepo extends JpaRepository<ThreeChoicePollEntity, Integer> {

    @Query(value = "SELECT * FROM showofhands.three_choice_poll WHERE user_id = :userid", nativeQuery = true)
    public List<ThreeChoicePollEntity> findAllByUserId(@Param("userid") int userId);
}
