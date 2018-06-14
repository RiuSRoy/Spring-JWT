package medlife.intern.doctorsAPI.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jdk.nashorn.internal.runtime.Specialization;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Document(collection = "Doctor")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Doctor{

    private static final long serialVersionUID = 1L;

    @Id
    private String mlDoctorId;

    private Long rank;

    private Boolean isLocked;

    private Date assignTime;

    private Date saveTime;

    private String upDatedBy;

    private Boolean isValidated;

    public Doctor(String mlDoctorId, Long rank, Boolean isLocked, Date assignTime, Date saveTime, String upDatedBy, Boolean isValidated) {
        this.mlDoctorId = mlDoctorId;
        this.rank = rank;
        this.isLocked = isLocked;
        this.assignTime = assignTime;
        this.saveTime = saveTime;
        this.upDatedBy = upDatedBy;
        this.isValidated = isValidated;
    }
    private Doctor() {}

    public String getMlDoctorId() {
        return mlDoctorId;
    }

    public void setMlDoctorId(String mlDoctorId) {
        this.mlDoctorId = mlDoctorId;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    public Date getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Date assignTime) {
        this.assignTime = assignTime;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }

    public String getUpDatedBy() {
        return upDatedBy;
    }

    public void setUpDatedBy(String upDatedBy) {
        this.upDatedBy = upDatedBy;
    }

    public Boolean getIsValidated() {
        return isValidated;
    }

    public void setIsValidated(Boolean validated) {
        isValidated = validated;
    }
}
