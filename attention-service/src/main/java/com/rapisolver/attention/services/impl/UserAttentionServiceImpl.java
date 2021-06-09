package com.rapisolver.attention.services.impl;

import com.rapisolver.attention.client.UserClient;
import com.rapisolver.attention.dtos.CreateUserAttentionDTO;
import com.rapisolver.attention.dtos.UserAttentionDTO;
import com.rapisolver.attention.entities.Attention;
import com.rapisolver.attention.entities.UserAttention;
import com.rapisolver.attention.exceptions.BadRequestException;
import com.rapisolver.attention.exceptions.InternalServerErrorException;
import com.rapisolver.attention.exceptions.NotFoundException;
import com.rapisolver.attention.models.UserDTO;
import com.rapisolver.attention.repository.AttentionRepository;
import com.rapisolver.attention.repository.UserAttentionRepository;
import com.rapisolver.attention.services.UserAttentionService;
import com.rapisolver.attention.util.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAttentionServiceImpl implements UserAttentionService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserClient userClient;

    @Autowired
    private AttentionRepository attentionRepository;

    @Autowired
    private UserAttentionRepository repository;

    @Transactional
    @Override
    public UserAttentionDTO create(CreateUserAttentionDTO t) throws RuntimeException {

        if (!userClient.getUser(t.getUserId()).getData().getRole().isCanPublish()) throw new BadRequestException("El usuario no es un proveedor");

        Attention attentionDB = attentionRepository.findById(t.getAttentionId()).orElseThrow(() -> new NotFoundException("ATTENTION_NOT_FOUND"));

        try {
            UserAttention userAttention = new UserAttention();
            userAttention.setDetail(t.getDetail());
            userAttention.setPrice(t.getPrice());
            userAttention.setAttention(attentionDB);
            userAttention.setStatus(Status.CREATED);
            userAttention.setUserId(t.getUserId());
            userAttention.setCreatedAt(new Date());
            userAttention = repository.save(userAttention);
            return mapper.map(userAttention, UserAttentionDTO.class);
        } catch (Exception e) {
            throw new InternalServerErrorException("CREATE_USER_ATTENTION_ERROR");
        }
    }

    @Override
    public List<UserAttentionDTO> getAll() throws RuntimeException {
        List<UserAttention> userAttentions = repository.findAll();
        return userAttentions.stream().map(u -> mapper.map(u, UserAttentionDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserAttentionDTO getById(Long aLong) throws RuntimeException {
        UserAttention userAttentionDB = repository.findById(aLong).orElseThrow(() -> new NotFoundException("USER_ATTENTION_NOT_FOUND"));
        return mapper.map(userAttentionDB, UserAttentionDTO.class);
    }

    @Transactional
    @Override
    public UserAttentionDTO update(Long aLong, CreateUserAttentionDTO t) throws RuntimeException {
        Attention attentionDB = attentionRepository.findById(t.getAttentionId()).orElseThrow(() -> new NotFoundException("ATTENTION_NOT_FOUND"));
        UserAttention userAttentionDB = repository.findById(aLong).orElseThrow(() -> new NotFoundException("USER_ATTENTION_NOT_FOUND"));

        try {
            userAttentionDB.setDetail(t.getDetail());
            userAttentionDB.setPrice(t.getPrice());
            userAttentionDB.setAttention(attentionDB);
            userAttentionDB.setStatus(Status.UPDATED);
            userAttentionDB = repository.save(userAttentionDB);
            return mapper.map(userAttentionDB, UserAttentionDTO.class);
        } catch (Exception e) {
            throw new InternalServerErrorException("UPDATE_USER_ATTENTION_ERROR");
        }
    }

    @Transactional
    @Override
    public String deleteById(Long aLong) throws RuntimeException {
        UserAttention userAttentionDB = repository.findById(aLong).orElseThrow(() -> new NotFoundException("USER_ATTENTION_NOT_FOUND"));

        try {
            userAttentionDB.setStatus(Status.DELETED);
            repository.save(userAttentionDB);
            return "Atencion del usuario eliminada correctamente";
        } catch (Exception e) {
            throw new InternalServerErrorException("DELETE_USER_ATTENTION_ERROR");
        }
    }
}
