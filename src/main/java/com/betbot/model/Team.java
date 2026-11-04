package com.betbot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private UUID teamId;
    private String teamName;
}
