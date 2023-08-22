package CinemasSystem_main;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @title:MovieTheater
 * @author:nanzhou
 * @date:
 */
public class MovieTheater {
    static Scanner input = new Scanner(System.in);
    private String MovieTheaterName;
    private List movies = new List(10);

    private List users = new List(10);

    // 登录用户
    private User loginUser;

    //    实例化初始管理员
    {
        User user = new User("admin", "12345", "admin", "管理员");
        addUser(user);
        User user2 = new User("用户", "54321", "admin", "用户");
        addUser(user2);
    }

    {
        for (int i = 0; i < 10; i++) {
            String name = "第" + (i + 1) + "个";
            Movie newMovie = new Movie(name, i, 12.2, "director", 50);
            addMovie(newMovie);
        }
    }

    public MovieTheater() {
        setMovieTheaterName("影院系统");
    }

    public MovieTheater(String movieTheaterName) {
        setMovieTheaterName(movieTheaterName);
    }

    public String getMovieTheaterName() {
        return MovieTheaterName;
    }

    public void setMovieTheaterName(String movieTheaterName) {
        MovieTheaterName = movieTheaterName;
    }

    //    输出
    public static void print(Object str) {
        System.out.println(str);
    }

    //    start系统
    public void start() {
        print("欢迎来到" + getMovieTheaterName() + "!!");
        openCinema();
    }

    //    输出一级菜单
    private void openCinema() {
        print("请选择功能:");
        print("1. 查询电影信息");
        print("2. 显示所有电影信息 (按照评分降序显示)");
        print("3. 管理员登录");
        print("4. 用户登录");
        print("5. 用户注册");
        print("6. 退出");
        System.out.print("请输入");
        switchBaseMenu(input.nextInt());
    }

    //    一级选择
    private void switchBaseMenu(int menu_num) {
        switch (menu_num) {
            case 1 -> selectMovie();
            case 2 -> showAllMoviesDesc();
            case 3, 4 -> userLogin();
            case 5 -> userEnroll();
            default -> exit();
        }
        openCinema();
    }

    //    用户注册
    private void userEnroll() {
        print("请输入你的用户名");
        String name = input.next();
        print(name);
        print("请输入用户登录手机号");
        String phone;
        int index;
        do {
            phone = input.next();
            index = queryUserByPhone(phone);
            if (index != -1) {
                // 手机号已注册
                print("手机号已注册");
            }
        } while (index > -1);
        print(phone);
        String password = null;
        String rePass = null;
        do {
            if (password != null) {
                print("两次密码不一致");
            }
            print("请输入密码：");
            password = input.next();
            print("请再次输入密码：");
            rePass = input.next();
        } while (!password.equals(rePass));
        print(password);
        User user = new User(name, phone, password, "用户");
        addUser(user);
        print("添加 《" + name + "》 成功!登录成功");
        showUserMenu();
    }

    private int queryUserByPhone(String phone) {
        for (int i = 0; i < users.getSize(); i++) {
            User user = (User) users.getList(i); // 获取列表中的用户对象
            if (phone.equals(user.getPhone())) {
                return i;
            }
        }
        return -1;
    }

    //    添加用户
    private void addUser(User user) {
        users.addList(user);
    }
//
//    //    用户扩容
//    private void growUser() {
//        User[] newusers = Arrays.copyOf(users, users.length * 2);
//        users = newusers;
//    }

    //    用户登陆
    private void userLogin() {
        print("请输入你的用户登录手机号");
        String phone = input.next();
        print("请输入密码");
        String password = input.next();
        selectUserMenu(phone, password);
    }

    //    用户验证
    private int verify(String phone, String password) {
        for (int i = 0; i < users.getSize(); i++) {
            User user = (User) users.getList(i);
            System.out.println(user.getRole()); // 注意这里应该是 user.getRole()
            if (phone.equals(user.getPhone()) && password.equals(user.getPassword())) {
                return user.getRole().equals("管理员") ? 1 : 0;
            }
        }
        return -1;
    }


