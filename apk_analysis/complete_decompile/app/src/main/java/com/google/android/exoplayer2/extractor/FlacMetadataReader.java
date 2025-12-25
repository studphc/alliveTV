package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class FlacMetadataReader {

    /* loaded from: classes.dex */
    public static final class FlacStreamMetadataHolder {

        @Nullable
        public FlacStreamMetadata flacStreamMetadata;

        public FlacStreamMetadataHolder(@Nullable FlacStreamMetadata flacStreamMetadata) {
            this.flacStreamMetadata = flacStreamMetadata;
        }
    }

    public static boolean checkAndPeekStreamMarker(ExtractorInput extractorInput) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        extractorInput.peekFully(parsableByteArray.getData(), 0, 4);
        if (parsableByteArray.readUnsignedInt() != 1716281667) {
            return false;
        }
        return true;
    }

    public static int getFrameStartMarker(ExtractorInput extractorInput) {
        extractorInput.resetPeekPosition();
        ParsableByteArray parsableByteArray = new ParsableByteArray(2);
        extractorInput.peekFully(parsableByteArray.getData(), 0, 2);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        if ((readUnsignedShort >> 2) == 16382) {
            extractorInput.resetPeekPosition();
            return readUnsignedShort;
        }
        extractorInput.resetPeekPosition();
        throw ParserException.createForMalformedContainer("First frame does not start with sync code.", null);
    }

    @Nullable
    public static Metadata peekId3Metadata(ExtractorInput extractorInput, boolean z) {
        Id3Decoder.FramePredicate framePredicate;
        if (z) {
            framePredicate = null;
        } else {
            framePredicate = Id3Decoder.NO_FRAMES_PREDICATE;
        }
        Metadata peekId3Data = new Id3Peeker().peekId3Data(extractorInput, framePredicate);
        if (peekId3Data == null || peekId3Data.length() == 0) {
            return null;
        }
        return peekId3Data;
    }

    @Nullable
    public static Metadata readId3Metadata(ExtractorInput extractorInput, boolean z) {
        extractorInput.resetPeekPosition();
        long peekPosition = extractorInput.getPeekPosition();
        Metadata peekId3Metadata = peekId3Metadata(extractorInput, z);
        extractorInput.skipFully((int) (extractorInput.getPeekPosition() - peekPosition));
        return peekId3Metadata;
    }

    public static boolean readMetadataBlock(ExtractorInput extractorInput, FlacStreamMetadataHolder flacStreamMetadataHolder) {
        extractorInput.resetPeekPosition();
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[4]);
        extractorInput.peekFully(parsableBitArray.data, 0, 4);
        boolean readBit = parsableBitArray.readBit();
        int readBits = parsableBitArray.readBits(7);
        int readBits2 = parsableBitArray.readBits(24) + 4;
        if (readBits == 0) {
            byte[] bArr = new byte[38];
            extractorInput.readFully(bArr, 0, 38);
            flacStreamMetadataHolder.flacStreamMetadata = new FlacStreamMetadata(bArr, 4);
        } else {
            FlacStreamMetadata flacStreamMetadata = flacStreamMetadataHolder.flacStreamMetadata;
            if (flacStreamMetadata != null) {
                if (readBits == 3) {
                    ParsableByteArray parsableByteArray = new ParsableByteArray(readBits2);
                    extractorInput.readFully(parsableByteArray.getData(), 0, readBits2);
                    flacStreamMetadataHolder.flacStreamMetadata = flacStreamMetadata.copyWithSeekTable(readSeekTableMetadataBlock(parsableByteArray));
                } else if (readBits == 4) {
                    ParsableByteArray parsableByteArray2 = new ParsableByteArray(readBits2);
                    extractorInput.readFully(parsableByteArray2.getData(), 0, readBits2);
                    parsableByteArray2.skipBytes(4);
                    flacStreamMetadataHolder.flacStreamMetadata = flacStreamMetadata.copyWithVorbisComments(Arrays.asList(VorbisUtil.readVorbisCommentHeader(parsableByteArray2, false, false).comments));
                } else if (readBits == 6) {
                    ParsableByteArray parsableByteArray3 = new ParsableByteArray(readBits2);
                    extractorInput.readFully(parsableByteArray3.getData(), 0, readBits2);
                    parsableByteArray3.skipBytes(4);
                    flacStreamMetadataHolder.flacStreamMetadata = flacStreamMetadata.copyWithPictureFrames(ImmutableList.m3903of(PictureFrame.fromPictureBlock(parsableByteArray3)));
                } else {
                    extractorInput.skipFully(readBits2);
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        return readBit;
    }

    public static FlacStreamMetadata.SeekTable readSeekTableMetadataBlock(ParsableByteArray parsableByteArray) {
        parsableByteArray.skipBytes(1);
        int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        long position = parsableByteArray.getPosition() + readUnsignedInt24;
        int i = readUnsignedInt24 / 18;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long readLong = parsableByteArray.readLong();
            if (readLong == -1) {
                jArr = Arrays.copyOf(jArr, i2);
                jArr2 = Arrays.copyOf(jArr2, i2);
                break;
            }
            jArr[i2] = readLong;
            jArr2[i2] = parsableByteArray.readLong();
            parsableByteArray.skipBytes(2);
            i2++;
        }
        parsableByteArray.skipBytes((int) (position - parsableByteArray.getPosition()));
        return new FlacStreamMetadata.SeekTable(jArr, jArr2);
    }

    public static void readStreamMarker(ExtractorInput extractorInput) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(4);
        extractorInput.readFully(parsableByteArray.getData(), 0, 4);
        if (parsableByteArray.readUnsignedInt() == 1716281667) {
        } else {
            throw ParserException.createForMalformedContainer("Failed to read FLAC stream marker.", null);
        }
    }
}
