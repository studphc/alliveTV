package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

/* loaded from: classes.dex */
public class ViewPropertyAnimationFactory<R> implements TransitionFactory<R> {

    /* renamed from: a */
    public final ViewPropertyTransition.Animator f9144a;

    /* renamed from: b */
    public ViewPropertyTransition f9145b;

    public ViewPropertyAnimationFactory(ViewPropertyTransition.Animator animator) {
        this.f9144a = animator;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource dataSource, boolean z) {
        if (dataSource != DataSource.MEMORY_CACHE && z) {
            if (this.f9145b == null) {
                this.f9145b = new ViewPropertyTransition(this.f9144a);
            }
            return this.f9145b;
        }
        return NoTransition.get();
    }
}
