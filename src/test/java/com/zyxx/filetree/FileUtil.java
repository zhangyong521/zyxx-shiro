package com.zyxx.filetree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    private static List<Tree> list = new ArrayList<>();//用来存放数据
    private static Integer id = 0;//因为测试使用，当初主键id来用

    public static void main(String[] args) {

        String filepath = "E:\\下载文件";//默认路径，扫描此文件夹下面的所有文件
        File file = new File(filepath);
        int parentid = 0;  //初始化父节点id
        try {
            file(filepath, parentid);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            Tree tree = list.get(i);
            System.out.println("id:" + tree.getId() + "  parentId:" + tree.getParentId() + "==" + tree.getPath());
        }
    }

    public static void file(String filepath, int parentid) throws FileNotFoundException {
        File file = new File(filepath);
        //1.判断文件
        if (!file.exists()) {
            throw new FileNotFoundException("文件不存在");
        }
        //2.是文件该怎么执行
        if (file.isFile()) {
            String name = file.getName();
            String path = file.getAbsolutePath();
            Tree tree = new Tree(id++, name, path, parentid);
            list.add(tree);
            return;
        }
        //3.获取文件夹路径下面的所有文件递归调用；
        if (file.isDirectory()) {
            String name = file.getName();
            String path = file.getAbsolutePath();
            System.out.println(file.getPath());
            System.out.println(file.getAbsoluteFile());
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getAbsolutePath().replace("E:\\下载文件",""));
            Tree tree = new Tree(id++, name, path, parentid);
            list.add(tree);
            String[] list = file.list();
            String parent = file.getParent();
            for (int i = 0; i < list.length; i++) {
                String s = list[i];
                String newFilePath = path + "\\" + s;//根据当前文件夹，拼接其下文文件形成新的路径
                file(newFilePath, tree.getId());
            }
        }
    }
}
