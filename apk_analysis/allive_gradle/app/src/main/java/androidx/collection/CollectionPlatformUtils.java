package androidx.collection;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003H\u0080\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, m5569d2 = {"Landroidx/collection/CollectionPlatformUtils;", "", "Ljava/lang/IndexOutOfBoundsException;", "Lkotlin/IndexOutOfBoundsException;", "createIndexOutOfBoundsException$collection", "()Ljava/lang/IndexOutOfBoundsException;", "createIndexOutOfBoundsException", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class CollectionPlatformUtils {

    @NotNull
    public static final CollectionPlatformUtils INSTANCE = new Object();

    @NotNull
    public final IndexOutOfBoundsException createIndexOutOfBoundsException$collection() {
        return new ArrayIndexOutOfBoundsException();
    }
}
