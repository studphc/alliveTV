package com.bumptech.glide;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/* renamed from: com.bumptech.glide.b */
/* loaded from: classes.dex */
public final class C0603b implements Glide.RequestOptionsFactory {

    /* renamed from: a */
    public final /* synthetic */ RequestOptions f8543a;

    public C0603b(RequestOptions requestOptions) {
        this.f8543a = requestOptions;
    }

    @Override // com.bumptech.glide.Glide.RequestOptionsFactory
    public final RequestOptions build() {
        RequestOptions requestOptions = this.f8543a;
        if (requestOptions == null) {
            return new RequestOptions();
        }
        return requestOptions;
    }
}
