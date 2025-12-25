package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import p000.dv2;

/* renamed from: com.google.android.exoplayer2.source.chunk.a */
/* loaded from: classes.dex */
public final class C0691a implements TrackOutput {

    /* renamed from: a */
    public final int f11200a;

    /* renamed from: b */
    public final int f11201b;

    /* renamed from: c */
    public final Format f11202c;

    /* renamed from: d */
    public final DummyTrackOutput f11203d = new DummyTrackOutput();

    /* renamed from: e */
    public Format f11204e;

    /* renamed from: f */
    public TrackOutput f11205f;

    /* renamed from: g */
    public long f11206g;

    public C0691a(int i, int i2, Format format) {
        this.f11200a = i;
        this.f11201b = i2;
        this.f11202c = format;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void format(Format format) {
        Format format2 = this.f11202c;
        if (format2 != null) {
            format = format.withManifestFormatInfo(format2);
        }
        this.f11204e = format;
        ((TrackOutput) Util.castNonNull(this.f11205f)).format(this.f11204e);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final /* synthetic */ int sampleData(DataReader dataReader, int i, boolean z) {
        return dv2.m4620a(this, dataReader, i, z);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
        long j2 = this.f11206g;
        if (j2 != C0643C.TIME_UNSET && j >= j2) {
            this.f11205f = this.f11203d;
        }
        ((TrackOutput) Util.castNonNull(this.f11205f)).sampleMetadata(j, i, i2, i3, cryptoData);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final /* synthetic */ void sampleData(ParsableByteArray parsableByteArray, int i) {
        dv2.m4621b(this, parsableByteArray, i);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final int sampleData(DataReader dataReader, int i, boolean z, int i2) {
        return ((TrackOutput) Util.castNonNull(this.f11205f)).sampleData(dataReader, i, z);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
        ((TrackOutput) Util.castNonNull(this.f11205f)).sampleData(parsableByteArray, i);
    }
}
