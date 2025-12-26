package com.google.android.exoplayer2.extractor.p002ts;

import androidx.core.view.InputDeviceCompat;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public final class SectionReader implements TsPayloadReader {

    /* renamed from: a */
    public final SectionPayloadReader f10541a;

    /* renamed from: b */
    public final ParsableByteArray f10542b = new ParsableByteArray(32);

    /* renamed from: c */
    public int f10543c;

    /* renamed from: d */
    public int f10544d;

    /* renamed from: e */
    public boolean f10545e;

    /* renamed from: f */
    public boolean f10546f;

    public SectionReader(SectionPayloadReader sectionPayloadReader) {
        this.f10541a = sectionPayloadReader;
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader
    public void consume(ParsableByteArray parsableByteArray, int i) {
        boolean z;
        int i2;
        boolean z2;
        if ((i & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i2 = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
        } else {
            i2 = -1;
        }
        if (this.f10546f) {
            if (!z) {
                return;
            }
            this.f10546f = false;
            parsableByteArray.setPosition(i2);
            this.f10544d = 0;
        }
        while (parsableByteArray.bytesLeft() > 0) {
            int i3 = this.f10544d;
            ParsableByteArray parsableByteArray2 = this.f10542b;
            if (i3 < 3) {
                if (i3 == 0) {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    parsableByteArray.setPosition(parsableByteArray.getPosition() - 1);
                    if (readUnsignedByte == 255) {
                        this.f10546f = true;
                        return;
                    }
                }
                int min = Math.min(parsableByteArray.bytesLeft(), 3 - this.f10544d);
                parsableByteArray.readBytes(parsableByteArray2.getData(), this.f10544d, min);
                int i4 = this.f10544d + min;
                this.f10544d = i4;
                if (i4 == 3) {
                    parsableByteArray2.setPosition(0);
                    parsableByteArray2.setLimit(3);
                    parsableByteArray2.skipBytes(1);
                    int readUnsignedByte2 = parsableByteArray2.readUnsignedByte();
                    int readUnsignedByte3 = parsableByteArray2.readUnsignedByte();
                    if ((readUnsignedByte2 & 128) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.f10545e = z2;
                    this.f10543c = (((readUnsignedByte2 & 15) << 8) | readUnsignedByte3) + 3;
                    int capacity = parsableByteArray2.capacity();
                    int i5 = this.f10543c;
                    if (capacity < i5) {
                        parsableByteArray2.ensureCapacity(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i5, parsableByteArray2.capacity() * 2)));
                    }
                }
            } else {
                int min2 = Math.min(parsableByteArray.bytesLeft(), this.f10543c - this.f10544d);
                parsableByteArray.readBytes(parsableByteArray2.getData(), this.f10544d, min2);
                int i6 = this.f10544d + min2;
                this.f10544d = i6;
                int i7 = this.f10543c;
                if (i6 != i7) {
                    continue;
                } else {
                    if (this.f10545e) {
                        if (Util.crc32(parsableByteArray2.getData(), 0, this.f10543c, -1) != 0) {
                            this.f10546f = true;
                            return;
                        }
                        parsableByteArray2.setLimit(this.f10543c - 4);
                    } else {
                        parsableByteArray2.setLimit(i7);
                    }
                    parsableByteArray2.setPosition(0);
                    this.f10541a.consume(parsableByteArray2);
                    this.f10544d = 0;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader
    public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f10541a.init(timestampAdjuster, extractorOutput, trackIdGenerator);
        this.f10546f = true;
    }

    @Override // com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader
    public void seek() {
        this.f10546f = true;
    }
}
