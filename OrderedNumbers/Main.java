import java.util.Scanner;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        System.out.print("How many numbers do you want to type? ");
        int numberOfNumbers = sc.nextInt();
        int[] allMyNumbers = new int[numberOfNumbers];

        System.out.print("enter your numbers: ");

        for (int i = 0; i < allMyNumbers.length; i++) {
            allMyNumbers[i] = Integer.parseInt(sc.next());
        }

      order(allMyNumbers);

        for (int number : allMyNumbers) {
            System.out.println(number);
        }
    }


    private static void order(int[] allMyNumbers){
        for (int i = 0; i < allMyNumbers.length - 1; i++){
            if (allMyNumbers[i] > allMyNumbers[i + 1]) {
                swap(allMyNumbers, i, i+1);
                while (i >= 1){
                    if(allMyNumbers[i] < allMyNumbers[i - 1]){
                        swap(allMyNumbers, i, i-1);
                    }
                    i--;
                }

            }
        }

    }

    private static void swap (int[] allMyNumbers, int index1, int index2) {
        int temp = allMyNumbers[index2];
        allMyNumbers[index2] = allMyNumbers[index1];
        allMyNumbers[index1] = temp;
  }
}
