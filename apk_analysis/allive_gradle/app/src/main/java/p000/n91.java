package p000;

import android.graphics.Rect;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class n91 {
    @DoNotInline
    /* renamed from: a */
    public static void m6322a(PopupWindow popupWindow, Rect rect) {
        popupWindow.setEpicenterBounds(rect);
    }

    @DoNotInline
    /* renamed from: b */
    public static void m6323b(PopupWindow popupWindow, boolean z) {
        popupWindow.setIsClippedToScreen(z);
    }
}
