package algorithms.findarray;

public class MyFindArray implements FindArray {

	@Override
	public int findArray(int[] array, int[] subArray) {


		if (subArray.length > array.length) {
			throw new UnsupportedOperationException("SubArray is bigger then Array");
		}

		outer:
		for (int i = array.length - subArray.length ; i >= subArray.length ; i--) {
			for (int j = 0; j < subArray.length; j++) {
				if (array[i + j] != subArray[j]) {
					continue outer;
				}
			}
			return i;
		}
		return -1;
	}
}
