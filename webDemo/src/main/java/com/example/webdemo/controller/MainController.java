package com.example.webdemo.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Controller
@AllArgsConstructor
public class MainController {

    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    MailProperties mailProperties;



    @GetMapping(value = "/")
    public String main(){

        return "main";
    }

    @GetMapping(value = "/this")
    public ModelAndView testThis(){
        ModelAndView mv = new ModelAndView("this");
        mv.addObject("body","wow");
        return mv;
    }

    @GetMapping(value = "/mail")
    @Async
    public String mailSend(){

        String to = "sopthfg@gmail.com";
        String subject = "TestMail";
        String text = "Good";




        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

        return "main";
    }

    @GetMapping(value = "/html")
    @Async
    public String htmlMailSend() throws MessagingException {

        MimeMessage mail = emailSender.createMimeMessage();
//        String body = templateEngine.process(templateName, context);
        MimeMessageHelper helper = new MimeMessageHelper(mail, true);

        String to = "sopthfg@gmail.com";
        String subject = "TestHtmlMail";
        String body = "<h1>hello</h1>\nHtml";

        try {
            helper.setFrom(mailProperties.getProperties().get("from"),mailProperties.getProperties().get("personal"));
        }catch (Exception e ){
            System.out.println(e.getStackTrace());
        }

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);
        emailSender.send(mail);

        return "main";

    }

//    @GetMapping(value = "/hbtest")
//    public String hbtest() throws IOException {
//        Handlebars handlebars = new Handlebars();
//
//        Template template = handlebars.compileInline("Hello {{this}}!");
//
//        System.out.println(template.apply("Handlebars.java"));
//        return template.apply("Handlebars.java");
//    }

}
