package com.vn.sanght.challenge.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Table(name = "alerts")
public class Alert implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "detection_time", nullable = false)
    private ZonedDateTime detectionTime;

    @Column(nullable = false)
    private Integer type;

    @Column(length = 100, nullable = false)
    private String machine;

    @Column(name = "anomaly_output_path", length = 255)
    private String anomalyOutputPath;

    @Column(name = "normal_output_path", length = 255)
    private String normalOutputPath;

    @Column(length = 512)
    private String comment;

    @Column(length = 50)
    private String reason;

    @Column(length = 50)
    private String action;

    public Alert() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ZonedDateTime getDetectionTime() {
        return detectionTime;
    }

    public void setDetectionTime(ZonedDateTime detectionTime) {
        this.detectionTime = detectionTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getAnomalyOutputPath() {
        return anomalyOutputPath;
    }

    public void setAnomalyOutputPath(String anomalyOutputPath) {
        this.anomalyOutputPath = anomalyOutputPath;
    }

    public String getNormalOutputPath() {
        return normalOutputPath;
    }

    public void setNormalOutputPath(String normalOutputPath) {
        this.normalOutputPath = normalOutputPath;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id=" + id +
                ", machine='" + machine + '\'' +
                ", detectionTime=" + detectionTime +
                ", anomalyOutputPath='" + anomalyOutputPath + '\'' +
                ", normalOutputPath='" + normalOutputPath + '\'' +
                ", type=" + type +
                '}';
    }
}
