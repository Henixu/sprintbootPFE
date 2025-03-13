package com.example.demo.dto;

import java.util.Date;

public record  TrainingSessionDTO(Date start, Date end) {
    public Date getStart() {
        return start;
    }
    public Date getEnd() {
        return end;
    }
}