package com.google.android.exoplayer2;

import android.os.Handler;
import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableList;
import p000.RunnableC0547b7;
import p000.ul1;
import p000.vl1;

/* renamed from: com.google.android.exoplayer2.h */
/* loaded from: classes.dex */
public final class C0674h {

    /* renamed from: a */
    public final Timeline.Period f10634a = new Timeline.Period();

    /* renamed from: b */
    public final Timeline.Window f10635b = new Timeline.Window();

    /* renamed from: c */
    public final AnalyticsCollector f10636c;

    /* renamed from: d */
    public final Handler f10637d;

    /* renamed from: e */
    public long f10638e;

    /* renamed from: f */
    public int f10639f;

    /* renamed from: g */
    public boolean f10640g;

    /* renamed from: h */
    public ul1 f10641h;

    /* renamed from: i */
    public ul1 f10642i;

    /* renamed from: j */
    public ul1 f10643j;

    /* renamed from: k */
    public int f10644k;

    /* renamed from: l */
    public Object f10645l;

    /* renamed from: m */
    public long f10646m;

    public C0674h(AnalyticsCollector analyticsCollector, Handler handler) {
        this.f10636c = analyticsCollector;
        this.f10637d = handler;
    }

    /* renamed from: l */
    public static MediaSource.MediaPeriodId m2629l(Timeline timeline, Object obj, long j, long j2, Timeline.Window window, Timeline.Period period) {
        timeline.getPeriodByUid(obj, period);
        timeline.getWindow(period.windowIndex, window);
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        Object obj2 = obj;
        while (period.durationUs == 0 && period.getAdGroupCount() > 0 && period.isServerSideInsertedAdGroup(period.getRemovedAdGroupCount()) && period.getAdGroupIndexForPositionUs(0L) == -1) {
            int i = indexOfPeriod + 1;
            if (indexOfPeriod >= window.lastPeriodIndex) {
                break;
            }
            timeline.getPeriod(i, period, true);
            obj2 = Assertions.checkNotNull(period.uid);
            indexOfPeriod = i;
        }
        timeline.getPeriodByUid(obj2, period);
        int adGroupIndexForPositionUs = period.getAdGroupIndexForPositionUs(j);
        if (adGroupIndexForPositionUs == -1) {
            return new MediaSource.MediaPeriodId(obj2, j2, period.getAdGroupIndexAfterPositionUs(j));
        }
        return new MediaSource.MediaPeriodId(obj2, adGroupIndexForPositionUs, period.getFirstAdIndexToPlay(adGroupIndexForPositionUs), j2);
    }

    /* renamed from: a */
    public final ul1 m2630a() {
        ul1 ul1Var = this.f10641h;
        if (ul1Var == null) {
            return null;
        }
        if (ul1Var == this.f10642i) {
            this.f10642i = ul1Var.f27332l;
        }
        ul1Var.m7743f();
        int i = this.f10644k - 1;
        this.f10644k = i;
        if (i == 0) {
            this.f10643j = null;
            ul1 ul1Var2 = this.f10641h;
            this.f10645l = ul1Var2.f27322b;
            this.f10646m = ul1Var2.f27326f.f27854a.windowSequenceNumber;
        }
        this.f10641h = this.f10641h.f27332l;
        m2639j();
        return this.f10641h;
    }

    /* renamed from: b */
    public final void m2631b() {
        if (this.f10644k == 0) {
            return;
        }
        ul1 ul1Var = (ul1) Assertions.checkStateNotNull(this.f10641h);
        this.f10645l = ul1Var.f27322b;
        this.f10646m = ul1Var.f27326f.f27854a.windowSequenceNumber;
        while (ul1Var != null) {
            ul1Var.m7743f();
            ul1Var = ul1Var.f27332l;
        }
        this.f10641h = null;
        this.f10643j = null;
        this.f10642i = null;
        this.f10644k = 0;
        m2639j();
    }

