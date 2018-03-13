package com.kakarot.plcenter.demo;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class N_10 {

    /**
     * 十六进制转换字符串
     * @param hex String 十六进制
     * @return String 转换后的字符串
     */
    public static String hex2bin(String hex) {
        String digital = "0123456789ABCDEF";
        char[] hex2char = hex.toCharArray();
        byte[] bytes = new byte[hex.length() / 2];
        int temp;
        for (int i = 0; i < bytes.length; i++) {
            temp = digital.indexOf(hex2char[2 * i]) * 16;
            temp += digital.indexOf(hex2char[2 * i + 1]);
            bytes[i] = (byte) (temp & 0xff);
        }
        return new String(bytes);
    }

    public static void main(String[] args) {
        System.out.println(N_10.hex2bin("aa15d511d21fbac178e14f9d43082ba63727a121f2eb0812f2a9560272530db0a7631b8a16aae19807ca9077680a2d76414476318c3c0099133d293f2f5bfc917779ecab4a0f6d57438cacc656d67403f8e83cdf86cfd4ea115ef438e7de8a84232c9f9918f74ac97c149e3d91a073633a47cbe64aa02fa0812063d850ee8707"));

    }
}
