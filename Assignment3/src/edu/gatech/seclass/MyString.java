package edu.gatech.seclass;

public class MyString implements MyStringInterface{
    String string;
    /**
     * Returns the current string.
     * If the string has not been initialized with method setString, it should return null.
     *
     * @return Current string
     */
    @Override
    public String getString() {
        return string;
    }

    /**
     * Sets the value of the current string
     *
     * @param string The value to be set
     * @throws IllegalArgumentException If string is equal to the interface variable `easterEgg`
     */
    @Override
    public void setString(String string) {

     this.string = string;
    }

    /**
     * Returns the number of integer numbers in the current string, where an integer number is defined
     * as a contiguous sequence of digits [0-9].
     * <p>
     * If the current string is empty, the method should return 0.
     * <p>
     * Examples:
     * - This method would return 2 for string "My numbers are 11, 96, and thirteen"
     * - This method would return 3 for string "i l0ve 2 pr0gram."
     * - This method would return 2 for string "I don't handle real number such as 10.4"
     *
     * @return Number of integer numbers in the current string
     * @throws NullPointerException If the current string is null
     */
    @Override
    //https://stackoverflow.com/questions/39823137/java-count-the-number-of-integers-in-a-string
    public int countNumbers() {
        int cnt = 0;
        boolean isPrev = false;

        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                if (!isPrev) {
                    cnt++;
                    isPrev = true;
                }
            } else {
                isPrev = false;
            }
        }
        return cnt;
    }

    /**
     * Returns a string equivalent to the original string with n added to every integer number in
     * the string, where an integer number is defined as a contiguous sequence of digits, and signs
     * are ignored (i.e., all integers are considered to be positive).
     * <p>
     * If 'invert' is true, the order of the digits within every number will be reversed (after adding n).
     * If 'invert' is false, the digits will remain in their original order within the string.
     * <p>
     * Examples:
     * - For n=2 and invert=false, "hello 90, bye 2" would be converted to "hello 92, bye 4".
     * - For n=11 and invert=false, "hi 12345" would be converted to "hi 12356".
     * - For n=8 and invert=true, "hello 90, bye 2" would be converted to "hello 89, bye 01".
     * - For n=0 and invert=true, "12345" would be converted to "54321".
     * - For n=10 and invert=false, "-12345" would be converted to "-12355".
     *
     * @param n      amount to add to every number
     * @param invert Boolean that indicates whether digits within a number should be reversed
     * @return String with n added to every number in the string, with the number reversed, if indicated
     * @throws NullPointerException     If the current string is null
     * @throws IllegalArgumentException If n is negative, and the current string is not null
     */
    @Override
    //https://stackoverflow.com/questions/39424812/converting-digits-to-words-in-a-string-in-java
    public String addNumber(int n, boolean invert) {
        String newP =""; int ci;
       String strr= "";
      int j=0;int k=0;int l=0;
      if (n <0){

      }
       int length= string.length()-1;
       newP = string;
        for (int i = 0; i < string.length(); i++) {
            ci = (int) string.charAt(i);
                if (ci >= '0' && ci <= '9') {
                    j=j+1;
                    if(j==1){
                        k=i;
                    }else{
                        l=i;
                    }
                    strr += Character.toString(string.charAt(i));
                } else {
                     if (j>0) {
                         int value=Integer.valueOf(strr) + n;
                            String str = String.valueOf(value);
                            StringBuilder builder = new StringBuilder(str);
                            if(invert) {
                                builder.reverse();
                            }
                         StringBuilder strg = new StringBuilder(newP);
                         String temp =strg.replace(k,l+1,builder.toString()).toString();
                         newP=temp;
                     }
                    j=0;l=0;k=0;strr="";
                }
                if(i>=length){
                    if (j>0) {
                        int value=Integer.valueOf(strr) +n;
                            String str = String.valueOf(value);
                            StringBuilder builder = new StringBuilder(str);
                            if(invert) {
                            builder.reverse();
                        }
                            StringBuilder strrr = new StringBuilder(newP);
                            String temp = "";
                            if (strr.length() > 1) {
                                temp = strrr.replace(k, l + 1, builder.toString()).toString();
                            } else {
                                temp = strrr.replace(k, k + 1, builder.toString()).toString();
                            }
                            newP = temp;
                    }
                }
        }
        return newP;
    }

    /**
     * Replace the individual digits in the current string, between initialPosition and finalPosition
     * (included), with the corresponding name (i.e., string representation) of those digits.
     * The first character in the string is considered to be in Position 1.
     * <p>
     * Examples:
     * - String "I'd b3tt3r put s0me d161ts in this 5tr1n6, right?, with initialPosition=17 and finalPosition=23 would be
     * converted to "I'd b3tt3r put szerome donesix1ts in this 5tr1n6, right?"
     * - String "abc416d", with initialPosition=2 and finalPosition=7 would be converted to "abcfouronesixd"*
     *
     * @param initialPosition Position of the first character to consider
     * @param finalPosition   Position of the last character to consider
     * @throws NullPointerException        If the current string is null
     * @throws IllegalArgumentException    If "initialPosition" < 1 or "initialPosition" > "finalPosition" (and the string
     *                                     is not null)
     * @throws MyIndexOutOfBoundsException If "finalPosition" is out of bounds (i.e., greater than the length of the
     *                                     string), 1 <= "initialPosition" <= "finalPosition", and the string is not null
     */
    @Override
    public void convertDigitsToNamesInSubstring(int initialPosition, int finalPosition) {
        //https://stackoverflow.com/questions/39424812/converting-digits-to-words-in-a-string-in-java
        //https://www.geeksforgeeks.org/program-to-print-the-given-digit-in-words/

        String[] Cwords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String Posp = "";
        if (string.equals(easterEgg)){
            return;
        }
        int ci;
        for (int i = 0; i < string.length(); i++) {
            ci = (int) string.charAt(i);
            if (i >= initialPosition - 1 && i <= finalPosition - 1) {
                if (ci >= '0' && ci <= '9') {
                    Posp += Cwords[Character.getNumericValue(string.charAt(i))];
                } else {
                    Posp += string.charAt(i);
                }
            } else {
                Posp += string.charAt(i);
            }
        }
        this.string = Posp;
    }


}