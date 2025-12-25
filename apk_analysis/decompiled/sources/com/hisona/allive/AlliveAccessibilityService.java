package com.hisona.allive;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes2.dex */
public class AlliveAccessibilityService extends AccessibilityService {
    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
    }

    @Override // android.accessibilityservice.AccessibilityService
    public boolean onKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 173 && keyEvent.getAction() == 1) {
            Intent intent = new Intent();
            intent.setClassName(BuildConfig.APPLICATION_ID, "com.hisona.allive.MainActivity");
            intent.addFlags(268435456);
            startActivity(intent);
            return true;
        }
        return false;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onServiceConnected() {
        super.onServiceConnected();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
