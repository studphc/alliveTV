package com.google.android.exoplayer2.extractor.p002ts;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.p002ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import p000.d82;
import p000.e82;
import p000.ee0;
import p000.f82;
import p000.g82;

/* loaded from: classes.dex */
public final class PsExtractor implements Extractor {
    public static final int AUDIO_STREAM = 192;
    public static final int AUDIO_STREAM_MASK = 224;
    public static final ExtractorsFactory FACTORY = new ee0(29);
    public static final int PRIVATE_STREAM_1 = 189;
    public static final int VIDEO_STREAM = 224;
    public static final int VIDEO_STREAM_MASK = 240;

    /* renamed from: a */
    public final TimestampAdjuster f10530a;

    /* renamed from: b */
    public final SparseArray f10531b;

    /* renamed from: c */
    public final ParsableByteArray f10532c;

    /* renamed from: d */
    public final f82 f10533d;

    /* renamed from: e */
    public boolean f10534e;

    /* renamed from: f */
    public boolean f10535f;

    /* renamed from: g */
    public boolean f10536g;

    /* renamed from: h */
    public long f10537h;

    /* renamed from: i */
    public e82 f10538i;

    /* renamed from: j */
    public ExtractorOutput f10539j;

    /* renamed from: k */
    public boolean f10540k;

