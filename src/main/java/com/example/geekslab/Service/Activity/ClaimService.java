package com.example.geekslab.Service.Activity;

import com.example.geekslab.Entite.Article;
import com.example.geekslab.Entite.Claim;
import com.example.geekslab.Entite.Useer;
import com.example.geekslab.IService.IClaimService;
import com.example.geekslab.Repository.ActivityRepo.ClaimRepository;
import com.example.geekslab.Repository.UseerRepo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;


import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
@AllArgsConstructor
public class ClaimService implements IClaimService {


    ClaimRepository repo;
    UserRepository repuser;

    @Override
    public List<Claim> GetallClaims() {
        return repo.findAll();
    }

    @Override
    public Claim AddClaim(Claim claim) {
        return repo.save(claim);
    }

    @Override
    public Claim findClaimById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }
@Override
    public Claim updateClaim(Long id, Claim claim) {

        Claim oldclaim = repo.findById(id).orElse(null);
    if (oldclaim == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Claim not found with id " + id);
    }

        oldclaim.setDescription(oldclaim.getDescription());
        oldclaim.setStatus(oldclaim.getStatus());
        return repo.save(oldclaim);
    }


    @Override
    public Question addAnswerToQuestion(Long questionId, Long answerId){

        Answer answer = answerRepository.findById(answerId)
                .orElse(null);

        Question question = questionRepository.findById(questionId)
                .orElse(null);

        if (question.getAnswers().contains(answer)) {
            throw new IllegalArgumentException("answer already exists in Question");
        }

        question.addAnswer(answer);
        return questionRepository.save(question);
    }
    public void addClaimToUser(Long userId, Long idClaim) {

        Claim claim = repo.findById(idClaim)
                .orElseThrow(() -> new EntityNotFoundException("Claim Not Found"));

        Useer user = repuser.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Claim Not Found"));

        if (user.getClaim().contains(claim)) {
            throw new IllegalArgumentException("  already exists  ");
        }

      user.AddClaim(claim);

        user.getClaims().add(claim);

        userRepository.save(user);
    }
}
