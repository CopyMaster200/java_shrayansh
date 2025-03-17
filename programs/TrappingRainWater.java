package test.programs;

public class TrappingRainWater {
    public static int trap(int[] height) {
        // Edge case: if array is empty or has less than 3 elements
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0;                    // Left pointer
        int right = height.length - 1;   // Right pointer
        int leftMax = 0;                 // Maximum height seen from left
        int rightMax = 0;                // Maximum height seen from right
        int water = 0;                   // Total water trapped

        // Continue until pointers meet
        while (left < right) {
            // Compare heights at current positions
            if (height[left] < height[right]) {
                // Process left side
                if (height[left] >= leftMax) {
                    // Update left maximum
                    leftMax = height[left];
                } else {
                    // Add trapped water for current position
                    water += leftMax - height[left];
                }
                left++;
            } else {
                // Process right side
                if (height[right] >= rightMax) {
                    // Update right maximum
                    rightMax = height[right];
                } else {
                    // Add trapped water for current position
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        // Test case
        int[] height = {3, 0, 1, 0, 4, 0, 2};
        System.out.println("Water trapped: " + trap(height));  // Output: 10

        // Additional test case
        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println("Water trapped: " + trap(height2));  // Output: 9
    }
}
