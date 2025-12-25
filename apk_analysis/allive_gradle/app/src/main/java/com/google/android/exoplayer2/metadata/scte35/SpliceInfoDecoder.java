package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class SpliceInfoDecoder extends SimpleMetadataDecoder {

    /* renamed from: a */
    public final ParsableByteArray f10767a = new ParsableByteArray();

    /* renamed from: b */
    public final ParsableBitArray f10768b = new ParsableBitArray();

    /* renamed from: c */
    public TimestampAdjuster f10769c;

    @Override // com.google.android.exoplayer2.metadata.SimpleMetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        Metadata.Entry spliceNullCommand;
        boolean z;
        int i;
        int i2;
        long j;
        ArrayList arrayList;
        long j2;
        long j3;
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        int i5;
        boolean z5;
        boolean z6;
        boolean z7;
        long j4;
        long j5;
        boolean z8;
        boolean z9;
        List list;
        long j6;
        long j7;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i6;
        int i7;
        int i8;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        long j8;
        boolean z18;
        long j9;
        int i9 = 32;
        boolean z19 = true;
        TimestampAdjuster timestampAdjuster = this.f10769c;
        if (timestampAdjuster == null || metadataInputBuffer.subsampleOffsetUs != timestampAdjuster.getTimestampOffsetUs()) {
            TimestampAdjuster timestampAdjuster2 = new TimestampAdjuster(metadataInputBuffer.timeUs);
            this.f10769c = timestampAdjuster2;
            timestampAdjuster2.adjustSampleTimestamp(metadataInputBuffer.timeUs - metadataInputBuffer.subsampleOffsetUs);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        ParsableByteArray parsableByteArray = this.f10767a;
        parsableByteArray.reset(array, limit);
        ParsableBitArray parsableBitArray = this.f10768b;
        parsableBitArray.reset(array, limit);
        parsableBitArray.skipBits(39);
        long readBits = (parsableBitArray.readBits(1) << 32) | parsableBitArray.readBits(32);
        parsableBitArray.skipBits(20);
        int readBits2 = parsableBitArray.readBits(12);
        int readBits3 = parsableBitArray.readBits(8);
        parsableByteArray.skipBytes(14);
        if (readBits3 != 0) {
            if (readBits3 != 255) {
                long j10 = 1;
                long j11 = C0643C.TIME_UNSET;
                if (readBits3 != 4) {
                    if (readBits3 != 5) {
                        if (readBits3 != 6) {
                            spliceNullCommand = null;
                        } else {
                            TimestampAdjuster timestampAdjuster3 = this.f10769c;
                            long m2693a = TimeSignalCommand.m2693a(readBits, parsableByteArray);
                            spliceNullCommand = new TimeSignalCommand(m2693a, timestampAdjuster3.adjustTsTimestamp(m2693a));
                        }
                    } else {
                        TimestampAdjuster timestampAdjuster4 = this.f10769c;
                        long readUnsignedInt = parsableByteArray.readUnsignedInt();
                        if ((parsableByteArray.readUnsignedByte() & 128) != 0) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        List emptyList = Collections.emptyList();
                        if (!z9) {
                            int readUnsignedByte = parsableByteArray.readUnsignedByte();
                            if ((readUnsignedByte & 128) != 0) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            if ((readUnsignedByte & 64) != 0) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                            if ((readUnsignedByte & 32) != 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if ((readUnsignedByte & 16) != 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z15 && !z17) {
                                j8 = TimeSignalCommand.m2693a(readBits, parsableByteArray);
                            } else {
                                j8 = -9223372036854775807L;
                            }
                            if (!z15) {
                                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                                ArrayList arrayList2 = new ArrayList(readUnsignedByte2);
                                for (int i10 = 0; i10 < readUnsignedByte2; i10++) {
                                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                                    if (!z17) {
                                        j9 = TimeSignalCommand.m2693a(readBits, parsableByteArray);
                                    } else {
                                        j9 = -9223372036854775807L;
                                    }
                                    arrayList2.add(new SpliceInsertCommand.ComponentSplice(readUnsignedByte3, j9, timestampAdjuster4.adjustTsTimestamp(j9)));
                                }
                                emptyList = arrayList2;
                            }
                            if (z16) {
                                long readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                                if ((readUnsignedByte4 & 128) != 0) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                j11 = ((((readUnsignedByte4 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
                            } else {
                                z18 = false;
                            }
                            int readUnsignedShort = parsableByteArray.readUnsignedShort();
                            int readUnsignedByte5 = parsableByteArray.readUnsignedByte();
                            z13 = z18;
                            i6 = readUnsignedShort;
                            list = emptyList;
                            i8 = parsableByteArray.readUnsignedByte();
                            i7 = readUnsignedByte5;
                            z10 = z14;
                            j7 = j11;
                            j6 = j8;
                            z12 = z17;
                            z11 = z15;
                        } else {
                            list = emptyList;
                            j6 = -9223372036854775807L;
                            j7 = -9223372036854775807L;
                            z10 = false;
                            z11 = false;
                            z12 = false;
                            z13 = false;
                            i6 = 0;
                            i7 = 0;
                            i8 = 0;
                        }
                        spliceNullCommand = new SpliceInsertCommand(readUnsignedInt, z9, z10, z11, z12, j6, timestampAdjuster4.adjustTsTimestamp(j6), list, z13, j7, i6, i7, i8);
                    }
                } else {
                    int readUnsignedByte6 = parsableByteArray.readUnsignedByte();
                    ArrayList arrayList3 = new ArrayList(readUnsignedByte6);
                    int i11 = 0;
                    while (i11 < readUnsignedByte6) {
                        long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
                        if ((parsableByteArray.readUnsignedByte() & 128) != 0) {
                            z = z19;
                        } else {
                            z = false;
                        }
                        ArrayList arrayList4 = new ArrayList();
                        if (!z) {
                            int readUnsignedByte7 = parsableByteArray.readUnsignedByte();
                            if ((readUnsignedByte7 & 128) != 0) {
                                z5 = z19;
                            } else {
                                z5 = false;
                            }
                            if ((readUnsignedByte7 & 64) != 0) {
                                z6 = z19;
                            } else {
                                z6 = false;
                            }
                            if ((readUnsignedByte7 & i9) != 0) {
                                z7 = z19;
                            } else {
                                z7 = false;
                            }
                            if (z6) {
                                j4 = parsableByteArray.readUnsignedInt();
                            } else {
                                j4 = -9223372036854775807L;
                            }
                            if (!z6) {
                                int readUnsignedByte8 = parsableByteArray.readUnsignedByte();
                                ArrayList arrayList5 = new ArrayList(readUnsignedByte8);
                                int i12 = 0;
                                while (i12 < readUnsignedByte8) {
                                    arrayList5.add(new SpliceScheduleCommand.ComponentSplice(parsableByteArray.readUnsignedByte(), parsableByteArray.readUnsignedInt()));
                                    i12++;
                                    i11 = i11;
                                }
                                i2 = i11;
                                arrayList4 = arrayList5;
                            } else {
                                i2 = i11;
                            }
                            if (z7) {
                                long readUnsignedByte9 = parsableByteArray.readUnsignedByte();
                                if ((readUnsignedByte9 & 128) != 0) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                j = 1;
                                i = 32;
                                j5 = ((((readUnsignedByte9 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
                            } else {
                                i = 32;
                                j = 1;
                                j5 = -9223372036854775807L;
                                z8 = false;
                            }
                            j3 = j5;
                            z4 = z8;
                            arrayList = arrayList4;
                            z2 = z5;
                            z3 = z6;
                            j2 = j4;
                            i3 = parsableByteArray.readUnsignedShort();
                            i4 = parsableByteArray.readUnsignedByte();
                            i5 = parsableByteArray.readUnsignedByte();
                        } else {
                            i = i9;
                            i2 = i11;
                            j = j10;
                            arrayList = arrayList4;
                            j2 = -9223372036854775807L;
                            j3 = -9223372036854775807L;
                            z2 = false;
                            z3 = false;
                            z4 = false;
                            i3 = 0;
                            i4 = 0;
                            i5 = 0;
                        }
                        arrayList3.add(new SpliceScheduleCommand.Event(readUnsignedInt2, z, z2, z3, arrayList, j2, z4, j3, i3, i4, i5));
                        i11 = i2 + 1;
                        z19 = true;
                        i9 = i;
                        j10 = j;
                    }
                    spliceNullCommand = new SpliceScheduleCommand(arrayList3);
                }
            } else {
                long readUnsignedInt3 = parsableByteArray.readUnsignedInt();
                int i13 = readBits2 - 4;
                byte[] bArr = new byte[i13];
                parsableByteArray.readBytes(bArr, 0, i13);
                spliceNullCommand = new PrivateCommand(readUnsignedInt3, bArr, readBits);
            }
        } else {
            spliceNullCommand = new SpliceNullCommand();
        }
        if (spliceNullCommand == null) {
            return new Metadata(new Metadata.Entry[0]);
        }
        return new Metadata(spliceNullCommand);
    }
}
