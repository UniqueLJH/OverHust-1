package com.unique.overhust.DownloadStreetView;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by fhw on 2/14/14.
 */
public class DownloadHustStreet {
    private String urlDownload, fileName;
    private File file;
    private URL url;
    private URLConnection connection;
    private InputStream inputStream;
    private OutputStream outputStream;
    private int filesize;
    private DownloadNotification downloadNotification;
    private int downloadSize, count;

    public DownloadHustStreet(String streetUrl, String filename) {

        downloadNotification = new DownloadNotification();
        downloadNotification.showNotification();

        urlDownload = streetUrl;
        fileName = Environment.getExternalStorageDirectory() + "/" + filename;
        file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            file.delete();
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int download() {

        try {
            url = new URL(urlDownload);
            connection = url.openConnection();
            filesize = connection.getContentLength();
            inputStream = connection.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("download", "" + e);
        }

        try {
            byte[] bytes = new byte[4096];
            outputStream = new FileOutputStream(fileName);
            int i = 0;
            while ((count = inputStream.read(bytes)) > 0) {
                downloadSize += count;
                outputStream.write(bytes, 0, count);
                if (i >= 10000) {
                    downloadNotification.updateProgressbar(downloadSize, filesize, count);
                    i = 0;
                }
                i += count;
            }
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("output", "" + e);
        }

        //0表示下载成功，1表示下载失败
        if (file != null) {
            return 0;
        } else {
            return 1;
        }
    }

}
