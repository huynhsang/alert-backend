package com.vn.sanght.challenge.web.vmodel;

public class UpdateAlertVM {
    private String comment;

    private String reason;

    private String action;

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
        return "UpdateAlertVM{" +
                "comment='" + comment + '\'' +
                ", reason='" + reason + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
