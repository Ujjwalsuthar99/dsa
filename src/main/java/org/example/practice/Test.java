package org.example.practice;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.management.ObjectName;
import java.io.IOException;
import java.util.*;
import java.util.logging.XMLFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) throws IOException {

//        splitCodeName("Roop Singh (nikhil)");
//        String xml = "<PidData><Resp errCode='0' errInfo='y' fCount='1' fType='0' nmPoints='40' qScore='null' /><DeviceInfo dpId='EVOLUTE.EVOLUTE' rdsId='EVOLUTE.AND.001' rdsVer='1.0.12' dc='8baa6245-a444-4223-8242-7816984453d9' mi='IDENTI5' mc='MIIEEjCCAvqgAwIBAgIGAY3Lh2CuMA0GCSqGSIb3DQEBCwUAMIGnMTkwNwYDVQQDDDBEUyBFVk9MVVRFIEZJTlRFQ0ggSU5OT1ZBVElPTlMgUFJJVkFURSBMSU1JVEVEIDExEjAQBgNVBAgMCUthcm5hdGFrYTETMBEGA1UECwwKTUFOQUdFTUVOVDE0MDIGA1UECgwrRVZPTFVURSBGSU5URUNIIElOTk9WQVRJT05TIFBSSVZBVEUgTElNSVRFRDELMAkGA1UEBhMCSU4wHhcNMjQwMjIxMTE1NzQzWhcNMjQwMzIyMTE1NzQzWjCBzDEoMCYGA1UECgwfRXZvbHV0ZSBTeXN0ZW1zIFByaXZhdGUgTGltaXRlZDEQMA4GA1UECwwHRVZPTFVURTEgMB4GCSqGSIb3DQEJARYRYWRtaW5AZXZvbHV0ZS5jb20xEjAQBgNVBAcMCUJhbmdhbG9yZTESMBAGA1UECAwJS2FybmF0YWthMQswCQYDVQQGEwJJTjE3MDUGA1UEAwwucmRfZGV2aWNlXzhiYWE2MjQ1LWE0NDQtNDIyMy04MjQyLTc4MTY5ODQ0NTNkOTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKt+Gh36FwVImE65IVjzM0Kba+FFHT6QWFfXmrDnY/E8IKFrb+KH2ophqWC6Jp5Oufl7PturH7N9I2DEcZWVxFJvlrTIG9MmOQuYgippaxSDJ9FzReBLhfJga4n8TJZGq1+6xIlnvqYkpj27/A/3RLAz+d1w/zKVf/9zk/z3BoNSGRzDxQuPt1vosd/jOazQwAWEhQdR/S8sYqnp6AEKKmA6uL8Uj8am2NiBzT9D8lO6vNP86IScispph6V8B1a5sH1mCZ6oo6TdJ6ABKuBG1eJbzwofrZtQntgE7dnaqtMQMXhhdfsUcJROr11o+dOG+Z7PUXAznpKqDtDav8PTpTUCAwEAAaMdMBswDAYDVR0TBAUwAwEB/zALBgNVHQ8EBAMCAYYwDQYJKoZIhvcNAQELBQADggEBACk7oeQBKMQ10PgAUzWUvjVxa32msfS8ZRmDpuKzPaoVEIgZDkpr8hzzgsn5g+T0fPv3ndlyddZwMh75IakJocLHNpqivq/945F3HTXliWijuq4urXwCMZBFHS1wMhnr4lKyPxsvE5oTc7YEtATJSDD8bsKGs3Ytnih/+Qb/ouAn5w6ktChi06w8AW231qlnmrAd/jH3CBn0a9/20tkUmxaS5rDRAT6Qa+sIhJnFHhmPa0kuIFWaQpUrtBQN1TJjOWL56Qo3Du/JqT0FR0OYKge5AYNzyV7CtzxP8/tb67r2vSKS8O6KpHiqAK7nWjMNQN8gvKvF2sc4BYPZO0yIoUg='><additional_info><Param name='DeviceSerial' value='IIMPEMCA1931'/><Param name='PrinterSupport' value='N'/></additional_info></DeviceInfo><Skey ci='20250923'>QlPBiDEeegiKACXttpTWXVlRovivBkJzWDqnhf6Bt4SoYBU+Nw291+hmwHnQC59+7HyvG9zXVJqL9HuLqy8en5VynFZ/OgsRlp3GR6ePIZ8e0Xs3YkxIw3T0ZgCFMSaLcAHJqxaKF96E4DS+ze6tTU9cGRQ53DWo9nTNd9ehaa1XfNXvOjXmstd8D2XSAPAUj30Rleya6lfRVTAsH/80iFLIdqJULN1VtCfhLEqbkDjlrjD8pTxTFbhqCDw1ACyW3+EphFxFjBgxiByuswagr+x5whNrkGSty7oz63caaXAPvGzc+vuKQK8ep1+Z7+bz3/5Wd8m02ze6phlltORZrg==</Skey><Hmac>fu4eS71dluzQyHCKip+LHeLwffrKUOccAYSBFrf3zEV+pT7Xg0HhcomqX/6LhYO4</Hmac><Data type='X'>MjAyNC0wMi0yMVQxNzoyNzo1NC+eo2f+6D+U1sxCixdLR/zMzHun+2L38TiOBl3+eTvT7NAFix7oRmMl7acHHZVO1P9KtS7YY/QXF87wL2zaSyVfrCjWTBTn5uxc4x/+sAnxXIvGhxKDNYzp0fbHoECTuVwRz2NJlKCxsfsp/lpa9MwtbgKFmObyeMiPUI+eJyVbCy10HOUzyoKgoKImTMc9hl/WVgKQH/StMEYtISXMkDysTqP5fL/ZalEo6VbezA1J38TNXRxLlR+8YnJdy1mfUlX7jlXtHxRV4xxxG4AQlUaAaDf301ka44Z6tvfTvRacHtGuLqZV2h9IcprlsrnfVX5u3aAOVHbxl78gLmyBBwfeFRK/Y1Q7CtxJ7q3FVtsDgbrCy9q9UfwMtya40jPBTe4aqpDDKbP13lXSAcP73+7Sgvr50u4k+TLdzpenPdVtg8mNAPU4pVMxpQFa707uOGbHi9/hW1os3MZqSMF4dEG5um8C5NWsfF4y9rKWcMCYxP4ZcPWZogygQFnE30yiFEhn1b4g6ePiRB21uESaU2kQD080IpDPjIuR7WxTYSpLOuQ2NusBVhdfa7sHXJCSnDIZbpg5dC9yjaOX3zt+8GGt0nx9KdV6A0vBeEViE0V+yLEhzZjJxOcbWVAhg9bSh3qtUCARHfqRwZkYCYIK6pEbhvYvMyVs9mxVts8AaSjUyCi1IGS6aT0IXS7jHMtFf8BXmaxOm262JY3cpcYRPm5hlyDoek2s5fAdD8r8RpIvyWZMoS9oH10aHQKLx3adWuRyi7A9AxIjjAvIC5Auv8e6VQXj1Pw2PF1MCR3ojtRI3oJkSrwRGlzuOpWXe/Obn92jPOFfnL1LWSMyNTgWVcWnRQ7RbR1luP4buRQnC3DPLRHHMT1//upMzvas+dxcJPxpxVWPJrlwe4fQEE5BN/LlbhdZgQoztzLfQYeh4rz6ufCoIO7fRWQQcwkw0wyBZlcW2eIGgmctoqq74cfw2CJBlqB03hMcGzyPP7P/XnBAP3QtBhiQMI1xnBY6RdSY3Fu3e5Tp2+X1nmw48dKCq8IPmim9LK3bpAQQbbU5nOmOefMTKwbbo/lCoWTC2hWHLMpwQVBt9xqSc9c8u5ZW5Z8+cMNGYfKeQNf97RNLq76//0s2OBmnoZ849HfrKot0Mnhofi0jLfyBnQlp6TGm2J9IXyH92jeBAwc74R5iSvQDsFPWoFdW31sT5lAXC7p+WOCcclid6g7f3Ta6/CQRepiTKu3CbyTrT/OlVBwZ0COUUmzU</Data></PidData>";
//        String[] strArr = {"<DeviceInfo", "/DeviceInfo>", "<Skey" , "/Skey>", "<Hmac", "/Hmac>", "<Data", "/Data>"};
//        int[] intArr = new int[8];
//        int i = 0;
//        for (String s : strArr) {
//            intArr[i++] = xml.indexOf(s);
//        }
//        int whileIteration = 1;
//        List<Object> anss = new LinkedList<>();
//        while (whileIteration < strArr.length) {
//            JSONObject mm = new JSONObject();
//            String key = "";
//            StringBuilder ans = new StringBuilder();
//            for (int j = intArr[whileIteration -1] + strArr[whileIteration-1].length() + 1; j < intArr[whileIteration] + strArr[whileIteration].length(); j++) {
//                if (xml.charAt(j) == ' ' || xml.charAt(j) == '<') {
//                    continue;
//                }
//                if (xml.charAt(j) == '>' || xml.charAt(j-1) == '>') {
//                    while (j != intArr[whileIteration]) {
//                        ans.append(xml.charAt(j));
//                        j++;
//                    }
//                    mm.put("value", ans.substring(1, ans.length() -1));
//                    break;
//                }
//
//                key += xml.charAt(j);
//                if (xml.charAt(j) == '\'') {
//                    StringBuilder value = new StringBuilder();
//                    while (xml.charAt(j+1) != '\'') {
//                        value.append(xml.charAt(j + 1));
//                        j++;
//                    }
//                    mm.put(key.substring(0, key.length() -2), value.toString());
//                    key = "";
//                    j++;
//                }
//            }
////            HashMap<String, Object> keyAns = new HashMap<>();
//            JSONObject formDetailsJson = new JSONObject();
//            formDetailsJson.put(strArr[whileIteration-1].substring(1), mm);
//            anss.add(formDetailsJson);
//            whileIteration+=2;
//        }
//        JSONArray jsonArray = new JSONArray();
//
//
//        for(Object p : anss) {
//            jsonArray.put(p);
//        }
//        System.out.println("jsonArray: "+jsonArray);

        
    }





























}
