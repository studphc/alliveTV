package p000;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.Comparator;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: ur */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1882ur implements Comparator {

    /* renamed from: a */
    public final /* synthetic */ int f27413a;

    /* renamed from: b */
    public final /* synthetic */ Object f27414b;

    public /* synthetic */ C1882ur(int i, Object obj) {
        this.f27413a = i;
        this.f27414b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Object obj3 = this.f27414b;
        switch (this.f27413a) {
            case 0:
                Function1[] selectors = (Function1[]) obj3;
                Intrinsics.checkNotNullParameter(selectors, "$selectors");
                for (Function1 function1 : selectors) {
                    int compareValues = AbstractC1919vr.compareValues((Comparable) function1.invoke(obj), (Comparable) function1.invoke(obj2));
                    if (compareValues != 0) {
                        return compareValues;
                    }
                }
                return 0;
            default:
                Pattern pattern = MediaCodecUtil.f10723a;
                fl1 fl1Var = (fl1) obj3;
                return fl1Var.mo4692a(obj2) - fl1Var.mo4692a(obj);
        }
    }
}
