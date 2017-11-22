package liuhao.baway.com.mybreakpointresume;

import android.app.Application;

import com.wyk.greendaodemo.greendao.gen.DaoMaster;
import com.wyk.greendaodemo.greendao.gen.MyDaoDao;

/**
 * Created by 15218 on 2017/11/22.
 */
public class MyApp extends Application {

    private MyDaoDao mydao;
    //暴露给外部使用此数据库
    public MyDaoDao getUserDao() {
        return mydao;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //对数据库进行初始化    liu.db 数据库的名字
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this,"liu.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        mydao = daoMaster.newSession().getMyDaoDao();
    }
}
