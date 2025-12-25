package p000;

import android.media.session.PlaybackState;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import java.util.List;

/* loaded from: classes.dex */
public abstract class m52 {
    @DoNotInline
    /* renamed from: a */
    public static void m6055a(PlaybackState.Builder builder, PlaybackState.CustomAction customAction) {
        builder.addCustomAction(customAction);
    }

    @DoNotInline
    /* renamed from: b */
    public static PlaybackState.CustomAction m6056b(PlaybackState.CustomAction.Builder builder) {
        return builder.build();
    }

    @DoNotInline
    /* renamed from: c */
    public static PlaybackState m6057c(PlaybackState.Builder builder) {
        return builder.build();
    }

    @DoNotInline
    /* renamed from: d */
    public static PlaybackState.Builder m6058d() {
        return new PlaybackState.Builder();
    }

    @DoNotInline
    /* renamed from: e */
    public static PlaybackState.CustomAction.Builder m6059e(String str, CharSequence charSequence, int i) {
        return new PlaybackState.CustomAction.Builder(str, charSequence, i);
    }

    @DoNotInline
    /* renamed from: f */
    public static String m6060f(PlaybackState.CustomAction customAction) {
        return customAction.getAction();
    }

    @DoNotInline
    /* renamed from: g */
    public static long m6061g(PlaybackState playbackState) {
        return playbackState.getActions();
    }

    @DoNotInline
    /* renamed from: h */
    public static long m6062h(PlaybackState playbackState) {
        return playbackState.getActiveQueueItemId();
    }

    @DoNotInline
    /* renamed from: i */
    public static long m6063i(PlaybackState playbackState) {
        return playbackState.getBufferedPosition();
    }

    @DoNotInline
    /* renamed from: j */
    public static List<PlaybackState.CustomAction> m6064j(PlaybackState playbackState) {
        return playbackState.getCustomActions();
    }

    @DoNotInline
    /* renamed from: k */
    public static CharSequence m6065k(PlaybackState playbackState) {
        return playbackState.getErrorMessage();
    }

    @DoNotInline
    /* renamed from: l */
    public static Bundle m6066l(PlaybackState.CustomAction customAction) {
        return customAction.getExtras();
    }

    @DoNotInline
    /* renamed from: m */
    public static int m6067m(PlaybackState.CustomAction customAction) {
        return customAction.getIcon();
    }

    @DoNotInline
    /* renamed from: n */
    public static long m6068n(PlaybackState playbackState) {
        return playbackState.getLastPositionUpdateTime();
    }

    @DoNotInline
    /* renamed from: o */
    public static CharSequence m6069o(PlaybackState.CustomAction customAction) {
        return customAction.getName();
    }

    @DoNotInline
    /* renamed from: p */
    public static float m6070p(PlaybackState playbackState) {
        return playbackState.getPlaybackSpeed();
    }

    @DoNotInline
    /* renamed from: q */
    public static long m6071q(PlaybackState playbackState) {
        return playbackState.getPosition();
    }

    @DoNotInline
    /* renamed from: r */
    public static int m6072r(PlaybackState playbackState) {
        return playbackState.getState();
    }

    @DoNotInline
    /* renamed from: s */
    public static void m6073s(PlaybackState.Builder builder, long j) {
        builder.setActions(j);
    }

    @DoNotInline
    /* renamed from: t */
    public static void m6074t(PlaybackState.Builder builder, long j) {
        builder.setActiveQueueItemId(j);
    }

    @DoNotInline
    /* renamed from: u */
    public static void m6075u(PlaybackState.Builder builder, long j) {
        builder.setBufferedPosition(j);
    }

    @DoNotInline
    /* renamed from: v */
    public static void m6076v(PlaybackState.Builder builder, CharSequence charSequence) {
        builder.setErrorMessage(charSequence);
    }

    @DoNotInline
    /* renamed from: w */
    public static void m6077w(PlaybackState.CustomAction.Builder builder, Bundle bundle) {
        builder.setExtras(bundle);
    }

    @DoNotInline
    /* renamed from: x */
    public static void m6078x(PlaybackState.Builder builder, int i, long j, float f, long j2) {
        builder.setState(i, j, f, j2);
    }
}
