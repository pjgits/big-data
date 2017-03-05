package com.pj.data.hdfs.util;

import com.pj.data.common.Env;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.File;
import java.net.URI;

/**
 * Created by pengj on 2017-03-04.
 */
public class HDFSRead {


    public static String getStringFromHDFS(String path) throws Exception {
        String path1 = new File(".").getCanonicalPath();
        System.getProperties().put("hadoop.home.dir", path1);
        new File("./bin").mkdirs();
        new File("./bin/winutils.exe").createNewFile();
        String hdfsPath = String.format(Env.HDFS_URI,path);
        System.out.println(hdfsPath);
        FileSystem fs = FileSystem.get(new URI(String.format(Env.HDFS_URI,"")), new Configuration());
        FSDataInputStream fsis = fs.open(new Path(path));
        IOUtils.copyBytes(fsis,System.out,2048,true);
        IOUtils.closeStream(fsis);
        return "\ncomplete!";
    }
}
