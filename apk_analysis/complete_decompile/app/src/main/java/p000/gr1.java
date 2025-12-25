package p000;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class gr1 {

    /* renamed from: a */
    public final int f17809a;

    /* renamed from: b */
    public boolean f17810b;

    /* renamed from: c */
    public boolean f17811c;

    /* renamed from: d */
    public byte[] f17812d;

    /* renamed from: e */
    public int f17813e;

    public gr1(int i) {
        this.f17809a = i;
        byte[] bArr = new byte[131];
        this.f17812d = bArr;
        bArr[2] = 1;
    }

    /* renamed from: a */
    public final void m4980a(byte[] bArr, int i, int i2) {
        if (!this.f17810b) {
            return;
        }
        int i3 = i2 - i;
        byte[] bArr2 = this.f17812d;
        int length = bArr2.length;
        int i4 = this.f17813e;
        if (length < i4 + i3) {
            this.f17812d = Arrays.copyOf(bArr2, (i4 + i3) * 2);
        }
        System.arraycopy(bArr, i, this.f17812d, this.f17813e, i3);
        this.f17813e += i3;
    }

    /* renamed from: b */
    public final boolean m4981b(int i) {
        if (!this.f17810b) {
            return false;
        }
        this.f17813e -= i;
        this.f17810b = false;
        this.f17811c = true;
        return true;
    }

    /* renamed from: c */
    public final void m4982c() {
        this.f17810b = false;
        this.f17811c = false;
    }

    /* renamed from: d */
    public final void m4983d(int i) {
        boolean z = true;
        Assertions.checkState(!this.f17810b);
        if (i != this.f17809a) {
            z = false;
        }
        this.f17810b = z;
        if (z) {
            this.f17813e = 3;
            this.f17811c = false;
        }
    }
}
