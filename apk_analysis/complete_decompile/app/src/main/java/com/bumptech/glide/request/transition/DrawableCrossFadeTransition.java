package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes.dex */
public class DrawableCrossFadeTransition implements Transition<Drawable> {

    /* renamed from: a */
    public final int f9138a;

    /* renamed from: b */
    public final boolean f9139b;

    public DrawableCrossFadeTransition(int i, boolean z) {
        this.f9138a = i;
        this.f9139b = z;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(Drawable drawable, Transition.ViewAdapter viewAdapter) {
        Drawable currentDrawable = viewAdapter.getCurrentDrawable();
        if (currentDrawable == null) {
            currentDrawable = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{currentDrawable, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f9139b);
        transitionDrawable.startTransition(this.f9138a);
        viewAdapter.setDrawable(transitionDrawable);
        return true;
    }
}
