package p000;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public final class io2 extends ByteArrayOutputStream {

    /* renamed from: a */
    public final /* synthetic */ jo2 f20167a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public io2(jo2 jo2Var, int i) {
        super(i);
        this.f20167a = jo2Var;
    }

    @Override // java.io.ByteArrayOutputStream
    public final String toString() {
        int i = ((ByteArrayOutputStream) this).count;
        if (i > 0 && ((ByteArrayOutputStream) this).buf[i - 1] == 13) {
            i--;
        }
        try {
            return new String(((ByteArrayOutputStream) this).buf, 0, i, this.f20167a.f20571b.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
