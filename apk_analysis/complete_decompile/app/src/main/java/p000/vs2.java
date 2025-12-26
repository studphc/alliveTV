package p000;

import com.google.common.collect.ImmutableSet;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes.dex */
public final class vs2 {

    /* renamed from: d */
    public static final Pattern f27943d = Pattern.compile("\\s+");

    /* renamed from: e */
    public static final ImmutableSet f27944e = ImmutableSet.m3973of(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, SchedulerSupport.NONE);

    /* renamed from: f */
    public static final ImmutableSet f27945f = ImmutableSet.m3974of("dot", "sesame", "circle");

    /* renamed from: g */
    public static final ImmutableSet f27946g = ImmutableSet.m3973of("filled", "open");

    /* renamed from: h */
    public static final ImmutableSet f27947h = ImmutableSet.m3974of("after", "before", "outside");

    /* renamed from: a */
    public final int f27948a;

    /* renamed from: b */
    public final int f27949b;

    /* renamed from: c */
    public final int f27950c;

    public vs2(int i, int i2, int i3) {
        this.f27948a = i;
        this.f27949b = i2;
        this.f27950c = i3;
    }
}
