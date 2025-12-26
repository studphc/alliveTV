package com.bumptech.glide;

import androidx.annotation.NonNull;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a */
    public TransitionFactory f8542a = NoTransition.getFactory();

    @NonNull
    public final CHILD dontTransition() {
        return transition(NoTransition.getFactory());
    }

    @NonNull
    public final CHILD transition(int i) {
        return transition(new ViewAnimationFactory(i));
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final CHILD m8504clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    public final CHILD transition(@NonNull ViewPropertyTransition.Animator animator) {
        return transition(new ViewPropertyAnimationFactory(animator));
    }

    @NonNull
    public final CHILD transition(@NonNull TransitionFactory<? super TranscodeType> transitionFactory) {
        this.f8542a = (TransitionFactory) Preconditions.checkNotNull(transitionFactory);
        return this;
    }
}
