import java.util.Scanner;

public class Hamming_Code {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int p=0,a;
        String bit;
        System.out.println("Enter Bit Sequence: ");
        bit=sc.nextLine();
        a=bit.length();

       while (Math.pow(2,p)<p+a+1){
           p++;
       }
       String HammingCode=hammingCode(bit, bit.length(),p);
      System.out.println("Generated Hamming Code:\n"+HammingCode);

    }

    private static String hammingCode(String bit, int length, int a) {

        String genCode=new String();
        int j=0;
        int[] hammingBit=new int[length+a+1];

        for (int i=1;i<hammingBit.length;i++){
            if (Math.ceil(Math.log(i) / Math.log(2) - Math.floor(Math.log(i) / Math.log(2))) == 0){

                hammingBit[i]=0;
            }else{
                hammingBit[i]=(bit.charAt(j) - '0');
                j++;
            }

        }

       int[]code = generate(hammingBit,a);

        for (int i=1;i<code.length;i++){
            genCode=genCode+code[i];
        }

        return genCode;
    }

    private static int[] generate(int[] hammingBit, int a) {
        for (int i=0;i<a;i++){
            int c=(int)Math.pow(2,i);
            for (int j=0;j<hammingBit.length;j++){
                if (((j >> i) & 1) == 1){
                    if (c != j){
                        hammingBit[c] = hammingBit[c] ^ hammingBit[j];
                    }
                }
            }
        }
        return hammingBit;
    }
}
