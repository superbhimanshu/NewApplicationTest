package com.test.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ReverseWordsInInputLine {

	public static void main(String[] args) {
		String s = "find you will pain only go you recordings security the into if";
		String[] c = s.split(" ");
		List<String> al = Arrays.asList(c);
		Collections.reverse(al);
		System.out.println(StringUtils.join(al, " "));
}

}
