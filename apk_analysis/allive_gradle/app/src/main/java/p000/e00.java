package p000;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/* loaded from: classes.dex */
public final class e00 {

    /* renamed from: a */
    public final Timeline.Period f16630a;

    /* renamed from: b */
    public ImmutableList f16631b = ImmutableList.m3902of();

    /* renamed from: c */
    public ImmutableMap f16632c = ImmutableMap.m3923of();

    /* renamed from: d */
    public MediaSource.MediaPeriodId f16633d;

    /* renamed from: e */
    public MediaSource.MediaPeriodId f16634e;

    /* renamed from: f */
    public MediaSource.MediaPeriodId f16635f;

    public e00(Timeline.Period period) {
        this.f16630a = period;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public static MediaSource.MediaPeriodId m4651b(Player player, ImmutableList immutableList, MediaSource.MediaPeriodId mediaPeriodId, Timeline.Period period) {
        Object uidOfPeriod;
        int i;
        Timeline currentTimeline = player.getCurrentTimeline();
        int currentPeriodIndex = player.getCurrentPeriodIndex();
        if (currentTimeline.isEmpty()) {
            uidOfPeriod = null;
        } else {
            uidOfPeriod = currentTimeline.getUidOfPeriod(currentPeriodIndex);
        }
        if (!player.isPlayingAd() && !currentTimeline.isEmpty()) {
            i = currentTimeline.getPeriod(currentPeriodIndex, period).getAdGroupIndexAfterPositionUs(Util.msToUs(player.getCurrentPosition()) - period.getPositionInWindowUs());
        } else {
            i = -1;
        }
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            MediaSource.MediaPeriodId mediaPeriodId2 = (MediaSource.MediaPeriodId) immutableList.get(i2);
            if (m4652c(mediaPeriodId2, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), i)) {
                return mediaPeriodId2;
            }
        }
        if (immutableList.isEmpty() && mediaPeriodId != null) {
            if (m4652c(mediaPeriodId, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), i)) {
                return mediaPeriodId;
            }
        }
        return null;
    }

    /* renamed from: c */
    public static boolean m4652c(MediaSource.MediaPeriodId mediaPeriodId, Object obj, boolean z, int i, int i2, int i3) {
        if (!mediaPeriodId.periodUid.equals(obj)) {
            return false;
        }
        if ((!z || mediaPeriodId.adGroupIndex != i || mediaPeriodId.adIndexInAdGroup != i2) && (z || mediaPeriodId.adGroupIndex != -1 || mediaPeriodId.nextAdGroupIndex != i3)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final void m4653a(ImmutableMap.Builder builder, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
        if (mediaPeriodId == null) {
            return;
        }
        if (timeline.getIndexOfPeriod(mediaPeriodId.periodUid) != -1) {
            builder.put(mediaPeriodId, timeline);
            return;
        }
        Timeline timeline2 = (Timeline) this.f16632c.get(mediaPeriodId);
        if (timeline2 != null) {
            builder.put(mediaPeriodId, timeline2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public final void m4654d(Timeline timeline) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        if (this.f16631b.isEmpty()) {
            m4653a(builder, this.f16634e, timeline);
            if (!Objects.equal(this.f16635f, this.f16634e)) {
                m4653a(builder, this.f16635f, timeline);
            }
            if (!Objects.equal(this.f16633d, this.f16634e) && !Objects.equal(this.f16633d, this.f16635f)) {
                m4653a(builder, this.f16633d, timeline);
            }
        } else {
            for (int i = 0; i < this.f16631b.size(); i++) {
                m4653a(builder, (MediaSource.MediaPeriodId) this.f16631b.get(i), timeline);
            }
            if (!this.f16631b.contains(this.f16633d)) {
                m4653a(builder, this.f16633d, timeline);
            }
        }
        this.f16632c = builder.buildOrThrow();
    }
}