    //    二级菜单判断
    public void selectUserMenu(String phone, String password) {
        int id = verify(phone, password);
//        System.out.println(id);
        if (id == -1) {
            print("用户名或密码错误, 请重试");
        } else {
            print("登录成功");
            // 当前登录用户， 保存登录状态
            loginUser = (User) users.getList(id);
            if (loginUser.getRole().equals("管理员")) {
                // 管理员
                showAdminMenu();
            } else {
                // 普通用户
                showUserMenu();
            }
        }
    }

    //    一级菜单2. 显示所有电影信息 (按照上映时间降序显示)
    private void showAllMoviesDesc() {
        /*创建的动态数组是实现了数组的功能，但实质上它仅仅是一个类的实例化，不能使用数组方法*/
//        Movie[] showmovie = Arrays.copyOf(movies, movies.getSize());
        Movie[] showmovie = new Movie[movies.getSize()];
        for (int i = 0; i < movies.getSize(); i++) {
            showmovie[i] = (Movie) movies.getList(i);
        }
        moviesDesc(showmovie);
        if (movies.getSize() == 0) {
            print("\u001B[31m 目前没有电影！\u001B[0m");
        } else {
            for (int i = 0; i < movies.getSize(); i++) {
                print(showmovie[i].toString());
            }
        }
    }

    //   所有电影信息 (按照上映时间降序显示)
    private void moviesDesc(Movie[] showmovie) {
        for (int i = 1; i < movies.getSize(); i++) {
            Movie temp = showmovie[i];
            int j = i - 1;
            while (j >= 0 && temp.getDate() > showmovie[j].getDate()) {
                showmovie[j + 1] = showmovie[j];
                j--;
            }
            showmovie[j + 1] = temp;
        }
    }

    //    一级菜单1. 查询电影信息
    private void selectMovie() {
        print("请输入带查询电影名称");
        String temp = input.next();
        if (selectMovieid(temp) != -1) {
            print(movies.getList(selectMovieid(temp)).toString());
        } else {
            print("查询无结果");
        }
    }

    //    查找电影id
    public int selectMovieid(String selectMovie) {
        for (int i = 0; i < movies.getSize(); i++) {
            Movie tempmovie = (Movie) movies.getList(i);
            if (selectMovie.equals(tempmovie.getName())) {
                return i;
            }
        }
        return -1;
    }

    //    退出
    private static void exit() {
        print("欢迎下次光临");
        System.exit(0);
    }

    //    输出二级用户菜单
    private void showUserMenu() {
        print("请选择功能:");
        print("1. 修改用户信息");
        print("2. 查询用户信息");
        print("3. 买电影票");
        print("4. 已购票查询");
        print("5. 退出");
        System.out.print("请输入");
        switchUserMenu(input.nextInt());
    }

    //    二级用户菜单选择
    private void switchUserMenu(int usermenu) {
        switch (usermenu) {
            case 1 -> updateUser();
            case 2 -> showUserMine();
            case 3 -> buyTicket();
            case 4 -> showTickets();
            default -> openCinema();
        }
        showUserMenu();
    }

    private void showTickets() {
        loginUser.showTickets();
    }

    private void buyTicket() {
        showAllMoviesDesc();
        Movie movie = null;
        do {
            if (movie != null) {
                print("请重新选择");
            }
            print("请选择要买的电影票：");
            String n = input.next();
            int movieIndex = selectMovieid(n);
            if (movieIndex != -1) {
                movie = (Movie) movies.getList(movieIndex);
            } else {
                print("电影不存在，请重新选择");
            }
        } while (movie == null || !(movie.getTicketCount() > 0));

        Integer count = null;
        do {
            if (count != null) {
                print("输入错误");
            }
            print("请输入购买数量：");
            count = input.nextInt();
        } while (!(count > 0 && count <= movie.getTicketCount()));

        Ticket ticket = new Ticket(movie, count);
        double money = movie.getPrice() * count;
        print(count + "张" + movie.getName() + "票，共计 " + money + "元，请支付。");
        // 添加票
        loginUser.addTicket(ticket);
        // 变电影票数量
        movie.setTicketCount(movie.getTicketCount() - count);
        print("购票成功");
    }

