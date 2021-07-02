package com.rapisolver.attention.services;

import com.rapisolver.attention.client.UserClient;
import com.rapisolver.attention.controllers.RapisolverResponse;
import com.rapisolver.attention.dtos.CreateUserAttentionDTO;
import com.rapisolver.attention.dtos.UserAttentionDTO;
import com.rapisolver.attention.entities.Attention;
import com.rapisolver.attention.entities.UserAttention;
import com.rapisolver.attention.models.UserDTO;
import com.rapisolver.attention.repository.AttentionRepository;
import com.rapisolver.attention.repository.UserAttentionRepository;
import com.rapisolver.attention.services.impl.UserAttentionServiceImpl;
import static org.mockito.BDDMockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

public class UserAttentionServiceTest {

    @Mock
    private UserClient userClient;

    @Mock
    private AttentionRepository attentionRepository;

    @Mock
    private UserAttentionRepository repository;

    @InjectMocks
    private UserAttentionServiceImpl underTest;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void itShouldReturnAll() throws RuntimeException {
        given(attentionRepository.findById(1L)).willReturn(Optional.of(Mockito.mock(Attention.class)));

        underTest.getAll();

        then(repository).should().findAll();
    }

    @Test
    public void itShouldSaveUserAttention() throws RuntimeException {

        /*CreateUserAttentionDTO createUserAttentionDTO = Mockito.mock(CreateUserAttentionDTO.class);
        UserAttention userAttention = Mockito.mock(UserAttention.class);

        given(attentionRepository.findById(1L)).willReturn(Optional.of(Mockito.mock(Attention.class)));

        underTest.create(createUserAttentionDTO);

        then(repository).should().save(userAttention);*/

    }

}
