package ByComs.Twitter;

/**
 * Created by JMYE on 8/3/17.
 */
public class HackingTime {
    static String getKey(String tweets, String signature){
        char[] sig_arr = signature.toCharArray();
        char[] twe_arr = tweets.toCharArray();

        int letter_len = 0;
        for(char c : sig_arr){
            if(Character.isLetter(c)) letter_len++;
        }
        char[] keys = new char[letter_len];

        int sig_cur = sig_arr.length - 1;
        int twe_cur = twe_arr.length - 1;
        letter_len--;
        while(sig_cur >= 0){
            if(Character.isLetter(sig_arr[sig_cur])){
                char sig = sig_arr[sig_cur];
                char twe = twe_arr[twe_cur];
                int tmp  = sig - twe;
                //System.out.println(-tmp);
                int offset = (twe - sig) < 0 ? (twe + 26 - sig) : (twe - sig);
                keys[letter_len] = (char)('0' + offset);
                letter_len--;
            }
            sig_cur--;
            twe_cur--;
        }
        System.out.println(keys);
        String short_key = shortenKey(new String(keys));
        System.out.println();
        System.out.println(short_key);
        for(int i = 1; i < short_key.length(); i++){
            StringBuilder key_builder = new StringBuilder();
            key_builder.append(short_key.substring(i));
            key_builder.append(short_key.substring(0, i));
            String tmp_key = key_builder.toString();
            String new_tweets = decrypt(tweets, tmp_key);
            if(new_tweets.substring(new_tweets.length() - signature.length()).equals(signature)){
                return tmp_key;
            }
        }
        return "";
    }

    static String shortenKey(String keys){
        String reverse_keys = reverse(keys);
        int end = 1;//end == 7
        String tmp_key = "";
        while(end < reverse_keys.length()){
            System.out.println(tmp_key);
            tmp_key = reverse_keys.substring(0, end);////2802215
            int tmp_len = tmp_key.length();//7
            int tmp_begin = end ;//
            while(tmp_begin + tmp_len <= reverse_keys.length()){
                if(!tmp_key.equals(reverse_keys.substring(tmp_begin, tmp_begin + tmp_len))){
                    break;
                }else{
                    tmp_begin += tmp_len;
                }
            }

            if(tmp_begin + tmp_len <= reverse_keys.length()){
                end++;
            }else{
                int i = 0;
                while(tmp_begin < reverse_keys.length() && reverse_keys.charAt(tmp_begin) == tmp_key.charAt(i)){
                    i++;
                    tmp_begin++;
                }
                if(tmp_begin == reverse_keys.length()){
                    return reverse(tmp_key);
                }else{
                    end++;
                }
            }
        }
        return reverse(tmp_key);
    }
    static String reverse(String s){
        char[] arr = s.toCharArray();
        int begin = 0, end = arr.length - 1;
        while(begin < end){
            char tmp  = arr[begin];
            arr[begin] = arr[end];
            arr[end] = tmp;
            begin++;
            end--;
        }
        return new String(arr);
    }

    static String decrypt(String tweets, String key){
        char[] key_arr = key.trim().toCharArray();
        int len = key_arr.length;

        char[] tweets_arr = tweets.toCharArray();
        int letter = 0;
        for(int i = 0; i< tweets_arr.length; i++){
            if(Character.isLetter(tweets_arr[i])){
                boolean upper = Character.isUpperCase(tweets_arr[i]);
                int offset = key_arr[letter % len] - '0';
                tweets_arr[i] = (char)(tweets_arr[i] - offset);
                if(upper && tweets_arr[i] < 'A'){
                    tweets_arr[i] += 26;
                }
                if(!upper && tweets_arr[i] < 'a'){
                    tweets_arr[i] += 26;
                }
                letter++;
            }
        }
        return new String(tweets_arr);
    }

    public static void main(String[] args) {
        String tweets = "Otjfvknou kskgnl, K mbxg iurtsvcnb ksgq hoz atv. Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez.-Atvt hrqgse, Cnikg";
        String signature = "-Your friend, Alice";
        String key = getKey(tweets,signature);
        System.out.println(key);
        System.out.println(decrypt(tweets,key));

    }
}
