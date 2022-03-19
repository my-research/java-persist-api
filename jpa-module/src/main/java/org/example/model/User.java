package org.example.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
}
