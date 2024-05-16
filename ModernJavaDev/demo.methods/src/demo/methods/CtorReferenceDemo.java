package demo.methods;

public class CtorReferenceDemo {
    
    public static void main(String[] args) {
    
    	SimplePersonProvider provider1 = Person::new;    
    	Person person1 = provider1.getPerson();
    	System.out.println(person1);
    	
    	ParameterizedPersonProvider provider2 = Person::new;
    	Person person2 = provider2.getPerson("Ashley Williams", 30, true);
    	System.out.println(person2);
    }
}

interface SimplePersonProvider {
    Person getPerson();
}

interface ParameterizedPersonProvider {
    Person getPerson(String name, int age, boolean welsh);
}
