package ems.member.configration;

import ems.member.DataBaseConnectionInfo;
import ems.member.dao.StudentDao;
import ems.member.service.StudentRegisterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {

    //<bean id="studentDao" class="ems.member.dao.StudentDao" ></bean>
    // 반환형 = 클래스 태그, 이름 = id 태그
    @Bean
    public StudentDao studentDao(){
        return new StudentDao();
    }

    //<bean id="registerService" class="ems.member.service.StudentRegisterService">
    //		<constructor-arg ref="studentDao" ></constructor-arg>
    //	</bean>
    @Bean
    public StudentRegisterService registerService(){
        return new StudentRegisterService(studentDao());
    }

    //<bean id="dataBaseConnectionInfoDev" class="ems.member.DataBaseConnectionInfo">
    //		<property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:xe" />
    //		<property name="userId" value="scott" />
    //		<property name="userPw" value="tiger" />
    //	</bean>
    @Bean
    public DataBaseConnectionInfo dataBaseConnectionInfoDev(){
        DataBaseConnectionInfo infoDev = new DataBaseConnectionInfo();
        infoDev.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        infoDev.setUserId("scott");
        infoDev.setUserPw("tiger");

        return infoDev;
    }
}
