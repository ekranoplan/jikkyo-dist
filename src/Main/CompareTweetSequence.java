package Main;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ekranoplan on 2016/11/29.
 */
public class CompareTweetSequence {
    private List<String> listA;
    private List<String> listB;
    private int dtwDistance;


    CompareTweetSequence(List<String> listA, List<String> listB) {
        this.listA = listA;
        this.listB = listB;
        this.dtwDistance = DTWDistance();
    }

    int getDtwDistance() {
        return dtwDistance;
    }

    private int DTWDistance() {
        int[][] dtw = new int[listA.size()][listB.size()];
        for (int i = 1; i < listA.size(); i++) {
            dtw[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < listB.size(); i++) {
            dtw[0][i] = Integer.MAX_VALUE;
        }
        dtw[0][0] = 0;

        for (int i = 1; i < listA.size(); i++) {
            for (int j = 1; j < listB.size(); j++) {
                int cost = StringUtils.getLevenshteinDistance(listA.get(i), listB.get(j));
                dtw[i][j] = cost + getMinimum(dtw[i - 1][j], dtw[i][j - 1], dtw[i - 1][j - 1]);
            }

        }
        return dtw[listA.size()-1][listB.size()-1];
    }

    private int getMinimum(int a, int b, int c) {
        List<Integer> l = new ArrayList<>();
        l.add(a);
        l.add(b);
        l.add(c);
        int min = Integer.MAX_VALUE;
        for (int i : l) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }
    
}
