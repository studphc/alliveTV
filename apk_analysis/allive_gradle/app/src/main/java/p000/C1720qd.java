package p000;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.audio.AudioTrackPositionTracker$Listener;
import com.google.android.exoplayer2.audio.C0651e;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Method;

/* renamed from: qd */
/* loaded from: classes.dex */
public final class C1720qd {

    /* renamed from: A */
    public long f25518A;

    /* renamed from: B */
    public long f25519B;

    /* renamed from: C */
    public long f25520C;

    /* renamed from: D */
    public boolean f25521D;

    /* renamed from: E */
    public long f25522E;

    /* renamed from: F */
    public long f25523F;

    /* renamed from: a */
    public final AudioTrackPositionTracker$Listener f25524a;

    /* renamed from: b */
    public final long[] f25525b;

    /* renamed from: c */
    public AudioTrack f25526c;

    /* renamed from: d */
    public int f25527d;

    /* renamed from: e */
    public int f25528e;

    /* renamed from: f */
    public C1683pd f25529f;

    /* renamed from: g */
    public int f25530g;

    /* renamed from: h */
    public boolean f25531h;

    /* renamed from: i */
    public long f25532i;

    /* renamed from: j */
    public float f25533j;

    /* renamed from: k */
    public boolean f25534k;

    /* renamed from: l */
    public long f25535l;

    /* renamed from: m */
    public long f25536m;

    /* renamed from: n */
    public Method f25537n;

    /* renamed from: o */
    public long f25538o;

    /* renamed from: p */
    public boolean f25539p;

    /* renamed from: q */
    public boolean f25540q;

    /* renamed from: r */
    public long f25541r;

    /* renamed from: s */
    public long f25542s;

    /* renamed from: t */
    public long f25543t;

    /* renamed from: u */
    public long f25544u;

    /* renamed from: v */
    public int f25545v;

    /* renamed from: w */
    public int f25546w;

    /* renamed from: x */
    public long f25547x;

    /* renamed from: y */
    public long f25548y;

    /* renamed from: z */
    public long f25549z;

    public C1720qd(C0651e c0651e) {
        this.f25524a = (AudioTrackPositionTracker$Listener) Assertions.checkNotNull(c0651e);
        if (Util.SDK_INT >= 18) {
            try {
                this.f25537n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f25525b = new long[10];
    }

    /* renamed from: a */
    public final long m7028a() {
        AudioTrack audioTrack = (AudioTrack) Assertions.checkNotNull(this.f25526c);
        if (this.f25547x != C0643C.TIME_UNSET) {
            return Math.min(this.f25518A, this.f25549z + ((((SystemClock.elapsedRealtime() * 1000) - this.f25547x) * this.f25530g) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = audioTrack.getPlaybackHeadPosition() & 4294967295L;
        if (this.f25531h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f25544u = this.f25542s;
            }
            playbackHeadPosition += this.f25544u;
        }
        if (Util.SDK_INT <= 29) {
            if (playbackHeadPosition == 0 && this.f25542s > 0 && playState == 3) {
                if (this.f25548y == C0643C.TIME_UNSET) {
                    this.f25548y = SystemClock.elapsedRealtime();
                }
                return this.f25542s;
            }
            this.f25548y = C0643C.TIME_UNSET;
        }
        if (this.f25542s > playbackHeadPosition) {
            this.f25543t++;
        }
        this.f25542s = playbackHeadPosition;
        return playbackHeadPosition + (this.f25543t << 32);
    }

    /* renamed from: b */
    public final boolean m7029b(long j) {
        if (j <= m7028a() && (!this.f25531h || ((AudioTrack) Assertions.checkNotNull(this.f25526c)).getPlayState() != 2 || m7028a() != 0)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public final void m7030c(AudioTrack audioTrack, boolean z, int i, int i2, int i3) {
        boolean z2;
        long j;
        this.f25526c = audioTrack;
        this.f25527d = i2;
        this.f25528e = i3;
        this.f25529f = new C1683pd(audioTrack);
        this.f25530g = audioTrack.getSampleRate();
        if (z && Util.SDK_INT < 23 && (i == 5 || i == 6)) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f25531h = z2;
        boolean isEncodingLinearPcm = Util.isEncodingLinearPcm(i);
        this.f25540q = isEncodingLinearPcm;
        if (isEncodingLinearPcm) {
            j = ((i3 / i2) * 1000000) / this.f25530g;
        } else {
            j = -9223372036854775807L;
        }
        this.f25532i = j;
        this.f25542s = 0L;
        this.f25543t = 0L;
        this.f25544u = 0L;
        this.f25539p = false;
        this.f25547x = C0643C.TIME_UNSET;
        this.f25548y = C0643C.TIME_UNSET;
        this.f25541r = 0L;
        this.f25538o = 0L;
        this.f25533j = 1.0f;
    }
}
