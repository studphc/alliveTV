package androidx.leanback.widget;

import android.graphics.Rect;
import androidx.leanback.transition.TransitionEpicenterCallback;

/* renamed from: androidx.leanback.widget.b1 */
/* loaded from: classes.dex */
public final class C0318b1 extends TransitionEpicenterCallback {

    /* renamed from: a */
    public final Rect f6271a = new Rect();

    /* renamed from: b */
    public final /* synthetic */ GuidedActionsStylist f6272b;

    public C0318b1(GuidedActionsStylist guidedActionsStylist) {
        this.f6272b = guidedActionsStylist;
    }

    @Override // androidx.leanback.transition.TransitionEpicenterCallback
    public final Rect onGetEpicenter(Object obj) {
        int height = (int) ((this.f6272b.f5814w * r3.f5793b.getHeight()) / 100.0f);
        Rect rect = this.f6271a;
        rect.set(0, height, 0, height);
        return rect;
    }
}
