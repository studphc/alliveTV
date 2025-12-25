package p000;

import java.io.File;
import java.io.IOException;
import kotlin.TuplesKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: wn */
/* loaded from: classes2.dex */
public final class C1952wn extends Lambda implements Function2 {

    /* renamed from: c */
    public static final C1952wn f28244c = new C1952wn(2, 0);

    /* renamed from: d */
    public static final C1952wn f28245d = new C1952wn(2, 1);

    /* renamed from: e */
    public static final C1952wn f28246e = new C1952wn(2, 2);

    /* renamed from: f */
    public static final C1952wn f28247f = new C1952wn(2, 3);

    /* renamed from: g */
    public static final C1952wn f28248g = new C1952wn(2, 4);

    /* renamed from: h */
    public static final C1952wn f28249h = new C1952wn(2, 5);

    /* renamed from: i */
    public static final C1952wn f28250i = new C1952wn(2, 6);

    /* renamed from: j */
    public static final C1952wn f28251j = new C1952wn(2, 7);

    /* renamed from: b */
    public final /* synthetic */ int f28252b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1952wn(int i, int i2) {
        super(i);
        this.f28252b = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f28252b) {
            case 0:
                return TuplesKt.m5575to(obj, obj2);
            case 1:
                String acc = (String) obj;
                CoroutineContext.Element element = (CoroutineContext.Element) obj2;
                Intrinsics.checkNotNullParameter(acc, "acc");
                Intrinsics.checkNotNullParameter(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
            case 2:
                return new C1959wu(obj, obj2);
            case 3:
                return obj;
            case 4:
                IOException exception = (IOException) obj2;
                Intrinsics.checkNotNullParameter((File) obj, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(exception, "exception");
                throw exception;
            case 5:
                return Boolean.valueOf(Intrinsics.areEqual(obj, obj2));
            case 6:
                return TuplesKt.m5575to(obj, obj2);
            default:
                return TuplesKt.m5575to(obj, obj2);
        }
    }
}
