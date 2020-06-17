package com.zyxx.fileserver.util;

import com.zyxx.fileserver.consts.FileServerConst;
import com.zyxx.fileserver.entity.FileServer;
import com.zyxx.fileserver.enums.FileServerEnums;
import com.zyxx.fileserver.exception.FileServerException;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 文件上传工具类
 *
 * @author Tellsea
 * @date 2019/8/20
 */
@Slf4j
public class FileServerUtils {

    public static final String DATE_TYPE_SLASH = "yyyy" + File.separator + "MM" + File.separator + "dd";

    public static FileServer upload(MultipartFile file, String folder) {
        // 文件名
        String fileName = String.valueOf(UUID.randomUUID());
        // 文件类型
        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
        // 时间文件夹
        String datePath = getDatePath(folder, DATE_TYPE_SLASH);
        // 相对路径
        String relativePath = datePath.concat(fileName).concat(fileType);
        // 绝对路径
        String destFile = FileServerConst.SAVE_POSITION.concat(datePath);
        File f = new File(destFile);
        if (!f.exists() && !f.isDirectory()) {
            f.mkdirs();
        }
        // 文件全路径
        destFile = destFile.concat(fileName).concat(fileType);
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(destFile);
            Files.write(path, bytes);
            log.info("上传成功...");
            log.info("相对路径：{}", relativePath);
            log.info("绝对路径：{}", destFile);
            return new FileServer().setFileName(fileName)
                    .setFileType(fileType)
                    .setDatePath(datePath)
                    .setDestFile(destFile)
                    .setRelativePath(relativePath);
        } catch (Exception e) {
            throw new FileServerException(FileServerEnums.SAVE_ERROR.getInfo());
        }
    }

    /**
     * 压缩上传
     *
     * @param file
     * @param folder
     * @param saveOld 是否保存原图
     * @return
     */
    public static FileServer uploadByThumbnail(MultipartFile file, String folder, boolean saveOld) {
        FileServer fileServer = upload(file, folder);
        try {
            File toFile;
            if (saveOld) {
                String path = FileServerConst.SAVE_POSITION
                        .concat(fileServer.getDatePath())
                        .concat(fileServer.getFileName())
                        .concat(FileServerConst.THUMBNAIL_SUFFIX)
                        .concat(fileServer.getFileType());
                toFile = new File(path);
                String newFilePath = fileServer.getDatePath().concat(fileServer.getFileName()).concat(FileServerConst.THUMBNAIL_SUFFIX).concat(fileServer.getFileType());
                fileServer.setRelativePath(fileServer.getRelativePath().concat(FileServerConst.THUMBNAIL_SEPARATOR) + newFilePath);
            } else {
                toFile = new File(fileServer.getDestFile());
            }
            Thumbnails.of(fileServer.getDestFile())
                    .imageType(BufferedImage.TYPE_INT_ARGB)
                    // 指定图片大小    0-1f  1f是原图
                    .scale(0.5f)
                    // 图片质量  0-1f  1f是原图
                    .outputQuality(0.8f)
                    .toFile(toFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileServerException(FileServerEnums.THUMBNAILS_ERROR.getInfo());
        }
        return fileServer;
    }

    /**
     * 获得保存路径
     *
     * @param folder
     * @param dateFormat
     * @return 例如：/aaa/2020/04/11/
     */
    public static String getDatePath(String folder, String dateFormat) {
        String date = new SimpleDateFormat(dateFormat).format(new Date());
        StringBuffer path = new StringBuffer();
        path.append(File.separator).append(folder).append(File.separator).append(date).append(File.separator);
        return path.toString().replace("\\", "/");
    }

    /**
     * 将指定文件夹打包
     *
     * @param sourceFilePath :待压缩的文件路径
     * @param zipFilePath    :压缩后存放路径
     * @param fileName       :压缩后文件的名称
     * @return
     */
    public static boolean folderToZip(String sourceFilePath, String zipFilePath, String fileName) {
        boolean flag = false;
        File sourceFile = new File(sourceFilePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;

        if (!sourceFile.exists()) {
            throw new FileServerException("待压缩的文件目录：" + sourceFilePath + "不存在.");
        } else {
            try {
                File zipFile = new File(zipFilePath + File.separator + fileName + ".zip");
                if (zipFile.exists()) {
                    zipFile.delete();
                }
                File[] sourceFiles = sourceFile.listFiles();
                if (null == sourceFiles || sourceFiles.length < 1) {
                    throw new FileServerException("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
                } else {
                    fos = new FileOutputStream(zipFile);
                    zos = new ZipOutputStream(new BufferedOutputStream(fos));
                    byte[] bufs = new byte[1024 * 10];
                    for (int i = 0; i < sourceFiles.length; i++) {
                        //创建ZIP实体，并添加进压缩包
                        ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
                        zos.putNextEntry(zipEntry);
                        //读取待压缩的文件并写进压缩包里
                        fis = new FileInputStream(sourceFiles[i]);
                        bis = new BufferedInputStream(fis, 1024 * 10);
                        int read = 0;
                        while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                            zos.write(bufs, 0, read);
                        }
                    }
                    flag = true;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                //关闭流
                try {
                    if (null != bis) {
                        bis.close();
                    }
                    if (null != zos) {
                        zos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return flag;
    }

    /**
     * 得到图片字节流 数组大小
     */
    public static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }

    /**
     * 将文件转换成Byte数组
     *
     * @param file
     * @return
     */
    public static byte[] getBytesByFile(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            byte[] data = bos.toByteArray();
            bos.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * MultipartFile转File
     *
     * @param param
     * @return
     */
    public static File transfer(MultipartFile param) {
        if (!param.isEmpty()) {
            File file = null;
            try {
                InputStream in = param.getInputStream();
                file = new File(param.getOriginalFilename());
                OutputStream out = new FileOutputStream(file);
                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                in.close();
                out.close();
                return file;
            } catch (Exception e) {
                e.printStackTrace();
                return file;
            }
        }
        return null;
    }

    /**
     * 获取指定文件的输入流
     *
     * @param logoPath 文件的路径
     * @return
     */
    public static InputStream getResourceAsStream(String logoPath) {
        return FileServerUtils.class.getResourceAsStream(logoPath);
    }

    /**
     * 下载文件
     *
     * @param filePath 访问路径
     * @param fileName 下载文件名
     * @param request
     * @param response
     */
    public static void download(String filePath, String fileName, HttpServletRequest request, HttpServletResponse response) {
        File file = new File(FileServerConst.SAVE_POSITION + filePath);
        if (file.exists()) {
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            try {
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            // 实现文件下载
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                throw new FileServerException(FileServerEnums.DOWNLOAD_ERROR.getInfo());
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            throw new FileServerException(FileServerEnums.DOWNLOAD_NOT_FOUND_ERROR.getInfo());
        }
    }

    public static void main(String[] args) {
//        String path = "D:\\Workspace\\IDEAWorkspace\\file-server\\file-static\\uploadByThumbnail\\2020\\04\\12";
//        folderToZip(path, path, "test");

        System.out.println(getDatePath("test", DATE_TYPE_SLASH).replace("\\", "/"));
    }
}
