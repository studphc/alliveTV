package com.hisona.allive;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import defpackage.a80;

/* loaded from: classes2.dex */
public class MainActivity extends FragmentActivity {
    public VersionChecker C;

    public final String getStringById(int i) {
        return getResources().getString(i);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 999 && !VersionChecker.checkPermission(this)) {
            Utils.showToast(this, getStringById(R.string.install_permission_err));
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(0);
        setContentView(R.layout.activity_main);
        VersionChecker versionChecker = new VersionChecker(this);
        this.C = versionChecker;
        versionChecker.setcheckJsonUrl(getResources().getString(R.string.UPDATE_JSON_URL));
        this.C.check();
        GlideApp.with((FragmentActivity) this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 2 && iArr[0] != 0) {
            Utils.showToast(this, getStringById(R.string.storage_permission_err));
        }
    }

    public void onSettingButtonClick(View view) {
        int id = view.getId();
        if (id == R.id.upButton) {
            new Thread(new a80(3)).start();
            return;
        }
        if (id == R.id.downButton) {
            new Thread(new a80(4)).start();
            return;
        }
        if (id == R.id.leftButton) {
            new Thread(new a80(5)).start();
            return;
        }
        if (id == R.id.rightButton) {
            new Thread(new a80(6)).start();
        } else if (id == R.id.selectButton) {
            new Thread(new a80(7)).start();
        } else if (id == R.id.backButton) {
            new Thread(new a80(8)).start();
        }
    }
}
