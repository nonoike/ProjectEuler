package problem3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.LongStream;

/**
 * <pre>
 * 13195 の素因数は 5, 7, 13, 29 である.
 * 600851475143 の素因数のうち最大のものを求めよ.
 * </pre>
 *
 * @author user
 */
public class Problem3 {
    /** 計算対象の数値 */
    private static final long TARGET_VALUE = 600851475143l;

    /** 計算対象を素因数分解した場合の値一覧 */
    private static List<Long> primes;

    /** エントリポイント */
    public static void main(String[] args) {
        primes = new ArrayList<>();
        calcAndSetPrimes();
        Long result = primes.stream().max(Comparator.naturalOrder()).orElse(0L);
        System.out.println(result);
    }

    /**
     * 素因数を計算し、リストに格納します。
     *
     * @param currentValue 現在の数値
     */
    private static void calcAndSetPrimes() {
        int i = 1;
        long currentValue = TARGET_VALUE;
        while (++i <= currentValue) {
            if (isRemainderZero(currentValue, i)) {
                currentValue /= i;
                primes.add(new Long(i));
                i = 1;
            }
        }
    }

    /**
     * 値1が値2で割り切れるかを判定します。
     *
     * @param val1 割られる数
     * @param val2 割る数
     * @return 割り切れればtrue、そうでないならfalse
     */
    public static boolean isRemainderZero(long val1, int val2) {
        return val1 % val2 == 0;
    }
}
