package com.betbot.model;


import com.betbot.factory.UserState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long chatId;
    private String locale;
    private String firstName;
    @Enumerated(EnumType.STRING)
    private UserState status;
    private int balance;
    //userstate
    //state
    //referall

}
