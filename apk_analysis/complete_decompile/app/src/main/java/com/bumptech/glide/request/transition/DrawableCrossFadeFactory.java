package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import okhttp3.internal.http.HttpStatusCodesKt;

/* loaded from: classes.dex */
public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {

    /* renamed from: a */
    public final int f9133a;

    /* renamed from: b */
    public final boolean f9134b;

    /* renamed from: c */
    public DrawableCrossFadeTransition f9135c;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        public final int f9136a;

        /* renamed from: b */
        public boolean f9137b;

        public Builder() {
            this(HttpStatusCodesKt.HTTP_MULT_CHOICE);
        }

        public DrawableCrossFadeFactory build() {
            return new DrawableCrossFadeFactory(this.f9136a, this.f9137b);
        }

        public Builder setCrossFadeEnabled(boolean z) {
            this.f9137b = z;
            return this;
        }

        public Builder(int i) {
            this.f9136a = i;
        }
    }

    public DrawableCrossFadeFactory(int i, boolean z) {
        this.f9133a = i;
        this.f9134b = z;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<Drawable> build(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE) {
            return NoTransition.get();
        }
        if (this.f9135c == null) {
            this.f9135c = new DrawableCrossFadeTransition(this.f9133a, this.f9134b);
        }
        return this.f9135c;
    }
}
