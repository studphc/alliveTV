package com.google.android.exoplayer2.extractor.p002ts;

import android.util.Pair;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;
import p000.gr1;
import p000.ry0;

/* loaded from: classes.dex */
public final class H262Reader implements ElementaryStreamReader {

    /* renamed from: q */
    public static final double[] f10418q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a */
    public String f10419a;

    /* renamed from: b */
    public TrackOutput f10420b;

    /* renamed from: c */
    public final C0671c f10421c;

    /* renamed from: d */
    public final ParsableByteArray f10422d;

    /* renamed from: e */
    public final gr1 f10423e;

    /* renamed from: f */
    public final boolean[] f10424f;

    /* renamed from: g */
    public final ry0 f10425g;

    /* renamed from: h */
    public long f10426h;

    /* renamed from: i */
    public boolean f10427i;

    /* renamed from: j */
    public boolean f10428j;

    /* renamed from: k */
    public long f10429k;

    /* renamed from: l */
    public long f10430l;

    /* renamed from: m */
    public long f10431m;

    /* renamed from: n */
    public long f10432n;

    /* renamed from: o */
    public boolean f10433o;

    /* renamed from: p */
    public boolean f10434p;

    public H262Reader() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f4  */
    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void consume(ParsableByteArray parsableByteArray) {
        ry0 ry0Var;
        gr1 gr1Var;
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        long j;
        boolean z2;
        boolean z3;
        boolean z4;
        long j2;
        int i5;
        int i6;
        float f;
        int i7;
        float f2;
        int i8;
        long j3;
        Assertions.checkStateNotNull(this.f10420b);
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] data = parsableByteArray.getData();
        this.f10426h += parsableByteArray.bytesLeft();
        this.f10420b.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
        while (true) {
            int findNalUnit = NalUnitUtil.findNalUnit(data, position, limit, this.f10424f);
            ry0Var = this.f10425g;
            gr1Var = this.f10423e;
            if (findNalUnit == limit) {
                break;
            }
            int i9 = findNalUnit + 3;
            int i10 = parsableByteArray.getData()[i9] & 255;
            int i11 = findNalUnit - position;
            if (!this.f10428j) {
                if (i11 > 0) {
                    ry0Var.m7310a(data, position, findNalUnit);
                }
                if (i11 < 0) {
                    i6 = -i11;
                } else {
                    i6 = 0;
                }
                if (ry0Var.f26181a) {
                    int i12 = ry0Var.f26182b - i6;
                    ry0Var.f26182b = i12;
                    if (ry0Var.f26183c == 0 && i10 == 181) {
                        ry0Var.f26183c = i12;
                        i = position;
                        i2 = i9;
                        i3 = limit;
                    } else {
                        ry0Var.f26181a = false;
                        String str = (String) Assertions.checkNotNull(this.f10419a);
                        byte[] copyOf = Arrays.copyOf(ry0Var.f26184d, ry0Var.f26182b);
                        int i13 = copyOf[4] & 255;
                        byte b = copyOf[5];
                        i2 = i9;
                        int i14 = (i13 << 4) | ((b & 255) >> 4);
                        int i15 = (copyOf[6] & 255) | ((b & Ascii.f14464SI) << 8);
                        int i16 = (copyOf[7] & 240) >> 4;
                        if (i16 != 2) {
                            if (i16 != 3) {
                                if (i16 != 4) {
                                    f2 = 1.0f;
                                    Format build = new Format.Builder().setId(str).setSampleMimeType(MimeTypes.VIDEO_MPEG2).setWidth(i14).setHeight(i15).setPixelWidthHeightRatio(f2).setInitializationData(Collections.singletonList(copyOf)).build();
                                    i8 = (copyOf[7] & Ascii.f14464SI) - 1;
                                    if (i8 < 0 && i8 < 8) {
                                        double d = f10418q[i8];
                                        byte b2 = copyOf[ry0Var.f26183c + 9];
                                        int i17 = (b2 & 96) >> 5;
                                        if (i17 != (b2 & Ascii.f14467US)) {
                                            double d2 = i17 + 1.0d;
                                            i = position;
                                            i3 = limit;
                                            d *= d2 / (r5 + 1);
                                        } else {
                                            i = position;
                                            i3 = limit;
                                        }
                                        j3 = (long) (1000000.0d / d);
                                    } else {
                                        i = position;
                                        i3 = limit;
                                        j3 = 0;
                                    }
                                    Pair create = Pair.create(build, Long.valueOf(j3));
                                    this.f10420b.format((Format) create.first);
                                    this.f10429k = ((Long) create.second).longValue();
                                    this.f10428j = true;
                                } else {
                                    f = i15 * 121;
                                    i7 = i14 * 100;
                                }
                            } else {
                                f = i15 * 16;
                                i7 = i14 * 9;
                            }
                        } else {
                            f = i15 * 4;
                            i7 = i14 * 3;
                        }
                        f2 = f / i7;
                        Format build2 = new Format.Builder().setId(str).setSampleMimeType(MimeTypes.VIDEO_MPEG2).setWidth(i14).setHeight(i15).setPixelWidthHeightRatio(f2).setInitializationData(Collections.singletonList(copyOf)).build();
                        i8 = (copyOf[7] & Ascii.f14464SI) - 1;
                        if (i8 < 0) {
                        }
                        i = position;
                        i3 = limit;
                        j3 = 0;
                        Pair create2 = Pair.create(build2, Long.valueOf(j3));
                        this.f10420b.format((Format) create2.first);
                        this.f10429k = ((Long) create2.second).longValue();
                        this.f10428j = true;
                    }
                } else {
                    i = position;
                    i2 = i9;
                    i3 = limit;
                    if (i10 == 179) {
                        ry0Var.f26181a = true;
                    }
                }
                ry0Var.m7310a(ry0.f26180e, 0, 3);
            } else {
                i = position;
                i2 = i9;
                i3 = limit;
            }
            if (gr1Var != null) {
                if (i11 > 0) {
                    gr1Var.m4980a(data, i, findNalUnit);
                    i5 = 0;
                } else {
                    i5 = -i11;
                }
                if (gr1Var.m4981b(i5)) {
                    int unescapeStream = NalUnitUtil.unescapeStream(gr1Var.f17812d, gr1Var.f17813e);
                    ParsableByteArray parsableByteArray2 = this.f10422d;
                    ((ParsableByteArray) Util.castNonNull(parsableByteArray2)).reset(gr1Var.f17812d, unescapeStream);
                    ((C0671c) Util.castNonNull(this.f10421c)).m2568a(this.f10432n, parsableByteArray2);
                }
                if (i10 == 178) {
                    z = true;
                    if (parsableByteArray.getData()[findNalUnit + 2] == 1) {
                        gr1Var.m4983d(i10);
                    }
                    if (i10 == 0 && i10 != 179) {
                        if (i10 == 184) {
                            this.f10433o = z;
                        }
                    } else {
                        i4 = i3 - findNalUnit;
                        if (this.f10434p && this.f10428j) {
                            j2 = this.f10432n;
                            if (j2 != C0643C.TIME_UNSET) {
                                this.f10420b.sampleMetadata(j2, this.f10433o ? 1 : 0, ((int) (this.f10426h - this.f10431m)) - i4, i4, null);
                            }
                        }
                        if (!this.f10427i && !this.f10434p) {
                            z2 = false;
                            z3 = true;
                        } else {
                            this.f10431m = this.f10426h - i4;
                            j = this.f10430l;
                            if (j == C0643C.TIME_UNSET) {
                                long j4 = this.f10432n;
                                if (j4 != C0643C.TIME_UNSET) {
                                    j = j4 + this.f10429k;
                                } else {
                                    j = -9223372036854775807L;
                                }
                            }
                            this.f10432n = j;
                            z2 = false;
                            this.f10433o = false;
                            this.f10430l = C0643C.TIME_UNSET;
                            z3 = true;
                            this.f10427i = true;
                        }
                        if (i10 != 0) {
                            z4 = z3;
                        } else {
                            z4 = z2;
                        }
                        this.f10434p = z4;
                    }
                    limit = i3;
                    position = i2;
                }
            }
            z = true;
            if (i10 == 0) {
            }
            i4 = i3 - findNalUnit;
            if (this.f10434p) {
                j2 = this.f10432n;
                if (j2 != C0643C.TIME_UNSET) {
                }
            }
            if (!this.f10427i) {
            }
            this.f10431m = this.f10426h - i4;
            j = this.f10430l;
            if (j == C0643C.TIME_UNSET) {
            }
            this.f10432n = j;
            z2 = false;
            this.f10433o = false;
            this.f10430l = C0643C.TIME_UNSET;
            z3 = true;
            this.f10427i = true;
            if (i10 != 0) {
            }
            this.f10434p = z4;
            limit = i3;
            position = i2;
        }
        if (!this.f10428j) {
            ry0Var.m7310a(data, position, limit);
        }
        if (gr1Var != null) {
            gr1Var.m4980a(data, position, limit);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.f10419a = trackIdGenerator.getFormatId();
        this.f10420b = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        C0671c c0671c = this.f10421c;
        if (c0671c != null) {
            c0671c.m2569b(extractorOutput, trackIdGenerator);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        this.f10430l = j;
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.ElementaryStreamReader
    public void seek() {
        NalUnitUtil.clearPrefixFlags(this.f10424f);
        ry0 ry0Var = this.f10425g;
        ry0Var.f26181a = false;
        ry0Var.f26182b = 0;
        ry0Var.f26183c = 0;
        gr1 gr1Var = this.f10423e;
        if (gr1Var != null) {
            gr1Var.m4982c();
        }
        this.f10426h = 0L;
        this.f10427i = false;
        this.f10430l = C0643C.TIME_UNSET;
        this.f10432n = C0643C.TIME_UNSET;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [ry0, java.lang.Object] */
    public H262Reader(C0671c c0671c) {
        this.f10421c = c0671c;
        this.f10424f = new boolean[4];
        ?? obj = new Object();
        obj.f26184d = new byte[128];
        this.f10425g = obj;
        if (c0671c != null) {
            this.f10423e = new gr1(178);
            this.f10422d = new ParsableByteArray();
        } else {
            this.f10423e = null;
            this.f10422d = null;
        }
        this.f10430l = C0643C.TIME_UNSET;
        this.f10432n = C0643C.TIME_UNSET;
    }
}
