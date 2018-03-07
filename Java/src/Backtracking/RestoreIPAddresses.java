package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 9/15/16.
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> rst = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return rst;
        }
        ipHelper(rst, new ArrayList<String>(), s, 0);
        return rst;
    }

    private void ipHelper(List<String> rst, List<String> list, String s, int pos) {
        if (list.size() == 4) {
            if (pos != s.length()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String tmp : list) {
                sb.append(tmp);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            rst.add(sb.toString());
            return;
        }
        for (int i = pos; i < s.length() && i < pos + 3; i++) {
            String tmp = s.substring(pos, i + 1);
            if (isvalidIp4(tmp)) {
                list.add(tmp);
                ipHelper(rst, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isvalidIp4(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }


    public List<String> restoreIpAddressesShorter(String s) {
        List<String> validIps = new ArrayList<String>();
        restoreIpHelper(s, validIps, 0, "", 0);
        return validIps;
    }

    private void restoreIpHelper(String ip, List<String> validIps, int idx, String restored, int count) {
        if (count > 4) return;
        if (count == 4 && idx == ip.length()) validIps.add(restored);

        for (int i=1; i<4; i++) {
            if (idx+i > ip.length()) break;
            String s = ip.substring(idx,idx+i);
            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) continue;
            restoreIpHelper(ip, validIps, idx+i, restored+s+(count==3?"" : "."), count+1);
        }
    }
}
