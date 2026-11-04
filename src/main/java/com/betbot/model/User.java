package com.betbot.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.betbot.factory.UserState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@Builder
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String email;
    private String fullName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordHash;
    private Instant createAt;
    @Column(unique = true)
    private Long telegramChatId; // ID чата в Telegram
    private String telegramUsername;
    private BigDecimal balance; // баланс для ставок
    @Enumerated(EnumType.STRING)
    private UserState status;


    @PrePersist
    void prePersist(){
        if(this.createAt == null) this.createAt = Instant.now();
    }
}