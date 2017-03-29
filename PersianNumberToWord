import java.math.BigDecimal;

/**
 * Created by mortezasun on 3/29/2017.
 */

public class PersianNumberToWord    {
   private static String[] yekan = new String[]{" یک ", " دو ", " سه ", " چهار ", " پنج ", " شش ", " هفت ", " هشت ", " نه "};
    private static String[] dahgan =new String[]{" بیست ", " سی ", " چهل ", " پنجاه ", " شصت ", " هفتاد ", " هشتاد ", " نود "};
    private static String[] sadgan =new String[] {" یکصد ", " دویست ", " سیصد ", " چهارصد ", " پانصد ", " ششصد ", " هفتصد ", " هشتصد ", " نهصد "};
    private static String[] dah = new String[]{" ده ", " یازده ", " دوازده ", " سیزده ", " چهارده ", " پانزده ", " شانزده ", " هفده ", " هیجده ", " نوزده "};

    public static String onWork(BigDecimal num, String Unit) {
       return onDo(num,0) + " "+Unit;
    }
    private static String onDo(BigDecimal num,int level){
        if (num == null) {
            return "";
        }
        // convert negative number to positive and get wordify value
        if (num.compareTo(new BigDecimal(0))<0) {
            num = num.negate();
            return "منفی " + onDo(num,level);
        }
        if (num.compareTo(new BigDecimal(0))==0) {
            if (level == 0) {
                return "صفر";
            } else {
                return "";
            }

        }
        String result ="";
        if (level > 0) {
            result += " و ";
            level -= 1;
        }

        if (num.compareTo(new BigDecimal(10))<0) {
            result += yekan[num.add(new BigDecimal(1).negate()).intValue()];
        } else if (num.compareTo(new BigDecimal(20))<0) {
            result += dah[num.add(new BigDecimal(10).negate()).intValue()];
        } else if (num.compareTo(new BigDecimal(100))<0) {
            result += dahgan[num.divide(new BigDecimal(10)).add(new BigDecimal(2).negate()).intValue()] +  onDo(num.remainder(new BigDecimal(10)), level + 1);
        } else if (num.compareTo(new BigDecimal(1000))<0) {
            result += sadgan[num.divide(new BigDecimal(100)).add(new BigDecimal(1).negate()).intValue()] +  onDo(num.remainder(new BigDecimal(100)), level + 1);
        } else if (num.compareTo(new BigDecimal(1000000))<0) {
            result += onDo(num.divide(new BigDecimal(1000)), level) + " هزار " + onDo(num.remainder(new BigDecimal(1000)), level + 1);
        } else if (num.compareTo(new BigDecimal(1000000000))<0) {
            result += onDo(num.divide(new BigDecimal(1000000)), level) + " میلیون " + onDo(num.remainder(new BigDecimal(1000000)), level + 1);
        } else if (num.compareTo(new BigDecimal(Long.valueOf("1000000000000")))<0) {
            result += onDo(num.divide(new BigDecimal(Long.parseLong("1000000000"))), level) + " میلیارد " + onDo(num.remainder(new BigDecimal(Long.parseLong("1000000000"))), level + 1);
        } else if (num.compareTo(new BigDecimal(Long.valueOf("1000000000000000")))<0) {
            result += onDo(num.divide(new BigDecimal(Long.parseLong("1000000000000"))), level) + " تریلیارد " + onDo(num.remainder(new BigDecimal(Long.parseLong("1000000000000"))), level + 1);
        }
        return result;
    }
}
