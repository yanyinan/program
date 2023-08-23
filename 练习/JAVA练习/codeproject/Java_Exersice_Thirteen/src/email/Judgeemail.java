package email;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

/**
 * 判断邮箱
 * 输入一个电子邮箱，判断是否是正确电子邮箱地址。 正确的邮箱地址:
 * 。必须包含 @ 字符，不能是开头或结尾
 * 。必须以 .com 结尾
 *
 * @ 和 .com 之间必须有其他字符
 */
public class Judgeemail {
    /**
     * 判断是否是一个电子邮箱
     *
     * @param email 需判断的电子邮箱
     * @return 返回判断结果
     */
    public boolean judge(String email) {
        // 必须包含一个 '@' 和一个 '.'
        int atIndex = email.indexOf("@");
        int dotIndex = email.indexOf(".");

        if (atIndex == -1 || dotIndex == -1) {
            return false;
        }

        // 除了 '@' 和 '.' 之外只能包含字母和数字
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (c != '@' && c != '.' && !Character.isLetterOrDigit(c)) {
                return false;
            }
        }

        // '@' 和 '.' 不能相邻
        if (atIndex + 1 == dotIndex || atIndex - 1 == dotIndex) {
            return false;
        }

        // 不能以 '@' 或 '.' 开头或结尾
        if (email.startsWith("@") || email.startsWith(".") || email.endsWith("@") || email.endsWith(".")) {
            return false;
        }

        return true;
    }


}
