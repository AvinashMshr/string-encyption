package org.avinash.encyption;

import java.util.Arrays;

import org.junit.Test;

import com.google.common.base.Strings;

public class StringEncryption {
	
	public static String encrypt(String input) {
		if(Strings.isNullOrEmpty(input)) {
			return null;
		}
		input = input.replace(" ", "");
		if(Strings.isNullOrEmpty(input)) {
			return null;
		}
		StringBuilder builderInput = new StringBuilder(input.toLowerCase());
		
		int inputLength = builderInput.length();
		
		int length = inputLength/8;
		if(builderInput.length() % 8 > 0) {
			length = length +1;
		}
		
		StringBuilder transform[] = new StringBuilder[length];
		int iCounter = 0;
		int iTransformCounter = 0;
		
		while (iCounter < inputLength) {
			transform[iTransformCounter] = 
					new StringBuilder(builderInput.substring(iCounter, iCounter + 8 < inputLength ? iCounter + 8 : inputLength-1));	
			iCounter = iCounter + 8 ;
			iTransformCounter++;
		}
		
		StringBuilder result = new StringBuilder("");
		StringBuilder tempResult = new StringBuilder("");
		for(int outerLoop = 0; outerLoop < 8; outerLoop++) {
			tempResult = new StringBuilder("");
			for(int innerLoop = 0; innerLoop < length; innerLoop++) {
					int l = transform[innerLoop].length();			
				if(l > outerLoop) {
					System.out.println(transform[innerLoop].charAt(outerLoop));
					tempResult = tempResult.append(transform[innerLoop].charAt(outerLoop));
				}else {
					tempResult = tempResult.append(new StringBuilder(""));
				}
			}
			
			result.append(tempResult).append(" ");
		}
		return result.toString();
	}

	@Test
	public void testHappyPath() {
		System.out.println(StringEncryption.encrypt("Welcome to Bangalore pajji").length());
	}
}
