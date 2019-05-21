import com.zhh.shuffle.Shuffler;
import com.zhh.sort.Sort;
import com.zhh.sort.SortFactory;
import com.zhh.sort.Sort.SortType;

public class SortVerify {

    public static void main(String[] args) {
        int[] a = Shuffler.shuffle(50);
        print(a);

        a = new int[]{10,2,3,4,4,4,10,5,6,7,8};
        Sort sort = SortFactory.create(SortType.QUICK);
        sort.sort(a);

        print(a);
    }

    public static int select(int[] a, int k){
        int lo = 0;
        int hi = a.length-1;
        while(hi >= lo){
            int j = (lo + hi)/2;
            if(a[j] > k){
                hi = j - 1;
            }else if(a[j] < k){
                lo = j + 1;
            }else{
                return a[j];
            }
        }
        return 0;
    }

    private static void print(int a[]) {
        StringBuffer sb = new StringBuffer();
        for (int b : a) {
            sb.append(b + " ");
        }
        System.out.println(sb.toString());
    }

}
