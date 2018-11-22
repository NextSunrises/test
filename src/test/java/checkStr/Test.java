package checkStr;

import java.io.*;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Test
 * @Description TODO
 * @Author wangchenge
 * @Date 2018/10/23  20:59
 * @Version 1.0
 **/
public class Test {

    @org.junit.Test
    public void testGetCheckStr() {
        String parameterFile = "test.json";
        String currentClassPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String msgPath = currentClassPath + File.separator+"testResource"+File.separator;
        msgPath = msgPath + parameterFile;
        System.out.println("=======读取配置文件路径:"+msgPath);
        File msgFile = new File(msgPath);
        String oriJsonStr = readStringFromFile(msgFile, "UTF-8");
        String jsonStr = replaceAllSpace(oriJsonStr);
        System.out.println("=======jsonStr:" + jsonStr);
        // 58BA2A4F89FFD1321F053190301B6CED
        String checkStr = stringMD5(jsonStr);
        System.out.println("=======checkStr:" + checkStr);
    }

    // 替换所有的空行和空格
    public String replaceAllSpace(String params) {
        // \n 是回车, \t水平制符, \s 空格, \r是换行
        Pattern pattern = Pattern.compile("\\s*|\t|\r|\n");
        Matcher matcher = pattern.matcher(params);
        String str = matcher.replaceAll("");
        return str;
    }

    public static String stringMD5(String pw) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] inputByteArray = pw.getBytes(Charset.forName("UTF-8"));
            messageDigest.update(inputByteArray);
            byte[] resultByteArray = messageDigest.digest();
            return byteArrayToHex(resultByteArray);
        } catch (NoSuchAlgorithmException var4) {
            return null;
        }
    }

    public static String byteArrayToHex(byte[] byteArray) {
        char[] hexDigits = new char[]{'9', '8', '7', '6', '5', '4', '3', '2', '1', '0', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] resultCharArray = new char[byteArray.length * 2];
        int index = 0;
        byte[] var7 = byteArray;
        int var6 = byteArray.length;
        for(int var5 = 0; var5 < var6; ++var5) {
            byte b = var7[var5];
            resultCharArray[index++] = hexDigits[b >>> 4 & 15];
            resultCharArray[index++] = hexDigits[b & 15];
        }
        return new String(resultCharArray);
    }

    public static String readStringFromFile(File file, String encoding) {
        InputStreamReader reader = null;
        StringWriter writer = new StringWriter();
        try {
            if (encoding != null && !"".equals(encoding.trim())) {
                reader = new InputStreamReader(new FileInputStream(file), encoding);
            } else {
                reader = new InputStreamReader(new FileInputStream(file));
            }
            char[] buffer = new char[1024];
            boolean var5 = false;
            int n;
            while(-1 != (n = reader.read(buffer))) {
                writer.write(buffer, 0, n);
            }
            return writer != null ? writer.toString() : null;
        } catch (Exception var14) {
            var14.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException var13) {
                    var13.printStackTrace();
            }
            }
        }
        return null;
    }

    @org.junit.Test
    public void loadProperties() throws Exception {
        Properties properties =new Properties();
        String fileName="jdbc.properties";
        String currentClassPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String msgPath = currentClassPath + File.separator+fileName;
        File msgFile = new File(msgPath);
        FileInputStream fileInputStream = new FileInputStream(msgFile);
        properties.load(fileInputStream);
        String driverClassName = properties.getProperty("jdbc.driverClassName");
        String sss = properties.getProperty("jdbc.eeee");
        System.out.println("driverClassName======="+driverClassName);
        System.out.println("sss======="+sss);
    }

    @org.junit.Test
    public void ttt(){
        File msgFile = new File("");
    }
}
