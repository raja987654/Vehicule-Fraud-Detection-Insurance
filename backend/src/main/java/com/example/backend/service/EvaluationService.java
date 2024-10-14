package com.example.backend.service;

import com.example.backend.entity.*;
import com.example.backend.repository.EvaluationRepository;
import com.example.backend.repository.SinistreRepository;
import com.example.backend.repository.expertRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.List;
import java.util.Properties;

@AllArgsConstructor
@Service
public class EvaluationService implements IEvaluationService {
    private EvaluationRepository repository;
    private SinistreRepository repsin;
    private expertRepository exp ;
    // private IsinistreService ss;
    private IexpertService es;

    @Override
    public Evaluation saveEvaluation(Evaluation e, int ids)  {
        Sinistre s;
        s=repsin.getById(ids);
        //s=ss.getSinistreById(ids);
        e.setSinistreEvaluation(s);
        e.setEtat(EtatEval.Affectation_en_cours);
        return   repository.save(e);
    }

    @Override
    public Evaluation affecterExpert(int id, int ide){
        Evaluation e=getEvaluationById(id);
//        Expert ex=es.getExpertById(ide);
        e.setEtat(EtatEval.affecte);
        e.setExpert(exp.getById(ide));
        return repository.save(e);
    }

    @Override
    public Evaluation accepterSinistre(int id, Evaluation e){
        Evaluation existingEval=repository.findById(id).orElse(null);

        Sinistre s=existingEval.getSinistreEvaluation();
        s.setEtat(EtatSinistre.Accepte);
        existingEval.setEtat(EtatEval.cloture);
        existingEval.setRapport(e.getRapport());
        s.getVoiture1().getUtilisateur().setNbrSinistre(s.getVoiture1().getUtilisateur().getNbrSinistre()+1);
        repsin.save(s);

        String tomail="nerminenafti@gmail.com";
        String subject="Sinistre approuvé";
        String body ="Votre sinistre a ete approuvé ";
        try { sendEmail(tomail,subject,body);} catch (MessagingException er ) {er.printStackTrace();}
        return repository.save(existingEval);
    }

    @Override
    public Evaluation refuserSinistre(int id,Evaluation e){
        Evaluation existingEval=repository.findById(id).orElse(null);

        Sinistre s=existingEval.getSinistreEvaluation();
        s.setEtat(EtatSinistre.rejete);
        existingEval.setEtat(EtatEval.cloture);
        existingEval.setRapport(e.getRapport());
        repsin.save(s);
        String tomail="nerminenafti@gmail.com";
        String subject="sinistre refusé";
        String body ="votre sinistre a ete refuse  ";
        try { sendEmail(tomail,subject,body);} catch (MessagingException er ) {er.printStackTrace();}
        return repository.save(existingEval);
    }

    @Override
    public List<Evaluation> getEvaluations(){
        return repository.findAll();
    }

    @Override
    public Evaluation getEvaluationById(int id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteEvaluation(int id){
        repository.deleteById(id);
    }

    @Override
    public void sendEmail(String tomail, String Subject, String body) throws MessagingException {

        String from ="techwork414@gmail.com";
        String password="pacrvzlvscatwwkb";

        Properties props=new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        Message message=new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(tomail));
        message.setSubject(Subject);
        message.setContent(body,"text/html");

        Transport.send(message);
    }
}
