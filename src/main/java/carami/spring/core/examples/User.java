package carami.spring.core.examples;

// Bean클래스
public class User {

    // private하게 필드를 선언
    private String name;

    // 기본 생성자가 있어야 한다
    public User(){

    }

    public User(String name){
        this.name = name;
    }

    // private한 필드를 접근하기 위한 seter, getter메소드가 있어야 한다.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
