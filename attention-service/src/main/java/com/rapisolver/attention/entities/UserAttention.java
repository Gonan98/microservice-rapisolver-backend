package com.rapisolver.attention.entities;

import com.rapisolver.attention.models.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_attentions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAttention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String detail;

    @Column(nullable = false)
    private BigDecimal price;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(nullable = false, length = 10)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attention_id", nullable = false)
    private Attention attention;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Transient
    private UserDTO user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userAttention")
    private List<Score> scores;
}
