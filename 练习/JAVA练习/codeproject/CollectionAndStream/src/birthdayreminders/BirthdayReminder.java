package birthdayreminders;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

/**
 * ## 生日提醒
 * 编写一个生日提醒程序，使用Map来存储人名和对应的生日日期。够根据日期提醒用户哪些人今天过生日？
 * - 如何筛选显示出最近七天过生日的用户
 * @author:nanzhou
 * @date:
 */

public class BirthdayReminder {
    public static void main(String[] args) {
        // 创建一个Map来存储人名和生日日期
        Map<String, LocalDate> birthdayMap = new HashMap<>();
        birthdayMap.put("Alice", LocalDate.of(1990, Month.MAY, 15));
        birthdayMap.put("Bob", LocalDate.of(1985, Month.SEPTEMBER, 22));
        birthdayMap.put("Charlie", LocalDate.of(1995, Month.MARCH, 8));
        birthdayMap.put("Cha", LocalDate.of(1995, Month.SEPTEMBER, 8));
        birthdayMap.put("Casa", LocalDate.of(1995, Month.SEPTEMBER, 9));
        // 添加更多的人名和生日日期

        // 获取今天的日期
        LocalDate today = LocalDate.now();

        // 遍历Map，查找今天过生日的人
        for (Map.Entry<String, LocalDate> entry : birthdayMap.entrySet()) {
            String name = entry.getKey();
            LocalDate birthday = entry.getValue();

            if (birthday.getMonth() == today.getMonth() && birthday.getDayOfMonth() == today.getDayOfMonth()) {
                System.out.println(name + "今天过生日！");
            }
        }

        // 显示最近七天过生日的用户
        LocalDate sevenDaysAgo = today.minusDays(7);

        for (Map.Entry<String, LocalDate> entry : birthdayMap.entrySet()) {
            String name = entry.getKey();
            LocalDate birthday = entry.getValue();

            if (!birthday.isBefore(sevenDaysAgo) && !birthday.isAfter(today)) {
                System.out.println(name + "最近七天过生日或将要过生日！");
                break;
            }
        }
    }


}
