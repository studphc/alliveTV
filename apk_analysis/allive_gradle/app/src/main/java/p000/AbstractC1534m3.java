package p000;

import android.graphics.ImageDecoder;
import android.media.session.MediaSessionManager;
import android.os.Handler;
import android.os.Looper;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: m3 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1534m3 {
    /* renamed from: A */
    public static /* bridge */ /* synthetic */ void m6015A(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        accessibilityNodeInfo.setTooltipText(charSequence);
    }

    /* renamed from: B */
    public static /* bridge */ /* synthetic */ void m6016B(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        accessibilityNodeInfo.setHeading(z);
    }

    /* renamed from: C */
    public static /* bridge */ /* synthetic */ boolean m6017C(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isScreenReaderFocusable();
    }

    /* renamed from: a */
    public static /* bridge */ /* synthetic */ int m6019a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        return remoteUserInfo.getPid();
    }

    /* renamed from: e */
    public static /* bridge */ /* synthetic */ ImageDecoder.Source m6023e(Object obj) {
        return (ImageDecoder.Source) obj;
    }

    /* renamed from: j */
    public static /* bridge */ /* synthetic */ Handler m6028j(Looper looper) {
        return Handler.createAsync(looper);
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction m6031m() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
    }

    /* renamed from: n */
    public static /* bridge */ /* synthetic */ CharSequence m6032n(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getTooltipText();
    }

    /* renamed from: o */
    public static /* bridge */ /* synthetic */ String m6033o(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        return remoteUserInfo.getPackageName();
    }

    /* renamed from: t */
    public static /* bridge */ /* synthetic */ void m6038t(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        accessibilityNodeInfo.setPaneTitle(charSequence);
    }

    /* renamed from: u */
    public static /* bridge */ /* synthetic */ void m6039u(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        accessibilityNodeInfo.setScreenReaderFocusable(z);
    }

    /* renamed from: v */
    public static /* bridge */ /* synthetic */ boolean m6040v(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isHeading();
    }

    /* renamed from: w */
    public static /* bridge */ /* synthetic */ int m6041w(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        return remoteUserInfo.getUid();
    }

    /* renamed from: x */
    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction m6042x() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
    }

    /* renamed from: y */
    public static /* bridge */ /* synthetic */ CharSequence m6043y(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getPaneTitle();
    }
}
