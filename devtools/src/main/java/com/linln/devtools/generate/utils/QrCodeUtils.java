package com.linln.devtools.generate.utils;

import com.github.binarywang.utils.qrcode.MatrixToLogoImageConfig;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 二维码工具类
 *
 * @author Qian Liping
 * @since 2019/3/29
 */
public final class QrCodeUtils {

    private static final int BLACK = Color.BLACK.getRGB();
    private static final int WHITE = Color.WHITE.getRGB();

    private QrCodeUtils() {
    }

    public static BufferedImage toBufferedImage(BitMatrix matrix) {

        int width = matrix.getWidth();
        int height = matrix.getHeight();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }

        return image;
    }

    /**
     * 根据指定边长创建生成的二维码
     *
     * @param content  二维码内容
     * @param length   二维码的高度和宽度
     * @param logoFile logo 文件对象，可以为空
     * @return 二维码图片的字节数组
     */
    public static BufferedImage createQrcode(String content, int length, File logoFile) throws WriterException, IOException {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix matrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, length, length);

        BufferedImage bufferedImage = toBufferedImage(matrix);

        if (logoFile != null) {
            overlapImage(bufferedImage, logoFile, new MatrixToLogoImageConfig());
        }

        return bufferedImage;
    }

    /**
     * 将logo添加到二维码中间
     *
     * @param image    生成的二维码图片对象
     * @param logoFile logo文件对象
     */
    private static void overlapImage(BufferedImage image, File logoFile,
                                     MatrixToLogoImageConfig logoConfig) throws IOException {

        BufferedImage logo = ImageIO.read(logoFile);
        Graphics2D g = image.createGraphics();
        // 考虑到logo图片贴到二维码中，建议大小不要超过二维码的1/5;
        int width = image.getWidth() / logoConfig.getLogoPart();
        int height = image.getHeight() / logoConfig.getLogoPart();
        // logo起始位置，此目的是为logo居中显示
        int x = (image.getWidth() - width) / 2;
        int y = (image.getHeight() - height) / 2;
        // 绘制图
        g.drawImage(logo, x, y, width, height, null);

        // 给logo画边框
        // 构造一个具有指定线条宽度以及 cap 和 join 风格的默认值的实心 BasicStroke
        g.setStroke(new BasicStroke(logoConfig.getBorder()));
        g.setColor(logoConfig.getBorderColor());
        g.drawRect(x, y, width, height);

        g.dispose();
    }

    public static void writeToStream(BufferedImage image, String format, OutputStream stream)
            throws IOException {

        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }
}
