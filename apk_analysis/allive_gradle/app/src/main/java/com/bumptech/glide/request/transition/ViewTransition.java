package com.bumptech.glide.request.transition;

import android.view.View;
import com.bumptech.glide.request.transition.Transition;
import p000.c43;

/* loaded from: classes.dex */
public class ViewTransition<R> implements Transition<R> {

    /* renamed from: a */
    public final c43 f9147a;

    public ViewTransition(c43 c43Var) {
        this.f9147a = c43Var;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(R r, Transition.ViewAdapter viewAdapter) {
        View view = viewAdapter.getView();
        if (view != null) {
            view.clearAnimation();
            view.startAnimation(this.f9147a.mo94c(view.getContext()));
            return false;
        }
        return false;
    }
}
