package com.example.p7shraredyoumeng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

public class MainActivity extends AppCompatActivity {
 private Button shared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shared=findViewById(R.id.shared_qq);
        shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击分享
                shareds();
            }
        });
    }

    //QQ与新浪不需要添加Activity，但需要在使用QQ分享或者授权的Activity中，添加：
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
    //分享方法
    private void shareds() {
        //图片
        UMImage image = new UMImage(MainActivity.this, "http://ww4.sinaimg.cn/large/610dc034jw1f2uyg3nvq7j20gy0p6myx.jpg");//网络图片
        image.setThumb(new UMImage(MainActivity.this, R.mipmap.ic_launcher));
        //分享面板
        new ShareAction(MainActivity.this).withText("这是分享").withMedia(image).setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ)
                .setCallback(umShareListener).open();

    }
    //监听事件
    public UMShareListener umShareListener=new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {
            Toast.makeText(MainActivity.this, "分享开始", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onResult(SHARE_MEDIA share_media) {
            Toast.makeText(MainActivity.this, "分享成功", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
            Toast.makeText(MainActivity.this, "分享失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {
            Toast.makeText(MainActivity.this, "取消分享", Toast.LENGTH_SHORT).show();

        }
    };
}