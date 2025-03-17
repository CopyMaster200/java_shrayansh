package test.recursion;

import java.util.ArrayList;
import java.util.List;

public class FindNinArray {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 18, 9, 4};
        int target = 4;
        List<Integer> targetIndexes = new ArrayList<>();
        System.out.println("Target " + target + " is at index position(linear)  : " + findIndex(arr, 0, target));
        System.out.println("Target " + target + " is at index position(reverse) : " + findIndexLast(arr, arr.length - 1, target));
        findAllIndex(arr, 0, target, targetIndexes);
        System.out.println("Target " + target + " is at index positions(All)    : " + targetIndexes);
        System.out.println("Target " + target + " is at index positions(All)    : " + findAllIndex(arr, 0, target));
    }

    private static int findIndex(int[] arr, int index, int target) {
        //Base condition if index reaches end of array and didn't find the target the return -1
        if (index == arr.length)
            return -1;
        if (arr[index] == target) //if target is found then return index position.
            return index;
        return findIndex(arr, index + 1, target);
    }

    private static int findIndexLast(int[] arr, int index, int target) {
        //Base condition if index reaches end of array in reverse and didn't find the target the return -1
        if (index == -1)
            return -1;
        if (arr[index] == target) //if target is found then return index position.
            return index;
        return findIndexLast(arr, index - 1, target);
    }

    private static void findAllIndex(int[] arr, int index, int target, List<Integer> indexList) {
        //Base condition if index reaches end of array and didn't find the target the return -1
        if (index == arr.length)
            return;
        if (arr[index] == target) //if target is found then return index position.
            indexList.add(index);
        findAllIndex(arr, index + 1, target, indexList);
    }

    private static List<Integer> findAllIndex(int[] arr, int index, int target) {
        List<Integer> indexes = new ArrayList<>();
        //Base condition if index reaches end of array then return list
        if (index == arr.length)
            return indexes;
        // This will contain index for that function call only.
        if (arr[index] == target) //if target is found then add index position to list.
            indexes.add(index);
        List<Integer> previousIndexes = findAllIndex(arr, index + 1, target);
        indexes.addAll(previousIndexes);
        return indexes;
    }
}
