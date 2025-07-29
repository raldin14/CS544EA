package bank.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Tracerecord {
    @Id
    @GeneratedValue
    private long id;
    private Date date;
    private String result;

    public Tracerecord(){}
    public Tracerecord(String result){
        this.date = new Date();
        this.result = result;
    }

}
