package method.dynamicPlanning;

import java.util.Arrays;
/**
 * ˳����ÿ�����յ���ǧ�������������ÿ����������������һ�� ����˳���ݵĻ���˾��������������˳��ı������������5�֣���5�֣��������޸ߣ�,��Ҫһ�������߾������صĻ����Щ���к�ľɳ�����иֲĵȵȡ�

�����ǻ����嵥��

������	��������(��λ:kg)
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
        // ���ڼ�¼ÿ�ֹ滮ѡ��Ļ����һά���ܹ滮ֵ���ڶ�ά��ѡ��
        static int[][] mark = new int[max][good.length];
    
        public static void main(String[] args) {
            int result = make(good.length - 1, max);
            System.out.println(result);
            Arrays.stream(mark[result]).forEach(item->System.out.println(item));
        }
    
        /**
         * ��̬�滮 - ���ַ�����ѡ��װ�Ķ��
         * 
         * @param i �ڼ�������
         * @param remain ʣ��ռ�
         * @return �����װ�¶��ٻ���
         */
        private static int make(int i, int remain) {
            if (i == 0) {
                // ���ֻʣ��һ�����ͬ������2��ѡ��
                // �����װ����ô�������0��
                // ���װ������װ���£�����������һ�����ﱾ���������װ���¾���0
                // ��ô��ʵ�Ϳ��Ժ��Բ�װ���������Ϊ���ֵ������ֻѡ��װ��������жϳ�����
            	mark[good[i]][i] = good[i];
            	mark[0][i] = 0;
                return remain > good[i] ? good[i] : 0;
            }
    
            // ����һ������ֻ��2��ѡ��װ�����߲�װ
            // ����A(װ)�����ʣ�µĿռ��ܹ�װ�±�����������װ�±��������ʣ�µĿռ���װ���ٻ�
            int planA = 0;// ���װ���£�PlanA����0
            int lastResult = 0;
            if (remain > good[i]) {
            	lastResult = make(i - 1, remain - good[i]);
            	planA = lastResult + good[i];
            	mark[planA] = Arrays.copyOf(mark[lastResult], mark[lastResult].length);
            	mark[planA][i] = good[i];
            }
              
            // ����B(��װ)�������װ���������Ϊ��װ�����Բ���Ҫ�����ܲ���װ�£�������㲻װ��������ʱʣ�µĿռ������װ���ٻ���
            lastResult = make(i - 1, remain);
            int planB = lastResult;
            mark[planB] = Arrays.copyOf(mark[lastResult], mark[lastResult].length);
            mark[planB][i] = 0;
        	
            // ���������A�ͷ���B�ĸ�װ�Ķ��Ҫ�ĸ�
            return planA > planB ? planA : planB;
        }
    }