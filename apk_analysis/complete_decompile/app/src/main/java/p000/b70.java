package p000;

import android.widget.AbsListView;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class b70 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m2062a(AbsListView absListView) {
        return absListView.isSelectedChildViewEnabled();
    }

    @DoNotInline
    /* renamed from: b */
    public static void m2063b(AbsListView absListView, boolean z) {
        absListView.setSelectedChildViewEnabled(z);
    }
}
