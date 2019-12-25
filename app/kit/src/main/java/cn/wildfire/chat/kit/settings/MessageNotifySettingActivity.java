package cn.wildfire.chat.kit.settings;

import android.widget.Switch;
import android.widget.Toast;

import butterknife.BindView;
import cn.wildfire.chat.kit.WfcBaseActivity;
import com.zk.imdemo.R;
import cn.wildfirechat.remote.ChatManager;
import cn.wildfirechat.remote.GeneralCallback;

public class MessageNotifySettingActivity extends WfcBaseActivity {
    @BindView(R.id.switchMsgNotification)
    Switch switchMsgNotification;
    @BindView(R.id.switchShowMsgDetail)
    Switch switchShowMsgDetail;

    @Override
    protected int contentLayout() {
        return R.layout.activity_msg_notify_settings;
    }



    @Override
    protected void afterViews() {
        super.afterViews();

        switchMsgNotification.setChecked(!ChatManager.Instance().isGlobalSlient());
        switchShowMsgDetail.setChecked(!ChatManager.Instance().isHiddenNotificationDetail());


        switchMsgNotification.setOnCheckedChangeListener((buttonView, isChecked) -> {
            ChatManager.Instance().setGlobalSlient(!isChecked, new GeneralCallback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onFail(int errorCode) {
                    Toast.makeText(MessageNotifySettingActivity.this, "网络错误", Toast.LENGTH_SHORT);
                }
            });
        });

        switchShowMsgDetail.setOnCheckedChangeListener((buttonView, isChecked) -> {
            ChatManager.Instance().setHiddenNotificationDetail(!isChecked, new GeneralCallback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onFail(int errorCode) {
                    Toast.makeText(MessageNotifySettingActivity.this, "网络错误", Toast.LENGTH_SHORT);
                }
            });
        });
    }
}
