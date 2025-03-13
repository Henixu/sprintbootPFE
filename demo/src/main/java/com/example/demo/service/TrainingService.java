package com.example.demo.service;

import com.example.demo.dto.TrainingCreateDTO;
import com.example.demo.model.Training;
import com.example.demo.model.User;
import com.example.demo.repository.TrainingRepository;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@AllArgsConstructor
@Service
public class TrainingService {
    private TrainingRepository trainingRepository;
    private UserRepository userRepository;

    public Training createTraining(TrainingCreateDTO dto) {
        if (trainingRepository.findByDate(dto.date()).isPresent()) {
            throw new RuntimeException("Training already exists on date: " + dto.date());
        }

        User admin = userRepository.findById(SecurityUtils.getCurrentUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Training training = new Training();
        training.setTitle(dto.title());
        training.setDescription(dto.description());
        training.setType(dto.type());
        training.setDate(dto.date());
        training.setDurationInHours(dto.durationInHours());
        training.setCreatedBy(admin);

        return trainingRepository.save(training);
    }
    // Update training by ID
    public Training updateTraining(Long id, TrainingCreateDTO dto) {
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Training not found with id: " + id));

        training.setTitle(dto.title());
        training.setDescription(dto.description());
        training.setType(dto.type());
        training.setDate(dto.date());
        training.setDurationInHours(dto.durationInHours());

        return trainingRepository.save(training);
    }


    // Delete training by ID
    public void deleteTraining(Long id) {
        Training training = trainingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Training not found with id: " + id));
        trainingRepository.delete(training);
    }
}
