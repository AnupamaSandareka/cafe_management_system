package com.cafe.cafe.management.system.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "user")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id",length = 45)
    private Integer userId;

    @Column(name = "user_name", length = 100, nullable = false)
    private String userName;

    @Type(type = "json")
    @Column(name = "contact_numbers", columnDefinition = "json")
    private ArrayList contact_numbers;

    @Column(name = "user_email", unique = true)
    private String userEmail;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "user_status")
    private String userStatus;

    @Column(name = "user_role")
    private String userRole;

    public User(Integer userId,String userName, ArrayList contact_numbers, String userEmail, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.contact_numbers = contact_numbers;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
}
