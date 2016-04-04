package algorithm.sort.radix;

public class RadixSortAlgorithm{
    public static void sort(int[] number) {
        int k = 0;
        int n = 1;
        int[][]temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        int[]order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
        while(true) {
        	int count = 0;
            for(int i = 0; i < number.length; i++) {
            	if (number[i] / n == 0)
            		count++;
                int lsd = ((number[i] / n) % 10);
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            if (count == number.length)
            	break;
            
            for(int i = 0; i < 10; i++) {
                if(order[i] != 0) {
                    for(int j = 0; j < order[i]; j++) {
                        number[k] = temp[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
        }
    }
    public static void main(String[] args)
    {
        int[]data = {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100};
        sort(data);
        for(int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + " ");
        }
    }
}
