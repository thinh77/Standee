package com.thinh.Standee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    private String unit;

    @ManyToOne
    private RoleEntity role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<UserLocation> userLocations = new ArrayList<>();

    public void addUserLocations(UserLocation userLocation) {
        this.userLocations.add(userLocation);
        userLocation.setUser(this);
    }
}
