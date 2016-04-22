package method.dynamicPlanning;

import java.util.Arrays;
/**
 * 顺丰快递每天能收到成千上万的物流单，每个物流单的重量不一。 现在顺丰快递的货车司机隔壁老王开着顺丰的标配货车（限载5吨，含5吨，不考虑限高）,想要一次性拿走尽可能重的货物，这些货有红木沙发，有钢材等等。

以下是货物清单：

货物编号	货物重量(单位:kg)
1	509
2	838
3	924
4	650
5	604
6	793
7	564
8	651
9	697
10	649
11	747
12	787
13	701
14	605
15	644
 * @author Kajelas
 *
 */
public class DynammicPlanning {
    
        static int good[] = { 509, 838, 924, 650, 604, 793, 564, 651, 697, 649, 747, 787, 701, 605, 644 };
        static int max = 5000;
        // 用于记录每种规划选择的货物（第一维是总规划值，第二维是选择）
        static int[][] mark = new int[max][good.length];
    
        public static void main(String[] args) {
            int result = make(good.length - 1, max);
            System.out.println(result);
            Arrays.stream(mark[result]).forEach(item->System.out.println(item));
        }
    
        /**
         * 动态规划 - 两种方案，选择装的多的
         * 
         * @param i 第几件货物
         * @param remain 剩余空间
         * @return 最多能装下多少货物
         */
        private static int make(int i, int remain) {
            if (i == 0) {
                // 如果只剩下一件货物，同样是有2种选择
                // 如果不装，那么结果就是0。
                // 如果装，并且装的下，结果就是最后一件货物本身的重量，装不下就是0
                // 那么其实就可以忽略不装的情况，因为最大值可以在只选择装的情况下判断出来。
            	mark[good[i]][i] = good[i];
            	mark[0][i] = 0;
                return remain > good[i] ? good[i] : 0;
            }
    
            // 对于一件货物只有2种选择，装，或者不装
            // 方案A(装)：如果剩下的空间能够装下本件货物，则计算装下本件货物后剩下的空间能装多少货
            int planA = 0;// 如果装不下，PlanA就是0
            int lastResult = 0;
            if (remain > good[i]) {
            	lastResult = make(i - 1, remain - good[i]);
            	planA = lastResult + good[i];
            	mark[planA] = Arrays.copyOf(mark[lastResult], mark[lastResult].length);
            	mark[planA][i] = good[i];
            }
              
            // 方案B(不装)：如果不装本件货物（因为不装，所以不需要考虑能不能装下），则计算不装本件货物时剩下的空间最多能装多少货物
            lastResult = make(i - 1, remain);
            int planB = lastResult;
            mark[planB] = Arrays.copyOf(mark[lastResult], mark[lastResult].length);
            mark[planB][i] = 0;
        	
            // 结果，方案A和方案B哪个装的多就要哪个
            return planA > planB ? planA : planB;
        }
    }