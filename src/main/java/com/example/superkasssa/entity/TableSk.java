package com.example.superkasssa.entity;

import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sk_example_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class TableSk {

    @Id
    @NotNull
    private Long id;

    @Type(type = "jsonb")
    @Column(name = "obj", columnDefinition = "jsonb")
    private JsonEntity jsonEntity;

}
