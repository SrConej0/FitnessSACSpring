package com.FitnessSACSpring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.FitnessSACSpring.entity.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {

    List<Plan> findAll();

    Plan findPlanByPlanId(int planId);

    Plan findByNombre(String nombre);

    void deletePlanByPlanId(int planId);
}

