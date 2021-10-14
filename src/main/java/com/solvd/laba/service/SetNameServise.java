package com.solvd.laba.service;

public interface SetNameServise <T, U> {
    T getCCName(U id);
    T setCCName(U id);
    T getCCSurname(U id);
    T setCCSurname(U id);
    T getCCPatronymic(U id);
    T setCCPatronymic(U id);
}
