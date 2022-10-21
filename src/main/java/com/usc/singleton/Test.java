package com.usc.singleton;

import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		int x = 10;
		double init = 1;
		double sum = 0;

		for (int i=0; i<x; i++) {
			sum += init + init * 0.1;
			init = init + init * 0.1;
		}

		System.out.println(sum);
	}



}
