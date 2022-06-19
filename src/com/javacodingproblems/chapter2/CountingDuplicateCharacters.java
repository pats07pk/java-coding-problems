package com.javacodingproblems.chapter2;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountingDuplicateCharacters {
	
	
	/*
	 * Write a program that counts duplicate characters from a given string
	 */
	
	public static void main(String[] args) {
		
		String s = "A quick brown fox jumps over the lazy dog";
		
		//Map<Character, Integer> countDuplicateCharacters = countDuplicateCharacters(s);
		Map<Character, Long> countDuplicateCharactersUsingStream = countDuplicateCharactersUsingStream(s);
		
		System.out.println(countDuplicateCharactersUsingStream);
		
		
		
		
	}
	
	
	/**
	 * Using iterator and Map to count the characters.
	 * @param str
	 * @return
	 */
	public static Map<Character, Integer> countDuplicateCharacters(String str) {

		  Map<Character, Integer> result = new HashMap<>();

		  // or use for(char ch: str.toCharArray()) { ... }
		  for (int i = 0; i<str.length(); i++) {
		    char ch = str.charAt(i); 

		    result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
		  }

		  return result;
		}
	
	
	/**
	 * Using java 8 stream
	 * @param str
	 * @return
	 */
	public static Map<Character, Long> countDuplicateCharactersUsingStream(String str) {

		Map<Character, Long> result = str.chars()
			.mapToObj(c -> (char)c)
			.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		 
		return result;
	}
	
	
	
	
	
	
	
	

}
