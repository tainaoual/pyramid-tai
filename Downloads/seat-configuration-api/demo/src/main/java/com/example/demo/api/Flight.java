package com.example.demo.api;
// Aoutors: tai & bilala
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "flight")
@XmlRootElement
@Data
@ToString
//flight entity to find flights
public class Flight implements Serializable {
    @Id
  private  String id ;

  private  String size;
  private  String seatNumber;
//  plane collection
    String[] planeCollection = new String[]{"First","Business", "Main", "Economy", "Comfort"};
    //A Big Plane will contain all, while a small one would include 3?

    //    colection for big plan
    public Flight[] findbigPlane() {
        List<String> values =new ArrayList<String>();
        values.addAll (List.of(planeCollection));

        Collections.addAll(values);
        return  findbigPlane();
    }
//    collection for small plane
    public Flight[] findSmallPlane(){
        List<String> values =new ArrayList<String>();
        values.add (planeCollection[0]);
        values.add (planeCollection[2]);
        values.add (planeCollection[3]);
        Collections.addAll(values);
        return  findSmallPlane();
    }

    }

