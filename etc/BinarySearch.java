package self.etc;

/**
 * 2진탐색 의 전제조건 -렌덤엑세스 가능한 정렬된데이타.
 *
 * @author qiiop
 *
 */
public class BinarySearch {
    static int[] arr = new int[1000000];
    static int sum = 0;

    public static void main(String[] args) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i*2;
        }

        int searchIdx = 4;
        System.out.println("찾는 데이터 : " + searchIdx);
        BinarySearch bSearch = new BinarySearch();

        int resultIdx = -1;
        resultIdx = bSearch.searchLinear(searchIdx);
        if (resultIdx == -1)
            System.out.println("존재하지 않음.");
        else
            System.out.println(resultIdx + "에 존재");

        resultIdx = bSearch.searchBinaryByRepeat(searchIdx);
        if (resultIdx == -1)
            System.out.println("존재하지 않음.");
        else
            System.out.println(resultIdx + "에 존재");

        resultIdx = bSearch.searchBinaryByRecursive(searchIdx, 0, arr.length-1);
        if (resultIdx == -1)
            System.out.println("존재하지 않음.");
        else
            System.out.println(resultIdx + "에 존재");
    }

    /**
     * 일반 선형탐색.
     *
     * @param searchIdx
     * @return
     */
    int searchLinear(int searchIdx) {
        sum = 0;
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            sum++;
            if (searchIdx == arr[i]) {
                result = i;
                break;
            }
        }
        return result;
    }

    /**
     * 반복형 이분탐색.
     *
     * @param searchIdx
     * @return
     */
    int searchBinaryByRepeat(int searchIdx) {
        sum = 0;

        int midIdx, end, start;

        midIdx = -1;
        start = 0;
        end = arr.length - 1;
        while (start <= end) {
            sum++;
            midIdx = (start + end) / 2;
            if (searchIdx == arr[midIdx]) {
                break;
            } else if (searchIdx < arr[midIdx]) { // 왼쪽에서 검색.
                end = midIdx - 1;
            } else { // 오른쪽부터 검색.
                start = midIdx + 1;
            }
            midIdx = -1;
        }
        return midIdx;
    }

    /**
     * 재귀형 이분탐색.
     *
     * @param searchIdx
     * @return
     */
    int searchBinaryByRecursive(int searchIdx, int start, int end) {
        sum = 0;

        int midIdx = -1;
        if (start <= end) {
            sum++;
            midIdx = (start + end) / 2;
            if (searchIdx == arr[midIdx]) {
                return midIdx;
            } else if (searchIdx < arr[midIdx]) { // 왼쪽에서 검색.
                return searchBinaryByRecursive(searchIdx, start, midIdx - 1);
            } else { // 오른쪽부터 검색.
                return searchBinaryByRecursive(searchIdx, midIdx + 1, end);
            }
        }
        return midIdx;
    }

}
