package org.example.service;

import org.example.model.Mahasiswa;
import org.example.model.DetailMahasiswa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Service;



import java.util.List;


@Service("mahasiswaService")
public class MahasiswaServiceImpl implements MahasiswaService {
    @Autowired
    JdbcTemplate jdbc;

    @Qualifier("Mahasiswa")  // Test NamedParameterJdbcTemplate

    @Override
    public List<Mahasiswa> findAllMahasiswa() {
        return jdbc.query(
                "select * from header",
                (rs, rowNum) ->
                        new Mahasiswa(
                                rs.getLong("idMhs"),
                                rs.getString("fullname"),
                                rs.getString("address"),
                                rs.getString("status"),
                                rs.getInt("absensi")
                        )
        );
    }

    @Override
    public List<Mahasiswa> findMahasiswaByName(String name) {
        return jdbc.query(
                "select * from header where fullname = '" + name + "'",
                (rs, rowNum) ->
                        new Mahasiswa(
                                rs.getLong("idMhs"),
                                rs.getString("fullname"),
                                rs.getString("address"),
                                rs.getString("status"),
                                rs.getInt("absensi")
                        )
        );
    }

    public List<DetailMahasiswa> findAllDetail() {
        return jdbc.query(
                "select * from detail",
                (rs, rowNum) ->
                        new DetailMahasiswa(
                                rs.getLong("iddetail"),
                                rs.getLong("idmhs"),
                                rs.getInt("physics"),
                                rs.getInt("calculus"),
                                rs.getInt("biology")
                        )
        );
    }

    @Override
    public List<DetailMahasiswa> findByIdDetail(long idMhs) {
        return jdbc.query(
                "select * from detail where idmhs = " + idMhs + "",
                (rs, rowNum) ->
                        new DetailMahasiswa(
                                rs.getLong("iddetail"),
                                rs.getLong("idmhs"),
                                rs.getInt("physics"),
                                rs.getInt("calculus"),
                                rs.getInt("biology")
                        )
        );
    }

    @Override
    public int saveMahasiswa(Mahasiswa mhs) {
        return jdbc.update(
                "insert into header (idmhs, fullname, address, status, absensi) values(?,?,?,?,?)",
                null, mhs.getFullname(), mhs.getAddress(), mhs.getStatus(), mhs.getAbsensi()
        );
    }

    @Override
    public int saveDetailMahasiswa(DetailMahasiswa detail, long idMhs) {
        return jdbc.update(
                "insert into detail (iddetail, idmhs, physics, calculus, biology) values(?,?,?,?,?)",
                null, idMhs, detail.getPhysics(), detail.getCalculus(), detail.getBiology());
    }


    @Override
    public int updateMahasiswa(Mahasiswa mhs) {
        return jdbc.update(
                "update header set fullname=? , address=?, status =?, absensi=? where idmhs = ?",
                mhs.getFullname(), mhs.getAddress(), mhs.getStatus(), mhs.getAbsensi(), mhs.getId());
    }

    @Override
    public int updateDetailMahasiswa(DetailMahasiswa detail) {
        return jdbc.update(
                "update detail set physics=? ,calculus = ?,biology = ? where idmhs = ?",
                detail.getPhysics(), detail.getCalculus(), detail.getBiology(), detail.getIdMhs());
    }

    @Override
    public int tambahAbsensi(long id) {
        return jdbc.update(
                "update header set absensi = absensi+1 where idMhs = ?",
                id);
    }

    @Override
    public List<Mahasiswa> findById(long id) {
        return jdbc.query(
                "select * from header where idMhs=" + id + "",
                (rs, rowNum) ->
                        new Mahasiswa(
                                rs.getLong("idMhs"),
                                rs.getString("fullname"),
                                rs.getString("address"),
                                rs.getString("status"),
                                rs.getInt("absensi")
                        )
        );
    }

    @Override
    public boolean isMahasiswaExist(Mahasiswa mhs) {
        List<Mahasiswa> dataMhs = jdbc.query(
                "Select * from detail where idMhs='" + mhs.getId() + "'",
                new BeanPropertyRowMapper(Mahasiswa.class));

        if (dataMhs.size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isDetailExist(DetailMahasiswa detail) {
        List<DetailMahasiswa> dataMhs = jdbc.query(
                "Select * from detail where idMhs='" + detail.getIdMhs() + "'",
                new BeanPropertyRowMapper(DetailMahasiswa.class));
        if (dataMhs.size() != 0) {
            return true;
        } else {
            return false;
        }
    }
}