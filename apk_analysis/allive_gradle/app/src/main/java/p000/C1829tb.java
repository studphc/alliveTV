package p000;

import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Handshake;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.ws.RealWebSocket;
import okio.FileSystem;
import okio.Path;
import okio.internal.ResourceFileSystem;
import okio.internal.ZipKt;

/* renamed from: tb */
/* loaded from: classes2.dex */
public final class C1829tb extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ int f26757b;

    /* renamed from: c */
    public final /* synthetic */ Object f26758c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1829tb(int i, Object obj) {
        super(0);
        this.f26757b = i;
        this.f26758c = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int lastIndexOf$default;
        Pair m5575to;
        switch (this.f26757b) {
            case 0:
                return ArrayIteratorKt.iterator((Object[]) this.f26758c);
            case 1:
                return ArrayIteratorsKt.iterator((float[]) this.f26758c);
            case 2:
                return ArrayIteratorsKt.iterator((double[]) this.f26758c);
            case 3:
                return ArrayIteratorsKt.iterator((boolean[]) this.f26758c);
            case 4:
                return ArrayIteratorsKt.iterator((char[]) this.f26758c);
            case 5:
                return ((Iterable) this.f26758c).iterator();
            case 6:
                List<Certificate> peerCertificates = ((Handshake) this.f26758c).peerCertificates();
                ArrayList arrayList = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(peerCertificates, 10));
                Iterator<T> it = peerCertificates.iterator();
                while (it.hasNext()) {
                    arrayList.add((X509Certificate) ((Certificate) it.next()));
                }
                return arrayList;
            case 7:
                return (Enum[]) this.f26758c;
            case 8:
                try {
                    return (List) ((Function0) this.f26758c).invoke();
                } catch (SSLPeerUnverifiedException unused) {
                    return CollectionsKt__CollectionsKt.emptyList();
                }
            case 9:
                ((Http2Connection) this.f26758c).writePing(false, 2, 0);
                return Unit.INSTANCE;
            case 10:
                ((RealWebSocket) this.f26758c).cancel();
                return Unit.INSTANCE;
            case 11:
                ResourceFileSystem.access$getCompanion$p().getClass();
                ClassLoader classLoader = (ClassLoader) this.f26758c;
                Intrinsics.checkNotNullParameter(classLoader, "<this>");
                Enumeration<URL> resources = classLoader.getResources("");
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(\"\")");
                ArrayList list = Collections.list(resources);
                Intrinsics.checkNotNullExpressionValue(list, "list(this)");
                ArrayList arrayList2 = new ArrayList();
                Iterator it2 = list.iterator();
                while (true) {
                    Pair pair = null;
                    if (it2.hasNext()) {
                        URL it3 = (URL) it2.next();
                        wb2 access$getCompanion$p = ResourceFileSystem.access$getCompanion$p();
                        Intrinsics.checkNotNullExpressionValue(it3, "it");
                        access$getCompanion$p.getClass();
                        Intrinsics.checkNotNullParameter(it3, "<this>");
                        if (Intrinsics.areEqual(it3.getProtocol(), "file")) {
                            pair = TuplesKt.m5575to(FileSystem.SYSTEM, Path.Companion.get$default(Path.INSTANCE, new File(it3.toURI()), false, 1, (Object) null));
                        }
                        if (pair != null) {
                            arrayList2.add(pair);
                        }
                    } else {
                        Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
                        Intrinsics.checkNotNullExpressionValue(resources2, "getResources(\"META-INF/MANIFEST.MF\")");
                        ArrayList<URL> list2 = Collections.list(resources2);
                        Intrinsics.checkNotNullExpressionValue(list2, "list(this)");
                        ArrayList arrayList3 = new ArrayList();
                        for (URL it4 : list2) {
                            wb2 access$getCompanion$p2 = ResourceFileSystem.access$getCompanion$p();
                            Intrinsics.checkNotNullExpressionValue(it4, "it");
                            access$getCompanion$p2.getClass();
                            Intrinsics.checkNotNullParameter(it4, "<this>");
                            String url = it4.toString();
                            Intrinsics.checkNotNullExpressionValue(url, "toString()");
                            if (!ro2.startsWith$default(url, "jar:file:", false, 2, null) || (lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) url, "!", 0, false, 6, (Object) null)) == -1) {
                                m5575to = null;
                            } else {
                                Path.Companion companion = Path.INSTANCE;
                                String substring = url.substring(4, lastIndexOf$default);
                                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                                m5575to = TuplesKt.m5575to(ZipKt.openZip(Path.Companion.get$default(companion, new File(URI.create(substring)), false, 1, (Object) null), FileSystem.SYSTEM, C1223g8.f17579h), ResourceFileSystem.access$getROOT$cp());
                            }
                            if (m5575to != null) {
                                arrayList3.add(m5575to);
                            }
                        }
                        return CollectionsKt___CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList3);
                    }
                }
                break;
            case 12:
                return SavedStateHandleSupport.getSavedStateHandlesVM((ViewModelStoreOwner) this.f26758c);
            case 13:
                return this.f26758c;
            default:
                return StringsKt__StringsKt.iterator((CharSequence) this.f26758c);
        }
    }
}
