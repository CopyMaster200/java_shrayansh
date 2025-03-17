package test.programs;

import java.util.Arrays;

public class TrappingRainWaterMatrix {
    public static int trapWaterUsingMatrix(int[] heights) {
        if (heights == null || heights.length < 3) {
            return 0;
        }

        // Find the maximum height to create the matrix
        int maxHeight = Arrays.stream(heights).max().getAsInt();
//        for (int height : heights) {
//            maxHeight = Math.max(maxHeight, height);
//        }

        // Create a matrix where:
        // 1 represents a block
        // 0 represents empty space that could hold water
        boolean[][] matrix = new boolean[maxHeight][heights.length];

        // Fill the matrix with blocks
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i]; j++) {
                matrix[j][i] = true; // Mark as block
            }
        }

        // Calculate trapped water
        int waterUnits = 0;

        // For each row (height level)
        for (int i = 0; i < maxHeight; i++) {
            // For each column (position)
            int start = -1;  // Start of potential water trap

            for (int j = 0; j < heights.length; j++) {
                if (matrix[i][j]) {  // If we find a block
                    if (start != -1) {  // If we have a previous block
                        // Calculate water trapped between start and current position
                        waterUnits += (j - start - 1);
                    }
                    start = j;  // Update start position
                }
            }
        }

        return waterUnits;
    }

    // Helper method to print the matrix for visualization
    public static void printMatrix(int[] heights) {
        int maxHeight = 0;
        for (int height : heights) {
            maxHeight = Math.max(maxHeight, height);
        }

        boolean[][] matrix = new boolean[maxHeight][heights.length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i]; j++) {
                matrix[j][i] = true;
            }
        }

        // Print matrix (upside down for better visualization)
        for (int i = maxHeight - 1; i >= 0; i--) {
            for (int j = 0; j < heights.length; j++) {
                System.out.print(matrix[i][j] ? "█ " : "· ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] heights = {3, 0, 1, 0, 4, 0, 2};

        System.out.println("Input Array Visualization:");
        printMatrix(heights);

        int trappedWater = trapWaterUsingMatrix(heights);
        System.out.println("\nTrapped water units: " + trappedWater);

        // Additional test case
        System.out.println("\nAnother Example:");
        int[] heights2 = {4, 2, 0, 3, 2, 5};
        printMatrix(heights2);
        System.out.println("\nTrapped water units: " + trapWaterUsingMatrix(heights2));
    }
}