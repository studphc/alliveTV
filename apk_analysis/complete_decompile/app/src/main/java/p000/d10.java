package p000;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes.dex */
public final class d10 implements s02 {

    /* renamed from: a */
    public final r02 f16197a;

    /* renamed from: b */
    public final long f16198b;

    /* renamed from: c */
    public final long f16199c;

    /* renamed from: d */
    public final co2 f16200d;

    /* renamed from: e */
    public int f16201e;

    /* renamed from: f */
    public long f16202f;

    /* renamed from: g */
    public long f16203g;

    /* renamed from: h */
    public long f16204h;

    /* renamed from: i */
    public long f16205i;

    /* renamed from: j */
    public long f16206j;

    /* renamed from: k */
    public long f16207k;

    /* renamed from: l */
    public long f16208l;

    public d10(co2 co2Var, long j, long j2, long j3, long j4, boolean z) {
        boolean z2;
        if (j >= 0 && j2 > j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.checkArgument(z2);
        this.f16200d = co2Var;
        this.f16198b = j;
        this.f16199c = j2;
        if (j3 != j2 - j && !z) {
            this.f16201e = 0;
        } else {
            this.f16202f = j4;
            this.f16201e = 4;
        }
        this.f16197a = new r02();
    }

    @Override // p000.s02
    /* renamed from: a */
    public final SeekMap mo2124a() {
        if (this.f16202f != 0) {
            return new c10(this);
        }
        return null;
    }

    @Override // p000.s02
    /* renamed from: b */
    public final void mo2125b(long j) {
        this.f16204h = Util.constrainValue(j, 0L, this.f16202f - 1);
        this.f16201e = 2;
        this.f16205i = this.f16198b;
        this.f16206j = this.f16199c;
        this.f16207k = 0L;
        this.f16208l = this.f16202f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cc  */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    @Override // p000.s02
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long read(ExtractorInput extractorInput) {
        r02 r02Var;
        ?? r2;
        long j;
        r02 r02Var2;
        long constrainValue;
        long j2;
        int i = this.f16201e;
        long j3 = this.f16199c;
        r02 r02Var3 = this.f16197a;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return -1L;
                        }
                        throw new IllegalStateException();
                    }
                    j2 = -1;
                    r02Var2 = r02Var3;
                } else {
                    if (this.f16205i != this.f16206j) {
                        long position = extractorInput.getPosition();
                        if (!r02Var3.m7161b(extractorInput, this.f16206j)) {
                            long j4 = this.f16205i;
                            if (j4 != position) {
                                constrainValue = j4;
                            } else {
                                throw new IOException("No ogg page can be found.");
                            }
                        } else {
                            r02Var3.m7160a(extractorInput, false);
                            extractorInput.resetPeekPosition();
                            long j5 = this.f16204h;
                            long j6 = r02Var3.f25823b;
                            long j7 = j5 - j6;
                            int i2 = r02Var3.f25825d + r02Var3.f25826e;
                            if (0 > j7 || j7 >= 72000) {
                                if (j7 < 0) {
                                    this.f16206j = position;
                                    this.f16208l = j6;
                                } else {
                                    this.f16205i = extractorInput.getPosition() + i2;
                                    this.f16207k = r02Var3.f25823b;
                                }
                                long j8 = this.f16206j;
                                long j9 = this.f16205i;
                                if (j8 - j9 < 100000) {
                                    this.f16206j = j9;
                                    constrainValue = j9;
                                } else {
                                    long j10 = i2;
                                    if (j7 <= 0) {
                                        j = 2;
                                    } else {
                                        j = 1;
                                    }
                                    long position2 = extractorInput.getPosition() - (j10 * j);
                                    long j11 = this.f16206j;
                                    r02Var2 = r02Var3;
                                    long j12 = this.f16205i;
                                    constrainValue = Util.constrainValue((((j11 - j12) * j7) / (this.f16208l - this.f16207k)) + position2, j12, j11 - 1);
                                    j2 = -1;
                                    if (constrainValue != j2) {
                                        return constrainValue;
                                    }
                                    this.f16201e = 3;
                                }
                            }
                        }
                        r02Var2 = r02Var3;
                        j2 = -1;
                        if (constrainValue != j2) {
                        }
                    }
                    r02Var2 = r02Var3;
                    j2 = -1;
                    constrainValue = -1;
                    if (constrainValue != j2) {
                    }
                }
                r02 r02Var4 = r02Var2;
                while (true) {
                    r02Var4.m7161b(extractorInput, j2);
                    r02Var4.m7160a(extractorInput, false);
                    if (r02Var4.f25823b > this.f16204h) {
                        extractorInput.resetPeekPosition();
                        this.f16201e = 4;
                        return -(this.f16207k + 2);
                    }
                    extractorInput.skipFully(r02Var4.f25825d + r02Var4.f25826e);
                    this.f16205i = extractorInput.getPosition();
                    this.f16207k = r02Var4.f25823b;
                    j2 = -1;
                }
            } else {
                r02Var = r02Var3;
                r2 = 0;
            }
        } else {
            r02Var = r02Var3;
            long position3 = extractorInput.getPosition();
            this.f16203g = position3;
            this.f16201e = 1;
            long j13 = j3 - 65307;
            if (j13 > position3) {
                return j13;
            }
            r2 = 0;
        }
        r02Var.f25822a = r2;
        r02Var.f25823b = 0L;
        r02Var.f25824c = r2;
        r02Var.f25825d = r2;
        r02Var.f25826e = r2;
        if (r02Var.m7161b(extractorInput, -1L)) {
            r02Var.m7160a(extractorInput, r2);
            extractorInput.skipFully(r02Var.f25825d + r02Var.f25826e);
            long j14 = r02Var.f25823b;
            while ((r02Var.f25822a & 4) != 4 && r02Var.m7161b(extractorInput, -1L) && extractorInput.getPosition() < j3 && r02Var.m7160a(extractorInput, true) && ExtractorUtil.skipFullyQuietly(extractorInput, r02Var.f25825d + r02Var.f25826e)) {
                j14 = r02Var.f25823b;
            }
            this.f16202f = j14;
            this.f16201e = 4;
            return this.f16203g;
        }
        throw new EOFException();
    }
}
