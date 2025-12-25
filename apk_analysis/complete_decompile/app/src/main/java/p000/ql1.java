package p000;

import android.media.MediaParser;
import android.telephony.TelephonyDisplayInfo;

/* loaded from: classes.dex */
public abstract /* synthetic */ class ql1 {
    /* renamed from: a */
    public static /* bridge */ /* synthetic */ int m7083a(TelephonyDisplayInfo telephonyDisplayInfo) {
        return telephonyDisplayInfo.getOverrideNetworkType();
    }

    /* renamed from: e */
    public static /* bridge */ /* synthetic */ MediaParser.SeekPoint m7087e(Object obj) {
        return (MediaParser.SeekPoint) obj;
    }

    /* renamed from: j */
    public static /* bridge */ /* synthetic */ String m7092j(MediaParser mediaParser) {
        return mediaParser.getParserName();
    }

    /* renamed from: l */
    public static /* bridge */ /* synthetic */ void m7094l(MediaParser mediaParser, rl1 rl1Var) {
        mediaParser.advance(rl1Var);
    }
}
