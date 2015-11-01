package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * フィボナッチ数列の項は前の2つの項の和である. 最初の2項を 1, 2 とすれば, 最初の10項は以下の通りである.<br>
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...<br>
 * 数列の項の値が400万以下の, 偶数値の項の総和を求めよ.<br>
 *
 * @author user
 */
public class Problem2 {
    /** 第一項 */
    private static final long FIRST_TERM_VALUE = 1;
    /** 第二項 */
    private static final long SECOND_TERM_VALUE = 2;
    /** 項の数値の最大値 */
    private static final long MAX_TERM_VALUE = 4000000;

    /** エントリポイント */
    public static void main(String[] args) {
        List<Long> terms = new ArrayList<Long>();
        // TODO マイナス値のケースの場合無限ループ
        while (true) {
            long nextValue = calcNextTerm(terms);
            if (MAX_TERM_VALUE <= nextValue) {
                break;
            }
            terms.add(nextValue);
        }
        // Long result = terms.stream().max(Comparator.naturalOrder()).orElse(0L);
        Long result = terms.stream().filter(e -> e % 2 == 0).collect(Collectors.summingLong(e -> e));
        System.out.println(result);
    }

    /**
     * フィボナッチ数列の次項の数値を求めます。
     *
     * @param terms これまでのフィボナッチ数列の項の数値の一覧
     * @return フィボナッチ数列の次項の数値
     */
    private static Long calcNextTerm(List<Long> terms) {
        int size = terms.size();
        switch (size) {
        case 0:
            return FIRST_TERM_VALUE;
        case 1:
            return SECOND_TERM_VALUE;
        default:
            return terms.get(size - 2) + terms.get(size - 1);
        }
    }
}
