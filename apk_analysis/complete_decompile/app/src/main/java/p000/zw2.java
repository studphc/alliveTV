package p000;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.android.exoplayer2.extractor.p002ts.TsUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class zw2 implements BinarySearchSeeker.TimestampSeeker {

    /* renamed from: a */
    public final TimestampAdjuster f29547a;

    /* renamed from: b */
    public final ParsableByteArray f29548b = new ParsableByteArray();

    /* renamed from: c */
    public final int f29549c;

    /* renamed from: d */
    public final int f29550d;

    public zw2(int i, TimestampAdjuster timestampAdjuster, int i2) {
        this.f29549c = i;
        this.f29547a = timestampAdjuster;
        this.f29550d = i2;
    }

    @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
    public final void onSeekFinished() {
        this.f29548b.reset(Util.EMPTY_BYTE_ARRAY);
    }

    @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
    public final BinarySearchSeeker.TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long j) {
        int findSyncBytePosition;
        int findSyncBytePosition2;
        long position = extractorInput.getPosition();
        int min = (int) Math.min(this.f29550d, extractorInput.getLength() - position);
        ParsableByteArray parsableByteArray = this.f29548b;
        parsableByteArray.reset(min);
        extractorInput.peekFully(parsableByteArray.getData(), 0, min);
        int limit = parsableByteArray.limit();
        long j2 = -1;
        long j3 = -1;
        long j4 = -9223372036854775807L;
        while (parsableByteArray.bytesLeft() >= 188 && (findSyncBytePosition2 = (findSyncBytePosition = TsUtil.findSyncBytePosition(parsableByteArray.getData(), parsableByteArray.getPosition(), limit)) + TsExtractor.TS_PACKET_SIZE) <= limit) {
            long readPcrFromPacket = TsUtil.readPcrFromPacket(parsableByteArray, findSyncBytePosition, this.f29549c);
            if (readPcrFromPacket != C0643C.TIME_UNSET) {
                long adjustTsTimestamp = this.f29547a.adjustTsTimestamp(readPcrFromPacket);
                if (adjustTsTimestamp > j) {
                    if (j4 == C0643C.TIME_UNSET) {
                        return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(adjustTsTimestamp, position);
                    }
                    return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(position + j3);
                }
                if (100000 + adjustTsTimestamp > j) {
                    return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(position + findSyncBytePosition);
                }
                j3 = findSyncBytePosition;
                j4 = adjustTsTimestamp;
            }
            parsableByteArray.setPosition(findSyncBytePosition2);
            j2 = findSyncBytePosition2;
        }
        if (j4 != C0643C.TIME_UNSET) {
            return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(j4, position + j2);
        }
        return BinarySearchSeeker.TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
    }
}
