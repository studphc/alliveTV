package p000;

import android.graphics.Point;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.C0717b;
import com.google.android.exoplayer2.trackselection.C0718c;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$TrackInfo$Factory;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: pw */
/* loaded from: classes.dex */
public final /* synthetic */ class C1702pw implements CallbackToFutureAdapter.Resolver, ListenerSet.Event, ListenerSet.IterationFinishedEvent, DefaultTrackSelector$TrackInfo$Factory, Deferred.DeferredHandler {

    /* renamed from: a */
    public final /* synthetic */ int f25320a;

    /* renamed from: b */
    public final /* synthetic */ Object f25321b;

    /* renamed from: c */
    public final /* synthetic */ Object f25322c;

    public /* synthetic */ C1702pw(int i, Object obj, Object obj2) {
        this.f25320a = i;
        this.f25321b = obj;
        this.f25322c = obj2;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        kotlinx.coroutines.Deferred this_asListenableFuture = (kotlinx.coroutines.Deferred) this.f25321b;
        Intrinsics.checkNotNullParameter(this_asListenableFuture, "$this_asListenableFuture");
        Intrinsics.checkNotNullParameter(completer, "completer");
        this_asListenableFuture.invokeOnCompletion(new C1739qw(completer, this_asListenableFuture));
        return this.f25322c;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0082  */
    @Override // com.google.android.exoplayer2.trackselection.DefaultTrackSelector$TrackInfo$Factory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List create(int i, TrackGroup trackGroup, int[] iArr) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Point point;
        int i8;
        int i9;
        boolean z2;
        boolean z3;
        Object obj = this.f25322c;
        Object obj2 = this.f25321b;
        boolean z4 = true;
        switch (this.f25320a) {
            case 12:
                Ordering ordering = DefaultTrackSelector.f11888j;
                int i10 = ((int[]) obj)[i];
                DefaultTrackSelector.Parameters parameters = (DefaultTrackSelector.Parameters) obj2;
                int i11 = parameters.viewportWidth;
                int i12 = parameters.viewportHeight;
                boolean z5 = parameters.viewportOrientationMayChange;
                if (i11 != Integer.MAX_VALUE && i12 != Integer.MAX_VALUE) {
                    int i13 = Integer.MAX_VALUE;
                    int i14 = 0;
                    while (i14 < trackGroup.length) {
                        Format format = trackGroup.getFormat(i14);
                        int i15 = format.width;
                        if (i15 > 0 && (i3 = format.height) > 0) {
                            if (z5) {
                                if (i15 > i3) {
                                    z2 = z4;
                                } else {
                                    z2 = false;
                                }
                                if (i11 > i12) {
                                    z3 = z4;
                                } else {
                                    z3 = false;
                                }
                                if (z2 != z3) {
                                    i5 = i11;
                                    i4 = i12;
                                    i6 = i15 * i5;
                                    i7 = i3 * i4;
                                    if (i6 < i7) {
                                        point = new Point(i4, Util.ceilDivide(i7, i15));
                                    } else {
                                        point = new Point(Util.ceilDivide(i6, i3), i5);
                                    }
                                    i8 = format.width;
                                    int i16 = format.height;
                                    i9 = i8 * i16;
                                    if (i8 >= ((int) (point.x * 0.98f)) && i16 >= ((int) (point.y * 0.98f)) && i9 < i13) {
                                        i13 = i9;
                                    }
                                }
                            }
                            i4 = i11;
                            i5 = i12;
                            i6 = i15 * i5;
                            i7 = i3 * i4;
                            if (i6 < i7) {
                            }
                            i8 = format.width;
                            int i162 = format.height;
                            i9 = i8 * i162;
                            if (i8 >= ((int) (point.x * 0.98f))) {
                                i13 = i9;
                            }
                        }
                        i14++;
                        z4 = true;
                    }
                    i2 = i13;
                } else {
                    i2 = Integer.MAX_VALUE;
                }
                ImmutableList.Builder builder = ImmutableList.builder();
                for (int i17 = 0; i17 < trackGroup.length; i17++) {
                    int pixelCount = trackGroup.getFormat(i17).getPixelCount();
                    if (i2 != Integer.MAX_VALUE && (pixelCount == -1 || pixelCount > i2)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    builder.add((ImmutableList.Builder) new C0718c(i, trackGroup, i17, parameters, iArr[i17], i10, z));
                }
                return builder.build();
            default:
                Ordering ordering2 = DefaultTrackSelector.f11888j;
                ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i18 = 0; i18 < trackGroup.length; i18++) {
                    builder2.add((ImmutableList.Builder) new C0717b(i, trackGroup, i18, (DefaultTrackSelector.Parameters) obj2, iArr[i18], (String) obj));
                }
                return builder2.build();
        }
    }

    @Override // com.google.firebase.inject.Deferred.DeferredHandler
    public void handle(Provider provider) {
        ((Deferred.DeferredHandler) this.f25321b).handle(provider);
        ((Deferred.DeferredHandler) this.f25322c).handle(provider);
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.IterationFinishedEvent
    public void invoke(Object obj, FlagSet flagSet) {
        ((AnalyticsListener) obj).onEvents((Player) this.f25322c, new AnalyticsListener.Events(flagSet, ((DefaultAnalyticsCollector) this.f25321b).f9516e));
    }

    @Override // com.google.android.exoplayer2.util.ListenerSet.Event
    public void invoke(Object obj) {
        switch (this.f25320a) {
            case 1:
                ((AnalyticsListener) obj).onAudioAttributesChanged((AnalyticsListener.EventTime) this.f25321b, (AudioAttributes) this.f25322c);
                return;
            case 2:
                ((AnalyticsListener) obj).onPlaybackParametersChanged((AnalyticsListener.EventTime) this.f25321b, (PlaybackParameters) this.f25322c);
                return;
            case 3:
            default:
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                AnalyticsListener.EventTime eventTime = (AnalyticsListener.EventTime) this.f25321b;
                VideoSize videoSize = (VideoSize) this.f25322c;
                analyticsListener.onVideoSizeChanged(eventTime, videoSize);
                analyticsListener.onVideoSizeChanged(eventTime, videoSize.width, videoSize.height, videoSize.unappliedRotationDegrees, videoSize.pixelWidthHeightRatio);
                return;
            case 4:
                ((AnalyticsListener) obj).onCues((AnalyticsListener.EventTime) this.f25321b, (CueGroup) this.f25322c);
                return;
            case 5:
                ((AnalyticsListener) obj).onAvailableCommandsChanged((AnalyticsListener.EventTime) this.f25321b, (Player.Commands) this.f25322c);
                return;
            case 6:
                ((AnalyticsListener) obj).onTrackSelectionParametersChanged((AnalyticsListener.EventTime) this.f25321b, (TrackSelectionParameters) this.f25322c);
                return;
            case 7:
                ((AnalyticsListener) obj).onCues((AnalyticsListener.EventTime) this.f25321b, (List<Cue>) this.f25322c);
                return;
            case 8:
                ((AnalyticsListener) obj).onTracksChanged((AnalyticsListener.EventTime) this.f25321b, (Tracks) this.f25322c);
                return;
            case 9:
                ((AnalyticsListener) obj).onDeviceInfoChanged((AnalyticsListener.EventTime) this.f25321b, (DeviceInfo) this.f25322c);
                return;
            case 10:
                ((AnalyticsListener) obj).onMetadata((AnalyticsListener.EventTime) this.f25321b, (Metadata) this.f25322c);
                return;
        }
    }
}
