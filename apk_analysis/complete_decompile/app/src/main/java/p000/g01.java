package p000;

import android.content.Context;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public final class g01 extends FrameLayout {

    /* renamed from: a */
    public final /* synthetic */ int f17501a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g01(Context context, int i) {
        super(context);
        this.f17501a = i;
    }

    @Override // android.view.View
    public final boolean hasOverlappingRendering() {
        switch (this.f17501a) {
            case 0:
                return false;
            default:
                return false;
        }
    }
}
