package androidx.activity;

import android.content.res.Resources;
import androidx.annotation.ColorInt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00020\u00128\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, m5569d2 = {"Landroidx/activity/SystemBarStyle;", "", "", "isDark", "", "getScrim$activity_release", "(Z)I", "getScrim", "getScrimWithEnforcedContrast$activity_release", "getScrimWithEnforcedContrast", "b", "I", "getDarkScrim$activity_release", "()I", "darkScrim", "c", "getNightMode$activity_release", "nightMode", "Lkotlin/Function1;", "Landroid/content/res/Resources;", "d", "Lkotlin/jvm/functions/Function1;", "getDetectDarkMode$activity_release", "()Lkotlin/jvm/functions/Function1;", "detectDarkMode", "Companion", "activity_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class SystemBarStyle {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a */
    public final int f520a;

    /* renamed from: b, reason: from kotlin metadata */
    public final int darkScrim;

    /* renamed from: c, reason: from kotlin metadata */
    public final int nightMode;

    /* renamed from: d, reason: from kotlin metadata */
    public final Function1 detectDarkMode;

    @Metadata(m5568d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001J9\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m5569d2 = {"Landroidx/activity/SystemBarStyle$Companion;", "", "", "lightScrim", "darkScrim", "Lkotlin/Function1;", "Landroid/content/res/Resources;", "", "detectDarkMode", "Landroidx/activity/SystemBarStyle;", DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "(IILkotlin/jvm/functions/Function1;)Landroidx/activity/SystemBarStyle;", "scrim", "dark", "(I)Landroidx/activity/SystemBarStyle;", "light", "(II)Landroidx/activity/SystemBarStyle;", "activity_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SystemBarStyle auto$default(Companion companion, int i, int i2, Function1 function1, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                function1 = C0074a.f524b;
            }
            return companion.auto(i, i2, function1);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2) {
            return auto$default(this, i, i2, null, 4, null);
        }

        @JvmStatic
        @NotNull
        public final SystemBarStyle dark(@ColorInt int scrim) {
            return new SystemBarStyle(scrim, scrim, 2, C0075b.f525b, null);
        }

        @JvmStatic
        @NotNull
        public final SystemBarStyle light(@ColorInt int scrim, @ColorInt int darkScrim) {
            return new SystemBarStyle(scrim, darkScrim, 1, C0076c.f526b, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final SystemBarStyle auto(@ColorInt int lightScrim, @ColorInt int darkScrim, @NotNull Function1<? super Resources, Boolean> detectDarkMode) {
            Intrinsics.checkNotNullParameter(detectDarkMode, "detectDarkMode");
            return new SystemBarStyle(lightScrim, darkScrim, 0, detectDarkMode, null);
        }
    }

    public SystemBarStyle(int i, int i2, int i3, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this.f520a = i;
        this.darkScrim = i2;
        this.nightMode = i3;
        this.detectDarkMode = function1;
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2) {
        return INSTANCE.auto(i, i2);
    }

    @JvmStatic
    @NotNull
    public static final SystemBarStyle dark(@ColorInt int i) {
        return INSTANCE.dark(i);
    }

    @JvmStatic
    @NotNull
    public static final SystemBarStyle light(@ColorInt int i, @ColorInt int i2) {
        return INSTANCE.light(i, i2);
    }

    /* renamed from: getDarkScrim$activity_release, reason: from getter */
    public final int getDarkScrim() {
        return this.darkScrim;
    }

    @NotNull
    public final Function1<Resources, Boolean> getDetectDarkMode$activity_release() {
        return this.detectDarkMode;
    }

    /* renamed from: getNightMode$activity_release, reason: from getter */
    public final int getNightMode() {
        return this.nightMode;
    }

    public final int getScrim$activity_release(boolean isDark) {
        if (isDark) {
            return this.darkScrim;
        }
        return this.f520a;
    }

    public final int getScrimWithEnforcedContrast$activity_release(boolean isDark) {
        if (this.nightMode == 0) {
            return 0;
        }
        if (isDark) {
            return this.darkScrim;
        }
        return this.f520a;
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2, @NotNull Function1<? super Resources, Boolean> function1) {
        return INSTANCE.auto(i, i2, function1);
    }
}
