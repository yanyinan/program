package System;

import java.util.Arrays;
import java.util.Scanner;


/**
 * @title:Cinema_system
 * @author:nanzhou
 * @date:
 */
public class MovieTheater {
    static Scanner input = new Scanner(System.in);
    Movie[] movies = new Movie[10];
    int movies_count = 0;
    User[] users = new User[10];
    int users_count = 0;

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
            Movie newMovie = new Movie(name, 12.2, i, "23");
            addMoviein(newMovie);
        }
    }

    //    用户验证
    private boolean verify(String phone, String password) {
        for (int i = 0; i < users_count; i++) {
            if (phone.equals(users[i].getPhone()) && password.equals(users[i].getPassword())) {
                return true;
            }
        }
        return false;
    }

    //    用户注册
    public void enroll(String name, String phone, String password) {
        User user = new User(name, phone, password, "用户");
        addUser(user);
        print("添加 《" + name + "》 成功!登录成功");
        showUserMenu(phone, password);
    }

    //    添加用户
    private void addUser(User user) {
//        扩容
        if (users_count + 1 > users.length) {
            growUser();
        }
        users[users_count++] = user;
    }

    //    用户扩容
    private void growUser() {
        User[] newusers = Arrays.copyOf(users, users.length * 2);
        users = newusers;
    }

    //    一级菜单2. 显示所有电影信息 (按照上映时间降序显示)
    public void showAllMoviesDesc() {
        Movie[] showmovie = Arrays.copyOf(movies, movies_count);
        moviesDesc(showmovie);
        if (movies_count == 0) {
            print("\u001B[31m 目前没有电影！\u001B[0m");
        } else {
            for (int i = 0; i < movies_count; i++) {
                print(showmovie[i].toString());
            }
        }
    }

    //   所有电影信息 (按照上映时间降序显示)
    private void moviesDesc(Movie[] showmovie) {
        for (int i = 1; i < movies_count; i++) {
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
    public void selectMovie(String selectMovie) {
        if (selectMovieid(selectMovie) == -1) {
            print("查询无结果");
        } else {
            movies[selectMovieid(selectMovie)].toString();
        }
    }

    //    二级菜单判断
    public void selectUserMenu(String phone, String password, String role) {
        if (verify(phone, password)) {
            print("欢迎" + users[selectUserMine(phone, password)].getUsername() + "使用本影院");
            if (role.equals("管理员")) {
                showAdminMenu(phone, password);
            } else {
                showUserMenu(phone, password);
            }
        }
    }

    //    二级用户菜单
    private void showUserMenu(String phone, String password) {
        print("请选择功能:");
        print("1. 修改用户信息");
        print("2. 查询用户信息");
        print("3. 退出");
        System.out.print("请输入");
        switchUserMenu(input.nextInt(), phone, password);
    }

    //    二级用户菜单选择
    private void switchUserMenu(int usermenu, String phone, String password) {
        switch (usermenu) {
            case 1 -> updateUser(phone, password);
            case 2 -> showUserMine(phone, password);
            default -> exit();
        }
    }

    //   二级 查看当前用户信息
    private void showUserMine(String phone, String password) {
        print(users[selectUserMine(phone, password)].toString());
        showUserMenu(phone,password);
    }

    //   二级1. 修改用户信息
    private void updateUser(String phone, String password) {
//        showUserMine(phone, password);
        int id = selectUserMine(phone, password);
        print("修改当前用户用户名");
        print("请输入：");
        users[id].setUsername(input.next());
        print("修改当前用户登录手机号");
        print("请输入：");
        phone = input.next();
        users[id].setPhone(phone);
        print("修改当前用户密码");
        print("请输入：");
        password = input.next();
        users[id].setPassword(password);
        print("修改完成");
        users[id].toString();
        showUserMenu(phone, password);
    }

    //    查询用户
    private int selectUserMine(String phone, String password) {
        for (int i = 0; i < users_count; i++) {
            if (phone.equals(users[i].getPhone()) && password.equals(users[i].getPassword())) {
                return i;
            }
        }
        return -1;
    }

    //    二级管理员菜单
    private void showAdminMenu(String phone, String password) {
        print("请选择功能:");
        print("1. 新增电影");
        print("2. 删除电影（输入电影名称，删除对应电影）");
        print("3. 修改电影（输入电影名称，展示电影信息，选择要修改的内容（价格/上映时间），输入内容，修改已存储的电影信息）");
        print("4. 查看所有用户信息");
        print("5. 退出");
        System.out.print("请输入");
        switchAdminMenu(input.nextInt(), phone, password);
    }

    //    二级管理员菜单选择
    private void switchAdminMenu(int adminmenu, String phone, String password) {
        switch (adminmenu) {
            case 1 -> addMovie(phone,password);
            case 2 -> deleteMovie(phone,password);
            case 3 -> updateMovie(phone,password);
            case 4 -> showAlluser(phone,password);
            default -> exit();
        }
    }

    //    二级管理员4. 查看所有用户信息
    private void showAlluser(String phone, String password) {
        for (int i = 0; i < users_count; i++) {
            print(users[i].toString());
        }
        showAdminMenu(phone,password);
    }

    //    查找电影id
    public int selectMovieid(String selectMovie) {
        for (int i = 0; i < movies_count; i++) {
            if (selectMovie.equals(movies[i].getName())) {
                return i;
            }
        }
        return -1;
    }

    //    修改电影
    private void updateMovie(String phone, String password) {
        print("请输入需要修改的电影名称");
        int update_id = selectMovieid(input.next());
        print(movies[update_id].toString());
        print("选择要修改的内容（价格/上映时间）\n 价格修改请输入1，价格修改请输入2.");
        updateMovieMess(input.nextInt(), update_id);
        print("修改完成");
        showAdminMenu(phone,password);
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
    private void deleteMovie(String phone, String password) {
        print("请输入需要删除的电影名称");
        int delete_id = selectMovieid(input.next());
        Movie[] temp_movies = Arrays.copyOf(movies, movies.length);
        System.arraycopy(movies, 0, temp_movies, 0, delete_id);
        System.arraycopy(movies, delete_id + 1, temp_movies, delete_id, movies.length - delete_id - 1);
        movies = temp_movies;
        movies_count--;
        showAdminMenu(phone,password);
    }

    //    添加电影（输入）
    private void addMovie(String phone, String password) {
        print("请输入电影的名称:");
        String name = input.next();
        print("请输入电影的价格:");
        double price = input.nextDouble();
        print("请输入电影的导演:");
        String author = input.next();
        print("请输入上映时间:");
        int date = input.nextInt();
        Movie movie = new Movie(name, price, date, author);
        addMoviein(movie);
        print("添加 《" + name + "》 成功!");
        showAdminMenu(phone,password);
    }

    //    添加电影（扩容）
    private void addMoviein(Movie movie) {
        //        扩容
        if (movies_count + 1 > movies.length) {
            growMovies();
        }
        movies[movies_count++] = movie;
    }

    //    电影扩容
    private void growMovies() {
        Movie[] newmovies = Arrays.copyOf(movies, movies.length * 2);
        movies = newmovies;
    }

    //    退出
    private static void exit() {
        print("欢迎下次光临");
        System.exit(0);
//        movieTheater.start();
    }

    //输出
    public static void print(String str) {
        System.out.println(str);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
