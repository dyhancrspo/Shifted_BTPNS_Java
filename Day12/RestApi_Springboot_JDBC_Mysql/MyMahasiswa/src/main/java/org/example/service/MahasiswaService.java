package org.example.service;

import org.example.model.DetailMahasiswa;
import org.example.model.Mahasiswa;
import java.util.*;

public interface MahasiswaService {

    int saveMahasiswa(Mahasiswa mahasiswa);

    int saveDetailMahasiswa(DetailMahasiswa detail, long idMhs);

    int updateMahasiswa(Mahasiswa mahasiswa);

    int updateDetailMahasiswa(DetailMahasiswa detail);

    int tambahAbsensi(long id);

    List<Mahasiswa> findById(long id);

    List<Mahasiswa> findAllMahasiswa();

    List<Mahasiswa> findMahasiswaByName(String name);

    List<DetailMahasiswa> findAllDetail();

    List<DetailMahasiswa> findByIdDetail(long idMhs);

    boolean isMahasiswaExist(Mahasiswa mahasiswa);

    boolean isDetailExist(DetailMahasiswa detail);

}
