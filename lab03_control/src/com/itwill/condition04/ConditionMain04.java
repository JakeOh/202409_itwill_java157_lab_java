package com.itwill.condition04;

import java.util.Random;
import java.util.Scanner;

public class ConditionMain04 {

    public static void main(String[] args) {
        // 가위(0), 바위(1), 보(2)
        // 컴퓨터의 선택 - 난수, 사용자의 선택 - Scanner(콘솔 입력)
        // 누가 이겼는 지 결과 출력.
        
        // Random 타입의 변수를 선언, 초기화.
        Random rand = new Random(); // Random: 난수를 만들어 주는 도구.
        int computer = rand.nextInt(3); // 0 이상 3 미만의 난수를 생성.
        
        // Scanner 타입의 변수를 선언, 초기화.
        Scanner scan = new Scanner(System.in);
        
        System.out.println("[0] 가위");
        System.out.println("[1] 바위");
        System.out.println("[2] 보");
        System.out.println("---------------");
        System.out.print("선택> ");
        int user = scan.nextInt(); // 콘솔에서 입력한 정수를 변수 user에 저장.
        
        System.out.println("computer=" + computer + ", user=" + user);
        
        // 방법1:
        if (user == 0 && computer == 0) {
            System.out.println("Tie");
        } else if (user == 0 && computer == 1) {
            System.out.println("Computer wins");
        } else if (user == 0 && computer == 2) {
            System.out.println("User wins");
        } else if (user == 1 && computer == 0) {
            System.out.println("User wins");
        } else if (user == 1 && computer == 1) {
            System.out.println("Tie");
        } else if (user == 1 && computer == 2) {
            System.out.println("Computer wins");
        } else if (user == 2 && computer == 0) {
            System.out.println("Computer wins");
        } else if (user == 2 && computer == 1) {
            System.out.println("User wins");
        } else { // user=2(보) && computer=2(보)
            System.out.println("Tie");
        }
        
        // 방법2:
        if (user == 0) { // 사용자가 가위를 선택한 경우
            if (computer == 0) { // 컴퓨터가 가위인 경우
                System.out.println("Tie");
            } else if (computer == 1) { // 컴퓨터가 바위인 경우
                System.out.println("Computer wins");
            } else { // 컴퓨터가 보인 경우
                System.out.println("User wins");
            }
        } else if (user == 1) { // 사용자가 바위를 선택한 경우
            if (computer == 0) { // 컴퓨터가 가위인 경우
                System.out.println("User wins");
            } else if (computer == 1) { // 컴퓨터가 바위인 경우
                System.out.println("Tie");
            } else { // 컴퓨터가 보인 경우
                System.out.println("Computer wins");
            }
        } else { // 사용자가 보를 선택한 경우
            if (computer == 0) { // 컴퓨터가 가위인 경우
                System.out.println("Computer wins");
            } else if (computer == 1) { // 컴퓨터가 바위인 경우
                System.out.println("User wins");
            } else { // 컴퓨터가 보인 경우
                System.out.println("Tie");
            }
        }
        
        // 방법3:
        if (user == computer) { // 사용자와 컴퓨터의 선택이 같은 경우 -> 비긴 경우
            System.out.println("Tie");
        } else if ((user == 0 && computer == 2) 
                || (user == 1 && computer == 0) 
                || (user == 2 && computer == 1)) { // 사용자가 이긴 경우
            System.out.println("User wins");
        } else {
            System.out.println("Computer wins");
        }
        
    }

}
