package com.itwill.loop04;

public class LoopMain04 {

    public static void main(String[] args) {
        /* (문제 1) 369게임: 아래와 같이 출력하세요.
            1   2   *   4   5   *   7   8   *   10
            11  12  *   14  15  *   17  18  *   20
            21  22  *   24  25  *   27  28  *   *
            *   *   *   *   *   *   *   *   *   40
            41  42  *   44  45  *   47  48  *   50
            51  52  *   54  55  *   57  58  *   *
            *   *   *   *   *   *   *   *   *   70
            71  72  *   74  75  *   77  78  *   80
            81  82  *   84  85  *   87  88  *   *
            *   *   *   *   *   *   *   *   *   100
        */
        for (int n = 1; n <= 100; n++) {
            int x = n % 10; // n을 10으로 나눈 나머지 -> 1의 자릿수.
            int y = n / 10; // n을 10으로 나눈 몫 -> 10의 자릿수.
            boolean b1 = (x == 3) || (x == 6) || (x == 9); // 1의 자릿수가 3, 6, 9이면
            boolean b2 = (y == 3) || (y == 6) || (y == 9); // 10의 자릿수가 3, 6, 9이면
            
            if (b1 && b2) {
                System.out.print("**\t");
            } else if (b1 || b2) {
                System.out.print("*\t");
            } else {
                System.out.print(n + "\t");
            }
            
            if (n % 10 == 0) { // 출력한 숫자가 10의 배수이면 줄바꿈을 넣자.
                System.out.println();
            }
        }
        System.out.println();
        
        /* (문제 2) 1부터 100까지의 정수들의 합: 5050 */
        int sum = 0;
        for (int n = 1; n <= 100; n++) {
            sum += n; // sum = sum + n;
        }
        System.out.println("1 ~ 100 합 = " + sum);
        
        /* (문제 3) 1부터 100까지의 정수들 중 3의 배수들의 합: 1683 */
        sum = 0;
        for (int n = 1; n <= 100; n++) {
            if (n % 3 == 0) {
                sum += n;
            }
        }
        System.out.println("1 ~ 100 사이의 3의 배수들의 합 = " + sum);
        
        sum = 0;
        for (int n = 3; n < 100; n += 3) {
            sum += n;
        }
        System.out.println("1 ~ 100 사이의 3의 배수들의 합 = " + sum);
        
    }

}
