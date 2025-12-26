package androidx.privacysandbox.ads.adservices.internal;

import android.os.Build;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import p000.C1787s6;
import p000.C1824t6;

@Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0006\u0007J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\b"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/internal/AdServicesInfo;", "", "", "adServicesVersion", "()I", "extServicesVersionS", "s6", "t6", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class AdServicesInfo {

    @NotNull
    public static final AdServicesInfo INSTANCE = new Object();

    public final int adServicesVersion() {
        if (Build.VERSION.SDK_INT >= 33) {
            return C1824t6.f26705a.m7458a();
        }
        return 0;
    }

    public final int extServicesVersionS() {
        int i = Build.VERSION.SDK_INT;
        if (i != 31 && i != 32) {
            return 0;
        }
        return C1787s6.f26253a.m7331a();
    }
}
