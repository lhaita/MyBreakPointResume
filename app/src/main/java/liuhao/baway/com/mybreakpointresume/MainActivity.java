package liuhao.baway.com.mybreakpointresume;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.superplayer.library.SuperPlayer;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pro;
    private TextView tv;
    private DownLoadFile downLoadFile ;
    private SuperPlayer sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        pro = (ProgressBar) findViewById(R.id.pro);
        tv = (TextView) findViewById(R.id.tv_progress);
        sp = (SuperPlayer) findViewById(R.id.submenuarrow);
        File f = new File(Environment.getExternalStorageDirectory()+"/wenjian/");
        if(!f.exists()){
            f.mkdir();
        }
        //存储地址
       final String path =  Environment.getExternalStorageDirectory()+"/wenjian/mm.mp4";
        //设置最大度
        pro.setMax(100);
        //实例化
        downLoadFile = new DownLoadFile(this,
                "http://2449.vod.myqcloud.com/2449_bfbbfa3cea8f11e5aac3db03cda99974.f20.mp4"
                , path,4, new DownLoadFile.DownLoadListener() {
            @Override
            public void getProgress(int progress) {
                    tv.setText("当前进度：" + progress + "%");
                pro.setProgress(progress);
            }

            @Override
            public void onComplete() {
                Toast.makeText(MainActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
                //播放视频
                sp.setVisibility(View.VISIBLE);
                sp.setNetChangeListener(true)//设置是否监听手机网络
                .setOnNetChangeListener(new SuperPlayer.OnNetChangeListener() {
                    @Override
                    public void onWifi() {
                        Toast.makeText(MainActivity.this,"当前网络环境是WIFI",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onMobile() {
                        Toast.makeText(MainActivity.this,"当前网络环境是手机网络",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDisConnect() {
                        Toast.makeText(MainActivity.this,"网络链接断开",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNoAvailable() {
                        Toast.makeText(MainActivity.this,"无网络链接",Toast.LENGTH_SHORT).show();
                    }
                });
                sp.setTitle("下载完的视频")
                        .play(path);
                sp.setScaleType(SuperPlayer.SCALETYPE_FITXY);
                sp.setPlayerWH(0,sp.getMeasuredHeight());//设置竖屏的时候屏幕的高度，如果不设置会切换后按照16:9的高度重置
            }

            @Override
            public void onFailure() {
                Toast.makeText(MainActivity.this, "下载失败", Toast.LENGTH_SHORT).show();
            }
        }
        );


    }
    public void xiazai(View view){
        downLoadFile.downLoad();
    }
    public void zanting(View view){
        downLoadFile.onPause();
    }
    public void jixu(View view){
        downLoadFile.onStart();
    }
    public void quxiao(View view){
        downLoadFile.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        downLoadFile.onDestroy();
    }
}
