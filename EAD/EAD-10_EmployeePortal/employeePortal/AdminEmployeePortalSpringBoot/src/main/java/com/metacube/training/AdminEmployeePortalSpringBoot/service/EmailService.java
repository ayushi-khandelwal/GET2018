package com.metacube.training.AdminEmployeePortalSpringBoot.service;

import javax.mail.MessagingException;

public interface EmailService
{
    public void sendEmail(String to, String subject, String message) throws MessagingException;
}
