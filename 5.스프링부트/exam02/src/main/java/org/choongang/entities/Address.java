package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long seq;

    @Column(length =10, nullable = false)
    private String zipcode;

    @Column(length = 80, nullable = false)
    private String addr1;

    @Column(length = 80)
    private String addr2;

    @ToString.Exclude
    @OneToOne(mappedBy = "address")//조회만 가능
     private  Member member;

}
