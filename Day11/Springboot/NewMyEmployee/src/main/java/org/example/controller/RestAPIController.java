package org.example.controller;


import javafx.scene.chart.StackedAreaChart;
import org.example.model.Staff;
import org.example.service.StaffService;
import org.example.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api") //Mapping Rest Url localhost:8080/api/
public class RestAPIController {
    //Inisialisasi logger untuk send response api
    public static final Logger logger = LoggerFactory.getLogger(RestAPIController.class);

    @Autowired
    StaffService staffService; //Service which will do all data retrieval/manipulation work

    // -------------------Retrieve All Staffs--------------------------------------------
    @RequestMapping(value = "/staff/", method = RequestMethod.GET) //Mapping url localhost:8080/api/staff/ dengan method GET
    public ResponseEntity<?> listAllStaff() { // Represents the entire HTTP response.
        ArrayList<Staff> staffs = staffService.findAllStaff(); //Invoke method findAllStaffs
        if (staffs.isEmpty()) { //Check kondisi
            return new ResponseEntity<>(staffs, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }


    // -------------------Retrieve Single Staff------------------------------------------
    @RequestMapping(value = "/staff/{IDKaryawan}", method = RequestMethod.GET) //Mapping url localhost:8080/api/staff/id dengan method GET
    public ResponseEntity<?> getStaff(@PathVariable("IDKaryawan") long IDKaryawan) {
        logger.info("Fetching staff with ID {}", IDKaryawan);
        Staff staffs = staffService.findById(IDKaryawan);

        if (staffs == null) {
            logger.error("Staff with id {} not found.", IDKaryawan);
            return new ResponseEntity<>(new CustomErrorType("Staff with id " + IDKaryawan  + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }


    // -------------------------Create Staff--------------------------
    @RequestMapping(value = "/staff/", method = RequestMethod.POST) //Mapping url localhost:8080/api/staff/ dengan method POST
    public ResponseEntity<?> newStaff(@RequestBody Staff staffs) {
        logger.info("Creating Staff : {}", staffs);
        if (staffService.isStaffExist(staffs)) {
            logger.error("Unable to create. A Staff with name {} already exist", staffs.getNama());
            return new ResponseEntity<>(new CustomErrorType("Unable to create. A Staff with name " +
                    staffs.getNama() + " already exist."), HttpStatus.CONFLICT);
        }
        staffService.saveStaff(staffs);
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }


    // -------------------------- Update Staff --------------------------
    @RequestMapping(value = "/staff/{IDKaryawan}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateStaff(@PathVariable("IDKaryawan") long IDKaryawan, @RequestBody Staff staffs) {
        logger.info("Updating Staff with id {}", IDKaryawan);
        Staff currentStaff = staffService.findById(IDKaryawan); // get target id
        if (currentStaff == null) { // Check Kondisi
            logger.error("Unable to update. Staff with id {} not found.", IDKaryawan);
            return new ResponseEntity<>(new CustomErrorType("Unable to upate. Staff with id " + IDKaryawan + " not found."), HttpStatus.NOT_FOUND);
        }
        //Set Atribut apabila currentStaff != null
        currentStaff.setNama(staffs.getNama());
        currentStaff.setEmail(staffs.getEmail());
        currentStaff.setTunjanganPulsa(staffs.getTunjanganPulsa());
        currentStaff.setGaji(staffs.getGaji());
        currentStaff.setTunjanganMakan(staffs.getTunjanganMakan());
        currentStaff.setAbsensi(staffs.getAbsensi());

        staffService.updateStaff(currentStaff);
        return new ResponseEntity<>(currentStaff, HttpStatus.OK);
    }


    // ------------------- Delete a Staff by Id-----------------------------------------
    @RequestMapping(value = "/staff/{IDKaryawan}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletebyID(@PathVariable("IDKaryawan") long IDKaryawan) {
        logger.info("Fetching and deleting staff with ID {}", IDKaryawan);

        Staff staffs = staffService.findById(IDKaryawan);
        if (staffs == null) {
            logger.info("Unable to delete. Staff with id {} not found.", IDKaryawan);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. Staff with id " + IDKaryawan + " not found."), HttpStatus.NOT_FOUND);
        }
        staffService.deletStaffById(IDKaryawan);
        return new ResponseEntity<Staff>(HttpStatus.NO_CONTENT);
    }


    // -------------------------- Deleete All Staff --------------------------
    @RequestMapping(value = "/staff/", method = RequestMethod.DELETE)
    public ResponseEntity<Staff> deleteAllStaff() {
        logger.info("Deleting All Staff");
        staffService.deletAll();
        return new ResponseEntity<Staff>(HttpStatus.NO_CONTENT);
    }
}
