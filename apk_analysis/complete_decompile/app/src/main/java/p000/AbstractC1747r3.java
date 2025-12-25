package p000;

import android.icu.text.DateFormat;
import android.view.accessibility.AccessibilityNodeInfo;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* renamed from: r3 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1747r3 {
    /* renamed from: b */
    public static /* bridge */ /* synthetic */ int m7171b(DateFormat.HourCycle hourCycle) {
        return hourCycle.ordinal();
    }

    /* renamed from: c */
    public static /* bridge */ /* synthetic */ DateFormat.HourCycle m7172c() {
        return DateFormat.HourCycle.HOUR_CYCLE_11;
    }

    /* renamed from: d */
    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.AccessibilityAction m7173d() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
    }

    /* renamed from: e */
    public static /* bridge */ /* synthetic */ OnBackInvokedCallback m7174e(Object obj) {
        return (OnBackInvokedCallback) obj;
    }

    /* renamed from: h */
    public static /* bridge */ /* synthetic */ OnBackInvokedDispatcher m7177h(Object obj) {
        return (OnBackInvokedDispatcher) obj;
    }

    /* renamed from: l */
    public static /* bridge */ /* synthetic */ DateFormat.HourCycle[] m7181l() {
        return DateFormat.HourCycle.values();
    }

    /* renamed from: m */
    public static /* bridge */ /* synthetic */ DateFormat.HourCycle m7182m() {
        return DateFormat.HourCycle.HOUR_CYCLE_12;
    }

    /* renamed from: n */
    public static /* bridge */ /* synthetic */ DateFormat.HourCycle m7183n() {
        return DateFormat.HourCycle.HOUR_CYCLE_23;
    }

    /* renamed from: o */
    public static /* bridge */ /* synthetic */ DateFormat.HourCycle m7184o() {
        return DateFormat.HourCycle.HOUR_CYCLE_24;
    }
}
