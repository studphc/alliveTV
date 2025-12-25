package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class se0 extends co2 {

    /* renamed from: n */
    public FlacStreamMetadata f26393n;

    /* renamed from: o */
    public re0 f26394o;

    @Override // p000.co2
    /* renamed from: b */
    public final long mo2266b(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.getData()[0] == -1) {
            int i = (parsableByteArray.getData()[2] & 255) >> 4;
            if (i == 6 || i == 7) {
                parsableByteArray.skipBytes(4);
                parsableByteArray.readUtf8EncodedLong();
            }
            int readFrameBlockSizeSamplesFromKey = FlacFrameReader.readFrameBlockSizeSamplesFromKey(parsableByteArray, i);
            parsableByteArray.setPosition(0);
            return readFrameBlockSizeSamplesFromKey;
        }
        return -1L;
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, re0] */
    @Override // p000.co2
    /* renamed from: c */
    public final boolean mo2267c(ParsableByteArray parsableByteArray, long j, C1540m9 c1540m9) {
        byte[] data = parsableByteArray.getData();
        FlacStreamMetadata flacStreamMetadata = this.f26393n;
        if (flacStreamMetadata == null) {
            FlacStreamMetadata flacStreamMetadata2 = new FlacStreamMetadata(data, 17);
            this.f26393n = flacStreamMetadata2;
            c1540m9.f22854b = flacStreamMetadata2.getFormat(Arrays.copyOfRange(data, 9, parsableByteArray.limit()), null);
            return true;
        }
        byte b = data[0];
        if ((b & Byte.MAX_VALUE) == 3) {
            FlacStreamMetadata.SeekTable readSeekTableMetadataBlock = FlacMetadataReader.readSeekTableMetadataBlock(parsableByteArray);
            FlacStreamMetadata copyWithSeekTable = flacStreamMetadata.copyWithSeekTable(readSeekTableMetadataBlock);
            this.f26393n = copyWithSeekTable;
            ?? obj = new Object();
            obj.f25942a = copyWithSeekTable;
            obj.f25943b = readSeekTableMetadataBlock;
            obj.f25944c = -1L;
            obj.f25945d = -1L;
            this.f26394o = obj;
            return true;
        }
        if (b != -1) {
            return true;
        }
        re0 re0Var = this.f26394o;
        if (re0Var != null) {
            re0Var.f25944c = j;
            c1540m9.f22855c = re0Var;
        }
        Assertions.checkNotNull((Format) c1540m9.f22854b);
        return false;
    }

    @Override // p000.co2
    /* renamed from: d */
    public final void mo2268d(boolean z) {
        super.mo2268d(z);
        if (z) {
            this.f26393n = null;
            this.f26394o = null;
        }
    }
}
