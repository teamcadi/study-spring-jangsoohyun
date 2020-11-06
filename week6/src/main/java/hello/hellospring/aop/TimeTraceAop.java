package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component //스프링빈으로 등록 (컴포넌트스캔하거나 스프링빈을 만들어주면됨)
public class TimeTraceAop {
    @Around("execution(* hello.hellospring..*(..))") //패키지하위에 다 적용시킴
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString()); //어떤 메소드를 콜할지 보여줌

        try {
            return joinPoint.proceed(); //다음 로직으로 진행
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs + "ms");
        }
    }
}