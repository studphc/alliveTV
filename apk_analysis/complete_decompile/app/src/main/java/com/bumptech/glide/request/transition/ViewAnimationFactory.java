package com.bumptech.glide.request.transition;

import android.view.animation.Animation;
import com.bumptech.glide.load.DataSource;
import p000.ai2;
import p000.c43;
import p000.tx0;

/* loaded from: classes.dex */
public class ViewAnimationFactory<R> implements TransitionFactory<R> {

    /* renamed from: a */
    public final c43 f9142a;

    /* renamed from: b */
    public ViewTransition f9143b;

    public ViewAnimationFactory(Animation animation) {
        this(new ai2(12, animation));
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource dataSource, boolean z) {
        if (dataSource != DataSource.MEMORY_CACHE && z) {
            if (this.f9143b == null) {
                this.f9143b = new ViewTransition(this.f9142a);
            }
            return this.f9143b;
        }
        return NoTransition.get();
    }

    public ViewAnimationFactory(int i) {
        this(new tx0(i));
    }

    public ViewAnimationFactory(c43 c43Var) {
        this.f9142a = c43Var;
    }
}
