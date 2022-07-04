package kopo.poly.util;

public class CmmUtil {
    public static String nvl(String str, String chg_str) {
        String res;

        if (str == null) {
            res = chg_str;
        } else if (str.equals("")) {
            res = chg_str;
        }else{
            res = str;
        }
        return res;
    }

    public static String nvl(String str) {
        return nvl(str, "");
    }
}
