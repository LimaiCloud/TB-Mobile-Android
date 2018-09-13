package com.device.limaiyun.thingsboard.utils.env;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ${Winter} on 2018/7/24.
 */
public class ProperUtil {
    private static Properties urlProper;

    public static Properties getUrlProper(Context context) {
        Properties propers = new Properties();

        try {
            InputStream ins = context.getAssets().open("httpConfigtext.properties");
            propers.load(ins);

        } catch (IOException e) {
            e.printStackTrace();
        }
        urlProper = propers;

        return urlProper;
    }

}
