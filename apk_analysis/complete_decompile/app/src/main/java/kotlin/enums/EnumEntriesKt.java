package kotlin.enums;

import androidx.exifinterface.media.ExifInterface;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.C1829tb;
import p000.q90;

@Metadata(m5568d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00060\u0005H\u0001\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, m5569d2 = {"enumEntries", "Lkotlin/enums/EnumEntries;", ExifInterface.LONGITUDE_EAST, "", "entriesProvider", "Lkotlin/Function0;", "", "entries", "([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;", "kotlin-stdlib"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class EnumEntriesKt {
    @SinceKotlin(version = "1.8")
    @ExperimentalStdlibApi
    @NotNull
    @PublishedApi
    public static final <E extends Enum<E>> EnumEntries<E> enumEntries(@NotNull Function0<E[]> entriesProvider) {
        Intrinsics.checkNotNullParameter(entriesProvider, "entriesProvider");
        return new q90(entriesProvider);
    }

    @SinceKotlin(version = "1.8")
    @ExperimentalStdlibApi
    @NotNull
    @PublishedApi
    public static final <E extends Enum<E>> EnumEntries<E> enumEntries(@NotNull E[] entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        q90 q90Var = new q90(new C1829tb(7, entries));
        q90Var.size();
        return q90Var;
    }
}
