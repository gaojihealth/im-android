package cn.wildfire.chat.kit.settings.blacklist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.zk.imdemo.R;
import cn.wildfirechat.model.UserInfo;
import cn.wildfirechat.remote.ChatManager;

public class BlacklistViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.portraitImageView)
    ImageView portraitImageView;
    @BindView(R.id.userNameTextView)
    TextView userNameTextView;

    public BlacklistViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(String userId) {
        UserInfo userInfo = ChatManager.Instance().getUserInfo(userId, false);
        userNameTextView.setText(userInfo.displayName == null ? "< " + userInfo.uid + "> " : userInfo.displayName);
        Glide.with(itemView.getContext()).load(userInfo.portrait).into(portraitImageView);
    }
}
