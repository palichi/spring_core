생성자 주입


```
    <bean id="user3" class="carami.spring.core.examples.User">
        <constructor-arg index="0" ref="name"/>
    </bean>

    <bean id="user4" class="carami.spring.core.examples.User">
        <constructor-arg index="0" value="홍길동"/>
    </bean>
```

constructor-arg 는 생성자를 이용하여 주입하라는 의미다. index="0"은 첫번째 파라미터에 name레퍼런스의 값을 설정하라는 것을 의미한다.


```


    @Bean
    public User user3(String name) {
        User user = new User(name);
        return user;
    }

    @Bean
    public User user4() {
        User user = new User("홍길동");
        return user;
    }
```

id가 user3으로 등록된 Bean은 User객체로 설정된다. 해당 User객체는 id가 name인 값을 받아들여 생성자에 값을 설정하여 반환하는 것을 알 수 있다.