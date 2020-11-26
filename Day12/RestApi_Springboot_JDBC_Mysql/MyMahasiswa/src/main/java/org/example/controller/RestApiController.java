package org.example.controller;


import org.example.model.Mahasiswa;
import org.example.model.DetailMahasiswa;
import org.example.service.MahasiswaService;
import org.example.util.CustomErrorType;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


//controller with mapping "/api"
@RestController
@RequestMapping("/api")
public class RestApiController {
    //Instance logger
    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    MahasiswaService mhsService; //Service which will do all data retrieval/manipulation work

    // -------------------Retrieve All Mahasiswa--------------------------------------------
    @RequestMapping(value = "/mahasiswa/", method = RequestMethod.GET)
    public ResponseEntity<List<Mahasiswa>> listAllMhs() {
        List<Mahasiswa> mhs = mhsService.findAllMahasiswa();
        if (mhs.isEmpty()) {
            return new ResponseEntity<>(mhs, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mhs, HttpStatus.OK);
    }

    // -------------------Retrieve Single Mahasiswa------------------------------------------
    @RequestMapping(value = "/mahasiswa/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMhs(@PathVariable("id") Long id) {
        logger.info("Fetching Mahasiswa with id {}", id);
        List<Mahasiswa> mhs = mhsService.findById(id);
        if (mhs == null) {
            logger.error("Mahasiswa with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Mahasiswa with id " + id  + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mhs, HttpStatus.OK);
    }

    // -------------------Retrieve Single Detail-------------------------------------------
    @RequestMapping(value = "/mahasiswa/{id}/detail", method = RequestMethod.GET)
    public ResponseEntity<?> detailNilaiMhs(@PathVariable("id") Long id) {
        logger.info("Fetching Detail with id Mhs {}", id);
        List<DetailMahasiswa> detail = mhsService.findByIdDetail(id);
        return new ResponseEntity<>(detail, HttpStatus.CREATED);
    }

    // -------------------Create Mahasiswa-------------------------------------------
    @RequestMapping(value = "/mahasiswa/", method = RequestMethod.POST)
    public ResponseEntity<?> createMhs(@RequestBody Mahasiswa mhs) {
        logger.info("Creating Mahasiswa : {}", mhs);
        if (mhsService.isMahasiswaExist(mhs)) {
            logger.error("Unable to create. A Mahasiswa with name {} already exist", mhs.getFullname());
            return new ResponseEntity<>(new CustomErrorType("Unable to create. A Mahasiswa with name " +
                    mhs.getFullname() + " already exist."), HttpStatus.CONFLICT);
        }
        mhsService.saveMahasiswa(mhs);
        return new ResponseEntity<>(mhs, HttpStatus.CREATED);
    }

    // -------------------Create Detail Mahasiswa-------------------------------------------
    @RequestMapping(value = "/mahasiswa/{id}/detail/add", method = RequestMethod.POST)
    public ResponseEntity<?> createMhs(@PathVariable("id") Long id,@RequestBody DetailMahasiswa mhs) {
        logger.info("Creating Mahasiswa : {}", mhs);
        mhsService.saveDetailMahasiswa(mhs,id);
        return new ResponseEntity<>(mhs, HttpStatus.CREATED);
    }

    // ------------------- Update Mahasiswa ------------------------------------------------
    @RequestMapping(value = "/mahasiswa/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMhsApi(@PathVariable("id") Long id, @RequestBody Mahasiswa mhs) {
        logger.info("Updating Mahasiswa with id {}", id);
        List<Mahasiswa> currentMhs = mhsService.findById(id);
        if (currentMhs == null) {
            logger.error("Unable to update. Mahasiswa with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to upate. Mahasiswa with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        for (Mahasiswa obj: currentMhs ){
            obj.setFullname(mhs.getFullname());
            obj.setAddress(mhs.getAddress());
            obj.setStatus(mhs.getStatus());
            obj.setAbsensi(mhs.getAbsensi());
            mhsService.updateMahasiswa(obj);
        }
        return new ResponseEntity<>(currentMhs, HttpStatus.OK);
    }


    // ------------------- Update Detail Mahasiswaa------------------------------------------------
    @RequestMapping(value = "/mahasiswa/{id}/detail/edit", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMhs(@PathVariable("id") Long id, @RequestBody DetailMahasiswa mhs) {
        logger.info("Updating Mahasiswa with id {}", id);
        List<DetailMahasiswa> currentDetail = mhsService.findByIdDetail(id);
        if (currentDetail == null) {
            logger.error("Unable to update. Mahasiswa with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to update. Mahasiswa with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        for (DetailMahasiswa obj: currentDetail ){
            obj.setPhysics(mhs.getPhysics());
            obj.setCalculus(mhs.getCalculus());
            obj.setBiology(mhs.getBiology());
            mhsService.updateDetailMahasiswa(obj);
        }
        return new ResponseEntity<>(currentDetail, HttpStatus.OK);
    }


    // ------------------- Update Mahasiswa Absensi / Tambah Absensi ------------------------------------------------
    @RequestMapping(value = "/mahasiswa/{id}/tambahabsensi", method = RequestMethod.PUT)
    public ResponseEntity<?> tambahabsenMhs(@PathVariable("id") Long id) {
        logger.info("Updating Mahasiswa with id {}", id);
        List<Mahasiswa> currentMhs = mhsService.findById(id);
        if (currentMhs == null) {
            logger.error("Unable to update. Mahasiswa with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to upate. Mahasiswa with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        mhsService.tambahAbsensi(id);
        return new ResponseEntity<>(currentMhs, HttpStatus.OK);
    }



}
