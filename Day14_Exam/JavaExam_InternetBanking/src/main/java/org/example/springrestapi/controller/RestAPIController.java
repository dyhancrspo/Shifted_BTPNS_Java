package org.example.springrestapi.controller;

import com.google.gson.Gson;
import org.example.database.entities.Nasabah;
import org.example.springrestapi.SpringbootDummyBankMain;
import org.example.springrestapi.rabbitmq.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/dummybank/api")

public class RestAPIController {
    public final RecvMqRestAPI restApiReceive = new RecvMqRestAPI();
    public final Logger logger = LoggerFactory.getLogger(SpringbootDummyBankMain.class);

    //--------------------------Get All Nasabah-------------------------------------
    @RequestMapping(value = "/nasabah/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllNsb() throws IOException, TimeoutException {
        SendMqRestAPI.getAll();
        restApiReceive.receiveFromDatabase();
        return new ResponseEntity<>(restApiReceive.getMessage(), HttpStatus.OK);
    }

    //--------------------------Create Mahasiswa-------------------------------------
    @RequestMapping(value = "/nasabah/", method = RequestMethod.POST)
    public ResponseEntity<?> createNsb(@RequestBody Nasabah nasabah) {
        try {
            SendMqRestAPI.addNasabah(new Gson().toJson(nasabah));
            restApiReceive.receiveFromDatabase();
        }catch (Exception e){
            System.out.println("ERROR on RestApiController -create :  " + e);
        }
        return new ResponseEntity<>("Success, data created! \n", HttpStatus.OK);
    }

    //--------------------------Update Data Nasabah-------------------------------------
    @RequestMapping(value = "/nasabah/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateNsb(@PathVariable("id") Long id, @RequestBody Nasabah nasabah) {
        nasabah.setId(id);
        try {
            SendMqRestAPI.updateNasabah(new Gson().toJson(nasabah));
        }catch (Exception e){
            System.out.println("ERROR on RestApiController -update :  " + e);
        }
        return new ResponseEntity<>("Success, data updated! ", HttpStatus.OK);
    }

    //--------------------------Find Data Nasabah by Id-------------------------------------
    @RequestMapping(value = "/nasabah/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findNsb(@PathVariable("id") Long id) {
        try {
            SendMqRestAPI.findDataById(Long.toString(id));
            restApiReceive.receiveFromDatabase();
        }catch (Exception e){
            System.out.println("ERROR on RestApiController -findbyid :  " + e);
        }
        return new ResponseEntity<>(restApiReceive.getMessage(), HttpStatus.OK);    }


    //--------------------------Delete Data Nasabah by Id-------------------------------------
    @RequestMapping(value = "/nasabah/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteNsb(@PathVariable("id") Long id) {
        try {
            SendMqRestAPI.deleteNasabahById(Long.toString(id));
        }catch (Exception e){
            System.out.println("ERROR on RestApiController -deletebyid :  " + e);
        }
        return new ResponseEntity<>("Data deleted!!! ", HttpStatus.OK);
    }

    //--------------------------Do Login Nasabah-------------------------------------
    @RequestMapping(value = "/nasabah/login/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> loginNsb(@PathVariable("id") Long id) {
        try {
            SendMqRestAPI.loginNasabah(Long.toString(id));
        }catch (Exception e){
            System.out.println("ERROR on RestApiController -login :  " + e);
        }
        return new ResponseEntity<>("Login Success, Welcome to Dummy Bank! ", HttpStatus.OK);
    }

    //--------------------------Do Logout Nasabah-------------------------------------
    @RequestMapping(value = "/nasabah/logout/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> logutNsb(@PathVariable("id") Long id) {
        try {
            SendMqRestAPI.logoutNasabah(Long.toString(id));
        }catch (Exception e){
            System.out.println("ERROR on RestApiController -login :  " + e);
        }
        return new ResponseEntity<>("Logout Success, \nHave a Nice Day, Enjoy banking with Dummy Bank! ", HttpStatus.OK);
    }


}
