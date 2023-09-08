package Province;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Province {
    public static void main(String[] args) {
        // 创建一个Map集合来存储中国省份和其简称
        Map<String, String> provinces = new HashMap<>();

        // 将我国省份和其简称存到 Map 集合中
        provinces.put("北京", "京");
        provinces.put("天津", "津");
        provinces.put("上海", "沪");
        provinces.put("重庆", "渝");
        provinces.put("河北", "冀");
        provinces.put("山西", "晋");
        provinces.put("辽宁", "辽");
        provinces.put("吉林", "吉");
        provinces.put("黑龙江", "黑");
        provinces.put("江苏", "苏");
        provinces.put("浙江", "浙");
        provinces.put("安徽", "皖");
        provinces.put("福建", "闽");
        provinces.put("江西", "赣");
        provinces.put("山东", "鲁");
        provinces.put("河南", "豫");
        provinces.put("湖北", "鄂");
        provinces.put("湖南", "湘");
        provinces.put("广东", "粤");
        provinces.put("海南", "琼");
        provinces.put("四川", "川");
        provinces.put("贵州", "黔");
        provinces.put("云南", "滇");
        provinces.put("陕西", "陕");
        provinces.put("甘肃", "甘");
        provinces.put("青海", "青");
        provinces.put("台湾", "台");
        provinces.put("内蒙古", "蒙");
        provinces.put("广西", "桂");
        provinces.put("西藏", "藏");
        provinces.put("宁夏", "宁");
        provinces.put("新疆", "新");
        provinces.put("香港", "港");
        provinces.put("澳门", "澳");
//        String regex = "^江";
//        Pattern p = Pattern.compile(regex);
////         keySet
//        Set<String> strings = provinces.keySet();
//        Iterator<String> iterator = strings.iterator();
//        // 打印出所有的省份和简称
//        while (iterator.hasNext()) {
//            String key = iterator.next();
//            Matcher matcher = p.matcher(key);
//            if (matcher.find()) {
//                iterator.remove();
////                System.out.println("out");
//            } else {
//                System.out.println("省份：" + key + "，简称：" + provinces.get(key));
//            }
////            System.out.println(key + " = " + provinces.get(key));
//        }
//        keySet
        Set<Map.Entry<String, String>> strings = provinces.entrySet();
        strings.removeIf(stringStringEntry -> stringStringEntry.getKey().contains("江"));
//        System.out.println(provinces);
        strings.forEach(stringStringEntry -> System.out.println("省份：" + stringStringEntry.getKey() + "，简称：" + stringStringEntry.getValue()));
//        provinces.forEach((key,value)->System.out.println("省份：" + key + "，简称：" + value));
//        for (Map.Entry<String,String> e : strings){
//            System.out.println("省份：" + e.getKey() + "，简称：" + e.getValue());
//        }

    }
}


