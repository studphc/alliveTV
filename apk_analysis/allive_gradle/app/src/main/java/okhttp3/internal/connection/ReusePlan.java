package okhttp3.internal.connection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.RoutePlanner;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014¨\u0006\u0015"}, m5569d2 = {"Lokhttp3/internal/connection/ReusePlan;", "Lokhttp3/internal/connection/RoutePlanner$Plan;", "Lokhttp3/internal/connection/RealConnection;", "connection", "<init>", "(Lokhttp3/internal/connection/RealConnection;)V", "", "connectTcp", "()Ljava/lang/Void;", "connectTlsEtc", "handleSuccess", "()Lokhttp3/internal/connection/RealConnection;", "cancel", "retry", "a", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "", "isReady", "Z", "()Z", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ReusePlan implements RoutePlanner.Plan {

    /* renamed from: a, reason: from kotlin metadata */
    public final RealConnection connection;

    public ReusePlan(@NotNull RealConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.connection = connection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* renamed from: connectTcp, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ RoutePlanner.ConnectResult mo9053connectTcp() {
        return (RoutePlanner.ConnectResult) connectTcp();
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* renamed from: connectTlsEtc, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ RoutePlanner.ConnectResult mo9054connectTlsEtc() {
        return (RoutePlanner.ConnectResult) connectTlsEtc();
    }

    @NotNull
    public final RealConnection getConnection() {
        return this.connection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    @NotNull
    /* renamed from: handleSuccess */
    public RealConnection mo9050handleSuccess() {
        return this.connection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public boolean isReady() {
        return true;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* renamed from: retry */
    public /* bridge */ /* synthetic */ RoutePlanner.Plan mo9051retry() {
        return (RoutePlanner.Plan) retry();
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan, okhttp3.internal.http.ExchangeCodec.Carrier
    @NotNull
    /* renamed from: cancel, reason: merged with bridge method [inline-methods] */
    public Void mo9049cancel() {
        throw new IllegalStateException("unexpected cancel");
    }

    @NotNull
    public Void connectTcp() {
        throw new IllegalStateException("already connected");
    }

    @NotNull
    public Void connectTlsEtc() {
        throw new IllegalStateException("already connected");
    }

    @NotNull
    public Void retry() {
        throw new IllegalStateException("unexpected retry");
    }
}
