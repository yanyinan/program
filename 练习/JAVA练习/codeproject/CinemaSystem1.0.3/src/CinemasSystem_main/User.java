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
    // 电影票
    private List tickets;

//    private int ticketCount;

    {
        tickets = new List(50);
    }

    public User() {
    }

    public User(String phone, String password, String username) {
        this(phone, password, username, "用户");
    }

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
        if (role.equals("管理员")) {
            this.role = 1;
        } else {
            this.role = 0;
        }
    }

    public void addTicket(Ticket ticket) {
//        // 考虑扩容
//        this.tickets[ticketCount ++] = ticket;
        tickets.addList(ticket);
    }

    public void showTickets() {
        System.out.println("序号 \t  电影名称    \t 上映时间   \t 数量");
        for (int i = 0; i < tickets.getSize(); i++) {
            Ticket ticket = (Ticket) tickets.getList(i);
            System.out.println(i + 1 + " \t " + ticket.info());
        }
    }

    @Override
    public String toString() {
        return "手机号 '" + phone + '\'' +
                ", 密码 ******  " +
                ", 用户名 '" + username + '\'';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