    /* renamed from: c */
    public final vl1 m2632c(Timeline timeline, ul1 ul1Var, long j) {
        boolean z;
        long contentResumeOffsetUs;
        long j2;
        long contentResumeOffsetUs2;
        long j3;
        long j4;
        long j5;
        boolean z2;
        long j6;
        vl1 vl1Var = ul1Var.f27326f;
        long j7 = (ul1Var.f27335o + vl1Var.f27858e) - j;
        Timeline.Period period = this.f10634a;
        boolean z3 = vl1Var.f27860g;
        long j8 = vl1Var.f27856c;
        MediaSource.MediaPeriodId mediaPeriodId = vl1Var.f27854a;
        if (z3) {
            int nextPeriodIndex = timeline.getNextPeriodIndex(timeline.getIndexOfPeriod(mediaPeriodId.periodUid), this.f10634a, this.f10635b, this.f10639f, this.f10640g);
            if (nextPeriodIndex == -1) {
                return null;
            }
            int i = timeline.getPeriod(nextPeriodIndex, period, true).windowIndex;
            Object checkNotNull = Assertions.checkNotNull(period.uid);
            long j9 = mediaPeriodId.windowSequenceNumber;
            long j10 = 0;
            if (timeline.getWindow(i, this.f10635b).firstPeriodIndex == nextPeriodIndex) {
                Pair<Object, Long> periodPositionUs = timeline.getPeriodPositionUs(this.f10635b, this.f10634a, i, C0643C.TIME_UNSET, Math.max(0L, j7));
                if (periodPositionUs == null) {
                    return null;
                }
                checkNotNull = periodPositionUs.first;
                long longValue = ((Long) periodPositionUs.second).longValue();
                ul1 ul1Var2 = ul1Var.f27332l;
                if (ul1Var2 != null && ul1Var2.f27322b.equals(checkNotNull)) {
                    j6 = ul1Var2.f27326f.f27854a.windowSequenceNumber;
                } else {
                    j6 = this.f10638e;
                    this.f10638e = 1 + j6;
                }
                j10 = longValue;
                j3 = -9223372036854775807L;
                j9 = j6;
            } else {
                j3 = 0;
            }
            MediaSource.MediaPeriodId m2629l = m2629l(timeline, checkNotNull, j10, j9, this.f10635b, this.f10634a);
            if (j3 != C0643C.TIME_UNSET && j8 != C0643C.TIME_UNSET) {
                if (timeline.getPeriodByUid(mediaPeriodId.periodUid, period).getAdGroupCount() > 0 && period.isServerSideInsertedAdGroup(period.getRemovedAdGroupCount())) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (m2629l.isAd() && z2) {
                    j5 = j10;
                    j4 = j8;
                } else if (z2) {
                    j4 = j3;
                    j5 = j8;
                }
                return m2633d(timeline, m2629l, j4, j5);
            }
            j4 = j3;
            j5 = j10;
            return m2633d(timeline, m2629l, j4, j5);
        }
        timeline.getPeriodByUid(mediaPeriodId.periodUid, period);
        if (mediaPeriodId.isAd()) {
            int i2 = mediaPeriodId.adGroupIndex;
            int adCountInAdGroup = period.getAdCountInAdGroup(i2);
            if (adCountInAdGroup == -1) {
                return null;
            }
            int nextAdIndexToPlay = period.getNextAdIndexToPlay(i2, mediaPeriodId.adIndexInAdGroup);
            if (nextAdIndexToPlay < adCountInAdGroup) {
                return m2634e(timeline, mediaPeriodId.periodUid, i2, nextAdIndexToPlay, vl1Var.f27856c, mediaPeriodId.windowSequenceNumber);
            }
            if (j8 == C0643C.TIME_UNSET) {
                Pair<Object, Long> periodPositionUs2 = timeline.getPeriodPositionUs(this.f10635b, period, period.windowIndex, C0643C.TIME_UNSET, Math.max(0L, j7));
                if (periodPositionUs2 == null) {
                    return null;
                }
                j2 = ((Long) periodPositionUs2.second).longValue();
            } else {
                j2 = j8;
            }
            Object obj = mediaPeriodId.periodUid;
            int i3 = mediaPeriodId.adGroupIndex;
            timeline.getPeriodByUid(obj, period);
            long adGroupTimeUs = period.getAdGroupTimeUs(i3);
            if (adGroupTimeUs == Long.MIN_VALUE) {
                contentResumeOffsetUs2 = period.durationUs;
            } else {
                contentResumeOffsetUs2 = period.getContentResumeOffsetUs(i3) + adGroupTimeUs;
            }
            return m2635f(timeline, mediaPeriodId.periodUid, Math.max(contentResumeOffsetUs2, j2), vl1Var.f27856c, mediaPeriodId.windowSequenceNumber);
        }
        int firstAdIndexToPlay = period.getFirstAdIndexToPlay(mediaPeriodId.nextAdGroupIndex);
        if (period.isServerSideInsertedAdGroup(mediaPeriodId.nextAdGroupIndex) && period.getAdState(mediaPeriodId.nextAdGroupIndex, firstAdIndexToPlay) == 3) {
            z = true;
        } else {
            z = false;
        }
        if (firstAdIndexToPlay != period.getAdCountInAdGroup(mediaPeriodId.nextAdGroupIndex) && !z) {
            return m2634e(timeline, mediaPeriodId.periodUid, mediaPeriodId.nextAdGroupIndex, firstAdIndexToPlay, vl1Var.f27858e, mediaPeriodId.windowSequenceNumber);
        }
        Object obj2 = mediaPeriodId.periodUid;
        int i4 = mediaPeriodId.nextAdGroupIndex;
        timeline.getPeriodByUid(obj2, period);
        long adGroupTimeUs2 = period.getAdGroupTimeUs(i4);
        if (adGroupTimeUs2 == Long.MIN_VALUE) {
            contentResumeOffsetUs = period.durationUs;
        } else {
            contentResumeOffsetUs = period.getContentResumeOffsetUs(i4) + adGroupTimeUs2;
        }
        return m2635f(timeline, mediaPeriodId.periodUid, contentResumeOffsetUs, vl1Var.f27858e, mediaPeriodId.windowSequenceNumber);
    }

