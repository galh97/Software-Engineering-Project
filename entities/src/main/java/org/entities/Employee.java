package org.entities;
import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public enum Role { STORE_EMPLOYEE, CUSTOMER_SERVICE, STORE_MANAGER, CEO, ADMIN}
    @Column(name = "employee_role")
    private Role role;
    public Employee(String userID, String name, String userName, String password, String email, String phone, Role role) {
        super(userID, name, userName, password,  email, phone);
        this.role = role;
    }

    public Employee() {
        super();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