    public PsExtractor() {
        this(new TimestampAdjuster(0L));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.f10539j = extractorOutput;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [com.google.android.exoplayer2.extractor.BinarySearchSeeker, e82] */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        long j;
        long j2;
        ElementaryStreamReader elementaryStreamReader;
        long j3;
        long j4;
        Assertions.checkStateNotNull(this.f10539j);
        long length = extractorInput.getLength();
        f82 f82Var = this.f10533d;
        int i = 1;
        if (length != -1 && !f82Var.f17172c) {
            boolean z = f82Var.f17174e;
            ParsableByteArray parsableByteArray = f82Var.f17171b;
            if (!z) {
                long length2 = extractorInput.getLength();
                int min = (int) Math.min(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, length2);
                long j5 = length2 - min;
                if (extractorInput.getPosition() != j5) {
                    positionHolder.position = j5;
                } else {
                    parsableByteArray.reset(min);
                    extractorInput.resetPeekPosition();
                    extractorInput.peekFully(parsableByteArray.getData(), 0, min);
                    int position = parsableByteArray.getPosition();
                    int limit = parsableByteArray.limit() - 4;
                    while (true) {
                        if (limit >= position) {
                            if (f82.m4777a(limit, parsableByteArray.getData()) == 442) {
                                parsableByteArray.setPosition(limit + 4);
                                long m4778b = f82.m4778b(parsableByteArray);
                                if (m4778b != C0643C.TIME_UNSET) {
                                    j4 = m4778b;
                                    break;
                                }
                            }
                            limit--;
                        } else {
                            j4 = C0643C.TIME_UNSET;
                            break;
                        }
                    }
                    f82Var.f17176g = j4;
                    f82Var.f17174e = true;
                    i = 0;
                }
            } else {
                if (f82Var.f17176g == C0643C.TIME_UNSET) {
                    parsableByteArray.reset(Util.EMPTY_BYTE_ARRAY);
                    f82Var.f17172c = true;
                    extractorInput.resetPeekPosition();
                    return 0;
                }
                if (!f82Var.f17173d) {
                    int min2 = (int) Math.min(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, extractorInput.getLength());
                    long j6 = 0;
                    if (extractorInput.getPosition() != j6) {
                        positionHolder.position = j6;
                    } else {
                        parsableByteArray.reset(min2);
                        extractorInput.resetPeekPosition();
                        extractorInput.peekFully(parsableByteArray.getData(), 0, min2);
                        int position2 = parsableByteArray.getPosition();
                        int limit2 = parsableByteArray.limit();
                        while (true) {
                            if (position2 < limit2 - 3) {
                                if (f82.m4777a(position2, parsableByteArray.getData()) == 442) {
                                    parsableByteArray.setPosition(position2 + 4);
                                    long m4778b2 = f82.m4778b(parsableByteArray);
                                    if (m4778b2 != C0643C.TIME_UNSET) {
                                        j3 = m4778b2;
                                        break;
                                    }
                                }
                                position2++;
                            } else {
                                j3 = C0643C.TIME_UNSET;
                                break;
                            }
                        }
                        f82Var.f17175f = j3;
                        f82Var.f17173d = true;
                        i = 0;
                    }
                } else {
                    long j7 = f82Var.f17175f;
                    if (j7 == C0643C.TIME_UNSET) {
                        parsableByteArray.reset(Util.EMPTY_BYTE_ARRAY);
                        f82Var.f17172c = true;
                        extractorInput.resetPeekPosition();
                        return 0;
                    }
                    TimestampAdjuster timestampAdjuster = f82Var.f17170a;
                    long adjustTsTimestamp = timestampAdjuster.adjustTsTimestamp(f82Var.f17176g) - timestampAdjuster.adjustTsTimestamp(j7);
                    f82Var.f17177h = adjustTsTimestamp;
                    if (adjustTsTimestamp < 0) {
                        Log.m3027w("PsDurationReader", "Invalid duration: " + f82Var.f17177h + ". Using TIME_UNSET instead.");
                        f82Var.f17177h = C0643C.TIME_UNSET;
                    }
                    parsableByteArray.reset(Util.EMPTY_BYTE_ARRAY);
                    f82Var.f17172c = true;
                    extractorInput.resetPeekPosition();
                    return 0;
                }
            }
            return i;
        }
        if (!this.f10540k) {
            this.f10540k = true;
            long j8 = f82Var.f17177h;
            if (j8 != C0643C.TIME_UNSET) {
                ?? binarySearchSeeker = new BinarySearchSeeker(new BinarySearchSeeker.DefaultSeekTimestampConverter(), new d82(f82Var.f17170a), j8, 0L, j8 + 1, 0L, length, 188L, 1000);
                this.f10538i = binarySearchSeeker;
                this.f10539j.seekMap(binarySearchSeeker.getSeekMap());
            } else {
                this.f10539j.seekMap(new SeekMap.Unseekable(j8));
            }
        }
        e82 e82Var = this.f10538i;
        if (e82Var != null && e82Var.isSeeking()) {
            return this.f10538i.handlePendingSeek(extractorInput, positionHolder);
        }
        extractorInput.resetPeekPosition();
        if (length != -1) {
            j = length - extractorInput.getPeekPosition();
        } else {
            j = -1;
        }
        if (j != -1 && j < 4) {
            return -1;
        }
        ParsableByteArray parsableByteArray2 = this.f10532c;
        if (!extractorInput.peekFully(parsableByteArray2.getData(), 0, 4, true)) {
            return -1;
        }
        parsableByteArray2.setPosition(0);
        int readInt = parsableByteArray2.readInt();
        if (readInt == 441) {
            return -1;
        }
        if (readInt == 442) {
            extractorInput.peekFully(parsableByteArray2.getData(), 0, 10);
            parsableByteArray2.setPosition(9);
            extractorInput.skipFully((parsableByteArray2.readUnsignedByte() & 7) + 14);
            return 0;
        }
        if (readInt == 443) {
            extractorInput.peekFully(parsableByteArray2.getData(), 0, 2);
            parsableByteArray2.setPosition(0);
            extractorInput.skipFully(parsableByteArray2.readUnsignedShort() + 6);
            return 0;
        }
        if (((readInt & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            extractorInput.skipFully(1);
            return 0;
        }
        int i2 = readInt & 255;
        SparseArray sparseArray = this.f10531b;
        g82 g82Var = (g82) sparseArray.get(i2);
        if (!this.f10534e) {
            if (g82Var == null) {
                if (i2 == 189) {
                    elementaryStreamReader = new Ac3Reader();
                    this.f10535f = true;
                    this.f10537h = extractorInput.getPosition();
                } else if ((readInt & 224) == 192) {
                    elementaryStreamReader = new MpegAudioReader();
                    this.f10535f = true;
                    this.f10537h = extractorInput.getPosition();
                } else if ((readInt & VIDEO_STREAM_MASK) == 224) {
                    elementaryStreamReader = new H262Reader();
                    this.f10536g = true;
                    this.f10537h = extractorInput.getPosition();
                } else {
                    elementaryStreamReader = null;
                }
                if (elementaryStreamReader != null) {
                    elementaryStreamReader.createTracks(this.f10539j, new TsPayloadReader.TrackIdGenerator(i2, 256));
                    g82Var = new g82(elementaryStreamReader, this.f10530a);
                    sparseArray.put(i2, g82Var);
                }
            }
            if (this.f10535f && this.f10536g) {
                j2 = this.f10537h + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            } else {
                j2 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            if (extractorInput.getPosition() > j2) {
                this.f10534e = true;
                this.f10539j.endTracks();
            }
        }
        extractorInput.peekFully(parsableByteArray2.getData(), 0, 2);
        parsableByteArray2.setPosition(0);
        int readUnsignedShort = parsableByteArray2.readUnsignedShort() + 6;
        if (g82Var == null) {
            extractorInput.skipFully(readUnsignedShort);
        } else {
            parsableByteArray2.reset(readUnsignedShort);
            extractorInput.readFully(parsableByteArray2.getData(), 0, readUnsignedShort);
            parsableByteArray2.setPosition(6);
            ParsableBitArray parsableBitArray = g82Var.f17604c;
            parsableByteArray2.readBytes(parsableBitArray.data, 0, 3);
            parsableBitArray.setPosition(0);
            parsableBitArray.skipBits(8);
            g82Var.f17605d = parsableBitArray.readBit();
            g82Var.f17606e = parsableBitArray.readBit();
            parsableBitArray.skipBits(6);
            parsableByteArray2.readBytes(parsableBitArray.data, 0, parsableBitArray.readBits(8));
            parsableBitArray.setPosition(0);
            g82Var.f17608g = 0L;
            if (g82Var.f17605d) {
                parsableBitArray.skipBits(4);
                parsableBitArray.skipBits(1);
                parsableBitArray.skipBits(1);
                long readBits = (parsableBitArray.readBits(3) << 30) | (parsableBitArray.readBits(15) << 15) | parsableBitArray.readBits(15);
                parsableBitArray.skipBits(1);
                boolean z2 = g82Var.f17607f;
                TimestampAdjuster timestampAdjuster2 = g82Var.f17603b;
                if (!z2 && g82Var.f17606e) {
                    parsableBitArray.skipBits(4);
                    parsableBitArray.skipBits(1);
                    parsableBitArray.skipBits(1);
                    parsableBitArray.skipBits(1);
                    timestampAdjuster2.adjustTsTimestamp((parsableBitArray.readBits(3) << 30) | (parsableBitArray.readBits(15) << 15) | parsableBitArray.readBits(15));
                    g82Var.f17607f = true;
                }
                g82Var.f17608g = timestampAdjuster2.adjustTsTimestamp(readBits);
            }
            long j9 = g82Var.f17608g;
            ElementaryStreamReader elementaryStreamReader2 = g82Var.f17602a;
            elementaryStreamReader2.packetStarted(j9, 4);
            elementaryStreamReader2.consume(parsableByteArray2);
            elementaryStreamReader2.packetFinished();
            parsableByteArray2.setLimit(parsableByteArray2.capacity());
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        boolean z;
        TimestampAdjuster timestampAdjuster = this.f10530a;
        boolean z2 = true;
        if (timestampAdjuster.getTimestampOffsetUs() == C0643C.TIME_UNSET) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            long firstSampleTimestampUs = timestampAdjuster.getFirstSampleTimestampUs();
            if (firstSampleTimestampUs == C0643C.TIME_UNSET || firstSampleTimestampUs == 0 || firstSampleTimestampUs == j2) {
                z2 = false;
            }
            z = z2;
        }
        if (z) {
            timestampAdjuster.reset(j2);
        }
        e82 e82Var = this.f10538i;
        if (e82Var != null) {
            e82Var.setSeekTargetUs(j2);
        }
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.f10531b;
            if (i < sparseArray.size()) {
                g82 g82Var = (g82) sparseArray.valueAt(i);
                g82Var.f17607f = false;
                g82Var.f17602a.seek();
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) {
        byte[] bArr = new byte[14];
        extractorInput.peekFully(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        extractorInput.advancePeekPosition(bArr[13] & 7);
        extractorInput.peekFully(bArr, 0, 3);
        if (1 != (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
            return false;
        }
        return true;
    }

    public PsExtractor(TimestampAdjuster timestampAdjuster) {
        this.f10530a = timestampAdjuster;
        this.f10532c = new ParsableByteArray(4096);
        this.f10531b = new SparseArray();
        this.f10533d = new f82();
    }
}
