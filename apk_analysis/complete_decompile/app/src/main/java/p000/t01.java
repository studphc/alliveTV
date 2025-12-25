package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class t01 implements TrackOutput {

    /* renamed from: g */
    public static final Format f26645g = new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_ID3).build();

    /* renamed from: h */
    public static final Format f26646h = new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_EMSG).build();

    /* renamed from: a */
    public final EventMessageDecoder f26647a = new EventMessageDecoder();

    /* renamed from: b */
    public final TrackOutput f26648b;

    /* renamed from: c */
    public final Format f26649c;

    /* renamed from: d */
    public Format f26650d;

    /* renamed from: e */
    public byte[] f26651e;

    /* renamed from: f */
    public int f26652f;

    public t01(TrackOutput trackOutput, int i) {
        this.f26648b = trackOutput;
        if (i != 1) {
            if (i == 3) {
                this.f26649c = f26646h;
            } else {
                throw new IllegalArgumentException(ye0.m8291k(i, "Unknown metadataType: "));
            }
        } else {
            this.f26649c = f26645g;
        }
        this.f26651e = new byte[0];
        this.f26652f = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void format(Format format) {
        this.f26650d = format;
        this.f26648b.format(this.f26649c);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final /* synthetic */ int sampleData(DataReader dataReader, int i, boolean z) {
        return dv2.m4620a(this, dataReader, i, z);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
        Assertions.checkNotNull(this.f26650d);
        int i4 = this.f26652f - i3;
        ParsableByteArray parsableByteArray = new ParsableByteArray(Arrays.copyOfRange(this.f26651e, i4 - i2, i4));
        byte[] bArr = this.f26651e;
        System.arraycopy(bArr, i4, bArr, 0, i3);
        this.f26652f = i3;
        String str = this.f26650d.sampleMimeType;
        Format format = this.f26649c;
        if (!Util.areEqual(str, format.sampleMimeType)) {
            if (MimeTypes.APPLICATION_EMSG.equals(this.f26650d.sampleMimeType)) {
                EventMessage decode = this.f26647a.decode(parsableByteArray);
                Format wrappedMetadataFormat = decode.getWrappedMetadataFormat();
                if (wrappedMetadataFormat != null && Util.areEqual(format.sampleMimeType, wrappedMetadataFormat.sampleMimeType)) {
                    parsableByteArray = new ParsableByteArray((byte[]) Assertions.checkNotNull(decode.getWrappedMetadataBytes()));
                } else {
                    Log.m3027w("HlsSampleStreamWrapper", "Ignoring EMSG. Expected it to contain wrapped " + format.sampleMimeType + " but actual wrapped format: " + decode.getWrappedMetadataFormat());
                    return;
                }
            } else {
                Log.m3027w("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.f26650d.sampleMimeType);
                return;
            }
        }
        int bytesLeft = parsableByteArray.bytesLeft();
        this.f26648b.sampleData(parsableByteArray, bytesLeft);
        this.f26648b.sampleMetadata(j, i, bytesLeft, i3, cryptoData);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final /* synthetic */ void sampleData(ParsableByteArray parsableByteArray, int i) {
        dv2.m4621b(this, parsableByteArray, i);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final int sampleData(DataReader dataReader, int i, boolean z, int i2) {
        int i3 = this.f26652f + i;
        byte[] bArr = this.f26651e;
        if (bArr.length < i3) {
            this.f26651e = Arrays.copyOf(bArr, (i3 / 2) + i3);
        }
        int read = dataReader.read(this.f26651e, this.f26652f, i);
        if (read != -1) {
            this.f26652f += read;
            return read;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = this.f26652f + i;
        byte[] bArr = this.f26651e;
        if (bArr.length < i3) {
            this.f26651e = Arrays.copyOf(bArr, (i3 / 2) + i3);
        }
        parsableByteArray.readBytes(this.f26651e, this.f26652f, i);
        this.f26652f += i;
    }
}
