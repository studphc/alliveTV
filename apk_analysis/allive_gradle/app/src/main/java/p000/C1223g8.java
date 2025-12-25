package p000;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.lifecycle.SavedStateHandlesVM;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import okio.internal.ResourceFileSystem;
import okio.internal.ZipEntry;

/* renamed from: g8 */
/* loaded from: classes.dex */
public final class C1223g8 extends Lambda implements Function1 {

    /* renamed from: c */
    public static final C1223g8 f17574c = new C1223g8(1, 0);

    /* renamed from: d */
    public static final C1223g8 f17575d = new C1223g8(1, 1);

    /* renamed from: e */
    public static final C1223g8 f17576e = new C1223g8(1, 2);

    /* renamed from: f */
    public static final C1223g8 f17577f = new C1223g8(1, 3);

    /* renamed from: g */
    public static final C1223g8 f17578g = new C1223g8(1, 4);

    /* renamed from: h */
    public static final C1223g8 f17579h = new C1223g8(1, 5);

    /* renamed from: i */
    public static final C1223g8 f17580i = new C1223g8(1, 6);

    /* renamed from: j */
    public static final C1223g8 f17581j = new C1223g8(1, 7);

    /* renamed from: k */
    public static final C1223g8 f17582k = new C1223g8(1, 8);

    /* renamed from: l */
    public static final C1223g8 f17583l = new C1223g8(1, 9);

    /* renamed from: m */
    public static final C1223g8 f17584m = new C1223g8(1, 10);

    /* renamed from: n */
    public static final C1223g8 f17585n = new C1223g8(1, 11);

    /* renamed from: o */
    public static final C1223g8 f17586o = new C1223g8(1, 12);

    /* renamed from: p */
    public static final C1223g8 f17587p = new C1223g8(1, 13);

    /* renamed from: q */
    public static final C1223g8 f17588q = new C1223g8(1, 14);

    /* renamed from: r */
    public static final C1223g8 f17589r = new C1223g8(1, 15);

    /* renamed from: s */
    public static final C1223g8 f17590s = new C1223g8(1, 16);

    /* renamed from: t */
    public static final C1223g8 f17591t = new C1223g8(1, 17);

    /* renamed from: u */
    public static final C1223g8 f17592u = new C1223g8(1, 18);

    /* renamed from: v */
    public static final C1223g8 f17593v = new C1223g8(1, 19);

    /* renamed from: w */
    public static final C1223g8 f17594w = new C1223g8(1, 20);

    /* renamed from: x */
    public static final C1223g8 f17595x = new C1223g8(1, 21);

    /* renamed from: y */
    public static final C1223g8 f17596y = new C1223g8(1, 22);

    /* renamed from: z */
    public static final C1223g8 f17597z = new C1223g8(1, 23);

    /* renamed from: b */
    public final /* synthetic */ int f17598b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1223g8(int i, int i2) {
        super(i);
        this.f17598b = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean z;
        ViewGroup viewGroup;
        Sequence<View> children;
        switch (this.f17598b) {
            case 0:
                return Unit.INSTANCE;
            case 1:
                return Unit.INSTANCE;
            case 2:
                return null;
            case 3:
                return obj;
            case 4:
                return Boolean.TRUE;
            case 5:
                ZipEntry entry = (ZipEntry) obj;
                Intrinsics.checkNotNullParameter(entry, "entry");
                return Boolean.valueOf(wb2.m8019a(ResourceFileSystem.access$getCompanion$p(), entry.getCanonicalPath()));
            case 6:
                CreationExtras initializer = (CreationExtras) obj;
                Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
                return new SavedStateHandlesVM();
            case 7:
                Sequence it = (Sequence) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                return it.iterator();
            case 8:
                Iterable it2 = (Iterable) obj;
                Intrinsics.checkNotNullParameter(it2, "it");
                return it2.iterator();
            case 9:
            case 10:
                return obj;
            case 11:
                IndexedValue it3 = (IndexedValue) obj;
                Intrinsics.checkNotNullParameter(it3, "it");
                return it3.getValue();
            case 12:
                if (obj == null) {
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 13:
                String line = (String) obj;
                Intrinsics.checkNotNullParameter(line, "line");
                return line;
            case 14:
                CharSequence it4 = (CharSequence) obj;
                Intrinsics.checkNotNullParameter(it4, "it");
                return it4.toString();
            case 15:
                CharSequence it5 = (CharSequence) obj;
                Intrinsics.checkNotNullParameter(it5, "it");
                return it5.toString();
            case 16:
                CharSequence it6 = (CharSequence) obj;
                Intrinsics.checkNotNullParameter(it6, "it");
                return it6.toString();
            case 17:
                View view = (View) obj;
                if (view instanceof ViewGroup) {
                    viewGroup = (ViewGroup) view;
                } else {
                    viewGroup = null;
                }
                if (viewGroup == null || (children = ViewGroupKt.getChildren(viewGroup)) == null) {
                    return null;
                }
                return children.iterator();
            case 18:
                View it7 = (View) obj;
                Intrinsics.checkNotNullParameter(it7, "it");
                Object parent = it7.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            case 19:
                View currentView = (View) obj;
                Intrinsics.checkNotNullParameter(currentView, "currentView");
                Object parent2 = currentView.getParent();
                if (parent2 instanceof View) {
                    return (View) parent2;
                }
                return null;
            case 20:
                View it8 = (View) obj;
                Intrinsics.checkNotNullParameter(it8, "it");
                Object parent3 = it8.getParent();
                if (parent3 instanceof View) {
                    return (View) parent3;
                }
                return null;
            case 21:
                View view2 = (View) obj;
                Intrinsics.checkNotNullParameter(view2, "view");
                Object parent4 = view2.getParent();
                if (parent4 instanceof View) {
                    return (View) parent4;
                }
                return null;
            case 22:
                View view3 = (View) obj;
                Intrinsics.checkNotNullParameter(view3, "view");
                Object parent5 = view3.getParent();
                if (parent5 instanceof View) {
                    return (View) parent5;
                }
                return null;
            default:
                Intrinsics.checkNotNullParameter((ZipEntry) obj, "it");
                return Boolean.TRUE;
        }
    }
}
