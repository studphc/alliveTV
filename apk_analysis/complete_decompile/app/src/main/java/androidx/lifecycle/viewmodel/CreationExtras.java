package androidx.lifecycle.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H¦\u0002¢\u0006\u0004\b\u0007\u0010\bR,\u0010\u000e\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, m5569d2 = {"Landroidx/lifecycle/viewmodel/CreationExtras;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "key", "get", "(Landroidx/lifecycle/viewmodel/CreationExtras$Key;)Ljava/lang/Object;", "", "a", "Ljava/util/Map;", "getMap$lifecycle_viewmodel_release", "()Ljava/util/Map;", "map", "Empty", "Key", "lifecycle-viewmodel_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public abstract class CreationExtras {

    /* renamed from: a */
    public final LinkedHashMap f6595a = new LinkedHashMap();

    @Metadata(m5568d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001J&\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Landroidx/lifecycle/viewmodel/CreationExtras$Empty;", "Landroidx/lifecycle/viewmodel/CreationExtras;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "key", "get", "(Landroidx/lifecycle/viewmodel/CreationExtras$Key;)Ljava/lang/Object;", "lifecycle-viewmodel_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Empty extends CreationExtras {

        @NotNull
        public static final Empty INSTANCE = new CreationExtras();

        @Override // androidx.lifecycle.viewmodel.CreationExtras
        @Nullable
        public <T> T get(@NotNull Key<T> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return null;
        }
    }

    @Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, m5569d2 = {"Landroidx/lifecycle/viewmodel/CreationExtras$Key;", ExifInterface.GPS_DIRECTION_TRUE, "", "lifecycle-viewmodel_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public interface Key<T> {
    }

    @Nullable
    public abstract <T> T get(@NotNull Key<T> key);

    @NotNull
    public final Map<Key<?>, Object> getMap$lifecycle_viewmodel_release() {
        return this.f6595a;
    }
}
