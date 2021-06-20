package com.example.lesson5task.entity;

import com.example.lesson5task.entity.templete.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Task extends AbsEntity {

    @Column(nullable = false)
    private String name;

    private String description;

    private Timestamp deadline;

    @ManyToOne(optional = false)
    private User taskTaker;

    @ManyToOne(optional = false)
    private User taskGiver;

}
