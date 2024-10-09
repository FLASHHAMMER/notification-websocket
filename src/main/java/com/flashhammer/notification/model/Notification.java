package com.flashhammer.notification.model;

import java.time.LocalDateTime;

public class Notification {
    private String id;
    private String userId;
    private String title;
    private String message;
    private LocalDateTime date;
    private LocalDateTime expiryDate;
    private Boolean isRead;
    private Action action;

    public Notification() {
        super();
    }

    public Notification(String id, String userId, String title, String message, LocalDateTime date, LocalDateTime expiryDate, Boolean isRead, Action action) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.message = message;
        this.date = date;
        this.expiryDate = expiryDate;
        this.isRead = isRead;
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
