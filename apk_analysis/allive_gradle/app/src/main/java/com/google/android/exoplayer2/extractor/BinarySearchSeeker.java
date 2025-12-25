package com.google.android.exoplayer2.extractor;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
public abstract class BinarySearchSeeker {

    /* renamed from: a */
    public final int f10037a;
    protected final BinarySearchSeekMap seekMap;

    @Nullable
    protected SeekOperationParams seekOperationParams;
    protected final TimestampSeeker timestampSeeker;

    /* loaded from: classes.dex */
    public static class BinarySearchSeekMap implements SeekMap {

        /* renamed from: a */
        public final SeekTimestampConverter f10038a;

        /* renamed from: b */
        public final long f10039b;

        /* renamed from: c */
        public final long f10040c;

        /* renamed from: d */
        public final long f10041d;

        /* renamed from: e */
        public final long f10042e;

        /* renamed from: f */
        public final long f10043f;

        /* renamed from: g */
        public final long f10044g;

        public BinarySearchSeekMap(SeekTimestampConverter seekTimestampConverter, long j, long j2, long j3, long j4, long j5, long j6) {
            this.f10038a = seekTimestampConverter;
            this.f10039b = j;
            this.f10040c = j2;
            this.f10041d = j3;
            this.f10042e = j4;
            this.f10043f = j5;
            this.f10044g = j6;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.f10039b;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekMap.SeekPoints getSeekPoints(long j) {
            return new SeekMap.SeekPoints(new SeekPoint(j, SeekOperationParams.calculateNextSearchBytePosition(this.f10038a.timeUsToTargetTime(j), this.f10040c, this.f10041d, this.f10042e, this.f10043f, this.f10044g)));
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }

        public long timeUsToTargetTime(long j) {
            return this.f10038a.timeUsToTargetTime(j);
        }
    }

    /* loaded from: classes.dex */
    public static final class DefaultSeekTimestampConverter implements SeekTimestampConverter {
        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter
        public long timeUsToTargetTime(long j) {
            return j;
        }
    }

    /* loaded from: classes.dex */
    public static class SeekOperationParams {

        /* renamed from: a */
        public final long f10045a;

        /* renamed from: b */
        public final long f10046b;

        /* renamed from: c */
        public final long f10047c;

        /* renamed from: d */
        public long f10048d;

        /* renamed from: e */
        public long f10049e;

        /* renamed from: f */
        public long f10050f;

        /* renamed from: g */
        public long f10051g;

        /* renamed from: h */
        public long f10052h;

        public SeekOperationParams(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.f10045a = j;
            this.f10046b = j2;
            this.f10048d = j3;
            this.f10049e = j4;
            this.f10050f = j5;
            this.f10051g = j6;
            this.f10047c = j7;
            this.f10052h = calculateNextSearchBytePosition(j2, j3, j4, j5, j6, j7);
        }

        public static long calculateNextSearchBytePosition(long j, long j2, long j3, long j4, long j5, long j6) {
            if (j4 + 1 < j5 && j2 + 1 < j3) {
                long j7 = ((float) (j - j2)) * (((float) (j5 - j4)) / ((float) (j3 - j2)));
                return Util.constrainValue(((j7 + j4) - j6) - (j7 / 20), j4, j5 - 1);
            }
            return j4;
        }
    }

    /* loaded from: classes.dex */
    public interface SeekTimestampConverter {
        long timeUsToTargetTime(long j);
    }

    /* loaded from: classes.dex */
    public static final class TimestampSearchResult {
        public static final TimestampSearchResult NO_TIMESTAMP_IN_RANGE_RESULT = new TimestampSearchResult(-3, C0643C.TIME_UNSET, -1);
        public static final int TYPE_NO_TIMESTAMP = -3;
        public static final int TYPE_POSITION_OVERESTIMATED = -1;
        public static final int TYPE_POSITION_UNDERESTIMATED = -2;
        public static final int TYPE_TARGET_TIMESTAMP_FOUND = 0;

        /* renamed from: a */
        public final int f10053a;

        /* renamed from: b */
        public final long f10054b;

        /* renamed from: c */
        public final long f10055c;

        public TimestampSearchResult(int i, long j, long j2) {
            this.f10053a = i;
            this.f10054b = j;
            this.f10055c = j2;
        }

        public static TimestampSearchResult overestimatedResult(long j, long j2) {
            return new TimestampSearchResult(-1, j, j2);
        }

        public static TimestampSearchResult targetFoundResult(long j) {
            return new TimestampSearchResult(0, C0643C.TIME_UNSET, j);
        }

