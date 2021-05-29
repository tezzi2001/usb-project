package com.heroku.labshare.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.LongArrayType;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TypeDef(name = "long-array", typeClass = LongArrayType.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private int faculty;
    private int specialty;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Type(type = "long-array")
    @Column(columnDefinition = "bigint[]", name = "liked_ids")
    private Long[] likedIDs;

    @OneToMany()
    private List<Task> tasks;
}
