package algorithm.sort.heap;

public class HeapSortAlgorithm {
	private static int[] sort = new int[] { 3, 4, 2, 1, 5 };

	public static void main(String[] args) {
		buildMaxHeapify(sort);
		heapSort(sort);
		for (int i = 0; i < sort.length; i++) {
			System.out.print(sort[i] + " ");
		}
	}

	private static void buildMaxHeapify(int[] data) {
		// û���ӽڵ�Ĳ���Ҫ�������ѣ������һ���ĸ��ڵ㿪ʼ
		int startIndex = getParentIndex(data.length - 1);
		// ��β�˿�ʼ�������ѣ�ÿ�ζ�����ȷ�Ķ�
		for (int i = startIndex; i >= 0; i--) {
			maxHeapify(data, data.length, i);
		}
	}

	/**
	 * ��������
	 *
	 * @param data
	 * @param heapSize ��Ҫ�������ѵĴ�С��һ����sort��ʱ���õ�����Ϊ���ֵ����ĩβ��ĩβ�Ͳ��ٹ���������
	 * @param index ��ǰ��Ҫ�������ѵ�λ��
	 */
	private static void maxHeapify(int[] data, int heapSize, int index) {
		// ��ǰ���������ӽڵ�Ƚ�
		int left = getChildLeftIndex(index);
		int right = getChildRightIndex(index);

		int largest = index;
		if (left < heapSize && data[index] < data[left]) {
			largest = left;
		}
		if (right < heapSize && data[largest] < data[right]) {
			largest = right;
		}
		// �õ����ֵ�������Ҫ��������������ˣ����ӽڵ���ܾͲ��������ˣ���Ҫ���µ���
		if (largest != index) {
			int temp = data[index];
			data[index] = data[largest];
			data[largest] = temp;
//			for (int i = 0; i < sort.length; i++) {
//				System.out.print(sort[i] + " ");
//			}
//			System.out.println();
			maxHeapify(data, heapSize, largest);
		}
	}

	/**
	 * �������ֵ����ĩβ��data��Ȼ�����ѣ��������ͳ��˵�����
	 *
	 * @param data
	 */
	private static void heapSort(int[] data) {
		// ĩβ��ͷ�������������������
		for (int i = data.length - 1; i > 0; i--) {
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;
//			for (int j = 0; j < sort.length; j++) {
//				System.out.print(sort[j] + " ");
//			}
//			System.out.println();
			maxHeapify(data, i, 0);
		}
	}

	/**
	 * ���ڵ�λ��
	 *
	 * @param current
	 * @return
	 */
	private static int getParentIndex(int current) {
		return (current - 1) >> 1;
	}

	/**
	 * ���ӽڵ�positionע�����ţ��ӷ����ȼ�����
	 *
	 * @param current
	 * @return
	 */
	private static int getChildLeftIndex(int current) {
		return (current << 1) + 1;
	}

	/**
	 * ���ӽڵ�position
	 *
	 * @param current
	 * @return
	 */
	private static int getChildRightIndex(int current) {
		return (current << 1) + 2;
	}
}
