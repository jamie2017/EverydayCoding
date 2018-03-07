package String;

/**
 * Created by JMYE on 6/27/17.
 */
public class ValidateIpAddress {
    String IPv6char = "0123456789abcdefABCDEF";
    public String validIPAddress(String IP) {
        String[] IPv4 = IP.split("\\.");
        boolean isIpv4 = true;
        if (IPv4.length == 4 && numberOfToken(IP, '.') == 3) {
            for (int i = 0; i < 4; i++) {
                if (!isValidIpv4(IPv4[i])) {
                    isIpv4 = false;
                    break;
                }
            }
        }
        else {
            isIpv4 = false;
        }
        if (isIpv4) {
            return "IPv4";
        }

        String[] IPv6 = IP.split(":");
        boolean isIpv6 = true;
        if (IPv6.length == 8 && numberOfToken(IP,':') == 7) {
            for (int i = 0; i < 8; i++) {
                if(!isValidIpv6(IPv6[i])){
                    isIpv6 = false;
                    break;
                }
            }
        } else {
            isIpv6 = false;
        }
        if (isIpv6){
            return "IPv6";
        }
        return "Neither";
    }

    private int numberOfToken(String IP,char token) {
        int num = 0;
        for (int i = 0; i < IP.length(); ++i) {
            if (IP.charAt(i) == token) {
                num++;
            }
        }
        return num;
    }

    private boolean isValidIpv4(String str) {
        int num = 0;
        if (str.equals("") || str.length() > 3) {
            return false;
        }
        if (str.length() > 1 && str.charAt(0) == '0') {
            return false;
        }
        for (int i = 0; i < str.length();++i) {
            if(!Character.isDigit(str.charAt(i))) {
                return false;
            } else {
                num = num * 10 + str.charAt(i)-'0';
            }
        }
        if (num >= 0 && num < 256) {
            return true;
        }
        return false;
    }

    private boolean isValidIpv6(String str) {
        if (str.equals("") || str.length() > 4) {
            return false;
        }
        for (int i = 0; i < str.length(); ++i) {
            if (IPv6char.indexOf(str.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }
}
