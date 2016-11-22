
class Person { 
	protected String lastname;
	protected String firstname;
	private int age;
	// ... additional code 
	public Person(String ln, String fn, int a)
	{
		lastname=ln; firstname=fn; age=a;
			
	}
   public String getName() { return firstname + " " + lastname; }
	 public int getAge() { return age; }
}
class Employee extends Person {
	private String title;
	private int salary;
	
	public Employee(String ln, String fn, int a,String title, int salary)
	{
		super( ln , fn, a);
		this.title=title; this.salary=salary;
	}
	
	// ... additional code
		 public String getName() {
		 if (title.equals("Doctor"))
		 return "Dr. " + firstname + " " + lastname; 		
	 return firstname + " " + lastname;
 }}
public class Tester 
{
	 public static void main(String args[])
	 {
		Person mom = new Person("Doe", "Jane", 71);
		Employee doc = new Employee( "Smith", "Jamie",45, "Doctor",	275000);
		Person p;     
		
		p = mom;
		System.out.println(p.getName());
		
		p = doc;
		System.out.println(p.getName());
      } 
}
 