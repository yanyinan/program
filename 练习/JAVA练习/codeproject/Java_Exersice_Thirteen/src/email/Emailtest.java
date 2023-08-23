package email;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Emailtest {
    public static void main(String[] args) {
        String str = "1233@2.com";
        Judgeemail judgeEmail = new Judgeemail();
        System.out.println(judgeEmail.judge(str));
    }

}
