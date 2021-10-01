package com.example.demo.ipi;
// Aoutors: tai & bilala
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "flight")
@XmlRootElement
@Data
@ToString
//flight antity to find plans
public class Flight implements Serializable {
    @Id
  private  String id ;

  private  String size;
  private  String seatNumber;
    //    colection for big plan
    public Flight[] findbigPlan() {
        List<String> values =new ArrayList<String>();
        values.add ("");
        values.add ("");
        values.add ("");
        Collections.addAll(values);
        return  findbigPlan();
    }
//    colection for small plan
    public Flight[] finfSmallPlan(){
        List<String> values =new ArrayList<String>();
        values.add ("");
        values.add ("");
        values.add ("");
        Collections.addAll(values);
        return  finfSmallPlan();
    }

    }

