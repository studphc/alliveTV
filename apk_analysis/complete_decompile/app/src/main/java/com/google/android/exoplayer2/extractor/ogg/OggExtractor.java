package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.VorbisUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import p000.C1540m9;
import p000.co2;
import p000.d10;
import p000.ee0;
import p000.k12;
import p000.q02;
import p000.r02;
import p000.re0;
import p000.s02;

/* loaded from: classes.dex */
public class OggExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new ee0(22);

    /* renamed from: a */
    public ExtractorOutput f10331a;

    /* renamed from: b */
    public co2 f10332b;

    /* renamed from: c */
    public boolean f10333c;

    /* renamed from: a */
    public final boolean m2561a(ExtractorInput extractorInput) {
        boolean z;
        r02 r02Var = new r02();
        if (r02Var.m7160a(extractorInput, true) && (r02Var.f25822a & 2) == 2) {
            int min = Math.min(r02Var.f25826e, 8);
            ParsableByteArray parsableByteArray = new ParsableByteArray(min);
            extractorInput.peekFully(parsableByteArray.getData(), 0, min);
            parsableByteArray.setPosition(0);
            if (parsableByteArray.bytesLeft() >= 5 && parsableByteArray.readUnsignedByte() == 127 && parsableByteArray.readUnsignedInt() == 1179402563) {
                this.f10332b = new co2();
            } else {
                parsableByteArray.setPosition(0);
                try {
                    z = VorbisUtil.verifyVorbisHeaderCapturePattern(1, parsableByteArray, true);
                } catch (ParserException unused) {
                    z = false;
                }
                if (z) {
                    this.f10332b = new co2();
                } else {
                    parsableByteArray.setPosition(0);
                    if (k12.m5481e(parsableByteArray, k12.f20715o)) {
                        this.f10332b = new co2();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.f10331a = extractorOutput;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v3, types: [s02, java.lang.Object] */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        boolean z;
        ParsableByteArray parsableByteArray;
        int i;
        Assertions.checkStateNotNull(this.f10331a);
        if (this.f10332b == null) {
            if (m2561a(extractorInput)) {
                extractorInput.resetPeekPosition();
            } else {
                throw ParserException.createForMalformedContainer("Failed to determine bitstream type", null);
            }
        }
        if (!this.f10333c) {
            TrackOutput track = this.f10331a.track(0, 1);
            this.f10331a.endTracks();
            co2 co2Var = this.f10332b;
            co2Var.f8438c = this.f10331a;
            co2Var.f8437b = track;
            co2Var.mo2268d(true);
            this.f10333c = true;
        }
        co2 co2Var2 = this.f10332b;
        Assertions.checkStateNotNull(co2Var2.f8437b);
        Util.castNonNull(co2Var2.f8438c);
        int i2 = co2Var2.f8443h;
        q02 q02Var = co2Var2.f8436a;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException();
                    }
                } else {
                    Util.castNonNull(co2Var2.f8439d);
                    long read = co2Var2.f8439d.read(extractorInput);
                    if (read >= 0) {
                        positionHolder.position = read;
                        return 1;
                    }
                    if (read < -1) {
                        co2Var2.mo2265a(-(read + 2));
                    }
                    if (!co2Var2.f8447l) {
                        co2Var2.f8438c.seekMap((SeekMap) Assertions.checkStateNotNull(co2Var2.f8439d.mo2124a()));
                        co2Var2.f8447l = true;
                    }
                    if (co2Var2.f8446k <= 0 && !q02Var.m6946b(extractorInput)) {
                        co2Var2.f8443h = 3;
                    } else {
                        co2Var2.f8446k = 0L;
                        ParsableByteArray parsableByteArray2 = q02Var.f25394b;
                        long mo2266b = co2Var2.mo2266b(parsableByteArray2);
                        if (mo2266b >= 0) {
                            long j = co2Var2.f8442g;
                            if (j + mo2266b >= co2Var2.f8440e) {
                                co2Var2.f8437b.sampleData(parsableByteArray2, parsableByteArray2.limit());
                                co2Var2.f8437b.sampleMetadata((j * 1000000) / co2Var2.f8444i, 1, parsableByteArray2.limit(), 0, null);
                                co2Var2.f8440e = -1L;
                            }
                        }
                        co2Var2.f8442g += mo2266b;
                        return 0;
                    }
                }
            } else {
                extractorInput.skipFully((int) co2Var2.f8441f);
                co2Var2.f8443h = 2;
                return 0;
            }
        } else {
            while (q02Var.m6946b(extractorInput)) {
                long position = extractorInput.getPosition();
                long j2 = co2Var2.f8441f;
                co2Var2.f8446k = position - j2;
                C1540m9 c1540m9 = co2Var2.f8445j;
                ParsableByteArray parsableByteArray3 = q02Var.f25394b;
                if (co2Var2.mo2267c(parsableByteArray3, j2, c1540m9)) {
                    co2Var2.f8441f = extractorInput.getPosition();
                } else {
                    Format format = (Format) co2Var2.f8445j.f22854b;
                    co2Var2.f8444i = format.sampleRate;
                    if (!co2Var2.f8448m) {
                        co2Var2.f8437b.format(format);
                        co2Var2.f8448m = true;
                    }
                    re0 re0Var = (re0) co2Var2.f8445j.f22855c;
                    if (re0Var != null) {
                        co2Var2.f8439d = re0Var;
                    } else if (extractorInput.getLength() == -1) {
                        co2Var2.f8439d = new Object();
                    } else {
                        r02 r02Var = q02Var.f25393a;
                        if ((r02Var.f25822a & 4) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        long j3 = co2Var2.f8441f;
                        long length = extractorInput.getLength();
                        long j4 = r02Var.f25825d + r02Var.f25826e;
                        long j5 = r02Var.f25823b;
                        parsableByteArray = parsableByteArray3;
                        i = 2;
                        co2Var2.f8439d = new d10(co2Var2, j3, length, j4, j5, z);
                        co2Var2.f8443h = i;
                        if (parsableByteArray.getData().length != 65025) {
                            return 0;
                        }
                        parsableByteArray.reset(Arrays.copyOf(parsableByteArray.getData(), Math.max(65025, parsableByteArray.limit())), parsableByteArray.limit());
                        return 0;
                    }
                    parsableByteArray = parsableByteArray3;
                    i = 2;
                    co2Var2.f8443h = i;
                    if (parsableByteArray.getData().length != 65025) {
                    }
                }
            }
            co2Var2.f8443h = 3;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        co2 co2Var = this.f10332b;
        if (co2Var != null) {
            q02 q02Var = co2Var.f8436a;
            r02 r02Var = q02Var.f25393a;
            r02Var.f25822a = 0;
            r02Var.f25823b = 0L;
            r02Var.f25824c = 0;
            r02Var.f25825d = 0;
            r02Var.f25826e = 0;
            q02Var.f25394b.reset(0);
            q02Var.f25395c = -1;
            q02Var.f25397e = false;
            if (j == 0) {
                co2Var.mo2268d(!co2Var.f8447l);
            } else if (co2Var.f8443h != 0) {
                co2Var.f8440e = (co2Var.f8444i * j2) / 1000000;
                ((s02) Util.castNonNull(co2Var.f8439d)).mo2125b(co2Var.f8440e);
                co2Var.f8443h = 2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) {
        try {
            return m2561a(extractorInput);
        } catch (ParserException unused) {
            return false;
        }
    }
}
