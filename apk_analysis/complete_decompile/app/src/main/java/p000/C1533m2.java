package p000;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: m2 */
/* loaded from: classes2.dex */
public final class C1533m2 extends ByteArrayOutputStream {

    /* renamed from: a */
    public final /* synthetic */ int f22769a;

    /* renamed from: a */
    public byte[] m6004a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    /* renamed from: b */
    public byte[] m6005b() {
        switch (this.f22769a) {
            case 1:
                byte[] buf = ((ByteArrayOutputStream) this).buf;
                Intrinsics.checkNotNullExpressionValue(buf, "buf");
                return buf;
            default:
                return ((ByteArrayOutputStream) this).buf;
        }
    }

    /* renamed from: c */
    public int m6006c() {
        return ((ByteArrayOutputStream) this).count;
    }

    /* renamed from: d */
    public void m6007d(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        int i = ((ByteArrayOutputStream) this).count;
        int i2 = i + remaining;
        byte[] bArr = ((ByteArrayOutputStream) this).buf;
        if (i2 > bArr.length) {
            ((ByteArrayOutputStream) this).buf = Arrays.copyOf(bArr, i + remaining);
        }
        byteBuffer.get(((ByteArrayOutputStream) this).buf, ((ByteArrayOutputStream) this).count, remaining);
        ((ByteArrayOutputStream) this).count += remaining;
    }

    public int getCount() {
        return ((ByteArrayOutputStream) this).count;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1533m2(int i, int i2) {
        super(i);
        this.f22769a = i2;
    }
}
