package com.solvd.laba.dao.interfases;

import com.solvd.laba.binary.Emploee;
import com.solvd.laba.dao.EntityDAO;

public interface EmploeeDAO extends EntityDAO<Emploee, Long> {
    static Emploee getById() {
        return null;
    }// extends IEntityDAO<Car>
}
