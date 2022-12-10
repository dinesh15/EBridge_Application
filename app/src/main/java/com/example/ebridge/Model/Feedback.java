package com.example.ebridge.Model;

import java.util.Date;

public class Feedback {
    private String message;
    private String feedbackTitle;


    public Feedback(String message, String feedbackTitle) {
        this.message = message;
        this.feedbackTitle = feedbackTitle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFeedbackTitle() {
        return feedbackTitle;
    }

    public void setFeedbackTitle(String feedbackTitle) {
        this.feedbackTitle = feedbackTitle;
    }
}
