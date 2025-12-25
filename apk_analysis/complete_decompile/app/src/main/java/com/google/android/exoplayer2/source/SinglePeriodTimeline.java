package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public final class SinglePeriodTimeline extends Timeline {

    /* renamed from: n */
    public static final Object f11058n = new Object();

    /* renamed from: o */
    public static final MediaItem f11059o = new MediaItem.Builder().setMediaId("SinglePeriodTimeline").setUri(Uri.EMPTY).build();

    /* renamed from: a */
    public final long f11060a;

    /* renamed from: b */
    public final long f11061b;

    /* renamed from: c */
    public final long f11062c;

    /* renamed from: d */
    public final long f11063d;

    /* renamed from: e */
    public final long f11064e;

    /* renamed from: f */
    public final long f11065f;

    /* renamed from: g */
    public final long f11066g;

    /* renamed from: h */
    public final boolean f11067h;

    /* renamed from: i */
    public final boolean f11068i;

    /* renamed from: j */
    public final boolean f11069j;

    /* renamed from: k */
    public final Object f11070k;

    /* renamed from: l */
    public final MediaItem f11071l;

    /* renamed from: m */
    public final MediaItem.LiveConfiguration f11072m;

    @Deprecated
    public SinglePeriodTimeline(long j, boolean z, boolean z2, boolean z3, @Nullable Object obj, @Nullable Object obj2) {
        this(j, j, 0L, 0L, z, z2, z3, obj, obj2);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getIndexOfPeriod(Object obj) {
        if (f11058n.equals(obj)) {
            return 0;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        Object obj;
        Assertions.checkIndex(i, 0, 1);
        if (z) {
            obj = f11058n;
        } else {
            obj = null;
        }
        return period.set(null, obj, 0, this.f11063d, -this.f11065f);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getPeriodCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Object getUidOfPeriod(int i) {
        Assertions.checkIndex(i, 0, 1);
        return f11058n;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r1 > r3) goto L10;
     */
    @Override // com.google.android.exoplayer2.Timeline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
        long j2;
        Assertions.checkIndex(i, 0, 1);
        long j3 = this.f11066g;
        boolean z = this.f11068i;
        if (z && !this.f11069j && j != 0) {
            long j4 = this.f11064e;
            if (j4 != C0643C.TIME_UNSET) {
                j3 += j;
            }
            j2 = -9223372036854775807L;
            return window.set(Timeline.Window.SINGLE_WINDOW_UID, this.f11071l, this.f11070k, this.f11060a, this.f11061b, this.f11062c, this.f11067h, z, this.f11072m, j2, this.f11064e, 0, 0, this.f11065f);
        }
        j2 = j3;
        return window.set(Timeline.Window.SINGLE_WINDOW_UID, this.f11071l, this.f11070k, this.f11060a, this.f11061b, this.f11062c, this.f11067h, z, this.f11072m, j2, this.f11064e, 0, 0, this.f11065f);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int getWindowCount() {
        return 1;
    }

    public SinglePeriodTimeline(long j, boolean z, boolean z2, boolean z3, @Nullable Object obj, MediaItem mediaItem) {
        this(j, j, 0L, 0L, z, z2, z3, obj, mediaItem);
    }

    @Deprecated
    public SinglePeriodTimeline(long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, @Nullable Object obj, @Nullable Object obj2) {
        this(C0643C.TIME_UNSET, C0643C.TIME_UNSET, C0643C.TIME_UNSET, j, j2, j3, j4, z, z2, z3, obj, obj2);
    }

    public SinglePeriodTimeline(long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, @Nullable Object obj, MediaItem mediaItem) {
        this(C0643C.TIME_UNSET, C0643C.TIME_UNSET, C0643C.TIME_UNSET, j, j2, j3, j4, z, z2, false, obj, mediaItem, z3 ? mediaItem.liveConfiguration : null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SinglePeriodTimeline(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, @Nullable Object obj, @Nullable Object obj2) {
        this(j, j2, j3, j4, j5, j6, j7, z, z2, false, obj, r0.buildUpon().setTag(obj2).build(), z3 ? r0.liveConfiguration : null);
        MediaItem mediaItem = f11059o;
    }

    @Deprecated
    public SinglePeriodTimeline(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, @Nullable Object obj, MediaItem mediaItem, @Nullable MediaItem.LiveConfiguration liveConfiguration) {
        this(j, j2, j3, j4, j5, j6, j7, z, z2, false, obj, mediaItem, liveConfiguration);
    }

    public SinglePeriodTimeline(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, @Nullable Object obj, MediaItem mediaItem, @Nullable MediaItem.LiveConfiguration liveConfiguration) {
        this.f11060a = j;
        this.f11061b = j2;
        this.f11062c = j3;
        this.f11063d = j4;
        this.f11064e = j5;
        this.f11065f = j6;
        this.f11066g = j7;
        this.f11067h = z;
        this.f11068i = z2;
        this.f11069j = z3;
        this.f11070k = obj;
        this.f11071l = (MediaItem) Assertions.checkNotNull(mediaItem);
        this.f11072m = liveConfiguration;
    }
}
