package com.example.demo.service;

import com.example.demo.dto.TrainingSessionDTO;
import com.example.demo.model.Room;
import com.example.demo.model.Training;
import com.example.demo.model.TrainingSession;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.TrainingRepository;
import com.example.demo.repository.TrainingSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingSessionService {

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private TrainingSessionRepository trainingSessionRepository;

    // Add RoomRepository here
    @Autowired
    private RoomRepository roomRepository;
    // Create a new session for a given training
    public TrainingSession createTrainingSession(Long trainingId, TrainingSessionDTO dto) {
        Training training = trainingRepository.findById(trainingId)
                .orElseThrow(() -> new RuntimeException("Training not found with id: " + trainingId));

        // Create and save the Room based on the DTO info
        Room room = new Room();
        room.setName(dto.roomName());
        room.setCapacity(dto.roomCapacity());
        roomRepository.save(room);


        TrainingSession session = new TrainingSession();
        session.setStart(dto.start());
        session.setEnd(dto.end());
        session.setTraining(training);
        session.setRoom(room);


        // Optionally add the session to the training's session list
        training.getSessions().add(session);

        return trainingSessionRepository.save(session);
    }

    // Update an existing session by its id
    public TrainingSession updateTrainingSession(Long sessionId, TrainingSessionDTO dto) {
        TrainingSession session = trainingSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found with id: " + sessionId));

        session.setStart(dto.start());
        session.setEnd(dto.end());

        return trainingSessionRepository.save(session);
    }

    // Delete a session by its id
    public void deleteTrainingSession(Long sessionId) {
        TrainingSession session = trainingSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found with id: " + sessionId));

        trainingSessionRepository.delete(session);
    }
}
