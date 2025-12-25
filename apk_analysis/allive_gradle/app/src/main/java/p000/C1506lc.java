package p000;

import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* renamed from: lc */
/* loaded from: classes.dex */
public final class C1506lc {

    /* renamed from: a */
    public final int f22449a;

    /* renamed from: b */
    public int f22450b;

    /* renamed from: c */
    public int f22451c;

    /* renamed from: d */
    public long f22452d;

    /* renamed from: e */
    public final boolean f22453e;

    /* renamed from: f */
    public final ParsableByteArray f22454f;

    /* renamed from: g */
    public final ParsableByteArray f22455g;

    /* renamed from: h */
    public int f22456h;

    /* renamed from: i */
    public int f22457i;

    public C1506lc(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) {
        this.f22455g = parsableByteArray;
        this.f22454f = parsableByteArray2;
        this.f22453e = z;
        parsableByteArray2.setPosition(12);
        this.f22449a = parsableByteArray2.readUnsignedIntToInt();
        parsableByteArray.setPosition(12);
        this.f22457i = parsableByteArray.readUnsignedIntToInt();
        ExtractorUtil.checkContainerInput(parsableByteArray.readInt() == 1, "first_chunk must be 1");
        this.f22450b = -1;
    }

    /* renamed from: a */
    public final boolean m5915a() {
        long readUnsignedInt;
        int i;
        int i2 = this.f22450b + 1;
        this.f22450b = i2;
        if (i2 == this.f22449a) {
            return false;
        }
        boolean z = this.f22453e;
        ParsableByteArray parsableByteArray = this.f22454f;
        if (z) {
            readUnsignedInt = parsableByteArray.readUnsignedLongToLong();
        } else {
            readUnsignedInt = parsableByteArray.readUnsignedInt();
        }
        this.f22452d = readUnsignedInt;
        if (this.f22450b == this.f22456h) {
            ParsableByteArray parsableByteArray2 = this.f22455g;
            this.f22451c = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray2.skipBytes(4);
            int i3 = this.f22457i - 1;
            this.f22457i = i3;
            if (i3 > 0) {
                i = parsableByteArray2.readUnsignedIntToInt() - 1;
            } else {
                i = -1;
            }
            this.f22456h = i;
        }
        return true;
    }
}
