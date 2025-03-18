package com.example.demo.dto;

import java.util.Date;

public record  TrainingSessionDTO(Date start, Date end, String roomName, int roomCapacity) {
    public Date getStart() {
        return start;
    }
    public Date getEnd() {
        return end;
    }
}