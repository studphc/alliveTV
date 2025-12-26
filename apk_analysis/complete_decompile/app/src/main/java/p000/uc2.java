package p000;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: classes.dex */
public final class uc2 extends ViewOutlineProvider {

    /* renamed from: a */
    public int f27224a;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f27224a);
        outline.setAlpha(1.0f);
    }
}
