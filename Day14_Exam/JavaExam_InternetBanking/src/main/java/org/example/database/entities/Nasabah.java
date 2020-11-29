package org.example.database.entities;


import javax.persistence.*;

@Entity
@Table(name = "dataNasabah")
public class Nasabah {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String fullname;
    String phonenumber;
    String username;
    String password;
    String status;
    Boolean isLogin = false;

    public Nasabah(){}

    public Nasabah(String fullname, String phonenumber, String username, String password, String status){
        setFullname(fullname);
        setPhonenumber(phonenumber);
        setUsername(username);
        setPassword(password);
        setStatus(status);
    }

    //------GetterSetter---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Boolean isLogin) {
        this.isLogin = isLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nasabah nasabah = (Nasabah) o;

        if (id != null ? !id.equals(nasabah.id) : nasabah.id != null) return false;
        if (fullname != null ? !fullname.equals(nasabah.fullname) : nasabah.fullname != null) return false;
        if (phonenumber != null ? !phonenumber.equals(nasabah.phonenumber) : nasabah.phonenumber != null) return false;
        if (username != null ? !username.equals(nasabah.username) : nasabah.username != null) return false;
        if (password != null ? !password.equals(nasabah.password) : nasabah.password != null) return false;
        if (status != null ? !status.equals(nasabah.status) : nasabah.status != null) return false;
        return isLogin != null ? isLogin.equals(nasabah.isLogin) : nasabah.isLogin == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (phonenumber != null ? phonenumber.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (isLogin != null ? isLogin.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Nasabah{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", isLogin='" + isLogin + '\'' +
                '}';
    }
}
