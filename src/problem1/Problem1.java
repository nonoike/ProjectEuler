package problem1;

import java.util.stream.LongStream;

/**
 * 10未満の自然数のうち, 3 もしくは 5 の倍数になっているものは 3, 5, 6, 9 の4つがあり, これらの合計は 23 になる.<br>
 * 同じようにして, 1000 未満の 3 か 5 の倍数になっている数字の合計を求めよ.
 *
 * @author user
 */
public class Problem1 {
    /** minimum value in the range. (thisValue <= range) */
    private static final int BEGIN_VALUE = 1;
    /** value of less than. (range < thisValue) */
    private static final int END_VALUE = 1000;

    /** entry point. */
    public static void main(String[] args) {
        long total = LongStream.range(BEGIN_VALUE, END_VALUE).filter(e -> e % 3 == 0 || e % 5 == 0).sum();
        System.out.println(total);
    }
}
