package com.ft.repository;

import com.ft.entity.Order;
import com.ft.entity.enums.Progress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

        @Query(value = "SELECT o " +
                        "FROM Order o " +
                        "WHERE o.description LIKE %:description% AND o.completed = :isCompleted AND o.whenToBeDone < :dateBefore "
                        +
                        "ORDER BY CASE " +
                        "WHEN (o.priority = 'URGENT') THEN '1' " +
                        "WHEN (o.priority = 'HIGH') THEN '2' " +
                        "WHEN (o.priority = 'MEDIUM') THEN '3' " +
                        "WHEN (o.priority = 'LOW') THEN '4' " +
                        "END ASC, o.id DESC")
        Page<Order> findByDescriptionIgnoreCaseContaining(String description, Pageable pageable, boolean isCompleted,
                        Date dateBefore);

        @Query(value = "SELECT o " +
                        "FROM Order o " +
                        "WHERE o.completed = :isCompleted AND o.whenToBeDone < :dateBefore " +
                        "ORDER BY CASE " +
                        "WHEN (o.priority = 'URGENT') THEN '1' " +
                        "WHEN (o.priority = 'HIGH') THEN '2' " +
                        "WHEN (o.priority = 'MEDIUM') THEN '3' " +
                        "WHEN (o.priority = 'LOW') THEN '4' " +
                        "END ASC, o.id DESC")
        Page<Order> findAll(Pageable pageable, boolean isCompleted, Date dateBefore);

        @Query(value = "SELECT o " +
                        "FROM Order o " +
                        "JOIN o.actionStatuses s " +
                        "JOIN s.tenants t " +
                        "WHERE t.id = :tenantid AND s.progress not like :progress  AND o.whenToBeDone < :dateBefore " +
                        "GROUP BY o.id " +
                        "ORDER BY CASE " +
                        "WHEN (o.priority = 'URGENT') THEN '1' " +
                        "WHEN (o.priority = 'HIGH') THEN '2' " +
                        "WHEN (o.priority = 'MEDIUM') THEN '3' " +
                        "WHEN (o.priority = 'LOW') THEN '4' " +
                        "END ASC, o.id DESC")
        Page<Order> findAllWhereTenantId(String tenantid, Pageable pageable, Progress progress, Date dateBefore);

        @Query(value = "SELECT o " +
                        "FROM Order o " +
                        "JOIN o.actionStatuses s " +
                        "JOIN s.tenants t " +
                        "WHERE t.id = :tenantid AND o.description LIKE %:description% AND s.progress NOT like :progress  AND o.whenToBeDone < :dateBefore "
                        +
                        "GROUP BY o.id " +
                        "ORDER BY CASE " +
                        "WHEN (o.priority = 'URGENT') THEN '1' " +
                        "WHEN (o.priority = 'HIGH') THEN '2' " +
                        "WHEN (o.priority = 'MEDIUM') THEN '3' " +
                        "WHEN (o.priority = 'LOW') THEN '4' " +
                        "END ASC, o.id DESC")
        Page<Order> findAllWhereTenantIdAndDescription(String description, String tenantid, Pageable pageable,
                        Progress progress, Date dateBefore);

        @Query(value = "SELECT o " +
                        "FROM Order o " +
                        "WHERE o.completed = true")
        List<Order> findAllCompleted();
}