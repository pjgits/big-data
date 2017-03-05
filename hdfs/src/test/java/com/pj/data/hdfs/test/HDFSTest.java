package com.pj.data.hdfs.test;

import com.pj.data.hdfs.util.HDFSRead;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pengj on 2017-03-04.
 */
public class HDFSTest {

    @Test
    public void testHDFSRead() throws Exception {
        String result = HDFSRead.getStringFromHDFS("/pj/hello.out");
        System.out.println(result);
        Assert.assertNotNull(result);
    }
}
