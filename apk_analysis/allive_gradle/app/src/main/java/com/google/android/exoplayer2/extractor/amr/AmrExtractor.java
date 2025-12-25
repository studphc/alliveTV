package com.google.android.exoplayer2.extractor.amr;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import p000.C1255h3;

/* loaded from: classes.dex */
public final class AmrExtractor implements Extractor {
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING_ALWAYS = 2;

    /* renamed from: q */
    public static final int[] f10111q;

    /* renamed from: t */
    public static final int f10114t;

    /* renamed from: a */
    public final byte[] f10115a;

    /* renamed from: b */
    public final int f10116b;

    /* renamed from: c */
    public boolean f10117c;

    /* renamed from: d */
    public long f10118d;

    /* renamed from: e */
    public int f10119e;

    /* renamed from: f */
    public int f10120f;

    /* renamed from: g */
    public boolean f10121g;

    /* renamed from: h */
    public long f10122h;

    /* renamed from: i */
    public int f10123i;

    /* renamed from: j */
    public int f10124j;

    /* renamed from: k */
    public long f10125k;

    /* renamed from: l */
    public ExtractorOutput f10126l;

    /* renamed from: m */
    public TrackOutput f10127m;

    /* renamed from: n */
    public SeekMap f10128n;

    /* renamed from: o */
    public boolean f10129o;
    public static final ExtractorsFactory FACTORY = new C1255h3(5);

    /* renamed from: p */
    public static final int[] f10110p = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: r */
    public static final byte[] f10112r = Util.getUtf8Bytes("#!AMR\n");

    /* renamed from: s */
    public static final byte[] f10113s = Util.getUtf8Bytes("#!AMR-WB\n");

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Flags {
    }

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f10111q = iArr;
        f10114t = iArr[8];
    }

    public AmrExtractor() {
        this(0);
    }

    /* renamed from: a */
    public final int m2535a(ExtractorInput extractorInput) {
        String str;
        boolean z;
        extractorInput.resetPeekPosition();
        byte[] bArr = this.f10115a;
        extractorInput.peekFully(bArr, 0, 1);
        byte b = bArr[0];
        if ((b & 131) <= 0) {
            int i = (b >> 3) & 15;
            if (i >= 0 && i <= 15 && (((z = this.f10117c) && (i < 10 || i > 13)) || (!z && (i < 12 || i > 14)))) {
                if (z) {
                    return f10111q[i];
                }
                return f10110p[i];
            }
            StringBuilder sb = new StringBuilder("Illegal AMR ");
            if (this.f10117c) {
                str = "WB";
            } else {
                str = "NB";
            }
            sb.append(str);
            sb.append(" frame type ");
            sb.append(i);
            throw ParserException.createForMalformedContainer(sb.toString(), null);
        }
        throw ParserException.createForMalformedContainer("Invalid padding bits for frame header " + ((int) b), null);
    }

    /* renamed from: b */
    public final boolean m2536b(ExtractorInput extractorInput) {
        extractorInput.resetPeekPosition();
        byte[] bArr = f10112r;
        byte[] bArr2 = new byte[bArr.length];
        extractorInput.peekFully(bArr2, 0, bArr.length);
        if (Arrays.equals(bArr2, bArr)) {
            this.f10117c = false;
            extractorInput.skipFully(bArr.length);
            return true;
        }
        extractorInput.resetPeekPosition();
        byte[] bArr3 = f10113s;
        byte[] bArr4 = new byte[bArr3.length];
        extractorInput.peekFully(bArr4, 0, bArr3.length);
        if (!Arrays.equals(bArr4, bArr3)) {
            return false;
        }
        this.f10117c = true;
        extractorInput.skipFully(bArr3.length);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.f10126l = extractorOutput;
        this.f10127m = extractorOutput.track(0, 1);
        extractorOutput.endTracks();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        int i;
        int i2;
        boolean z;
        String str;
        int i3;
        Assertions.checkStateNotNull(this.f10127m);
        Util.castNonNull(this.f10126l);
        if (extractorInput.getPosition() == 0 && !m2536b(extractorInput)) {
            throw ParserException.createForMalformedContainer("Could not find AMR header.", null);
        }
        if (!this.f10129o) {
            this.f10129o = true;
            boolean z2 = this.f10117c;
            if (z2) {
                str = MimeTypes.AUDIO_AMR_WB;
            } else {
                str = MimeTypes.AUDIO_AMR_NB;
            }
            if (z2) {
                i3 = AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND;
            } else {
                i3 = 8000;
            }
            this.f10127m.format(new Format.Builder().setSampleMimeType(str).setMaxInputSize(f10114t).setChannelCount(1).setSampleRate(i3).build());
        }
        if (this.f10120f == 0) {
            try {
                int m2535a = m2535a(extractorInput);
                this.f10119e = m2535a;
                this.f10120f = m2535a;
                if (this.f10123i == -1) {
                    this.f10122h = extractorInput.getPosition();
                    this.f10123i = this.f10119e;
                }
                if (this.f10123i == this.f10119e) {
                    this.f10124j++;
                }
            } catch (EOFException unused) {
            }
        }
        int sampleData = this.f10127m.sampleData((DataReader) extractorInput, this.f10120f, true);
        if (sampleData != -1) {
            int i4 = this.f10120f - sampleData;
            this.f10120f = i4;
            if (i4 <= 0) {
                this.f10127m.sampleMetadata(this.f10125k + this.f10118d, 1, this.f10119e, 0, null);
                this.f10118d += SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US;
            }
            i = 0;
            long length = extractorInput.getLength();
            if (!this.f10121g) {
                int i5 = this.f10116b;
                if ((i5 & 1) != 0 && length != -1 && ((i2 = this.f10123i) == -1 || i2 == this.f10119e)) {
                    if (this.f10124j >= 20 || i == -1) {
                        if ((i5 & 2) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ConstantBitrateSeekMap constantBitrateSeekMap = new ConstantBitrateSeekMap(length, this.f10122h, (int) ((i2 * 8000000) / SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US), i2, z);
                        this.f10128n = constantBitrateSeekMap;
                        this.f10126l.seekMap(constantBitrateSeekMap);
                        this.f10121g = true;
                    }
                } else {
                    SeekMap.Unseekable unseekable = new SeekMap.Unseekable(C0643C.TIME_UNSET);
                    this.f10128n = unseekable;
                    this.f10126l.seekMap(unseekable);
                    this.f10121g = true;
                }
            }
            return i;
        }
        i = -1;
        long length2 = extractorInput.getLength();
        if (!this.f10121g) {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        this.f10118d = 0L;
        this.f10119e = 0;
        this.f10120f = 0;
        if (j != 0) {
            SeekMap seekMap = this.f10128n;
            if (seekMap instanceof ConstantBitrateSeekMap) {
                this.f10125k = ((ConstantBitrateSeekMap) seekMap).getTimeUsAtPosition(j);
                return;
            }
        }
        this.f10125k = 0L;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) {
        return m2536b(extractorInput);
    }

    public AmrExtractor(int i) {
        this.f10116b = (i & 2) != 0 ? i | 1 : i;
        this.f10115a = new byte[1];
        this.f10123i = -1;
    }
}
