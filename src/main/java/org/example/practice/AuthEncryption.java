package org.example.practice;

public class AuthEncryption {

    final String salt = "11111111";

    public String createTokenWithSalt(String s) {
        String res="";
        for(char c: s.toCharArray()) {
            String binary = toBinary(c);
            int k=salt.length()-binary.length();
            res += customXOR(binary, k);
        }
        return res;
    }

    public String customXOR(String binary, int start) {
        int temp = start;
        String s="";
        for(char c: binary.toCharArray()) {
            switch(c) {
                case '0':
                    if(salt.charAt(temp)=='0') s+='0';
                    else s+='1';
                    break;
                case '1':
                    if(salt.charAt(temp)=='1') s+='0';
                    else s+='1';
                    break;
            }
            temp++;
        }
        return salt.substring(0, start)+s;
    }

    public String getPayloadWithToken(String token) {
        int dotIdx = token.indexOf(".");
        String headerEncoded = token.substring(0, dotIdx);
//		String bodyEncoded = token.substring(dotIdx+1);
        return decodeToken(headerEncoded);
    }

    public String decodeToken(String content) {
        if(content.length()%8!=0) return "Invalid header";
        String res="";
        for(int i=0; i<content.length(); i+=8) {
            String value = content.substring(i, i+8);
            String s = customXOR(value, 0);
            int ascii = toDecimal(s, 0);
            res += ((char) ascii);
        }
        return res;
    }

    public String toBinary(int num) {
        if(num<=0) return "";
        return toBinary(num/2)+num%2;
    }

    public int toDecimal(String s, int i) {
        if(i>=s.length()) { return 0; }
        int dec=toDecimal(s, i+1)+Character.getNumericValue(s.charAt((s.length()-1)-i))*(int)(Math.pow(2, i));
        return dec;
    }
}
