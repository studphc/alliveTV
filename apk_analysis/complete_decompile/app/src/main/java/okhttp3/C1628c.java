package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import p000.AbstractC1726qj;

/* renamed from: okhttp3.c */
/* loaded from: classes2.dex */
public final class C1628c implements Dns {
    @Override // okhttp3.Dns
    public final List lookup(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        try {
            InetAddress[] allByName = InetAddress.getAllByName(hostname);
            Intrinsics.checkNotNullExpressionValue(allByName, "getAllByName(hostname)");
            return ArraysKt___ArraysKt.toList(allByName);
        } catch (NullPointerException e) {
            UnknownHostException unknownHostException = new UnknownHostException(AbstractC1726qj.m7038C("Broken system behaviour for dns lookup of ", hostname));
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}