    //   二级 查看当前用户信息
    private void showUserMine() {
        print(loginUser);
    }

    //   二级1. 修改用户信息
    private void updateUser() {
        print("修改当前用户用户名");
        print("请输入：");
        loginUser.setUsername(input.next());
        print("修改当前用户登录手机号");
        print("请输入：");
        loginUser.setPhone(input.next());
        print("修改当前用户密码");
        print("请输入：");
        loginUser.setPassword(input.next());
        print("修改完成");
        print(loginUser);
    }

    //    输出二级用户菜单
    private void showAdminMenu() {
        print("请选择功能:");
        print("1. 新增电影");
        print("2. 删除电影（输入电影名称，删除对应电影）");
        print("3. 修改电影（输入电影名称，展示电影信息，选择要修改的内容（价格/上映时间），输入内容，修改已存储的电影信息）");
        print("4. 查看所有用户信息");
        print("5. 退出");
        System.out.print("请输入");
        switchAdminMenu(input.nextInt());
    }

    private void switchAdminMenu(int adminmenu) {
        switch (adminmenu) {
            case 1 -> addMovie();
            case 2 -> deleteMovie();
            case 3 -> updateMovie();
            case 4 -> showAlluser();
            default -> openCinema();
        }
    }

    //    二级管理员4. 查看所有用户信息
    private void showAlluser() {
        for (int i = 0; i < users.getSize(); i++) {
            User user = (User) users.getList(i);
            print(user.toString());
        }
    }

    //    修改电影
    private void updateMovie() {
        print("请输入需要修改的电影名称");
        int update_id = selectMovieid(input.next());
        Movie movie = (Movie) movies.getList(update_id);
        print(movie.toString());
        print("选择要修改的内容（价格/上映时间）\n 价格修改请输入1，价格修改请输入2.");
        updateMovieMess(input.nextInt(), update_id);
        print("修改完成");
    }

    //    选择要修改的内容（价格/上映时间）
    private void updateMovieMess(int i, int update_id) {
        switch (i) {
            case 1 -> updateMoviePrice(update_id);
            case 2 -> updateMovieDate(update_id);
            default -> print("输入错误");
        }
    }

    //    修改电影上映时间
    private void updateMovieDate(int updateId) {
        print("请输入上映时间");
        Movie movie = (Movie) movies.getList(updateId);
        movie.setDate(input.nextInt());
    }

    //    修改电影价格
    private void updateMoviePrice(int updateId) {
        print("请输入价格");
        Movie movie = (Movie) movies.getList(updateId);
        movie.setPrice(input.nextDouble());
    }

    //    删除电影名称
    private void deleteMovie() {
        print("请输入需要删除的电影名称");
        int index = selectMovieid(input.next());
//        System.arraycopy(movies, index + 1, movies, index, movies.getSize() - index - 1);
//        movies[--moviesCount] = null;
//        print("删除成功");
        movies.removeList(index);
        print("删除成功");
    }

    //    添加电影（输入）
    private void addMovie() {
        print("输入电影名称：");
        String name = input.next();
        print("输入导演姓名：");
        String director = input.next();
        print("请输入上映时间(格式: 20230101)：");
        int date = input.nextInt();
        print("请输入票价：");
        double price = input.nextDouble();
        print("请输入数量： ");
        int count = input.nextInt();
        Movie movie = new Movie(name, date, price, director, count);
        addMovie(movie);
        print("添加成功");
    }

//    private void addMoviein(Movie movie) {
////        //        扩容
////        if (moviesCount + 1 > movies.length) {
////            growMovies();
////        }
////        movies[moviesCount++] = movie;
//        movies.addList(movie);
//    }

//    //    电影扩容
//    private void growMovies() {
//        Movie[] newmovies = Arrays.copyOf(movies, movies.length * 2);
//        movies = newmovies;
//    }

    //    添加电影（扩容）
    public void addMovie(Movie movie) {
//        //        扩容
//        if (movies.getSize() + 1 > movies.length) {
//            growMovies();
//        }
        movies.addList(movie);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
