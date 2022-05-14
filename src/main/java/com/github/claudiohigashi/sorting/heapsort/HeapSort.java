package com.github.claudiohigashi.sorting.heapsort;

public class HeapSort {
    public void sort(int[] array) {
        // Build a Max Heap
        buildMaxHeap(array);

        // Extraction phase:
        // - move top element to the bottom of heap
        // - decrease heap size so the highest value is not part ot the heap anymore
        // - fix the heap property by bubbling down the new top element
        for (int length = array.length - 1; length >= 0; length--) {
            swap(array, 0, length); // move the highest value to the end
            bubbleDown(array, length, 0); // bubble down the top element to keep the heap property
        }
    }

    private void buildMaxHeap(int[] array) {
        int start = array.length / 2;
        for (int i = start; i >= 0; i--) {
            bubbleDown(array, array.length, i);
        }
    }

    private void bubbleDown(int[] array, int length, int i) {
        int biggerChild = getIndexOfBiggerBetweenLeftAndRightChildren(array, length, i);
        if (biggerChild == -1) {
            return;
        }
        if (array[i] < array[biggerChild]) {
            swap(array, i, biggerChild);
            bubbleDown(array, length, biggerChild);
        }
    }

    private void swap(int[] array, int i, int bigger) {
        int saved_array_i = array[i];
        array[i] = array[bigger];
        array[bigger] = saved_array_i;
    }

    private int getIndexOfBiggerBetweenLeftAndRightChildren(int[] array, int length, int i) {
        int left = calcLeftChild(i);
        if (left > length - 1) {
            return -1;
        }
        int right = calcRightChild(i);
        if (right > length - 1) {
            return left;
        }
        if (array[left] >= array[right]) {
            return left;
        }
        return right;
    }

    private int calcLeftChild(int i) {
        return 2 * i + 1;
    }

    private int calcRightChild(int i) {
        return 2 * i + 2;
    }
}
