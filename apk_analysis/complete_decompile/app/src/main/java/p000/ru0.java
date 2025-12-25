package p000;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class ru0 {

    /* renamed from: a */
    public final TrackOutput f26141a;

    /* renamed from: d */
    public ev2 f26144d;

    /* renamed from: e */
    public f10 f26145e;

    /* renamed from: f */
    public int f26146f;

    /* renamed from: g */
    public int f26147g;

    /* renamed from: h */
    public int f26148h;

    /* renamed from: i */
    public int f26149i;

    /* renamed from: l */
    public boolean f26152l;

    /* renamed from: b */
    public final cv2 f26142b = new cv2();

    /* renamed from: c */
    public final ParsableByteArray f26143c = new ParsableByteArray();

    /* renamed from: j */
    public final ParsableByteArray f26150j = new ParsableByteArray(1);

    /* renamed from: k */
    public final ParsableByteArray f26151k = new ParsableByteArray();

    public ru0(TrackOutput trackOutput, ev2 ev2Var, f10 f10Var) {
        this.f26141a = trackOutput;
        this.f26144d = ev2Var;
        this.f26145e = f10Var;
        this.f26144d = ev2Var;
        this.f26145e = f10Var;
        trackOutput.format(ev2Var.f16998a.format);
        m7307d();
    }

    /* renamed from: a */
    public final TrackEncryptionBox m7304a() {
        if (!this.f26152l) {
            return null;
        }
        cv2 cv2Var = this.f26142b;
        int i = ((f10) Util.castNonNull(cv2Var.f16129a)).f17072a;
        TrackEncryptionBox trackEncryptionBox = cv2Var.f16141m;
        if (trackEncryptionBox == null) {
            trackEncryptionBox = this.f26144d.f16998a.getSampleDescriptionEncryptionBox(i);
        }
        if (trackEncryptionBox == null || !trackEncryptionBox.isEncrypted) {
            return null;
        }
        return trackEncryptionBox;
    }

    /* renamed from: b */
    public final boolean m7305b() {
        this.f26146f++;
        if (!this.f26152l) {
            return false;
        }
        int i = this.f26147g + 1;
        this.f26147g = i;
        int[] iArr = this.f26142b.f16135g;
        int i2 = this.f26148h;
        if (i != iArr[i2]) {
            return true;
        }
        this.f26148h = i2 + 1;
        this.f26147g = 0;
        return false;
    }

    /* renamed from: c */
    public final int m7306c(int i, int i2) {
        ParsableByteArray parsableByteArray;
        boolean z;
        boolean z2;
        int i3;
        TrackEncryptionBox m7304a = m7304a();
        if (m7304a == null) {
            return 0;
        }
        int i4 = m7304a.perSampleIvSize;
        cv2 cv2Var = this.f26142b;
        if (i4 != 0) {
            parsableByteArray = cv2Var.f16142n;
        } else {
            byte[] bArr = (byte[]) Util.castNonNull(m7304a.defaultInitializationVector);
            int length = bArr.length;
            ParsableByteArray parsableByteArray2 = this.f26151k;
            parsableByteArray2.reset(bArr, length);
            i4 = bArr.length;
            parsableByteArray = parsableByteArray2;
        }
        int i5 = this.f26146f;
        if (cv2Var.f16139k && cv2Var.f16140l[i5]) {
            z = true;
        } else {
            z = false;
        }
        if (!z && i2 == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        ParsableByteArray parsableByteArray3 = this.f26150j;
        byte[] data = parsableByteArray3.getData();
        if (z2) {
            i3 = 128;
        } else {
            i3 = 0;
        }
        data[0] = (byte) (i3 | i4);
        parsableByteArray3.setPosition(0);
        TrackOutput trackOutput = this.f26141a;
        trackOutput.sampleData(parsableByteArray3, 1, 1);
        trackOutput.sampleData(parsableByteArray, i4, 1);
        if (!z2) {
            return i4 + 1;
        }
        ParsableByteArray parsableByteArray4 = this.f26143c;
        if (!z) {
            parsableByteArray4.reset(8);
            byte[] data2 = parsableByteArray4.getData();
            data2[0] = 0;
            data2[1] = 1;
            data2[2] = (byte) 0;
            data2[3] = (byte) (i2 & 255);
            data2[4] = (byte) ((i >> 24) & 255);
            data2[5] = (byte) ((i >> 16) & 255);
            data2[6] = (byte) ((i >> 8) & 255);
            data2[7] = (byte) (i & 255);
            trackOutput.sampleData(parsableByteArray4, 8, 1);
            return i4 + 9;
        }
        ParsableByteArray parsableByteArray5 = cv2Var.f16142n;
        int readUnsignedShort = parsableByteArray5.readUnsignedShort();
        parsableByteArray5.skipBytes(-2);
        int i6 = (readUnsignedShort * 6) + 2;
        if (i2 != 0) {
            parsableByteArray4.reset(i6);
            byte[] data3 = parsableByteArray4.getData();
            parsableByteArray5.readBytes(data3, 0, i6);
            int i7 = (((data3[2] & 255) << 8) | (data3[3] & 255)) + i2;
            data3[2] = (byte) ((i7 >> 8) & 255);
            data3[3] = (byte) (i7 & 255);
        } else {
            parsableByteArray4 = parsableByteArray5;
        }
        trackOutput.sampleData(parsableByteArray4, i6, 1);
        return i4 + 1 + i6;
    }

    /* renamed from: d */
    public final void m7307d() {
        cv2 cv2Var = this.f26142b;
        cv2Var.f16132d = 0;
        cv2Var.f16144p = 0L;
        cv2Var.f16145q = false;
        cv2Var.f16139k = false;
        cv2Var.f16143o = false;
        cv2Var.f16141m = null;
        this.f26146f = 0;
        this.f26148h = 0;
        this.f26147g = 0;
        this.f26149i = 0;
        this.f26152l = false;
    }
}
