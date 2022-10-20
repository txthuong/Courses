import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegrexPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String text = "Please email us at mentor@rahulshettyacademy.com with below template to receive response";
		//Pattern p = Pattern.compile("Please email us at (.+\\.com) with below template to receive response");
        String regexStr = "Please email us at (.+\\.com) with below template to receive response";
        Pattern p = Pattern.compile(regexStr);
		Matcher matcher = p.matcher(text);
		matcher.find();
		String email = matcher.group(1);
		System.out.println(email);
	}

}
