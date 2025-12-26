package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import p000.p62;

/* loaded from: classes.dex */
public final class PopupWindowCompat {
    public static boolean getOverlapAnchor(@NonNull PopupWindow popupWindow) {
        return p62.m6837a(popupWindow);
    }

    public static int getWindowLayoutType(@NonNull PopupWindow popupWindow) {
        return p62.m6838b(popupWindow);
    }

    public static void setOverlapAnchor(@NonNull PopupWindow popupWindow, boolean z) {
        p62.m6839c(popupWindow, z);
    }

    public static void setWindowLayoutType(@NonNull PopupWindow popupWindow, int i) {
        p62.m6840d(popupWindow, i);
    }

    public static void showAsDropDown(@NonNull PopupWindow popupWindow, @NonNull View view, int i, int i2, int i3) {
        popupWindow.showAsDropDown(view, i, i2, i3);
    }
}
