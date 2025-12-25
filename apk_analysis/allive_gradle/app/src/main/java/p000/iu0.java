package p000;

import android.graphics.Rect;
import android.transition.Transition;
import androidx.leanback.transition.TransitionEpicenterCallback;

/* loaded from: classes.dex */
public final class iu0 extends Transition.EpicenterCallback {

    /* renamed from: a */
    public final /* synthetic */ int f20266a;

    /* renamed from: b */
    public final /* synthetic */ Object f20267b;

    public /* synthetic */ iu0(int i, Object obj) {
        this.f20266a = i;
        this.f20267b = obj;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public final Rect onGetEpicenter(Transition transition) {
        switch (this.f20266a) {
            case 0:
                return (Rect) this.f20267b;
            case 1:
                Rect rect = (Rect) this.f20267b;
                if (rect == null || rect.isEmpty()) {
                    return null;
                }
                return rect;
            default:
                return ((TransitionEpicenterCallback) this.f20267b).onGetEpicenter(transition);
        }
    }
}
