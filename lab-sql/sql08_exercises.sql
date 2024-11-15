/*
 * hr 계정 테이블 연습문제
 */

-- 아래 문제들에서 직원의 이름은
-- 이름(first_name)과 성(last_name)을 붙여서 하나의 컬럼으로 출력.

-- 1. 직원의 이름과 부서 이름을 출력. (inner join)
select
    e.first_name || ' ' || e.last_name as NAME,
    d.department_name
from employees e
    join departments d on e.department_id = d.department_id;

select
    e.first_name || ' ' || e.last_name as NAME,
    d.department_name
from employees e, departments d 
where e.department_id = d.department_id;

-- 2. 직원의 이름과 부서 이름을 출력. 부서 번호가 없는 직원도 출력.
select
    e.first_name || ' ' || e.last_name as NAME,
    d.department_name
from employees e
    left join departments d on e.department_id = d.department_id;

select
    e.first_name || ' ' || e.last_name as NAME,
    d.department_name
from employees e, departments d 
where e.department_id = d.department_id(+);

-- 3. 직원의 이름과 직무 이름(job title)을 출력.
select
    e.first_name || ' ' || e.last_name as NAME,
    j.job_title
from employees e
    join jobs j on e.job_id = j.job_id;

select
    e.first_name || ' ' || e.last_name as NAME,
    j.job_title
from employees e, jobs j 
where e.job_id = j.job_id;

-- 4. 직원의 이름과 직원이 근무하는 도시 이름(city)를 출력.
select
    e.first_name || ' ' || e.last_name as NAME,
    l.city
from employees e
    join departments d on e.department_id = d.department_id
    join locations l on d.location_id = l.location_id;

select
    e.first_name || ' ' || e.last_name as NAME,
    l.city
from employees e, departments d, locations l
where e.department_id = d.department_id
    and d.location_id = l.location_id;
    
-- 5. 직원의 이름과 직원이 근무하는 도시 이름(city)를 출력. 근무 도시를 알 수 없는 직원도 출력.
select
    e.first_name || ' ' || e.last_name as NAME,
    l.city
from employees e
    left join departments d on e.department_id = d.department_id
    left join locations l on d.location_id = l.location_id;

select
    e.first_name || ' ' || e.last_name as NAME,
    l.city
from employees e, departments d, locations l
where e.department_id = d.department_id(+)
    and d.location_id = l.location_id(+);

-- 6. 2008년에 입사한 직원들의 이름을 출력.
select
    e.first_name || ' ' || e.last_name as NAME,
    hire_date
from employees e
-- where to_char(hire_date, 'YYYY') = '2008'
-- where hire_date between '2008/01/01' and '2008/12/31'
where hire_date between to_date('08/01/01', 'RR/MM/DD') 
                and to_date('08/12/31', 'RR/MM/DD')
;

-- 7. 2008년에 입사한 직원들의 부서 이름과 부서별 인원수 출력.
select
    d.department_name, count(*)
from departments d
    join employees e on d.department_id = e.department_id
where to_char(hire_date, 'YYYY') = '2008'
group by d.department_name;

select
    d.department_name, count(*)
from departments d, employees e 
where to_char(hire_date, 'YYYY') = '2008'
    and d.department_id = e.department_id
group by d.department_name;

-- 8. 2008년에 입사한 직원들의 부서 이름과 부서별 인원수 출력. 
--    단, 부서별 인원수가 5명 이상인 경우만 출력.
select
    d.department_name, count(*)
from departments d
    join employees e on d.department_id = e.department_id
where to_char(hire_date, 'YYYY') = '2008'
group by d.department_name
having count(*) >= 5;

select
    d.department_name, count(*)
from departments d, employees e 
where to_char(hire_date, 'YYYY') = '2008'
    and d.department_id = e.department_id
group by d.department_name
having count(*) >= 5;

-- 9. 부서번호, 부서별 급여 평균을 검색. 소숫점 한자리까지 반올림 출력.

-- 10. 부서별 급여 평균이 최대인 부서의 부서번호, 급여 평균을 출력.

-- 11. 사번, 직원 이름, 국가 이름, 급여 출력.

-- 12. 국가이름, 국가별 급여 합계 출력.

-- 13. 사번, 직원이름, 직무 이름, 급여를 출력.

-- 14. 직무 이름, 직무별 급여 평균, 최솟값, 최댓값을 출력.

-- 15. 국가 이름, 직무 이름, 국가별 직무별 급여 평균을 출력.

-- 16. 국가 이름, 직무 이름, 국가별 직무별 급여 합계을 출력.
--     미국에서, 국가별 직무별 급여 합계가 50,000 이상인 레코드만 출력.
