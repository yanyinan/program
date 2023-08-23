package passWord;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

import java.util.Random;

/**
 * 生成密码
 * 随机生成一个 6 位的密码，要求:
 * 不包含重复字符
 * 要有字母和数字.
 * 不能以数字开头
 */
public class Producepassword {
    public String producePassword() {
        String password = "";
        Random random = new Random();
        char[] usedChars = new char[62]; // 用于存储已使用的字符，包括大写字母、小写字母和数字
        int usedCount = 0; // 记录已使用的字符数量
        for (int i = 0; i < 6; i++) {
            char temp;
            int select;

            if (i == 0) {
                select = random.nextInt(2); // 在第一个位置只选择大写或小写字母
            } else {
                select = random.nextInt(3); // 在其他位置可以选择大写字母、小写字母或数字
            }
            switch (select) {
                case 0:
                    temp = (char) (random.nextInt(26) + 65); // 生成大写字母
                    break;
                case 1:
                    temp = (char) (random.nextInt(26) + 97); // 生成小写字母
                    break;
                default:
                    temp = (char) (random.nextInt(10) + 48); // 生成数字
                    break;
            }
            boolean isUsed = false;
            for (int j = 0; j < usedCount; j++) {
                if (usedChars[j] == temp) {
                    isUsed = true;
                    break;
                }
            }
            if (isUsed) {
                i--; // 字符已经被使用，重新生成另一个字符
            } else {
                usedChars[usedCount++] = temp;
                password += temp;
            }
        }
        return password;
    }

}
