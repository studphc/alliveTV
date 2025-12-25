package p000;

import android.location.GnssStatus;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class ki0 {
    /* renamed from: a */
    public static /* bridge */ /* synthetic */ int m5533a(GnssStatus gnssStatus) {
        return gnssStatus.hashCode();
    }

    /* renamed from: h */
    public static /* bridge */ /* synthetic */ Optional m5540h(Object obj) {
        return (Optional) obj;
    }

    /* renamed from: j */
    public static /* synthetic */ CompletableFuture m5542j() {
        return new CompletableFuture();
    }

    /* renamed from: l */
    public static /* bridge */ /* synthetic */ BiConsumer m5544l(Object obj) {
        return (BiConsumer) obj;
    }

    /* renamed from: q */
    public static /* bridge */ /* synthetic */ Stream m5549q(Object obj) {
        return (Stream) obj;
    }

    /* renamed from: y */
    public static /* bridge */ /* synthetic */ void m5557y(BiConsumer biConsumer, Object obj, Object obj2) {
        biConsumer.accept(obj, obj2);
    }
}
