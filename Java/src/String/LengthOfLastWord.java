package String;

/**
 * Created by jianmei on 7/10/16.
 */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {

		return s.trim().length()-s.trim().lastIndexOf(" ")-1;
	}
}
