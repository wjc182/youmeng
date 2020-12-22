package com.example.p7shraredyoumeng;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this,"5fe2046d72497a48449cf889"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0

        // QQ设置
        PlatformConfig.setQQZone("101921179", "bac16752f56eb4a3fcaad108395e5e1b");
        PlatformConfig.setQQFileProvider("com.example.p7shraredyoumeng.fileprovider");
        //微博
        PlatformConfig.setSinaWeibo("398543816", "2468e86004a9ad2978121e9e05eb984c","http://android.com");
    }

}
