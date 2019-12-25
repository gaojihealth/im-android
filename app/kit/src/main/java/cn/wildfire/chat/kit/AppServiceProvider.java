package cn.wildfire.chat.kit;

import com.zk.chat.app.AppService;

import cn.wildfire.chat.kit.group.GroupAnnouncement;


public interface AppServiceProvider {
    public interface UpdateGroupAnnouncementCallback {
        void onUiSuccess(GroupAnnouncement announcement);

        void onUiFailure(int code, String msg);
    }

    public interface GetGroupAnnouncementCallback {
        void onUiSuccess(GroupAnnouncement announcement);

        void onUiFailure(int code, String msg);
    }

    public void getGroupAnnouncement(String groupId, AppService.GetGroupAnnouncementCallback callback);

    public void updateGroupAnnouncement(String groupId, String announcement, AppService.UpdateGroupAnnouncementCallback callback);
}
