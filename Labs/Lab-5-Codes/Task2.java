public class Task2 {

    public char charFirstSingleLetter(String s, int n) {

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int count = 0;


            for (int j = 0; j < n; j++) {
                if (c == s.charAt(j)) {
                    count++;
                }
            }


            if (count == 1) {
                return c;
            }
            
        }


        return '\0';
    }

    public static void main(String[] args) {
        Task2 task = new Task2();
        String input = "swiss";
        
        int length = input.length();
        char result = task.charFirstSingleLetter(input, length);

        if (result != '\0') {
            System.out.println("The first non-repeating character is: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }

}
