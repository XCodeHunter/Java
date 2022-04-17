package simpleprograms;

public class concatenação {
  String s1 = "Hello";

  String s2="EISA";

  String s3=s1+s2;
  
  String s4=s1.concat(s2);

  System.out.println(s3==s4);

  System.out.println(s3.equals(s4));
}
