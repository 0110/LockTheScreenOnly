package org.buxs.ollo.lockthescreenonly;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ollo on 12.10.17.
 */
public class DeviceAdminSample extends DeviceAdminReceiver {
    void showToast(Context context, String msg) {
        Toast.makeText(context, "Device manager Sample | " + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEnabled(Context context, Intent intent) {
        showToast(context, "Enabled");
    }

    @Override
    public void onDisabled(Context context, Intent intent) {
        showToast(context, "Disabled");
    }

    @Override
    public void onPasswordChanged(Context context, Intent intent) {
        showToast(context, "Passwort changed");
    }

}
