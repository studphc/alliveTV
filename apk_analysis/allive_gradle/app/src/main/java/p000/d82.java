package p000;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class d82 implements BinarySearchSeeker.TimestampSeeker {

    /* renamed from: a */
    public final TimestampAdjuster f16290a;

    /* renamed from: b */
    public final ParsableByteArray f16291b = new ParsableByteArray();

    public d82(TimestampAdjuster timestampAdjuster) {
        this.f16290a = timestampAdjuster;
    }

    @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
    public final void onSeekFinished() {
        this.f16291b.reset(Util.EMPTY_BYTE_ARRAY);
    }

    @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
    public final BinarySearchSeeker.TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long j) {
        long position = extractorInput.getPosition();
        int min = (int) Math.min(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, extractorInput.getLength() - position);
        ParsableByteArray parsableByteArray = this.f16291b;
        parsableByteArray.reset(min);
        extractorInput.peekFully(parsableByteArray.getData(), 0, min);
        int i = -1;
        int i2 = -1;
        long j2 = -9223372036854775807L;
        while (parsableByteArray.bytesLeft() >= 4) {
            if (e82.m4669a(parsableByteArray.getPosition(), parsableByteArray.getData()) != 442) {
                parsableByteArray.skipBytes(1);
            } else {
                parsableByteArray.skipBytes(4);
                long m4778b = f82.m4778b(parsableByteArray);
                if (m4778b != C0643C.TIME_UNSET) {
                    long adjustTsTimestamp = this.f16290a.adjustTsTimestamp(m4778b);
                    if (adjustTsTimestamp > j) {
                        if (j2 == C0643C.TIME_UNSET) {
                            return BinarySearchSeeker.TimestampSearchResult.overestimatedResult(adjustTsTimestamp, position);
                        }
                        return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(position + i2);
                    }
                    if (100000 + adjustTsTimestamp > j) {
                        return BinarySearchSeeker.TimestampSearchResult.targetFoundResult(position + parsableByteArray.getPosition());
                    }
                    i2 = parsableByteArray.getPosition();
                    j2 = adjustTsTimestamp;
                }
                int limit = parsableByteArray.limit();
                if (parsableByteArray.bytesLeft() < 10) {
                    parsableByteArray.setPosition(limit);
                } else {
                    parsableByteArray.skipBytes(9);
                    int readUnsignedByte = parsableByteArray.readUnsignedByte() & 7;
                    if (parsableByteArray.bytesLeft() < readUnsignedByte) {
                        parsableByteArray.setPosition(limit);
                    } else {
                        parsableByteArray.skipBytes(readUnsignedByte);
                        if (parsableByteArray.bytesLeft() < 4) {
                            parsableByteArray.setPosition(limit);
                        } else {
                            if (e82.m4669a(parsableByteArray.getPosition(), parsableByteArray.getData()) == 443) {
                                parsableByteArray.skipBytes(4);
                                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                                if (parsableByteArray.bytesLeft() < readUnsignedShort) {
                                    parsableByteArray.setPosition(limit);
                                } else {
                                    parsableByteArray.skipBytes(readUnsignedShort);
                                }
                            }
                            while (true) {
                                if (parsableByteArray.bytesLeft() < 4) {
                                    break;
                                }
                                int m4669a = e82.m4669a(parsableByteArray.getPosition(), parsableByteArray.getData());
                                if (m4669a == 442 || m4669a == 441 || (m4669a >>> 8) != 1) {
                                    break;
                                }
                                parsableByteArray.skipBytes(4);
                                if (parsableByteArray.bytesLeft() < 2) {
                                    parsableByteArray.setPosition(limit);
                                    break;
                                }
                                parsableByteArray.setPosition(Math.min(parsableByteArray.limit(), parsableByteArray.getPosition() + parsableByteArray.readUnsignedShort()));
                            }
                        }
                    }
                }
                i = parsableByteArray.getPosition();
            }
        }
        if (j2 != C0643C.TIME_UNSET) {
            return BinarySearchSeeker.TimestampSearchResult.underestimatedResult(j2, position + i);
        }
        return BinarySearchSeeker.TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
    }
}
