package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.p002ts.PsExtractor;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class FlacFrameReader {

    /* loaded from: classes.dex */
    public static final class SampleNumberHolder {
        public long sampleNumber;
    }

    public static boolean checkAndReadFrameHeader(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i, SampleNumberHolder sampleNumberHolder) {
        boolean z;
        boolean z2;
        int position = parsableByteArray.getPosition();
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        long j = readUnsignedInt >>> 16;
        if (j != i) {
            return false;
        }
        if ((j & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        int i2 = (int) ((readUnsignedInt >> 12) & 15);
        int i3 = (int) ((readUnsignedInt >> 8) & 15);
        int i4 = (int) (15 & (readUnsignedInt >> 4));
        int i5 = (int) ((readUnsignedInt >> 1) & 7);
        if ((readUnsignedInt & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (i4 <= 7) {
            if (i4 != flacStreamMetadata.channels - 1) {
                return false;
            }
        } else if (i4 > 10 || flacStreamMetadata.channels != 2) {
            return false;
        }
        if ((i5 != 0 && i5 != flacStreamMetadata.bitsPerSampleLookupKey) || z2) {
            return false;
        }
        try {
            long readUtf8EncodedLong = parsableByteArray.readUtf8EncodedLong();
            if (!z) {
                readUtf8EncodedLong *= flacStreamMetadata.maxBlockSizeSamples;
            }
            sampleNumberHolder.sampleNumber = readUtf8EncodedLong;
            int readFrameBlockSizeSamplesFromKey = readFrameBlockSizeSamplesFromKey(parsableByteArray, i2);
            if (readFrameBlockSizeSamplesFromKey == -1 || readFrameBlockSizeSamplesFromKey > flacStreamMetadata.maxBlockSizeSamples) {
                return false;
            }
            int i6 = flacStreamMetadata.sampleRate;
            if (i3 != 0) {
                if (i3 <= 11) {
                    if (i3 != flacStreamMetadata.sampleRateLookupKey) {
                        return false;
                    }
                } else if (i3 == 12) {
                    if (parsableByteArray.readUnsignedByte() * 1000 != i6) {
                        return false;
                    }
                } else {
                    if (i3 > 14) {
                        return false;
                    }
                    int readUnsignedShort = parsableByteArray.readUnsignedShort();
                    if (i3 == 14) {
                        readUnsignedShort *= 10;
                    }
                    if (readUnsignedShort != i6) {
                        return false;
                    }
                }
            }
            if (parsableByteArray.readUnsignedByte() != Util.crc8(parsableByteArray.getData(), position, parsableByteArray.getPosition() - 1, 0)) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean checkFrameHeaderFromPeek(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata, int i, SampleNumberHolder sampleNumberHolder) {
        long peekPosition = extractorInput.getPeekPosition();
        byte[] bArr = new byte[2];
        extractorInput.peekFully(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
            extractorInput.resetPeekPosition();
            extractorInput.advancePeekPosition((int) (peekPosition - extractorInput.getPosition()));
            return false;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        System.arraycopy(bArr, 0, parsableByteArray.getData(), 0, 2);
        parsableByteArray.setLimit(ExtractorUtil.peekToLength(extractorInput, parsableByteArray.getData(), 2, 14));
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition((int) (peekPosition - extractorInput.getPosition()));
        return checkAndReadFrameHeader(parsableByteArray, flacStreamMetadata, i, sampleNumberHolder);
    }

    public static long getFirstSampleNumber(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata) {
        int i;
        extractorInput.resetPeekPosition();
        boolean z = true;
        extractorInput.advancePeekPosition(1);
        byte[] bArr = new byte[1];
        extractorInput.peekFully(bArr, 0, 1);
        if ((bArr[0] & 1) != 1) {
            z = false;
        }
        extractorInput.advancePeekPosition(2);
        if (z) {
            i = 7;
        } else {
            i = 6;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(i);
        parsableByteArray.setLimit(ExtractorUtil.peekToLength(extractorInput, parsableByteArray.getData(), 0, i));
        extractorInput.resetPeekPosition();
        SampleNumberHolder sampleNumberHolder = new SampleNumberHolder();
        try {
            long readUtf8EncodedLong = parsableByteArray.readUtf8EncodedLong();
            if (!z) {
                readUtf8EncodedLong *= flacStreamMetadata.maxBlockSizeSamples;
            }
            sampleNumberHolder.sampleNumber = readUtf8EncodedLong;
            return readUtf8EncodedLong;
        } catch (NumberFormatException unused) {
            throw ParserException.createForMalformedContainer(null, null);
        }
    }

    public static int readFrameBlockSizeSamplesFromKey(ParsableByteArray parsableByteArray, int i) {
        switch (i) {
            case 1:
                return PsExtractor.AUDIO_STREAM;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return parsableByteArray.readUnsignedByte() + 1;
            case 7:
                return parsableByteArray.readUnsignedShort() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }
}
