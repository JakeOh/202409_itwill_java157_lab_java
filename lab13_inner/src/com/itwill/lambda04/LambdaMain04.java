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
                new Employee(301, "이지해", "인사팀", "회장", 30_000),
                new Employee(203, "장세은", "개발2팀", "대리", 900),
                new Employee(302, "조희성", "인사팀", "차장", 900),
                new Employee(401, "최하신", "총무", "대리", 300),
                new Employee(402, "최호철", "총무", "과장", 1_000),
                new Employee(103, "허유진", "개발1팀", "과장", 500)
        );

        // Ex1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
        // Ex2. 개발(1, 2)팀에서 일하는 직원들의 급여 합계.
        // Ex3. 개발팀에서 일하는 직원들의 급여 평균.
        // Ex4. 직급이 부장인 직원들의 급여 합계.
        // Ex5. 직급이 부장인 직원들의 급여 평균.
        // Ex6. 급여가 1,000 이상인 직원들의 정보를 한 줄에 한 명씩 출력.
        // Ex7. 개발1팀 직원들의 급여를 10% 인상하면 인상된 급여의 평균?
        // Ex8. 직원들 중 대리는 몇 명?
        
    }

}
