package androidx.media;

import androidx.media.AudioAttributesImpl;

/* renamed from: androidx.media.b */
/* loaded from: classes.dex */
public final class C0425b extends C0424a {
    @Override // androidx.media.C0424a
    /* renamed from: a */
    public final C0424a setUsage(int i) {
        this.f6684a.setUsage(i);
        return this;
    }

    @Override // androidx.media.C0424a, androidx.media.AudioAttributesImpl.Builder
    public final AudioAttributesImpl build() {
        return new AudioAttributesImplApi21(this.f6684a.build());
    }

    @Override // androidx.media.C0424a, androidx.media.AudioAttributesImpl.Builder
    public final AudioAttributesImpl.Builder setUsage(int i) {
        this.f6684a.setUsage(i);
        return this;
    }
}
