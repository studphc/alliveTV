package p000;

import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class m91 {
    @DoNotInline
    /* renamed from: a */
    public static int m6112a(PopupWindow popupWindow, View view, int i, boolean z) {
        return popupWindow.getMaxAvailableHeight(view, i, z);
    }
}
