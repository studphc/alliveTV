package p000;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Predicate;
import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class m10 implements Predicate {

    /* renamed from: a */
    public final /* synthetic */ int f22754a;

    /* renamed from: b */
    public final /* synthetic */ Object f22755b;

    public /* synthetic */ m10(int i, Object obj) {
        this.f22754a = i;
        this.f22755b = obj;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b3, code lost:
    
        if (r3.f11894h.m6767a(r9, r3.f11895i) != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x005d, code lost:
    
        if (r5.equals(com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4) == false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007e A[Catch: all -> 0x008b, TRY_ENTER, TryCatch #0 {all -> 0x008b, blocks: (B:9:0x002e, B:11:0x0034, B:13:0x0038, B:15:0x003c, B:20:0x007e, B:22:0x0082, B:24:0x0086, B:27:0x008d, B:29:0x0091, B:31:0x0095, B:33:0x0099, B:35:0x00a1, B:37:0x00ab, B:39:0x00b6), top: B:8:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1 A[Catch: all -> 0x008b, TryCatch #0 {all -> 0x008b, blocks: (B:9:0x002e, B:11:0x0034, B:13:0x0038, B:15:0x003c, B:20:0x007e, B:22:0x0082, B:24:0x0086, B:27:0x008d, B:29:0x0091, B:31:0x0095, B:33:0x0099, B:35:0x00a1, B:37:0x00ab, B:39:0x00b6), top: B:8:0x002e }] */
    @Override // com.google.common.base.Predicate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean apply(Object obj) {
        boolean z;
        p10 p10Var;
        boolean isAvailable;
        boolean isEnabled;
        p10 p10Var2;
        boolean z2 = false;
        char c = 2;
        switch (this.f22754a) {
            case 0:
                DefaultTrackSelector defaultTrackSelector = (DefaultTrackSelector) this.f22755b;
                Format format = (Format) obj;
                synchronized (defaultTrackSelector.f11890d) {
                    try {
                        if (defaultTrackSelector.f11893g.constrainAudioChannelCountToDeviceCapabilities && !defaultTrackSelector.f11892f && format.channelCount > 2) {
                            String str = format.sampleMimeType;
                            if (str != null) {
                                switch (str.hashCode()) {
                                    case -2123537834:
                                        if (str.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                                            c = 0;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 187078296:
                                        if (str.equals(MimeTypes.AUDIO_AC3)) {
                                            c = 1;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 187078297:
                                        break;
                                    case 1504578661:
                                        if (str.equals(MimeTypes.AUDIO_E_AC3)) {
                                            c = 3;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    default:
                                        c = 65535;
                                        break;
                                }
                                switch (c) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                        z = true;
                                        break;
                                }
                                if (z) {
                                    if (Util.SDK_INT >= 32 && (p10Var2 = defaultTrackSelector.f11894h) != null && p10Var2.f25000b) {
                                    }
                                }
                                if (Util.SDK_INT >= 32 && (p10Var = defaultTrackSelector.f11894h) != null && p10Var.f25000b) {
                                    isAvailable = p10Var.f24999a.isAvailable();
                                    if (isAvailable) {
                                        isEnabled = defaultTrackSelector.f11894h.f24999a.isEnabled();
                                        if (isEnabled) {
                                            break;
                                        }
                                    }
                                }
                            }
                            z = false;
                            if (z) {
                            }
                            if (Util.SDK_INT >= 32) {
                                isAvailable = p10Var.f24999a.isAvailable();
                                if (isAvailable) {
                                }
                            }
                        }
                        z2 = true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return z2;
            default:
                Map.Entry entry = (Map.Entry) obj;
                return ((Predicate) this.f22755b).apply(Multisets.immutableEntry(entry.getKey(), ((Collection) entry.getValue()).size()));
        }
    }
}
