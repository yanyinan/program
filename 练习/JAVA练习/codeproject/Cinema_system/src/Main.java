import java.util.Scanner;

import System.MovieTheater;

public class Main {
    static Scanner input = new Scanner(System.in);
    static MovieTheater movieTheater = new MovieTheater();

    public static void start() {
        print("欢迎使用开发喵影院");
        showBaseMenu();
    }

    //    一级菜单
    private static void showBaseMenu() {
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
    private static void switchBaseMenu(int menu_num) {
        switch (menu_num) {
            case 1 -> selectMovie();
            case 2 -> showAllMoviesDesc();
            case 3 -> adminLogin();
            case 4 -> userLogin();
            case 5 -> userEnroll();
            default -> exit();
        }
    }

    //    退出
    private static void exit() {
        print("欢迎下次光临");
        System.exit(0);
    }

    //    用户注册
    private static void userEnroll() {
        print("请输入你的用户名");
        String name = input.next();
        print(name);
        print("请输入用户登录手机号");
        String phone = input.next();
        print(phone);
        print("请输入密码");
        String password = input.next();
        print(password);
        movieTheater.enroll(name, phone, password);
    }

    //    用户登录
    private static void userLogin() {
        print("请输入你的用户登录手机号");
        String phone = input.next();
        print("请输入密码");
        String password = input.next();
//        用户登录成功返回二级菜单
        movieTheater.selectUserMenu(phone, password, "用户");
    }

    //    管理员登录
    private static void adminLogin() {
        print("请输入你的用户登录手机号");
        String phone = input.next();
        print("请输入密码");
        String password = input.next();
//        用户登录成功返回二级菜单
        movieTheater.selectUserMenu(phone, password, "管理员");
    }

    //     显示所有电影信息 (按照评分降序显示)
    private static void showAllMoviesDesc() {
        movieTheater.showAllMoviesDesc();
        showBaseMenu();
    }

    //    查询电影信息
    private static void selectMovie() {
        print("请输入要查询的电影");
        movieTheater.selectMovie(input.next());
        showBaseMenu();
    }

    //    输出
    public static void print(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        start();
    }
}