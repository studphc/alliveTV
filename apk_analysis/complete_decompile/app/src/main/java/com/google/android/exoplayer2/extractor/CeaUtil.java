package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes.dex */
public final class CeaUtil {
    public static final int USER_DATA_IDENTIFIER_GA94 = 1195456820;
    public static final int USER_DATA_TYPE_CODE_MPEG_CC = 3;

    public static void consume(long j, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        int i;
        int i2;
        boolean z;
        while (true) {
            boolean z2 = true;
            if (parsableByteArray.bytesLeft() > 1) {
                int i3 = 0;
                while (true) {
                    if (parsableByteArray.bytesLeft() == 0) {
                        i = -1;
                        break;
                    }
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    i3 += readUnsignedByte;
                    if (readUnsignedByte != 255) {
                        i = i3;
                        break;
                    }
                }
                int i4 = 0;
                while (true) {
                    if (parsableByteArray.bytesLeft() == 0) {
                        i4 = -1;
                        break;
                    }
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    i4 += readUnsignedByte2;
                    if (readUnsignedByte2 != 255) {
                        break;
                    }
                }
                int position = parsableByteArray.getPosition() + i4;
                if (i4 != -1 && i4 <= parsableByteArray.bytesLeft()) {
                    if (i == 4 && i4 >= 8) {
                        int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                        int readUnsignedShort = parsableByteArray.readUnsignedShort();
                        if (readUnsignedShort == 49) {
                            i2 = parsableByteArray.readInt();
                        } else {
                            i2 = 0;
                        }
                        int readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                        if (readUnsignedShort == 47) {
                            parsableByteArray.skipBytes(1);
                        }
                        if (readUnsignedByte3 == 181 && ((readUnsignedShort == 49 || readUnsignedShort == 47) && readUnsignedByte4 == 3)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (readUnsignedShort == 49) {
                            if (i2 != 1195456820) {
                                z2 = false;
                            }
                            z &= z2;
                        }
                        if (z) {
                            consumeCcData(j, parsableByteArray, trackOutputArr);
                        }
                    }
                } else {
                    Log.m3027w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                    position = parsableByteArray.limit();
                }
                parsableByteArray.setPosition(position);
            } else {
                return;
            }
        }
    }

    public static void consumeCcData(long j, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(1);
            int i = (readUnsignedByte & 31) * 3;
            int position = parsableByteArray.getPosition();
            for (TrackOutput trackOutput : trackOutputArr) {
                parsableByteArray.setPosition(position);
                trackOutput.sampleData(parsableByteArray, i);
                if (j != C0643C.TIME_UNSET) {
                    trackOutput.sampleMetadata(j, 1, i, 0, null);
                }
            }
        }
    }
}
