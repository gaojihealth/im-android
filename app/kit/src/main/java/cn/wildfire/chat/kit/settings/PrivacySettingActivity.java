package cn.wildfire.chat.kit.settings;

import android.content.Intent;

import com.zk.imdemo.R;

import butterknife.OnClick;
import cn.wildfire.chat.kit.WfcBaseActivity;
import cn.wildfire.chat.kit.settings.blacklist.BlacklistListActivity;

public class PrivacySettingActivity extends WfcBaseActivity {

    @Override
    protected int contentLayout() {
        return R.layout.privacy_setting_activity;
    }

    @OnClick(R.id.blacklistOptionItemView)
    void blacklistSettings() {
        Intent intent = new Intent(this, BlacklistListActivity.class);
        startActivity(intent);
    }

}
