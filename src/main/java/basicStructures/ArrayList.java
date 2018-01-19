package basicStructures;

public class ArrayList {
    Integer[] array;
    int maxSize;

    public ArrayList(int maxSize) {
        this.maxSize = maxSize;
        array = new Integer[maxSize];
    }

    public int get(int index) {
        return array[index];
    }

    public int putAtIndex(int index, int integer) {
        if (index > maxSize - 1) {
            resizeArray(index + 1);
        }

        final int indexOfLastItem = getIndexOfLast();
        if (indexOfLastItem == -1) {
            array[index] = integer;
        } else {
            for (int i=indexOfLastItem; i >= index; i--) {
                if (i + 1 > maxSize - 1) {
                    resizeArray(i + 2);
                }
                array[i+1] = array[i];
            }
            array[index] = integer;
        }

        return index;
    }

    private void resizeArray(int newMaxSize) {
        final Integer[] arrayCopy = new Integer[newMaxSize];
        for (int i=0; i<maxSize; i++) {
            arrayCopy[i] = array[i];
        }
        this.maxSize = newMaxSize;
        this.array = arrayCopy;
    }

    public int getIndexOfLast() {
        for (int i=maxSize-1; i >= 0; i--) {
            if (array[i] != null) {
                return i;
            }
        }

        return -1;
    }

    public int getMaxSize() {
        return maxSize;
    }

    @Override
    public String toString() {
        StringBuilder printed = new StringBuilder();
        printed.append("array=[");
        for (int i=0; i<maxSize; i++) {
            printed.append(array[i]);
            if (i != maxSize - 1) {
                printed.append(", ");
            }
        }
        printed.append("]");
        return printed.toString();
    }
}
