package com.rapisolver.attention.services.impl;

import com.rapisolver.attention.dtos.AttentionDTO;
import com.rapisolver.attention.dtos.CreateAttentionDTO;
import com.rapisolver.attention.entities.Attention;
import com.rapisolver.attention.entities.Category;
import com.rapisolver.attention.exceptions.InternalServerErrorException;
import com.rapisolver.attention.exceptions.NotFoundException;
import com.rapisolver.attention.repository.AttentionRepository;
import com.rapisolver.attention.repository.CategoryRepository;
import com.rapisolver.attention.services.AttentionService;
import com.rapisolver.attention.util.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttentionServiceImpl implements AttentionService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AttentionRepository attentionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    @Override
    public AttentionDTO create(CreateAttentionDTO t) throws RuntimeException {
        Category categoryDB = categoryRepository.findById(t.getCategoryId()).orElseThrow(() -> new NotFoundException("CATEGORY_NOT_FOUND"));

        try {
            Attention attention = new Attention();
            attention.setName(t.getName());
            attention.setCategory(categoryDB);
            attention.setStatus(Status.CREATED);
            attention.setCreatedAt(new Date());
            attention = attentionRepository.save(attention);
            return mapper.map(attention, AttentionDTO.class);
        } catch (Exception e) {
            throw new InternalServerErrorException("CREATE_ATTENTION_ERROR");
        }
    }

    @Override
    public List<AttentionDTO> getAll() throws RuntimeException {
        List<Attention> attentions = attentionRepository.findAll();
        return attentions.stream().map(a -> mapper.map(a, AttentionDTO.class)).collect(Collectors.toList());
    }

    @Override
    public AttentionDTO getById(Long id) throws RuntimeException {
        Attention attentionDB = attentionRepository.findById(id).orElseThrow(() -> new NotFoundException("ATTENTION_NOT_FOUND"));
        return mapper.map(attentionDB, AttentionDTO.class);
    }

    @Transactional
    @Override
    public AttentionDTO update(Long id, CreateAttentionDTO t) throws RuntimeException {
        Category categoryDB = categoryRepository.findById(t.getCategoryId()).orElseThrow(() -> new NotFoundException("CATEGORY_NOT_FOUND"));
        Attention attentionDB = attentionRepository.findById(id).orElseThrow(() -> new NotFoundException("ATTENTION_NOT_FOUND"));

        try {
            attentionDB.setName(t.getName());
            attentionDB.setCategory(categoryDB);
            attentionDB.setStatus(Status.UPDATED);
            attentionDB = attentionRepository.save(attentionDB);
            return mapper.map(attentionDB, AttentionDTO.class);
        } catch (Exception e) {
            throw new InternalServerErrorException("UPDATE_ATTENTION_ERROR");
        }
    }

    @Transactional
    @Override
    public String deleteById(Long id) throws RuntimeException {
        Attention attentionDB = attentionRepository.findById(id).orElseThrow(() -> new NotFoundException("Atencion a eliminar no encontrada"));

        try {
            attentionDB.setStatus(Status.DELETED);
            attentionRepository.save(attentionDB);
            return "Atencion eliminada correctamente";
        } catch (Exception e) {
            throw new InternalServerErrorException("DELETE_ATTENTION_ERROR");
        }
    }
}
