package p000;

/* loaded from: classes.dex */
public final class ce3 extends nd3 {

    /* renamed from: a */
    public final char f8349a;

    public ce3(char c) {
        this.f8349a = c;
    }

    public final String toString() {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        int i = this.f8349a;
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(i & 15);
            i >>= 4;
        }
        return ye0.m8296p("CharMatcher.is('", String.copyValueOf(cArr), "')");
    }

    @Override // com.google.android.gms.internal.common.zzr
    public final boolean zza(char c) {
        if (c == this.f8349a) {
            return true;
        }
        return false;
    }
}
