package p000;

import androidx.collection.ScatterMapKt;
import java.util.BitSet;

/* loaded from: classes.dex */
public final class uk2 extends AbstractC1842to {

    /* renamed from: b */
    public final char[] f27304b;

    /* renamed from: c */
    public final boolean f27305c;

    /* renamed from: d */
    public final long f27306d;

    public uk2(char[] cArr, long j, boolean z, String str) {
        super(str);
        this.f27304b = cArr;
        this.f27306d = j;
        this.f27305c = z;
    }

    @Override // com.google.common.base.CharMatcher
    /* renamed from: d */
    public final void mo2122d(BitSet bitSet) {
        if (this.f27305c) {
            bitSet.set(0);
        }
        for (char c : this.f27304b) {
            if (c != 0) {
                bitSet.set(c);
            }
        }
    }

    @Override // com.google.common.base.CharMatcher
    public final boolean matches(char c) {
        if (c == 0) {
            return this.f27305c;
        }
        if (1 == ((this.f27306d >> c) & 1)) {
            char[] cArr = this.f27304b;
            int length = cArr.length - 1;
            int rotateLeft = (Integer.rotateLeft(ScatterMapKt.MurmurHashC1 * c, 15) * 461845907) & length;
            int i = rotateLeft;
            do {
                char c2 = cArr[i];
                if (c2 == 0) {
                    return false;
                }
                if (c2 == c) {
                    return true;
                }
                i = (i + 1) & length;
            } while (i != rotateLeft);
        }
        return false;
    }
}
