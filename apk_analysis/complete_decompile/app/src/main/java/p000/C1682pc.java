package p000;

import com.google.android.exoplayer2.extractor.p002ts.PsExtractor;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.NoSuchElementException;

/* renamed from: pc */
/* loaded from: classes.dex */
public final class C1682pc implements InterfaceC1580nc {

    /* renamed from: d */
    public int f25115d;

    /* renamed from: a */
    public int f25112a = 0;

    /* renamed from: b */
    public int f25113b = -1;

    /* renamed from: c */
    public int f25114c = 0;

    /* renamed from: e */
    public Object f25116e = new int[16];

    public C1682pc() {
        this.f25115d = r0.length - 1;
    }

    @Override // p000.InterfaceC1580nc
    /* renamed from: a */
    public int mo6340a() {
        return -1;
    }

    @Override // p000.InterfaceC1580nc
    /* renamed from: b */
    public int mo6341b() {
        return this.f25112a;
    }

    @Override // p000.InterfaceC1580nc
    /* renamed from: c */
    public int mo6342c() {
        ParsableByteArray parsableByteArray = (ParsableByteArray) this.f25116e;
        int i = this.f25113b;
        if (i == 8) {
            return parsableByteArray.readUnsignedByte();
        }
        if (i == 16) {
            return parsableByteArray.readUnsignedShort();
        }
        int i2 = this.f25114c;
        this.f25114c = i2 + 1;
        if (i2 % 2 == 0) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            this.f25115d = readUnsignedByte;
            return (readUnsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
        }
        return this.f25115d & 15;
    }

    /* renamed from: d */
    public void m6905d(int i) {
        int i2 = this.f25114c;
        int[] iArr = (int[]) this.f25116e;
        if (i2 == iArr.length) {
            int length = iArr.length << 1;
            if (length >= 0) {
                int[] iArr2 = new int[length];
                int length2 = iArr.length;
                int i3 = this.f25112a;
                int i4 = length2 - i3;
                System.arraycopy(iArr, i3, iArr2, 0, i4);
                System.arraycopy((int[]) this.f25116e, 0, iArr2, i4, i3);
                this.f25112a = 0;
                this.f25113b = this.f25114c - 1;
                this.f25116e = iArr2;
                this.f25115d = length - 1;
            } else {
                throw new IllegalStateException();
            }
        }
        int i5 = (this.f25113b + 1) & this.f25115d;
        this.f25113b = i5;
        ((int[]) this.f25116e)[i5] = i;
        this.f25114c++;
    }

    /* renamed from: e */
    public int m6906e() {
        int i = this.f25114c;
        if (i != 0) {
            int[] iArr = (int[]) this.f25116e;
            int i2 = this.f25112a;
            int i3 = iArr[i2];
            this.f25112a = (i2 + 1) & this.f25115d;
            this.f25114c = i - 1;
            return i3;
        }
        throw new NoSuchElementException();
    }
}
