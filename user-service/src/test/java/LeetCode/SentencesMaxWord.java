package LeetCode;

/**
 * @Description: 给定一组句子，找出其中最多的单词数
 * @Author : yandg
 * @Date 2024/9/6 星期五
 */
public class SentencesMaxWord {
    public static void main(String[] args) {
        System.out.println( mostWordsFound(new String[]{"hello world", "this is a test", "leetcode is a good platform"}));
    }

    public static int mostWordsFound(String[] sentences) {
        // 单词数遍历字符串数组,找到每个句子中最多的句子
        int max = 0;
        for (String sentence : sentences) {
            int count = 0;
            for (String word : sentence.split(" ")) {
                if (!word.isEmpty()) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
            }

        }
        return max;
    }
}
