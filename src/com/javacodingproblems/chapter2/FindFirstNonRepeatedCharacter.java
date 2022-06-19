package com.javacodingproblems.chapter2;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstNonRepeatedCharacter {

	
	private static final int EXTENDED_ASCII_CODES = 256;
	
	
	public static void main(String[] args) {
		
		String s = "Patit Pawan Karmakar";
		char c = firstNonRepeatedCharacter1(s);
		System.out.println(c);
	}
	
	
	

	public static char firstNonRepeatedCharacter(String str) {

	  int[] flags = new int[EXTENDED_ASCII_CODES];

	  for (int i = 0; i < flags.length; i++) {
	    flags[i] = -1;
	  }

	  for (int i = 0; i < str.length(); i++) {
	    char ch = str.charAt(i);
	    System.out.println(flags[ch]);
	    if (flags[ch] == -1) {
	      flags[ch] = i;
	    } else {
	      flags[ch] = -2;
	    }
	  }

	  int position = Integer.MAX_VALUE;

	  for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
	    if (flags[i] >= 0) {
	      position = Math.min(position, flags[i]);
	    }
	  }

	  return position == Integer.MAX_VALUE ?
	    Character.MIN_VALUE : str.charAt(position);
	}
	
	
	public static char firstNonRepeatedCharacter1(String str) {

		  Map<Character, Integer> chars = new LinkedHashMap<>();

		  // or use for(char ch: str.toCharArray()) { ... }
		  for (int i = 0; i < str.length(); i++) {
		    char ch = str.charAt(i);

		    chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
		  }
		  
		  System.out.println(chars);

		  for (Map.Entry<Character, Integer> entry: chars.entrySet()) {
		    if (entry.getValue() == 1) {
		      return entry.getKey();
		    }
		  }

		  return Character.MIN_VALUE;
		}
	
	
}