        public static TimestampSearchResult underestimatedResult(long j, long j2) {
            return new TimestampSearchResult(-2, j, j2);
        }
    }

    /* loaded from: classes.dex */
    public interface TimestampSeeker {
        void onSeekFinished();

        TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long j);
    }

    public BinarySearchSeeker(SeekTimestampConverter seekTimestampConverter, TimestampSeeker timestampSeeker, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.timestampSeeker = timestampSeeker;
        this.f10037a = i;
        this.seekMap = new BinarySearchSeekMap(seekTimestampConverter, j, j2, j3, j4, j5, j6);
    }

    public SeekOperationParams createSeekParamsForTargetTimeUs(long j) {
        long timeUsToTargetTime = this.seekMap.timeUsToTargetTime(j);
        BinarySearchSeekMap binarySearchSeekMap = this.seekMap;
        return new SeekOperationParams(j, timeUsToTargetTime, binarySearchSeekMap.f10040c, binarySearchSeekMap.f10041d, binarySearchSeekMap.f10042e, binarySearchSeekMap.f10043f, binarySearchSeekMap.f10044g);
    }

    public final SeekMap getSeekMap() {
        return this.seekMap;
    }

    public int handlePendingSeek(ExtractorInput extractorInput, PositionHolder positionHolder) {
        while (true) {
            SeekOperationParams seekOperationParams = (SeekOperationParams) Assertions.checkStateNotNull(this.seekOperationParams);
            long j = seekOperationParams.f10050f;
            long j2 = seekOperationParams.f10051g;
            long j3 = seekOperationParams.f10052h;
            if (j2 - j <= this.f10037a) {
                markSeekOperationFinished(false, j);
                return seekToPosition(extractorInput, j, positionHolder);
            }
            if (!skipInputUntilPosition(extractorInput, j3)) {
                return seekToPosition(extractorInput, j3, positionHolder);
            }
            extractorInput.resetPeekPosition();
            TimestampSearchResult searchForTimestamp = this.timestampSeeker.searchForTimestamp(extractorInput, seekOperationParams.f10046b);
            int i = searchForTimestamp.f10053a;
            if (i != -3) {
                long j4 = searchForTimestamp.f10054b;
                long j5 = searchForTimestamp.f10055c;
                if (i != -2) {
                    if (i != -1) {
                        if (i == 0) {
                            skipInputUntilPosition(extractorInput, j5);
                            markSeekOperationFinished(true, j5);
                            return seekToPosition(extractorInput, j5, positionHolder);
                        }
                        throw new IllegalStateException("Invalid case");
                    }
                    seekOperationParams.f10049e = j4;
                    seekOperationParams.f10051g = j5;
                    seekOperationParams.f10052h = SeekOperationParams.calculateNextSearchBytePosition(seekOperationParams.f10046b, seekOperationParams.f10048d, j4, seekOperationParams.f10050f, j5, seekOperationParams.f10047c);
                } else {
                    seekOperationParams.f10048d = j4;
                    seekOperationParams.f10050f = j5;
                    seekOperationParams.f10052h = SeekOperationParams.calculateNextSearchBytePosition(seekOperationParams.f10046b, j4, seekOperationParams.f10049e, j5, seekOperationParams.f10051g, seekOperationParams.f10047c);
                }
            } else {
                markSeekOperationFinished(false, j3);
                return seekToPosition(extractorInput, j3, positionHolder);
            }
        }
    }

    public final boolean isSeeking() {
        if (this.seekOperationParams != null) {
            return true;
        }
        return false;
    }

    public final void markSeekOperationFinished(boolean z, long j) {
        this.seekOperationParams = null;
        this.timestampSeeker.onSeekFinished();
        onSeekOperationFinished(z, j);
    }

    public void onSeekOperationFinished(boolean z, long j) {
    }

    public final int seekToPosition(ExtractorInput extractorInput, long j, PositionHolder positionHolder) {
        if (j == extractorInput.getPosition()) {
            return 0;
        }
        positionHolder.position = j;
        return 1;
    }

    public final void setSeekTargetUs(long j) {
        SeekOperationParams seekOperationParams = this.seekOperationParams;
        if (seekOperationParams != null && seekOperationParams.f10045a == j) {
            return;
        }
        this.seekOperationParams = createSeekParamsForTargetTimeUs(j);
    }

    public final boolean skipInputUntilPosition(ExtractorInput extractorInput, long j) {
        long position = j - extractorInput.getPosition();
        if (position >= 0 && position <= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            extractorInput.skipFully((int) position);
            return true;
        }
        return false;
    }
}
