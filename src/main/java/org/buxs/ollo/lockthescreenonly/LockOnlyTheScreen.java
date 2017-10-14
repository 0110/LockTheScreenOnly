package org.buxs.ollo.lockthescreenonly;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LockOnlyTheScreen extends Activity {

    private static final String TAG = "LockOnlyTheScreen";

    ComponentName mDeviceAdminLockOnlyTheScreen = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDeviceAdminLockOnlyTheScreen = new ComponentName(this, LockOnlyTheScreen.class);
        Log.d(TAG,
                "App started");

        DevicePolicyManager mDPM =
                (DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE);

        try  {
            mDPM.lockNow();
            this.finish();
        } catch (AndroidRuntimeException are) {
            Log.d(TAG,
                    "Request permssion on start, because: " + are.getMessage());
            // Launch the activity to have the user enable our admin.
            Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mDeviceAdminLockOnlyTheScreen);
            startActivity(intent);
        }
    }
}
