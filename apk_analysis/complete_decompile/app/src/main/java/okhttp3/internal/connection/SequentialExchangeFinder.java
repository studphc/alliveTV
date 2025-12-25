package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.RoutePlanner;
import org.jetbrains.annotations.NotNull;
import p000.ha0;
import p000.vc2;

@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m5569d2 = {"Lokhttp3/internal/connection/SequentialExchangeFinder;", "Lokhttp3/internal/connection/ExchangeFinder;", "Lokhttp3/internal/connection/RoutePlanner;", "routePlanner", "<init>", "(Lokhttp3/internal/connection/RoutePlanner;)V", "Lokhttp3/internal/connection/RealConnection;", "find", "()Lokhttp3/internal/connection/RealConnection;", "a", "Lokhttp3/internal/connection/RoutePlanner;", "getRoutePlanner", "()Lokhttp3/internal/connection/RoutePlanner;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class SequentialExchangeFinder implements ExchangeFinder {

    /* renamed from: a, reason: from kotlin metadata */
    public final RoutePlanner routePlanner;

    public SequentialExchangeFinder(@NotNull RoutePlanner routePlanner) {
        Intrinsics.checkNotNullParameter(routePlanner, "routePlanner");
        this.routePlanner = routePlanner;
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    @NotNull
    public RealConnection find() {
        RoutePlanner.Plan plan;
        IOException iOException = null;
        while (!getRoutePlanner().isCanceled()) {
            try {
                plan = getRoutePlanner().plan();
            } catch (IOException e) {
                if (iOException == null) {
                    iOException = e;
                } else {
                    ha0.addSuppressed(iOException, e);
                }
                if (!vc2.m7907a(getRoutePlanner(), null, 1, null)) {
                    throw iOException;
                }
            }
            if (!plan.isReady()) {
                RoutePlanner.ConnectResult result = plan.getResult();
                if (result.isSuccess()) {
                    result = plan.mo9054connectTlsEtc();
                }
                RoutePlanner.Plan nextPlan = result.getNextPlan();
                Throwable throwable = result.getThrowable();
                if (throwable == null) {
                    if (nextPlan != null) {
                        getRoutePlanner().getDeferredPlans().addFirst(nextPlan);
                    }
                } else {
                    throw throwable;
                }
            }
            return plan.mo9050handleSuccess();
        }
        throw new IOException("Canceled");
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    @NotNull
    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }
}
