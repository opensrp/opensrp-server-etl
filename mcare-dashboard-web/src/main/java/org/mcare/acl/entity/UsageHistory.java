package org.mcare.acl.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Service;

/**
 * @author nursat
 *
 */

@Service
@Entity
@Table(name = "usage")
public class UsageHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usage_id_seq")
    @SequenceGenerator(name = "usage_id_seq", sequenceName = "usage_id_seq", allocationSize = 1)
    private long id;

    private String userName;

    @Temporal(TemporalType.DATE)
    private Date loginDate;

    private String day;

    private Date loginTime;

    private Date logoutTime;

    private int duration;

    public UsageHistory() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
