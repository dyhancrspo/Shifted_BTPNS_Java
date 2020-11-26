package org.example.model;

public class DetailMahasiswa {
    long idDetail;
    long idMhs;
    int physics;
    int calculus;
    int biology;

    public DetailMahasiswa(long idDetail, long idMhs, int physics, int calculus, int biology ){
        setIdDetail(idDetail);
        setIdMhs(idMhs);
        setPhysics(physics);
        setCalculus(calculus);
        setBiology(biology);
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getCalculus() {
        return calculus;
    }

    public void setCalculus(int calculus) {
        this.calculus = calculus;
    }

    public int getBiology() {
        return biology;
    }

    public void setBiology(int biology) {
        this.biology = biology;
    }

    public long getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(long idDetail) {
        this.idDetail = idDetail;
    }

    public long getIdMhs() {
        return idMhs;
    }

    public void setIdMhs(long idMhs) {
        this.idMhs = idMhs;
    }

    @Override
    public String toString() {
        return "DetailMahasiswa{" +
                "idDetail=" + idDetail +
                ", idMhs=" + idMhs +
                ", physics=" + physics +
                ", calculus=" + calculus +
                ", biology=" + biology +
                '}';
    }
}
