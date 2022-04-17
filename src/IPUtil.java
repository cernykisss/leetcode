public class IPUtil {

    public static void main(String[] args) {
        System.out.println(ipToLong("10.0.3.193"));
        System.out.println(longToIP(167773121));
    }
    public static long ipToLong(String strIp) {
        String[] nums = strIp.split("\\.");
        long res = (Long.parseLong(nums[0]) << 24) + (Long.parseLong(nums[1]) << 16)
                + (Long.parseLong(nums[2]) << 8) + (Long.parseLong(nums[3]));
        return res;
    }

    public static String longToIP(long longIp) {
        StringBuffer sb = new StringBuffer();
        sb.append(String.valueOf((longIp >>> 24)));
        sb.append(".");
        sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
        sb.append(".");
        sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
        sb.append(".");
        sb.append(String.valueOf((longIp & 0x000000FF)));
        return sb.toString();
    }


}

