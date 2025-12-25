package androidx.privacysandbox.ads.adservices.internal;

import android.content.Context;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001J;\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m5569d2 = {"Landroidx/privacysandbox/ads/adservices/internal/BackCompatManager;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/content/Context;", "context", "", "tag", "Lkotlin/Function1;", "manager", "getManager", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ads-adservices_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class BackCompatManager {

    @NotNull
    public static final BackCompatManager INSTANCE = new Object();

    @Nullable
    public final <T> T getManager(@NotNull Context context, @NotNull String tag, @NotNull Function1<? super Context, ? extends T> manager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(manager, "manager");
        try {
            return manager.invoke(context);
        } catch (NoClassDefFoundError unused) {
            Log.d(tag, "Unable to find adservices code, check manifest for uses-library tag, versionS=" + AdServicesInfo.INSTANCE.extServicesVersionS());
            return null;
        }
    }
}
