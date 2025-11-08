import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hamming_Algo {
    public static ArrayList<Integer> calParityCount(ArrayList<Integer> bits) {
        ArrayList<Integer> counts = new ArrayList<>();
        int bitSize = bits.size();
        
        for (int i = 0; (int) Math.pow(2, i) <= bitSize; i++) {
            int parityPosition = (int) Math.pow(2, i);
            int count = 0;
            
            // Check bits where the i-th bit of position is 1
            for (int j = parityPosition; j <= bitSize; j++) {
                if ((j & parityPosition) == parityPosition) {
                    count += bits.get(j - 1);
                }
            }
            counts.add(count);
        }
        return counts;
    }
    
    public static void evenParity(ArrayList<Integer> counts, ArrayList<Integer> bits) {
        for (int i = 0; i < counts.size(); i++) {
            int parityIdx = (int) Math.pow(2, i) - 1;
            if (parityIdx < bits.size()) {
                if (counts.get(i) % 2 != 0)
                    bits.set(parityIdx, 1);
                else
                    bits.set(parityIdx, 0);
            }
        }
    }
    
    public static void generateError(ArrayList<Integer> bits, int pos) {
        int position = pos - 1;
        if (position >= 0 && position < bits.size()) {
            bits.set(position, bits.get(position) == 0 ? 1 : 0);
        }
    }
    
    public static int errorDetector(ArrayList<Integer> bits) {
        int errorIdx = 0;
        ArrayList<Integer> counter = calParityCount(bits);
        for (int i = 0; i < counter.size(); i++) {
            if (counter.get(i) % 2 != 0) {
                errorIdx += (int) Math.pow(2, i);
            }
        }
        return errorIdx;
    }
    
    public static void errorCorrector(ArrayList<Integer> bits, int errorIdx) {
        if (errorIdx == 0) {
            System.out.println("No error detected!");
        } else {
            System.out.println("Error detected at position: " + errorIdx);
            generateError(bits, errorIdx);
            System.out.println("The corrected bit is: " + bits);
        }
    }
    
    public static void main(String[] args) {
        // Initialize with parity bits as 0
        ArrayList<Integer> bits = new ArrayList<>(Arrays.asList(0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0));
        //                                                       P1 P2 D1 P4 D2 D3 D4 P8 D5 D6 D7
        
        // Encode: set parity bits
        ArrayList<Integer> parityCounts = calParityCount(bits);
        evenParity(parityCounts, bits);
        
        Scanner input = new Scanner(System.in);
        System.out.println("The encoded bit is: " + bits);
        
        System.out.println("Do you want to change a bit (y/n)?");
        String errorQues = input.next().toLowerCase();
        
        if ("y".equals(errorQues)) {
            System.out.println("Enter bit position to change (1-" + bits.size() + "):");
            int index = input.nextInt();
            generateError(bits, index);
            System.out.println("Bit changed successfully! " + bits);
            
            System.out.println("Do you want to detect and correct error (y/n)?");
            String resQues = input.next().toLowerCase();
            
            if ("y".equals(resQues)) {
                int errorIndex = errorDetector(bits);
                errorCorrector(bits, errorIndex);
            } else {
                System.out.println("Thanks for using Hamming Algorithm!");
            }
        } else {
            System.out.println("Thanks for using Hamming Algorithm!");
        }
        input.close();
    }
}