package com.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ScreenerProto {

	public static void main(String... args) {
		final int numberOfItins = 30;
		final int range = 3;
		final int departTimeRange = 25;
		final int durationRange = 50;
		final Random r = new Random(System.currentTimeMillis());
		/*
		 * ItinProto[] itinArray = new ItinProto[numberOfItins];
		 * for(int i=0;i<itinArray.length;i++) {
		 * itinArray[i] = new ItinProto( r.nextInt(departTimeRange),
		 * r.nextInt(durationRange));
		 * }
		 */
		ItinProto[] itinArray = { new ItinProto(7, 5), new ItinProto(8, 6), new ItinProto(9, 4), new ItinProto(11, 3), new ItinProto(15, 5), };
		Arrays.sort(itinArray, new Comparator<ItinProto>() {

			@Override
			public int compare(ItinProto o1, ItinProto o2) {
				int result = o1.departTime - o2.departTime;
				if (result == 0) {
					result = o1.duration - o2.duration;
				}
				return result;
			}
		});
		System.out.println(Arrays.toString(itinArray));
		List<Bucket> bucketList = new LinkedList<Bucket>();
		Bucket currentBucket = new Bucket(range, itinArray[0]);
		for (int i = 1; i < itinArray.length; i++) {
			if (currentBucket.fit(itinArray[i])) {
				Bucket newBucket = currentBucket.bucket(itinArray[i]);
				if (newBucket != null) {
					System.out.println("backfilling bucket: " + newBucket.toString());
					bucketList.add(newBucket);
				}
			} else {
				bucketList.add(currentBucket);
				currentBucket = new Bucket(5, itinArray[i]);
			}
		}
		bucketList.add(currentBucket);

		System.out.println(bucketList);
	}

	public static class ItinProto {
		final int departTime;
		final int duration;

		public ItinProto(int departTime, int duration) {
			this.departTime = departTime;
			this.duration = duration;
		}

		public String toString() {
			return String.format("(%d,%d)", departTime, duration);
		}
	}

	public static class Bucket {
		final int range;
		ItinProto bucketValue;
		int lowerBound;
		int upperBound;
		Deque<ItinProto> blockedList = new LinkedList<ItinProto>();

		Bucket(int range, ItinProto itin) {
			this.range = range;
			bucketValue = itin;
			calculateBounds(itin);
		}

		private void calculateBounds(ItinProto itin) {
			lowerBound = itin.departTime - range;
			upperBound = itin.departTime + range;
		}

		boolean fit(ItinProto itin) {
			if (lowerBound < itin.departTime && itin.departTime < upperBound) {
				return true;
			}
			return false;
		}

		Bucket bucket(ItinProto itin) {
			Bucket newBeforeBucket = null;
			if (fit(itin)) {
				if (bucketValue.duration > itin.duration) {
					blockedList.addFirst(bucketValue);
					bucketValue = itin;
					calculateBounds(itin);
					if (!fit(blockedList.getLast())) {
						newBeforeBucket = splitBucketTail();
					}
				} else {
					blockedList.addFirst(itin);
				}
			}
			return newBeforeBucket;
		}

		private Bucket splitBucketTail() {
			ItinProto itin = blockedList.removeLast();
			Bucket returnBucket = new Bucket(range, itin);
			for (Iterator<ItinProto> itinIter = blockedList.descendingIterator(); itinIter.hasNext();) {
				ItinProto nextItin = itinIter.next();
				if (!fit(nextItin)) {
					if (returnBucket.fit(nextItin)) {
						returnBucket.bucket(nextItin);
						itinIter.remove();
					}
				}
			}
			return returnBucket;
		}

		public String toString() {
			return bucketValue + "-(" + blockedList.toString() + ")";
		}
	}
}