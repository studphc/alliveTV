package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(api = 28)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class CoreComponentFactory extends android.app.AppComponentFactory {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public interface CompatWrapped {
        Object getWrapper();
    }

    /* renamed from: a */
    public static Object m688a(Object obj) {
        Object wrapper;
        if ((obj instanceof CompatWrapped) && (wrapper = ((CompatWrapped) obj).getWrapper()) != null) {
            return wrapper;
        }
        return obj;
    }

    @NonNull
    public Activity instantiateActivity(@NonNull ClassLoader classLoader, @NonNull String str, @Nullable Intent intent) {
        return (Activity) m688a(super.instantiateActivity(classLoader, str, intent));
    }

    @NonNull
    public Application instantiateApplication(@NonNull ClassLoader classLoader, @NonNull String str) {
        return (Application) m688a(super.instantiateApplication(classLoader, str));
    }

    @NonNull
    public ContentProvider instantiateProvider(@NonNull ClassLoader classLoader, @NonNull String str) {
        return (ContentProvider) m688a(super.instantiateProvider(classLoader, str));
    }

    @NonNull
    public BroadcastReceiver instantiateReceiver(@NonNull ClassLoader classLoader, @NonNull String str, @Nullable Intent intent) {
        return (BroadcastReceiver) m688a(super.instantiateReceiver(classLoader, str, intent));
    }

    @NonNull
    public Service instantiateService(@NonNull ClassLoader classLoader, @NonNull String str, @Nullable Intent intent) {
        return (Service) m688a(super.instantiateService(classLoader, str, intent));
    }
}
