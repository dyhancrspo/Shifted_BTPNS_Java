package org.example.springrestapi.controller;

import com.google.gson.Gson;
import org.example.database.entities.Mahasiswa;
import org.example.springrestapi.SpringBootRestMahasiswaMain;
import org.example.springrestapi.rabbitmq.SendMqRestAPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class RestAPIController {
    public final Logger logger = LoggerFactory.getLogger(SpringBootRestMahasiswaMain.class);

    //--------------------------Create Mahasiswa-------------------------------------
    @RequestMapping(value = "/mahasiswa/", method = RequestMethod.POST)
    public ResponseEntity<?> createMhs(@RequestBody Mahasiswa mahasiswa) {
        try {
            SendMqRestAPI.addMahasiswa(new Gson().toJson(mahasiswa));
        }catch (Exception e){
            System.out.println("ERROR on RestApiController -create :  " + e);
        }
        return new ResponseEntity<>("Success, data created! ", HttpStatus.OK);
    }

    //--------------------------Update Mahasiswa-------------------------------------
    @RequestMapping(value = "/mahasiswa/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMhs(@PathVariable("id") Long id, @RequestBody Mahasiswa mahasiswa) {
        mahasiswa.setId(id);
        try {
            SendMqRestAPI.updateMahasiswa(new Gson().toJson(mahasiswa));
        }catch (Exception e){
            System.out.println("ERROR on RestApiController -update :  " + e);
        }
        return new ResponseEntity<>("Success, data updated! ", HttpStatus.OK);
    }

    //--------------------------Do Absensi Mahasiswa-------------------------------------
    @RequestMapping(value = "/mahasiswa/{id}/absensi", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMhs(@PathVariable("id") Long id) {
        try {
            SendMqRestAPI.absensiMahasiswa(Long.toString(id));
        }catch (Exception e){
            System.out.println("ERROR on RestApiController -absensi :  " + e);
        }
        return new ResponseEntity<>("Success, Add Attendance! ", HttpStatus.OK);
    }



}
