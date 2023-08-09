/**
 * @title:Flip_the_array
 * @author:nanzhou
 * @date:2023.8.9
 */
// 设存在以下数组:
//
//         ```java
//         char[][] chunxiao = {
//         { '春' , '眠' , '不' , '觉' , '晓' } ,
//         { '处' , '处' , '闻' , '啼' , '鸟' } ,
//         { '夜' , '来' , '风' , '雨' , '声' } ,
//         { '花' ,  '落' , '知' , '多' , '少' }
//         } ;
//         ```
//
//         将其输出成如下形式
//
//         ![image-20230809190550417](https://s2.loli.net/2023/08/09/IQA1aO7LxopH2Xq.png)
//
//         - 尝试设计一组循环语句，将以上形式的输出结果翻转为以下形式(旋转 90 度):
public class Flip_the_array {
    public static void main(String[] args) {
//        char[][] chunxiao = {
//                {'春', '眠', '不', '觉', '晓', '，'},
//                {'处', '处', '闻', '啼', '鸟', '。'},
//                {'夜', '来', '风', '雨', '声', ','},
//                {'花', '落', '知', '多', '少', '。'}
//        };
        char[][] chunxiao = {
                {'十', '年', '生', '死', '两', '茫', '茫', ','},
                {'不', '思', '量', ','},
                {'自', '难', '忘', '。'},
                {'千', '里', '孤', '坟', ','},
                {'无', '处', '话', '凄', '凉', '。'},
                {'纵', '使', '相', '逢', '应', '不', '识', ','},
                {'尘', '满', '面', ','},
                {'鬓', '如', '霜', '。'},
                {'夜', '来', '幽', '梦', '忽', '还', '乡', ','},
                {'小', '轩', '窗', ','},
                {'正', '梳', '妆', '。'},
                {'相', '顾', '无', '言', ','},
                {'惟', '有', '泪', '千', '行', '。'},
                {'料', '得', '年', '年', '肠', '断', '处','，'},
                {'明', '月', '夜', '，'},
                {'短', '松', '冈', '。'}
        };
        System.out.println("正序输出");
        for (int i = 0; i < chunxiao.length; i++) {
            for (int j = 0; j < chunxiao[i].length; j++) {
                System.out.print(chunxiao[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("旋转90");
        int maxLength = 0;
        int maxIndex = -1;
        int minLength = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < chunxiao.length; i++) {
            int length = 0;
            for (int j = 0; j < chunxiao[i].length; j++) {
                length += chunxiao[i][j];
            }
            if (length > maxLength) {
                maxLength = length;
                maxIndex = i;
            } else if (length < minLength) {
                minLength = length;
                minIndex = i;
            }
        }
        int x = chunxiao[maxIndex].length - chunxiao[minIndex].length;
            for (int i = 0; i < chunxiao[chunxiao.length - 1].length + x; i++) {
                for (int j = chunxiao.length - 1; j >= 0; j--) {
                    if (i >= chunxiao[j].length) {
                        System.out.print("\t");
                    } else
                        System.out.print(chunxiao[j][i] + "\t");
                }
                System.out.println();
            }
        }

}


