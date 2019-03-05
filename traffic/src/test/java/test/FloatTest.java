package test;

import java.text.DecimalFormat;

public class FloatTest {
	public static void main(String[] args) {
		String a = "12327.10";
		String b = "1773.30";
		String c = Float.parseFloat(a) + Float.parseFloat(b) + "";
		DecimalFormat df = new DecimalFormat("#########.00");
		String s = df.format(Float.parseFloat(a) + Float.parseFloat(b));
		System.out.println(s);
	}
}
