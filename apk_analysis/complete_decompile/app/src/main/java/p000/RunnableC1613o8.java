package p000;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.AppLocalesStorageHelper;
import androidx.profileinstaller.ProfileInstaller;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: o8 */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC1613o8 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f23658a;

    /* renamed from: b */
    public final /* synthetic */ Context f23659b;

    public /* synthetic */ RunnableC1613o8(Context context, int i) {
        this.f23658a = i;
        this.f23659b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f23659b;
        switch (this.f23658a) {
            case 0:
                if (Build.VERSION.SDK_INT >= 33) {
                    ExecutorC1752r8 executorC1752r8 = AppCompatDelegate.f594a;
                    ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
                    if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                        if (AppCompatDelegate.getApplicationLocales().isEmpty()) {
                            String readLocales = AppLocalesStorageHelper.readLocales(context);
                            Object systemService = context.getSystemService("locale");
                            if (systemService != null) {
                                AbstractC1715q8.m7005b(systemService, AbstractC1678p8.m6886a(readLocales));
                            }
                        }
                        context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                    }
                }
                AppCompatDelegate.f599f = true;
                return;
            case 1:
                AppCompatDelegate.m162e(context);
                return;
            case 2:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new RunnableC1613o8(context, 3));
                return;
            default:
                ProfileInstaller.writeProfile(context);
                return;
        }
    }
}
