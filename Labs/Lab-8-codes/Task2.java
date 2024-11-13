public class Task2 {

    public static boolean  palindrome(String str, int right,int left)
    {
        if(left >= right){
        return true;
    }
    if (str.charAt(left) != str.charAt(right)) {
        return false;
    }
    return palindrome(str, left + 1, right - 1);
}
    public static void main(String[] args)
{
    String str= "racecar";

    boolean isPalindrome = palindrome(str, 0, str.length() - 1);

    System.out.println(isPalindrome);
    
    // if (palindrome(str, 0, str.length() - 1)) {
    //     System.out.println(str + " is a palindrome.");
    // } else {
    //     System.out.println(str + " is not a palindrome.");
    // }
}
}



