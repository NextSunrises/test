package com.tkrs.test;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @ClassName Test
 * @Description TODO
 * @Author wangchenge
 * @Date 2018/9/5  16:57
 * @Version 1.0
 **/
public class Test123 {

    @Test
    /***
     * @Author wcg
     * @Description 判断是否为图片格式文件名
     * @Date 18:55 2018/9/5
     * @Param []
     * @return void
     **/
    public void test() {
        String reg = "(?i).+?\\.(jpg|bmp|png)";
        String fileName = "123.bmp";
        System.out.println(fileName.matches(reg));
    }

    @Test
    public void ttt() throws ParseException {
        String date = "21-9月 -18 01.10.00.998000 下午";
        String pattern = "dd-M月 -yy hh.mm.ss.SSSSSS a";
//        Date date1 = DateUtils.parseDate(date, pattern);
        Date date1 = new SimpleDateFormat(pattern).parse(date);
        System.out.println("date1:" + date1);
        LocalDateTime localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
   /*     ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);//Combines this date-time with a time-zone to create a  ZonedDateTime.
        Date date123 = Date.from(zdt.toInstant());*/
        System.out.println("localDateTime:" + localDateTime);
    }

    /***
     * 创建缩略图（压缩图片）
     * @throws InterruptedException
     * @throws
     */
    @Test
    public void testCompressImg() {
        long start = System.currentTimeMillis();
        String imagePath = "E://img//thumbail1234.jpg";
        String imgsrc = "E://img//15.jpg";
        int widthdist = 400;          //自定义压缩
        int heightdist = 250;
        FileOutputStream out = null;
        Float rate = 0.0f;          //按原图片比例压缩（默认）
        try {
            File srcfile = new File(imgsrc);
            // 检查图片文件是否存在
            if (!srcfile.exists()) {
                System.out.println("文件不存在");
            }
            // 如果比例不为空则说明是按比例压缩
            if (rate != null && rate > 0) {
                //获得源图片的宽高存入数组中
                int[] results = getImgWidthHeight(srcfile);
                if (results == null || results[0] == 0 || results[1] == 0) {

                } else {
                    //按比例缩放或扩大图片大小，将浮点型转为整型
                    widthdist = (int) (results[0] * rate);
                    heightdist = (int) (results[1] * rate);
                }
            }
            // 开始读取文件并进行压缩
            java.awt.Image src = ImageIO.read(srcfile);
            // 构造一个类型为预定义图像类型之一的 BufferedImage
            BufferedImage tag = new BufferedImage((int) widthdist, (int) heightdist, BufferedImage.TYPE_INT_RGB);
            //绘制图像  getScaledInstance表示创建此图像的缩放版本，返回一个新的缩放版本Image,按指定的width,height呈现图像
            //Image.SCALE_SMOOTH,选择图像平滑度比缩放速度具有更高优先级的图像缩放算法。
            tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist, java.awt.Image.SCALE_SMOOTH), 0, 0, null);
            //创建文件输出流
            out = new FileOutputStream(imagePath);
            //将图片按JPEG压缩，保存到out中
//            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//            encoder.encode(tag);
            //关闭文件输出流
        } catch (Exception ef) {
            ef.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);
    }

    public static int[] getImgWidthHeight(File file) {
        InputStream is;
        BufferedImage src;
        int result[] = {0, 0};
        try {
            // 获得文件输入流
            is = new FileInputStream(file);
            // 从流里将图片写入缓冲图片区
            src = ImageIO.read(is);
            result[0] = src.getWidth(null); // 得到源图片宽
            result[1] = src.getHeight(null);// 得到源图片高
            is.close();  //关闭输入流
        } catch (Exception ef) {
            ef.printStackTrace();
        }
        return result;
    }

    @Test
    /**
     * 缩放
     */
    public void zoomImg() {
        try {
            String imagePath = "E://img//thumbail123.jpg";
            String imgsrc = "E://img//11.jpg";
            Thumbnails.of(imgsrc).size(400, 500).toFile(imagePath);//变为400*300,遵循原图比例缩或放到400*某个高度
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     * 按比例缩小
     */
    public void narrowImg() {
        try {
            String imagePath = "E://img//thumbail123.jpg";
            String imgsrc = "E://img//11.jpg";
            Thumbnails.of(imgsrc).scale(0.2f).toFile(imagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cutTest(){
        String imagePath = "E://img//thumbail123.jpg";
        String imgsrc = "E://img//11.jpg";
        cut(imgsrc,imagePath,0,0,200,200);
    }

    /**
     * 图像切割(按指定起点坐标和宽高切割)
     * @param srcImageFile 源图像地址
     * @param result 切片后的图像地址
     * @param x 目标切片起点坐标X
     * @param y 目标切片起点坐标Y
     * @param width 目标切片宽度
     * @param height 目标切片高度
     */
    public final static void cut(String srcImageFile, String result,
                                 int x, int y, int width, int height) {
        try {
            // 读取源图像
            BufferedImage bi = ImageIO.read(new File(srcImageFile));
            int srcWidth = bi.getHeight(); // 源图宽度
            int srcHeight = bi.getWidth(); // 源图高度
            if (srcWidth > 0 && srcHeight > 0) {
                Image image = bi.getScaledInstance(srcWidth, srcHeight,
                        Image.SCALE_DEFAULT);
                // 四个参数分别为图像起点坐标和宽高
                // 即: CropImageFilter(int x,int y,int width,int height)
                ImageFilter cropFilter = new CropImageFilter(x, y, width, height);
                Image img = Toolkit.getDefaultToolkit().createImage(
                        new FilteredImageSource(image.getSource(),
                                cropFilter));
                BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                g.drawImage(img, 0, 0, width, height, null); // 绘制切割后的图
                g.dispose();
                // 输出为文件
                ImageIO.write(tag, "JPEG", new File(result));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void scale1(){
        String imgSrc = "E://img//13.jpg";
        String result="E://img//thumbail123.jpg";
        File srcFile=new File(imgSrc);
        BufferedImage bufferedImage=null;
        FileOutputStream out = null;
        try {
            bufferedImage= ImageIO.read(srcFile);
            int width = bufferedImage.getWidth(); // 得到源图宽
            int height = bufferedImage.getHeight(); // 得到源图长
            int minium=width<=height?width:height;
            Image image = bufferedImage.getScaledInstance(minium, minium,Image.SCALE_SMOOTH);
            BufferedImage desImage = new BufferedImage(minium, minium,
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = desImage.getGraphics();
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
            g.dispose();
            //ImageIO.write(desImage, "JPEG", new File(result));// 输出到文件流
//            tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist, java.awt.Image.SCALE_SMOOTH), 0, 0, null);
//            //创建文件输出流
            out = new FileOutputStream(result);
            //将图片按JPEG压缩，保存到out中
//            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//            encoder.encode(desImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void scale2() throws IOException {
        String imgSrc = "E://img//15.jpg";
        String result="E://img//thumbail1232.jpg";
        File srcFile=new File(imgSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            BufferedImage bufferedImage= ImageIO.read(srcFile);
            int width = bufferedImage.getWidth(); // 得到源图宽
            int height = bufferedImage.getHeight(); // 得到源图长
            System.out.println("============"+width);
            System.out.println("============"+height);
            int minium=(int)((width<=height?width:height)*0.1);
            System.out.println("============"+minium);
            Thumbnails.of(srcFile).forceSize(200, 200).toOutputStream(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File desFIle=new File(result);
        FileOutputStream fileOutputStream = new FileOutputStream(desFIle);
        fileOutputStream.write(output.toByteArray());
    }
    File file = new File("E://img//t.jpg");
    @Test
    public void scale3() throws IOException {
        String result="E://img//thumbail1.jpg";
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        Thumbnails.of(file).forceSize(200, 200).toOutputStream(outputStream);
    }
    @Test
    public void tt(){
        int $某变量 = 3;
        System.out.println("某变量="+$某变量);
        byte[] b=null;
        String s = new String(Base64.encodeBase64(b));
        System.out.println("============"+s);
    }

    @Test
    public void test1234() throws IOException {
        String base64="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";
        byte[] oriBuffer = Base64.decodeBase64(base64);
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        Thumbnails.of(new ByteArrayInputStream(oriBuffer))
                .forceSize(200,200).toOutputStream(byteArrayOutputStream);
    }
    @Test
    public void tttttttt() throws IOException {
        byte[] b =Files.readAllBytes(Paths.get("E://img//123.jpg"));
        String base64String = Base64.encodeBase64String(b);
//        base64String="data:image/png;base64,"+base64String;
        System.out.println("============="+base64String);
        if(base64String.indexOf(",")>0){
            base64String=base64String.substring(base64String.indexOf(",")+1,base64String.length());
        }
        final byte[] oriBuffer = Base64.decodeBase64(base64String);
        long start = System.currentTimeMillis();
        byte[] scaleBuffer = scaleImg(oriBuffer);
        long end = System.currentTimeMillis();
        System.out.println("======用时:"+(end-start)/1000);

    }

    private byte[] scaleImg(byte[] oriBuffer) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] byteArray = null;
        try {
            Thumbnails.of(new ByteArrayInputStream(oriBuffer)).forceSize(200, 200).toOutputStream(output);
            byteArray = output.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return byteArray;
    }

    private static  final String sss="TEMP_";
    @Test
    public void test111(){
        String str="TEMP_12312312312312";
        String temp = str.replace(sss, "");
        System.out.println(temp);
        System.out.println(str);
    }
}
