package CinemasSystem_main;

/**
 * @title:CinemasSystem
 * @author:nanzhou
 * @date:
 */
public class User {
    private String username;
    private String phone;
    private String password;
    private Integer role;
    public User(String username, String phone, String password, String role) {
        setUsername(username);
        setPhone(phone);
        setPassword(password);
        setRole(role);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(String role) {
        if (role.equals("管理员") ){
            this.role = 1;
        } else {
            this.role = 0;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
