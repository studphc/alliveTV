package p000;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: classes.dex */
public final class uh2 extends ViewOutlineProvider {
    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRect(0, 0, view.getWidth(), view.getHeight());
        outline.setAlpha(1.0f);
    }
}
