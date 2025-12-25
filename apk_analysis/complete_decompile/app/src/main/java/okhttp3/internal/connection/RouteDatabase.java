package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, m5569d2 = {"Lokhttp3/internal/connection/RouteDatabase;", "", "<init>", "()V", "Lokhttp3/Route;", "failedRoute", "", "failed", "(Lokhttp3/Route;)V", "route", "connected", "", "shouldPostpone", "(Lokhttp3/Route;)Z", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class RouteDatabase {

    /* renamed from: a */
    public final LinkedHashSet f24367a = new LinkedHashSet();

    public final synchronized void connected(@NotNull Route route) {
        Intrinsics.checkNotNullParameter(route, "route");
        this.f24367a.remove(route);
    }

    public final synchronized void failed(@NotNull Route failedRoute) {
        Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
        this.f24367a.add(failedRoute);
    }

    public final synchronized boolean shouldPostpone(@NotNull Route route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.f24367a.contains(route);
    }
}
