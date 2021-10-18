package com.solvd.laba.service;

import com.solvd.laba.binary.RegistrationCard;
import com.solvd.laba.binary.Visitor;

public interface IRegistrationCardService {
    RegistrationCard createRegCardForNewVisitorByConsole(int newRegCardId, Visitor newVisitor);
}
