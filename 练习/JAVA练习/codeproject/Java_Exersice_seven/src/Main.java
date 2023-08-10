import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//定义数组
        char[][] jiangchenzi = {
                {'十', '年', '生', '死', '两', '芒', '芒'},
                {'不', '思', '量'},
                {'自', '难', '忘'},
                {'千', '里', '孤', '坟'},
                {'无', '处', '话', '凄', '凉'},
                {'纵', '使', '相', '逢', '应', '不', '识'},
                {'尘', '满', '面'},
                {'鬓', '如', '霜'},
                {'夜', '来', '幽', '梦', '忽', '还', '乡'},
                {'小', '轩', '窗'},
                {'正', '梳', '妆'},
                {'相', '顾', '无', '颜'},
                {'唯', '有', '泪', '千', '行'},
                {'料', '得', '年', '年', '肠', '断', '处'},
                {'明', '月', '夜'},
                {'短', '松', '冈'},
        };
//正常输出
        for (int i = 0; i < jiangchenzi.length; i++) {
            for (int j = 0; j < jiangchenzi[i].length; j++) {
                System.out.print(jiangchenzi[i][j] + "\t");
            }
            System.out.println();
        }
//翻转输出
//找出最长数组的长度
        int max = jiangchenzi[0].length;
        for (int i = 0; i < jiangchenzi.length; i++) {
            if (jiangchenzi[i].length > max){
                max = jiangchenzi[i].length;
            }
        }
        char[][] newArr = new char[jiangchenzi.length][max];
        for (int i = 0; i < jiangchenzi.length; i++) {
            System.arraycopy(jiangchenzi[i], 0, newArr[i], 0, jiangchenzi[i].length);
            Arrays.fill(newArr[i],jiangchenzi[i].length , newArr[i].length, ' ');
        }
        int count = newArr[0].length;
        for (int i = 0; i < count; i++) {
            for (int j = newArr.length - 1; j >=0 ; j--) {
                System.out.print(newArr[j][i] + "\t");
            }
            System.out.println();
        }


    }
}