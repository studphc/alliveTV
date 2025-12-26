package androidx.media;

import android.media.AudioAttributes;
import androidx.media.AudioAttributesImpl;

/* renamed from: androidx.media.a */
/* loaded from: classes.dex */
public class C0424a implements AudioAttributesImpl.Builder {

    /* renamed from: a */
    public final AudioAttributes.Builder f6684a;

    public C0424a() {
        this.f6684a = new AudioAttributes.Builder();
    }

    @Override // androidx.media.AudioAttributesImpl.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0424a setUsage(int i) {
        if (i == 16) {
            i = 12;
        }
        this.f6684a.setUsage(i);
        return this;
    }

    @Override // androidx.media.AudioAttributesImpl.Builder
    public AudioAttributesImpl build() {
        return new AudioAttributesImplApi21(this.f6684a.build());
    }

    @Override // androidx.media.AudioAttributesImpl.Builder
    public final AudioAttributesImpl.Builder setContentType(int i) {
        this.f6684a.setContentType(i);
        return this;
    }

    @Override // androidx.media.AudioAttributesImpl.Builder
    public final AudioAttributesImpl.Builder setFlags(int i) {
        this.f6684a.setFlags(i);
        return this;
    }

    @Override // androidx.media.AudioAttributesImpl.Builder
    public final AudioAttributesImpl.Builder setLegacyStreamType(int i) {
        this.f6684a.setLegacyStreamType(i);
        return this;
    }

    public C0424a(Object obj) {
        this.f6684a = new AudioAttributes.Builder((AudioAttributes) obj);
    }
}
