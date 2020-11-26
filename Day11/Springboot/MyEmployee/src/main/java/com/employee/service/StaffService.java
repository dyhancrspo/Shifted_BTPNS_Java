package com.employee.service;

import com.employee.model.Staff;
import java.util.*;

//Define Interface Method dari Class Inrerface StaffService
public interface StaffService {
    Staff findById (long id);

    Staff findByName(String name);

    void saveStaff(Staff staff);

    void updateStaff(Staff staff);

    void deleteStaffById(long id);

    List<Staff> findAllStaffs();

    void deleteAllStaffs();

    boolean isStaffExist(Staff staff);
}
