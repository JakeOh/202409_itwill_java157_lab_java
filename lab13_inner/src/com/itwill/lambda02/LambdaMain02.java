package com.itwill.lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface MyFilter {
    boolean test(Object x);
}

public class LambdaMain02 {
    
    public List<Object> filter(List<Object> list, MyFilter filter) {
        List<Object> result = new ArrayList<>();
        
        for (Object x : list) {
            if (filter.test(x)) {
                result.add(x);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        // 메인 클래스의 non-static 메서드들을 사용하기 위해서, 메인 객체를 생성.
        LambdaMain02 app = new LambdaMain02();
        
        List<Object> numbers = Arrays.asList(1, 2, 3, 10, 20, 30, 11, 12, 13);
        System.out.println(numbers);
        
        // numbers의 원소들 중에서 홀수들만 저장하는 리스트를 만들자.
        List<Object> odds = app.filter(numbers, new MyFilter() {
            @Override
            public boolean test(Object x) {
                return (Integer) x % 2 == 1;
            }
        });
        System.out.println(odds);
        
        // numbers의 원소들 중에서 짝수들만 저장하는 리스트를 만들자.
        List<Object> evens = app.filter(numbers, (x) -> (Integer) x % 2 == 0);
        System.out.println(evens);

    }

}
