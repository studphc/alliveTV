package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.cache.DiskLruCache;

/* renamed from: okhttp3.internal.cache.a */
/* loaded from: classes2.dex */
public final class C1633a extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ DiskLruCache f24230b;

    /* renamed from: c */
    public final /* synthetic */ DiskLruCache.Editor f24231c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1633a(DiskLruCache diskLruCache, DiskLruCache.Editor editor) {
        super(1);
        this.f24230b = diskLruCache;
        this.f24231c = editor;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        IOException it = (IOException) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        DiskLruCache diskLruCache = this.f24230b;
        DiskLruCache.Editor editor = this.f24231c;
        synchronized (diskLruCache) {
            editor.detach$okhttp();
        }
        return Unit.INSTANCE;
    }
}
