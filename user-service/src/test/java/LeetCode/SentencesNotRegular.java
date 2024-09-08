package LeetCode;

import java.util.Arrays;

/**
 * @Description: 两句话中不常见的单词
 * @Author : yandg
 * @Date 2024/9/6 星期五
 */
public class SentencesNotRegular {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(uncommonFromSentences("this sd is sweet", "this apple is sour")));
    }

    public static String[] uncommonFromSentences(String A, String B) {
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");
        String[] result = new String[wordsA.length + wordsB.length];
        System.arraycopy(wordsA, 0, result, 0, wordsA.length);
        System.arraycopy(wordsB, 0, result, wordsA.length, wordsB.length);
        Arrays.sort(result);
        int i = 0, j = 1;
        while (i < result.length - 1 && j < result.length) {
            if (result[i].equals(result[j])) {
                i++;
                j++;
            } else {
                return new String[]{result[i]};
            }
            return new String[]{result[result.length - 1]};
        }
        return new String[]{};
    }
}
