package p000;

import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.video.VideoSize;
import java.io.IOException;
import java.util.List;

/* renamed from: u7 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1862u7 {
    /* renamed from: A */
    public static void m7601A(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    /* renamed from: B */
    public static void m7603B(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    /* renamed from: E */
    public static void m7607E(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    /* renamed from: Y */
    public static void m7627Y(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    /* renamed from: h0 */
    public static void m7644h0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    /* renamed from: i0 */
    public static void m7646i0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    /* renamed from: y */
    public static void m7677y(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    /* renamed from: z */
    public static void m7679z(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime) {
    }

    /* renamed from: A0 */
    public static void m7602A0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
    }

    /* renamed from: B0 */
    public static void m7604B0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, float f) {
    }

    /* renamed from: C */
    public static void m7605C(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    /* renamed from: D */
    public static void m7606D(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Exception exc) {
    }

    /* renamed from: G */
    public static void m7609G(AnalyticsListener analyticsListener, Player player, AnalyticsListener.Events events) {
    }

    /* renamed from: H */
    public static void m7610H(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z) {
    }

    /* renamed from: I */
    public static void m7611I(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z) {
    }

    /* renamed from: N */
    public static void m7616N(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z) {
    }

    /* renamed from: O */
    public static void m7617O(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, long j) {
    }

    /* renamed from: Q */
    public static void m7619Q(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
    }

    /* renamed from: R */
    public static void m7620R(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Metadata metadata) {
    }

    /* renamed from: T */
    public static void m7622T(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
    }

    /* renamed from: U */
    public static void m7623U(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    /* renamed from: V */
    public static void m7624V(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    /* renamed from: W */
    public static void m7625W(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
    }

    /* renamed from: X */
    public static void m7626X(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
    }

    /* renamed from: a */
    public static void m7629a(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
    }

    /* renamed from: a0 */
    public static void m7630a0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
    }

    /* renamed from: b */
    public static void m7631b(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Exception exc) {
    }

    /* renamed from: b0 */
    public static void m7632b0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    /* renamed from: e */
    public static void m7637e(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, String str) {
    }

    /* renamed from: e0 */
    public static void m7638e0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    /* renamed from: f */
    public static void m7639f(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
    }

    /* renamed from: f0 */
    public static void m7640f0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, long j) {
    }

    /* renamed from: g */
    public static void m7641g(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
    }

    /* renamed from: g0 */
    public static void m7642g0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, long j) {
    }

    /* renamed from: h */
    public static void m7643h(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Format format) {
    }

    /* renamed from: j */
    public static void m7647j(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, long j) {
    }

    /* renamed from: j0 */
    public static void m7648j0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z) {
    }

    /* renamed from: k */
    public static void m7649k(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    /* renamed from: k0 */
    public static void m7650k0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z) {
    }

    /* renamed from: l */
    public static void m7651l(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Exception exc) {
    }

    /* renamed from: m0 */
    public static void m7654m0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i) {
    }

    /* renamed from: n */
    public static void m7655n(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Player.Commands commands) {
    }

    /* renamed from: n0 */
    public static void m7656n0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
    }

    /* renamed from: o0 */
    public static void m7658o0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Tracks tracks) {
    }

    /* renamed from: p */
    public static void m7659p(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, CueGroup cueGroup) {
    }

    /* renamed from: p0 */
    public static void m7660p0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
    }

    /* renamed from: q */
    public static void m7661q(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, List list) {
    }

    /* renamed from: q0 */
    public static void m7662q0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Exception exc) {
    }

    /* renamed from: t0 */
    public static void m7668t0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, String str) {
    }

    /* renamed from: u0 */
    public static void m7670u0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
    }

    /* renamed from: v */
    public static void m7671v(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, DeviceInfo deviceInfo) {
    }

    /* renamed from: v0 */
    public static void m7672v0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
    }

    /* renamed from: x */
    public static void m7675x(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
    }

    /* renamed from: x0 */
    public static void m7676x0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Format format) {
    }

    /* renamed from: F */
    public static void m7608F(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, long j) {
    }

    /* renamed from: J */
    public static void m7612J(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    /* renamed from: K */
    public static void m7613K(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    /* renamed from: M */
    public static void m7615M(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    /* renamed from: P */
    public static void m7618P(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i) {
    }

    /* renamed from: S */
    public static void m7621S(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z, int i) {
    }

    /* renamed from: Z */
    public static void m7628Z(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, boolean z, int i) {
    }

    /* renamed from: c */
    public static void m7633c(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, String str, long j) {
    }

    /* renamed from: d0 */
    public static void m7636d0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Object obj, long j) {
    }

    /* renamed from: i */
    public static void m7645i(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    /* renamed from: l0 */
    public static void m7652l0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, int i2) {
    }

    /* renamed from: r */
    public static void m7663r(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
    }

    /* renamed from: r0 */
    public static void m7664r0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, String str, long j) {
    }

    /* renamed from: s */
    public static void m7665s(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
    }

    /* renamed from: u */
    public static void m7669u(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, Format format) {
    }

    /* renamed from: w */
    public static void m7673w(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, boolean z) {
    }

    /* renamed from: w0 */
    public static void m7674w0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, long j, int i) {
    }

    /* renamed from: y0 */
    public static void m7678y0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    /* renamed from: c0 */
    public static void m7634c0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
    }

    /* renamed from: d */
    public static void m7635d(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, String str, long j, long j2) {
    }

    /* renamed from: m */
    public static void m7653m(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
    }

    /* renamed from: o */
    public static void m7657o(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
    }

    /* renamed from: s0 */
    public static void m7666s0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, String str, long j, long j2) {
    }

    /* renamed from: t */
    public static void m7667t(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, String str, long j) {
    }

    /* renamed from: L */
    public static void m7614L(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
    }

    /* renamed from: z0 */
    public static void m7680z0(AnalyticsListener analyticsListener, AnalyticsListener.EventTime eventTime, int i, int i2, int i3, float f) {
    }
}
