package com.example.statisticallibrary;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Library of Statistical Calculations
 * Includes functions for finding the minimum value, maximum value, median value, 
 * and the mean.
 */
public class StatisticalLibrary {

    // Calculate the mean of the list 'x', with an option to filter values based on a minimum cutoff
    public static double calculateMean(ArrayList<Double> x, double min, boolean cutOff) {
        double sum = 0;
        int count = 0;

        // Iterate through each value in the list
        for(double value: x) {
            // If cutoff is true, only include values greater than or equal to 'min'
            if(cutOff && value >= min) {
                sum += value;
                count++;
            } else if (!cutOff) { // Otherwise, include all values
                sum += value;
                count++;
            }
        }

        // Avoid division by zero by checking if count is 0
        return count > 0 ? sum / count : 0;
    }

    // Calculate the median of the list 'x'
    public static double calculateMedian(ArrayList<Double> x) {
        // Sort the list first to ensure proper median calculation
        Collections.sort(x);
        int size = x.size();
        double median;

        // If the list has an odd number of elements, return the middle element
        if(size % 2 == 1) {
            median = x.get(size / 2);
        } else {
            // If the list has an even number of elements, return the average of the two middle elements
            median = (x.get(size / 2 - 1) + x.get(size / 2)) / 2;
        }
        return median;
    }

    // Find the minimum value in the list 'x'
    public static double findMin(ArrayList<Double> x) {
        double minValue = x.get(0); // Start with the first element as the minimum

        // Loop through the list to find the minimum value
        for(double value : x) {
            if(value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }

    // Find the maximum value in the list 'x'
    public static double findMax(ArrayList<Double> x) {
        double maxValue = x.get(0); // Start with the first element as the maximum

        // Loop through the list to find the maximum value
        for(double value : x) {
            if(value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        // Test data
        ArrayList<Double> data = new ArrayList<>();
        Collections.addAll(data, 25.5, 29.4, 36.7, 43.1, 57.9, 88.3, 99.9, 100.0);

        // Call methods and display the results
        System.out.println("Mean (with cutoff >= 0): " + calculateMean(data, 0, true));
        System.out.println("Median: " + calculateMedian(data));
        System.out.println("Minimum: " + findMin(data));
        System.out.println("Maximum: " + findMax(data));
    }
}
