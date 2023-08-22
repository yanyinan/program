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
    private Movie[] movies = new Movie[10];
    private Integer moviesCount = 0;
    private User[] users = new User[10];
    private Integer usersCount = 0;
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
            Movie newMovie = new Movie(name, i, 12.3, "123");
            addMoviein(newMovie);
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
        for (int i = 0; i < usersCount; i++) {
            if (phone.equals(users[i].getPhone())) {
                return i;
            }
        }
        return -1;
    }

    //    添加用户
    private void addUser(User user) {
//        扩容
        if (usersCount + 1 > users.length) {
            growUser();
        }
        users[usersCount++] = user;
    }

    //    用户扩容
    private void growUser() {
        User[] newusers = Arrays.copyOf(users, users.length * 2);
        users = newusers;
    }

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
        for (int i = 0; i < usersCount; i++) {
            System.out.println(users[i].getRole());
            if (phone.equals(users[i].getPhone()) && password.equals(users[i].getPassword())) {
                return users[i].getRole().equals("管理员") ? 1 : 0;
            }
        }
        return -1;
    }

    //    二级菜单判断
    public void selectUserMenu(String phone, String password) {
        int id = verify(phone, password);
        System.out.println(id);
        if (id == -1) {
            print("用户名或密码错误, 请重试");
        } else {
            print("登录成功");
            // 当前登录用户， 保存登录状态
            loginUser = users[id];
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
        Movie[] showmovie = Arrays.copyOf(movies, moviesCount);
        moviesDesc(showmovie);
        if (moviesCount == 0) {
            print("\u001B[31m 目前没有电影！\u001B[0m");
        } else {
            for (int i = 0; i < moviesCount; i++) {
                print(showmovie[i].toString());
            }
        }
    }

    //   所有电影信息 (按照上映时间降序显示)
    private void moviesDesc(Movie[] showmovie) {
        for (int i = 1; i < moviesCount; i++) {
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
            movies[selectMovieid(temp)].toString();
        } else {
            print("查询无结果");
        }
    }

    //    查找电影id
    public int selectMovieid(String selectMovie) {
        for (int i = 0; i < moviesCount; i++) {
            if (selectMovie.equals(movies[i].getName())) {
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
        print("3. 退出");
        System.out.print("请输入");
        switchUserMenu(input.nextInt());
    }

    //    二级用户菜单选择
    private void switchUserMenu(int usermenu) {
        switch (usermenu) {
            case 1 -> updateUser();
            case 2 -> showUserMine();
            default -> openCinema();
        }
        showUserMenu();
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
        for (int i = 0; i < usersCount; i++) {
            print(users[i].toString());
        }
    }

    //    修改电影
    private void updateMovie() {
        print("请输入需要修改的电影名称");
        int update_id = selectMovieid(input.next());
        print(movies[update_id].toString());
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
        movies[updateId].setDate(input.nextInt());
    }

    //    修改电影价格
    private void updateMoviePrice(int updateId) {
        print("请输入价格");
        movies[updateId].setPrice(input.nextDouble());
    }

    //    删除电影名称
    private void deleteMovie() {
        print("请输入需要删除的电影名称");
        int index = selectMovieid(input.next());
        System.arraycopy(movies, index + 1, movies, index, movies.length - index - 1);
        movies[--moviesCount] = null;
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

        Movie movie = new Movie(name, date, price, director);

        addMovie(movie);

        print("添加成功");
    }

    private void addMoviein(Movie movie) {
        //        扩容
        if (moviesCount + 1 > movies.length) {
            growMovies();
        }
        movies[moviesCount++] = movie;
    }

    //    电影扩容
    private void growMovies() {
        Movie[] newmovies = Arrays.copyOf(movies, movies.length * 2);
        movies = newmovies;
    }

    //    添加电影（扩容）
    public void addMovie(Movie movie) {
        //        扩容
        if (moviesCount + 1 > movies.length) {
            growMovies();
        }
        movies[moviesCount++] = movie;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
