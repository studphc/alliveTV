package androidx.activity.contextaware;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0003¨\u0006\u0011"}, m5569d2 = {"Landroidx/activity/contextaware/ContextAwareHelper;", "", "<init>", "()V", "Landroid/content/Context;", "peekAvailableContext", "()Landroid/content/Context;", "Landroidx/activity/contextaware/OnContextAvailableListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "addOnContextAvailableListener", "(Landroidx/activity/contextaware/OnContextAvailableListener;)V", "removeOnContextAvailableListener", "context", "dispatchOnContextAvailable", "(Landroid/content/Context;)V", "clearAvailableContext", "activity_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class ContextAwareHelper {

    /* renamed from: a */
    public final CopyOnWriteArraySet f527a = new CopyOnWriteArraySet();

    /* renamed from: b */
    public volatile Context f528b;

    public final void addOnContextAvailableListener(@NotNull OnContextAvailableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Context context = this.f528b;
        if (context != null) {
            listener.onContextAvailable(context);
        }
        this.f527a.add(listener);
    }

    public final void clearAvailableContext() {
        this.f528b = null;
    }

    public final void dispatchOnContextAvailable(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f528b = context;
        Iterator it = this.f527a.iterator();
        while (it.hasNext()) {
            ((OnContextAvailableListener) it.next()).onContextAvailable(context);
        }
    }

    @Nullable
    /* renamed from: peekAvailableContext, reason: from getter */
    public final Context getF528b() {
        return this.f528b;
    }

    public final void removeOnContextAvailableListener(@NotNull OnContextAvailableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f527a.remove(listener);
    }
}
