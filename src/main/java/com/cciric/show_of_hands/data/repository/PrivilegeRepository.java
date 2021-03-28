package com.cciric.show_of_hands.data.repository;

import com.cciric.show_of_hands.data.entity.Privilege.Privilege;
import com.cciric.show_of_hands.data.entity.Role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    Privilege findByName(String read_privilege);
}
