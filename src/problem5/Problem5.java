package problem5;

/**
 * 2520 は 1 から 10 の数字の全ての整数で割り切れる数字であり, そのような数字の中では最小の値である.<br>
 * では, 1 から 20 までの整数全てで割り切れる数字の中で最小の正の数はいくらになるか.
 *
 * @author user
 */
public class Problem5 {
    private static final int MAX_VALUE = 20;

    /** エントリポイント.引数は不要 */
    public static void main(String[] args) {
        long total = 1;
        // 最小の約数(素数)を乗算し続ける(素因数分解の逆のイメージ)
        for (int i = 1; i <= MAX_VALUE; i++) {
            if (!isRemainderZero(total, i)) {
                total = total * getLeastDivisor(i);
            }
        }
        System.out.println(total);
    }

    /**
     * 値を割り切れる最小の約数を求めます。<br>
     * ただし1を渡されたら場合のみ1を返し、それ以外は2以上の正数となります。<br>
     *
     * @param val 最小約数を求める値
     * @return 最小の約数(素数)
     */
    public static long getLeastDivisor(int val) {
        for (int i = 2; i < val; i++) {
            if (isRemainderZero(val, i)) {
                return i;
            }
        }
        return val;
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