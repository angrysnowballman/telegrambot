package com.betbot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long firstId;
    private String firstTeamName;
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long secondtId;
    private String secondTeamName;
    private
}
