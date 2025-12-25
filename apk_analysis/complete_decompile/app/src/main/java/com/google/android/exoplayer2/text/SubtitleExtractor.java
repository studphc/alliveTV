package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.IndexSeekMap;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class SubtitleExtractor implements Extractor {

    /* renamed from: a */
    public final SubtitleDecoder f11741a;

    /* renamed from: d */
    public final Format f11744d;

    /* renamed from: g */
    public ExtractorOutput f11747g;

    /* renamed from: h */
    public TrackOutput f11748h;

    /* renamed from: i */
    public int f11749i;

    /* renamed from: b */
    public final CueEncoder f11742b = new CueEncoder();

    /* renamed from: c */
    public final ParsableByteArray f11743c = new ParsableByteArray();

    /* renamed from: e */
    public final ArrayList f11745e = new ArrayList();

    /* renamed from: f */
    public final ArrayList f11746f = new ArrayList();

    /* renamed from: j */
    public int f11750j = 0;

    /* renamed from: k */
    public long f11751k = C0643C.TIME_UNSET;

    public SubtitleExtractor(SubtitleDecoder subtitleDecoder, Format format) {
        this.f11741a = subtitleDecoder;
        this.f11744d = format.buildUpon().setSampleMimeType(MimeTypes.TEXT_EXOPLAYER_CUES).setCodecs(format.sampleMimeType).build();
    }

    /* renamed from: a */
    public final void m2842a() {
        boolean z;
        int binarySearchFloor;
        Assertions.checkStateNotNull(this.f11748h);
        ArrayList arrayList = this.f11745e;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f11746f;
        if (size == arrayList2.size()) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        long j = this.f11751k;
        if (j == C0643C.TIME_UNSET) {
            binarySearchFloor = 0;
        } else {
            binarySearchFloor = Util.binarySearchFloor((List<? extends Comparable<? super Long>>) arrayList, Long.valueOf(j), true, true);
        }
        while (binarySearchFloor < arrayList2.size()) {
            ParsableByteArray parsableByteArray = (ParsableByteArray) arrayList2.get(binarySearchFloor);
            parsableByteArray.setPosition(0);
            int length = parsableByteArray.getData().length;
            this.f11748h.sampleData(parsableByteArray, length);
            this.f11748h.sampleMetadata(((Long) arrayList.get(binarySearchFloor)).longValue(), 1, length, 0, null);
            binarySearchFloor++;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        boolean z;
        if (this.f11750j == 0) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.f11747g = extractorOutput;
        this.f11748h = extractorOutput.track(0, 3);
        this.f11747g.endTracks();
        this.f11747g.seekMap(new IndexSeekMap(new long[]{0}, new long[]{0}, C0643C.TIME_UNSET));
        this.f11748h.format(this.f11744d);
        this.f11750j = 1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) {
        boolean z;
        int i;
        int i2 = this.f11750j;
        if (i2 != 0 && i2 != 5) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        int i3 = this.f11750j;
        int i4 = 1024;
        ParsableByteArray parsableByteArray = this.f11743c;
        if (i3 == 1) {
            if (extractorInput.getLength() != -1) {
                i = Ints.checkedCast(extractorInput.getLength());
            } else {
                i = 1024;
            }
            parsableByteArray.reset(i);
            this.f11749i = 0;
            this.f11750j = 2;
        }
        if (this.f11750j == 2) {
            int capacity = parsableByteArray.capacity();
            int i5 = this.f11749i;
            if (capacity == i5) {
                parsableByteArray.ensureCapacity(i5 + 1024);
            }
            int read = extractorInput.read(parsableByteArray.getData(), this.f11749i, parsableByteArray.capacity() - this.f11749i);
            if (read != -1) {
                this.f11749i += read;
            }
            long length = extractorInput.getLength();
            if ((length != -1 && this.f11749i == length) || read == -1) {
                SubtitleDecoder subtitleDecoder = this.f11741a;
                try {
                    SubtitleInputBuffer dequeueInputBuffer = subtitleDecoder.dequeueInputBuffer();
                    while (dequeueInputBuffer == null) {
                        Thread.sleep(5L);
                        dequeueInputBuffer = subtitleDecoder.dequeueInputBuffer();
                    }
                    dequeueInputBuffer.ensureSpaceForWrite(this.f11749i);
                    dequeueInputBuffer.data.put(parsableByteArray.getData(), 0, this.f11749i);
                    dequeueInputBuffer.data.limit(this.f11749i);
                    subtitleDecoder.queueInputBuffer(dequeueInputBuffer);
                    SubtitleOutputBuffer dequeueOutputBuffer = subtitleDecoder.dequeueOutputBuffer();
                    while (dequeueOutputBuffer == null) {
                        Thread.sleep(5L);
                        dequeueOutputBuffer = subtitleDecoder.dequeueOutputBuffer();
                    }
                    for (int i6 = 0; i6 < dequeueOutputBuffer.getEventTimeCount(); i6++) {
                        byte[] encode = this.f11742b.encode(dequeueOutputBuffer.getCues(dequeueOutputBuffer.getEventTime(i6)));
                        this.f11745e.add(Long.valueOf(dequeueOutputBuffer.getEventTime(i6)));
                        this.f11746f.add(new ParsableByteArray(encode));
                    }
                    dequeueOutputBuffer.release();
                    m2842a();
                    this.f11750j = 4;
                } catch (SubtitleDecoderException e) {
                    throw ParserException.createForMalformedContainer("SubtitleDecoder failed.", e);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException();
                }
            }
        }
        if (this.f11750j == 3) {
            if (extractorInput.getLength() != -1) {
                i4 = Ints.checkedCast(extractorInput.getLength());
            }
            if (extractorInput.skip(i4) == -1) {
                m2842a();
                this.f11750j = 4;
            }
        }
        if (this.f11750j != 4) {
            return 0;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        if (this.f11750j == 5) {
            return;
        }
        this.f11741a.release();
        this.f11750j = 5;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        boolean z;
        int i = this.f11750j;
        if (i != 0 && i != 5) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        this.f11751k = j2;
        if (this.f11750j == 2) {
            this.f11750j = 1;
        }
        if (this.f11750j == 4) {
            this.f11750j = 3;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) {
        return true;
    }
}
