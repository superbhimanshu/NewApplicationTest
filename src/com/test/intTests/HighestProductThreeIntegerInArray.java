package com.test.intTests;

import java.util.Arrays;

//Given an arrayOfInts, find the highestProduct you can get from three of the integers.
public class HighestProductThreeIntegerInArray {

	public static void main(String[] args) {
		int[] in = { 2, 4, 3, 1, 5, -20, -30 };
		// System.out.println(highestProductOfThree(in));
		System.out.println(efficientMethod(in));

	}

	public static int highestProductOfThree(int[] in) {
		int output = 0;
		if (in == null || in.length < 3) {
			return output;
		}
		Arrays.sort(in);
		int forwardProd = in[in.length - 1] * in[in.length - 2] * in[in.length - 3];
		int backProd = 0;
		if (in[0] < 0 && in[1] < 0)
			backProd = in[in.length - 1] * in[1] * in[0];

		return forwardProd > backProd ? forwardProd : backProd;

	}

	public static int efficientMethod(int[] in) {
		int highestProductOf3 = in[0] * in[1] * in[2];
		int lowest = Math.min(in[0], in[1]);
		int highest = Math.max(in[0], in[1]);
		int highestProductOf2 = in[0] * in[1];
		int lowestProductOf2 = in[0] * in[1];
		// int highestProductOf3 =0;

		for (int i = 2; i < in.length; i++) {
			int current = in[i];

			highestProductOf3 = Math.max(Math.max(highestProductOf3, current * highestProductOf2), current * lowestProductOf2);
			highestProductOf2 = Math.max(highestProductOf2, lowest * current);
			highestProductOf2 = Math.max(highestProductOf2, highest * current);
			lowestProductOf2 = Math.min(lowestProductOf2, lowest * current);
			lowestProductOf2 = Math.min(lowestProductOf2, highest * current);
			lowest = Math.min(lowest, current);
			highest = Math.max(highest, current);

		}
		return highestProductOf3;

	}

	public static int highestProductOf3(int[] arrayOfInts) {
		if (arrayOfInts.length < 3) {
			throw new IllegalArgumentException("Less than 3 items!");
		}

		// We're going to start at the 3rd item (at index 2)
		// so pre-populate highests and lowests based on the first 2 items.
		// we could also start these as null and check below if they're set
		// but this is arguably cleaner
		int highest = Math.max(arrayOfInts[0], arrayOfInts[1]);
		int lowest = Math.min(arrayOfInts[0], arrayOfInts[1]);

		int highestProductOf2 = arrayOfInts[0] * arrayOfInts[1];
		int lowestProductOf2 = arrayOfInts[0] * arrayOfInts[1];

		// except this one--we pre-populate it for the first /3/ items.
		// this means in our first pass it'll check against itself, which is
		// fine.
		int highestProductOf3 = arrayOfInts[0] * arrayOfInts[1] * arrayOfInts[2];

		// walk through items, starting at index 2
		for (int i = 2; i < arrayOfInts.length; i++) {
			int current = arrayOfInts[i];

			// do we have a new highest product of 3?
			// it's either the current highest,
			// or the current times the highest product of two
			// or the current times the lowest product of two
			highestProductOf3 = Math.max(Math.max(highestProductOf3, current * highestProductOf2), current * lowestProductOf2);

			// do we have a new highest product of two?
			highestProductOf2 = Math.max(Math.max(highestProductOf2, current * highest), current * lowest);

			// do we have a new lowest product of two?
			lowestProductOf2 = Math.min(Math.min(lowestProductOf2, current * highest), current * lowest);

			// do we have a new highest?
			highest = Math.max(highest, current);

			// do we have a new lowest?
			lowest = Math.min(lowest, current);
		}

		return highestProductOf3;
	}
}
