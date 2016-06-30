package ucai.cn.huaxia;

import android.app.Application;
import android.content.Context;


import ucai.cn.huaxia.data.RequestManager;

/**
 * Created by Administrator on 2016/6/29.
 */
public class HuaXiaApplication extends Application{
    public static final String SERVER_ROOT = "http://122.224.150.244/mobile/filteData.json?&";
    Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        RequestManager.init(context);
    }
}
