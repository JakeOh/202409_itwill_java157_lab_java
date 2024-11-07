package com.itwill.lambda04;

import java.util.Arrays;
import java.util.List;

public class LambdaMain04 {

    public static void main(String[] args) {
        // 직원(Employee)들의 리스트
        List<Employee> employees = Arrays.asList(
                new Employee(101, "김민석", "개발1팀", "과장", 700),
                new Employee(201, "김종후", "개발2팀", "부장", 800),
                new Employee(102, "안상찬", "개발1팀", "대리", 500),
                new Employee(202, "이수빈", "개발2팀", "부장", 1_000),
                new Employee(301, "이지해", "인사팀", "회장", 100),
                new Employee(203, "장세은", "개발2팀", "대리", 900),
                new Employee(302, "조희성", "인사팀", "차장", 900),
                new Employee(401, "최하신", "총무", "대리", 300),
                new Employee(402, "최호철", "총무", "과장", 1_000),
                new Employee(103, "허유진", "개발1팀", "과장", 500)
        );

        // Ex1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
        System.out.println("Ex.1 -----");
//        for (Employee e : employees) {
//            System.out.println(e);
//        }
        employees.forEach(System.out::println); // e -> System.out.println(e)
        
        // Ex2. 개발(1, 2)팀에서 일하는 직원들의 급여 합계.
        // Ex3. 개발팀에서 일하는 직원들의 급여 평균.
        System.out.println("Ex.2, Ex.3 -----");
        int count = 0; // 개발(1, 2)팀에서 일하는 직원 수
        double sum = 0; // 급여 합계
        for (Employee e : employees) {
            if (e.getDept().contains("개발")) {
                count++;
                sum += e.getSalary();
            }
        }
        System.out.println("급여 합계 = " + sum);
        double mean = sum / count;
        System.out.println("급여 평균 = " + mean);
        
        // Stream & Lambda
        sum = employees.stream()
                .filter(e -> e.getDept().contains("개발"))
                .mapToDouble(e -> e.getSalary())
                .sum();
        System.out.println("sum = " + sum);
        
        mean = employees.stream()
                .filter(e -> e.getDept().equals("개발1팀") || e.getDept().equals("개발2팀"))
                .mapToDouble(e -> e.getSalary())
                .average() //-> 리턴 타입: OptionalDouble - 정상 값 또는 예외를 저장하는 객체.
                .orElseThrow();
        System.out.println("mean = " + mean);
        
        // Ex4. 직급이 부장인 직원들의 급여 합계.
        // Ex5. 직급이 부장인 직원들의 급여 평균.
        // Ex6. 급여가 1,000 이상인 직원들의 정보를 한 줄에 한 명씩 출력.
        // Ex7. 개발1팀 직원들의 급여를 10% 인상하면 인상된 급여의 평균?
        // Ex8. 직원들 중 대리는 몇 명?
        
    }

}
