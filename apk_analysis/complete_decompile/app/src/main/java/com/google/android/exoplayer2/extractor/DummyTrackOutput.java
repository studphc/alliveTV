package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import p000.dv2;

/* loaded from: classes.dex */
public final class DummyTrackOutput implements TrackOutput {

    /* renamed from: a */
    public final byte[] f10086a = new byte[4096];

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void format(Format format) {
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final /* synthetic */ int sampleData(DataReader dataReader, int i, boolean z) {
        return dv2.m4620a(this, dataReader, i, z);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleMetadata(long j, int i, int i2, int i3, @Nullable TrackOutput.CryptoData cryptoData) {
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final /* synthetic */ void sampleData(ParsableByteArray parsableByteArray, int i) {
        dv2.m4621b(this, parsableByteArray, i);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public int sampleData(DataReader dataReader, int i, boolean z, int i2) {
        byte[] bArr = this.f10086a;
        int read = dataReader.read(bArr, 0, Math.min(bArr.length, i));
        if (read != -1) {
            return read;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
        parsableByteArray.skipBytes(i);
    }
}
