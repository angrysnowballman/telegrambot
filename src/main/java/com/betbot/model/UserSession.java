package com.betbot.model;


import com.betbot.telegramm.bot.model.UserState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import java.util.Locale;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long chatId;
    private Long referralId;
    private Locale locale;
    private String firstName;
    @Enumerated(EnumType.STRING)
    // править
    private UserState userState;
    private int balance;
    //userstate
    //state
    //referall

}
