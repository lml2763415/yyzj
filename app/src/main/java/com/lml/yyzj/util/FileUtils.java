package com.lml.yyzj.util;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by liml on 16/11/27.
 */

public class FileUtils {
    public static void createDir(){
        File file = new File(Environment.getExternalStorageDirectory() + "/Abook/ebook/");
        if(!file.exists()){
            file.mkdirs();
        }
    }
    public static void saveFile(final String filename , final String path){
        createDir();
//如果目标文件已经存在，则删除。产生覆盖旧文件的效果
        Observable.just(path)
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        File file = new File(Environment.getExternalStorageDirectory() + "/Abook/ebook/"+filename+".txt");
                        if(file.exists())
                        {
                            file.delete();
                        }
                        try {
                            // 构造URL
                            URL url = new URL(s);
                            // 打开连接
                            URLConnection con = url.openConnection();
                            //获得文件的长度
                            int contentLength = con.getContentLength();
                            System.out.println("长度 :"+contentLength);
                            // 输入流
                            InputStream is = con.getInputStream();
                            // 1K的数据缓冲
                            byte[] bs = new byte[1024];
                            // 读取到的数据长度
                            int len;
                            // 输出的文件流
                            OutputStream os = new FileOutputStream(file);
                            // 开始读取
                            while ((len = is.read(bs)) != -1) {
                                os.write(bs, 0, len);
                            }
                            Log.d("lml","下载完成");
                            // 完毕，关闭所有链接
                            os.close();
                            is.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe();



    }
}
