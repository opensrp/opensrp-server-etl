package org.mcare.acl.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Service;

/**
 * @author nursat
 *
 */
@Service
@Entity
public class ActiveUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activeUser_id_seq")
    @SequenceGenerator(name = "activeUser_id_seq", sequenceName = "activeUser_id_seq", allocationSize = 1)
    private int id;

    private String userName;

    @Temporal(TemporalType.DATE)
    private Date loginDate;

    private String day;

    private Date loginTime;

    private Date logoutTime;

    private int duration;

    private Date lastActiveTime;

    public ActiveUser() {
        // TODO Auto-generated constructor stub
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getLastActiveTime() {
        return lastActiveTime;
    }

    public void setLastActiveTime(Date lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }

}
