package p000;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* renamed from: ul */
/* loaded from: classes.dex */
public abstract class AbstractC1876ul implements SubtitleDecoder {

    /* renamed from: a */
    public final ArrayDeque f27307a = new ArrayDeque();

    /* renamed from: b */
    public final ArrayDeque f27308b;

    /* renamed from: c */
    public final PriorityQueue f27309c;

    /* renamed from: d */
    public C1802sl f27310d;

    /* renamed from: e */
    public long f27311e;

    /* renamed from: f */
    public long f27312f;

    /* JADX WARN: Type inference failed for: r2v1, types: [tl, java.lang.Object, com.google.android.exoplayer2.text.SubtitleOutputBuffer] */
    public AbstractC1876ul() {
        for (int i = 0; i < 10; i++) {
            this.f27307a.add(new SubtitleInputBuffer());
        }
        this.f27308b = new ArrayDeque();
        for (int i2 = 0; i2 < 2; i2++) {
            ArrayDeque arrayDeque = this.f27308b;
            C1294i5 c1294i5 = new C1294i5(3, this);
            ?? subtitleOutputBuffer = new SubtitleOutputBuffer();
            subtitleOutputBuffer.f26863d = c1294i5;
            arrayDeque.add(subtitleOutputBuffer);
        }
        this.f27309c = new PriorityQueue();
    }

    public abstract Subtitle createSubtitle();

    public abstract void decode(SubtitleInputBuffer subtitleInputBuffer);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public abstract SubtitleInputBuffer dequeueInputBuffer();

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        ArrayDeque arrayDeque;
        this.f27312f = 0L;
        this.f27311e = 0L;
        while (true) {
            PriorityQueue priorityQueue = this.f27309c;
            boolean isEmpty = priorityQueue.isEmpty();
            arrayDeque = this.f27307a;
            if (isEmpty) {
                break;
            }
            C1802sl c1802sl = (C1802sl) Util.castNonNull((C1802sl) priorityQueue.poll());
            c1802sl.clear();
            arrayDeque.add(c1802sl);
        }
        C1802sl c1802sl2 = this.f27310d;
        if (c1802sl2 != null) {
            c1802sl2.clear();
            arrayDeque.add(c1802sl2);
            this.f27310d = null;
        }
    }

    @Nullable
    public final SubtitleOutputBuffer getAvailableOutputBuffer() {
        return (SubtitleOutputBuffer) this.f27308b.pollFirst();
    }

    public final long getPositionUs() {
        return this.f27311e;
    }

    public abstract boolean isNewSubtitleDataAvailable();

    public void releaseOutputBuffer(SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.clear();
        this.f27308b.add(subtitleOutputBuffer);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0083, code lost:
    
        return null;
     */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SubtitleOutputBuffer dequeueOutputBuffer() {
        ArrayDeque arrayDeque = this.f27308b;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        while (true) {
            PriorityQueue priorityQueue = this.f27309c;
            if (priorityQueue.isEmpty() || ((C1802sl) Util.castNonNull((C1802sl) priorityQueue.peek())).timeUs > this.f27311e) {
                break;
            }
            C1802sl c1802sl = (C1802sl) Util.castNonNull((C1802sl) priorityQueue.poll());
            boolean isEndOfStream = c1802sl.isEndOfStream();
            ArrayDeque arrayDeque2 = this.f27307a;
            if (isEndOfStream) {
                SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) Util.castNonNull((SubtitleOutputBuffer) arrayDeque.pollFirst());
                subtitleOutputBuffer.addFlag(4);
                c1802sl.clear();
                arrayDeque2.add(c1802sl);
                return subtitleOutputBuffer;
            }
            decode(c1802sl);
            if (isNewSubtitleDataAvailable()) {
                Subtitle createSubtitle = createSubtitle();
                SubtitleOutputBuffer subtitleOutputBuffer2 = (SubtitleOutputBuffer) Util.castNonNull((SubtitleOutputBuffer) arrayDeque.pollFirst());
                subtitleOutputBuffer2.setContent(c1802sl.timeUs, createSubtitle, Long.MAX_VALUE);
                c1802sl.clear();
                arrayDeque2.add(c1802sl);
                return subtitleOutputBuffer2;
            }
            c1802sl.clear();
            arrayDeque2.add(c1802sl);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) {
        Assertions.checkArgument(subtitleInputBuffer == this.f27310d);
        C1802sl c1802sl = (C1802sl) subtitleInputBuffer;
        if (c1802sl.isDecodeOnly()) {
            c1802sl.clear();
            this.f27307a.add(c1802sl);
        } else {
            long j = this.f27312f;
            this.f27312f = 1 + j;
            c1802sl.f26469d = j;
            this.f27309c.add(c1802sl);
        }
        this.f27310d = null;
    }
}
