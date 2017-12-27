package basicStructures;

public class BasicList {
    Integer[] array;
    int maxSize;

    public BasicList(int maxSize) {
        this.maxSize = maxSize;
        array = new Integer[maxSize];
    }

    public BasicList() {
        this.maxSize = 100;
        array = new Integer[maxSize];
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int get(int index) {
        return array[index];
    }

    public int insert(int index, int integer) {
        final int indexOfLastItem = getIndexOfLastItem();
        if (indexOfLastItem == -1) {
            array[index] = integer;
        } else {
            for (int i=indexOfLastItem; i >= index; i--) {
                if (i+1 == maxSize) {
                    continue;
                }
                array[i+1] = array[i];
            }
            array[index] = integer;
        }

        return index;
    }

    public int getIndexOfLastItem() {
        for (int i=maxSize-1; i >= 0; i--) {
            if (array[i] != null) {
                return i;
            }
        }

        return -1;
    }
}
