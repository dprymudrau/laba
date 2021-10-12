package com.solvd.laba.service.impl.jdbc;

import com.solvd.laba.binary.RegistrationCard;

public interface RegistrationCardService<T> {
    RegistrationCard findRegCardByVisitorId(T visitorId);
}