    /* renamed from: d */
    public final vl1 m2633d(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j, long j2) {
        timeline.getPeriodByUid(mediaPeriodId.periodUid, this.f10634a);
        if (mediaPeriodId.isAd()) {
            return m2634e(timeline, mediaPeriodId.periodUid, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, j, mediaPeriodId.windowSequenceNumber);
        }
        return m2635f(timeline, mediaPeriodId.periodUid, j2, j, mediaPeriodId.windowSequenceNumber);
    }

    /* renamed from: e */
    public final vl1 m2634e(Timeline timeline, Object obj, int i, int i2, long j, long j2) {
        long j3;
        long j4;
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj, i, i2, j2);
        Object obj2 = mediaPeriodId.periodUid;
        Timeline.Period period = this.f10634a;
        long adDurationUs = timeline.getPeriodByUid(obj2, period).getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        if (i2 == period.getFirstAdIndexToPlay(i)) {
            j3 = period.getAdResumePositionUs();
        } else {
            j3 = 0;
        }
        boolean isServerSideInsertedAdGroup = period.isServerSideInsertedAdGroup(mediaPeriodId.adGroupIndex);
        if (adDurationUs != C0643C.TIME_UNSET && j3 >= adDurationUs) {
            j4 = Math.max(0L, adDurationUs - 1);
        } else {
            j4 = j3;
        }
        return new vl1(mediaPeriodId, j4, j, C0643C.TIME_UNSET, adDurationUs, isServerSideInsertedAdGroup, false, false, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0022, code lost:
    
        if (r5.isServerSideInsertedAdGroup(r5.getRemovedAdGroupCount()) != false) goto L16;
     */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final vl1 m2635f(Timeline timeline, Object obj, long j, long j2, long j3) {
        boolean z;
        boolean z2;
        boolean z3;
        long j4;
        long j5;
        int i;
        long j6 = j;
        Timeline.Period period = this.f10634a;
        timeline.getPeriodByUid(obj, period);
        int adGroupIndexAfterPositionUs = period.getAdGroupIndexAfterPositionUs(j6);
        if (adGroupIndexAfterPositionUs == -1) {
            if (period.getAdGroupCount() > 0) {
            }
            z = false;
        } else {
            if (period.isServerSideInsertedAdGroup(adGroupIndexAfterPositionUs) && period.getAdGroupTimeUs(adGroupIndexAfterPositionUs) == period.durationUs && period.hasPlayedAdGroup(adGroupIndexAfterPositionUs)) {
                adGroupIndexAfterPositionUs = -1;
                z = true;
            }
            z = false;
        }
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj, j3, adGroupIndexAfterPositionUs);
        if (!mediaPeriodId.isAd() && mediaPeriodId.nextAdGroupIndex == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean m2638i = m2638i(timeline, mediaPeriodId);
        boolean m2637h = m2637h(timeline, mediaPeriodId, z2);
        if (adGroupIndexAfterPositionUs != -1 && period.isServerSideInsertedAdGroup(adGroupIndexAfterPositionUs)) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (adGroupIndexAfterPositionUs != -1) {
            j4 = period.getAdGroupTimeUs(adGroupIndexAfterPositionUs);
        } else if (z) {
            j4 = period.durationUs;
        } else {
            j4 = -9223372036854775807L;
        }
        if (j4 != C0643C.TIME_UNSET && j4 != Long.MIN_VALUE) {
            j5 = j4;
        } else {
            j5 = period.durationUs;
        }
        if (j5 != C0643C.TIME_UNSET && j6 >= j5) {
            if (!m2637h && z) {
                i = 0;
            } else {
                i = 1;
            }
            j6 = Math.max(0L, j5 - i);
        }
        return new vl1(mediaPeriodId, j6, j2, j4, j5, z3, z2, m2638i, m2637h);
    }

    /* renamed from: g */
    public final vl1 m2636g(Timeline timeline, vl1 vl1Var) {
        boolean z;
        long j;
        long durationUs;
        boolean z2;
        int i;
        MediaSource.MediaPeriodId mediaPeriodId = vl1Var.f27854a;
        if (!mediaPeriodId.isAd() && mediaPeriodId.nextAdGroupIndex == -1) {
            z = true;
        } else {
            z = false;
        }
        boolean m2638i = m2638i(timeline, mediaPeriodId);
        boolean m2637h = m2637h(timeline, mediaPeriodId, z);
        Object obj = mediaPeriodId.periodUid;
        Timeline.Period period = this.f10634a;
        timeline.getPeriodByUid(obj, period);
        if (!mediaPeriodId.isAd() && (i = mediaPeriodId.nextAdGroupIndex) != -1) {
            j = period.getAdGroupTimeUs(i);
        } else {
            j = -9223372036854775807L;
        }
        if (mediaPeriodId.isAd()) {
            durationUs = period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        } else if (j != C0643C.TIME_UNSET && j != Long.MIN_VALUE) {
            durationUs = j;
        } else {
            durationUs = period.getDurationUs();
        }
        if (mediaPeriodId.isAd()) {
            z2 = period.isServerSideInsertedAdGroup(mediaPeriodId.adGroupIndex);
        } else {
            int i2 = mediaPeriodId.nextAdGroupIndex;
            if (i2 != -1 && period.isServerSideInsertedAdGroup(i2)) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return new vl1(mediaPeriodId, vl1Var.f27855b, vl1Var.f27856c, j, durationUs, z2, z, m2638i, m2637h);
    }

    /* renamed from: h */
    public final boolean m2637h(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, boolean z) {
        int indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
        if (!timeline.getWindow(timeline.getPeriod(indexOfPeriod, this.f10634a).windowIndex, this.f10635b).isDynamic) {
            if (timeline.isLastPeriod(indexOfPeriod, this.f10634a, this.f10635b, this.f10639f, this.f10640g) && z) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    public final boolean m2638i(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        boolean z;
        if (!mediaPeriodId.isAd() && mediaPeriodId.nextAdGroupIndex == -1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        if (timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.f10634a).windowIndex, this.f10635b).lastPeriodIndex != timeline.getIndexOfPeriod(mediaPeriodId.periodUid)) {
            return false;
        }
        return true;
    }

    /* renamed from: j */
    public final void m2639j() {
        MediaSource.MediaPeriodId mediaPeriodId;
        ImmutableList.Builder builder = ImmutableList.builder();
        for (ul1 ul1Var = this.f10641h; ul1Var != null; ul1Var = ul1Var.f27332l) {
            builder.add((ImmutableList.Builder) ul1Var.f27326f.f27854a);
        }
        ul1 ul1Var2 = this.f10642i;
        if (ul1Var2 == null) {
            mediaPeriodId = null;
        } else {
            mediaPeriodId = ul1Var2.f27326f.f27854a;
        }
        this.f10637d.post(new RunnableC0547b7(this, builder, mediaPeriodId));
    }

    /* renamed from: k */
    public final boolean m2640k(ul1 ul1Var) {
        boolean z;
        boolean z2 = false;
        if (ul1Var != null) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        if (ul1Var.equals(this.f10643j)) {
            return false;
        }
        this.f10643j = ul1Var;
        while (true) {
            ul1Var = ul1Var.f27332l;
            if (ul1Var == null) {
                break;
            }
            if (ul1Var == this.f10642i) {
                this.f10642i = this.f10641h;
                z2 = true;
            }
            ul1Var.m7743f();
            this.f10644k--;
        }
        ul1 ul1Var2 = this.f10643j;
        if (ul1Var2.f27332l != null) {
            ul1Var2.m7739b();
            ul1Var2.f27332l = null;
            ul1Var2.m7740c();
        }
        m2639j();
        return z2;
    }

    /* renamed from: m */
    public final MediaSource.MediaPeriodId m2641m(Timeline timeline, Object obj, long j) {
        long j2;
        int indexOfPeriod;
        Object obj2 = obj;
        Timeline.Period period = this.f10634a;
        int i = timeline.getPeriodByUid(obj2, period).windowIndex;
        Object obj3 = this.f10645l;
        if (obj3 != null && (indexOfPeriod = timeline.getIndexOfPeriod(obj3)) != -1 && timeline.getPeriod(indexOfPeriod, period).windowIndex == i) {
            j2 = this.f10646m;
        } else {
            ul1 ul1Var = this.f10641h;
            while (true) {
                if (ul1Var != null) {
                    if (ul1Var.f27322b.equals(obj2)) {
                        j2 = ul1Var.f27326f.f27854a.windowSequenceNumber;
                        break;
                    }
                    ul1Var = ul1Var.f27332l;
                } else {
                    ul1 ul1Var2 = this.f10641h;
                    while (true) {
                        if (ul1Var2 != null) {
                            int indexOfPeriod2 = timeline.getIndexOfPeriod(ul1Var2.f27322b);
                            if (indexOfPeriod2 != -1 && timeline.getPeriod(indexOfPeriod2, period).windowIndex == i) {
                                j2 = ul1Var2.f27326f.f27854a.windowSequenceNumber;
                                break;
                            }
                            ul1Var2 = ul1Var2.f27332l;
                        } else {
                            j2 = this.f10638e;
                            this.f10638e = 1 + j2;
                            if (this.f10641h == null) {
                                this.f10645l = obj2;
                                this.f10646m = j2;
                            }
                        }
                    }
                }
            }
        }
        long j3 = j2;
        timeline.getPeriodByUid(obj2, period);
        int i2 = period.windowIndex;
        Timeline.Window window = this.f10635b;
        timeline.getWindow(i2, window);
        boolean z = false;
        for (int indexOfPeriod3 = timeline.getIndexOfPeriod(obj); indexOfPeriod3 >= window.firstPeriodIndex; indexOfPeriod3--) {
            boolean z2 = true;
            timeline.getPeriod(indexOfPeriod3, period, true);
            if (period.getAdGroupCount() <= 0) {
                z2 = false;
            }
            z |= z2;
            if (period.getAdGroupIndexForPositionUs(period.durationUs) != -1) {
                obj2 = Assertions.checkNotNull(period.uid);
            }
            if (z && (!z2 || period.durationUs != 0)) {
                break;
            }
        }
        return m2629l(timeline, obj2, j, j3, this.f10635b, this.f10634a);
    }

    /* renamed from: n */
    public final boolean m2642n(Timeline timeline) {
        ul1 ul1Var;
        ul1 ul1Var2 = this.f10641h;
        if (ul1Var2 == null) {
            return true;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(ul1Var2.f27322b);
        while (true) {
            indexOfPeriod = timeline.getNextPeriodIndex(indexOfPeriod, this.f10634a, this.f10635b, this.f10639f, this.f10640g);
            while (true) {
                ul1Var = ul1Var2.f27332l;
                if (ul1Var == null || ul1Var2.f27326f.f27860g) {
                    break;
                }
                ul1Var2 = ul1Var;
            }
            if (indexOfPeriod == -1 || ul1Var == null || timeline.getIndexOfPeriod(ul1Var.f27322b) != indexOfPeriod) {
                break;
            }
            ul1Var2 = ul1Var;
        }
        boolean m2640k = m2640k(ul1Var2);
        ul1Var2.f27326f = m2636g(timeline, ul1Var2.f27326f);
        return !m2640k;
    }

    /* renamed from: o */
    public final boolean m2643o(Timeline timeline, long j, long j2) {
        vl1 vl1Var;
        long j3;
        boolean z;
        ul1 ul1Var = null;
        for (ul1 ul1Var2 = this.f10641h; ul1Var2 != null; ul1Var2 = ul1Var2.f27332l) {
            vl1 vl1Var2 = ul1Var2.f27326f;
            if (ul1Var == null) {
                vl1Var = m2636g(timeline, vl1Var2);
            } else {
                vl1 m2632c = m2632c(timeline, ul1Var, j);
                if (m2632c == null) {
                    return !m2640k(ul1Var);
                }
                if (vl1Var2.f27855b == m2632c.f27855b && vl1Var2.f27854a.equals(m2632c.f27854a)) {
                    vl1Var = m2632c;
                } else {
                    return !m2640k(ul1Var);
                }
            }
            ul1Var2.f27326f = vl1Var.m7923a(vl1Var2.f27856c);
            long j4 = vl1Var2.f27858e;
            if (j4 != C0643C.TIME_UNSET) {
                long j5 = vl1Var.f27858e;
                if (j4 != j5) {
                    ul1Var2.m7745h();
                    if (j5 == C0643C.TIME_UNSET) {
                        j3 = Long.MAX_VALUE;
                    } else {
                        j3 = ul1Var2.f27335o + j5;
                    }
                    if (ul1Var2 == this.f10642i && !ul1Var2.f27326f.f27859f && (j2 == Long.MIN_VALUE || j2 >= j3)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!m2640k(ul1Var2) && !z) {
                        return true;
                    }
                    return false;
                }
            }
            ul1Var = ul1Var2;
        }
        return true;
    }
}
