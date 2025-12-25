package com.bumptech.glide.request.transition;

import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.request.transition.Transition;

/* renamed from: com.bumptech.glide.request.transition.a */
/* loaded from: classes.dex */
public final class C0638a implements Transition {

    /* renamed from: a */
    public final Transition f9148a;

    /* renamed from: b */
    public final /* synthetic */ BitmapContainerTransitionFactory f9149b;

    public C0638a(BitmapContainerTransitionFactory bitmapContainerTransitionFactory, Transition transition) {
        this.f9149b = bitmapContainerTransitionFactory;
        this.f9148a = transition;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public final boolean transition(Object obj, Transition.ViewAdapter viewAdapter) {
        return this.f9148a.transition(new BitmapDrawable(viewAdapter.getView().getResources(), this.f9149b.getBitmap(obj)), viewAdapter);
    }
}
