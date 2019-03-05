package test;
import java.util.Random;
import java.util.UUID;
import org.mybatis.spring.SqlSessionFactoryBean;
public class TestCase {
public static void main(String[] args) {
   String a=UUID.randomUUID().toString().toUpperCase();
   long c=0;
   while(true)
   {
	   String b=UUID.randomUUID().toString().toUpperCase();
	   if(b.equals(a))
	   {
		   break;
	   }
	   c++;
	   if(c==100000000)
	   {
		   System.out.println(a.equals(b));
		   break;
	   }
   }
   
}
}
