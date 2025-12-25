package p000;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import java.util.zip.Checksum;

/* renamed from: kp */
/* loaded from: classes2.dex */
public final class C1482kp extends AbstractC1743r {

    /* renamed from: b */
    public final Checksum f22131b;

    /* renamed from: c */
    public final /* synthetic */ C1519lp f22132c;

    public C1482kp(C1519lp c1519lp, Checksum checksum) {
        this.f22132c = c1519lp;
        this.f22131b = (Checksum) Preconditions.checkNotNull(checksum);
    }

    @Override // p000.AbstractC1743r
    /* renamed from: a */
    public final void mo5756a(byte b) {
        this.f22131b.update(b);
    }

    @Override // p000.AbstractC1743r
    /* renamed from: e */
    public final void mo5757e(byte[] bArr, int i, int i2) {
        this.f22131b.update(bArr, i, i2);
    }

    @Override // com.google.common.hash.Hasher
    public final HashCode hash() {
        long value = this.f22131b.getValue();
        if (this.f22132c.f22603b == 32) {
            return HashCode.fromInt((int) value);
        }
        return HashCode.fromLong(value);
    }
}
