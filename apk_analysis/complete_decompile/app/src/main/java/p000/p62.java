package p000;

import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class p62 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m6837a(PopupWindow popupWindow) {
        return popupWindow.getOverlapAnchor();
    }

    @DoNotInline
    /* renamed from: b */
    public static int m6838b(PopupWindow popupWindow) {
        return popupWindow.getWindowLayoutType();
    }

    @DoNotInline
    /* renamed from: c */
    public static void m6839c(PopupWindow popupWindow, boolean z) {
        popupWindow.setOverlapAnchor(z);
    }

    @DoNotInline
    /* renamed from: d */
    public static void m6840d(PopupWindow popupWindow, int i) {
        popupWindow.setWindowLayoutType(i);
    }
}
