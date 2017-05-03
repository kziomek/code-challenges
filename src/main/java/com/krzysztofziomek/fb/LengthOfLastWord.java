package com.krzysztofziomek.fb;

/**
 * @author Krzysztof Ziomek
 * @since 03/05/2017.
 */
public class LengthOfLastWord {


    public int lengthOfLastWord(final String a) {

        int length = 0;
        int i = a.length() -1;

        while(a.charAt(i) == ' ') {
            i--;
        }

        for (;i>=0; i--){
            if (a.charAt(i) == ' '){
                break;
            }
            length++;
        }
        return length;

    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord(" Hello World  "));

    }

}
