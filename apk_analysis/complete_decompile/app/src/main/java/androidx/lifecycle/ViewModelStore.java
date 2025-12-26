package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.io.Closeable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0003¨\u0006\u0011"}, m5569d2 = {"Landroidx/lifecycle/ViewModelStore;", "", "<init>", "()V", "", "key", "Landroidx/lifecycle/ViewModel;", "viewModel", "", "put", "(Ljava/lang/String;Landroidx/lifecycle/ViewModel;)V", "get", "(Ljava/lang/String;)Landroidx/lifecycle/ViewModel;", "", "keys", "()Ljava/util/Set;", "clear", "lifecycle-viewmodel_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public class ViewModelStore {

    /* renamed from: a */
    public final LinkedHashMap f6578a = new LinkedHashMap();

    public final void clear() {
        for (ViewModel viewModel : this.f6578a.values()) {
            viewModel.f6565c = true;
            HashMap hashMap = viewModel.f6563a;
            if (hashMap != null) {
                synchronized (hashMap) {
                    try {
                        Iterator it = viewModel.f6563a.values().iterator();
                        while (it.hasNext()) {
                            ViewModel.m1537a(it.next());
                        }
                    } finally {
                    }
                }
            }
            LinkedHashSet linkedHashSet = viewModel.f6564b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        Iterator it2 = viewModel.f6564b.iterator();
                        while (it2.hasNext()) {
                            ViewModel.m1537a((Closeable) it2.next());
                        }
                    } finally {
                    }
                }
            }
            viewModel.onCleared();
        }
        this.f6578a.clear();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public final ViewModel get(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (ViewModel) this.f6578a.get(key);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final Set<String> keys() {
        return new HashSet(this.f6578a.keySet());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void put(@NotNull String key, @NotNull ViewModel viewModel) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        ViewModel viewModel2 = (ViewModel) this.f6578a.put(key, viewModel);
        if (viewModel2 != null) {
            viewModel2.onCleared();
        }
    }
}
