package br.com.cs.rs.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = -5613292949395788401L;

    private Long id;

    private String name;

    @JsonIgnore
    private String password;

    private String role;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date createdAt;

    private Integer active = 1;

    public UserDTO() {
    }

    public UserDTO(final String name, final String password) {
        super();
        this.name = name;
        this.password = password;
        this.createdAt = new Date();
    }

    public UserDTO(final String name, final String password,
        final String role) {
        this(name, password);
        this.role = role;
    }

    public UserDTO(final String name, final String password, final String role,
        final Integer active) {
        this(name, password, role);
        this.active = active;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [id=").append(this.id).append(", name=")
                        .append(this.name).append(", password=")
                        .append(this.password)
                        .append(", role=").append(this.role)
                        .append(", createdAt=")
                        .append(this.createdAt).append("]");
        return builder.toString();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer isActive() {
        return this.active;
    }

    public void setActive(final Integer active) {
        this.active = active;
    }

}
