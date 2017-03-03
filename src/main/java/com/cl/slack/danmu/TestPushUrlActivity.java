package com.cl.slack.danmu;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cl.slack.danmu.login.HuyaPushUrl;
import com.cl.slack.danmu.login.LongzhuPushUrl;
import com.cl.slack.danmu.login.PandaPushUrl;
import com.cl.slack.danmu.login.PushUrl;
import com.cl.slack.danmu.login.QuanminPushUrl;
import com.cl.slack.danmu.login.ZhanqiPushUrl;

import java.util.Map;

public class TestPushUrlActivity extends BaseWebViewActivity {
    private static final String TAG = "PushUrl";
    private boolean mStopPush = false;
    private PushUrl mPushUrl;
    private final String mZhanqiCookie = "gid=1774650720; BF_UID=www.baidu.com_15a828fe9b4_be; AD_BF_UID=15a82b75d93_479971; __gads=ID=090e109b7d346214:T=1488251740:S=ALNI_Mb7_jDJwNDVi_-svfPB75PdpPMZ3A; _VID=www.baidu.com_15a8db8219c_cedb; _TID=www.baidu.com_15a8db8219c_cedb; ZQ_GUID=9C91C826-933F-B3DF-16D5-01D2A3A77E86; ZQ_GUID_C=9C91C826-933F-B3DF-16D5-01D2A3A77E86; tj_uid=110970179; Hm_lvt_299cfc89fdba155674e083d478408f29=1488253215,1488436339,1488436373,1488436536; Hm_lpvt_299cfc89fdba155674e083d478408f29=1488436536";
    private final String mQuanminCookie = "qm_di=fort5zm15d3tr1m2ny4ww1oxj5scbp1sim6z4rwf; sid=61fe54c2a8b0f50bebd1f7f45b497b77; token=fgq9SY8816b739; uid=1488513056; Hm_lvt_63d2da29d5f9eb3559db793b4f7b0283=1488247623,1488254849,1488254899,1488437687; Hm_lpvt_63d2da29d5f9eb3559db793b4f7b0283=1488437726";
    private final String mLongzhuCookie = "__gads=ID=054edad8cab3801f:T=1480097812:S=ALNI_Mbw26xPSdoxrCb8gwLekZYKwEFmqg; pgv_pvi=1897766912; PLULOGINSESSID=c52360452b7f00b4f8cad2537810d80e; p1u_id=28ce13c8d8fd3baad4348cb231e30e14c0f2a76f8b23f63ef34de6a1e7dd815b93c55e98f27db60a; pgv_si=s4648322048; _ma=OREN.2.1388103681.1480097814; pgv_info=ssid=s2413619159; pgv_pvid=8227009778";
    private final String mHuyaCookie = "hiido_ui=0.4719331785305796; hd_newui=0.8684650934874634; __yamid_tt1=0.5016889985909294; __yamid_new=C76A924DA22000017F605E003C9081B0; first_username_flag=1943046018yy_first_1; h_pr=1; yyuid=1704206903; username=1943046018yy; password=BDC2BFDCFDFCFFD20391978D8900FF60F8319492; osinfo=E1147DFD5D4738F0254F93FB14B42D065E88F64F; udb_l=DAAxOTQzMDQ2MDE4eXnsYK5YBXQA9VgHs-x9YAporf1DLZYrjsYS1CqZIRT8gawodbTBAWgXiY0cF-zFh1l4KcKmsQAyCW2EEZizO_naG9RUqAp-Cyk-y_gDbeVRDy07yepbBoXguqRQOKarXW9pUNE90oJFMtcPSaCHAoZ8jSiKZhEIHlNOBl8AAAAAAwAAAAAAAAAMADQ3LjkwLjUyLjIxOQQANTIxNg==; udb_n=5be1078a59bf2e1b85ccbfd14adb9a2b21a63fa36df3ad9e9a2d7a0ba999f0b4a95fcfafd9c4024025589bab89971739; udb_c=AEAWBlBqAAJgAOObG4OjfuSQWhPJXsK-XKCD4xqRbndpjIWT0pjNvbERLL3v8DKY-LrRrGx9431zN8ADrNtBQT9k8am-iDU0Cm9cffmPIi6zUTjcRPKv0LhnkiJdpN5UakJECOoXCwmzVw==; udb_oar=5FE3A3F7763CEA01F672E8E6AE50118365343BDF41948C2ACB812D749A50429CE4B8E8C3B50D13499E2B642ABA438D73F6A2F3E0B81675DD4202F565687708E669D903FA51FE2A96E91567E3A2B6480B51971DE1794AF1D3CB062C9AA8E9489AC3C7700D54AE549FBC760CE35AC46756F839E912F9D0D50241134D8738806DAEC8E58B8A6082A8B6A3BA23355634ECB371AFA7EFF8070AF8BD3FD3D31A6EAC82ABEC3737CDA6D6B4F87DFD53ACD3D0D63F4FAC78901546B48C8C43B14ED37A38CE2692550A7A48B77BF3882A59DAAF9AC34A0C8C76CD537EEA56BF5BE490F937C0904A5039FC2BF5F89560AE4E05C077E00620B20D1C7DDB35892019CCF2305495AD2955179F04E0FABE89978DD0E2B5F0820C45EB006EB7C9A0701800686190168FDDB4DA1142D2734C79B135159604F32702E34BFB9A2E831CEF030DC07E43; guid=b72475589bf5a3584f09b827b9275d28; __yasmid=0.5016889985909294; SoundValue=1.00; isInLiveRoom=; __yaoldyyuid=1704206903; _yasids=__rootsid%3DC76F18BBA370000134D0917613701071; PHPSESSID=1emqebb7h00udmq4vfje7dp6s2; h_unt=1488354945; undefined=undefined; Hm_lvt_51700b6c722f5bb4cf39906a596ea41f=1487674695,1487823054,1487919189,1488354940; Hm_lpvt_51700b6c722f5bb4cf39906a596ea41f=1488354956";
    private final String mPandaCookie = "__guid=96554777.717254311122803200.1488182372781.3662; SESSCYPHP=b9a8b49afea2919a3657a4d76af49af4; I=r%3D73046252; R=r%3D73046252%26u%3DCnaqnGi73046252%26n%3D%25R5%2590%25OR%25R7%259N%2587%25R4%25O8%2587%25R5%25O2%2581%25R5%2593%25N6%25R5%2593%2588%25R5%2593%2588%25R5%2593%2588%26le%3DZwL5BQZ5ZGVkWGDjpKRhL29g%26m%3DZGZkBQL3BQH4ZQx%3D%26im%3DnUE0pPHmDFHlEvHlEzx3YaOxnJ0hM3ZyZxLjZwH3ZQDjZmtjLzD3MQV5ATR4ZQR3AGZlLmN3MGZ5Lv5dpTp%3D; M=t%3D1488509575%26v%3D1.0%26mt%3D1488509575%26s%3Ddc66eda19860276dd45d6bf86fa5ddda; Hm_lvt_204071a8b1d0b2a04c782c44b88eb996=1488254220,1488254256,1488436714,1488509407; Hm_lpvt_204071a8b1d0b2a04c782c44b88eb996=1488509599; smid=0b7dfeb7-26e0-4aa6-ac4a-07756ba345a9";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_push_url);
    }

    public void douyu(View view) {
    }

    /**
     * 龙珠 都是走的这一个 就像开关一样
     * TODO : 龙珠 更新后 ，页面上拿不到 推流码，直播分类没有选中
     */
    public void longzhu(View view) {
        if(mStopPush){
            mStopPush = false;
            mPushUrl.stopLivePush();
        }else {
            mStopPush = true;
            mPushUrl = new LongzhuPushUrl();
            mPushUrl.addCookie(mLongzhuCookie);
            mPushUrl.setPushUrlCallback(mPushUrlCallback);
            mPushUrl.setParam("balabala","127");
            mPushUrl.startLivePush();
        }
    }

    /**
     * TODO : 关闭的地址是不对的
     * 貌似 是因为 网页上拿到的 cookie 不能使用？
     * @param view
     */
    public void xiongmao(View view) {
        if(mStopPush){
            mStopPush = false;
            mPushUrl.stopLivePush();
        }else {
            mStopPush = true;
            mPushUrl = new PandaPushUrl();
            mPushUrl.addCookie(mPandaCookie);
            mPushUrl.setPushUrlCallback(mPushUrlCallback);
            mPushUrl.startLivePush();
        }
    }

    /**
     * 不需要开启或关闭直播
     */
    public void quanmin(View view) {
        mPushUrl = new QuanminPushUrl();
        mPushUrl.addCookie(mQuanminCookie);
        mPushUrl.setPushUrlCallback(mPushUrlCallback);
        mPushUrl.startLivePush();
    }

    public void zhanqi(View view) {
        if(mStopPush){
            mStopPush = false;
            mPushUrl.stopLivePush();
        }else {
            mStopPush = true;
            mPushUrl = new ZhanqiPushUrl();
            mPushUrl.addCookie(mZhanqiCookie);
            mPushUrl.setPushUrlCallback(mPushUrlCallback);
            mPushUrl.startLivePush();
        }
    }

    public void huya(View view) {
        if(mStopPush){
            mStopPush = false;
            mPushUrl.stopLivePush();
        }else {
            mStopPush = true;
            mPushUrl = new HuyaPushUrl();
            mPushUrl.addCookie(mHuyaCookie);
            mPushUrl.setPushUrlCallback(mPushUrlCallback);
            mPushUrl.startLivePush();
        }
    }

    public void sixjianfang(View view) {

    }

    public void testOther(View view) {
        testWebView();
//        new LongZhuInitDialog(this).show();
        //showAlert();
    }

    private void testWebView() {
        mWebView = new WebView(getApplicationContext());
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams( // 1,1);
                FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);

        mWebView = new WebView(getApplicationContext());
        mWebView.setLayoutParams(params);
        addWebView(0);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("http://www.panda.tv/");
    }

    private PushUrl.PushUrlCallback mPushUrlCallback = new PushUrl.PushUrlCallback() {
        @Override
        public void onGetUrl(String url) {
            Log.i(TAG,"onGetUrl : " + url);
        }

        @Override
        public void onError(String msg) {
            Log.e(TAG,"onError : " + msg);
        }

        @Override
        public void onClose() {
            Log.i(TAG,"onClose ...");
        }
    };

    private void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    private void showAlert(){
        try {
            String json = getAssertString("longzhuType.json");
            JSONObject o = JSON.parseObject(json);
            for (Map.Entry<String, Object> entry : o.entrySet()) {
                Log.i("slack",entry.getKey() + " , " +  entry.getValue());
            }

        }catch (Exception e){
            Log.e(TAG,"json error : " + e.toString());
        }
    }
}
