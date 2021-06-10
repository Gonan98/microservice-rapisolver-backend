package com.rapisolver.attention.entities;

import com.rapisolver.attention.models.UserDTO;
import com.rapisolver.attention.util.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "scores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int mark;

    @Column(nullable = false, length = 50)
    private String note;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(nullable = false, length = 10)
    private String status;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Transient
    private UserDTO userDTO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_attention_id", nullable = false)
    private UserAttention userAttention;
}
