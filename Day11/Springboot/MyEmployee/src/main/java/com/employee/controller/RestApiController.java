package com.employee.controller;

import com.employee.model.Staff;
import com.employee.service.StaffService;
import com.employee.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.sql.*;

@RestController
@RequestMapping("/api") //Mapping Rest Url localhost:8080/api/
public class RestApiController {

    //Inisialisasi logger untuk send response api
    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    StaffService staffService; //Service which will do all data retrieval/manipulation work

    // -------------------Retrieve All Staffs--------------------------------------------
    @RequestMapping(value = "/staff/", method = RequestMethod.GET) //Mapping url localhost:8080/api/staff/ dengan method GET
    public ResponseEntity<List<Staff>> listAllStaffs() {
        List<Staff> staffs = staffService.findAllStaffs(); //Invoke method findAllStaffs
        if (staffs.isEmpty()) { //Check kondisi
            return new ResponseEntity<>(staffs, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }

    // -------------------Retrieve Single Staff------------------------------------------
    @RequestMapping(value = "/staff/{id}", method = RequestMethod.GET) //Mapping url localhost:8080/api/staff/id dengan method GET
    public ResponseEntity<?> getStaff(@PathVariable("id") long id) {
        logger.info("Fetching Staff with id {}", id);
        Staff staff = staffService.findById(id); //get target id
        if (staff == null) { //check kondisi
            logger.error("Staff with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Staff with id " + id  + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    // -------------------Create a Staff-------------------------------------------
    @RequestMapping(value = "/staff/", method = RequestMethod.POST) //Mapping url localhost:8080/api/staff/ dengan method POST
    public ResponseEntity<?> createStaff(@RequestBody Staff staff) {
        logger.info("Creating Staff : {}", staff);
        if (staffService.isStaffExist(staff)) { //Check kondisi dengan menginvoke method isStaffExist
            logger.error("Unable to create. A Staff with name {} already exist", staff.getNama());
            return new ResponseEntity<>(new CustomErrorType("Unable to create. A Staff with name " +
                    staff.getNama() + " already exist."), HttpStatus.CONFLICT);
        }
        // jika isStaffExist = false
        staffService.saveStaff(staff); //invoke method saveStaff dengan params staff
        return new ResponseEntity<>(staff, HttpStatus.CREATED);
    }

    // ------------------- Update a Staff ------------------------------------------------
    @RequestMapping(value = "/staff/{id}", method = RequestMethod.PUT) //Mapping url localhost:8080/api/staff/id dengan method PUT
    public ResponseEntity<?> updateStaff(@PathVariable("id") long id, @RequestBody Staff staff) {
        logger.info("Updating Staff with id {}", id);
        Staff currentStaff = staffService.findById(id); // get target id
        if (currentStaff == null) { // Check Kondisi
            logger.error("Unable to update. Staff with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to upate. Staff with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        //Set Atribut apabila currentStaff != null
        currentStaff.setNama(staff.getNama());
        currentStaff.setJabatan(staff.getJabatan());
        currentStaff.setAbsensi(staff.getAbsensi());
        currentStaff.setGaji(staff.getGaji());
        currentStaff.setTunjanganPulsa(staff.getTunjanganPulsa());
        currentStaff.setTunjanganMakan(staff.getTunjanganMakan());
        currentStaff.setEmailsStaff(staff.getEmailsStaff());

        staffService.updateStaff(currentStaff); // invoke method updateStaff dengan params currentStaff
        return new ResponseEntity<>(currentStaff, HttpStatus.OK); // send response
    }

    // ------------------- Delete a Staff-----------------------------------------
    @RequestMapping(value = "/staff/{id}", method = RequestMethod.DELETE) //Mapping url localhost:8080/api/staff/id dengan method DELETE
    public ResponseEntity<?> deleteStaff(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Staff with id {}", id);
        Staff staff = staffService.findById(id); //get target id
        if (staff == null) { //Check konidisi
            logger.error("Unable to delete. Staff with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. Staff with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        // Apabali staff != null
        staffService.deleteStaffById(id); // invoke method deleteStaffById dengan paramater id
        return new ResponseEntity<Staff>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All Staff-----------------------------
    @RequestMapping(value = "/staff/", method = RequestMethod.DELETE) //Mapping url localhost:8080/api/staff/ dengan method DELETE
    public ResponseEntity<Staff> deleteAllStaffs() {
        logger.info("Deleting All Staff");
        staffService.deleteAllStaffs(); // invoke method deleteAllStaffs
        return new ResponseEntity<Staff>(HttpStatus.NO_CONTENT);
    }

}