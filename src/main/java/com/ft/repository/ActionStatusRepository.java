package com.ft.repository;

import com.ft.entity.ActionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionStatusRepository extends JpaRepository<ActionStatus, Integer> {

}
