import java.lang.Math.*;

public class Challenge {

    public int minDepth;

    public static void main(String[] args) {

        // level 1:
        //System.out.println(solution1(11111));

        // level 2:
        //System.out.println(solution2(143));

        // level 2.1:
        System.out.println(Level21.solution(2,33));


    }



    /**solution level 2 - Lovely Lucky LAMBs*/
    public static int solution2(int total_lambs) {

        // generous; min henchman

        int counter = 1;    // number of henchman
        int lambs = 1;      // number of lambs of one henchman
        int lambs_given = 1;  // number of all lambs given away

        while(2* lambs + lambs_given <= total_lambs){
            lambs = lambs*2;
            lambs_given = lambs_given + lambs;
            counter++;
        }

        // stingy; max henchman

        int counter2;    // number of henchman
        int lambs2;      // number of lambs of one henchman
        int lambs2_sub;  // number of lambs of 2nd subordinate
        int lambs_given2;  // number of all lambs given away
        int saveL ;

        if(total_lambs <= 1){
            counter2 = 1;
        }
        else if(total_lambs == 2){
            counter2 = 2;
        }
        else{
            lambs_given2 = 2;
            lambs2_sub = 1;
            counter2 = 2;
            lambs2 = 1;

            while(lambs2 + lambs2_sub + lambs_given2 <= total_lambs){
                saveL = lambs2;
                lambs2 = lambs2 + lambs2_sub;
                lambs2_sub = saveL;
                lambs_given2 = lambs_given2 + lambs2;
                counter2++;
            }
        }

        return counter2 - counter;
    }


    //solution level 1
    public static String solution1(int i) {

        //generate prime number string till primeNumbers.length() >= i+5
        String primeNumbers = "";
        int num = 1;

        while(primeNumbers.length() < i+5){

            int counter = 0;
            num++;

            for(int n = 1; n < num; n++){

                if(num%n==0)
                {
                    counter = counter + 1;
                }

            }

            if(counter == 1){
                primeNumbers = primeNumbers + num;
            }
        }

        System.out.println(primeNumbers);

        //get id from prime number string

        String substring = primeNumbers.substring(i,i+5);

        return substring;
    }

}
