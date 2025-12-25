package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* loaded from: classes.dex */
public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {

    /* renamed from: a */
    public final TransitionFactory f9132a;

    public BitmapContainerTransitionFactory(TransitionFactory<Drawable> transitionFactory) {
        this.f9132a = transitionFactory;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource dataSource, boolean z) {
        return new C0638a(this, this.f9132a.build(dataSource, z));
    }

    public abstract Bitmap getBitmap(R r);
}
