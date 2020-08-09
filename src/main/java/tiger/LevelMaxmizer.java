package tiger;

import java.util.Arrays;
import java.util.Comparator;

public class LevelMaxmizer {
    /**
     * int，返回做完x个任务后能达到的最高等级
     * @param x int整型 需要完成的任务数量
     * @param level int整型 初始等级
     * @param tasks int整型二维数组 表示可供选择的任务，tasks[i][0]表示第i个任务所需的最低等级，task[i][1]表示第i个任务完成后能提升的等级
     * @return int整型
     */
    public int maxLevel (int x, int level, int[][] tasks) {
        // write code here

        /*  对tasks排序: 所需最低等级tasks[0]从小到大排, 能提升的等级tasks[1]从大到小排序
            顺序遍历首先 level >= tasks[0]的, level += tasks[1];
            然后从最开始的位置继续遍历
        * */
        Arrays.sort(tasks, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o2[0] - o1[0];
                else return o1[1] - o2[1];
            }
        });

        // 2,1,[[1,3], [1,2], [0,1]]   x=2, level=1

        // 遍历x次
        for (int i = 0; i < x; i++) {
            // 每次遍历整个数组; 加了之后提升level，break; 再从最前面开始
            for (int j = 0; j < tasks.length; j++) {
                if (level >= tasks[j][0] && tasks[j][0] != 0) { // tasks[j][0] != 0: 做过一次这个任务就不能做了
                    level += tasks[j][0];
                    tasks[j][0] = 0;
                    break;
                }
            }
        }

        return level;
    }
}
