package com.rapisolver.attention.services.impl;

import com.rapisolver.attention.dtos.CreateScoreDTO;
import com.rapisolver.attention.dtos.ScoreDTO;
import com.rapisolver.attention.entities.Score;
import com.rapisolver.attention.entities.UserAttention;
import com.rapisolver.attention.exceptions.InternalServerErrorException;
import com.rapisolver.attention.exceptions.NotFoundException;
import com.rapisolver.attention.repository.ScoreRepository;
import com.rapisolver.attention.repository.UserAttentionRepository;
import com.rapisolver.attention.services.ScoreService;
import com.rapisolver.attention.util.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserAttentionRepository userAttentionRepository;

    @Autowired
    private ScoreRepository repository;

    @Transactional
    @Override
    public ScoreDTO create(CreateScoreDTO t) throws RuntimeException {
        UserAttention userAttentionDB = userAttentionRepository.findById(t.getUserAttentionId()).orElseThrow(() -> new NotFoundException("USER_ATTENTION_NOT_FOUND"));

        try {
            Score score = new Score();
            score.setMark(t.getMark());
            score.setNote(t.getNote());
            score.setStatus(Status.CREATED);
            score.setCreatedAt(new Date());
            score.setUserAttention(userAttentionDB);
            score = repository.save(score);
            return mapper.map(score, ScoreDTO.class);
        } catch (Exception e) {
            throw new InternalServerErrorException("CREATE_SCORE_ERROR");
        }
    }

    @Override
    public List<ScoreDTO> getAll() throws RuntimeException {
        List<Score> scores = repository.findAll();
        return scores.stream().map(s -> mapper.map(s, ScoreDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ScoreDTO getById(Long aLong) throws RuntimeException {
        Score scoreDB = repository.findById(aLong).orElseThrow(() -> new NotFoundException("SCORE_NOT_FOUND"));
        return mapper.map(scoreDB, ScoreDTO.class);
    }

    @Transactional
    @Override
    public ScoreDTO update(Long aLong, CreateScoreDTO t) throws RuntimeException {
        UserAttention userAttentionDB = userAttentionRepository.findById(t.getUserAttentionId()).orElseThrow(() -> new NotFoundException("USER_ATTENTION_NOT_FOUND"));
        Score scoreDB = repository.findById(aLong).orElseThrow(() -> new NotFoundException("SCORE_NOT_FOUND"));

        try {
            scoreDB.setMark(t.getMark());
            scoreDB.setNote(t.getNote());
            scoreDB.setUserAttention(userAttentionDB);
            scoreDB.setStatus(Status.UPDATED);
            scoreDB = repository.save(scoreDB);
            return mapper.map(scoreDB, ScoreDTO.class);
        } catch (Exception e) {
            throw new InternalServerErrorException("UPDATE_SCORE_ERROR");
        }
    }

    @Transactional
    @Override
    public String deleteById(Long aLong) throws RuntimeException {
        Score scoreDB = repository.findById(aLong).orElseThrow(() -> new NotFoundException("SCORE_NOT_FOUND"));

        try {
            scoreDB.setStatus(Status.DELETED);
            repository.save(scoreDB);
            return "Calificacion eliminada correctamente";
        } catch (Exception e) {
            throw new InternalServerErrorException("DELETE_SCORE_ERROR");
        }
    }
}
