package org.example.design.copies;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Main {

    public static void main(String[] args) {

//        int i = 010;
//        int j = 07;
//
//        System.out.println(i);
//        System.out.println(j);

        BigDecimal s = new BigDecimal(String.valueOf(500000000));
//        BigInteger bigIntValue = s.toBigInteger();

//        String s = "https://api-preprod.synofin.tech/oauth/authorization";

//        String apiGateway = s.substring(0, s.indexOf("/", 8) + 1);
        System.out.println("Try programiz.pro " + formatAmount(s));

    }


    public static String formatAmount(BigDecimal val) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');

        DecimalFormat indianFormatter = new DecimalFormat("##,##,###", symbols);

        if (val.stripTrailingZeros().scale() > 0) {
            DecimalFormat formatterWithDecimal = new DecimalFormat("##,##,##0.00", symbols);
            return formatterWithDecimal.format(val);
        } else {
            DecimalFormat formatterWithoutDecimal = new DecimalFormat("##,##,##0", symbols);
            return formatterWithoutDecimal.format(val);
        }
    }

    /* kasnnsmdfjhsdf ***** */
//    /* kasnnsmdfjhsdf /* sjdhnsi */*/
    /* kasnnsmdfjhsdf // sjdhnsi */
//    /* kasnnsmdfjhsdf // // sjdhnsi */

}
