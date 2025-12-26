package p000;

import android.transition.Transition;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class in1 {
    @DoNotInline
    /* renamed from: a */
    public static void m5249a(PopupWindow popupWindow, Transition transition) {
        popupWindow.setEnterTransition(transition);
    }

    @DoNotInline
    /* renamed from: b */
    public static void m5250b(PopupWindow popupWindow, Transition transition) {
        popupWindow.setExitTransition(transition);
    }
}
