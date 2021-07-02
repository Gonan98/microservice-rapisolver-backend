package com.rapisolver.attention.services;

import com.rapisolver.attention.entities.UserAttention;
import com.rapisolver.attention.repository.ScoreRepository;
import com.rapisolver.attention.repository.UserAttentionRepository;
import com.rapisolver.attention.services.impl.ScoreServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

public class ScoreServiceTest {

    @Mock
    private ScoreRepository repository;

    @Mock
    private UserAttentionRepository userAttentionRepository;

    @InjectMocks
    private ScoreServiceImpl serviceTest;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void itShouldGetAll() throws RuntimeException {
        BDDMockito.given(userAttentionRepository.findById(1L)).willReturn(Optional.of(Mockito.mock(UserAttention.class)));

        serviceTest.getAll();

        BDDMockito.then(repository).should().findAll();
    }
}
