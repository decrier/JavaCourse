package BitOperations;

public class Test {
    public static void main(String[] args) {
        int x = 342;
        System.out.println(Integer.toBinaryString(x));  // 00000000 00000000 00000001 01010110

        System.out.println(Integer.toBinaryString(~x)); // 11111111 11111111 11111110 10101001

        System.out.println(277&432);
//         100010101
//        &
//         110110000
//         ---------
//         100010000       //272

        System.out.println(277|432);  // 272
//         100010101
//        |
//         110110000
//         ---------
//         110110101       //272

        System.out.println(277^432);  // 165
//         100010101
//        ^
//         110110000
//         ---------
//         010100101       //272

        x = 64;
        int y = 3;
        int z = (x << y); // z = x * (2 hoch y)
        System.out.println(x); // 64
        System.out.println(z); // 512
        // 1000 0000 -> 0100 0000 0000

        x = 64;
        y = 2;
        z = (x >> y); // z = x / (2 hoch y)
        System.out.println(x); // 64
        System.out.println(z); // 16
        // 1000 0000 -> 0010 0000
        // Die Division durch zwei hoch y wird durchgeführt, wobei der Rest verworfen wird



    }
}
