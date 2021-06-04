package com.rapisolver.attention.repository;

import com.rapisolver.attention.entities.UserAttention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAttentionRepository extends JpaRepository<UserAttention, Long> {
}
