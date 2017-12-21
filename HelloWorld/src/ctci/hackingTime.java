package ctci;

/**
 * Created by sunil on 10/30/17.
 */
public class hackingTime {
}

/*
 * Complete the function below.
 */
/*
    static String decrypt(String encrypted_message) {
        String key = getKey();
        //String key = "8251220"; The key is obtained from the method getKey.
        System.out.println(key);
        int i = 0;
        StringBuilder result = new StringBuilder();
        for(char ch: encrypted_message.toCharArray()) {
            if(i == key.length()) i = 0;
            if(Character.isLetter(ch)) {
                char firstLetter = (ch <= 'Z') ? 'A' : 'a';
                ch = (char)(ch - Character.getNumericValue(key.charAt(i)));
                //if we need to cross z to a as ch is -ve
                if(ch < firstLetter) {
                    ch = (char)(ch + 26);
                }
                i++;
            }
            result.append(ch);
        }
        return result.toString();
    }

    static String getKey(){

        String enc = "AtvthrqgseCnikg";
        String dec = "YourfriendAlice";
        String key = "";
        for (int i = 0; i < enc.length(); i++) {
            //if (enc.charAt(i) >= 65 && enc.charAt(i) <= 122) {
            int k = enc.charAt(i) - dec.charAt(i);
            if(k < 0) {
                k = 26 + k;
            }
            key = key + k;
            //}
        }
        //By trail and error method and analysis we can conlcude that the key is 8251220.
        //We trim only the needed portion from the key and pass to the main function.
        key = key.substring(6,13);
        System.out.println(key);

        return key;
    }

*/