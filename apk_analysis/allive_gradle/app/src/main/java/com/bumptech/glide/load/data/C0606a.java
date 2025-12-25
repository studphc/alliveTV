package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;
import p000.C1741qy;

/* renamed from: com.bumptech.glide.load.data.a */
/* loaded from: classes.dex */
public final class C0606a implements DataRewinder.Factory {
    @Override // com.bumptech.glide.load.data.DataRewinder.Factory
    public final DataRewinder build(Object obj) {
        return new C1741qy(obj);
    }

    @Override // com.bumptech.glide.load.data.DataRewinder.Factory
    public final Class getDataClass() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
